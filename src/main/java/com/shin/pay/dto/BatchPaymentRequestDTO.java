package com.shin.pay.dto;

import com.google.common.collect.Lists;
import com.shin.pay.entity.BatchPaymentInfo;
import com.shin.pay.entity.PayInfo;
import com.shin.pay.entity.PayPriority;

import java.util.List;
import java.util.Map;

/**
 * @Author gaoshiliang
 * @Date 15/10/22.
 */
public class BatchPaymentRequestDTO {

    private BatchPaymentInfo paymentInfo;

    private PayPriority payPriority;

    private Map<String,PayInfo> payInfoMap;

    public BatchPaymentInfo getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(BatchPaymentInfo paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public PayPriority getPayPriority() {
        return payPriority;
    }

    public void setPayPriority(PayPriority payPriority) {
        this.payPriority = payPriority;
    }

    public Map<String, PayInfo> getPayInfoMap() {
        return payInfoMap;
    }

    public void setPayInfoMap(Map<String, PayInfo> payInfoMap) {
        this.payInfoMap = payInfoMap;
    }

    public List<PayInfo> getPayInfos(){
        List<PayInfo> payInfos = Lists.newArrayList();
        for (String key:this.payInfoMap.keySet()){
            payInfos.add(payInfoMap.get(key));
        }
        return payInfos;
    }
}
