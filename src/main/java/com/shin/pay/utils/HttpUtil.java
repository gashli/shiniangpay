package com.shin.pay.utils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import net.sf.json.JSONObject;
import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.URL;
import java.net.URLDecoder;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author gaoshiliang
 * @Date 15/10/23.
 */
public class HttpUtil {

    private static Logger logger = LoggerFactory.getLogger(HttpUtil.class);    //日志记录


    /**
     * 获取用户ip
     */
    public static String getRemoteIp(HttpServletRequest request) {
        String ip = request.getHeader("x-real-ip");
        if (StringUtil.isEmpty(ip)) {
            ip = request.getRemoteAddr();
        }
        String[] stemps = ip.split(",");
        if (stemps != null && stemps.length >= 1) {
            ip = stemps[0];
        }
        ip = ip.trim();
        if (ip.length() > 23) {
            ip = ip.substring(23);
        }
        return ip;
    }

    /**
     * 获取用户信息
     */
    public static Map<String, String> getLoginUserInfo(HttpServletRequest request) {
        Cookie[] cookie = request.getCookies();
        Map<String, String> userInfoMap = Maps.newHashMap();
        userInfoMap.put("userName", "gashli");
        userInfoMap.put("pwd", "JHsfela411k31NfscPv3vs2Iqa3");
        userInfoMap.put("telphone", "18898443355");
        userInfoMap.put("loginName", "gashli@163.com");
        return userInfoMap;
    }


    public static String doPost(String requestUrl, Map<String, String> paramMap) {
        String responseContent = null;
        if (requestUrl.startsWith("https://")) {
            responseContent = doHttpsClientPost(requestUrl, paramMap);
        } else {
            responseContent = doHttpClientPost(requestUrl, paramMap);
        }
        return responseContent;
    }

    private static String doHttpsClientPost(String requestUrl, Map<String, String> paramMap) {
        String responseContent = null;
        HttpsURLConnection httpsURLConnection = null;
        InputStream inputStream = null;
        BufferedReader bufferedReader = null;
        try {
            SSLContext context = SSLContext.getInstance("SSL");
            context.init(null, new TrustManager[]{new TrustAnyTrustManager()}, new SecureRandom());
            URL url = new URL(requestUrl);

            httpsURLConnection = (HttpsURLConnection) url.openConnection();
            httpsURLConnection.setRequestMethod("POST");
            httpsURLConnection.setSSLSocketFactory(context.getSocketFactory());
            httpsURLConnection.setHostnameVerifier(new TrustAnyHostnameVerifier());
            //true表示建立连接后，需要从向连接输入数据
            httpsURLConnection.setDoInput(true);
            //true表示需要向连接读取数据
            httpsURLConnection.setDoOutput(true);
            httpsURLConnection.connect();

            String params = paramMapToString(paramMap, "&");

            byte[] b = params.getBytes();

            httpsURLConnection.getOutputStream().write(b, 0, b.length);
            httpsURLConnection.getOutputStream().flush();
            httpsURLConnection.getOutputStream().close();

            inputStream = httpsURLConnection.getInputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));

            String lineTemp;
            StringBuffer resultTemp = new StringBuffer();
            String sysSep = System.getProperty("line.separator");

            if ((lineTemp = bufferedReader.readLine()) != null) {
                resultTemp.append(lineTemp);
                resultTemp.append(sysSep);
            }
            responseContent = resultTemp.toString();
        } catch (Exception e) {
            logger.error("remote invoke error.", e);
        }
        return responseContent;
    }

    private static String paramMapToString(Map<String, String> paramsMap, String splitStr) {
        String ret = "";
        if (CollectionUtils.isEmpty(paramsMap)) {
            return ret;
        }
        for (String key : paramsMap.keySet()) {
            if (ret.length() > 0)
                ret = ret + splitStr;
            ret = ret + key + "=" + paramsMap.get(key);
        }
        return ret;
    }

    private static String doHttpClientPost(String requestUrl, Map<String, String> paramMap) {
        if (paramMap == null) {
            return "";
        }
        String responseContent = "";
        //建立http连接
        HttpClient httpClient = new DefaultHttpClient();
        //使用post方式
        HttpPost httpPost = new HttpPost(requestUrl);
        //post参数
        List<NameValuePair> nameValuePairs = Lists.newArrayList();
        Iterator<String> iterator = paramMap.keySet().iterator();
        InputStream inputStream = null;
        while (iterator.hasNext()) {
            String key = iterator.next();
            String value = paramMap.get(key);
            nameValuePairs.add(new BasicNameValuePair(key, value));
        }
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, "UTF-8"));

            logger.info(httpPost.toString());
            //获取返回结果
            HttpResponse response = httpClient.execute(httpPost);

            //获取返回实体
            HttpEntity httpEntity = response.getEntity();

            //获取头文信息
            Header header = httpEntity.getContentType();

            String headString = "";
            if (header != null) {
                headString = header.getValue();
            }
            //得到http请求中的编码
            String charset = getEncoding(headString);

            if (httpEntity != null) {
                String lineTemp;
                inputStream = httpEntity.getContent();
                StringBuffer stringBuffer = new StringBuffer();
                //读数据流
                Reader reader = new InputStreamReader(inputStream, "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(reader);
                while ((lineTemp = bufferedReader.readLine()) != null) {
                    stringBuffer.append(lineTemp);
                }
                responseContent = stringBuffer.toString();
            }
        } catch (Exception e) {
            logger.error("remote invok error", e);
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Exception e) {
                logger.info("io close error", e);
            }
        }
        return responseContent;

    }

    private static String getEncoding(String header) {
        String charset = "UTF-8";
        if (StringUtil.isEmpty(header))
            return charset;
        if (matcher(header, "(charset)\\s?=\\s?(utf-?8)")) {
            charset = "UTF-8";
        } else if (matcher(header, "(charset)\\s?=\\s?(gbk)")) {
            charset = "GBK";
        } else if (matcher(header, "(charset)\\s?=\\s?(gb2312)")) {
            return "GB2312";
        }
        return charset;
    }

    private static boolean matcher(String header, String pattern) {
        //匹配模式
        Pattern p = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE + Pattern.UNICODE_CASE);
        //去匹配header中的串
        Matcher matcher = p.matcher(header);
        if (matcher.find()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 发送get请求
     *
     * @param url 路径
     * @return
     */
    public static String doGet(String url) {
        String strResult = "";
        try {
            DefaultHttpClient client = new DefaultHttpClient();
            //发送get请求
            HttpGet request = new HttpGet(url);
            HttpResponse response = client.execute(request);

            /**请求发送成功，并得到响应**/
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                /**读取服务器返回过来的json字符串数据**/
                strResult = EntityUtils.toString(response.getEntity());
                logger.info("result:"+strResult);
            } else {
                logger.error("get请求提交失败:" + url);
            }
        } catch (IOException e) {
            logger.error("get请求提交失败:" + url, e);
        }
        return strResult;
    }

}
