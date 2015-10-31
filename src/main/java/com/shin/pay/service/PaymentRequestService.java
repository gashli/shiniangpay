package com.shin.pay.service;

import com.shin.pay.dto.BatchPaymentRequestDTO;

/**
 * @Author gaoshiliang
 * @Date 15/10/23.
 */
public interface PaymentRequestService {

    public void savePaymentRequest(BatchPaymentRequestDTO requestDTO);
}
