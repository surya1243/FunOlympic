package com.pofil.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.pofil.model.CardDelivery;
import com.pofil.repository.CardDeliveryRepository;

@Service
public class CardDeliveryDetailServiceImpl implements CardDeliveryDetailService {

	

	@Autowired
	CardDeliveryRepository cardDeliveryRepository;
	
	@Override
	public CardDelivery saveCardDeliveryDetails(CardDelivery cardDelivery) {
		cardDeliveryRepository.save(cardDelivery);
		return cardDeliveryRepository.save(cardDelivery);
	}
	
	@Override
	public List<CardDelivery> getByDeliveryStatus(String deliveryStatus, Sort sort){
		return cardDeliveryRepository.findByDeliveryStatus(deliveryStatus, Sort.by(Sort.Direction.DESC, "dispatchedDate"));
	}

	@Override
	public Optional<CardDelivery> getById(String id) {
		return cardDeliveryRepository.findById(id);
	}

	@Override
	public CardDelivery findByReferenceNumber(String referenceNumber) {
		return cardDeliveryRepository.findByReferenceNumber(referenceNumber);
	}

	@Override
	public Long countDeliveryStatus(String field, String value) {
		return cardDeliveryRepository.countDeliveryStatus(field, value);
	}

	@Override
	public List<CardDelivery> getByReferenceNumberAndDeliveryStatus(String referenceNumber, String deliveryStatus) {
		return cardDeliveryRepository.findByReferenceNumberAndDeliveryStatus(referenceNumber, deliveryStatus);
	}

	@Override
	public List<CardDelivery> getByDestinationBranchAndDeliveryStatus(String destinationBranch, String deliveryStatus) {
		return cardDeliveryRepository.findByDestinationBranchAndDeliveryStatus(destinationBranch, deliveryStatus);
	}

	@Override
	public List<CardDelivery> getByDispatchedDateIsBetweenAndDeliveryStatus(Date start, Date end,
			String deliveryStatus) {
		return cardDeliveryRepository.findByDispatchedDateIsBetweenAndDeliveryStatus(start, end, deliveryStatus);
	}

	@Override
	public List<CardDelivery> getByDispatchedDateIsBetweenAndDeliveryStatusAndDestinationBranch(Date start, Date end,
			String deliveryStatus, String destinationBranch) {
		return cardDeliveryRepository.findByDispatchedDateIsBetweenAndDeliveryStatusAndDestinationBranch(start, end, deliveryStatus, destinationBranch);
	}

}
