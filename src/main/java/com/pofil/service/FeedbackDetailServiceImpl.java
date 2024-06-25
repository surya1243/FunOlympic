package com.pofil.service;

import com.pofil.model.Feedback;
import com.pofil.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class FeedbackDetailServiceImpl implements FeedbackDetailService {
    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private FeedbackDetailService feedbackDetailService;

    @Override
    public Optional<Feedback> getFeedById(String id) {
        return feedbackDetailService.getFeedById(id);
    }

    @Override
    public Feedback getFeedbackByClientCode(String clientCode) {
        return feedbackDetailService.getFeedbackByClientCode(clientCode);
    }

    @Override
    public List<Feedback> findByDate(Sort sort) {
        return feedbackRepository.findAll(Sort.by(Sort.Direction.DESC, "date"));
    }

    
    @Override
	public List<Feedback> findByBranchName(String branchName) {
		return feedbackRepository.findByBranchName(branchName);
	}
    
	@Override
	public List<Feedback> findByTypeOfService(String serviceType) {
		return feedbackRepository.findByTypeOfService(serviceType);
	}
	

	@Override
	public List<Feedback> findByRating(String rating) {
		return feedbackRepository.findByRating(rating);
	}

	@Override
    public Feedback saveFeedback(Feedback feedback) {
        feedbackRepository.save(feedback);
        return feedbackRepository.save(feedback);
    }

	@Override
	public List<Feedback> findAll() {
		return feedbackRepository.findAll();
	}

	@Override
	public Optional<Feedback> findById(String id) {
		return feedbackRepository.findById(id);
	}

	@Override
	public List<Feedback> findByBranchNameAndTypeOfService(String branchName, String serviceType) {
		return feedbackRepository.findByBranchNameAndTypeOfService(branchName, serviceType);
	}

	@Override
	public List<Feedback> findByBranchNameAndRating(String branchName, String rating) {
		return feedbackRepository.findByBranchNameAndRating(branchName, rating);
	}

	@Override
	public List<Feedback> findByTypeOfServiceAndRating(String serviceType, String rating) {
		return feedbackRepository.findByTypeOfServiceAndRating(serviceType, rating);
	}

	@Override
	public List<Feedback> findByBranchNameAndTypeOfServiceAndRating(String branchName, String serviceType,
			String rating) {
		return feedbackRepository.findByBranchNameAndTypeOfServiceAndRating(branchName, serviceType, rating);
	}

	@Override
	public Long countFeedbackRating(String field, String value) {
		return feedbackRepository.countFeedbackRating(field, value);
	}
    
    
}
