package com.pofil.model;

import java.util.Date;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Document(collection = "managercheques")
public class ManagerCheque {

	@Id
	private String id;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date issueDate;

	private String branchName;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date chequeDate;

	private String partiesName;
	private String amount;
	private String purposeOfPayment;
	private String systemInputBy;
	private String systemApprovedBy;
	private String mcStatus;
	
	private String mcLodgedBy;
	private String mcLodgedModifiedBy;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date paidCancelDate;
	private String cIdRemarks;

	@CreatedDate
	public Date createdDate;

	@LastModifiedDate
	private Date lastModifiedDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public Date getChequeDate() {
		return chequeDate;
	}

	public void setChequeDate(Date chequeDate) {
		this.chequeDate = chequeDate;
	}

	public String getPartiesName() {
		return partiesName;
	}

	public void setPartiesName(String partiesName) {
		this.partiesName = partiesName;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getPurposeOfPayment() {
		return purposeOfPayment;
	}

	public void setPurposeOfPayment(String purposeOfPayment) {
		this.purposeOfPayment = purposeOfPayment;
	}

	public String getSystemInputBy() {
		return systemInputBy;
	}

	public void setSystemInputBy(String systemInputBy) {
		this.systemInputBy = systemInputBy;
	}

	public String getSystemApprovedBy() {
		return systemApprovedBy;
	}

	public void setSystemApprovedBy(String systemApprovedBy) {
		this.systemApprovedBy = systemApprovedBy;
	}

	public String getMcStatus() {
		return mcStatus;
	}

	public void setMcStatus(String mcStatus) {
		this.mcStatus = mcStatus;
	}

	public Date getPaidCancelDate() {
		return paidCancelDate;
	}

	public void setPaidCancelDate(Date paidCancelDate) {
		this.paidCancelDate = paidCancelDate;
	}

	public String getcIdRemarks() {
		return cIdRemarks;
	}

	public void setcIdRemarks(String cIdRemarks) {
		this.cIdRemarks = cIdRemarks;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getMcLodgedBy() {
		return mcLodgedBy;
	}

	public void setMcLodgedBy(String mcLodgedBy) {
		this.mcLodgedBy = mcLodgedBy;
	}

	public String getMcLodgedModifiedBy() {
		return mcLodgedModifiedBy;
	}

	public void setMcLodgedModifiedBy(String mcLodgedModifiedBy) {
		this.mcLodgedModifiedBy = mcLodgedModifiedBy;
	}

}
