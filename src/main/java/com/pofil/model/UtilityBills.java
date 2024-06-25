package com.pofil.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "utilitybills")
public class UtilityBills {

	@Id
	private String id;

	private String branchName;
	private String fiscalYear;
	private String month;
	private double totalExpense;
	
	private double electricityExpenseAmount;
	private String electricityExpenseRemarks;
	
	private double fuelExpensesTwoWheelAmount;
	private String fuelExpensesTwoWheelRemarks;
	
	private double fuelExpensesFourWheelAmount;
	private String fuelExpensesFourWheelRemarks;
	
	private double fuelGensetAmount;
	private String fuelGensetRemarks;
	
	private double telephoneExpenseAmount;
	private String telephoneExpenseRemarks;
	
	private double maintenanceExpenseAmount;
	private String maintenanceExpenseRemarks;
	
	private double othersExpensesAmount;
	private String othersExpensesRemarks;

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


	public String getFiscalYear() {
		return fiscalYear;
	}


	public void setFiscalYear(String fiscalYear) {
		this.fiscalYear = fiscalYear;
	}


	public String getMonth() {
		return month;
	}


	public void setMonth(String month) {
		this.month = month;
	}


	public double getTotalExpense() {
		return totalExpense;
	}


	public void setTotalExpense(double totalExpense) {
		this.totalExpense = totalExpense;
	}


	public double getElectricityExpenseAmount() {
		return electricityExpenseAmount;
	}


	public void setElectricityExpenseAmount(double electricityExpenseAmount) {
		this.electricityExpenseAmount = electricityExpenseAmount;
	}


	public String getElectricityExpenseRemarks() {
		return electricityExpenseRemarks;
	}


	public void setElectricityExpenseRemarks(String electricityExpenseRemarks) {
		this.electricityExpenseRemarks = electricityExpenseRemarks;
	}


	public double getFuelExpensesTwoWheelAmount() {
		return fuelExpensesTwoWheelAmount;
	}


	public void setFuelExpensesTwoWheelAmount(double fuelExpensesTwoWheelAmount) {
		this.fuelExpensesTwoWheelAmount = fuelExpensesTwoWheelAmount;
	}


	public String getFuelExpensesTwoWheelRemarks() {
		return fuelExpensesTwoWheelRemarks;
	}


	public void setFuelExpensesTwoWheelRemarks(String fuelExpensesTwoWheelRemarks) {
		this.fuelExpensesTwoWheelRemarks = fuelExpensesTwoWheelRemarks;
	}


	public double getFuelExpensesFourWheelAmount() {
		return fuelExpensesFourWheelAmount;
	}


	public void setFuelExpensesFourWheelAmount(double fuelExpensesFourWheelAmount) {
		this.fuelExpensesFourWheelAmount = fuelExpensesFourWheelAmount;
	}


	public String getFuelExpensesFourWheelRemarks() {
		return fuelExpensesFourWheelRemarks;
	}


	public void setFuelExpensesFourWheelRemarks(String fuelExpensesFourWheelRemarks) {
		this.fuelExpensesFourWheelRemarks = fuelExpensesFourWheelRemarks;
	}


	public double getFuelGensetAmount() {
		return fuelGensetAmount;
	}


	public void setFuelGensetAmount(double fuelGensetAmount) {
		this.fuelGensetAmount = fuelGensetAmount;
	}


	public String getFuelGensetRemarks() {
		return fuelGensetRemarks;
	}


	public void setFuelGensetRemarks(String fuelGensetRemarks) {
		this.fuelGensetRemarks = fuelGensetRemarks;
	}


	public double getTelephoneExpenseAmount() {
		return telephoneExpenseAmount;
	}


	public void setTelephoneExpenseAmount(double telephoneExpenseAmount) {
		this.telephoneExpenseAmount = telephoneExpenseAmount;
	}


	public String getTelephoneExpenseRemarks() {
		return telephoneExpenseRemarks;
	}


	public void setTelephoneExpenseRemarks(String telephoneExpenseRemarks) {
		this.telephoneExpenseRemarks = telephoneExpenseRemarks;
	}


	public double getMaintenanceExpenseAmount() {
		return maintenanceExpenseAmount;
	}


	public void setMaintenanceExpenseAmount(double maintenanceExpenseAmount) {
		this.maintenanceExpenseAmount = maintenanceExpenseAmount;
	}


	public String getMaintenanceExpenseRemarks() {
		return maintenanceExpenseRemarks;
	}


	public void setMaintenanceExpenseRemarks(String maintenanceExpenseRemarks) {
		this.maintenanceExpenseRemarks = maintenanceExpenseRemarks;
	}


	public double getOthersExpensesAmount() {
		return othersExpensesAmount;
	}


	public void setOthersExpensesAmount(double othersExpensesAmount) {
		this.othersExpensesAmount = othersExpensesAmount;
	}


	public String getOthersExpensesRemarks() {
		return othersExpensesRemarks;
	}


	public void setOthersExpensesRemarks(String othersExpensesRemarks) {
		this.othersExpensesRemarks = othersExpensesRemarks;
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


}
