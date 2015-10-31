package com.shin.pay.service.impl;

import com.shin.pay.dto.BatchPaymentRequestDTO;
import com.shin.pay.dto.PayModelResultDto;
import org.springframework.stereotype.Service;

/**
 * @Author gaoshiliang
 * @Date 15/10/23.
 */
public class WeiXinModelServiceImpl extends PayModelAdapter {

    @Override
    public PayModelResultDto pay(BatchPaymentRequestDTO requestDTO) {
        PayModelResultDto resultDto = new PayModelResultDto();
        resultDto.setBgUrl("http:www.qq.com");
        resultDto.setModelName("微信支付");
        resultDto.setPayAmount("50");
        resultDto.setPayTime("2015-09-17");
        resultDto.setReturnCode("SN0001000");
        resultDto.setReturnMsg("支付成功");
        return resultDto;
    }
}
