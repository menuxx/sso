package com.yingtaohuo.model;

import java.util.Date;

public class OrderModel {

    private Integer id;

    private Integer userId;

    private Integer corpId;

    private String orderCode;

    private Integer status;

    private Integer orderType;

    private Integer payType;

    private Integer tableId;

    private Integer addressId;

    private Integer queueId;

    private Integer totalAmount;

    private Integer payAmount;

    private Integer prePayAmount;

    private Integer packageAmount;

    private Integer deliveryAmount;

    private String remark;

    private String applyActivities;

    private Integer couponId;

    private Integer orderTimes;

    private Integer transportStatus;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCorpId() {
        return corpId;
    }

    public void setCorpId(Integer corpId) {
        this.corpId = corpId;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode == null ? null : orderCode.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Integer getQueueId() {
        return queueId;
    }

    public void setQueueId(Integer queueId) {
        this.queueId = queueId;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Integer payAmount) {
        this.payAmount = payAmount;
    }

    public Integer getPrePayAmount() {
        return prePayAmount;
    }

    public void setPrePayAmount(Integer prePayAmount) {
        this.prePayAmount = prePayAmount;
    }

    public Integer getPackageAmount() {
        return packageAmount;
    }

    public void setPackageAmount(Integer packageAmount) {
        this.packageAmount = packageAmount;
    }

    public Integer getDeliveryAmount() {
        return deliveryAmount;
    }

    public void setDeliveryAmount(Integer deliveryAmount) {
        this.deliveryAmount = deliveryAmount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getApplyActivities() {
        return applyActivities;
    }

    public void setApplyActivities(String applyActivities) {
        this.applyActivities = applyActivities == null ? null : applyActivities.trim();
    }

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    public Integer getOrderTimes() {
        return orderTimes;
    }

    public void setOrderTimes(Integer orderTimes) {
        this.orderTimes = orderTimes;
    }

    public Integer getTransportStatus() {
        return transportStatus;
    }

    public void setTransportStatus(Integer transportStatus) {
        this.transportStatus = transportStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}