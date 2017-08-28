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
public class TDadaMerchant implements Serializable {

    private static final long serialVersionUID = -928068980;

    private final UInteger id;
    private final String   mobile;
    private final String   cityName;
    private final String   enterpriseName;
    private final String   enterpriseAddress;
    private final String   contactName;
    private final String   contactPhone;
    private final String   email;
    private final String   sourceId;

    public TDadaMerchant(TDadaMerchant value) {
        this.id = value.id;
        this.mobile = value.mobile;
        this.cityName = value.cityName;
        this.enterpriseName = value.enterpriseName;
        this.enterpriseAddress = value.enterpriseAddress;
        this.contactName = value.contactName;
        this.contactPhone = value.contactPhone;
        this.email = value.email;
        this.sourceId = value.sourceId;
    }

    public TDadaMerchant(
        UInteger id,
        String   mobile,
        String   cityName,
        String   enterpriseName,
        String   enterpriseAddress,
        String   contactName,
        String   contactPhone,
        String   email,
        String   sourceId
    ) {
        this.id = id;
        this.mobile = mobile;
        this.cityName = cityName;
        this.enterpriseName = enterpriseName;
        this.enterpriseAddress = enterpriseAddress;
        this.contactName = contactName;
        this.contactPhone = contactPhone;
        this.email = email;
        this.sourceId = sourceId;
    }

    public UInteger getId() {
        return this.id;
    }

    public String getMobile() {
        return this.mobile;
    }

    public String getCityName() {
        return this.cityName;
    }

    public String getEnterpriseName() {
        return this.enterpriseName;
    }

    public String getEnterpriseAddress() {
        return this.enterpriseAddress;
    }

    public String getContactName() {
        return this.contactName;
    }

    public String getContactPhone() {
        return this.contactPhone;
    }

    public String getEmail() {
        return this.email;
    }

    public String getSourceId() {
        return this.sourceId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("TDadaMerchant (");

        sb.append(id);
        sb.append(", ").append(mobile);
        sb.append(", ").append(cityName);
        sb.append(", ").append(enterpriseName);
        sb.append(", ").append(enterpriseAddress);
        sb.append(", ").append(contactName);
        sb.append(", ").append(contactPhone);
        sb.append(", ").append(email);
        sb.append(", ").append(sourceId);

        sb.append(")");
        return sb.toString();
    }
}
