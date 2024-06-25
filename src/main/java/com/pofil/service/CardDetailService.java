package com.pofil.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;

import com.pofil.model.Card;

public interface CardDetailService {
	
	Card saveCardDetails(Card card);
	
	List<Card> findAllByRequestDateDesc(Sort sort);
	
	List<Card> findAllByEnabledStatus(boolean enabledStatus, Sort sort);
	
	Optional<Card> findById(String id);
	
	Optional<Card> findByAccountNumber(String accountNuber);
	
	List<Card> findByCardReqOriginatingBranchAndEnabledStatus(String branchName, boolean enabledStatus);
	
	List<Card> findByCardStatusAndEnabledStatus(String cardStatus, boolean enabledStatus);
	
	List<Card> findByCardReqOriginatingBranchAndCardStatusAndEnabledStatus(String branchName, String cardStatus, boolean enabledStatus);
	
	List<Card> findByRequestDateBetweenAndEnabledStatus(Date start, Date end, boolean enabledStatus);

	List<Card> findByCardStatus(String cardStatus, Sort sort);
	
	List<Card> findByCardReqOriginatingBranch(String branchName, Sort sort);
	List<Card> findByCardStatusAndCardReqOriginatingBranch(String cardStatus, String branchName, Sort sort);
	
	List<Card> findByRequestDateBetween(Date start, Date end, Sort sort);
	List<Card> findAll(Sort sort);
	
	List<Card> findByRequestDateBetweenAndCardStatus(Date start, Date end, String cardStatus, Sort sort);
	
	List<Card> findByRequestDateBetweenAndCardStatusAndCardReqOriginatingBranch(Date start, Date end, String cardStatus, String branchName,Sort sort);
}
