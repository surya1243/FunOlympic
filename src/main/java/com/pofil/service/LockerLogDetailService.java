package com.pofil.service;

import java.util.List;
import java.util.Optional;

import com.pofil.model.LockerLog;

public interface LockerLogDetailService {
	
	LockerLog saveLockerLogDetail(LockerLog lockerLogDetail);

	List<LockerLog> getAllLockerLogDetail();
	
	List<LockerLog> getByLockerStatus(String lockerStatus);
	
	List<LockerLog> getByLockerExistBranch(String lockerExistBranch);

	Optional<LockerLog> getLockerByLockerId(String lockerId);
	
	List<LockerLog> getBylockerEnabled(boolean enableValue);
	
	List<LockerLog> findAllByOrderByCheckednDateDesc();

	Optional<LockerLog> findById(String id);
	
	



}
