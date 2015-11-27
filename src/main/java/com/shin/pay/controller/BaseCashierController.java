package com.shin.pay.controller;


import com.google.common.collect.Maps;
import com.shin.pay.utils.HttpUtil;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Author gaoshiliang
 * @Date 15/10/23.
 */
public abstract class BaseCashierController extends AbstractController {

    protected Map<String,String> getParameterMap(HttpServletRequest request){
        //获取远程ip
        String remoteIp = HttpUtil.getRemoteIp(request);

        Map<String,String> userInfoMap = HttpUtil.getLoginUserInfo(request);

        return getBaseMap(remoteIp,userInfoMap);
    }


    private  Map<String,String> getBaseMap(String remoteIp,Map<String,String> userInfoMap){
        Map<String,String> resultMap = Maps.newHashMap();
        resultMap.put("remoteIp", remoteIp);
        resultMap.putAll(userInfoMap);
        return resultMap;
    }

}
