package com.pofil.service;

import java.util.List;
import java.util.Optional;

import com.pofil.model.Locker;

public interface LockerDetailService {

	Locker saveLockerDetail(Locker lockerDetail);

	List<Locker> getAllLockerDetail();

	Optional<Locker> getLockerById(String id);

	List<Locker> getLockerDetailById();

	Long countLocker(String field, String value);
	
	List<Locker> findByLockerIdLike(String lockerId);
}
