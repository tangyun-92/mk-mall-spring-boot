package com.tang.mk_mall.model.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

public class CreateOrderReq {

    @NotNull(message = "收货人姓名不能为null")
    @ApiModelProperty(value = "收货人姓名", name = "receiverName", dataType = "String", required = true)
    private String receiverName;

    @NotNull(message = "收货人联系方式不能为null")
    @ApiModelProperty(value = "收货人联系方式", name = "receiverMobile", dataType = "String", required = true)
    private String receiverMobile;

    @NotNull(message = "收货人地址不能为null")
    @ApiModelProperty(value = "收货人地址", name = "receiverAddress", dataType = "String", required = true)
    private String receiverAddress;

    @ApiModelProperty(value = "运费：默认为0，包邮", name = "postage", dataType = "Integer")
    private Integer postage = 0;

    @ApiModelProperty(value = "支付类型：默认为1，在线支付", name = "paymentType", dataType = "Integer")
    private Integer paymentType = 1;

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverMobile() {
        return receiverMobile;
    }

    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public Integer getPostage() {
        return postage;
    }

    public void setPostage(Integer postage) {
        this.postage = postage;
    }

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    @Override
    public String toString() {
        return "CreateOrderReq{" +
                "receiverName='" + receiverName + '\'' +
                ", receiverMobile='" + receiverMobile + '\'' +
                ", receiverAddress='" + receiverAddress + '\'' +
                ", postage=" + postage +
                ", paymentType=" + paymentType +
                '}';
    }
}