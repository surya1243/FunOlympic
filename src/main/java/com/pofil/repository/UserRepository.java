package com.pofil.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.pofil.model.AppUser;

public interface UserRepository extends MongoRepository<AppUser, String> {
	AppUser findByEmail(String email);

	AppUser findByEmailAndRoles(String email, String roles);

	/* Long countUser(String field, String value); */
	@Query(value = "{?0: ?1}", count = true)
	Long countViewerSportsCount(String field, String value);
}
