package com.pofil.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Document(collection = "AccInfo")
public class AccountInfo {
	@Id
    private String id;
	
	private String branchName;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date registeredDate;
	
	private int currentAccNatural;
	private double currentAccNaturalAmount;
	private String currentAccNaturalRemakrs;
	
	private int currentCallAccInstitutional;
	private double currentCallAccInstitutionalAmount;
	private String currentCallAccInstitutionalRemarks;
	
	private int savingAcc;
	private double savingAccAmount;
	private String savingAccRemarks;

	private int fdAcc;
	private double fdAccAmount;
	private String fdAccRemarks;
	
	private int termLoanAcc;
	private double termLoanAccAmount;
	private String termLoanAccRemarks;
	
	private int wcLoanAcc;
	private double wcLoanAccAmount;
	private String wcLoanAccRemarks;
	
	private int odLoanAcc;
	private double odLoanAccAmount;
	private String odLoanAccRemarks;
	
	private int mobileBanking;
	private String mobileBankingRemarks;
	
	private int atm;
	private String atmRemarks;
	
	private int iBanking;
	private String iBankingRemarks;
	
	private int qrCode;
	private String qrCodeRemarks;
	
	private int visitCustNo;
	private String visitDetails;
	
	private int loanRepayments;
	private double loanRepaymentsAmount;
	private String loanRepaymentsRemarks;
	
