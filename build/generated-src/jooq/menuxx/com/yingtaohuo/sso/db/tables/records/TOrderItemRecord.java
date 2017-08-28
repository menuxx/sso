/*
 * This file is generated by jOOQ.
*/
package com.yingtaohuo.sso.db.tables.records;


import com.yingtaohuo.sso.db.tables.TOrderItem;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record7;
import org.jooq.Row7;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * 订单产品列表
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TOrderItemRecord extends UpdatableRecordImpl<TOrderItemRecord> implements Record7<Integer, Integer, Integer, Integer, Integer, Timestamp, Integer> {

    private static final long serialVersionUID = 1731525428;

    /**
     * Setter for <code>menuxx.t_order_item.id</code>.
     */
    public TOrderItemRecord setId(Integer value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>menuxx.t_order_item.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>menuxx.t_order_item.order_id</code>. 订单编号
     */
    public TOrderItemRecord setOrderId(Integer value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>menuxx.t_order_item.order_id</code>. 订单编号
     */
    public Integer getOrderId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>menuxx.t_order_item.item_id</code>. 产品编号
     */
    public TOrderItemRecord setItemId(Integer value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>menuxx.t_order_item.item_id</code>. 产品编号
     */
    public Integer getItemId() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>menuxx.t_order_item.quantity</code>. 数量
     */
    public TOrderItemRecord setQuantity(Integer value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>menuxx.t_order_item.quantity</code>. 数量
     */
    public Integer getQuantity() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>menuxx.t_order_item.pay_amount</code>.
     */
    public TOrderItemRecord setPayAmount(Integer value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>menuxx.t_order_item.pay_amount</code>.
     */
    public Integer getPayAmount() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>menuxx.t_order_item.create_time</code>. 创建时间
     */
    public TOrderItemRecord setCreateTime(Timestamp value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>menuxx.t_order_item.create_time</code>. 创建时间
     */
    public Timestamp getCreateTime() {
        return (Timestamp) get(5);
    }

    /**
     * Setter for <code>menuxx.t_order_item.deal_price</code>. 成交价格
     */
    public TOrderItemRecord setDealPrice(Integer value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>menuxx.t_order_item.deal_price</code>. 成交价格
     */
    public Integer getDealPrice() {
        return (Integer) get(6);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record7 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row7<Integer, Integer, Integer, Integer, Integer, Timestamp, Integer> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row7<Integer, Integer, Integer, Integer, Integer, Timestamp, Integer> valuesRow() {
        return (Row7) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return TOrderItem.T_ORDER_ITEM.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return TOrderItem.T_ORDER_ITEM.ORDER_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return TOrderItem.T_ORDER_ITEM.ITEM_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field4() {
        return TOrderItem.T_ORDER_ITEM.QUANTITY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field5() {
        return TOrderItem.T_ORDER_ITEM.PAY_AMOUNT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field6() {
        return TOrderItem.T_ORDER_ITEM.CREATE_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field7() {
        return TOrderItem.T_ORDER_ITEM.DEAL_PRICE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value2() {
        return getOrderId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value3() {
        return getItemId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value4() {
        return getQuantity();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value5() {
        return getPayAmount();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value6() {
        return getCreateTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value7() {
        return getDealPrice();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TOrderItemRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TOrderItemRecord value2(Integer value) {
        setOrderId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TOrderItemRecord value3(Integer value) {
        setItemId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TOrderItemRecord value4(Integer value) {
        setQuantity(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TOrderItemRecord value5(Integer value) {
        setPayAmount(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TOrderItemRecord value6(Timestamp value) {
        setCreateTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TOrderItemRecord value7(Integer value) {
        setDealPrice(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TOrderItemRecord values(Integer value1, Integer value2, Integer value3, Integer value4, Integer value5, Timestamp value6, Integer value7) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TOrderItemRecord
     */
    public TOrderItemRecord() {
        super(TOrderItem.T_ORDER_ITEM);
    }

    /**
     * Create a detached, initialised TOrderItemRecord
     */
    public TOrderItemRecord(Integer id, Integer orderId, Integer itemId, Integer quantity, Integer payAmount, Timestamp createTime, Integer dealPrice) {
        super(TOrderItem.T_ORDER_ITEM);

        set(0, id);
        set(1, orderId);
        set(2, itemId);
        set(3, quantity);
        set(4, payAmount);
        set(5, createTime);
        set(6, dealPrice);
    }
}
