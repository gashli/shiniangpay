package com.shin.pay.utils;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/**
 * @Author gaoshiliang
 * @Date 15/10/30.
 */
public class TrustAnyHostnameVerifier implements HostnameVerifier{
    public boolean verify(String s, SSLSession sslSession) {
        return true;
    }
}
