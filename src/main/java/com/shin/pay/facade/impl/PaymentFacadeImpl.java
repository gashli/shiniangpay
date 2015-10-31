package com.shin.pay.facade.impl;

import com.shin.pay.biz.PaymentRequestBiz;
import com.shin.pay.facade.PaymentFacade;
import com.shin.pay.dto.BatchPaymentRequestDTO;
import com.shin.pay.dto.PayModelResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author gaoshiliang
 * @Date 15/10/23.
 */
@Component(value = "paymentFacade")
public class PaymentFacadeImpl implements PaymentFacade {

    @Autowired
    private PaymentRequestBiz requestBiz;

    public void subPaymentOrderInfo(BatchPaymentRequestDTO requestDTO) {
        System.out.println("将订单信息存入表中");
    }

    public PayModelResultDto submitEbankPay(BatchPaymentRequestDTO requestDTO) {
        requestBiz.doEbankPaymentRequest(requestDTO);
        return null;
    }

    public PayModelResultDto submitUnEbankPay(BatchPaymentRequestDTO requestDTO) {
        requestBiz.doUnEbankPaymentRequest(requestDTO);
        return null;
    }

}
