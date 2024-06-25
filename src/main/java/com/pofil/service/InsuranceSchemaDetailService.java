package com.pofil.service;

import java.util.List;
import java.util.Optional;

import com.pofil.model.InsuranceSchema;

public interface InsuranceSchemaDetailService {

	Optional<InsuranceSchema> getInsuranceSchemaById(String id);

	Optional<InsuranceSchema> findByInsSchemaName(String insSchemaName);

	List<InsuranceSchema> getInsuranceSchemaByCompanyName(String insCompanyName);

	InsuranceSchema getInsuranceSchemaByInsSchemaCode(String insCode);

	List<InsuranceSchema> getInsuranceSchemas();

	InsuranceSchema saveInsuranceSchema(InsuranceSchema insuranceSchema);
}
