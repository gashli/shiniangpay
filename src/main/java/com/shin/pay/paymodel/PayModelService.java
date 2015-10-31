package com.shin.pay.paymodel;

import com.shin.pay.dto.BatchPaymentRequestDTO;
import com.shin.pay.dto.PayModelResultDto;

/**
 * @Author gaoshiliang
 * @Date 15/10/22.
 */
public interface PayModelService {

    public PayModelResultDto pay(BatchPaymentRequestDTO requestDTO);

}
