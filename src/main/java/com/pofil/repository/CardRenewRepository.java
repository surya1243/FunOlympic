package com.pofil.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.pofil.model.CardRenew;

public interface CardRenewRepository extends MongoRepository<CardRenew, String> {
	
	List<CardRenew> findByEnabledStatus(boolean enabledStatus, Sort sort);
	
	List<CardRenew> findAllByRenewRequestDate(Sort sort);
	 
	List<CardRenew> findByAccountNumberAndEnabledStatus(String accountNumber, boolean enabledStatus);
	
	List<CardRenew> findByCardReqOriginatingBranchAndEnabledStatus(String branchName, boolean enabledStatus);
	
	List<CardRenew> findByCardStatusAndEnabledStatus(String cardStatus, boolean enabledStatus);
	
	List<CardRenew> findByCardReqOriginatingBranchAndCardStatusAndEnabledStatus(String branchName, String cardStatus, boolean enabledStatus);
	
	List<CardRenew> findByRenewRequestDateBetweenAndEnabledStatus(Date start, Date end, boolean enabledStatus);
	
	List<CardRenew> findByCardStatus(String cardStatus, Sort sort);
	
	List<CardRenew> findByCardReqOriginatingBranchAndCardStatus(String cardReqOriginatingBranch, String cardStatus, Sort sort);
	
	List<CardRenew> findByRenewRequestDateBetweenAndCardStatus(Date start, Date end, String cardStatus);
	
	List<CardRenew> findByRenewRequestDateBetweenAndCardStatusAndCardReqOriginatingBranch(Date start, Date end, String cardStatus, String cardReqOriginatingBranch);
	
	List<CardRenew> findByCardReqOriginatingBranch(String cardReqOriginatingBranch,Sort sort );
	
	List<CardRenew> findByRenewRequestDateBetween(Date start, Date end,Sort sort);
	
	@Query(value = "{?0: ?1}", count = true)
	Long countStatusOf(String field, String value);

}
