package com.pofil.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.pofil.model.InsuranceCustomerRegister;

public interface InsuranceCustomerRegisterDetailService {
	Optional<InsuranceCustomerRegister> getInsCustById(String id);

	List<InsuranceCustomerRegister> getAllInsuranceCustomerRegister();

	List<InsuranceCustomerRegister> findByInsCompanyName(String insCompanyName);

	List<InsuranceCustomerRegister> findByInsCompanyNameAndInsSchemaName(String insCompanyName, String insSchemeName);

	List<InsuranceCustomerRegister> findByInsStartedDateIsBetween(Date firstDate, Date secondDate);

	InsuranceCustomerRegister saveInsCustRegister(InsuranceCustomerRegister insCustRegister);
}