	private String lodgedBy;
	private String lodgedModifiedBy;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public Date getRegisteredDate() {
		return registeredDate;
	}
	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}
	public int getCurrentAccNatural() {
		return currentAccNatural;
	}
	public void setCurrentAccNatural(int currentAccNatural) {
		this.currentAccNatural = currentAccNatural;
	}
	public double getCurrentAccNaturalAmount() {
		return currentAccNaturalAmount;
	}
	public void setCurrentAccNaturalAmount(double currentAccNaturalAmount) {
		this.currentAccNaturalAmount = currentAccNaturalAmount;
	}
	public String getCurrentAccNaturalRemakrs() {
		return currentAccNaturalRemakrs;
	}
	public void setCurrentAccNaturalRemakrs(String currentAccNaturalRemakrs) {
		this.currentAccNaturalRemakrs = currentAccNaturalRemakrs;
	}
	public int getCurrentCallAccInstitutional() {
		return currentCallAccInstitutional;
	}
	public void setCurrentCallAccInstitutional(int currentCallAccInstitutional) {
		this.currentCallAccInstitutional = currentCallAccInstitutional;
	}
	public double getCurrentCallAccInstitutionalAmount() {
		return currentCallAccInstitutionalAmount;
	}
	public void setCurrentCallAccInstitutionalAmount(double currentCallAccInstitutionalAmount) {
		this.currentCallAccInstitutionalAmount = currentCallAccInstitutionalAmount;
	}
	public String getCurrentCallAccInstitutionalRemarks() {
		return currentCallAccInstitutionalRemarks;
	}
	public void setCurrentCallAccInstitutionalRemarks(String currentCallAccInstitutionalRemarks) {
		this.currentCallAccInstitutionalRemarks = currentCallAccInstitutionalRemarks;
	}
	public int getSavingAcc() {
		return savingAcc;
	}
	public void setSavingAcc(int savingAcc) {
		this.savingAcc = savingAcc;
	}
	public double getSavingAccAmount() {
		return savingAccAmount;
	}
	public void setSavingAccAmount(double savingAccAmount) {
		this.savingAccAmount = savingAccAmount;
	}
	public String getSavingAccRemarks() {
		return savingAccRemarks;
	}
	public void setSavingAccRemarks(String savingAccRemarks) {
		this.savingAccRemarks = savingAccRemarks;
	}
	public int getFdAcc() {
		return fdAcc;
	}
	public void setFdAcc(int fdAcc) {
		this.fdAcc = fdAcc;
	}
	public double getFdAccAmount() {
		return fdAccAmount;
	}
	public void setFdAccAmount(double fdAccAmount) {
		this.fdAccAmount = fdAccAmount;
	}
	public String getFdAccRemarks() {
		return fdAccRemarks;
	}
	public void setFdAccRemarks(String fdAccRemarks) {
		this.fdAccRemarks = fdAccRemarks;
	}
	public int getTermLoanAcc() {
		return termLoanAcc;
	}
	public void setTermLoanAcc(int termLoanAcc) {
		this.termLoanAcc = termLoanAcc;
	}
	public double getTermLoanAccAmount() {
		return termLoanAccAmount;
	}
	public void setTermLoanAccAmount(double termLoanAccAmount) {
		this.termLoanAccAmount = termLoanAccAmount;
	}
	public String getTermLoanAccRemarks() {
		return termLoanAccRemarks;
	}
	public void setTermLoanAccRemarks(String termLoanAccRemarks) {
		this.termLoanAccRemarks = termLoanAccRemarks;
	}
	public int getWcLoanAcc() {
		return wcLoanAcc;
	}
	public void setWcLoanAcc(int wcLoanAcc) {
		this.wcLoanAcc = wcLoanAcc;
	}
	public double getWcLoanAccAmount() {
		return wcLoanAccAmount;
	}
	public void setWcLoanAccAmount(double wcLoanAccAmount) {
		this.wcLoanAccAmount = wcLoanAccAmount;
	}
	public String getWcLoanAccRemarks() {
		return wcLoanAccRemarks;
	}
	public void setWcLoanAccRemarks(String wcLoanAccRemarks) {
		this.wcLoanAccRemarks = wcLoanAccRemarks;
	}
	public int getOdLoanAcc() {
		return odLoanAcc;
	}
	public void setOdLoanAcc(int odLoanAcc) {
		this.odLoanAcc = odLoanAcc;
	}
	public double getOdLoanAccAmount() {
		return odLoanAccAmount;
	}
	public void setOdLoanAccAmount(double odLoanAccAmount) {
		this.odLoanAccAmount = odLoanAccAmount;
	}
	public String getOdLoanAccRemarks() {
		return odLoanAccRemarks;
	}
	public void setOdLoanAccRemarks(String odLoanAccRemarks) {
		this.odLoanAccRemarks = odLoanAccRemarks;
	}
	public int getMobileBanking() {
		return mobileBanking;
	}
	public void setMobileBanking(int mobileBanking) {
		this.mobileBanking = mobileBanking;
	}
	public String getMobileBankingRemarks() {
		return mobileBankingRemarks;
	}
	public void setMobileBankingRemarks(String mobileBankingRemarks) {
		this.mobileBankingRemarks = mobileBankingRemarks;
	}
	public int getAtm() {
		return atm;
	}
	public void setAtm(int atm) {
		this.atm = atm;
	}
	public String getAtmRemarks() {
		return atmRemarks;
	}
	public void setAtmRemarks(String atmRemarks) {
		this.atmRemarks = atmRemarks;
	}
	public int getiBanking() {
		return iBanking;
	}
	public void setiBanking(int iBanking) {
		this.iBanking = iBanking;
	}
	public String getiBankingRemarks() {
		return iBankingRemarks;
	}
	public void setiBankingRemarks(String iBankingRemarks) {
		this.iBankingRemarks = iBankingRemarks;
	}
	public int getVisitCustNo() {
		return visitCustNo;
	}
	public void setVisitCustNo(int visitCustNo) {
		this.visitCustNo = visitCustNo;
	}
	public String getVisitDetails() {
		return visitDetails;
	}
	public void setVisitDetails(String visitDetails) {
		this.visitDetails = visitDetails;
	}
	public int getLoanRepayments() {
		return loanRepayments;
	}
	public void setLoanRepayments(int loanRepayments) {
		this.loanRepayments = loanRepayments;
	}
	public double getLoanRepaymentsAmount() {
		return loanRepaymentsAmount;
	}
	public void setLoanRepaymentsAmount(double loanRepaymentsAmount) {
		this.loanRepaymentsAmount = loanRepaymentsAmount;
	}
	public String getLoanRepaymentsRemarks() {
		return loanRepaymentsRemarks;
	}
	public void setLoanRepaymentsRemarks(String loanRepaymentsRemarks) {
		this.loanRepaymentsRemarks = loanRepaymentsRemarks;
	}
	public String getLodgedBy() {
		return lodgedBy;
	}
	public void setLodgedBy(String lodgedBy) {
		this.lodgedBy = lodgedBy;
	}
	public String getLodgedModifiedBy() {
		return lodgedModifiedBy;
	}
	public void setLodgedModifiedBy(String lodgedModifiedBy) {
		this.lodgedModifiedBy = lodgedModifiedBy;
	}
	public int getQrCode() {
		return qrCode;
	}
	public void setQrCode(int qrCode) {
		this.qrCode = qrCode;
	}
	public String getQrCodeRemarks() {
		return qrCodeRemarks;
	}
	public void setQrCodeRemarks(String qrCodeRemarks) {
		this.qrCodeRemarks = qrCodeRemarks;
	}

	
	
	
}
