package com.pofil.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import groovy.transform.ToString;

@ToString
@Document(collection = "errorIssueLogs")
public class ErrorIssueLog {
	
    @Id
    private String id;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss a")
    private Date incidentValueDate;
    
    private String branchName;
    private String departmentUnit;
    private String transactionId;
    private double transactionAmount;
    private String trxnEnteredBy;
    private String trxnApprovedBy;
    private String natureOfError;
    private String errorDetail;
    private String reportedBy;
    private String causeOfError;
    private String stepsToAddressError;
    private String resolutionDetail;
    private String resolutionApprovalGivenBy;
    private String progressStatus;
    private String errorLodgedBy;
    private String errorLodgedModifiedBy;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss a")
    private Date resolvedDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getIncidentValueDate() {
		return incidentValueDate;
	}

	public void setIncidentValueDate(Date incidentValueDate) {
		this.incidentValueDate = incidentValueDate;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getDepartmentUnit() {
		return departmentUnit;
	}

	public void setDepartmentUnit(String departmentUnit) {
		this.departmentUnit = departmentUnit;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getTrxnEnteredBy() {
		return trxnEnteredBy;
	}

	public void setTrxnEnteredBy(String trxnEnteredBy) {
		this.trxnEnteredBy = trxnEnteredBy;
	}

	public String getTrxnApprovedBy() {
		return trxnApprovedBy;
	}

	public void setTrxnApprovedBy(String trxnApprovedBy) {
		this.trxnApprovedBy = trxnApprovedBy;
	}

	public String getNatureOfError() {
		return natureOfError;
	}

	public void setNatureOfError(String natureOfError) {
		this.natureOfError = natureOfError;
	}

	public String getErrorDetail() {
		return errorDetail;
	}

	public void setErrorDetail(String errorDetail) {
		this.errorDetail = errorDetail;
	}

	public String getReportedBy() {
		return reportedBy;
	}

	public void setReportedBy(String reportedBy) {
		this.reportedBy = reportedBy;
	}

	public String getCauseOfError() {
		return causeOfError;
	}

	public void setCauseOfError(String causeOfError) {
		this.causeOfError = causeOfError;
	}

	public String getStepsToAddressError() {
		return stepsToAddressError;
	}

	public void setStepsToAddressError(String stepsToAddressError) {
		this.stepsToAddressError = stepsToAddressError;
	}

	public String getResolutionDetail() {
		return resolutionDetail;
	}

	public void setResolutionDetail(String resolutionDetail) {
		this.resolutionDetail = resolutionDetail;
	}

	public String getResolutionApprovalGivenBy() {
		return resolutionApprovalGivenBy;
	}

	public void setResolutionApprovalGivenBy(String resolutionApprovalGivenBy) {
		this.resolutionApprovalGivenBy = resolutionApprovalGivenBy;
	}

	public String getProgressStatus() {
		return progressStatus;
	}

	public void setProgressStatus(String progressStatus) {
		this.progressStatus = progressStatus;
	}

	public String getErrorLodgedBy() {
		return errorLodgedBy;
	}

	public void setErrorLodgedBy(String errorLodgedBy) {
		this.errorLodgedBy = errorLodgedBy;
	}

	public String getErrorLodgedModifiedBy() {
		return errorLodgedModifiedBy;
	}

	public void setErrorLodgedModifiedBy(String errorLodgedModifiedBy) {
		this.errorLodgedModifiedBy = errorLodgedModifiedBy;
	}

	public Date getResolvedDate() {
		return resolvedDate;
	}

	public void setResolvedDate(Date resolvedDate) {
		this.resolvedDate = resolvedDate;
	}

	@Override
	public String toString() {
		return "ErrorIssueLog [id=" + id + ", incidentValueDate=" + incidentValueDate + ", branchName=" + branchName
				+ ", departmentUnit=" + departmentUnit + ", transactionId=" + transactionId + ", transactionAmount="
				+ transactionAmount + ", trxnEnteredBy=" + trxnEnteredBy + ", trxnApprovedBy=" + trxnApprovedBy
				+ ", natureOfError=" + natureOfError + ", errorDetail=" + errorDetail + ", reportedBy=" + reportedBy
				+ ", causeOfError=" + causeOfError + ", stepsToAddressError=" + stepsToAddressError
				+ ", resolutionDetail=" + resolutionDetail + ", resolutionApprovalGivenBy=" + resolutionApprovalGivenBy
				+ ", progressStatus=" + progressStatus + ", errorLodgedBy=" + errorLodgedBy + ", errorLodgedModifiedBy="
				+ errorLodgedModifiedBy + ", resolvedDate=" + resolvedDate + ", getId()=" + getId()
				+ ", getIncidentValueDate()=" + getIncidentValueDate() + ", getBranchName()=" + getBranchName()
				+ ", getDepartmentUnit()=" + getDepartmentUnit() + ", getTransactionId()=" + getTransactionId()
				+ ", getTransactionAmount()=" + getTransactionAmount() + ", getTrxnEnteredBy()=" + getTrxnEnteredBy()
				+ ", getTrxnApprovedBy()=" + getTrxnApprovedBy() + ", getNatureOfError()=" + getNatureOfError()
				+ ", getErrorDetail()=" + getErrorDetail() + ", getReportedBy()=" + getReportedBy()
				+ ", getCauseOfError()=" + getCauseOfError() + ", getStepsToAddressError()=" + getStepsToAddressError()
				+ ", getResolutionDetail()=" + getResolutionDetail() + ", getResolutionApprovalGivenBy()="
				+ getResolutionApprovalGivenBy() + ", getProgressStatus()=" + getProgressStatus()
				+ ", getErrorLodgedBy()=" + getErrorLodgedBy() + ", getErrorLodgedModifiedBy()="
				+ getErrorLodgedModifiedBy() + ", getResolvedDate()=" + getResolvedDate() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
    

}
