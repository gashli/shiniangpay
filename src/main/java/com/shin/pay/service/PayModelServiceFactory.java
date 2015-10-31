package com.shin.pay.service;

import com.shin.pay.paymodel.PayModelService;

/**
 * @Author gaoshiliang
 * @Date 15/10/23.
 */
public interface PayModelServiceFactory {

    public PayModelService  getPayModelService(String payModel);
}
