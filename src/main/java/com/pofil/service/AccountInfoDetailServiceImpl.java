package com.pofil.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.pofil.model.AccountInfo;
import com.pofil.repository.AccountInfoRepository;
@Service
public class AccountInfoDetailServiceImpl implements AccountInfoDetailService {

	@Autowired
	private AccountInfoRepository accountInfoRepository;
	
	@Override
	public AccountInfo saveAccountLogDetails(AccountInfo accountInfo) {
		accountInfoRepository.save(accountInfo);
		return accountInfoRepository.save(accountInfo);
	}

	@Override
	public List<AccountInfo> findAll() {
		return accountInfoRepository.findAll();
	}

	@Override
	public Optional<AccountInfo> findById(String id) {
		return accountInfoRepository.findById(id);
	}

	@Override
	public List<AccountInfo> findByBranchName(String branchName) {
		return accountInfoRepository.findByBranchName(branchName);
	}

	@Override
	public List<AccountInfo> findByRegisteredDateBetween(Date start, Date end, Sort sort) {
		return accountInfoRepository.findByRegisteredDateBetween(start, end, sort);
	}

	@Override
	public List<AccountInfo> findByRegisteredDateBetweenAndBranchName(Date start, Date end, String branchName,
			Sort sort) {
		return accountInfoRepository.findByRegisteredDateBetweenAndBranchName(start, end, branchName, sort);
	}

	@Override
	public List<AccountInfo> findByRegisteredDate(Date date) {
		return accountInfoRepository.findByRegisteredDate(date);
	}

	@Override
	public List<AccountInfo> findByBranchNameAndRegisteredDate(String branchName, Date registeredDate) {
		return accountInfoRepository.findByBranchNameAndRegisteredDate(branchName, registeredDate);
	}

}
