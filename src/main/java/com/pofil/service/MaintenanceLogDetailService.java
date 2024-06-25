package com.pofil.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.pofil.model.MaintenanceLog;

public interface MaintenanceLogDetailService {

    MaintenanceLog saveMaintenanceLog(MaintenanceLog maintenanceLog);
    Optional<MaintenanceLog> findById(String id);
	List<MaintenanceLog> findByBranchName(String branchName);
	List<MaintenanceLog> findByCustomerAppDateBetween(Date start, Date end);
	List<MaintenanceLog> findByCustomerAppDateBetweenAndBranchName(Date start, Date end, String branchName);
}