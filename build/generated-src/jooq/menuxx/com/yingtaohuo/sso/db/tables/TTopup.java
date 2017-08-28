/*
 * This file is generated by jOOQ.
*/
package com.yingtaohuo.sso.db.tables;


import com.yingtaohuo.sso.db.Keys;
import com.yingtaohuo.sso.db.Menuxx;
import com.yingtaohuo.sso.db.tables.records.TTopupRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;
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
public class TTopup extends TableImpl<TTopupRecord> {

    private static final long serialVersionUID = -6697225;

    /**
     * The reference instance of <code>menuxx.t_topup</code>
     */
    public static final TTopup T_TOPUP = new TTopup();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TTopupRecord> getRecordType() {
        return TTopupRecord.class;
    }

    /**
     * The column <code>menuxx.t_topup.id</code>.
     */
    public final TableField<TTopupRecord, UInteger> ID = createField("id", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>menuxx.t_topup.corp_id</code>. 商家编号
     */
    public final TableField<TTopupRecord, Integer> CORP_ID = createField("corp_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "商家编号");

    /**
     * The column <code>menuxx.t_topup.recharge_amount</code>. 充值金额
     */
    public final TableField<TTopupRecord, Integer> RECHARGE_AMOUNT = createField("recharge_amount", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "充值金额");

    /**
     * The column <code>menuxx.t_topup.gift_amount</code>. 赠送金额
     */
    public final TableField<TTopupRecord, Integer> GIFT_AMOUNT = createField("gift_amount", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "赠送金额");

    /**
     * The column <code>menuxx.t_topup.content</code>. 描述
     */
    public final TableField<TTopupRecord, String> CONTENT = createField("content", org.jooq.impl.SQLDataType.VARCHAR.length(100), this, "描述");

    /**
     * Create a <code>menuxx.t_topup</code> table reference
     */
    public TTopup() {
        this("t_topup", null);
    }

    /**
     * Create an aliased <code>menuxx.t_topup</code> table reference
     */
    public TTopup(String alias) {
        this(alias, T_TOPUP);
    }

    private TTopup(String alias, Table<TTopupRecord> aliased) {
        this(alias, aliased, null);
    }

    private TTopup(String alias, Table<TTopupRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Menuxx.MENUXX;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<TTopupRecord, UInteger> getIdentity() {
        return Keys.IDENTITY_T_TOPUP;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<TTopupRecord> getPrimaryKey() {
        return Keys.KEY_T_TOPUP_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<TTopupRecord>> getKeys() {
        return Arrays.<UniqueKey<TTopupRecord>>asList(Keys.KEY_T_TOPUP_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TTopup as(String alias) {
        return new TTopup(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public TTopup rename(String name) {
        return new TTopup(name, null);
    }
}
