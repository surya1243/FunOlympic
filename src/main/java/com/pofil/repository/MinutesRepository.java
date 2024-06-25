package com.pofil.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pofil.model.Minutes;

public interface MinutesRepository extends MongoRepository<Minutes, String> {
	
	List<Minutes> findAllByOrderByMeetingsDateDesc();
	
	List<Minutes> findByBranchNameOrderByMeetingsDateDesc(String branchName);
	
	
	List<Minutes> findByFiscalYear(String fiscalYear);
	
	List<Minutes> findByCategoryOrderByMeetingsDateDesc(String category);
	
	List<Minutes> findAllByCategoryAndBranchNameOrderByMeetingsDateDesc(String category, String branchName);
	
	
	List<Minutes> findAllByMeetingsDateIsBetweenOrderByMeetingsDateDesc(Date firstDate, Date secondDate);
	
	
	Optional<Minutes> findById(String id);

}
