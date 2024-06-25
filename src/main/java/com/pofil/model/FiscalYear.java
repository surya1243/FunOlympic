package com.pofil.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "fiscalyears")
public class FiscalYear {
	
	@Id
    private String id;
    private String fiscalYears;
    private String remark;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFiscalYears() {
		return fiscalYears;
	}
	public void setFiscalYears(String fiscalYears) {
		this.fiscalYears = fiscalYears;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "FiscalYear [id=" + id + ", fiscalYears=" + fiscalYears + ", remark=" + remark + "]";
	}
    


}
