package com.pofil.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "maintenancelogs")
public class MaintenanceLog {
    @Id
    private String id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date customerAppDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date maintenanceRequestDate;

    private String cardNumber;
    private String oldCardNumber;
    private String accountNumber;
    private String maintenanceRequestFor;
    private String maintenanceRemarks;
    private String branchName;
    private boolean maintenanceStatus;

    private String mlLodgedBy;
    private String mlLodgedModifiedBy;

    public String getId() {
        return id;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCustomerAppDate() {
        return customerAppDate;
    }

    public void setCustomerAppDate(Date customerAppDate) {
        this.customerAppDate = customerAppDate;
    }

    public Date getMaintenanceRequestDate() {
        return maintenanceRequestDate;
    }

    public void setMaintenanceRequestDate(Date maintenanceRequestDate) {
        this.maintenanceRequestDate = maintenanceRequestDate;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getMaintenanceRequestFor() {
        return maintenanceRequestFor;
    }

    public void setMaintenanceRequestFor(String maintenanceRequestFor) {
        this.maintenanceRequestFor = maintenanceRequestFor;
    }

    public String getMaintenanceRemarks() {
        return maintenanceRemarks;
    }

    public void setMaintenanceRemarks(String maintenanceRemarks) {
        this.maintenanceRemarks = maintenanceRemarks;
    }

    public boolean isMaintenanceStatus() {
        return maintenanceStatus;
    }

    public void setMaintenanceStatus(boolean maintenanceStatus) {
        this.maintenanceStatus = maintenanceStatus;
    }

    public String getMlLodgedBy() {
        return mlLodgedBy;
    }

    public void setMlLodgedBy(String mlLodgedBy) {
        this.mlLodgedBy = mlLodgedBy;
    }

    public String getMlLodgedModifiedBy() {
        return mlLodgedModifiedBy;
    }

    public void setMlLodgedModifiedBy(String mlLodgedModifiedBy) {
        this.mlLodgedModifiedBy = mlLodgedModifiedBy;
    }
    public String getOldCardNumber() {
        return oldCardNumber;
    }

    public void setOldCardNumber(String oldCardNumber) {
        this.oldCardNumber = oldCardNumber;
    }
    
    
}