package com.shin.pay.main;

import com.shin.pay.utils.HttpUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author gaoshiliang
 * @Date 15/10/30.
 */
public class HttpUtilTest extends BaseTest {

    @Test
    public void  HttpPostTest(){
        String url ="http://hq.sinajs.cn";
        HttpUtil.doPost(url,initRequestParams());
    }

    @Test
    public void  HttpGetTest(){
        String url ="http://hq.sinajs.cn/list=sh601021";
        HttpUtil.doGet(url);
    }

    private static Map<String,String> initRequestParams(){
        Map<String,String> resultMap = new HashMap<String, String>();
        resultMap.put("list","sh601006");
        return resultMap;
    }

    private void TestA(){
        System.out.println("test");
    }
    
    private void TestB(){
        System.out.println("testB");
    }
}
