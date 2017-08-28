/*
 * This file is generated by jOOQ.
*/
package com.yingtaohuo.sso.db.tables.records;


import com.yingtaohuo.sso.db.tables.TDeliveryShop;

import java.math.BigDecimal;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record17;
import org.jooq.Row17;
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
public class TDeliveryShopRecord extends UpdatableRecordImpl<TDeliveryShopRecord> implements Record17<UInteger, Integer, String, Integer, String, String, String, String, BigDecimal, BigDecimal, String, String, String, String, String, String, Integer> {

    private static final long serialVersionUID = -2079845820;

    /**
     * Setter for <code>menuxx.t_delivery_shop.id</code>. 店铺id
     */
    public TDeliveryShopRecord setId(UInteger value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>menuxx.t_delivery_shop.id</code>. 店铺id
     */
    public UInteger getId() {
        return (UInteger) get(0);
    }

    /**
     * Setter for <code>menuxx.t_delivery_shop.shop_id</code>. 对应系统t_corp表的id
     */
    public TDeliveryShopRecord setShopId(Integer value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>menuxx.t_delivery_shop.shop_id</code>. 对应系统t_corp表的id
     */
    public Integer getShopId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>menuxx.t_delivery_shop.shop_name</code>. 店铺名称
     */
    public TDeliveryShopRecord setShopName(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>menuxx.t_delivery_shop.shop_name</code>. 店铺名称
     */
    public String getShopName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>menuxx.t_delivery_shop.shop_type</code>. 店铺类型，业务类型(食品小吃-1,饮料-2,鲜花-3,文印票务-8,便利店-9,水果生鲜-13,同城电商-19, 医药-20,蛋糕-21,酒品-24,小商品市场-25,服装-26,汽修零配-27,数码-28,小龙虾-29, 其他-5)
     */
    public TDeliveryShopRecord setShopType(Integer value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>menuxx.t_delivery_shop.shop_type</code>. 店铺类型，业务类型(食品小吃-1,饮料-2,鲜花-3,文印票务-8,便利店-9,水果生鲜-13,同城电商-19, 医药-20,蛋糕-21,酒品-24,小商品市场-25,服装-26,汽修零配-27,数码-28,小龙虾-29, 其他-5)
     */
    public Integer getShopType() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>menuxx.t_delivery_shop.city_name</code>. 所在城市名称(如杭州)
     */
    public TDeliveryShopRecord setCityName(String value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>menuxx.t_delivery_shop.city_name</code>. 所在城市名称(如杭州)
     */
    public String getCityName() {
        return (String) get(4);
    }

    /**
     * Setter for <code>menuxx.t_delivery_shop.dada_city_code</code>. 达达系统城市编码
     */
    public TDeliveryShopRecord setDadaCityCode(String value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>menuxx.t_delivery_shop.dada_city_code</code>. 达达系统城市编码
     */
    public String getDadaCityCode() {
        return (String) get(5);
    }

    /**
     * Setter for <code>menuxx.t_delivery_shop.area_name</code>. 所在区域(如滨江浦沿)
     */
    public TDeliveryShopRecord setAreaName(String value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>menuxx.t_delivery_shop.area_name</code>. 所在区域(如滨江浦沿)
     */
    public String getAreaName() {
        return (String) get(6);
    }

    /**
     * Setter for <code>menuxx.t_delivery_shop.shop_address</code>. 详细地址(通策广场103号)
     */
    public TDeliveryShopRecord setShopAddress(String value) {
        set(7, value);
        return this;
    }

    /**
     * Getter for <code>menuxx.t_delivery_shop.shop_address</code>. 详细地址(通策广场103号)
     */
    public String getShopAddress() {
        return (String) get(7);
    }

    /**
     * Setter for <code>menuxx.t_delivery_shop.lng</code>. 经度（火星坐标）
     */
    public TDeliveryShopRecord setLng(BigDecimal value) {
        set(8, value);
        return this;
    }

    /**
     * Getter for <code>menuxx.t_delivery_shop.lng</code>. 经度（火星坐标）
     */
    public BigDecimal getLng() {
        return (BigDecimal) get(8);
    }

    /**
     * Setter for <code>menuxx.t_delivery_shop.lat</code>. 纬度（火星坐标）
     */
    public TDeliveryShopRecord setLat(BigDecimal value) {
        set(9, value);
        return this;
    }

    /**
     * Getter for <code>menuxx.t_delivery_shop.lat</code>. 纬度（火星坐标）
     */
    public BigDecimal getLat() {
        return (BigDecimal) get(9);
    }

    /**
     * Setter for <code>menuxx.t_delivery_shop.contact_name</code>. 联系人名称
     */
    public TDeliveryShopRecord setContactName(String value) {
        set(10, value);
        return this;
    }

    /**
     * Getter for <code>menuxx.t_delivery_shop.contact_name</code>. 联系人名称
     */
    public String getContactName() {
        return (String) get(10);
    }

    /**
     * Setter for <code>menuxx.t_delivery_shop.contact_phone</code>. 联系人手机
     */
    public TDeliveryShopRecord setContactPhone(String value) {
        set(11, value);
        return this;
    }

    /**
     * Getter for <code>menuxx.t_delivery_shop.contact_phone</code>. 联系人手机
     */
    public String getContactPhone() {
        return (String) get(11);
    }

    /**
     * Setter for <code>menuxx.t_delivery_shop.shop_no</code>. 店铺在配送系统中的编号
     */
    public TDeliveryShopRecord setShopNo(String value) {
        set(12, value);
        return this;
    }

    /**
     * Getter for <code>menuxx.t_delivery_shop.shop_no</code>. 店铺在配送系统中的编号
     */
    public String getShopNo() {
        return (String) get(12);
    }

    /**
     * Setter for <code>menuxx.t_delivery_shop.imdada_username</code>. 达达用户名
     */
    public TDeliveryShopRecord setImdadaUsername(String value) {
        set(13, value);
        return this;
    }

    /**
     * Getter for <code>menuxx.t_delivery_shop.imdada_username</code>. 达达用户名
     */
    public String getImdadaUsername() {
        return (String) get(13);
    }

    /**
     * Setter for <code>menuxx.t_delivery_shop.imdada_password</code>. 达达用户密码
     */
    public TDeliveryShopRecord setImdadaPassword(String value) {
        set(14, value);
        return this;
    }

    /**
     * Getter for <code>menuxx.t_delivery_shop.imdada_password</code>. 达达用户密码
     */
    public String getImdadaPassword() {
        return (String) get(14);
    }

    /**
     * Setter for <code>menuxx.t_delivery_shop.ele_app_id</code>. 饿了么appid
     */
    public TDeliveryShopRecord setEleAppId(String value) {
        set(15, value);
        return this;
    }

    /**
     * Getter for <code>menuxx.t_delivery_shop.ele_app_id</code>. 饿了么appid
     */
    public String getEleAppId() {
        return (String) get(15);
    }

    /**
     * Setter for <code>menuxx.t_delivery_shop.dada_merchant_id</code>. 达达商户id
     */
    public TDeliveryShopRecord setDadaMerchantId(Integer value) {
        set(16, value);
        return this;
    }

    /**
     * Getter for <code>menuxx.t_delivery_shop.dada_merchant_id</code>. 达达商户id
     */
    public Integer getDadaMerchantId() {
        return (Integer) get(16);
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
    // Record17 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row17<UInteger, Integer, String, Integer, String, String, String, String, BigDecimal, BigDecimal, String, String, String, String, String, String, Integer> fieldsRow() {
        return (Row17) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row17<UInteger, Integer, String, Integer, String, String, String, String, BigDecimal, BigDecimal, String, String, String, String, String, String, Integer> valuesRow() {
        return (Row17) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<UInteger> field1() {
        return TDeliveryShop.T_DELIVERY_SHOP.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return TDeliveryShop.T_DELIVERY_SHOP.SHOP_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return TDeliveryShop.T_DELIVERY_SHOP.SHOP_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field4() {
        return TDeliveryShop.T_DELIVERY_SHOP.SHOP_TYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return TDeliveryShop.T_DELIVERY_SHOP.CITY_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return TDeliveryShop.T_DELIVERY_SHOP.DADA_CITY_CODE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return TDeliveryShop.T_DELIVERY_SHOP.AREA_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field8() {
        return TDeliveryShop.T_DELIVERY_SHOP.SHOP_ADDRESS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<BigDecimal> field9() {
        return TDeliveryShop.T_DELIVERY_SHOP.LNG;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<BigDecimal> field10() {
        return TDeliveryShop.T_DELIVERY_SHOP.LAT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field11() {
        return TDeliveryShop.T_DELIVERY_SHOP.CONTACT_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field12() {
        return TDeliveryShop.T_DELIVERY_SHOP.CONTACT_PHONE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field13() {
        return TDeliveryShop.T_DELIVERY_SHOP.SHOP_NO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field14() {
        return TDeliveryShop.T_DELIVERY_SHOP.IMDADA_USERNAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field15() {
        return TDeliveryShop.T_DELIVERY_SHOP.IMDADA_PASSWORD;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field16() {
        return TDeliveryShop.T_DELIVERY_SHOP.ELE_APP_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field17() {
        return TDeliveryShop.T_DELIVERY_SHOP.DADA_MERCHANT_ID;
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
        return getShopId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getShopName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value4() {
        return getShopType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getCityName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getDadaCityCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getAreaName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value8() {
        return getShopAddress();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal value9() {
        return getLng();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal value10() {
        return getLat();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value11() {
        return getContactName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value12() {
        return getContactPhone();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value13() {
        return getShopNo();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value14() {
        return getImdadaUsername();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value15() {
        return getImdadaPassword();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value16() {
        return getEleAppId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value17() {
        return getDadaMerchantId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TDeliveryShopRecord value1(UInteger value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TDeliveryShopRecord value2(Integer value) {
        setShopId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TDeliveryShopRecord value3(String value) {
        setShopName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TDeliveryShopRecord value4(Integer value) {
        setShopType(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TDeliveryShopRecord value5(String value) {
        setCityName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TDeliveryShopRecord value6(String value) {
        setDadaCityCode(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TDeliveryShopRecord value7(String value) {
        setAreaName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TDeliveryShopRecord value8(String value) {
        setShopAddress(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TDeliveryShopRecord value9(BigDecimal value) {
        setLng(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TDeliveryShopRecord value10(BigDecimal value) {
        setLat(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TDeliveryShopRecord value11(String value) {
        setContactName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TDeliveryShopRecord value12(String value) {
        setContactPhone(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TDeliveryShopRecord value13(String value) {
        setShopNo(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TDeliveryShopRecord value14(String value) {
        setImdadaUsername(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TDeliveryShopRecord value15(String value) {
        setImdadaPassword(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TDeliveryShopRecord value16(String value) {
        setEleAppId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TDeliveryShopRecord value17(Integer value) {
        setDadaMerchantId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TDeliveryShopRecord values(UInteger value1, Integer value2, String value3, Integer value4, String value5, String value6, String value7, String value8, BigDecimal value9, BigDecimal value10, String value11, String value12, String value13, String value14, String value15, String value16, Integer value17) {
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
        value11(value11);
        value12(value12);
        value13(value13);
        value14(value14);
        value15(value15);
        value16(value16);
        value17(value17);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TDeliveryShopRecord
     */
    public TDeliveryShopRecord() {
        super(TDeliveryShop.T_DELIVERY_SHOP);
    }

    /**
     * Create a detached, initialised TDeliveryShopRecord
     */
    public TDeliveryShopRecord(UInteger id, Integer shopId, String shopName, Integer shopType, String cityName, String dadaCityCode, String areaName, String shopAddress, BigDecimal lng, BigDecimal lat, String contactName, String contactPhone, String shopNo, String imdadaUsername, String imdadaPassword, String eleAppId, Integer dadaMerchantId) {
        super(TDeliveryShop.T_DELIVERY_SHOP);

        set(0, id);
        set(1, shopId);
        set(2, shopName);
        set(3, shopType);
        set(4, cityName);
        set(5, dadaCityCode);
        set(6, areaName);
        set(7, shopAddress);
        set(8, lng);
        set(9, lat);
        set(10, contactName);
        set(11, contactPhone);
        set(12, shopNo);
        set(13, imdadaUsername);
        set(14, imdadaPassword);
        set(15, eleAppId);
        set(16, dadaMerchantId);
    }
}
