package com.pofil.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.ToString;

import java.util.Date;
@ToString
@Document(collection = "feedbacks")
public class Feedback {

    @Id
    private String id;
    private String clientCode;
    private String custName;
    private String accountNumber;
    private String mobileNumber;
    private String telNumber;
    private String accountType;
    private String typeOfService;
    private String timeTakenForService;
    private String branchName;
    private String custFeedback;
    private String rating;
    private String collectedBy;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss a")
    private Date date;
    
    @CreatedDate
	private Date creationDate = new Date();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClientCode() {
		return clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getTelNumber() {
		return telNumber;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getTypeOfService() {
		return typeOfService;
	}

	public void setTypeOfService(String typeOfService) {
		this.typeOfService = typeOfService;
	}

	public String getTimeTakenForService() {
		return timeTakenForService;
	}

	public void setTimeTakenForService(String timeTakenForService) {
		this.timeTakenForService = timeTakenForService;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getCustFeedback() {
		return custFeedback;
	}

	public void setCustFeedback(String custFeedback) {
		this.custFeedback = custFeedback;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getCollectedBy() {
		return collectedBy;
	}

	public void setCollectedBy(String collectedBy) {
		this.collectedBy = collectedBy;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
    
}
