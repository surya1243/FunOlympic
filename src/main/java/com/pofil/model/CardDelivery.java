package com.pofil.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Document(collection = "carddelivery")
public class CardDelivery {

	@Id
    private String id;
	
	@Indexed(unique = true)
    private String referenceNumber;
    
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dispatchedDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dispatchedItemDeliveredDate;
	 
	private String destinationBranch;
    private String dispatchedMedium;
    private String detailsOfCourrierStaff;
    private String numberOfCardDispatched;
    private String numberOfPinDispatched;
    private String deliveryStatus;
    private String dispatchedItemReceivedBy;
    private String dispatchedRemarks;
    private boolean deliveryPhase;
    private String lodgedBy;
    private String lodgedModifiedBy;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getDispatchedDate() {
		return dispatchedDate;
	}
	public void setDispatchedDate(Date dispatchedDate) {
		this.dispatchedDate = dispatchedDate;
	}
	public Date getDispatchedItemDeliveredDate() {
		return dispatchedItemDeliveredDate;
	}
	public void setDispatchedItemDeliveredDate(Date dispatchedItemDeliveredDate) {
		this.dispatchedItemDeliveredDate = dispatchedItemDeliveredDate;
	}
	public String getDestinationBranch() {
		return destinationBranch;
	}
	public void setDestinationBranch(String destinationBranch) {
		this.destinationBranch = destinationBranch;
	}
	public String getDispatchedMedium() {
		return dispatchedMedium;
	}
	public void setDispatchedMedium(String dispatchedMedium) {
		this.dispatchedMedium = dispatchedMedium;
	}
	public String getDetailsOfCourrierStaff() {
		return detailsOfCourrierStaff;
	}
	public void setDetailsOfCourrierStaff(String detailsOfCourrierStaff) {
		this.detailsOfCourrierStaff = detailsOfCourrierStaff;
	}
	public String getNumberOfCardDispatched() {
		return numberOfCardDispatched;
	}
	public void setNumberOfCardDispatched(String numberOfCardDispatched) {
		this.numberOfCardDispatched = numberOfCardDispatched;
	}
	public String getNumberOfPinDispatched() {
		return numberOfPinDispatched;
	}
	public void setNumberOfPinDispatched(String numberOfPinDispatched) {
		this.numberOfPinDispatched = numberOfPinDispatched;
	}
	public String getDeliveryStatus() {
		return deliveryStatus;
	}
	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}
	public String getDispatchedItemReceivedBy() {
		return dispatchedItemReceivedBy;
	}
	public void setDispatchedItemReceivedBy(String dispatchedItemReceivedBy) {
		this.dispatchedItemReceivedBy = dispatchedItemReceivedBy;
	}
	public String getDispatchedRemarks() {
		return dispatchedRemarks;
	}
	public void setDispatchedRemarks(String dispatchedRemarks) {
		this.dispatchedRemarks = dispatchedRemarks;
	}
	public boolean isDeliveryPhase() {
		return deliveryPhase;
	}
	public void setDeliveryPhase(boolean deliveryPhase) {
		this.deliveryPhase = deliveryPhase;
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
	public String getReferenceNumber() {
		return referenceNumber;
	}
	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

    
}
