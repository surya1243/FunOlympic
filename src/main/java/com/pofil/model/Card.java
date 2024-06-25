package com.pofil.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Document(collection = "cards")
public class Card {
	@Id
    private String id;
	
	
	@Indexed(unique = true)
    private String accountNumber;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date customerAppDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date requestDate;
	 
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date receivedDate;
    
    private String accountOperation;
    private String accountType;
    private String clientCode;
    private String branchCode;
    private String currency;
    private String fName;
    private String lName;
    private String gender;
    private String maritalStatus;
    private String contactAddress;
    private String mobileNumber;
    private String phoneNumber;
    private String emailAddress;
    private String cardReqOriginatingBranch;
    private String cardStatus;
    private String statusUpdatedDate;
    private String requestRemark;
    private String otherRemarks;
    private String cardNumber;
    private String lodgedEditedBy;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cardExpiryDate;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cardActivatedDate;
    
    private String activationRemarks;
    
    private String lodgedBy;
    private String modifiedBy;
    private String modifiedFinalBy;
    private boolean enabledStatus;
    
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Date getCustomerAppDate() {
		return customerAppDate;
	}
	public void setCustomerAppDate(Date customerAppDate) {
		this.customerAppDate = customerAppDate;
	}
	public Date getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}
	public Date getReceivedDate() {
		return receivedDate;
	}
	public void setReceivedDate(Date receivedDate) {
		this.receivedDate = receivedDate;
	}
	public String getAccountOperation() {
		return accountOperation;
	}
	public void setAccountOperation(String accountOperation) {
		this.accountOperation = accountOperation;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getClientCode() {
		return clientCode;
	}
	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}
	public String getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public String getContactAddress() {
		return contactAddress;
	}
	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getCardReqOriginatingBranch() {
		return cardReqOriginatingBranch;
	}
	public void setCardReqOriginatingBranch(String cardReqOriginatingBranch) {
		this.cardReqOriginatingBranch = cardReqOriginatingBranch;
	}
	public String getCardStatus() {
		return cardStatus;
	}
	public void setCardStatus(String cardStatus) {
		this.cardStatus = cardStatus;
	}
	public String getStatusUpdatedDate() {
		return statusUpdatedDate;
	}
	public void setStatusUpdatedDate(String statusUpdatedDate) {
		this.statusUpdatedDate = statusUpdatedDate;
	}
	public String getRequestRemark() {
		return requestRemark;
	}
	public void setRequestRemark(String requestRemark) {
		this.requestRemark = requestRemark;
	}
	public String getOtherRemarks() {
		return otherRemarks;
	}
	public void setOtherRemarks(String otherRemarks) {
		this.otherRemarks = otherRemarks;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public Date getCardExpiryDate() {
		return cardExpiryDate;
	}
	public void setCardExpiryDate(Date cardExpiryDate) {
		this.cardExpiryDate = cardExpiryDate;
	}
	public Date getCardActivatedDate() {
		return cardActivatedDate;
	}
	public void setCardActivatedDate(Date cardActivatedDate) {
		this.cardActivatedDate = cardActivatedDate;
	}
	public String getActivationRemarks() {
		return activationRemarks;
	}
	public void setActivationRemarks(String activationRemarks) {
		this.activationRemarks = activationRemarks;
	}
	public String getLodgedBy() {
		return lodgedBy;
	}
	public void setLodgedBy(String lodgedBy) {
		this.lodgedBy = lodgedBy;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public boolean isEnabledStatus() {
		return enabledStatus;
	}
	public void setEnabledStatus(boolean enabledStatus) {
		this.enabledStatus = enabledStatus;
	}
	public Card() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Card(String id, String accountNumber, Date customerAppDate, Date requestDate, Date receivedDate,
			String accountOperation, String accountType, String clientCode, String branchCode, String currency,
			String fName, String lName, String gender, String maritalStatus, String contactAddress, String mobileNumber,
			String phoneNumber, String emailAddress, String cardReqOriginatingBranch, String cardStatus,
			String statusUpdatedDate, String requestRemark, String otherRemarks, String cardNumber, Date cardExpiryDate,
			Date cardActivatedDate, String activationRemarks, String lodgedBy, String modifiedBy,
			boolean enabledStatus) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.customerAppDate = customerAppDate;
		this.requestDate = requestDate;
		this.receivedDate = receivedDate;
		this.accountOperation = accountOperation;
		this.accountType = accountType;
		this.clientCode = clientCode;
		this.branchCode = branchCode;
		this.currency = currency;
		this.fName = fName;
		this.lName = lName;
		this.gender = gender;
		this.maritalStatus = maritalStatus;
		this.contactAddress = contactAddress;
		this.mobileNumber = mobileNumber;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.cardReqOriginatingBranch = cardReqOriginatingBranch;
		this.cardStatus = cardStatus;
		this.statusUpdatedDate = statusUpdatedDate;
		this.requestRemark = requestRemark;
		this.otherRemarks = otherRemarks;
		this.cardNumber = cardNumber;
		this.cardExpiryDate = cardExpiryDate;
		this.cardActivatedDate = cardActivatedDate;
		this.activationRemarks = activationRemarks;
		this.lodgedBy = lodgedBy;
		this.modifiedBy = modifiedBy;
		this.enabledStatus = enabledStatus;
	}
	public String getModifiedFinalBy() {
		return modifiedFinalBy;
	}
	public void setModifiedFinalBy(String modifiedFinalBy) {
		this.modifiedFinalBy = modifiedFinalBy;
	}
	public String getLodgedEditedBy() {
		return lodgedEditedBy;
	}
	public void setLodgedEditedBy(String lodgedEditedBy) {
		this.lodgedEditedBy = lodgedEditedBy;
	}
	
    
    
}
