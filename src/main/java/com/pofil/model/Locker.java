package com.pofil.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "locker")
public class Locker {
	@Id
    private String id;
	
	@Indexed(unique = true)
    private String lockerId;
	
	private String lockerSize;
	private String branchName;
	private String remarks;
	private String lockerStatus;
	private boolean enabled;
	private String keyNo;
	
	
	private String checkLockerVal;
	
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
	public String getCheckLockerVal() {
		return checkLockerVal;
	}
	public void setCheckLockerVal(String checkLockerVal) {
		this.checkLockerVal = checkLockerVal;
	}
	public String getLockerSize() {
		return lockerSize;
	}
	public void setLockerSize(String lockerSize) {
		this.lockerSize = lockerSize;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getLockerStatus() {
		return lockerStatus;
	}
	public void setLockerStatus(String lockerStatus) {
		this.lockerStatus = lockerStatus;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	@Override
	public String toString() {
		return "Locker [id=" + id + ", lockerId=" + lockerId + ", lockerSize=" + lockerSize + ", branchName="
				+ branchName + ", remarks=" + remarks + ", lockerStatus=" + lockerStatus + ", enabled=" + enabled + "]";
	}
	public Locker(String id, String lockerId, String lockerSize, String branchName, String remarks, String lockerStatus,
			boolean enabled) {
		super();
		this.id = id;
		this.lockerId = lockerId;
		this.lockerSize = lockerSize;
		this.branchName = branchName;
		this.remarks = remarks;
		this.lockerStatus = lockerStatus;
		this.enabled = enabled;
	}
	public Locker() {
	}
	public String getKeyNo() {
		return keyNo;
	}
	
	public void setKeyNo(String keyNo) {
		this.keyNo = keyNo;
	}
	
}
