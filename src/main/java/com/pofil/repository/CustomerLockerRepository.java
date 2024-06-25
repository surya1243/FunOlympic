package com.pofil.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.pofil.model.CustomerLocker;

public interface CustomerLockerRepository extends MongoRepository<CustomerLocker, String> {
	
	Optional<CustomerLocker> findByLockerId(String lockerId);
	
	Optional<CustomerLocker> findByCheckLockerVal(String checkLockerVal);
	
	List<CustomerLocker> findByEnabled(boolean boolVal);

	List<CustomerLocker> findAllByOrderByExpirationDateAsc();
	
	List<CustomerLocker> findAllByOrderByBranchNameAsc(String branchName);
	
	List<CustomerLocker> findAllByBranchNameAndEnabledOrderByExpirationDateAsc(String branchName, boolean boolVal);
	
	List<CustomerLocker> findAllByLockerStatusAndEnabledOrderByExpirationDateAsc(String lockerStatus, boolean boolVal);
	
	List<CustomerLocker> findAllByLockerStatusAndBranchNameAndEnabledOrderByExpirationDateAsc(String lockerStatus, String branchName, boolean boolVal);

	List<CustomerLocker> findAllByExpirationDateIsBetweenAndEnabledOrderByExpirationDateAsc(Date firstDate, Date secondDate, boolean boolVal);
	
	List<CustomerLocker> findByLockerStatus(String lockerStatus);

	List<CustomerLocker> findAllByEnabledOrderByExpirationDateAsc(boolean boolVal);
	
	List<CustomerLocker> findAll(Sort sort);

}
