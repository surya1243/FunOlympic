package com.pofil.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.pofil.model.Locker;
import com.pofil.repository.LockerRepository;
@Service
public class LockerDetailServiceImpl implements LockerDetailService {

	LockerRepository addLockerRepository;
	
	@Autowired
	public LockerDetailServiceImpl(LockerRepository addLockerRepository) {
		this.addLockerRepository = addLockerRepository;
	}

	@Override
	public Locker saveLockerDetail(Locker lockerDetail) {
		addLockerRepository.save(lockerDetail);
		return addLockerRepository.save(lockerDetail);
	}
	@Override
	public List<Locker> getAllLockerDetail() {
		return addLockerRepository.findAll();
	}

	@Override
	public List<Locker> getLockerDetailById() {
		return addLockerRepository.findAll(Sort.by(Sort.Direction.ASC, "lockerId"));
	}

	@Override
	public Optional<Locker> getLockerById(String id) {
		return addLockerRepository.findById(id);
	}

	@Override
	public Long countLocker(String field, String value) {
		return addLockerRepository.countLocker(field, value);
	}

	@Override
	public List<Locker> findByLockerIdLike(String lockerId) {
		return addLockerRepository.findByLockerIdLike(lockerId);
	}

}
