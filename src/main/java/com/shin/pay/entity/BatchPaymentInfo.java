package com.shin.pay.entity;

import com.shin.pay.annotation.ArithmeticEnum;
import com.shin.pay.annotation.Handler;
import com.shin.pay.annotation.Pair;
import com.shin.pay.annotation.Table;
import com.shin.pay.service.DictionaryService;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author gaoshiliang
 * @Date 15/10/22.
 */
@Handler(pairs = {@Pair(fieldName = "busiTypeId", dicFieldName = DictionaryService.BUSITYPEID,isToSelf = true),
        @Pair(fieldName = "merchantCode", dicFieldName = DictionaryService.MERCHANTCODE,isToSelf = false,targetFieldName ="merchantName")},
        table = @Table(prefix = "pay",column = "userId",arithmetic = ArithmeticEnum.MODE,count = 3))
public class BatchPaymentInfo extends Entity{
    private Long userId;

    private Long batchOrderId;

    private String batchOrderNo;

    private String merchantCode;

    private String merchantName;

    private String busiTypeId;

    private BigDecimal batchAmount;

    private BigDecimal reduceAmount;

    private BigDecimal shouldPayAmount;

    private BigDecimal successAmount;

    private BigDecimal payFailedAmount;

    private BigDecimal rollBackAmount;

    private BigDecimal userPayFeeAmount;

    private Integer status;

    private String payPriority;

    private String currentPriority;

    private Date orderTime;

    private Date createTime;

    private Date updateTime;

    private String qunar_trade_no;

    private String tableName;

    private String transTypeId;

    private String paySequenceNo;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBatchOrderId() {
        return batchOrderId;
    }

    public void setBatchOrderId(Long batchOrderId) {
        this.batchOrderId = batchOrderId;
    }

    public String getBatchOrderNo() {
        return batchOrderNo;
    }

    public void setBatchOrderNo(String batchOrderNo) {
        this.batchOrderNo = batchOrderNo;
    }

    public String getMerchantCode() {
        return merchantCode;
    }

    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
    }

    public String getBusiTypeId() {
        return busiTypeId;
    }

    public void setBusiTypeId(String busiTypeId) {
        this.busiTypeId = busiTypeId;
    }

    public BigDecimal getBatchAmount() {
        return batchAmount;
    }

    public void setBatchAmount(BigDecimal batchAmount) {
        this.batchAmount = batchAmount;
    }

    public BigDecimal getReduceAmount() {
        return reduceAmount;
    }

    public void setReduceAmount(BigDecimal reduceAmount) {
        this.reduceAmount = reduceAmount;
    }

    public BigDecimal getShouldPayAmount() {
        return shouldPayAmount;
    }

    public void setShouldPayAmount(BigDecimal shouldPayAmount) {
        this.shouldPayAmount = shouldPayAmount;
    }

    public BigDecimal getSuccessAmount() {
        return successAmount;
    }

    public void setSuccessAmount(BigDecimal successAmount) {
        this.successAmount = successAmount;
    }

    public BigDecimal getPayFailedAmount() {
        return payFailedAmount;
    }

    public void setPayFailedAmount(BigDecimal payFailedAmount) {
        this.payFailedAmount = payFailedAmount;
    }

    public BigDecimal getRollBackAmount() {
        return rollBackAmount;
    }

    public void setRollBackAmount(BigDecimal rollBackAmount) {
        this.rollBackAmount = rollBackAmount;
    }

    public BigDecimal getUserPayFeeAmount() {
        return userPayFeeAmount;
    }

    public void setUserPayFeeAmount(BigDecimal userPayFeeAmount) {
        this.userPayFeeAmount = userPayFeeAmount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPayPriority() {
        return payPriority;
    }

    public void setPayPriority(String payPriority) {
        this.payPriority = payPriority;
    }

    public String getCurrentPriority() {
        return currentPriority;
    }

    public void setCurrentPriority(String currentPriority) {
        this.currentPriority = currentPriority;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getQunar_trade_no() {
        return qunar_trade_no;
    }

    public void setQunar_trade_no(String qunar_trade_no) {
        this.qunar_trade_no = qunar_trade_no;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTransTypeId() {
        return transTypeId;
    }

    public void setTransTypeId(String transTypeId) {
        this.transTypeId = transTypeId;
    }

    public String getPaySequenceNo() {
        return paySequenceNo;
    }

    public void setPaySequenceNo(String paySequenceNo) {
        this.paySequenceNo = paySequenceNo;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("BatchPaymentInfo{");
        sb.append("userId=").append(userId);
        sb.append(", batchOrderId=").append(batchOrderId);
        sb.append(", batchOrderNo='").append(batchOrderNo).append('\'');
        sb.append(", merchantCode='").append(merchantCode).append('\'');
        sb.append(", merchantName='").append(merchantName).append('\'');
        sb.append(", busiTypeId='").append(busiTypeId).append('\'');
        sb.append(", batchAmount=").append(batchAmount);
        sb.append(", reduceAmount=").append(reduceAmount);
        sb.append(", shouldPayAmount=").append(shouldPayAmount);
        sb.append(", successAmount=").append(successAmount);
        sb.append(", payFailedAmount=").append(payFailedAmount);
        sb.append(", rollBackAmount=").append(rollBackAmount);
        sb.append(", userPayFeeAmount=").append(userPayFeeAmount);
        sb.append(", status=").append(status);
        sb.append(", payPriority='").append(payPriority).append('\'');
        sb.append(", currentPriority='").append(currentPriority).append('\'');
        sb.append(", orderTime=").append(orderTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", qunar_trade_no='").append(qunar_trade_no).append('\'');
        sb.append(", tableName='").append(tableName).append('\'');
        sb.append(", transTypeId='").append(transTypeId).append('\'');
        sb.append(", paySequenceNo='").append(paySequenceNo).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
