package com.pofil.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonInclude;

@Document(collection = "lockerlogs")
public class LockerLog {
	
	@Id
    private String id;
	
    private String lockerId;
    
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date checkednDate;
    
    private String checkedInTime;
    
    private String checkedOutTime;
    
    
    private String lockerHolderName;
    private String lockerStatus;
    private String authorizedPerson;
    private String lockerUsedBy;
    private String custodianA;
    private String custodianB;
    private String lockerExistBranch;
    private String remark;
    private boolean enabled;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLockerId() {
		return lockerId;
	}
	public void setLockerId(String lockerId) {
		this.lockerId = lockerId;
	}
	public Date getCheckednDate() {
		return checkednDate;
	}
	public void setCheckednDate(Date checkednDate) {
		this.checkednDate = checkednDate;
	}

	public String getCheckedInTime() {
		return checkedInTime;
	}
	public void setCheckedInTime(String checkedInTime) {
		this.checkedInTime = checkedInTime;
	}
	public String getCheckedOutTime() {
		return checkedOutTime;
	}
	public void setCheckedOutTime(String checkedOutTime) {
		this.checkedOutTime = checkedOutTime;
	}
	public String getLockerHolderName() {
		return lockerHolderName;
	}
	public void setLockerHolderName(String lockerHolderName) {
		this.lockerHolderName = lockerHolderName;
	}
	public String getLockerStatus() {
		return lockerStatus;
	}
	public void setLockerStatus(String lockerStatus) {
		this.lockerStatus = lockerStatus;
	}
	public String getAuthorizedPerson() {
		return authorizedPerson;
	}
	public void setAuthorizedPerson(String authorizedPerson) {
		this.authorizedPerson = authorizedPerson;
	}
	public String getLockerUsedBy() {
		return lockerUsedBy;
	}
	public void setLockerUsedBy(String lockerUsedBy) {
		this.lockerUsedBy = lockerUsedBy;
	}
	public String getCustodianA() {
		return custodianA;
	}
	public void setCustodianA(String custodianA) {
		this.custodianA = custodianA;
	}
	public String getCustodianB() {
		return custodianB;
	}
	public void setCustodianB(String custodianB) {
		this.custodianB = custodianB;
	}
	public String getLockerExistBranch() {
		return lockerExistBranch;
	}
	public void setLockerExistBranch(String lockerExistBranch) {
		this.lockerExistBranch = lockerExistBranch;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	@Override
	public String toString() {
		return "LockerLog [id=" + id + ", lockerId=" + lockerId + ", checkednDate=" + checkednDate + ", checkedInTime="
				+ checkedInTime + ", checkedOutTime=" + checkedOutTime + ", lockerHolderName=" + lockerHolderName
				+ ", lockerStatus=" + lockerStatus + ", authorizedPerson=" + authorizedPerson + ", lockerUsedBy="
				+ lockerUsedBy + ", custodianA=" + custodianA + ", custodianB=" + custodianB + ", lockerExistBranch="
				+ lockerExistBranch + ", remark=" + remark + ", enabled=" + enabled + "]";
	}


}
