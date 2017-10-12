package com.yingtaohuo.model;

public class ShopConfigModel {
    private Integer id;

    private Integer vipRecharge;

    private String alterOrderText;

    private String noticeText;

    private String businessTimeline;

    private Integer deliveryChannel;

    private Integer deliveryFee;

    private Integer deliveryNofeeLimit;

    private Integer deliveryPackFee;

    private Integer transportAuto3rd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVipRecharge() {
        return vipRecharge;
    }

    public void setVipRecharge(Integer vipRecharge) {
        this.vipRecharge = vipRecharge;
    }

    public String getAlterOrderText() {
        return alterOrderText;
    }

    public void setAlterOrderText(String alterOrderText) {
        this.alterOrderText = alterOrderText == null ? null : alterOrderText.trim();
    }

    public String getNoticeText() {
        return noticeText;
    }

    public void setNoticeText(String noticeText) {
        this.noticeText = noticeText == null ? null : noticeText.trim();
    }

    public String getBusinessTimeline() {
        return businessTimeline;
    }

    public void setBusinessTimeline(String businessTimeline) {
        this.businessTimeline = businessTimeline == null ? null : businessTimeline.trim();
    }

    public Integer getDeliveryChannel() {
        return deliveryChannel;
    }

    public void setDeliveryChannel(Integer deliveryChannel) {
        this.deliveryChannel = deliveryChannel;
    }

    public Integer getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(Integer deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public Integer getDeliveryNofeeLimit() {
        return deliveryNofeeLimit;
    }

    public void setDeliveryNofeeLimit(Integer deliveryNofeeLimit) {
        this.deliveryNofeeLimit = deliveryNofeeLimit;
    }

    public Integer getDeliveryPackFee() {
        return deliveryPackFee;
    }

    public void setDeliveryPackFee(Integer deliveryPackFee) {
        this.deliveryPackFee = deliveryPackFee;
    }

    public Integer getTransportAuto3rd() {
        return transportAuto3rd;
    }

    public void setTransportAuto3rd(Integer transportAuto3rd) {
        this.transportAuto3rd = transportAuto3rd;
    }
}