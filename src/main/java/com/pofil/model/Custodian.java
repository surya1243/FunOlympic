package com.pofil.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "custodianDetail")
public class Custodian {
	@Id
    private String id;
	
	@Indexed(unique = true)
	private String custodianName;
	
    private String custodianType;
    private String branchName;
	private String remarks;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCustodianType() {
		return custodianType;
	}
	public void setCustodianType(String custodianType) {
		this.custodianType = custodianType;
	}
	public String getCustodianName() {
		return custodianName;
	}
	public void setCustodianName(String custodianName) {
		this.custodianName = custodianName;
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
	@Override
	public String toString() {
		return "Custodian [id=" + id + ", custodianName=" + custodianName + ", custodianType=" + custodianType
				+ ", branchName=" + branchName + ", remarks=" + remarks + "]";
	}
	public Custodian(String id, String custodianName, String custodianType, String branchName, String remarks) {
		super();
		this.id = id;
		this.custodianName = custodianName;
		this.custodianType = custodianType;
		this.branchName = branchName;
		this.remarks = remarks;
	}


}
