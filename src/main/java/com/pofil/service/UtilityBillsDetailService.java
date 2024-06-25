package com.pofil.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;

import com.pofil.model.UtilityBills;

public interface UtilityBillsDetailService {

	Optional<UtilityBills> findById(String id);

	List<UtilityBills> findByFiscalYear(Sort sort);

	List<UtilityBills> findUtilityBillsGroupByFiscalYear();

	List<UtilityBills> findAllList();

	UtilityBills saveUtility(UtilityBills utilityBills);

	List<UtilityBills> getByFiscalYearAndMonth(String fiscalYear, String month);

	List<UtilityBills> getByFiscalYearAndBranchName(String fiscalYear, String branchName);

	List<UtilityBills> findByBranchNameAndFiscalYearAndMonth(String branchName, String fiscalYear, String month);
	
	List<UtilityBills> getByBranchName(String branchName);
	List<UtilityBills> getByBranchNameAndMonth(String branchName, String month);
	
	List<UtilityBills> findByFiscalYearContaining(String fiscalYear, Sort sort);
	
	List<UtilityBills> findByBranchNameContaining(String branchName, Sort sort);
}
