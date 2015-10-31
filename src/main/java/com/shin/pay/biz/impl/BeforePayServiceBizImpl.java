package com.shin.pay.biz.impl;

import com.shin.pay.biz.BeforePayServiceBiz;
import com.shin.pay.dto.BatchPaymentRequestDTO;

/**
 * @Author gaoshiliang
 * @Date 15/10/23.
 */
public class BeforePayServiceBizImpl implements BeforePayServiceBiz {
    public void checkParams(BatchPaymentRequestDTO requestDTO) {
        System.out.println("检查参数...");
    }
}
