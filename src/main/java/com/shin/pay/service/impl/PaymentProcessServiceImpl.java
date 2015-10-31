package com.shin.pay.service.impl;

import com.shin.pay.dto.PayModelResultDto;
import com.shin.pay.service.PaymentProcessService;
import org.springframework.stereotype.Service;

/**
 * @Author gaoshiliang
 * @Date 15/10/23.
 */
@Service("paymentProcessService")
public class PaymentProcessServiceImpl implements PaymentProcessService {
    public void sycPayResult(PayModelResultDto resultDto) {
        System.out.println("支付后，同步处理支付订单。");
    }
}
