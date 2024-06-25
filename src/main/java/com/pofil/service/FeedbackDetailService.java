package com.pofil.service;

import com.pofil.model.Feedback;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;

public interface FeedbackDetailService {

    Optional<Feedback> getFeedById(String id);

    Feedback getFeedbackByClientCode(String clientCode);

    List<Feedback> findByDate(Sort sort);

    Feedback saveFeedback(Feedback feedback);
    
    List<Feedback> findAll();
    
    List<Feedback> findByBranchName(String branchName);
    
    List<Feedback> findByTypeOfService(String serviceType);
    
    List<Feedback> findByRating(String rating);

	Optional<Feedback> findById(String id);
	
	List<Feedback> findByBranchNameAndTypeOfService(String branchName, String serviceType);

	List<Feedback> findByBranchNameAndRating(String branchName, String rating);

	List<Feedback> findByTypeOfServiceAndRating(String serviceType, String rating);

	List<Feedback> findByBranchNameAndTypeOfServiceAndRating(String branchName, String serviceType, String rating);
	
	Long countFeedbackRating(String field, String value);
}
