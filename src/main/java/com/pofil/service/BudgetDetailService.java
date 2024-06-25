package com.pofil.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;

import com.pofil.model.Budget;

public interface BudgetDetailService {
	
	List<Budget> findByBudgetTitle(String budgetTitle);
	List<Budget> findByTargetType(Sort sort);
	List<Budget> findByFiscalYear(Sort sort);

	Budget saveBudget(Budget budget);

}
