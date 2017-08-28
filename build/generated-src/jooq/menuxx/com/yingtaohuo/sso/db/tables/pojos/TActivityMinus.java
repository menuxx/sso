/*
 * This file is generated by jOOQ.
*/
package com.yingtaohuo.sso.db.tables.pojos;


import java.io.Serializable;
import java.sql.Timestamp;

import javax.annotation.Generated;

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
public class TActivityMinus implements Serializable {

    private static final long serialVersionUID = 430127372;

    private final UInteger  id;
    private final UInteger  activityId;
    private final String    descText;
    private final Integer   toup;
    private final Integer   cutback;
    private final Timestamp createTime;
    private final Integer   enable;

    public TActivityMinus(TActivityMinus value) {
        this.id = value.id;
        this.activityId = value.activityId;
        this.descText = value.descText;
        this.toup = value.toup;
        this.cutback = value.cutback;
        this.createTime = value.createTime;
        this.enable = value.enable;
    }

    public TActivityMinus(
        UInteger  id,
        UInteger  activityId,
        String    descText,
        Integer   toup,
        Integer   cutback,
        Timestamp createTime,
        Integer   enable
    ) {
        this.id = id;
        this.activityId = activityId;
        this.descText = descText;
        this.toup = toup;
        this.cutback = cutback;
        this.createTime = createTime;
        this.enable = enable;
    }

    public UInteger getId() {
        return this.id;
    }

    public UInteger getActivityId() {
        return this.activityId;
    }

    public String getDescText() {
        return this.descText;
    }

    public Integer getToup() {
        return this.toup;
    }

    public Integer getCutback() {
        return this.cutback;
    }

    public Timestamp getCreateTime() {
        return this.createTime;
    }

    public Integer getEnable() {
        return this.enable;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("TActivityMinus (");

        sb.append(id);
        sb.append(", ").append(activityId);
        sb.append(", ").append(descText);
        sb.append(", ").append(toup);
        sb.append(", ").append(cutback);
        sb.append(", ").append(createTime);
        sb.append(", ").append(enable);

        sb.append(")");
        return sb.toString();
    }
}
