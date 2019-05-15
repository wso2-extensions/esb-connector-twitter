/*
 *  Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.connector.integration.test.twitter;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.wso2.connector.integration.test.base.ConnectorIntegrationTestBase;
import org.wso2.connector.integration.test.base.RestResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * Integration test for Twitter connector.
 */
public class TwitterConnectorIntegrationTest extends ConnectorIntegrationTestBase {

    private Map<String, String> eiRequestHeadersMap = new HashMap<String, String>();

    /**
     * Environment setup for Twitter Connector.
     */
    @BeforeClass(alwaysRun = true)
    public void setEnvironment() throws Exception {

        String connectorName = System.getProperty("connector_name") + "-connector-" +
                System.getProperty("connector_version") + ".zip";
        init(connectorName);
        eiRequestHeadersMap.put("Accept-Charset", "UTF-8");
        eiRequestHeadersMap.put("Content-Type", "application/json");

        getApiConfigProperties();
        connectorProperties.getProperty("consumerKey");
        connectorProperties.getProperty("consumerSecret");
        connectorProperties.getProperty("accessToken");
        connectorProperties.getProperty("accessTokenSecret");
        connectorProperties.getProperty("apiUrl");

        connectorProperties.setProperty("status",
                System.currentTimeMillis() + connectorProperties.getProperty("status"));
        connectorProperties.setProperty("query",
                System.currentTimeMillis() + connectorProperties.getProperty("query"));
    }

