package com.pofil.service;

import com.pofil.model.MaintenanceLog;
import com.pofil.repository.MaintenanceLogRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaintenanceLogDetailServiceImpl implements MaintenanceLogDetailService {

    @Autowired
    private MaintenanceLogRepository maintenanceLogRepository;
    @Override
    public MaintenanceLog saveMaintenanceLog(MaintenanceLog maintenanceLog) {
        maintenanceLogRepository.save(maintenanceLog);
        return maintenanceLogRepository.save(maintenanceLog);
    }
	@Override
	public Optional<MaintenanceLog> findById(String id) {
		return maintenanceLogRepository.findById(id);
	}
	@Override
	public List<MaintenanceLog> findByBranchName(String branchName) {
		return maintenanceLogRepository.findByBranchName(branchName);
	}
	@Override
	public List<MaintenanceLog> findByCustomerAppDateBetween(Date start, Date end) {
		return maintenanceLogRepository.findByCustomerAppDateBetween(start, end);
	}
	@Override
	public List<MaintenanceLog> findByCustomerAppDateBetweenAndBranchName(Date start, Date end, String branchName) {
		return maintenanceLogRepository.findByCustomerAppDateBetweenAndBranchName(start, end, branchName);
	}
    
}