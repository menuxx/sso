/*
 * This file is generated by jOOQ.
*/
package com.yingtaohuo.sso.db.tables.records;


import com.yingtaohuo.sso.db.tables.TConfig;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
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
public class TConfigRecord extends UpdatableRecordImpl<TConfigRecord> implements Record5<UInteger, String, String, Integer, String> {

    private static final long serialVersionUID = -2134165412;

    /**
     * Setter for <code>menuxx.t_config.id</code>.
     */
    public TConfigRecord setId(UInteger value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>menuxx.t_config.id</code>.
     */
    public UInteger getId() {
        return (UInteger) get(0);
    }

    /**
     * Setter for <code>menuxx.t_config.name</code>. 配置名
     */
    public TConfigRecord setName(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>menuxx.t_config.name</code>. 配置名
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>menuxx.t_config.value</code>. 配置值 0 关闭，1 启用
     */
    public TConfigRecord setValue(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>menuxx.t_config.value</code>. 配置值 0 关闭，1 启用
     */
    public String getValue() {
        return (String) get(2);
    }

    /**
     * Setter for <code>menuxx.t_config.corp_id</code>. 商家ID
     */
    public TConfigRecord setCorpId(Integer value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>menuxx.t_config.corp_id</code>. 商家ID
     */
    public Integer getCorpId() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>menuxx.t_config.remark</code>. 配置说明
     */
    public TConfigRecord setRemark(String value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>menuxx.t_config.remark</code>. 配置说明
     */
    public String getRemark() {
        return (String) get(4);
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
    // Record5 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<UInteger, String, String, Integer, String> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<UInteger, String, String, Integer, String> valuesRow() {
        return (Row5) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<UInteger> field1() {
        return TConfig.T_CONFIG.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return TConfig.T_CONFIG.NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return TConfig.T_CONFIG.VALUE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field4() {
        return TConfig.T_CONFIG.CORP_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return TConfig.T_CONFIG.REMARK;
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
    public String value2() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value4() {
        return getCorpId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getRemark();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TConfigRecord value1(UInteger value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TConfigRecord value2(String value) {
        setName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TConfigRecord value3(String value) {
        setValue(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TConfigRecord value4(Integer value) {
        setCorpId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TConfigRecord value5(String value) {
        setRemark(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TConfigRecord values(UInteger value1, String value2, String value3, Integer value4, String value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TConfigRecord
     */
    public TConfigRecord() {
        super(TConfig.T_CONFIG);
    }

    /**
     * Create a detached, initialised TConfigRecord
     */
    public TConfigRecord(UInteger id, String name, String value, Integer corpId, String remark) {
        super(TConfig.T_CONFIG);

        set(0, id);
        set(1, name);
        set(2, value);
        set(3, corpId);
        set(4, remark);
    }
}
