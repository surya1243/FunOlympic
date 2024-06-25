package com.pofil.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.pofil.model.ErrorIssueLog;

public interface ErrorIssueLogDetailService {
	
	Optional<ErrorIssueLog> getById(String id);
	
	List<ErrorIssueLog> getAll();
	
	ErrorIssueLog saveAll(ErrorIssueLog errorIssueLog);
	
	List<ErrorIssueLog> getByBranchName(String branchName);

	List<ErrorIssueLog> getByNatureOfError(String natureOfError);

	List<ErrorIssueLog> getByBranchNameAndNatureOfError(String branchName, String natureOfError);

	List<ErrorIssueLog> getByIncidentValueDateBetween(Date start, Date end);
	
	List<ErrorIssueLog> getByBranchNameAndCauseOfError(String branchName, String causeOfError);
	
	List<ErrorIssueLog> ggetByBranchNameAndIncidentValueDateBetween(String branchName,Date start, Date end);

}
