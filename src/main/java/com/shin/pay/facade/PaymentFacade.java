package com.shin.pay.facade;

import com.shin.pay.dto.BatchPaymentRequestDTO;
import com.shin.pay.dto.PayModelResultDto;

/**
 * @Author gaoshiliang
 * @Date 15/10/23.
 */
public interface PaymentFacade {
    public void subPaymentOrderInfo(BatchPaymentRequestDTO requestDTO);

    public PayModelResultDto submitEbankPay(BatchPaymentRequestDTO requestDTO);

    public PayModelResultDto submitUnEbankPay(BatchPaymentRequestDTO requestDTO);
}
