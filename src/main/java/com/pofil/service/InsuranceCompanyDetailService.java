package com.pofil.service;

import java.util.List;
import java.util.Optional;

import com.pofil.model.InsuranceCompany;

public interface InsuranceCompanyDetailService {

	Optional<InsuranceCompany> getInsCompanyById(String id);

	Optional<InsuranceCompany> getInsCompanyByName(String insCompanyName);

	InsuranceCompany getInsCompanyByCode(String insCompanyCode);

	List<InsuranceCompany> getAllInsCompany();

	InsuranceCompany saveInsCompany(InsuranceCompany insCompany);

}
