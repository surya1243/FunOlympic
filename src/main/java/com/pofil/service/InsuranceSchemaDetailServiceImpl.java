package com.pofil.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pofil.model.InsuranceSchema;
import com.pofil.repository.InsuranceSchemaRepository;

@Service
public class InsuranceSchemaDetailServiceImpl implements InsuranceSchemaDetailService {

	private InsuranceSchemaRepository schemaRepository;

	@Autowired
	public InsuranceSchemaDetailServiceImpl(InsuranceSchemaRepository schemaRepository) {
		this.schemaRepository = schemaRepository;
	}

	@Override
	public Optional<InsuranceSchema> getInsuranceSchemaById(String id) {
		return schemaRepository.findById(id);
	}

	@Override
	public Optional<InsuranceSchema> findByInsSchemaName(String insSchemaName) {
		return schemaRepository.findByInsSchemaName(insSchemaName);
	}

	@Override
	public InsuranceSchema getInsuranceSchemaByInsSchemaCode(String insCode) {
		return schemaRepository.findByInsSchemaCode(insCode);
	}

	@Override
	public List<InsuranceSchema> getInsuranceSchemas() {
		return schemaRepository.findAll();
	}

	@Override
	public List<InsuranceSchema> getInsuranceSchemaByCompanyName(String insCompanyName) {
		return schemaRepository.findByInsCompanyName(insCompanyName);
	}

	@Override
	public InsuranceSchema saveInsuranceSchema(InsuranceSchema insuranceSchema) {
		schemaRepository.save(insuranceSchema);
		return schemaRepository.save(insuranceSchema);
	}
}
