package com.shin.pay.biz.impl;

import com.shin.pay.biz.PaymentProcessBiz;
import com.shin.pay.biz.PaymentRequestBiz;
import com.shin.pay.dto.BatchPaymentRequestDTO;
import com.shin.pay.service.PaymentRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author gaoshiliang
 * @Date 15/10/23.
 */
@Service("requestBiz")
public class PaymentRequestBizImpl implements PaymentRequestBiz {
    @Autowired
    private PaymentRequestService requestService;

    @Autowired
    private PaymentProcessBiz processBiz;

    public void doEbankPaymentRequest(BatchPaymentRequestDTO requestInfo) {
        //1、参数校验

        //2、支付下单
        requestService.savePaymentRequest(requestInfo);

        //3、网关支付
        processBiz.gotoPay(requestInfo);
        //4、结果返回封装

    }

    public void doUnEbankPaymentRequest(BatchPaymentRequestDTO requestInfo) {
        //1、参数校验

        //2、支付下单
        requestService.savePaymentRequest(requestInfo);

        //3、是否为充值订单

        //4、网关支付
        processBiz.gotoPay(requestInfo);

        //5、结果返回封装
    }
}
