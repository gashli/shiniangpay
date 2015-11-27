package com.shin.pay.service;

import com.shin.pay.dao.BatchPaymentDAO;
import com.shin.pay.entity.BatchPaymentInfo;
import com.shin.pay.main.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author shiliang.gao
 * @since 2015-11-20
 */
public class DicHandlerServiceTest extends BaseTest {


    @Autowired
    BatchPaymentDAO paymentDAO;

    @Autowired
    HandlerService service;

    @Test
    public void DicHandlerTest(){
//        System.out.println(paymentDAO.queryBatchPaymentInfo("gashli.123456"));
        BatchPaymentInfo paymentInfo=paymentDAO.queryBatchPaymentInfo("gashli.123456");
        System.out.println("装换前："+paymentInfo);
        service.excuteAnnotation(paymentInfo);
        System.out.println("装换后："+paymentInfo);
    }


    private BatchPaymentInfo init(){
        BatchPaymentInfo batchPaymentInfo = new BatchPaymentInfo();
        batchPaymentInfo.setPaySequenceNo("gashli.123456");
        batchPaymentInfo.setUserId(10010L);
        return batchPaymentInfo;
    }
}
