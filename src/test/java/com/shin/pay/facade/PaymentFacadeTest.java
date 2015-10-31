package com.shin.pay.facade;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.shin.pay.dto.BatchPaymentRequestDTO;
import com.shin.pay.entity.BatchPaymentInfo;
import com.shin.pay.entity.PayInfo;
import com.shin.pay.entity.PayPriority;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @Author gaoshiliang
 * @Date 15/10/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class PaymentFacadeTest {

    @Autowired
    private PaymentFacade paymentFacade;

    @Test
    public void PaymentFacadeTest_A(){
        paymentFacade.submitUnEbankPay(init());
    }


    private BatchPaymentRequestDTO init(){
        BatchPaymentRequestDTO requestDTO = buildBathcPayment();
        return requestDTO;
    }

    private BatchPaymentRequestDTO buildBathcPayment(){
        BatchPaymentRequestDTO requestDTO = new BatchPaymentRequestDTO();
        requestDTO.setPayInfoMap(buildPayInfo());
        requestDTO.setPayPriority(buildPayPriority());
        requestDTO.setPaymentInfo(buildBatchPaymentInfo_BANK());
        return requestDTO;
    }


    private BatchPaymentInfo buildBatchPaymentInfo_BANK(){
        BatchPaymentInfo paymentInfo = new BatchPaymentInfo();
        paymentInfo.setBatchAmount(new BigDecimal(10.03));
        paymentInfo.setBatchOrderId(13L);
        paymentInfo.setBusiTypeId("QIANXIAN");
        paymentInfo.setCurrentPriority("BANK");
        paymentInfo.setPayPriority("BANK");
        paymentInfo.setPaySequenceNo("pay2015102110133017428");
        return paymentInfo;

    }

    private BatchPaymentInfo buildBatchPaymentInfo_WEIXIN(){
        BatchPaymentInfo paymentInfo = new BatchPaymentInfo();
        paymentInfo.setBatchAmount(new BigDecimal(10.03));
        paymentInfo.setBatchOrderId(13L);
        paymentInfo.setBusiTypeId("QIANXIAN");
        paymentInfo.setCurrentPriority("WEIXIN");
        paymentInfo.setPayPriority("WEIXIN");
        paymentInfo.setPaySequenceNo("pay2015102110133017428");
        return paymentInfo;
    }

    private BatchPaymentInfo buildBatchPaymentInfo_ALIPAY(){
        BatchPaymentInfo paymentInfo = new BatchPaymentInfo();
        paymentInfo.setBatchAmount(new BigDecimal(10.03));
        paymentInfo.setBatchOrderId(13L);
        paymentInfo.setBusiTypeId("QIANXIAN");
        paymentInfo.setCurrentPriority("ALIPAY");
        paymentInfo.setPayPriority("ALIPAY");
        paymentInfo.setPaySequenceNo("pay2015102110133017428");
        return paymentInfo;
    }

    private PayPriority buildPayPriority(){
        PayPriority priority = new PayPriority();
        List<String> priorityS = Lists.newLinkedList();
        priorityS.add("BANK");
        priorityS.add("WEIXIN");
        priorityS.add("ALIPAY");
        priority.setPriority(priorityS);
        return priority;
    }

    private Map<String,PayInfo> buildPayInfo(){
        Map<String,PayInfo> payInfoMap = Maps.newHashMap();
        PayInfo payInfo = new PayInfo();
        payInfo.setAmount(10.03);
        payInfo.setBankCode("ICBC");
        payInfo.setBatchPaymentId(12L);
        payInfo.setBgRetUrl("baidu.com");
        payInfo.setBusiTypeId("QIANXIAN");
        payInfo.setCurId("CYN");
        payInfo.setFzData("a:10,b:0.03");
        payInfo.setPayMode("BANK");
        payInfo.setUserId("a0000001");
        payInfoMap.put("1", payInfo);
        return payInfoMap;

    }


}
