package com.pofil.model;

public class Expense {
	private String category;
	private double amount;
	private String description;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Expense [category=" + category + ", amount=" + amount + ", description=" + description + "]";
	}

}
