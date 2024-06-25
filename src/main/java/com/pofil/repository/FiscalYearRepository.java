package com.pofil.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pofil.model.FiscalYear;

public interface FiscalYearRepository extends MongoRepository<FiscalYear, String> {
	FiscalYear findByFiscalYears(String fiscalYear);
}