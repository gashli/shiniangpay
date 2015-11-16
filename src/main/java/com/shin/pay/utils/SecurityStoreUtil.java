package com.shin.pay.utils;

import com.google.common.collect.Maps;
import net.sf.json.JSONException;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.lang.StringUtils;
import org.owasp.esapi.ESAPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.String;import java.util.Map;

/**
 * @author shiliang.gao
 * @since 15-11-3
 */
@Component
public class SecurityStoreUtil {
    private static final Logger logger = LoggerFactory.getLogger(SecurityStoreUtil.class);

    @Value("host_enc_url")
//    private static final String host_enc_url = "http://secweb.pay.qunar.com/qunarSecureStorage/page/securestorage/encryptionCIData";
    private static final String host_enc_url = "http://192.168.237.59:9090/qunarSecureStorage/page/securestorage/encryptionCIData";

    @Value("host_dnc_url")
//    private static final String host_dnc_url = "http://secweb.pay.qunar.com/qunarSecureStorage/page/securestorage/decryptionCIData";
    private static final String host_dnc_url = "http://192.168.237.59:9090/qunarSecureStorage/page/securestorage/decryptionCIData";


    public static final String CHARSET = "UTF-8";

    private static MultiThreadedHttpConnectionManager connectionManager = null;

    private static int connectionTimeOut = 25000;
    private static int socketTimeOut = 25000;
    private static int maxConnectionPerHost = 20;
    private static int maxTotalConnection = 20;

    private static HttpClient client;

    static {
        init();
    }

    private static void init() {
        connectionManager = new MultiThreadedHttpConnectionManager();
        connectionManager.getParams().setConnectionTimeout(connectionTimeOut);
        connectionManager.getParams().setSoTimeout(socketTimeOut);
        connectionManager.getParams().setDefaultMaxConnectionsPerHost(maxConnectionPerHost);
        connectionManager.getParams().setMaxTotalConnections(maxTotalConnection);
        client = new HttpClient();
    }


    /**
     * 加密方法，包括身份证、卡号
     *
     * @param anyNo
     * @return
     */
    public static String encrypt(String anyNo) {
        if (StringUtils.isBlank(anyNo)) {
            return null;
        }
        return postEncData(anyNo);
    }


    /**
     * 解密卡号
     *
     * @param cardNo
     * @return
     */
    public static String decCardNo(String cardNo) {
        logger.debug("the cardNo need to encrypt is :" + cardNo);
        if (StringUtils.isBlank(cardNo)) {
            return "";
        }
        return postDecData(cardNo, 1);
    }

    /**
     * 解密身份证号
     *
     * @param identityCode
     * @return
     */
    public static String decIdCode(String identityCode) {
        logger.debug("the identityCode need to encrypt is :" + identityCode);
        if (StringUtils.isBlank(identityCode)) {
            return "";
        }
        return postDecData(identityCode, 2);
    }


    /**
     * 调用解密方法
     *
     * @param cardNo
     * @param type
     * @return
     */
    private static String postDecData(String cardNo, int type) {
        String result = cardNo;
        try {
            PostMethod postMethod = new PostMethod(host_dnc_url);
            postMethod.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=" + CHARSET);
            postMethod.setParameter("encrypIndex", cardNo);
            int resultStatus = client.executeMethod(postMethod);
            if (resultStatus == HttpStatus.SC_OK) {
                String strTemp = postMethod.getResponseBodyAsString();
                Map<String, String> mapTemp;
                if (StringUtils.isNotBlank(strTemp)) {
                    mapTemp = getDecMapFromResponse(strTemp);
                    if (type == 1) {
                        return mapTemp.get("cardNo");
                    } else if (type == 2) {
                        return mapTemp.get("identityNo");
                    } else {
                        return strTemp;
                    }
                }
            } else {
                logger.error("remote securestorage invoke error. returnCode:" + postMethod.getStatusCode());
            }

        } catch (IOException e) {
            logger.error("postDecData encounter an error.", e);
        }
        return result;
    }

    private static String postEncData(String anyNo) {
        PostMethod postMethod = new PostMethod(host_enc_url);
        postMethod.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=" + CHARSET);
        postMethod.setParameter("cardId", anyNo);
        postMethod.setParameter("identityNo", "nocard");

        try {
            int resultStatus = client.executeMethod(postMethod);
            if (resultStatus == HttpStatus.SC_OK) {
                return postMethod.getResponseBodyAsString();
            } else {
                logger.error("remote invoke error . returnCode:" + resultStatus);
            }
        } catch (IOException e) {
            logger.error("postEncData encounter an error.", e);
        }
        return null;
    }

    private static Map<String, String> getDecMapFromResponse(String response) {
        Map<String, String> map = Maps.newHashMap();
        //防xss攻击
        String jsonStr = ESAPI.encoder().decodeForHTML(response);
        if (StringUtils.isNotBlank(jsonStr)) {
            try {
                JSONObject json = new JSONObject(jsonStr);
                map.put("cardNo", json.getString("cardId"));
                map.put("identityNo", json.getString("identityNo"));
                return map;
            } catch (JSONException e) {
                logger.info("analysis result error.");
            }
        }
        return null;
    }


}
