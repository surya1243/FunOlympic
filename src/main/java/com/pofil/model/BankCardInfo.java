package com.pofil.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "bankcardinfo")
public class BankCardInfo {

    @Id
    private String id;
    
    @Indexed(unique = true, direction = IndexDirection.DESCENDING)
    private String bankName;
    
    private String bIN;
    private String oldBin;
    private String institution;
    private String cardProduct;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getbIN() {
		return bIN;
	}
	public void setbIN(String bIN) {
		this.bIN = bIN;
	}
	public String getOldBin() {
		return oldBin;
	}
	public void setOldBin(String oldBin) {
		this.oldBin = oldBin;
	}
	public String getInstitution() {
		return institution;
	}
	public void setInstitution(String institution) {
		this.institution = institution;
	}
	public String getCardProduct() {
		return cardProduct;
	}
	public void setCardProduct(String cardProduct) {
		this.cardProduct = cardProduct;
	}
    
    
}
