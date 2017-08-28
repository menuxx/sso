/*
 * This file is generated by jOOQ.
*/
package com.yingtaohuo.sso.db.tables;


import com.yingtaohuo.sso.db.Keys;
import com.yingtaohuo.sso.db.Menuxx;
import com.yingtaohuo.sso.db.tables.records.TActivityNewuserRecord;

import java.sql.Timestamp;
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
public class TActivityNewuser extends TableImpl<TActivityNewuserRecord> {

    private static final long serialVersionUID = 2094480618;

    /**
     * The reference instance of <code>menuxx.t_activity_newuser</code>
     */
    public static final TActivityNewuser T_ACTIVITY_NEWUSER = new TActivityNewuser();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TActivityNewuserRecord> getRecordType() {
        return TActivityNewuserRecord.class;
    }

    /**
     * The column <code>menuxx.t_activity_newuser.id</code>.
     */
    public final TableField<TActivityNewuserRecord, UInteger> ID = createField("id", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>menuxx.t_activity_newuser.activity_id</code>. 对应的活动id
     */
    public final TableField<TActivityNewuserRecord, Integer> ACTIVITY_ID = createField("activity_id", org.jooq.impl.SQLDataType.INTEGER, this, "对应的活动id");

    /**
     * The column <code>menuxx.t_activity_newuser.desc_text</code>. 描述字段
     */
    public final TableField<TActivityNewuserRecord, String> DESC_TEXT = createField("desc_text", org.jooq.impl.SQLDataType.VARCHAR.length(200), this, "描述字段");

    /**
     * The column <code>menuxx.t_activity_newuser.discount</code>. 折扣
     */
    public final TableField<TActivityNewuserRecord, Double> DISCOUNT = createField("discount", org.jooq.impl.SQLDataType.FLOAT, this, "折扣");

    /**
     * The column <code>menuxx.t_activity_newuser.toup</code>. 满
     */
    public final TableField<TActivityNewuserRecord, Integer> TOUP = createField("toup", org.jooq.impl.SQLDataType.INTEGER, this, "满");

    /**
     * The column <code>menuxx.t_activity_newuser.cutback</code>. 减
     */
    public final TableField<TActivityNewuserRecord, Integer> CUTBACK = createField("cutback", org.jooq.impl.SQLDataType.INTEGER, this, "减");

    /**
     * The column <code>menuxx.t_activity_newuser.create_time</code>. 创建时间
     */
    public final TableField<TActivityNewuserRecord, Timestamp> CREATE_TIME = createField("create_time", org.jooq.impl.SQLDataType.TIMESTAMP.defaultValue(org.jooq.impl.DSL.inline("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "创建时间");

    /**
     * The column <code>menuxx.t_activity_newuser.enable</code>. 是否启用
     */
    public final TableField<TActivityNewuserRecord, Integer> ENABLE = createField("enable", org.jooq.impl.SQLDataType.INTEGER, this, "是否启用");

    /**
     * Create a <code>menuxx.t_activity_newuser</code> table reference
     */
    public TActivityNewuser() {
        this("t_activity_newuser", null);
    }

    /**
     * Create an aliased <code>menuxx.t_activity_newuser</code> table reference
     */
    public TActivityNewuser(String alias) {
        this(alias, T_ACTIVITY_NEWUSER);
    }

    private TActivityNewuser(String alias, Table<TActivityNewuserRecord> aliased) {
        this(alias, aliased, null);
    }

    private TActivityNewuser(String alias, Table<TActivityNewuserRecord> aliased, Field<?>[] parameters) {
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
    public Identity<TActivityNewuserRecord, UInteger> getIdentity() {
        return Keys.IDENTITY_T_ACTIVITY_NEWUSER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<TActivityNewuserRecord> getPrimaryKey() {
        return Keys.KEY_T_ACTIVITY_NEWUSER_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<TActivityNewuserRecord>> getKeys() {
        return Arrays.<UniqueKey<TActivityNewuserRecord>>asList(Keys.KEY_T_ACTIVITY_NEWUSER_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TActivityNewuser as(String alias) {
        return new TActivityNewuser(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public TActivityNewuser rename(String name) {
        return new TActivityNewuser(name, null);
    }
}
