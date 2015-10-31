package com.shin.pay.biz;

import com.shin.pay.dto.BatchPaymentRequestDTO;

/**
 * @Author gaoshiliang
 * @Date 15/10/23.
 */
public interface PaymentProcessBiz {

    public void gotoPay(BatchPaymentRequestDTO requestDTO);

}
