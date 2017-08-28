/*
 * This file is generated by jOOQ.
*/
package com.yingtaohuo.sso.db.tables.records;


import com.yingtaohuo.sso.db.tables.TBankAccount;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record6;
import org.jooq.Row6;
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
public class TBankAccountRecord extends UpdatableRecordImpl<TBankAccountRecord> implements Record6<UInteger, Integer, String, String, String, String> {

    private static final long serialVersionUID = 1195560787;

    /**
     * Setter for <code>menuxx.t_bank_account.id</code>.
     */
    public TBankAccountRecord setId(UInteger value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>menuxx.t_bank_account.id</code>.
     */
    public UInteger getId() {
        return (UInteger) get(0);
    }

    /**
     * Setter for <code>menuxx.t_bank_account.corp_id</code>. 商户编号
     */
    public TBankAccountRecord setCorpId(Integer value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>menuxx.t_bank_account.corp_id</code>. 商户编号
     */
    public Integer getCorpId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>menuxx.t_bank_account.account_name</code>. 开户名
     */
    public TBankAccountRecord setAccountName(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>menuxx.t_bank_account.account_name</code>. 开户名
     */
    public String getAccountName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>menuxx.t_bank_account.mobile</code>. 手机号
     */
    public TBankAccountRecord setMobile(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>menuxx.t_bank_account.mobile</code>. 手机号
     */
    public String getMobile() {
        return (String) get(3);
    }

    /**
     * Setter for <code>menuxx.t_bank_account.bank_name</code>. 开户行
     */
    public TBankAccountRecord setBankName(String value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>menuxx.t_bank_account.bank_name</code>. 开户行
     */
    public String getBankName() {
        return (String) get(4);
    }

    /**
     * Setter for <code>menuxx.t_bank_account.account</code>. 卡号
     */
    public TBankAccountRecord setAccount(String value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>menuxx.t_bank_account.account</code>. 卡号
     */
    public String getAccount() {
        return (String) get(5);
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
    // Record6 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row6<UInteger, Integer, String, String, String, String> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row6<UInteger, Integer, String, String, String, String> valuesRow() {
        return (Row6) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<UInteger> field1() {
        return TBankAccount.T_BANK_ACCOUNT.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return TBankAccount.T_BANK_ACCOUNT.CORP_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return TBankAccount.T_BANK_ACCOUNT.ACCOUNT_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return TBankAccount.T_BANK_ACCOUNT.MOBILE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return TBankAccount.T_BANK_ACCOUNT.BANK_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return TBankAccount.T_BANK_ACCOUNT.ACCOUNT;
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
        return getCorpId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getAccountName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getMobile();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getBankName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getAccount();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TBankAccountRecord value1(UInteger value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TBankAccountRecord value2(Integer value) {
        setCorpId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TBankAccountRecord value3(String value) {
        setAccountName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TBankAccountRecord value4(String value) {
        setMobile(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TBankAccountRecord value5(String value) {
        setBankName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TBankAccountRecord value6(String value) {
        setAccount(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TBankAccountRecord values(UInteger value1, Integer value2, String value3, String value4, String value5, String value6) {
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
     * Create a detached TBankAccountRecord
     */
    public TBankAccountRecord() {
        super(TBankAccount.T_BANK_ACCOUNT);
    }

    /**
     * Create a detached, initialised TBankAccountRecord
     */
    public TBankAccountRecord(UInteger id, Integer corpId, String accountName, String mobile, String bankName, String account) {
        super(TBankAccount.T_BANK_ACCOUNT);

        set(0, id);
        set(1, corpId);
        set(2, accountName);
        set(3, mobile);
        set(4, bankName);
        set(5, account);
    }
}
