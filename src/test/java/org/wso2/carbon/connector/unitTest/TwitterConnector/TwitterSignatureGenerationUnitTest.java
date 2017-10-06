/*
 * Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.connector.unitTest.TwitterConnector;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.util.UUIDGenerator;
import org.apache.axiom.util.UIDGenerator;
import org.apache.axis2.AxisFault;
import org.apache.axis2.context.ConfigurationContext;
import org.apache.axis2.context.OperationContext;
import org.apache.axis2.context.ServiceContext;
import org.apache.axis2.description.InOutAxisOperation;
import org.apache.synapse.MessageContext;
import org.apache.synapse.config.SynapseConfiguration;
import org.apache.synapse.core.axis2.Axis2MessageContext;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.wso2.carbon.connector.twitter.TwitterConstants;
import org.wso2.carbon.connector.twitter.TwitterSignatureGeneration;

/**
 * generate the authorization header
 */
public class TwitterSignatureGenerationUnitTest {

    private TwitterSignatureGeneration twitterSignatureGeneration;
    private TwitterGenerateSampleSignature twitterGenerateSampleSignature;
    private SynapseConfiguration synapseConfig;
    private MessageContext ctx;
    private ConfigurationContext configContext;

    @BeforeMethod
    public void setUp() throws Exception {
        twitterSignatureGeneration = new TwitterSignatureGeneration();
        twitterGenerateSampleSignature = new TwitterGenerateSampleSignature();
        ctx = createMessageContext();
    }

    @Test
    public void testTwitterSignatureGeneration() throws Exception {
        ctx.setProperty(TwitterConstants.TWITTER_CONSUMER_KEY, "dummyConsumerKey");
        ctx.setProperty(TwitterConstants.TWITTER_CONSUMER_SECRET, "dummyConsumerSecret");
        ctx.setProperty(TwitterConstants.TWITTER_ACCESS_TOKEN, "dummyAccessToken");
        ctx.setProperty(TwitterConstants.TWITTER_ACCESS_TOKEN_SECRET, "dummyAccessTokenSecret");
        ctx.setProperty(TwitterConstants.SIGNATURE_METHOD, "HmacSHA1");
        ctx.setProperty(TwitterConstants.HTTP_METHOD, "GET");
        ctx.setProperty(TwitterConstants.TWITTER_ENDPOINT, "https://api.twitter.com/oauth/request_token");
        twitterSignatureGeneration.connect(ctx);
        String output = ctx.getProperty("uri.var.signature").toString();
        String signature = output.substring(output.indexOf("oauth_signature=") + 17, output.indexOf("\",oauth_token"));
        String oauthNonce = output.substring(output.indexOf("oauth_nonce") + 13, output.indexOf("\",oauth_version"));
        String oauthTimestamp = output
                .substring(output.indexOf("oauth_timestamp") + 17, output.indexOf("\",oauth_nonce"));
        String sampleSignature = twitterGenerateSampleSignature.connect(oauthNonce, oauthTimestamp);
        Assert.assertEquals(signature, sampleSignature);
    }

    private MessageContext createMessageContext() throws AxisFault {
        MessageContext msgCtx = createSynapseMessageContext();
        org.apache.axis2.context.MessageContext axis2MsgCtx = ((Axis2MessageContext) msgCtx).getAxis2MessageContext();
        axis2MsgCtx.setServerSide(true);
        axis2MsgCtx.setMessageID(UUIDGenerator.getUUID());
        return msgCtx;
    }

    private MessageContext createSynapseMessageContext() throws AxisFault {
        org.apache.axis2.context.MessageContext axis2MC = new org.apache.axis2.context.MessageContext();
        axis2MC.setConfigurationContext(this.configContext);
        ServiceContext svcCtx = new ServiceContext();
        OperationContext opCtx = new OperationContext(new InOutAxisOperation(), svcCtx);
        axis2MC.setServiceContext(svcCtx);
        axis2MC.setOperationContext(opCtx);
        Axis2MessageContext mc = new Axis2MessageContext(axis2MC, this.synapseConfig, null);
        mc.setMessageID(UIDGenerator.generateURNString());

        mc.setEnvelope(OMAbstractFactory.getSOAP12Factory().createSOAPEnvelope());
        mc.getEnvelope().addChild(OMAbstractFactory.getSOAP12Factory().createSOAPBody());

        return mc;
    }
}

