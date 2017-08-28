/*
 * This file is generated by jOOQ.
*/
package com.yingtaohuo.sso.db.tables.records;


import com.yingtaohuo.sso.db.tables.TActivity;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record10;
import org.jooq.Row10;
import org.jooq.impl.UpdatableRecordImpl;
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
public class TActivityRecord extends UpdatableRecordImpl<TActivityRecord> implements Record10<UInteger, Integer, Timestamp, Timestamp, Integer, Integer, Integer, Integer, String, String> {

    private static final long serialVersionUID = -1098291151;

    /**
     * Setter for <code>menuxx.t_activity.id</code>.
     */
    public TActivityRecord setId(UInteger value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>menuxx.t_activity.id</code>.
     */
    public UInteger getId() {
        return (UInteger) get(0);
    }

    /**
     * Setter for <code>menuxx.t_activity.type</code>. 1, 满减活动，2，拉新活动
     */
    public TActivityRecord setType(Integer value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>menuxx.t_activity.type</code>. 1, 满减活动，2，拉新活动
     */
    public Integer getType() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>menuxx.t_activity.start_time</code>. 活动开始时间
     */
    public TActivityRecord setStartTime(Timestamp value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>menuxx.t_activity.start_time</code>. 活动开始时间
     */
    public Timestamp getStartTime() {
        return (Timestamp) get(2);
    }

    /**
     * Setter for <code>menuxx.t_activity.end_time</code>. 活动结束时间
     */
    public TActivityRecord setEndTime(Timestamp value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>menuxx.t_activity.end_time</code>. 活动结束时间
     */
    public Timestamp getEndTime() {
        return (Timestamp) get(3);
    }

    /**
     * Setter for <code>menuxx.t_activity.corp_id</code>. 活动店铺id
     */
    public TActivityRecord setCorpId(Integer value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>menuxx.t_activity.corp_id</code>. 活动店铺id
     */
    public Integer getCorpId() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>menuxx.t_activity.status</code>. 0, 为未激活， 1，为已激活
     */
    public TActivityRecord setStatus(Integer value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>menuxx.t_activity.status</code>. 0, 为未激活， 1，为已激活
     */
    public Integer getStatus() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>menuxx.t_activity.share_calc</code>. 是否能与其他活动兼容
     */
    public TActivityRecord setShareCalc(Integer value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>menuxx.t_activity.share_calc</code>. 是否能与其他活动兼容
     */
    public Integer getShareCalc() {
        return (Integer) get(6);
    }

    /**
     * Setter for <code>menuxx.t_activity.weight</code>. 当发生不兼容共享时，计算权重发挥作用。计算权重越高，首先参与计算
     */
    public TActivityRecord setWeight(Integer value) {
        set(7, value);
        return this;
    }

    /**
     * Getter for <code>menuxx.t_activity.weight</code>. 当发生不兼容共享时，计算权重发挥作用。计算权重越高，首先参与计算
     */
    public Integer getWeight() {
        return (Integer) get(7);
    }

    /**
     * Setter for <code>menuxx.t_activity.icon_name</code>. icon图标
     */
    public TActivityRecord setIconName(String value) {
        set(8, value);
        return this;
    }

    /**
     * Getter for <code>menuxx.t_activity.icon_name</code>. icon图标
     */
    public String getIconName() {
        return (String) get(8);
    }

    /**
     * Setter for <code>menuxx.t_activity.desc_text</code>.
     */
    public TActivityRecord setDescText(String value) {
        set(9, value);
        return this;
    }

    /**
     * Getter for <code>menuxx.t_activity.desc_text</code>.
     */
    public String getDescText() {
        return (String) get(9);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<UInteger> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record10 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row10<UInteger, Integer, Timestamp, Timestamp, Integer, Integer, Integer, Integer, String, String> fieldsRow() {
        return (Row10) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row10<UInteger, Integer, Timestamp, Timestamp, Integer, Integer, Integer, Integer, String, String> valuesRow() {
        return (Row10) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<UInteger> field1() {
        return TActivity.T_ACTIVITY.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return TActivity.T_ACTIVITY.TYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field3() {
        return TActivity.T_ACTIVITY.START_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field4() {
        return TActivity.T_ACTIVITY.END_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field5() {
        return TActivity.T_ACTIVITY.CORP_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field6() {
        return TActivity.T_ACTIVITY.STATUS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field7() {
        return TActivity.T_ACTIVITY.SHARE_CALC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field8() {
        return TActivity.T_ACTIVITY.WEIGHT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field9() {
        return TActivity.T_ACTIVITY.ICON_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field10() {
        return TActivity.T_ACTIVITY.DESC_TEXT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UInteger value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value2() {
        return getType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value3() {
        return getStartTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value4() {
        return getEndTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value5() {
        return getCorpId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value6() {
        return getStatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value7() {
        return getShareCalc();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value8() {
        return getWeight();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value9() {
        return getIconName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value10() {
        return getDescText();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TActivityRecord value1(UInteger value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TActivityRecord value2(Integer value) {
        setType(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TActivityRecord value3(Timestamp value) {
        setStartTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TActivityRecord value4(Timestamp value) {
        setEndTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TActivityRecord value5(Integer value) {
        setCorpId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TActivityRecord value6(Integer value) {
        setStatus(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TActivityRecord value7(Integer value) {
        setShareCalc(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TActivityRecord value8(Integer value) {
        setWeight(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TActivityRecord value9(String value) {
        setIconName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TActivityRecord value10(String value) {
        setDescText(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TActivityRecord values(UInteger value1, Integer value2, Timestamp value3, Timestamp value4, Integer value5, Integer value6, Integer value7, Integer value8, String value9, String value10) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TActivityRecord
     */
    public TActivityRecord() {
        super(TActivity.T_ACTIVITY);
    }

    /**
     * Create a detached, initialised TActivityRecord
     */
    public TActivityRecord(UInteger id, Integer type, Timestamp startTime, Timestamp endTime, Integer corpId, Integer status, Integer shareCalc, Integer weight, String iconName, String descText) {
        super(TActivity.T_ACTIVITY);

        set(0, id);
        set(1, type);
        set(2, startTime);
        set(3, endTime);
        set(4, corpId);
        set(5, status);
        set(6, shareCalc);
        set(7, weight);
        set(8, iconName);
        set(9, descText);
    }
}