    /**
     * Positive test case for getAccountSettings method with mandatory parameters.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getAccountSettings} integration test with " +
            "mandatory parameters.")
    public void getAccountSettingsWithMandatoryParameters() throws Exception {

        String methodName = "getAccountSettings";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getAccountSettings_mandatory.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(esbRestResponse.getBody().has("time_zone"));
    }

    /**
     * Negative test case for getAccountSettings method.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getAccountSettings} negative integration test.")
    public void getAccountSettingsNegative() throws Exception {

        String methodName = "getAccountSettings";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getAccountSettings_negative.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 400);
        Assert.assertTrue(esbRestResponse.getBody().has("errors"));
    }

    /**
     * Positive test case for getAccountVerifyCredentials method with mandatory parameters.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getAccountVerifyCredentials} integration test with " +
            "mandatory parameters.")
    public void getAccountVerifyCredentialsWithMandatoryParameters() throws Exception {

        String methodName = "getAccountVerifyCredentials";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getAccountVerifyCredentials_mandatory.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(esbRestResponse.getBody().has("id"));
    }

    /**
     * Positive test case for getAccountVerifyCredentials method with optional parameters.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getAccountVerifyCredentials} integration test with " +
            "optional parameters.")
    public void getAccountVerifyCredentialsWithOptionalParameters() throws Exception {

        String methodName = "getAccountVerifyCredentials";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getAccountVerifyCredentials_optional.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(esbRestResponse.getBody().has("id"));
    }

    /**
     * Negative test case for getAccountVerifyCredentials method.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getAccountVerifyCredentials} negative integration test.")
    public void getAccountVerifyCredentialsNegative() throws Exception {

        String methodName = "getAccountSettings";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getAccountVerifyCredentials_negative.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 400);
        Assert.assertTrue(esbRestResponse.getBody().has("errors"));
    }

    /**
     * Positive test case for setAccount method with mandatory parameters.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {setAccount} integration test with mandatory parameters.")
    public void setAccountWithMandatoryParameters() throws Exception {

        String methodName = "setAccount";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_setAccount_mandatory.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(esbRestResponse.getBody().has("time_zone"));
    }

    /**
     * Positive test case for setAccount method with optional parameters.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getAccountVerifyCredentials} integration test with " +
            "optional parameters.")
    public void setAccountWithOptionalParameters() throws Exception {

        String methodName = "setAccount";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_setAccount_optional.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(esbRestResponse.getBody().has("time_zone"));
    }

    /**
     * Negative test case for setAccount method.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {setAccount} negative integration test.")
    public void setAccountNegative() throws Exception {

        String methodName = "setAccount";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_setAccount_negative.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 400);
        Assert.assertTrue(esbRestResponse.getBody().has("errors"));
    }

    /**
     * Positive test case for blockUser method with mandatory parameters.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {blockUser} integration test with mandatory parameters.")
    public void blockUserWithMandatoryParameters() throws Exception {

        String methodName = "blockUser";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_blockUser_mandatory.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(esbRestResponse.getBody().has("id"));
    }

    /**
     * Positive test case for blockUser method with optional parameters.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {blockUser} integration test with optional parameters.")
    public void blockUserWithOptionalParameters() throws Exception {

        String methodName = "blockUser";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_blockUser_optional.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(esbRestResponse.getBody().has("id"));
    }

    /**
     * Negative test case for blockUser method.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {blockUser} negative integration test.")
    public void blockUserNegative() throws Exception {

        String methodName = "blockUser";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_blockUser_negative.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 400);
        Assert.assertTrue(esbRestResponse.getBody().has("errors"));
    }

    /**
     * Positive test case for destroyBlock method with mandatory parameters.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {destroyBlock} integration test with mandatory parameters.")
    public void destroyBlockMandatoryParameters() throws Exception {

        String methodName = "destroyBlock";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_destroyBlock_mandatory.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(esbRestResponse.getBody().has("id"));
    }

    /**
     * Positive test case for destroyBlock method with optional parameters.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {destroyBlock} integration test with optional parameters.")
    public void destroyBlockWithOptionalParameters() throws Exception {

        String methodName = "destroyBlock";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_destroyBlock_optional.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(esbRestResponse.getBody().has("id"));
    }

    /**
     * Negative test case for destroyBlock method.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {destroyBlock} negative integration test.")
    public void destroyBlockNegative() throws Exception {

        String methodName = "destroyBlock";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_destroyBlock_negative.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 400);
        Assert.assertTrue(esbRestResponse.getBody().has("errors"));
    }

    /**
     * Positive test case for getBlockIds method with mandatory parameters.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getBlockIds} integration test with mandatory parameters.")
    public void getBlockIdsMandatoryParameters() throws Exception {

        String methodName = "getBlockIds";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getBlockIds_mandatory.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(esbRestResponse.getBody().has("previous_cursor"));
    }

    /**
     * Negative test case for getBlockIds method.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getBlockIds} negative integration test.")
    public void getBlockIdsNegative() throws Exception {

        String methodName = "getBlockIds";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getBlockIds_negative.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 400);
        Assert.assertTrue(esbRestResponse.getBody().has("errors"));
    }

    /**
     * Positive test case for getBlocksList method with mandatory parameters.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getBlocksList} integration test with mandatory parameters.")
    public void getBlocksListMandatoryParameters() throws Exception {

        String methodName = "getBlocksList";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getBlocksList_mandatory.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(esbRestResponse.getBody().has("previous_cursor"));
    }

    /**
     * Positive test case for getBlocksList method with optional parameters.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getBlocksList} integration test with optional parameters.")
    public void getBlocksListOptionalParameters() throws Exception {

        String methodName = "getBlocksList";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getBlocksList_optional.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(esbRestResponse.getBody().has("previous_cursor"));
    }

    /**
     * Negative test case for getBlocksList method.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getBlocksList} negative integration test.")
    public void getBlocksListNegative() throws Exception {

        String methodName = "getBlocksList";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getBlocksList_negative.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 400);
        Assert.assertTrue(esbRestResponse.getBody().has("errors"));
    }

    /**
     * Positive test case for getStatusesHomeTimeline method with mandatory parameters.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getStatusesHomeTimeline} integration test with" +
            " mandatory parameters.")
    public void getStatusesHomeTimelineMandatoryParameters() throws Exception {

        String methodName = "getStatusesHomeTimeline";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getStatusesHomeTimeline_mandatory.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(esbRestResponse.getBody().has("output"));
    }

    /**
     * Positive test case for getStatusesHomeTimeline method with optional parameters.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getStatusesHomeTimeline} integration test with optional parameters.")
    public void getStatusesHomeTimelineOptionalParameters() throws Exception {

        String methodName = "getStatusesHomeTimeline";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getStatusesHomeTimeline_optional.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(esbRestResponse.getBody().has("output"));
    }

    /**
     * Negative test case for getStatusesHomeTimeline method.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getStatusesHomeTimeline} negative integration test.")
    public void getStatusesHomeTimelineNegative() throws Exception {

        String methodName = "getStatusesHomeTimeline";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getStatusesHomeTimeline_negative.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 400);
        Assert.assertTrue(esbRestResponse.getBody().has("errors"));
    }

    /**
     * Positive test case for getStatusesLookup method with mandatory parameters.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getStatusesHomeTimeline} integration test with mandatory parameters.")
    public void getStatusesLookupMandatoryParameters() throws Exception {

        String methodName = "getStatusesLookup";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getStatusesLookup_mandatory.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(esbRestResponse.getBody().has("id"));
    }

    /**
     * Positive test case for getStatusesLookup method with optional parameters.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getStatusesHomeTimeline} integration test with optional parameters.")
    public void getStatusesLookupOptionalParameters() throws Exception {

        String methodName = "getStatusesLookup";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getStatusesLookup_optional.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(esbRestResponse.getBody().has("id"));
    }

    /**
     * Negative test case for getStatusesLookup method.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getStatusesLookup} negative integration test.")
    public void getStatusesLookupNegative() throws Exception {

        String methodName = "getStatusesLookup";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getStatusesLookup_negative.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 400);
        Assert.assertTrue(esbRestResponse.getBody().has("errors"));
    }

    /**
     * Positive test case for getStatusesMentionsTimeline method with mandatory parameters.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getStatusesMentionsTimeline} integration test with " +
            "mandatory parameters.")
    public void getStatusesMentionsTimelineMandatoryParameters() throws Exception {

        String methodName = "getStatusesMentionsTimeline";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getStatusesMentionsTimeline_mandatory.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(esbRestResponse.getBody().has("output"));
    }

    /**
     * Positive test case for getStatusesMentionsTimeline method with optional parameters.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getStatusesMentionsTimeline} integration test with " +
            "optional parameters.")
    public void getStatusesMentionsTimelineOptionalParameters() throws Exception {

        String methodName = "getStatusesMentionsTimeline";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getStatusesMentionsTimeline_optional.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(esbRestResponse.getBody().has("output"));
    }

    /**
     * Negative test case for getStatusesMentionsTimeline method.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getStatusesMentionsTimeline} negative integration test.")
    public void getStatusesMentionsTimelineNegative() throws Exception {

        String methodName = "getStatusesMentionsTimeline";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getStatusesMentionsTimeline_negative.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 400);
        Assert.assertTrue(esbRestResponse.getBody().has("errors"));
    }

    /**
     * Positive test case for getStatusesRetweetsOfMe method with mandatory parameters.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getStatusesRetweetsOfMe} integration test with " +
            "mandatory parameters.")
    public void getStatusesRetweetsOfMeMandatoryParameters() throws Exception {

        String methodName = "getStatusesRetweetsOfMe";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getStatusesRetweetsOfMe_mandatory.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(esbRestResponse.getBody().has("output"));
    }

    /**
     * Positive test case for getStatusesRetweetsOfMe method with optional parameters.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getStatusesRetweetsOfMe} integration test with " +
            "optional parameters.")
    public void getStatusesRetweetsOfMeOptionalParameters() throws Exception {

        String methodName = "getStatusesRetweetsOfMe";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getStatusesRetweetsOfMe_optional.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(esbRestResponse.getBody().has("output"));
    }

    /**
     * Negative test case for getStatusesRetweetsOfMe method.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getStatusesRetweetsOfMe} negative integration test.")
    public void getStatusesRetweetsOfMeNegative() throws Exception {

        String methodName = "getStatusesRetweetsOfMe";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getStatusesRetweetsOfMe_negative.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 400);
        Assert.assertTrue(esbRestResponse.getBody().has("errors"));
    }

    /**
     * Positive test case for getStatusesUserTimeline method with mandatory parameters.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getStatusesUserTimeline} integration test with " +
            "mandatory parameters.")
    public void getStatusesUserTimelineMandatoryParameters() throws Exception {

        String methodName = "getStatusesUserTimeline";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getStatusesUserTimeline_mandatory.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(esbRestResponse.getBody().has("output"));
    }

    /**
     * Positive test case for getStatusesUserTimeline method with optional parameters.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getStatusesUserTimeline} integration test with " +
            "optional parameters.")
    public void getStatusesUserTimelineOptionalParameters() throws Exception {

        String methodName = "getStatusesUserTimeline";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getStatusesUserTimeline_optional.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(esbRestResponse.getBody().has("output"));
    }

    /**
     * Negative test case for getStatusesUserTimeline method.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getStatusesUserTimeline} negative integration test.")
    public void getStatusesUserTimelineNegative() throws Exception {

        String methodName = "getStatusesUserTimeline";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getStatusesUserTimeline_negative.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 400);
        Assert.assertTrue(esbRestResponse.getBody().has("errors"));
    }

    /**
     * Positive test case for updateStatus method with mandatory parameters.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {updateStatus} integration test with mandatory parameters.")
    public void updateStatusMandatoryParameters() throws Exception {

        String methodName = "updateStatus";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_updateStatus_mandatory.json");
        String sId = esbRestResponse.getBody().getString("id");
        connectorProperties.setProperty("Id2", sId);
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(esbRestResponse.getBody().has("id"));
    }

    /**
     * Negative test case for updateStatus method.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {updateStatus} negative integration test.")
    public void updateStatusNegative() throws Exception {

        String methodName = "updateStatus";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_updateStatus_negative.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 400);
        Assert.assertTrue(esbRestResponse.getBody().has("errors"));
    }

    /**
     * Positive test case for retweet method with mandatory parameters.
     */
    @Test(groups = {"wso2.ei"}, dependsOnMethods = {"updateStatusMandatoryParameters"}, description =
            "twitter {retweet} integration test with mandatory parameters.")
    public void retweetWithMandatoryParameters() throws Exception {

        String methodName = "retweet";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_retweet_mandatory.json");
        String sId = esbRestResponse.getBody().getString("id");
        connectorProperties.setProperty("Id3", sId);
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(esbRestResponse.getBody().has("text"));
    }

