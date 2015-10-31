package com.shin.pay.service.impl;

import com.shin.pay.dto.BatchPaymentRequestDTO;
import com.shin.pay.service.PaymentRequestService;
import org.springframework.stereotype.Service;

/**
 * @Author gaoshiliang
 * @Date 15/10/23.
 */
@Service("paymentRequestService")
public class PaymentRequestServiceImpl implements PaymentRequestService {
    public void savePaymentRequest(BatchPaymentRequestDTO requestDTO) {
        System.out.println("存储支付订单");
    }
}
