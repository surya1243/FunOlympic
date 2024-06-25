package com.pofil.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pofil.model.LockerLog;
import com.pofil.repository.LockerLogRepository;

@Service
public class LockerLogDetailServiceImpl implements LockerLogDetailService {
	
	LockerLogRepository lockerLogRepository;
	
	@Autowired
	public LockerLogDetailServiceImpl(LockerLogRepository lockerLogRepository) {
		this.lockerLogRepository = lockerLogRepository;
	}

	@Override
	public LockerLog saveLockerLogDetail(LockerLog lockerLogDetail) {
		lockerLogRepository.save(lockerLogDetail);
		return lockerLogRepository.save(lockerLogDetail);
	}

	@Override
	public List<LockerLog> getAllLockerLogDetail() {
		return lockerLogRepository.findAll();
	}

	@Override
	public Optional<LockerLog> getLockerByLockerId(String lockerId) {
		return lockerLogRepository.findByLockerId(lockerId);
	}

	@Override
	public List<LockerLog> getBylockerEnabled(boolean enableValue) {
		return lockerLogRepository.findByEnabled(enableValue);
	}

	@Override
	public List<LockerLog> getByLockerStatus(String lockerStatus) {
		return lockerLogRepository.findByLockerStatus(lockerStatus);
	}

	@Override
	public List<LockerLog> getByLockerExistBranch(String lockerExistBranch) {
		return lockerLogRepository.findByLockerExistBranch(lockerExistBranch);
	}

	@Override
	public List<LockerLog> findAllByOrderByCheckednDateDesc() {
		return lockerLogRepository.findAllByOrderByCheckednDateDesc();
	}

	@Override
	public Optional<LockerLog> findById(String id) {
		return lockerLogRepository.findById(id);
	}



}
