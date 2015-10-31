package com.shin.pay.entity;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

/**
 * @Author gaoshiliang
 * @Date 15/10/22.
 */
public class PayInfo {
    private Long id;
    private Long orderInfoId;
    private String busiTypeId;
    private String merchantCode;
    private String orderNo;
    private Double amount;
    private Date orderTime;
    private String fzData;
    private String tppCode;
    private String bankCode;
    private String curId;
    private String pageRetUrl;
    private String bgRetUrl;
    private String userIp;
    private String reserve;
    private String payId;

    //状态：0：创建支付请求；1：支付待分账；2：支付完成已分账；3：支付失败；4:支付撤销
    private Integer status;
    private String errCode;
    private String errMessage;
    private Double payAmount;
    private Date payTime;

    private String userId;
    private BigDecimal tradeFee;

    private String pmCode;
    private String openFlag;
    private Integer groupFlag;
    private String transStep;
    private Date createTime;
    private Date updateTime;
    private Long parentOrderInfoId;
    private Integer oldStatus[];//为满足更新条件而加的字段,没有对应的数据库字段

    private String foreignCurId;
    private Long batchPaymentId;
    private String payMode;
    private Integer collection; // 1:代收，0：非代收
    private String payChannel;

    private String qunar_trade_no; // 交易唯一号   做到b2bpay的时候加的   网关交互用的是payinfo

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderInfoId() {
        return orderInfoId;
    }

    public void setOrderInfoId(Long orderInfoId) {
        this.orderInfoId = orderInfoId;
    }

    public String getBusiTypeId() {
        return busiTypeId;
    }

    public void setBusiTypeId(String busiTypeId) {
        this.busiTypeId = busiTypeId;
    }

    public String getMerchantCode() {
        return merchantCode;
    }

    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getFzData() {
        return fzData;
    }

    public void setFzData(String fzData) {
        this.fzData = fzData;
    }

    public String getTppCode() {
        return tppCode;
    }

    public void setTppCode(String tppCode) {
        this.tppCode = tppCode;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getCurId() {
        return curId;
    }

    public void setCurId(String curId) {
        this.curId = curId;
    }

    public String getPageRetUrl() {
        return pageRetUrl;
    }

    public void setPageRetUrl(String pageRetUrl) {
        this.pageRetUrl = pageRetUrl;
    }

    public String getBgRetUrl() {
        return bgRetUrl;
    }

    public void setBgRetUrl(String bgRetUrl) {
        this.bgRetUrl = bgRetUrl;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    public String getReserve() {
        return reserve;
    }

    public void setReserve(String reserve) {
        this.reserve = reserve;
    }

    public String getPayId() {
        return payId;
    }

    public void setPayId(String payId) {
        this.payId = payId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }

    public Double getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Double payAmount) {
        this.payAmount = payAmount;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public BigDecimal getTradeFee() {
        return tradeFee;
    }

    public void setTradeFee(BigDecimal tradeFee) {
        this.tradeFee = tradeFee;
    }

    public String getPmCode() {
        return pmCode;
    }

    public void setPmCode(String pmCode) {
        this.pmCode = pmCode;
    }

    public String getOpenFlag() {
        return openFlag;
    }

    public void setOpenFlag(String openFlag) {
        this.openFlag = openFlag;
    }

    public Integer getGroupFlag() {
        return groupFlag;
    }

    public void setGroupFlag(Integer groupFlag) {
        this.groupFlag = groupFlag;
    }

    public String getTransStep() {
        return transStep;
    }

    public void setTransStep(String transStep) {
        this.transStep = transStep;
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

    public Long getParentOrderInfoId() {
        return parentOrderInfoId;
    }

    public void setParentOrderInfoId(Long parentOrderInfoId) {
        this.parentOrderInfoId = parentOrderInfoId;
    }

    public Integer[] getOldStatus() {
        return oldStatus;
    }

    public void setOldStatus(Integer[] oldStatus) {
        this.oldStatus = oldStatus;
    }

    public String getForeignCurId() {
        return foreignCurId;
    }

    public void setForeignCurId(String foreignCurId) {
        this.foreignCurId = foreignCurId;
    }

    public Long getBatchPaymentId() {
        return batchPaymentId;
    }

    public void setBatchPaymentId(Long batchPaymentId) {
        this.batchPaymentId = batchPaymentId;
    }

    public String getPayMode() {
        return payMode;
    }

    public void setPayMode(String payMode) {
        this.payMode = payMode;
    }

    public Integer getCollection() {
        return collection;
    }

    public void setCollection(Integer collection) {
        this.collection = collection;
    }

    public String getPayChannel() {
        return payChannel;
    }

    public void setPayChannel(String payChannel) {
        this.payChannel = payChannel;
    }

    public String getQunar_trade_no() {
        return qunar_trade_no;
    }

    public void setQunar_trade_no(String qunar_trade_no) {
        this.qunar_trade_no = qunar_trade_no;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PayInfo{");
        sb.append("id=").append(id);
        sb.append(", orderInfoId=").append(orderInfoId);
        sb.append(", busiTypeId='").append(busiTypeId).append('\'');
        sb.append(", merchantCode='").append(merchantCode).append('\'');
        sb.append(", orderNo='").append(orderNo).append('\'');
        sb.append(", amount=").append(amount);
        sb.append(", orderTime=").append(orderTime);
        sb.append(", fzData='").append(fzData).append('\'');
        sb.append(", tppCode='").append(tppCode).append('\'');
        sb.append(", bankCode='").append(bankCode).append('\'');
        sb.append(", curId='").append(curId).append('\'');
        sb.append(", pageRetUrl='").append(pageRetUrl).append('\'');
        sb.append(", bgRetUrl='").append(bgRetUrl).append('\'');
        sb.append(", userIp='").append(userIp).append('\'');
        sb.append(", reserve='").append(reserve).append('\'');
        sb.append(", payId='").append(payId).append('\'');
        sb.append(", status=").append(status);
        sb.append(", errCode='").append(errCode).append('\'');
        sb.append(", errMessage='").append(errMessage).append('\'');
        sb.append(", payAmount=").append(payAmount);
        sb.append(", payTime=").append(payTime);
        sb.append(", userId='").append(userId).append('\'');
        sb.append(", tradeFee=").append(tradeFee);
        sb.append(", pmCode='").append(pmCode).append('\'');
        sb.append(", openFlag='").append(openFlag).append('\'');
        sb.append(", groupFlag=").append(groupFlag);
        sb.append(", transStep='").append(transStep).append('\'');
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", parentOrderInfoId=").append(parentOrderInfoId);
        sb.append(", oldStatus=").append(oldStatus == null ? "null" : Arrays.asList(oldStatus).toString());
        sb.append(", foreignCurId='").append(foreignCurId).append('\'');
        sb.append(", batchPaymentId=").append(batchPaymentId);
        sb.append(", payMode='").append(payMode).append('\'');
        sb.append(", collection=").append(collection);
        sb.append(", payChannel='").append(payChannel).append('\'');
        sb.append(", qunar_trade_no='").append(qunar_trade_no).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
