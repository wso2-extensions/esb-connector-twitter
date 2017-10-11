package org.wso2.carbon.connector.unitTest.TwitterConnector;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.wso2.carbon.connector.twitter.TwitterConstants;

/**
 * Program to generate oauth signature locally
 */
public class TwitterGenerateSampleSignature {

    private static String key = "dummyConsumerKey";
    private static String secret = "dummyConsumerSecret";
    private static String token = "dummyAccessToken";
    private static String tokenSecret = "dummyAccessTokenSecret";
    private static final String SIGNATURE_METHOD = "HmacSHA1";
    private static final String ENC = "UTF-8";

    /**
     * @throws IOException
     * @throws ClientProtocolException
     * @throws URISyntaxException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     */
    public String connect(String oauthNonce, String oauthTimestamp)
            throws IOException, URISyntaxException, InvalidKeyException, NoSuchAlgorithmException {

        HttpClient httpclient = new DefaultHttpClient();
        List<NameValuePair> qparams = new ArrayList<NameValuePair>();
        // These params should ordered in key
        qparams.add(new BasicNameValuePair("oauth_consumer_key", key));
        qparams.add(new BasicNameValuePair("oauth_nonce", oauthNonce));
        qparams.add(new BasicNameValuePair("oauth_signature_method", SIGNATURE_METHOD));
        qparams.add(new BasicNameValuePair("oauth_timestamp", oauthTimestamp));
        qparams.add(new BasicNameValuePair("oauth_token", token));
        qparams.add(new BasicNameValuePair("oauth_version", "1.0"));

        // generate the oauth_signature
        String signature = getSignature(URLEncoder.encode("https://api.twitter.com/oauth/request_token", ENC),
                URLEncoder.encode(URLEncodedUtils.format(qparams, ENC), ENC));
        return encode(signature);
    }

    public static String encode(String value) throws UnsupportedEncodingException {
        String encoded;
        try {
            encoded = URLEncoder.encode(value, TwitterConstants.ENC);
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedEncodingException("Unsupported encoding");
        }
        StringBuilder buf = null;
        if (encoded != null) {
            buf = new StringBuilder(encoded.length());
            char focus;
            for (int i = 0; i < encoded.length(); i++) {
                focus = encoded.charAt(i);
                if (focus == '*') {
                    buf.append("%2A");
                } else if (focus == '+') {
                    buf.append("%20");
                } else if (focus == '%' && (i + 1) < encoded.length() && encoded.charAt(i + 1) == '7'
                        && encoded.charAt(i + 2) == 'E') {
                    buf.append('~');
                    i += 2;
                } else {
                    buf.append(focus);
                }
            }
        }
        if (buf != null) {
            return buf.toString();
        }
        return null;
    }

    /**
     * @param url    the url for "request_token" URLEncoded.
     * @param params parameters string, URLEncoded.
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     */
    private static String getSignature(String url, String params)
            throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
        StringBuilder base = new StringBuilder();
        base.append("GET&");
        base.append(url);
        base.append("&");
        base.append(params);
        // It is needed to append a "&" to the end of secret key.
        byte[] keyBytes = (secret + "&" + encode(tokenSecret)).getBytes();
        SecretKey key = new SecretKeySpec(keyBytes, SIGNATURE_METHOD);
        Mac mac = Mac.getInstance(SIGNATURE_METHOD);
        mac.init(key);
        // encode it, base64 it, change it to string and return.
        return new String(Base64.encodeBase64(mac.doFinal(base.toString().getBytes(ENC))), ENC).trim();
    }
}