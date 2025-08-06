/*
 *  Copyright (c) 2025, WSO2 LLC. (https://www.wso2.com).
 *
 *  WSO2 LLC. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

package org.wso2.carbon.twitter.connector;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.synapse.MessageContext;
import org.wso2.integration.connector.core.AbstractConnector;
import org.wso2.integration.connector.core.ConnectException;
import org.wso2.integration.connector.core.authentication.Token;
import org.wso2.integration.connector.core.authentication.TokenManager;
import org.wso2.integration.connector.core.util.ConnectorUtils;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class OAuthAccessTokenHandler extends AbstractConnector {

    @Override
    public void connect(MessageContext messageContext) throws ConnectException {
        String connectionName = (String) ConnectorUtils.lookupTemplateParamater(messageContext, "connectionName");
        String clientId = (String) getParameter(messageContext, "clientId");
        String clientSecret = (String) getParameter(messageContext, "clientSecret");
        String refreshToken = (String) getParameter(messageContext, "refreshToken");
        String accessToken = (String) getParameter(messageContext, "accessToken");
        String apiUrl = (String) getParameter(messageContext, "apiUrl");

        // Default to Twitter API URL if not specified
        if (StringUtils.isBlank(apiUrl)) {
            apiUrl = "https://api.twitter.com";
        }

        // Check for refresh token first - needed for token refresh
        if (StringUtils.isBlank(refreshToken) || StringUtils.isBlank(clientId) || StringUtils.isBlank(clientSecret)) {
            // If access token is provided but no refresh credentials, just use it directly
            if (StringUtils.isNotBlank(accessToken)) {
                messageContext.setProperty("uri.var.accessToken", accessToken);
                messageContext.setProperty("_OH_INTERNAL_ACCESS_TOKEN_", accessToken);
                return;
            }
            handleException("Mandatory OAuth parameters missing: refreshToken, clientId, and clientSecret are required for token refresh.", messageContext);
        }

        // Build token URL and parameters for refresh
        String tokenUrl = apiUrl + "/2/oauth2/token";
        Map<String, String> payloadParameters = new HashMap<>();
        payloadParameters.put("refresh_token", refreshToken);
        payloadParameters.put("client_id", clientId);
        payloadParameters.put("grant_type", "refresh_token");
        
        String tokenKey = getTokenKey(connectionName, payloadParameters);
        Token token = TokenManager.getToken(tokenKey);
        
        // If we have a cached token and it's active, use it
        if (token != null && token.isActive()) {
            messageContext.setProperty("uri.var.accessToken", token.getAccessToken());
            messageContext.setProperty("_OH_INTERNAL_ACCESS_TOKEN_", token.getAccessToken());
            return;
        }
        
        // If cached token is expired, remove it
        if (token != null && !token.isActive()) {
            TokenManager.removeToken(tokenKey);
        }
        
        // Always fetch a fresh token (either no cached token or expired token)
        token = fetchAndStoreNewToken(tokenKey, messageContext, payloadParameters, tokenUrl, clientSecret);
        messageContext.setProperty("uri.var.accessToken", token.getAccessToken());
        messageContext.setProperty("_OH_INTERNAL_ACCESS_TOKEN_", token.getAccessToken());
    }

    private synchronized Token fetchAndStoreNewToken(String tokenKey, MessageContext messageContext,
                                                     Map<String, String> payloadParameters, String tokenUrl, String clientSecret) {
        Token token = fetchAccessToken(messageContext, payloadParameters, tokenUrl, clientSecret);
        TokenManager.addToken(tokenKey, token);
        return token;
    }

    private Token fetchAccessToken(MessageContext messageContext, Map<String, String> payloadParameters,
                                   String tokenUrl, String clientSecret) {

        long currentTime = System.currentTimeMillis();
        
        try {
            HttpPost postRequest = new HttpPost(tokenUrl);
            postRequest.setHeader("Content-Type", "application/x-www-form-urlencoded");
            
            // Twitter requires Basic authentication for refresh token requests
            // Use client_id:client_secret format as required by Twitter OAuth 2.0
            String clientIdParam = payloadParameters.get("client_id");
            
            if (StringUtils.isNotBlank(clientIdParam) && StringUtils.isNotBlank(clientSecret)) {
                // Create Basic auth header: Base64(client_id:client_secret) 
                String authString = clientIdParam + ":" + clientSecret;
                String credentials = java.util.Base64.getEncoder().encodeToString(authString.getBytes("UTF-8"));
                postRequest.setHeader("Authorization", "Basic " + credentials);
            } else {
                handleException("Missing clientId or clientSecret for OAuth token refresh", messageContext);
                return null;
            }
            
            // Build form data for request body
            StringBuilder formData = new StringBuilder();
            for (Map.Entry<String, String> entry : payloadParameters.entrySet()) {
                if (formData.length() > 0) {
                    formData.append("&");
                }
                formData.append(entry.getKey()).append("=").append(java.net.URLEncoder.encode(entry.getValue(), "UTF-8"));
            }
            
            // Set request body
            StringEntity requestEntity = new StringEntity(formData.toString());
            postRequest.setEntity(requestEntity);

            try (CloseableHttpClient httpClient = HttpClients.createDefault();
                 CloseableHttpResponse response = httpClient.execute(postRequest)) {

                HttpEntity entity = response.getEntity();
                if (entity == null) {
                    handleException("Empty response received from token endpoint.", messageContext);
                }

                int statusCode = response.getStatusLine().getStatusCode();
                String responseBody = entity != null ? EntityUtils.toString(entity) : "";

                if (statusCode == HttpURLConnection.HTTP_OK) {
                    JsonObject json = JsonParser.parseString(responseBody).getAsJsonObject();
                    String accessToken = json.get("access_token").getAsString();
                    long expiresIn = json.has("expires_in") ? json.get("expires_in").getAsLong() * 1000 : 3600000; // default 1h
                    return new Token(accessToken, currentTime, expiresIn);
                } else {
                    handleException("Failed to retrieve access token. Status: " + statusCode + ", Response: " + responseBody, messageContext);
                }
            }
        } catch (IOException e) {
            handleException("I/O error while retrieving access token: " + e.getMessage(), messageContext);
        } catch (Exception e) {
            handleException("Error while retrieving access token: " + e.getMessage(), messageContext);
        }
        return null;
    }

    private String getTokenKey(String connectionName, Map<String, String> params) {
        return connectionName + "_" + Objects.hash(params);
    }
}
