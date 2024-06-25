package com.pofil.repository;

import com.pofil.model.MaintenanceLog;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MaintenanceLogRepository extends MongoRepository<MaintenanceLog, String> {
	
	Optional<MaintenanceLog> findById(String id);
	
	List<MaintenanceLog> findByBranchName(String branchName);
	List<MaintenanceLog> findByCustomerAppDateBetween(Date start, Date end);
	List<MaintenanceLog> findByCustomerAppDateBetweenAndBranchName(Date start, Date end, String branchName);
    
}