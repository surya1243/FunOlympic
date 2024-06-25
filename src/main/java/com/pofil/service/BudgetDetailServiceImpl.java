package com.pofil.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.pofil.model.Budget;
import com.pofil.repository.BudgetRepository;

@Service
public class BudgetDetailServiceImpl implements BudgetDetailService {

	@Autowired
	private BudgetRepository budgetRepository;

	@Override
	public Budget saveBudget(Budget budget) {
		budgetRepository.save(budget);
		return budgetRepository.save(budget);
	}

	@Override
	public List<Budget> findByBudgetTitle(String budgetTitle) {
		return budgetRepository.findByBudgetTitle(budgetTitle);
	}

	@Override
	public List<Budget> findByTargetType(Sort sort) {
		return budgetRepository.findAll(Sort.by(Sort.Direction.DESC, "targetType"));
	}

	@Override
	public List<Budget> findByFiscalYear(Sort sort) {
		return budgetRepository.findAll(Sort.by(Sort.Direction.DESC, "fiscalYear"));

}
}
