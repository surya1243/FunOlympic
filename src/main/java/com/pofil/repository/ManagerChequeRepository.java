package com.pofil.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.pofil.model.ManagerCheque;

public interface ManagerChequeRepository extends MongoRepository<ManagerCheque, String> {

	Optional<ManagerCheque> findById(String id);

	List<ManagerCheque> findByBranchName(String branchName);

	List<ManagerCheque> findByMcStatus(String mcStatus);

	List<ManagerCheque> findByBranchNameAndMcStatus(String branchName, String mcStatus);

	List<ManagerCheque> findByIssueDateBetween(Date start, Date end);
	
	List<ManagerCheque> findByBranchNameAndIssueDateBetween(String branchName, Date start, Date end);
	
	@Query(value = "{?0: ?1}", count = true)
	Long countManagerCheque(String field, String value);
}
