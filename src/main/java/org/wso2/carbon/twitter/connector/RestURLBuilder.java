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

import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.utils.URIBuilder;
import org.apache.synapse.MessageContext;
import org.wso2.integration.connector.core.AbstractConnector;
import org.wso2.integration.connector.core.ConnectException;
import org.wso2.integration.connector.core.util.ConnectorUtils;

import java.net.URISyntaxException;

/**
 * RestURLBuilder class handles building REST API URLs for Twitter operations.
 * It constructs the endpoint URL with path parameters and query parameters.
 */
public class RestURLBuilder extends AbstractConnector {

    private String endpointPath;
    private String pathParams;
    private String queryParams;

    @Override
    public void connect(MessageContext messageContext) throws ConnectException {
        // Get base API URL
        String apiUrl = (String) ConnectorUtils.lookupTemplateParamater(messageContext, "apiUrl");
        if (StringUtils.isBlank(apiUrl)) {
            apiUrl = "https://api.twitter.com";
        }
        
        // Use instance variables if set, otherwise try to get from parameters
        String currentEndpointPath = this.endpointPath;
        if (StringUtils.isBlank(currentEndpointPath)) {
            currentEndpointPath = (String) getParameter(messageContext, "endpointPath");
        }
        if (StringUtils.isBlank(currentEndpointPath)) {
            handleException("endpointPath parameter is required", messageContext);
            return;
        }
        
        // Get path parameters (comma-separated list)
        String currentPathParams = this.pathParams;
        if (StringUtils.isBlank(currentPathParams)) {
            currentPathParams = (String) getParameter(messageContext, "pathParams");
        }
        
        // Get query parameters (comma-separated list of param names)
        String queryParamNames = this.queryParams;
        if (StringUtils.isBlank(queryParamNames)) {
            queryParamNames = (String) getParameter(messageContext, "queryParams");
        }
        
        try {
            // Build the base URL with path
            String fullPath = buildPathWithParams(currentEndpointPath, currentPathParams, messageContext);
            URIBuilder uriBuilder = new URIBuilder(apiUrl + fullPath);
            
            // Add query parameters
            if (StringUtils.isNotBlank(queryParamNames)) {
                addQueryParameters(uriBuilder, queryParamNames, messageContext);
            }
            
            String finalUrl = uriBuilder.toString();
            messageContext.setProperty("uri.var.callEndpointUri", finalUrl);
            
        } catch (URISyntaxException e) {
            handleException("Error building URL: " + e.getMessage(), messageContext);
        }
    }
    
    /**
     * Builds the path with path parameters substituted
     */
    private String buildPathWithParams(String endpointPath, String pathParams, MessageContext messageContext) {
        String path = endpointPath;
        
        if (StringUtils.isNotBlank(pathParams)) {
            String[] paramNames = pathParams.split(",");
            for (String paramName : paramNames) {
                paramName = paramName.trim();
                String paramValue = (String) messageContext.getProperty("uri.var." + paramName);
                if (StringUtils.isNotBlank(paramValue)) {
                    path = path.replace("{" + paramName + "}", paramValue);
                }
            }
        }
        
        return path;
    }
    
    /**
     * Adds query parameters to the URI builder
     */
    private void addQueryParameters(URIBuilder uriBuilder, String queryParamNames, MessageContext messageContext) {
        String[] paramNames = queryParamNames.split(",");
        
        for (String paramName : paramNames) {
            paramName = paramName.trim();
            String paramValue = (String) messageContext.getProperty("uri.var." + paramName);
            
            if (StringUtils.isNotBlank(paramValue)) {
                // Handle special field parameter naming conventions for Twitter API
                String queryParamName = getTwitterQueryParamName(paramName);
                uriBuilder.addParameter(queryParamName, paramValue);
            }
        }
    }
    
    /**
     * Maps internal parameter names to Twitter API query parameter names
     */
    private String getTwitterQueryParamName(String paramName) {
        switch (paramName) {
            case "tweet_fields":
                return "tweet.fields";
            case "user_fields":
                return "user.fields";
            case "media_fields":
                return "media.fields";
            case "place_fields":
                return "place.fields";
            case "poll_fields":
                return "poll.fields";
            case "list_fields":
                return "list.fields";
            default:
                return paramName;
        }
    }
    
    // Setter methods for properties used in XML templates
    public void setEndpointPath(String endpointPath) {
        this.endpointPath = endpointPath;
    }
    
    public void setPathParams(String pathParams) {
        this.pathParams = pathParams;
    }
    
    public void setQueryParams(String queryParams) {
        this.queryParams = queryParams;
    }
}