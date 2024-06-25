package com.pofil.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.pofil.model.Locker;

public interface LockerRepository extends MongoRepository<Locker, String>{
	Locker findBylockerId(String lockerId);
	Optional<Locker> findById(String id);
	@Query(value = "{?0: ?1}", count = true)
	Long countLocker(String field, String value);
	
	List<Locker> findByLockerIdLike(String lockerId);
}
