package com.pofil.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.pofil.model.UtilityBills;

public interface UtilityBillsRepository extends MongoRepository<UtilityBills, String> {
	
	Optional<UtilityBills> findById(String id);
	List<UtilityBills> findByFiscalYear(Sort sort);
	
	List<UtilityBills> findByFiscalYearContaining(String fiscalYear, Sort sort);
	
	List<UtilityBills> findUtilityBillsGroupByFiscalYear();
	List<UtilityBills> findAll();
	List<UtilityBills> findByBranchName(String branchName);
	List<UtilityBills> findByBranchNameContaining(String branchName, Sort sort);
	
	List<UtilityBills> findByFiscalYearAndMonth(String fiscalYear, String month);

	List<UtilityBills> findByFiscalYearAndBranchName(String fiscalYear, String branchName);	
	
	List<UtilityBills> findByBranchNameAndFiscalYearAndMonth(String branchName, String fiscalYear, String month);
	
	@Query(value = "{?0: ?1}", count = true)
	public Long countOrderOf(String field, String value);
	
	List<UtilityBills> findByBranchNameAndMonth(String branchName, String month);
}
