package com.pofil.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pofil.model.Budget;

public interface BudgetRepository extends MongoRepository<Budget, String> {
	
	Optional<Budget> findById(String Id);
	
	List<Budget> findAll();

	List<Budget> findByBudgetTitle(String budgetTitle);
	List<Budget> findByTargetType(String targetType);
	List<Budget> findByFiscalYear();
	
}