    /**
     * Negative test case for retweet method.
     */
    @Test(groups = {"wso2.ei"}, dependsOnMethods = {"updateStatusMandatoryParameters"}, description =
            "twitter {retweet} negative integration test.")
    public void retweetNegative() throws Exception {

        String methodName = "retweet";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_retweet_negative.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 400);
        Assert.assertTrue(esbRestResponse.getBody().has("errors"));
    }

    /**
     * Positive test case for getStatusesRetweetsByld method with mandatory parameters.
     */
    @Test(groups = {"wso2.ei"}, dependsOnMethods = {"updateStatusMandatoryParameters"}, description =
            "twitter {getStatusesRetweetsById} integration test with mandatory parameters.")
    public void getStatusesRetweetsByIdMandatoryParameters() throws Exception {

        String methodName = "getStatusesRetweetsById";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getStatusesRetweetsById_mandatory.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
    }

    /**
     * Negative test case for getStatusesRetweetsByld method.
     */
    @Test(groups = {"wso2.ei"}, dependsOnMethods = {"updateStatusMandatoryParameters"}, description =
            "twitter {getStatusesRetweetsById} negative integration test.")
    public void getStatusesRetweetsByIdNegative() throws Exception {

        String methodName = "getStatusesRetweetsById";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getStatusesRetweetsById_negative.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 400);
        Assert.assertTrue(esbRestResponse.getBody().has("errors"));
    }

    /**
     * Positive test case for showStatusesById method with mandatory parameters.
     */
    @Test(groups = {"wso2.ei"}, dependsOnMethods = {"updateStatusMandatoryParameters"}, description =
            "twitter {showStatusesById} integration test with mandatory parameters.")
    public void showStatusesByIdMandatoryParameters() throws Exception {

        String methodName = "showStatusesById";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_showStatusesById_mandatory.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
    }

    /**
     * Negative test case for showStatusesById method.
     */
    @Test(groups = {"wso2.ei"}, dependsOnMethods = {"updateStatusMandatoryParameters"}, description =
            "twitter {showStatusesById} negative integration test.")
    public void showStatusesByIdNegative() throws Exception {

        String methodName = "showStatusesById";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_showStatusesById_negative.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 400);
        Assert.assertTrue(esbRestResponse.getBody().has("errors"));
    }

    /**
     * Positive test case for destroyStatusById method with mandatory parameters.
     */
    @Test(groups = {"wso2.ei"}, dependsOnMethods = {"retweetWithMandatoryParameters"}, description =
            "twitter {destroyStatusById} integration test with mandatory parameters.")
    public void destroyStatusByldWithMandatoryParameters() throws Exception {

        String methodName = "destroyStatusById";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_destroyStatusById_mandatory.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(esbRestResponse.getBody().has("id"));
    }

    /**
     * Negative test case for destroyStatusById method.
     */
    @Test(groups = {"wso2.ei"}, dependsOnMethods = {"retweetWithMandatoryParameters"}, description =
            "twitter {destroyStatusById} negative integration test.")
    public void destroyStatusByldNegative() throws Exception {

        String methodName = "destroyStatusById";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_destroyStatusById_negative.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 400);
        Assert.assertTrue(esbRestResponse.getBody().has("errors"));
    }

    /**
     * Positive test case for createSavedSearches method with mandatory parameters.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {createSavedSearches} integration test with mandatory parameters.")
    public void createSavedSearchesWithMandatoryParameters() throws Exception {

        String methodName = "createSavedSearches";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_createSavedSearches_mandatory.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(esbRestResponse.getBody().has("query"));
    }

    /**
     * Negative test case for createSavedSearches method.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {createSavedSearches} negative integration test.")
    public void createSavedSearchesNegative() throws Exception {

        String methodName = "createSavedSearches";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_createSavedSearches_negative.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 400);
        Assert.assertTrue(esbRestResponse.getBody().has("errors"));
    }

    /**
     * Positive test case for getSavedSearchesList method with mandatory parameters.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getSavedSearchesList} integration test with mandatory parameters.")
    public void getSavedSearchesListWithMandatoryParameters() throws Exception {

        String methodName = "getSavedSearchesList";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getSavedSearchesList_mandatory.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
    }

    /**
     * Negative test case for getSavedSearchesList method.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getSavedSearchesList} negative integration test.")
    public void getSavedSearchesListNegative() throws Exception {

        String methodName = "getSavedSearchesList";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getSavedSearchesList_negative.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 400);
        Assert.assertTrue(esbRestResponse.getBody().has("errors"));
    }

    /**
     * Positive test case for getUsersSearch method with mandatory parameters.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getUsersSearch} integration test with mandatory parameters.")
    public void getUsersSearchWithMandatoryParameters() throws Exception {

        String methodName = "getUsersSearch";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getUsersSearch_mandatory.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
    }

    /**
     * Positive test case for getUsersSearch method with optional parameters.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getUsersSearch} integration test with optional parameters.")
    public void getUsersSearchWithOptionalParameters() throws Exception {

        String methodName = "getUsersSearch";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getUsersSearch_optional.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
    }

    /**
     * Negative test case for getUsersSearch method.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getUsersSearch} negative integration test.")
    public void getUsersSearchNegative() throws Exception {

        String methodName = "getUsersSearch";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getUsersSearch_negative.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 400);
        Assert.assertTrue(esbRestResponse.getBody().has("errors"));
    }

    /**
     * Positive test case for getSearchTweets method with mandatory parameters.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getSearchTweets} integration test with mandatory parameters.")
    public void getSearchTweetsWithMandatoryParameters() throws Exception {

        String methodName = "getSearchTweets";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getSearchTweets_mandatory.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(esbRestResponse.getBody().has("statuses"));
    }

    /**
     * Negative test case for getSearchTweets method.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getSearchTweets} negative integration test.")
    public void getSearchTweetsNegative() throws Exception {

        String methodName = "getSearchTweets";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getSearchTweets_negative.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 400);
        Assert.assertTrue(esbRestResponse.getBody().has("errors"));
    }

    /**
     * Positive test case for getTrendsAvailable method with mandatory parameters.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getTrendsAvailable} integration test with mandatory parameters.")
    public void getTrendsAvailableWithMandatoryParameters() throws Exception {

        String methodName = "getTrendsAvailable";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getTrendsAvailable_mandatory.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
    }

    /**
     * Negative test case for getTrendsAvailable method.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getTrendsAvailable} negative integration test.")
    public void getTrendsAvailableNegative() throws Exception {

        String methodName = "getTrendsAvailable";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getTrendsAvailable_negative.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 400);
        Assert.assertTrue(esbRestResponse.getBody().has("errors"));
    }

    /**
     * Positive test case for getTrendsPlace method with mandatory parameters.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getTrendsPlace} integration test with mandatory parameters.")
    public void getTrendsPlaceWithMandatoryParameters() throws Exception {

        String methodName = "getTrendsPlace";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getTrendsPlace_mandatory.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
    }

    /**
     * Negative test case for getTrendsPlace method.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getTrendsPlace} negative integration test.")
    public void getTrendsPlaceNegative() throws Exception {

        String methodName = "getTrendsPlace";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getTrendsPlace_negative.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 400);
        Assert.assertTrue(esbRestResponse.getBody().has("errors"));
    }

    /**
     * Positive test case for getTrendsClosest method with mandatory parameters.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getTrendsClosest} integration test with mandatory parameters.")
    public void getTrendsClosestWithMandatoryParameters() throws Exception {

        String methodName = "getTrendsClosest";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getTrendsClosest_mandatory.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
    }

    /**
     * Negative test case for getTrendsClosest method.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getTrendsClosest} negative integration test.")
    public void getTrendsClosestNegative() throws Exception {

        String methodName = "getTrendsClosest";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getTrendsClosest_negative.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 400);
        Assert.assertTrue(esbRestResponse.getBody().has("errors"));
    }

    /**
     * Positive test case for sendNewDirectMessages method with mandatory parameters.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {sendNewDirectMessages} integration test with mandatory parameters.")
    public void sendNewDirectMessagesWithMandatoryParameters() throws Exception {

        String methodName = "sendNewDirectMessages";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_sendNewDirectMessages_mandatory.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(esbRestResponse.getBody().has("event"));
    }

    /**
     * Negative test case for sendNewDirectMessages method.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {sendNewDirectMessages} negative integration test..")
    public void sendNewDirectMessagesNegative() throws Exception {

        String methodName = "sendNewDirectMessages";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_sendNewDirectMessages_negative.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 400);
    }

    /**
     * Positive test case for getDirectMessages method with mandatory parameters.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getDirectMessages} integration test with mandatory parameters.")
    public void getDirectMessagesWithMandatoryParameters() throws Exception {

        String methodName = "getDirectMessages";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getDirectMessages_mandatory.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
    }

    /**
     * Positive test case for getDirectMessages method with optional parameters.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getDirectMessages} integration test with optional parameters.")
    public void getDirectMessagesWithOptionalParameters() throws Exception {

        String methodName = "getDirectMessages";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getDirectMessages_optional.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
    }

    /**
     * Negative test case for getDirectMessages method.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getDirectMessages} negative integration test.")
    public void getDirectMessagesNegative() throws Exception {

        String methodName = "getDirectMessages";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getDirectMessages_negative.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 400);
        Assert.assertTrue(esbRestResponse.getBody().has("errors"));
    }

    /**
     * Positive test case for createFavorites method with mandatory parameters.
     */
    @Test(groups = {"wso2.ei"}, dependsOnMethods = {"updateStatusMandatoryParameters"}, description =
            "twitter {createFavorites} integration test with mandatory parameters.")
    public void createFavoritesWithMandatoryParameters() throws Exception {

        String methodName = "createFavorites";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_createFavorites_mandatory.json");
        String sId = esbRestResponse.getBody().getString("id");
        connectorProperties.setProperty("Id2", sId);
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(esbRestResponse.getBody().has("id"));
    }

    /**
     * Negative test case for createFavorites method.
     */
    @Test(groups = {"wso2.ei"}, dependsOnMethods = {"updateStatusMandatoryParameters"}, description =
            "twitter {createFavorites} negative integration test.")
    public void createFavoritesNegative() throws Exception {

        String methodName = "createFavorites";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_createFavorites_negative.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 400);
        Assert.assertTrue(esbRestResponse.getBody().has("errors"));
    }

    /**
     * * Positive test case for getFavoritesList method with mandatory parameters.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getFavoritesList} integration test with mandatory parameters.")
    public void getFavoritesListWithMandatoryParameters() throws Exception {

        String methodName = "getFavoritesList";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getFavoritesList_mandatory.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
    }

    /**
     * Positive test case for getFavoritesList method with optional parameters.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getFavoritesList} integration test with optional parameters.")
    public void getFavoritesListWithOptionalParameters() throws Exception {

        String methodName = "getFavoritesList";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getFavoritesList_optional.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
    }

    /**
     * Negative test case for getFavoritesList method.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getFavoritesList} negative integration test.")
    public void getFavoritesListNegative() throws Exception {

        String methodName = "getFavoritesList";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getFavoritesList_negative.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 400);
        Assert.assertTrue(esbRestResponse.getBody().has("errors"));
    }

    /**
     * Positive test case for destroyFavorites method with mandatory parameters.
     */
    @Test(groups = {"wso2.ei"}, dependsOnMethods = {"createFavoritesWithMandatoryParameters"}, description =
            "twitter {destroyFavorites} integration test with mandatory parameters.")
    public void destroyFavoritesWithMandatoryParameters() throws Exception {

        String methodName = "destroyFavorites";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_destroyFavorites_mandatory.json");
        String sId = esbRestResponse.getBody().getString("id");
        connectorProperties.setProperty("Id2", sId);
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(esbRestResponse.getBody().has("id"));
    }

    /**
     * Negative test case for destroyFavorites method.
     */
    @Test(groups = {"wso2.ei"}, dependsOnMethods = {"updateStatusMandatoryParameters"}, description =
            "twitter {destroyFavorites} negative integration test.")
    public void destroyFavoritesNegative() throws Exception {

        String methodName = "destroyFavorites";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_destroyFavorites_negative.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 400);
        Assert.assertTrue(esbRestResponse.getBody().has("errors"));
    }

    /**
     * Positive test case for getApplicationRateLimitStatus method with mandatory parameters.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getApplicationRateLimitStatus} integration test with" +
            " mandatory parameters.")
    public void getApplicationRateLimitStatusWithMandatoryParameters() throws Exception {

        String methodName = "getApplicationRateLimitStatus";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getApplicationRateLimitStatus_mandatory.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(esbRestResponse.getBody().has("rate_limit_context"));
    }

    /**
     * Negative test case for getApplicationRateLimitStatus method.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getApplicationRateLimitStatus} negative integration test.")
    public void getApplicationRateLimitStatusNegative() throws Exception {

        String methodName = "getApplicationRateLimitStatus";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getApplicationRateLimitStatus_negative.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 400);
        Assert.assertTrue(esbRestResponse.getBody().has("errors"));
    }

    /**
     * Positive test case for getHelpConfiguration method with mandatory parameters.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getHelpConfiguration} integration test with mandatory parameters.")
    public void getHelpConfigurationWithMandatoryParameters() throws Exception {

        String methodName = "getHelpConfiguration";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getHelpConfiguration_mandatory.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(esbRestResponse.getBody().has("dm_text_character_limit"));
    }

    /**
     * Negative test case for getHelpConfiguration method.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getHelpConfiguration} negative integration test.")
    public void getHelpConfigurationNegative() throws Exception {

        String methodName = "getHelpConfiguration";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getHelpConfiguration_negative.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 400);
        Assert.assertTrue(esbRestResponse.getBody().has("errors"));
    }

    /**
     * Positive test case for getHelpLanguages method with mandatory parameters.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getHelpLanguages} integration test with mandatory parameters.")
    public void getHelpLanguagesWithMandatoryParameters() throws Exception {

        String methodName = "getHelpLanguages";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getHelpLanguages_mandatory.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
    }

    /**
     * Negative test case for getHelpLanguages method.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getHelpLanguages} negative integration test.")
    public void getHelpLanguagesNegative() throws Exception {

        String methodName = "getHelpLanguages";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getHelpLanguages_negative.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 400);
        Assert.assertTrue(esbRestResponse.getBody().has("errors"));
    }

    /**
     * Positive test case for getHelpPrivacy method with mandatory parameters.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getHelpPrivacy} integration test with mandatory parameters.")
    public void getHelpPrivacyWithMandatoryParameters() throws Exception {

        String methodName = "getHelpPrivacy";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getHelpPrivacy_mandatory.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(esbRestResponse.getBody().has("privacy"));
    }

    /**
     * Negative test case for getHelpPrivacy method.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getHelpPrivacy} negative integration test.")
    public void getHelpPrivacyNegative() throws Exception {

        String methodName = "getHelpPrivacy";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getHelpPrivacy_negative.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 400);
        Assert.assertTrue(esbRestResponse.getBody().has("errors"));
    }

    /**
     * Positive test case for getHelpTos method with mandatory parameters.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getHelpTos} integration test with mandatory parameters.")
    public void getHelpTosWithMandatoryParameters() throws Exception {

        String methodName = "getHelpTos";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getHelpTos_mandatory.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(esbRestResponse.getBody().has("tos"));
    }

    /**
     * Negative test case for getHelpTos method.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getHelpTos} negative integration test.")
    public void getHelpTosNegative() throws Exception {

        String methodName = "getHelpTos";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getHelpTos_negative.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 400);
        Assert.assertTrue(esbRestResponse.getBody().has("errors"));
    }

    /**
     * Positive test case for createLists method with mandatory parameters.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {createLists} integration test with mandatory parameters.")
    public void createListsWithMandatoryParameters() throws Exception {

        String methodName = "createLists";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_createLists_mandatory.json");
        String sId = esbRestResponse.getBody().getString("id");
        connectorProperties.setProperty("listId1", sId);
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(esbRestResponse.getBody().has("id"));
    }

    /**
     * Positive test case for createLists method with optional parameters.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {createLists} integration test with optional parameters.")
    public void createListsWithOptionalParameters() throws Exception {

        String methodName = "createLists";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_createLists_optional.json");
        String sId = esbRestResponse.getBody().getString("id");
        connectorProperties.setProperty("listId2", sId);
        String slug = esbRestResponse.getBody().getString("slug");
        connectorProperties.setProperty("Slug", slug);
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(esbRestResponse.getBody().has("id"));
    }

    /**
     * Negative test case for createLists method.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {optional} negative integration test.")
    public void createListsNegative() throws Exception {

        String methodName = "createLists";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_createLists_negative.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 400);
        Assert.assertTrue(esbRestResponse.getBody().has("errors"));
    }

    /**
     * Positive test case for getLists method with mandatory parameters.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getLists} integration test with mandatory parameters.")
    public void getListsWithMandatoryParameters() throws Exception {

        String methodName = "getLists";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getLists_mandatory.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
    }

    /**
     * Negative test case for getLists method.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getLists} negative integration test.")
    public void getListsNegative() throws Exception {

        String methodName = "getLists";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getLists_negative.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 400);
        Assert.assertTrue(esbRestResponse.getBody().has("errors"));
    }

    /**
     * Positive test case for updateLists method with mandatory parameters.
     */
    @Test(groups = {"wso2.ei"}, dependsOnMethods = {"createListsWithMandatoryParameters"}, description =
            "twitter {updateLists } integration test with mandatory parameters.")
    public void updateListsWithMandatoryParameters() throws Exception {

        String methodName = "updateLists";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_updateLists_mandatory.json");
        String sId = esbRestResponse.getBody().getString("id");
        connectorProperties.setProperty("listId2", sId);
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(esbRestResponse.getBody().has("id"));
    }

    /**
     * Negative test case for updateLists  method.
     */
    @Test(groups = {"wso2.ei"}, dependsOnMethods = {"createListsWithMandatoryParameters"}, description =
            "twitter {updateLists} negative integration test.")
    public void updateListsNegative() throws Exception {

        String methodName = "updateLists";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_updateLists_negative.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 400);
        Assert.assertTrue(esbRestResponse.getBody().has("errors"));
    }

    /**
     * Positive test case for destroyLists method with mandatory parameters.
     */
    @Test(groups = {"wso2.ei"}, dependsOnMethods = {"updateListsWithMandatoryParameters"}, description =
            "twitter {destroyLists} integration test with mandatory parameters.")
    public void destroyListsWithMandatoryParameters() throws Exception {

        String methodName = "destroyLists";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_destroyLists_mandatory.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(esbRestResponse.getBody().has("id"));
    }

    /**
     * Positive test case for destroyLists method with optional parameters.
     */
    @Test(groups = {"wso2.ei"}, dependsOnMethods = {"createListsWithOptionalParameters"}, description =
            "twitter {destroyLists} integration test with optional parameters.")
    public void destroyListsWithOptionalParameters() throws Exception {

        String methodName = "destroyLists";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_destroyLists_optional.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(esbRestResponse.getBody().has("id"));
    }

    /**
     * Negative test case for destroyLists  method.
     */
    @Test(groups = {"wso2.ei"}, dependsOnMethods = {"createListsWithMandatoryParameters"}, description =
            "twitter {destroyLists} negative integration test.")
    public void destroyListsNegative() throws Exception {

        String methodName = "destroyLists";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_destroyLists_negative.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 400);
        Assert.assertTrue(esbRestResponse.getBody().has("errors"));
    }

    /**
     * Positive test case for getListsMemberships method with mandatory parameters.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getListsMemberships} integration test with mandatory parameters.")
    public void getListsMembershipsWithMandatoryParameters() throws Exception {

        String methodName = "getListsMemberships";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getListsMemberships_mandatory.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(esbRestResponse.getBody().has("next_cursor"));
    }

    /**
     * Positive test case for getListsMemberships method with optional parameters.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getListsMemberships} integration test with optional parameters.")
    public void getListsMembershipsWithOptionalParameters() throws Exception {

        String methodName = "getListsMemberships";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getListsMemberships_optional.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(esbRestResponse.getBody().has("next_cursor"));
    }

    /**
     * Negative test case for getListsMemberships method.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getListsMemberships} negative integration test.")
    public void getListsMembershipsNegative() throws Exception {

        String methodName = "getListsMemberships";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getListsMemberships_negative.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 400);
        Assert.assertTrue(esbRestResponse.getBody().has("errors"));
    }

    /**
     * Positive test case for getListsOwnerships method with mandatory parameters.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getListsOwnerships} integration test with mandatory parameters.")
    public void getListsOwnershipsWithMandatoryParameters() throws Exception {

        String methodName = "getListsOwnerships";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getListsOwnerships_mandatory.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(esbRestResponse.getBody().has("next_cursor"));
    }

    /**
     * Negative test case for getListsOwnerships method.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getListsOwnerships} negative integration test.")
    public void getListsOwnershipsNegative() throws Exception {

        String methodName = "getListsOwnerships";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getListsOwnerships_negative.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 400);
        Assert.assertTrue(esbRestResponse.getBody().has("errors"));
    }

    /**
     * Positive test case for createMutesUsers method with mandatory parameters.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {createMutesUsers} integration test with mandatory parameters.")
    public void createMutesUsersWithMandatoryParameters() throws Exception {

        String methodName = "createMutesUsers";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_createMutesUsers_mandatory.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(esbRestResponse.getBody().has("id"));
    }

    /**
     * Negative test case for createMutesUsers method.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {createMutesUsers} negative integration test.")
    public void createMutesUsersNegative() throws Exception {

        String methodName = "createMutesUsers";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_createMutesUsers_negative.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 400);
        Assert.assertTrue(esbRestResponse.getBody().has("errors"));
    }

    /**
     * Positive test case for getMutesUsersIds method with mandatory parameters.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getMutesUsersIds} integration test with mandatory parameters.")
    public void getMutesUsersIdsWithMandatoryParameters() throws Exception {

        String methodName = "getMutesUsersIds";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getMutesUsersIds_mandatory.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(esbRestResponse.getBody().has("ids"));
    }

    /**
     * Negative test case for getMutesUsersIds method.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getMutesUsersIds} negative integration test.")
    public void getMutesUsersIdsNegative() throws Exception {

        String methodName = "getMutesUsersIds";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getMutesUsersIds_negative.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 400);
        Assert.assertTrue(esbRestResponse.getBody().has("errors"));
    }

    /**
     * Positive test case for getMutesUsersList method with mandatory parameters.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getMutesUsersList} integration test with mandatory parameters.")
    public void getMutesUsersListWithMandatoryParameters() throws Exception {

        String methodName = "getMutesUsersList";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getMutesUsersList_mandatory.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(esbRestResponse.getBody().has("users"));
    }

    /**
     * Positive test case for getMutesUsersList method with optional parameters.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getMutesUsersList} integration test with optional parameters.")
    public void getMutesUsersListWithOptionalParameters() throws Exception {

        String methodName = "getMutesUsersList";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getMutesUsersList_optional.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(esbRestResponse.getBody().has("users"));
    }

    /**
     * Negative test case for getMutesUsersList method.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getMutesUsersList} negative integration test.")
    public void getMutesUsersListNegative() throws Exception {

        String methodName = "getMutesUsersList";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getMutesUsersList_negative.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 400);
        Assert.assertTrue(esbRestResponse.getBody().has("errors"));
    }

    /**
     * Positive test case for destroyMutesUsers method with mandatory parameters.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {destroyMutesUsers} integration test with mandatory parameters.")
    public void destroyMutesUsersWithMandatoryParameters() throws Exception {

        String methodName = "destroyMutesUsers";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_destroyMutesUsers_mandatory.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(esbRestResponse.getBody().has("id"));
    }

    /**
     * Negative test case for destroyMutesUsers method.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {destroyMutesUsers} negative integration test.")
    public void destroyMutesUsersNegative() throws Exception {

        String methodName = "destroyMutesUsers";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_destroyMutesUsers_negative.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 400);
        Assert.assertTrue(esbRestResponse.getBody().has("errors"));
    }

    /**
     * Positive test case for getUsersSuggestions method with mandatory parameters.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getUsersSuggestions} integration test with mandatory parameters.")
    public void getUsersSuggestionsWithMandatoryParameters() throws Exception {

        String methodName = "getUsersSuggestions";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getUsersSuggestions_mandatory.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
    }

    /**
     * Negative test case for getUsersSuggestions method.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getUsersSuggestions} negative integration test.")
    public void getUsersSuggestionsNegative() throws Exception {

        String methodName = "getUsersSuggestions";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getUsersSuggestions_negative.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 400);
        Assert.assertTrue(esbRestResponse.getBody().has("errors"));
    }

    /**
     * Positive test case for getUsersLookup method with mandatory parameters.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getUsersLookup} integration test with mandatory parameters.")
    public void getUsersLookupWithMandatoryParameters() throws Exception {

        String methodName = "getUsersLookup";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getUsersLookup_mandatory.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
    }

    /**
     * Positive test case for getUsersLookup method with optional parameters.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getUsersLookup} integration test with optional parameters.")
    public void getUsersLookupWithOptionalParameters() throws Exception {

        String methodName = "getUsersLookup";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getUsersLookup_optional.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
    }

    /**
     * Negative test case for getUsersLookup method.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getUsersLookup} negative integration test.")
    public void getUsersLookupNegative() throws Exception {

        String methodName = "getUsersLookup";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getUsersLookup_negative.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 400);
        Assert.assertTrue(esbRestResponse.getBody().has("errors"));
    }

    /**
     * Positive test case for getUsersShow method with mandatory parameters.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getUsersShow} integration test with mandatory parameters.")
    public void getUsersShowWithOptionalParameters() throws Exception {

        String methodName = "getUsersShow";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getUsersShow_mandatory.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(esbRestResponse.getBody().has("id"));
    }

    /**
     * Negative test case for getUsersShow method.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getUsersShow} negative integration test.")
    public void getUsersShowNegative() throws Exception {

        String methodName = "getUsersShow";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getUsersShow_negative.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 400);
        Assert.assertTrue(esbRestResponse.getBody().has("errors"));
    }

    /**
     * Positive test case for createFriendships method with mandatory parameters.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {createFriendships} integration test with mandatory parameters.")
    public void createFriendshipsWithMandatoryParameters() throws Exception {

        String methodName = "createFriendships";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_createFriendships_mandatory.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(esbRestResponse.getBody().has("id"));
    }

    /**
     * Positive test case for createFriendships method with optional parameters.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {createFriendships} integration test with optional parameters.")
    public void createFriendshipsWithOptionalParameters() throws Exception {

        String methodName = "createFriendships";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_createFriendships_optional.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(esbRestResponse.getBody().has("id"));
    }

    /**
     * Negative test case for createFriendships method.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {createFriendships} negative integration test.")
    public void createFriendshipsNegative() throws Exception {

        String methodName = "createFriendships";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_createFriendships_negative.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 400);
        Assert.assertTrue(esbRestResponse.getBody().has("errors"));
    }

    /**
     * Positive test case for destroyFriendships method with mandatory parameters.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {destroyFriendships} integration test with mandatory parameters.")
    public void destroyFriendshipsWithOptionalParameters() throws Exception {

        String methodName = "destroyFriendships";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_destroyFriendships_mandatory.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(esbRestResponse.getBody().has("id"));
    }

    /**
     * Negative test case for destroyFriendships method.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {destroyFriendships} negative integration test.")
    public void destroyFriendshipsNegative() throws Exception {

        String methodName = "destroyFriendships";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_destroyFriendships_negative.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 400);
        Assert.assertTrue(esbRestResponse.getBody().has("errors"));
    }

    /**
     * Positive test case for getFollowersIds method with mandatory parameters.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getFollowersIds} integration test with mandatory parameters.")
    public void getFollowersIdsWithOptionalParameters() throws Exception {

        String methodName = "getFollowersIds";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getFollowersIds_mandatory.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(esbRestResponse.getBody().has("ids"));
    }

    /**
     * Negative test case for getFollowersIds method.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getFollowersIds} negative integration test.")
    public void getFollowersIdsNegative() throws Exception {

        String methodName = "getFollowersIds";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getFollowersIds_negative.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 400);
        Assert.assertTrue(esbRestResponse.getBody().has("errors"));
    }

    /**
     * Positive test case for getFollowersList method with mandatory parameters.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getFollowersList} integration test with mandatory parameters.")
    public void getFollowersListWithMandatoryParameters() throws Exception {

        String methodName = "getFollowersList";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getFollowersList_mandatory.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(esbRestResponse.getBody().has("users"));
    }

    /**
     * Positive test case for getFollowersList method with optional parameters.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getFollowersList} integration test with optional parameters.")
    public void getFollowersListWithOptionalParameters() throws Exception {

        String methodName = "getFollowersList";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getFollowersList_optional.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(esbRestResponse.getBody().has("users"));
    }

    /**
     * Negative test case for getFollowersList method.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getFollowersList} negative integration test.")
    public void getFollowersListNegative() throws Exception {

        String methodName = "getFollowersList";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getFollowersList_negative.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 400);
        Assert.assertTrue(esbRestResponse.getBody().has("errors"));
    }

    /**
     * Positive test case for getFriendshipsIncoming method with mandatory parameters.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getFriendshipsIncoming} integration test with mandatory" +
            " parameters.")
    public void getFriendshipsIncomingWithOptionalParameters() throws Exception {

        String methodName = "getFriendshipsIncoming";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getFriendshipsIncoming_mandatory.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
    }

    /**
     * Negative test case for getFriendshipsIncoming method.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getFriendshipsIncoming} negative integration test.")
    public void getFriendshipsIncomingNegative() throws Exception {

        String methodName = "getFriendshipsIncoming";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getFriendshipsIncoming_negative.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 400);
        Assert.assertTrue(esbRestResponse.getBody().has("errors"));
    }

    /**
     * Positive test case for getFriendshipsLookup method with mandatory parameters.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getFriendshipsLookup} integration test with mandatory parameters.")
    public void getFriendshipsLookupWithOptionalParameters() throws Exception {

        String methodName = "getFriendshipsLookup";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getFriendshipsLookup_mandatory.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
    }

    /**
     * Negative test case for getFriendshipsLookup method.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getFriendshipsLookup} negative integration test.")
    public void getFriendshipsLookupNegative() throws Exception {

        String methodName = "getFriendshipsLookup";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getFriendshipsLookup_negative.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 400);
        Assert.assertTrue(esbRestResponse.getBody().has("errors"));
    }

    /**
     * Positive test case for getFriendshipsNoRetweetsIds method with mandatory parameters.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {createFriendships} integration test with mandatory parameters.")
    public void getFriendshipsNoRetweetsIdsWithMandatoryParameters() throws Exception {

        String methodName = "getFriendshipsNoRetweetsIds";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getFriendshipsNoRetweetsIds_mandatory.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
    }

    /**
     * Positive test case for getFriendshipsNoRetweetsIds method with optional parameters.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getFriendshipsNoRetweetsIds} integration test with optional" +
            " parameters.")
    public void getFriendshipsNoRetweetsIdsWithOptionalParameters() throws Exception {

        String methodName = "getFriendshipsNoRetweetsIds";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getFriendshipsNoRetweetsIds_optional.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
    }

    /**
     * Negative test case for getFriendshipsNoRetweetsIds method.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getFriendshipsNoRetweetsIds} negative integration test.")
    public void getFriendshipsNoRetweetsIdsNegative() throws Exception {

        String methodName = "getFriendshipsNoRetweetsIds";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getFriendshipsNoRetweetsIds_negative.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 400);
        Assert.assertTrue(esbRestResponse.getBody().has("errors"));
    }

    /**
     * Positive test case for getFriendshipsOutgoing method with mandatory parameters.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getFriendshipsOutgoing} integration test with mandatory parameters.")
    public void getFriendshipsOutgoingWithMandatoryParameters() throws Exception {

        String methodName = "getFriendshipsNoRetweetsIds";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getFriendshipsOutgoing_mandatory.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
    }

    /**
     * Positive test case for getFriendshipsOutgoing method with optional parameters.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getFriendshipsOutgoing} integration test with optional parameters.")
    public void getFriendshipsOutgoingWithOptionalParameters() throws Exception {

        String methodName = "getFriendshipsOutgoing";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getFriendshipsOutgoing_optional.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
    }

    /**
     * Negative test case for getFriendshipsOutgoing method.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getFriendshipsOutgoing} negative integration test.")
    public void getFriendshipsOutgoingNegative() throws Exception {

        String methodName = "getFriendshipsOutgoing";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getFriendshipsOutgoing_negative.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 400);
        Assert.assertTrue(esbRestResponse.getBody().has("errors"));
    }

    /**
     * Positive test case for getFriendshipsShow method with mandatory parameters.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getFriendshipsShow} integration test with mandatory parameters.")
    public void getFriendshipsShowWithMandatoryParameters() throws Exception {

        String methodName = "getFriendshipsShow";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getFriendshipsShow_mandatory.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
    }

    /**
     * Negative test case for getFriendshipsShow method.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getFriendshipsShow} negative integration test.")
    public void getFriendshipShowNegative() throws Exception {

        String methodName = "getFriendshipsShow";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getFriendshipsShow_negative.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 400);
        Assert.assertTrue(esbRestResponse.getBody().has("errors"));
    }

    /**
     * Positive test case for  getFriendsList method with mandatory parameters.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getFriendsList} integration test with mandatory parameters.")
    public void getFriendsListWithMandatoryParameters() throws Exception {

        String methodName = "getFriendsList";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getFriendsList_mandatory.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(esbRestResponse.getBody().has("users"));
    }

    /**
     * Negative test case for  getFriendsList method.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {getFriendsIds} negative integration test.")
    public void getFriendsListNegative() throws Exception {

        String methodName = "getFriendsList";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_getFriendsList_negative.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 400);
        Assert.assertTrue(esbRestResponse.getBody().has("errors"));
    }

    /**
     * Positive test case for  updateFriendships method with mandatory parameters.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {updateFriendships} integration test with mandatory parameters.")
    public void updateFriendshipsWithMandatoryParameters() throws Exception {

        String methodName = "updateFriendships";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_updateFriendships_mandatory.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(esbRestResponse.getBody().has("relationship"));
    }

    /**
     * Negative test case for  updateFriendships method.
     */
    @Test(groups = {"wso2.ei"}, description = "twitter {updateFriendships} negative integration test.")
    public void updateFriendshipsNegative() throws Exception {

        String methodName = "updateFriendships";
        RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURLHttp(methodName),
                "POST", eiRequestHeadersMap, "esb_updateFriendships_negative.json");
        Assert.assertEquals(esbRestResponse.getHttpStatusCode(), 400);
        Assert.assertTrue(esbRestResponse.getBody().has("errors"));
    }
}
