package com.pofil.model;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Document(collection = "minutes")
public class Minutes {
	@Id
	private String id;
	private String minuteTitle;
	
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date meetingsDate;
    
	private String category;
	private String branchName;
	private String fiscalYear;
	private String remarks;
	private String fileLocationUrl;
	
	@CreatedDate
	private Date creationDate = new Date();
	
	@LastModifiedBy
	private String modifiedBy;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	public String getMinuteTitle() {
		return minuteTitle;
	}
	public void setMinuteTitle(String minuteTitle) {
		this.minuteTitle = minuteTitle;
	}

	public Date getMeetingsDate() {
		return meetingsDate;
	}
	public void setMeetingsDate(Date meetingsDate) {
		this.meetingsDate = meetingsDate;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getFiscalYear() {
		return fiscalYear;
	}
	public void setFiscalYear(String fiscalYear) {
		this.fiscalYear = fiscalYear;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getFileLocationUrl() {
		return fileLocationUrl;
	}
	public void setFileLocationUrl(String fileLocationUrl) {
		this.fileLocationUrl = fileLocationUrl;
	}


}
