package com.shin.pay.dto;

/**
 * @Author gaoshiliang
 * @Date 15/10/22.
 */
public class PayModelResultDto {
    private String returnCode;
    private String returnMsg;
    private String modelName;
    private String payAmount;
    private String bgUrl;
    private String payTime;

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(String payAmount) {
        this.payAmount = payAmount;
    }

    public String getBgUrl() {
        return bgUrl;
    }

    public void setBgUrl(String bgUrl) {
        this.bgUrl = bgUrl;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PayResultDto{");
        sb.append("returnCode='").append(returnCode).append('\'');
        sb.append(", returnMsg='").append(returnMsg).append('\'');
        sb.append(", modelName='").append(modelName).append('\'');
        sb.append(", payAmount='").append(payAmount).append('\'');
        sb.append(", bgUrl='").append(bgUrl).append('\'');
        sb.append(", payTime='").append(payTime).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
