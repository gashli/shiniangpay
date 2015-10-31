package com.shin.pay.biz;

import com.shin.pay.dto.BatchPaymentRequestDTO;

/**
 * @Author gaoshiliang
 * @Date 15/10/23.
 */
public interface BeforePayServiceBiz {

    public void checkParams(BatchPaymentRequestDTO requestDTO);


}
