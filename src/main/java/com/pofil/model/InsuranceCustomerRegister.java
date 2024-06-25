package com.pofil.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import groovy.transform.ToString;

@ToString
@Document(collection = "insurancecustomerRegisters")
public class InsuranceCustomerRegister {

	@Id
	private String id;

	@Indexed(unique = true)
	private String masterPolicyId;

	private String insCompanyName;
	private String insCompanyCode;
	private String insSchemaCode;
	private String insSchemaName;
	private int clientCode;
	private String insSchemaTenure;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date insStartedDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date insEndDate;

	private String bankBranchName;
	private double insuredAmount;
	private double insInstallmentAmount;
	private String insPaymentFrequency;
	private String insStatus;
	private String insMarketedBy;
	private String remarks;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMasterPolicyId() {
		return masterPolicyId;
	}
	public void setMasterPolicyId(String masterPolicyId) {
		this.masterPolicyId = masterPolicyId;
	}
	public String getInsCompanyName() {
		return insCompanyName;
	}
	public void setInsCompanyName(String insCompanyName) {
		this.insCompanyName = insCompanyName;
	}
	public String getInsCompanyCode() {
		return insCompanyCode;
	}
	public void setInsCompanyCode(String insCompanyCode) {
		this.insCompanyCode = insCompanyCode;
	}
	public String getInsSchemaCode() {
		return insSchemaCode;
	}
	public void setInsSchemaCode(String insSchemaCode) {
		this.insSchemaCode = insSchemaCode;
	}
	public String getInsSchemaName() {
		return insSchemaName;
	}
	public void setInsSchemaName(String insSchemaName) {
		this.insSchemaName = insSchemaName;
	}
	public int getClientCode() {
		return clientCode;
	}
	public void setClientCode(int clientCode) {
		this.clientCode = clientCode;
	}
	public String getInsSchemaTenure() {
		return insSchemaTenure;
	}
	public void setInsSchemaTenure(String insSchemaTenure) {
		this.insSchemaTenure = insSchemaTenure;
	}
	public Date getInsStartedDate() {
		return insStartedDate;
	}
	public void setInsStartedDate(Date insStartedDate) {
		this.insStartedDate = insStartedDate;
	}
	public Date getInsEndDate() {
		return insEndDate;
	}
	public void setInsEndDate(Date insEndDate) {
		this.insEndDate = insEndDate;
	}
	public String getBankBranchName() {
		return bankBranchName;
	}
	public void setBankBranchName(String bankBranchName) {
		this.bankBranchName = bankBranchName;
	}
	public double getInsuredAmount() {
		return insuredAmount;
	}
	public void setInsuredAmount(double insuredAmount) {
		this.insuredAmount = insuredAmount;
	}
	public double getInsInstallmentAmount() {
		return insInstallmentAmount;
	}
	public void setInsInstallmentAmount(double insInstallmentAmount) {
		this.insInstallmentAmount = insInstallmentAmount;
	}
	public String getInsPaymentFrequency() {
		return insPaymentFrequency;
	}
	public void setInsPaymentFrequency(String insPaymentFrequency) {
		this.insPaymentFrequency = insPaymentFrequency;
	}
	public String getInsStatus() {
		return insStatus;
	}
	public void setInsStatus(String insStatus) {
		this.insStatus = insStatus;
	}
	public String getInsMarketedBy() {
		return insMarketedBy;
	}
	public void setInsMarketedBy(String insMarketedBy) {
		this.insMarketedBy = insMarketedBy;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
