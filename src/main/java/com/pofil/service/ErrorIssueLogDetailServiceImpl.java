package com.pofil.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pofil.model.ErrorIssueLog;
import com.pofil.repository.ErrorIssueLogRepository;

@Service
public class ErrorIssueLogDetailServiceImpl implements ErrorIssueLogDetailService {
	
	@Autowired
	ErrorIssueLogRepository errorIssueLogRepository;

	@Override
	public Optional<ErrorIssueLog> getById(String id) {
		return errorIssueLogRepository.findById(id);
	}

	@Override
	public List<ErrorIssueLog> getAll() {
		return errorIssueLogRepository.findAll();
	}

	@Override
	public ErrorIssueLog saveAll(ErrorIssueLog errorIssueLog) {
		errorIssueLogRepository.save(errorIssueLog);
		return errorIssueLogRepository.save(errorIssueLog);
	}

	@Override
	public List<ErrorIssueLog> getByBranchName(String branchName) {
		return errorIssueLogRepository.findByBranchName(branchName);
	}

	@Override
	public List<ErrorIssueLog> getByNatureOfError(String natureOfError) {
		return errorIssueLogRepository.findByNatureOfError(natureOfError);
	}

	@Override
	public List<ErrorIssueLog> getByBranchNameAndNatureOfError(String branchName, String natureOfError) {
		return errorIssueLogRepository.findByBranchNameAndNatureOfError(branchName, natureOfError);
	}

	@Override
	public List<ErrorIssueLog> getByIncidentValueDateBetween(Date start, Date end) {
		return errorIssueLogRepository.findByIncidentValueDateBetween(start, end);
	}

	@Override
	public List<ErrorIssueLog> getByBranchNameAndCauseOfError(String branchName, String causeOfError) {
		return errorIssueLogRepository.findByBranchNameAndCauseOfError(branchName, causeOfError);
	}

	@Override
	public List<ErrorIssueLog> ggetByBranchNameAndIncidentValueDateBetween(String branchName, Date start, Date end) {
		return errorIssueLogRepository.findByBranchNameAndIncidentValueDateBetween(branchName, start,  end);
	}

}
