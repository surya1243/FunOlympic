package com.pofil.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.pofil.model.CardDelivery;

public interface CardDeliveryRepository extends MongoRepository<CardDelivery, String> {
	
	List<CardDelivery> findByDeliveryStatus (String deliveryStatus, Sort sort);
	
	List<CardDelivery> findByDestinationBranchAndDeliveryStatus (String destinationBranch, String deliveryStatus);
	
	Optional<CardDelivery> findById(String id);
	
	List<CardDelivery> findByReferenceNumberAndDeliveryStatus(String referenceNumber, String deliveryStatus);
	
	List<CardDelivery> findByDispatchedDateIsBetweenAndDeliveryStatus(Date start, Date end, String deliveryStatus);

	List<CardDelivery> findByDispatchedDateIsBetweenAndDeliveryStatusAndDestinationBranch(Date start, Date end, String deliveryStatus,String destinationBranch);
	
	CardDelivery findByReferenceNumber(String referenceNumber);
	
	@Query(value = "{?0: ?1}", count = true)
	Long countDeliveryStatus(String field, String value);
	

}
