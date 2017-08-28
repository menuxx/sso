/*
 * This file is generated by jOOQ.
*/
package com.yingtaohuo.sso.db.tables.pojos;


import java.io.Serializable;
import java.sql.Timestamp;

import javax.annotation.Generated;


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
public class TCategory implements Serializable {

    private static final long serialVersionUID = 1917158255;

    private final Integer   id;
    private final Integer   corpId;
    private final String    categoryName;
    private final String    categoryIcon;
    private final Integer   sortId;
    private final Timestamp createTime;

    public TCategory(TCategory value) {
        this.id = value.id;
        this.corpId = value.corpId;
        this.categoryName = value.categoryName;
        this.categoryIcon = value.categoryIcon;
        this.sortId = value.sortId;
        this.createTime = value.createTime;
    }

    public TCategory(
        Integer   id,
        Integer   corpId,
        String    categoryName,
        String    categoryIcon,
        Integer   sortId,
        Timestamp createTime
    ) {
        this.id = id;
        this.corpId = corpId;
        this.categoryName = categoryName;
        this.categoryIcon = categoryIcon;
        this.sortId = sortId;
        this.createTime = createTime;
    }

    public Integer getId() {
        return this.id;
    }

    public Integer getCorpId() {
        return this.corpId;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public String getCategoryIcon() {
        return this.categoryIcon;
    }

    public Integer getSortId() {
        return this.sortId;
    }

    public Timestamp getCreateTime() {
        return this.createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("TCategory (");

        sb.append(id);
        sb.append(", ").append(corpId);
        sb.append(", ").append(categoryName);
        sb.append(", ").append(categoryIcon);
        sb.append(", ").append(sortId);
        sb.append(", ").append(createTime);

        sb.append(")");
        return sb.toString();
    }
}
