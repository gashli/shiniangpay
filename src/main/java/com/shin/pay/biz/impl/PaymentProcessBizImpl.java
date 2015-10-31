package com.shin.pay.biz.impl;

import com.shin.pay.biz.PaymentProcessBiz;
import com.shin.pay.dto.BatchPaymentRequestDTO;
import com.shin.pay.dto.PayModelResultDto;
import com.shin.pay.entity.BatchPaymentInfo;
import com.shin.pay.service.PayModelServiceFactory;
import com.shin.pay.service.PaymentProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author gaoshiliang
 * @Date 15/10/23.
 */
@Component("paymentProcessBiz")
public class PaymentProcessBizImpl implements PaymentProcessBiz {
    @Autowired
    private PayModelServiceFactory payModelServiceFactory;
    @Autowired
    private PaymentProcessService processService;

    public void gotoPay(BatchPaymentRequestDTO requestDTO) {
        BatchPaymentInfo batchPaymentInfo = requestDTO.getPaymentInfo();
        String currentPriorityModel = batchPaymentInfo.getPayPriority();
        System.out.println(currentPriorityModel);
        PayModelResultDto modelResultDto = payModelServiceFactory.getPayModelService(currentPriorityModel).pay(requestDTO);
        System.out.println(modelResultDto.toString());
        processService.sycPayResult(modelResultDto);
    }
}
