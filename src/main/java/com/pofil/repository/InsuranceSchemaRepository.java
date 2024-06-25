package com.pofil.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pofil.model.InsuranceSchema;

public interface InsuranceSchemaRepository extends MongoRepository<InsuranceSchema, String> {
	InsuranceSchema findByInsSchemaCode(String schemaCode);

	List<InsuranceSchema> findByInsCompanyName(String insCompanyName);

	Optional<InsuranceSchema> findByInsSchemaName(String insSchemaName);
}
