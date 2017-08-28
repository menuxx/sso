/*
 * This file is generated by jOOQ.
*/
package com.yingtaohuo.sso.db.tables.records;


import com.yingtaohuo.sso.db.tables.TScene;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record7;
import org.jooq.Row7;
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
public class TSceneRecord extends UpdatableRecordImpl<TSceneRecord> implements Record7<UInteger, String, String, Integer, Integer, Integer, Integer> {

    private static final long serialVersionUID = -745928766;

    /**
     * Setter for <code>menuxx.t_scene.id</code>.
     */
    public TSceneRecord setId(UInteger value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>menuxx.t_scene.id</code>.
     */
    public UInteger getId() {
        return (UInteger) get(0);
    }

    /**
     * Setter for <code>menuxx.t_scene.icon_name</code>. icon名称 (eatin, packages, eatout)
     */
    public TSceneRecord setIconName(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>menuxx.t_scene.icon_name</code>. icon名称 (eatin, packages, eatout)
     */
    public String getIconName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>menuxx.t_scene.tab_name</code>. 按钮名称
     */
    public TSceneRecord setTabName(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>menuxx.t_scene.tab_name</code>. 按钮名称
     */
    public String getTabName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>menuxx.t_scene.tp_id</code>. 功能模板ID（目前 0: 堂食，1：打包，2外卖）
     */
    public TSceneRecord setTpId(Integer value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>menuxx.t_scene.tp_id</code>. 功能模板ID（目前 0: 堂食，1：打包，2外卖）
     */
    public Integer getTpId() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>menuxx.t_scene.sort_num</code>. 排序字段
     */
    public TSceneRecord setSortNum(Integer value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>menuxx.t_scene.sort_num</code>. 排序字段
     */
    public Integer getSortNum() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>menuxx.t_scene.corp_id</code>. 商家ID
     */
    public TSceneRecord setCorpId(Integer value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>menuxx.t_scene.corp_id</code>. 商家ID
     */
    public Integer getCorpId() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>menuxx.t_scene.enable</code>.
     */
    public TSceneRecord setEnable(Integer value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>menuxx.t_scene.enable</code>.
     */
    public Integer getEnable() {
        return (Integer) get(6);
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
    // Record7 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row7<UInteger, String, String, Integer, Integer, Integer, Integer> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row7<UInteger, String, String, Integer, Integer, Integer, Integer> valuesRow() {
        return (Row7) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<UInteger> field1() {
        return TScene.T_SCENE.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return TScene.T_SCENE.ICON_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return TScene.T_SCENE.TAB_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field4() {
        return TScene.T_SCENE.TP_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field5() {
        return TScene.T_SCENE.SORT_NUM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field6() {
        return TScene.T_SCENE.CORP_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field7() {
        return TScene.T_SCENE.ENABLE;
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
        return getIconName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getTabName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value4() {
        return getTpId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value5() {
        return getSortNum();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value6() {
        return getCorpId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value7() {
        return getEnable();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TSceneRecord value1(UInteger value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TSceneRecord value2(String value) {
        setIconName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TSceneRecord value3(String value) {
        setTabName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TSceneRecord value4(Integer value) {
        setTpId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TSceneRecord value5(Integer value) {
        setSortNum(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TSceneRecord value6(Integer value) {
        setCorpId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TSceneRecord value7(Integer value) {
        setEnable(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TSceneRecord values(UInteger value1, String value2, String value3, Integer value4, Integer value5, Integer value6, Integer value7) {
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
     * Create a detached TSceneRecord
     */
    public TSceneRecord() {
        super(TScene.T_SCENE);
    }

    /**
     * Create a detached, initialised TSceneRecord
     */
    public TSceneRecord(UInteger id, String iconName, String tabName, Integer tpId, Integer sortNum, Integer corpId, Integer enable) {
        super(TScene.T_SCENE);

        set(0, id);
        set(1, iconName);
        set(2, tabName);
        set(3, tpId);
        set(4, sortNum);
        set(5, corpId);
        set(6, enable);
    }
}
