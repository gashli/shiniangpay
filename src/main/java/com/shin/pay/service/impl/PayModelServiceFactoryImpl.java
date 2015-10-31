package com.shin.pay.service.impl;

import com.shin.pay.paymodel.PayModelService;
import com.shin.pay.service.PayModelServiceFactory;

import java.util.Map;

/**
 * @Author gaoshiliang
 * @Date 15/10/23.
 */
public class PayModelServiceFactoryImpl implements PayModelServiceFactory {
    private Map<String, PayModelService> payModelServiceMap;

    public PayModelService getPayModelService(String payModel) {
        if (payModelServiceMap == null || payModelServiceMap.isEmpty()) {
            System.out.println("获取支付模式为空");
        }
        return payModelServiceMap.get(payModel);
    }

    public Map<String, PayModelService> getPayModelServiceMap() {
        return payModelServiceMap;
    }

    public void setPayModelServiceMap(Map<String, PayModelService> payModelServiceMap) {
        this.payModelServiceMap = payModelServiceMap;
    }
}
