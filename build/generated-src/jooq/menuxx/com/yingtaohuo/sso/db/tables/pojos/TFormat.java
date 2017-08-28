/*
 * This file is generated by jOOQ.
*/
package com.yingtaohuo.sso.db.tables.pojos;


import java.io.Serializable;

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
public class TFormat implements Serializable {

    private static final long serialVersionUID = -1827130483;

    private final UInteger id;
    private final Integer  corpId;
    private final String   format;
    private final Integer  sortId;

    public TFormat(TFormat value) {
        this.id = value.id;
        this.corpId = value.corpId;
        this.format = value.format;
        this.sortId = value.sortId;
    }

    public TFormat(
        UInteger id,
        Integer  corpId,
        String   format,
        Integer  sortId
    ) {
        this.id = id;
        this.corpId = corpId;
        this.format = format;
        this.sortId = sortId;
    }

    public UInteger getId() {
        return this.id;
    }

    public Integer getCorpId() {
        return this.corpId;
    }

    public String getFormat() {
        return this.format;
    }

    public Integer getSortId() {
        return this.sortId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("TFormat (");

        sb.append(id);
        sb.append(", ").append(corpId);
        sb.append(", ").append(format);
        sb.append(", ").append(sortId);

        sb.append(")");
        return sb.toString();
    }
}
