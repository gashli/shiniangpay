package com.shin.pay.utils;

/**
 * @Author gaoshiliang
 * @Date 15/10/23.
 */
public class StringUtil {

    public static boolean isEmpty(String targetStr){
        if (targetStr==null){
            return true;
        }
        return targetStr.trim().equals("")?true:false;
    }
}
