package com.pofil.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;

import com.pofil.model.CardDelivery;

public interface CardDeliveryDetailService {
	
	CardDelivery saveCardDeliveryDetails(CardDelivery cardDelivery);
	
	List<CardDelivery> getByDeliveryStatus(String deliveryStatus, Sort sort);
	
	Optional<CardDelivery> getById(String id);
	
	CardDelivery findByReferenceNumber(String referenceNumber);
	
	Long countDeliveryStatus(String field, String value);
	
	List<CardDelivery> getByReferenceNumberAndDeliveryStatus(String referenceNumber, String deliveryStatus);
	
	List<CardDelivery> getByDestinationBranchAndDeliveryStatus (String destinationBranch, String deliveryStatus);
	
	List<CardDelivery> getByDispatchedDateIsBetweenAndDeliveryStatus(Date start, Date end, String deliveryStatus);

	List<CardDelivery> getByDispatchedDateIsBetweenAndDeliveryStatusAndDestinationBranch(Date start, Date end, String deliveryStatus,String destinationBranch);
	
}
