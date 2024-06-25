package com.pofil.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import groovy.transform.ToString;
@ToString
@Document(collection = "insurancecompanys")
public class InsuranceCompany {

    @Id
    private String id;
    private String insCompanyCode;
    private String insCompanyName;
    private String insCompanyType;
    private String remark;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInsCompanyCode() {
        return insCompanyCode;
    }

    public void setInsCompanyCode(String insCompanyCode) {
        this.insCompanyCode = insCompanyCode;
    }

    public String getInsCompanyName() {
        return insCompanyName;
    }

    public void setInsCompanyName(String insCompanyName) {
        this.insCompanyName = insCompanyName;
    }

    public String getInsCompanyType() {
        return insCompanyType;
    }

    public void setInsCompanyType(String insCompanyType) {
        this.insCompanyType = insCompanyType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
