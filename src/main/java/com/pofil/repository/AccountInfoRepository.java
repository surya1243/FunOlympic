package com.pofil.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.pofil.model.AccountInfo;
import com.pofil.model.Card;

public interface AccountInfoRepository extends MongoRepository<AccountInfo, String> {

	Optional<AccountInfo> findById(String id);

	List<AccountInfo> findByBranchName(String branchName);

	List<AccountInfo> findByRegisteredDateBetween(Date start, Date end, Sort sort);

	List<AccountInfo> findByRegisteredDateBetweenAndBranchName(Date start, Date end, String branchName, Sort sort);

	List<AccountInfo> findByRegisteredDate(Date date);
	
	List<AccountInfo> findByBranchNameAndRegisteredDate(String branchName, Date registeredDate);
	


}
