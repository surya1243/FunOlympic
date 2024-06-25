package com.pofil.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.pofil.model.Feedback;

public interface FeedbackRepository extends MongoRepository<Feedback, String> {
	List<Feedback> findByDate();

	Feedback findByAccountNumber(String accountNumber);

	List<Feedback> findAll();

	Feedback findDistinctByAccountNumber(String accountNumber);

	List<Feedback> findByDateBetween(String a, String b);

	List<Feedback> findByBranchName(String branchName);

	List<Feedback> findByTypeOfService(String serviceType);

	List<Feedback> findByRating(String rating);

	List<Feedback> findByDateBetween(Date firstDate, Date secondDate);

	List<Feedback> findByBranchNameAndTypeOfService(String branchName, String serviceType);

	List<Feedback> findByBranchNameAndRating(String branchName, String rating);

	List<Feedback> findByTypeOfServiceAndRating(String serviceType, String rating);

	List<Feedback> findByBranchNameAndTypeOfServiceAndRating(String branchName, String serviceType, String rating);
	
	@Query(value = "{?0: ?1}", count = true)
	Long countFeedbackRating(String field, String value);
}
