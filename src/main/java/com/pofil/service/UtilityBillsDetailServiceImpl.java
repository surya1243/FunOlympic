package com.pofil.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.TypedAggregation;
import org.springframework.stereotype.Service;

import com.pofil.model.UtilityBills;
import com.pofil.repository.UtilityBillsRepository;

@Service
public class UtilityBillsDetailServiceImpl implements UtilityBillsDetailService {
	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	UtilityBillsRepository utilityBillsRepository;

	@Override
	public Optional<UtilityBills> findById(String id) {
		return utilityBillsRepository.findById(id);
	}

	@Override
	public List<UtilityBills> findByFiscalYear(Sort sort) {
		return utilityBillsRepository.findAll(Sort.by(Sort.Direction.DESC, "fiscalYear"));
	}


	@Override
	public List<UtilityBills> findByBranchNameAndFiscalYearAndMonth(String branchName, String fiscalYear, String month) {
		List<UtilityBills> exists = utilityBillsRepository.findByBranchNameAndFiscalYearAndMonth(branchName, fiscalYear, month);
		if (exists == null)
			return null;
		return exists;
	}
	
	@Override
	public List<UtilityBills> findUtilityBillsGroupByFiscalYear() {
		TypedAggregation<UtilityBills> studentAggregation = Aggregation.newAggregation(UtilityBills.class,
				Aggregation.group("fiscalYear").push("$$ROOT").as("utilityBills"));
		AggregationResults<UtilityBills> results = mongoTemplate.aggregate(studentAggregation, UtilityBills.class);
		List<UtilityBills> utilityBillsResultsList = results.getMappedResults();
		System.out.println(utilityBillsResultsList);
		return utilityBillsResultsList;
	}

	@Override
	public UtilityBills saveUtility(UtilityBills utilityBills) {
		utilityBillsRepository.save(utilityBills);
		return utilityBillsRepository.save(utilityBills);
	}

	@Override
	public List<UtilityBills> findAllList() {
		return utilityBillsRepository.findAll();
	}

	@Override
	public List<UtilityBills> getByFiscalYearAndMonth(String fiscalYear, String month) {
		return utilityBillsRepository.findByFiscalYearAndMonth(fiscalYear, month);
	}

	@Override
	public List<UtilityBills> getByFiscalYearAndBranchName(String fiscalYear, String branchName) {
		return utilityBillsRepository.findByFiscalYearAndBranchName(fiscalYear, branchName);
	}

	@Override
	public List<UtilityBills> getByBranchName(String branchName) {
		return utilityBillsRepository.findByBranchName(branchName);
	}

	@Override
	public List<UtilityBills> getByBranchNameAndMonth(String branchName, String month) {
		return utilityBillsRepository.findByBranchNameAndMonth(branchName, month);
	}

	@Override
	public List<UtilityBills> findByFiscalYearContaining(String fiscalYear, Sort sort) {
		return utilityBillsRepository.findByFiscalYearContaining(fiscalYear, sort);
	}

	@Override
	public List<UtilityBills> findByBranchNameContaining(String branchName, Sort sort) {
		return utilityBillsRepository.findByBranchNameContaining(branchName, sort);
	}

}
