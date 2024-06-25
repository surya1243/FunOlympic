package com.pofil.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "budgets")
public class Budget {

	@Id
	private String id;

	@Indexed(unique = true)
	private String budgetTitle;

	private String budgetData;
	private String targetType;
	private String fiscalYear;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBudgetTitle() {
		return budgetTitle;
	}

	public void setBudgetTitle(String budgetTitle) {
		this.budgetTitle = budgetTitle;
	}

	public String getBudgetData() {
		return budgetData;
	}

	public void setBudgetData(String budgetData) {
		this.budgetData = budgetData;
	}

	public String getTargetType() {
		return targetType;
	}

	public void setTargetType(String targetType) {
		this.targetType = targetType;
	}

	public String getFiscalYear() {
		return fiscalYear;
	}

	public void setFiscalYear(String fiscalYear) {
		this.fiscalYear = fiscalYear;
	}

	@Override
	public String toString() {
		return "Budget [id=" + id + ", budgetTitle=" + budgetTitle + ", budgetData=" + budgetData + ", targetType="
				+ targetType + ", fiscalYear=" + fiscalYear + "]";
	}

}
