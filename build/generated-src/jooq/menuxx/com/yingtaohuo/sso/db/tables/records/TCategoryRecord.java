/*
 * This file is generated by jOOQ.
*/
package com.yingtaohuo.sso.db.tables.records;


import com.yingtaohuo.sso.db.tables.TCategory;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record6;
import org.jooq.Row6;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * 产品分类表
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TCategoryRecord extends UpdatableRecordImpl<TCategoryRecord> implements Record6<Integer, Integer, String, String, Integer, Timestamp> {

    private static final long serialVersionUID = -1892670654;

    /**
     * Setter for <code>menuxx.t_category.id</code>.
     */
    public TCategoryRecord setId(Integer value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>menuxx.t_category.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>menuxx.t_category.corp_id</code>. 商家编号
     */
    public TCategoryRecord setCorpId(Integer value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>menuxx.t_category.corp_id</code>. 商家编号
     */
    public Integer getCorpId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>menuxx.t_category.category_name</code>. 分类名称
     */
    public TCategoryRecord setCategoryName(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>menuxx.t_category.category_name</code>. 分类名称
     */
    public String getCategoryName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>menuxx.t_category.category_icon</code>.
     */
    public TCategoryRecord setCategoryIcon(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>menuxx.t_category.category_icon</code>.
     */
    public String getCategoryIcon() {
        return (String) get(3);
    }

    /**
     * Setter for <code>menuxx.t_category.sort_id</code>. 排序号
     */
    public TCategoryRecord setSortId(Integer value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>menuxx.t_category.sort_id</code>. 排序号
     */
    public Integer getSortId() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>menuxx.t_category.create_time</code>. 创建时间
     */
    public TCategoryRecord setCreateTime(Timestamp value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>menuxx.t_category.create_time</code>. 创建时间
     */
    public Timestamp getCreateTime() {
        return (Timestamp) get(5);
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
    // Record6 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row6<Integer, Integer, String, String, Integer, Timestamp> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row6<Integer, Integer, String, String, Integer, Timestamp> valuesRow() {
        return (Row6) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return TCategory.T_CATEGORY.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return TCategory.T_CATEGORY.CORP_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return TCategory.T_CATEGORY.CATEGORY_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return TCategory.T_CATEGORY.CATEGORY_ICON;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field5() {
        return TCategory.T_CATEGORY.SORT_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field6() {
        return TCategory.T_CATEGORY.CREATE_TIME;
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
        return getCorpId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getCategoryName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getCategoryIcon();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value5() {
        return getSortId();
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
    public TCategoryRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TCategoryRecord value2(Integer value) {
        setCorpId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TCategoryRecord value3(String value) {
        setCategoryName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TCategoryRecord value4(String value) {
        setCategoryIcon(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TCategoryRecord value5(Integer value) {
        setSortId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TCategoryRecord value6(Timestamp value) {
        setCreateTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TCategoryRecord values(Integer value1, Integer value2, String value3, String value4, Integer value5, Timestamp value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TCategoryRecord
     */
    public TCategoryRecord() {
        super(TCategory.T_CATEGORY);
    }

    /**
     * Create a detached, initialised TCategoryRecord
     */
    public TCategoryRecord(Integer id, Integer corpId, String categoryName, String categoryIcon, Integer sortId, Timestamp createTime) {
        super(TCategory.T_CATEGORY);

        set(0, id);
        set(1, corpId);
        set(2, categoryName);
        set(3, categoryIcon);
        set(4, sortId);
        set(5, createTime);
    }
}
