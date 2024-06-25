package com.pofil.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pofil.model.ErrorIssueLog;

public interface ErrorIssueLogRepository extends MongoRepository<ErrorIssueLog, String> {

	Optional<ErrorIssueLog> findById(String Id);

	List<ErrorIssueLog> findAll();

	List<ErrorIssueLog> findByBranchName(String branchName);

	List<ErrorIssueLog> findByNatureOfError(String natureOfError);

	List<ErrorIssueLog> findByBranchNameAndNatureOfError(String branchName, String natureOfError);

	List<ErrorIssueLog> findByBranchNameAndCauseOfError(String branchName, String causeOfError);

	List<ErrorIssueLog> findByIncidentValueDateBetween(Date start, Date end);
	
	List<ErrorIssueLog> findByBranchNameAndIncidentValueDateBetween(String branchName,Date start, Date end);

}
