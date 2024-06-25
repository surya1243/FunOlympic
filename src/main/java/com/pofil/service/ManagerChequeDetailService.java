package com.pofil.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.Query;

import com.pofil.model.ManagerCheque;

/**
 * ManagerChequeDetailService
 */
public interface ManagerChequeDetailService {

    Optional<ManagerCheque> getMcById(String id);

	List<ManagerCheque> getGfpByPartiesName(String partiesName);

	List<ManagerCheque> getAllMcList();

    ManagerCheque saveMcRecords(ManagerCheque mcRecords);
    
    List<ManagerCheque> getByBranchName(String branchName);

    List<ManagerCheque> getByMcStatus(String mcStatus);
    
	List<ManagerCheque> getByBranchNameAndMcStatus(String branchName, String mcStatus);

	List<ManagerCheque> getByIssueDateBetween(Date start, Date end);
	
	List<ManagerCheque> getByBranchNameAndIssueDateBetween(String branchName, Date start, Date end);
	
	Long countManagerCheque(String field, String value);
}