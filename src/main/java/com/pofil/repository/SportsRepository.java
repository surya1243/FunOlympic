package com.pofil.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.pofil.model.Sports;

public interface SportsRepository extends MongoRepository<Sports, String> {
	Optional<Sports> findBySportsNameEquals(String sportsName);
	Sports findBySportsName(String sportsName);
	Optional<Sports> findBySportsCode(String sportsCode);
	List<Sports> findAllByOrderBySportsNameAsc(String sportsName);
	
	@Query("{ 'sportsName' : { $in: ?0 } }")
    List<Sports> findBySportsNameIn(List<String> sportsNames);
}

