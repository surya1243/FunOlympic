package com.pofil.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;

import com.pofil.model.CardRenew;

public interface CardRenewDetailService {

	CardRenew saveCardRenewDetails(CardRenew cardRenew);
	
	Optional<CardRenew> findById(String id);
	
	List<CardRenew> findAllByRenewRequestDateDesc(Sort sort);
	
	List<CardRenew> findAllByEnabledStatus(boolean enabledStatus, Sort sort);
	
	List<CardRenew> findByAccountNumberAndEnabledStatus(String accountNumber, boolean enabledStatus);
	
	List<CardRenew> findByCardReqOriginatingBranchAndEnabledStatus(String branchName, boolean enabledStatus);
	
	List<CardRenew> findByCardStatusAndEnabledStatus(String cardStatus, boolean enabledStatus);
	
	List<CardRenew> findByCardReqOriginatingBranchAndCardStatusAndEnabledStatus(String branchName, String cardStatus, boolean enabledStatus);
	
	List<CardRenew> findByRenewRequestDateBetweenAndEnabledStatus(Date start, Date end, boolean enabledStatus);
	
	List<CardRenew> findByCardStatus(String cardStatus, Sort sort);
	
	List<CardRenew> findByCardReqOriginatingBranchAndCardStatus(String cardReqOriginatingBranch, String cardStatus, Sort sort);
	
	List<CardRenew> findByRenewRequestDateBetweenAndCardStatusAndCardReqOriginatingBranch(Date start, Date end, String cardStatus, String cardReqOriginatingBranch);
	List<CardRenew> findByRenewRequestDateBetweenAndCardStatus(Date start, Date end, String cardStatus);
	List<CardRenew> findByRenewRequestDateBetween(Date start, Date end,Sort sort);
	
	List<CardRenew> findByCardReqOriginatingBranch(String cardReqOriginatingBranch,Sort sort );
}
