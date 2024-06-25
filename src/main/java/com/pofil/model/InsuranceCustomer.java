package com.pofil.model;

import groovy.transform.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@ToString
@Document(collection = "insurancecustomers")
public class InsuranceCustomer {

    @Id
    private String id;
    
    @Indexed(unique = true)
    private int clientCode;
    
    private String bankAccNo;
    private String clientName;
    private String clientEmail;
    private String fatherName;
    private String grandFatherName;
    private String clientMobile;
    private String clientTel;
    private String cCurrentAddress;
    private String cPermanentAddress;
    private String citizenIdNo;
    private String cIdRemarks;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getClientCode() {
        return clientCode;
    }

    public void setClientCode(int clientCode) {
        this.clientCode = clientCode;
    }

    public String getBankAccNo() {
        return bankAccNo;
    }

    public void setBankAccNo(String bankAccNo) {
        this.bankAccNo = bankAccNo;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getGrandFatherName() {
        return grandFatherName;
    }

    public void setGrandFatherName(String grandFatherName) {
        this.grandFatherName = grandFatherName;
    }

    public String getClientMobile() {
        return clientMobile;
    }

    public void setClientMobile(String clientMobile) {
        this.clientMobile = clientMobile;
    }

    public String getClientTel() {
        return clientTel;
    }

    public void setClientTel(String clientTel) {
        this.clientTel = clientTel;
    }

    public String getcCurrentAddress() {
        return cCurrentAddress;
    }

    public void setcCurrentAddress(String cCurrentAddress) {
        this.cCurrentAddress = cCurrentAddress;
    }

    public String getcPermanentAddress() {
        return cPermanentAddress;
    }

    public void setcPermanentAddress(String cPermanentAddress) {
        this.cPermanentAddress = cPermanentAddress;
    }

    public String getCitizenIdNo() {
        return citizenIdNo;
    }

    public void setCitizenIdNo(String citizenIdNo) {
        this.citizenIdNo = citizenIdNo;
    }

    public String getcIdRemarks() {
        return cIdRemarks;
    }

    public void setcIdRemarks(String cIdRemarks) {
        this.cIdRemarks = cIdRemarks;
    }
}
