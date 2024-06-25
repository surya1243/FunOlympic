package com.pofil.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pofil.model.CustomerLocker;
import com.pofil.model.Sports;

public interface SportsRepository extends MongoRepository<Sports, String> {
	Optional<Sports> findBySportsNameEquals(String sportsName);
	Sports findBySportsName(String sportsName);
	Optional<Sports> findBySportsCode(String sportsCode);
	List<Sports> findAllByOrderBySportsNameAsc(String sportsName);

}

