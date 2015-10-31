package com.shin.pay.service.impl;

import com.shin.pay.dto.BatchPaymentRequestDTO;
import com.shin.pay.dto.PayModelResultDto;
import org.springframework.stereotype.Service;

/**
 * @Author gaoshiliang
 * @Date 15/10/23.
 */
public class BankCardModelServiceImpl extends PayModelAdapter {

    @Override
    public PayModelResultDto pay(BatchPaymentRequestDTO requestDTO){
        PayModelResultDto resultDto = new PayModelResultDto();
        resultDto.setBgUrl("http:www.baidu.com");
        resultDto.setModelName("银行卡支付");
        resultDto.setPayAmount("1000");
        resultDto.setPayTime("2015-09-15");
        resultDto.setReturnCode("SN0001000");
        resultDto.setReturnMsg("支付成功");
        return resultDto;
    }

}
