package com.shin.pay.controller;

import com.shin.pay.dto.BatchPaymentRequestDTO;
import com.shin.pay.facade.PaymentFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;


/**
 * @Author gaoshiliang
 * @Date 15/10/23.
 */
public class CashierPayController extends BaseCashierController {

    @Autowired
    private PaymentFacade paymentFacade;

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {

        //1、获取并验证参数
        Map<String, String> paramsMap = getParameterMap(request);

        //2、封装接口请求参数
        BatchPaymentRequestDTO requestDTO = new BatchPaymentRequestDTO();

        //3、查询所要支付的订单（幂等）

        //4、变价校验

        //5、支付处理
        if (paramsMap.get("payModel").equals("ebank")){
            this.doEbankPay(requestDTO);
        }else {
            this.doUnEbankPay(requestDTO);

        }

        //6、支付重试

        //7、支付后处理

        return null;
    }


    private void doEbankPay(BatchPaymentRequestDTO requestDTO){
        paymentFacade.submitEbankPay(requestDTO);

    }

    private void doUnEbankPay(BatchPaymentRequestDTO requestDTO){
        paymentFacade.submitUnEbankPay(requestDTO);
    }
}
