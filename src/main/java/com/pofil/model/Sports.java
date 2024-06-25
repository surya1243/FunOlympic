package com.pofil.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "sports")
public class Sports {
	
	@Id
    private String id;
	
	@Indexed(unique = true)
    private String sportsCode;
	
    private String sportsName;
    private boolean enabled;
    private String remark;
    private String fileLocationUrl;
    
    public Sports() {
    	
    }    
	
	public Sports(String id, String sportsCode, String sportsName, boolean enabled, String remark) {
		this.id = id;
		this.sportsCode = sportsCode;
		this.sportsName = sportsName;
		this.enabled = enabled;
		this.remark = remark;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSportsCode() {
		return sportsCode;
	}
	public void setSportsCode(String sportsCode) {
		this.sportsCode = sportsCode;
	}
	public String getSportsName() {
		return sportsName;
	}
	public void setSportsName(String sportsName) {
		this.sportsName = sportsName;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getFileLocationUrl() {
		return fileLocationUrl;
	}

	public void setFileLocationUrl(String fileLocationUrl) {
		this.fileLocationUrl = fileLocationUrl;
	}

	@Override
	public String toString() {
		return "Branch [id=" + id + ", sportsCode=" + sportsCode + ", sportsName=" + sportsName + ",  enabled=" + enabled + ", remark=" + remark + "]";
	}
}
