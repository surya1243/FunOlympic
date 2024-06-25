package com.pofil.model;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;


@Document(collection = "customerLocker")
public class CustomerLocker {
	@Id
    private String id;
	
	private String lockerId;
	
	private String lockerSize;	
	
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date openedDate;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date expirationDate;
    
    
	private String lockerHolderName;	
	private String holderIdentDetail;	
	private String accountNumber;	
	private String holderAddress;	
	private String holderMobile;	
	private String holderTelephone;	
	private String lockerStatus;
	
	
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date statusEffDate;
    
	private String branchName;	
	private String statusRemark;	
	private String beneficName;	
	private String beneficDetail;	
	private String beneficAddress;	
	private String beneficMobile;	
	private String beneficTelephone;
	private String refundDeposit;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date refundDepositDate;
	
	
	private String refundAnnualFee;	
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date refundAnnualFeeDate;	
	
	private String waiverRemark;	
	
	@DateTimeFormat(pattern = "MM-dd")
	private Date standingInstDate;
	
	private String authorizedPerson;	
	private String authIdentificationDetail;	
	private String authAddress;	
	private String authMobile;	
	private String authTelephone;	
	private String authRemark;	
	private String lockerFile;
	private String checkLockerVal;
	
	private String[] albums;
	
	private boolean isDeleted;
	private boolean enabled;
	
	
	
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public boolean isDeleted() {
		return isDeleted;
	}
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
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
	public Date getOpenedDate() {
		return openedDate;
	}
	public void setOpenedDate(Date openedDate) {
		this.openedDate = openedDate;
	}
	public Date getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	public String getLockerHolderName() {
		return lockerHolderName;
	}
	public void setLockerHolderName(String lockerHolderName) {
		this.lockerHolderName = lockerHolderName;
	}
	public String getHolderIdentDetail() {
		return holderIdentDetail;
	}
	public void setHolderIdentDetail(String holderIdentDetail) {
		this.holderIdentDetail = holderIdentDetail;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getHolderAddress() {
		return holderAddress;
	}
	public void setHolderAddress(String holderAddress) {
		this.holderAddress = holderAddress;
	}
	public String getHolderMobile() {
		return holderMobile;
	}
	public void setHolderMobile(String holderMobile) {
		this.holderMobile = holderMobile;
	}
	public String getHolderTelephone() {
		return holderTelephone;
	}
	public void setHolderTelephone(String holderTelephone) {
		this.holderTelephone = holderTelephone;
	}
	public String getLockerStatus() {
		return lockerStatus;
	}
	public void setLockerStatus(String lockerStatus) {
		this.lockerStatus = lockerStatus;
	}
	public Date getStatusEffDate() {
		return statusEffDate;
	}
	public void setStatusEffDate(Date statusEffDate) {
		this.statusEffDate = statusEffDate;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getStatusRemark() {
		return statusRemark;
	}
	public void setStatusRemark(String statusRemark) {
		this.statusRemark = statusRemark;
	}
	public String getBeneficName() {
		return beneficName;
	}
	public void setBeneficName(String beneficName) {
		this.beneficName = beneficName;
	}
	public String getBeneficDetail() {
		return beneficDetail;
	}
	public void setBeneficDetail(String beneficDetail) {
		this.beneficDetail = beneficDetail;
	}
	public String getBeneficAddress() {
		return beneficAddress;
	}
	public void setBeneficAddress(String beneficAddress) {
		this.beneficAddress = beneficAddress;
	}
	public String getBeneficMobile() {
		return beneficMobile;
	}
	public void setBeneficMobile(String beneficMobile) {
		this.beneficMobile = beneficMobile;
	}
	public String getBeneficTelephone() {
		return beneficTelephone;
	}
	public void setBeneficTelephone(String beneficTelephone) {
		this.beneficTelephone = beneficTelephone;
	}
	public String getRefundDeposit() {
		return refundDeposit;
	}
	public void setRefundDeposit(String refundDeposit) {
		this.refundDeposit = refundDeposit;
	}
	public Date getRefundDepositDate() {
		return refundDepositDate;
	}
	public void setRefundDepositDate(Date refundDepositDate) {
		this.refundDepositDate = refundDepositDate;
	}
	public String getRefundAnnualFee() {
		return refundAnnualFee;
	}
	public void setRefundAnnualFee(String refundAnnualFee) {
		this.refundAnnualFee = refundAnnualFee;
	}
	public Date getRefundAnnualFeeDate() {
		return refundAnnualFeeDate;
	}
	public void setRefundAnnualFeeDate(Date refundAnnualFeeDate) {
		this.refundAnnualFeeDate = refundAnnualFeeDate;
	}
	public String getWaiverRemark() {
		return waiverRemark;
	}
	public void setWaiverRemark(String waiverRemark) {
		this.waiverRemark = waiverRemark;
	}
	public Date getStandingInstDate() {
		return standingInstDate;
	}
	public void setStandingInstDate(Date standingInstDate) {
		this.standingInstDate = standingInstDate;
	}
	public String getAuthorizedPerson() {
		return authorizedPerson;
	}
	public void setAuthorizedPerson(String authorizedPerson) {
		this.authorizedPerson = authorizedPerson;
	}
	public String getAuthIdentificationDetail() {
		return authIdentificationDetail;
	}
	public void setAuthIdentificationDetail(String authIdentificationDetail) {
		this.authIdentificationDetail = authIdentificationDetail;
	}
	public String getAuthAddress() {
		return authAddress;
	}
	public void setAuthAddress(String authAddress) {
		this.authAddress = authAddress;
	}
	public String getAuthMobile() {
		return authMobile;
	}
	public void setAuthMobile(String authMobile) {
		this.authMobile = authMobile;
	}
	public String getAuthTelephone() {
		return authTelephone;
	}
	public void setAuthTelephone(String authTelephone) {
		this.authTelephone = authTelephone;
	}
	public String getAuthRemark() {
		return authRemark;
	}
	public void setAuthRemark(String authRemark) {
		this.authRemark = authRemark;
	}
	public String getLockerFile() {
		return lockerFile;
	}
	public void setLockerFile(String lockerFile) {
		this.lockerFile = lockerFile;
	}
	
	
	public String[] getAlbums() {
		return albums;
	}
	public void setAlbums(String[] albums) {
		this.albums = albums;
	}
	
	public void setAlbums(List<String> albums) {
		this.albums = new String[albums.size()];
		this.albums = albums.toArray(this.albums);
		System.out.println(Arrays.toString(this.albums));
	}
	
	@Override
	public String toString() {
		return "CustomerLocker [id=" + id + ", lockerId=" + lockerId + ", lockerSize=" + lockerSize + ", openedDate="
				+ openedDate + ", expirationDate=" + expirationDate + ", lockerHolderName=" + lockerHolderName
				+ ", holderIdentDetail=" + holderIdentDetail + ", accountNumber=" + accountNumber + ", holderAddress="
				+ holderAddress + ", holderMobile=" + holderMobile + ", holderTelephone=" + holderTelephone
				+ ", lockerStatus=" + lockerStatus + ", statusEffDate=" + statusEffDate + ", branchName=" + branchName
				+ ", statusRemark=" + statusRemark + ", beneficName=" + beneficName + ", beneficDetail=" + beneficDetail
				+ ", beneficAddress=" + beneficAddress + ", beneficMobile=" + beneficMobile + ", beneficTelephone="
				+ beneficTelephone + ", refundDeposit=" + refundDeposit + ", refundDepositDate=" + refundDepositDate
				+ ", refundAnnualFee=" + refundAnnualFee + ", refundAnnualFeeDate=" + refundAnnualFeeDate
				+ ", waiverRemark=" + waiverRemark + ", standingInstDate=" + standingInstDate + ", authorizedPerson="
				+ authorizedPerson + ", authIdentificationDetail=" + authIdentificationDetail + ", authAddress="
				+ authAddress + ", authMobile=" + authMobile + ", authTelephone=" + authTelephone + ", authRemark="
				+ authRemark + ", lockerFile=" + lockerFile + ", isDeleted=" + isDeleted + "]";
	}

	
}
