/*
 * This file is generated by jOOQ.
*/
package com.yingtaohuo.sso.db.tables.pojos;


import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.types.UByte;
import org.jooq.types.UInteger;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TDeliveryTransport implements Serializable {

    private static final long serialVersionUID = 1331145969;

    private final UInteger   id;
    private final Integer    shopId;
    private final String     orderNo;
    private final UInteger   transportChannel;
    private final String     receiverAddress;
    private final String     receiverName;
    private final String     receiverTel;
    private final BigDecimal receiverLat;
    private final BigDecimal receiverLng;
    private final UInteger   status;
    private final UInteger   orderTotalAmount;
    private final Double     orderWeight;
    private final String     orderRemark;
    private final String     goodsRemark;
    private final UInteger   goodsCount;
    private final UByte      isInvoiced;
    private final String     invoice;
    private final Timestamp  requireReceiveTime;
    private final UInteger   transportFee;
    private final Integer    transportTips;
    private final Long       transportDistance;
    private final Timestamp  createTime;
    private final String     cancelReason;
    private final String     errorMsg;
    private final Timestamp  updateTime;
    private final String     transporterName;
    private final String     transporterTel;
    private final String     transporterNo;
    private final Timestamp  acceptTime;
    private final Timestamp  finishTime;
    private final Timestamp  fetchTime;
    private final Timestamp  cancelTime;
    private final Timestamp  expireTime;
    private final Timestamp  resendTime;

    public TDeliveryTransport(TDeliveryTransport value) {
        this.id = value.id;
        this.shopId = value.shopId;
        this.orderNo = value.orderNo;
        this.transportChannel = value.transportChannel;
        this.receiverAddress = value.receiverAddress;
        this.receiverName = value.receiverName;
        this.receiverTel = value.receiverTel;
        this.receiverLat = value.receiverLat;
        this.receiverLng = value.receiverLng;
        this.status = value.status;
        this.orderTotalAmount = value.orderTotalAmount;
        this.orderWeight = value.orderWeight;
        this.orderRemark = value.orderRemark;
        this.goodsRemark = value.goodsRemark;
        this.goodsCount = value.goodsCount;
        this.isInvoiced = value.isInvoiced;
        this.invoice = value.invoice;
        this.requireReceiveTime = value.requireReceiveTime;
        this.transportFee = value.transportFee;
        this.transportTips = value.transportTips;
        this.transportDistance = value.transportDistance;
        this.createTime = value.createTime;
        this.cancelReason = value.cancelReason;
        this.errorMsg = value.errorMsg;
        this.updateTime = value.updateTime;
        this.transporterName = value.transporterName;
        this.transporterTel = value.transporterTel;
        this.transporterNo = value.transporterNo;
        this.acceptTime = value.acceptTime;
        this.finishTime = value.finishTime;
        this.fetchTime = value.fetchTime;
        this.cancelTime = value.cancelTime;
        this.expireTime = value.expireTime;
        this.resendTime = value.resendTime;
    }

    public TDeliveryTransport(
        UInteger   id,
        Integer    shopId,
        String     orderNo,
        UInteger   transportChannel,
        String     receiverAddress,
        String     receiverName,
        String     receiverTel,
        BigDecimal receiverLat,
        BigDecimal receiverLng,
        UInteger   status,
        UInteger   orderTotalAmount,
        Double     orderWeight,
        String     orderRemark,
        String     goodsRemark,
        UInteger   goodsCount,
        UByte      isInvoiced,
        String     invoice,
        Timestamp  requireReceiveTime,
        UInteger   transportFee,
        Integer    transportTips,
        Long       transportDistance,
        Timestamp  createTime,
        String     cancelReason,
        String     errorMsg,
        Timestamp  updateTime,
        String     transporterName,
        String     transporterTel,
        String     transporterNo,
        Timestamp  acceptTime,
        Timestamp  finishTime,
        Timestamp  fetchTime,
        Timestamp  cancelTime,
        Timestamp  expireTime,
        Timestamp  resendTime
    ) {
        this.id = id;
        this.shopId = shopId;
        this.orderNo = orderNo;
        this.transportChannel = transportChannel;
        this.receiverAddress = receiverAddress;
        this.receiverName = receiverName;
        this.receiverTel = receiverTel;
        this.receiverLat = receiverLat;
        this.receiverLng = receiverLng;
        this.status = status;
        this.orderTotalAmount = orderTotalAmount;
        this.orderWeight = orderWeight;
        this.orderRemark = orderRemark;
        this.goodsRemark = goodsRemark;
        this.goodsCount = goodsCount;
        this.isInvoiced = isInvoiced;
        this.invoice = invoice;
        this.requireReceiveTime = requireReceiveTime;
        this.transportFee = transportFee;
        this.transportTips = transportTips;
        this.transportDistance = transportDistance;
        this.createTime = createTime;
        this.cancelReason = cancelReason;
        this.errorMsg = errorMsg;
        this.updateTime = updateTime;
        this.transporterName = transporterName;
        this.transporterTel = transporterTel;
        this.transporterNo = transporterNo;
        this.acceptTime = acceptTime;
        this.finishTime = finishTime;
        this.fetchTime = fetchTime;
        this.cancelTime = cancelTime;
        this.expireTime = expireTime;
        this.resendTime = resendTime;
    }

    public UInteger getId() {
        return this.id;
    }

    public Integer getShopId() {
        return this.shopId;
    }

    public String getOrderNo() {
        return this.orderNo;
    }

    public UInteger getTransportChannel() {
        return this.transportChannel;
    }

    public String getReceiverAddress() {
        return this.receiverAddress;
    }

    public String getReceiverName() {
        return this.receiverName;
    }

    public String getReceiverTel() {
        return this.receiverTel;
    }

    public BigDecimal getReceiverLat() {
        return this.receiverLat;
    }

    public BigDecimal getReceiverLng() {
        return this.receiverLng;
    }

    public UInteger getStatus() {
        return this.status;
    }

    public UInteger getOrderTotalAmount() {
        return this.orderTotalAmount;
    }

    public Double getOrderWeight() {
        return this.orderWeight;
    }

    public String getOrderRemark() {
        return this.orderRemark;
    }

    public String getGoodsRemark() {
        return this.goodsRemark;
    }

    public UInteger getGoodsCount() {
        return this.goodsCount;
    }

    public UByte getIsInvoiced() {
        return this.isInvoiced;
    }

    public String getInvoice() {
        return this.invoice;
    }

    public Timestamp getRequireReceiveTime() {
        return this.requireReceiveTime;
    }

    public UInteger getTransportFee() {
        return this.transportFee;
    }

    public Integer getTransportTips() {
        return this.transportTips;
    }

    public Long getTransportDistance() {
        return this.transportDistance;
    }

    public Timestamp getCreateTime() {
        return this.createTime;
    }

    public String getCancelReason() {
        return this.cancelReason;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public Timestamp getUpdateTime() {
        return this.updateTime;
    }

    public String getTransporterName() {
        return this.transporterName;
    }

    public String getTransporterTel() {
        return this.transporterTel;
    }

    public String getTransporterNo() {
        return this.transporterNo;
    }

    public Timestamp getAcceptTime() {
        return this.acceptTime;
    }

    public Timestamp getFinishTime() {
        return this.finishTime;
    }

    public Timestamp getFetchTime() {
        return this.fetchTime;
    }

    public Timestamp getCancelTime() {
        return this.cancelTime;
    }

    public Timestamp getExpireTime() {
        return this.expireTime;
    }

    public Timestamp getResendTime() {
        return this.resendTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("TDeliveryTransport (");

        sb.append(id);
        sb.append(", ").append(shopId);
        sb.append(", ").append(orderNo);
        sb.append(", ").append(transportChannel);
        sb.append(", ").append(receiverAddress);
        sb.append(", ").append(receiverName);
        sb.append(", ").append(receiverTel);
        sb.append(", ").append(receiverLat);
        sb.append(", ").append(receiverLng);
        sb.append(", ").append(status);
        sb.append(", ").append(orderTotalAmount);
        sb.append(", ").append(orderWeight);
        sb.append(", ").append(orderRemark);
        sb.append(", ").append(goodsRemark);
        sb.append(", ").append(goodsCount);
        sb.append(", ").append(isInvoiced);
        sb.append(", ").append(invoice);
        sb.append(", ").append(requireReceiveTime);
        sb.append(", ").append(transportFee);
        sb.append(", ").append(transportTips);
        sb.append(", ").append(transportDistance);
        sb.append(", ").append(createTime);
        sb.append(", ").append(cancelReason);
        sb.append(", ").append(errorMsg);
        sb.append(", ").append(updateTime);
        sb.append(", ").append(transporterName);
        sb.append(", ").append(transporterTel);
        sb.append(", ").append(transporterNo);
        sb.append(", ").append(acceptTime);
        sb.append(", ").append(finishTime);
        sb.append(", ").append(fetchTime);
        sb.append(", ").append(cancelTime);
        sb.append(", ").append(expireTime);
        sb.append(", ").append(resendTime);

        sb.append(")");
        return sb.toString();
    }
}
