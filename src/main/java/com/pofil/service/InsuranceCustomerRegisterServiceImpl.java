package com.pofil.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pofil.model.InsuranceCustomerRegister;
import com.pofil.repository.InsuranceCustomerRegisterRepository;

@Service
public class InsuranceCustomerRegisterServiceImpl implements InsuranceCustomerRegisterDetailService {
	@Autowired
	private InsuranceCustomerRegisterRepository insCustRegisterRepository;

	@Override
	public Optional<InsuranceCustomerRegister> getInsCustById(String id) {
		return null;
	}

	@Override
	public List<InsuranceCustomerRegister> findByInsCompanyName(String insCompanyName) {
		return insCustRegisterRepository.findByInsCompanyName(insCompanyName);
	}

	@Override
	public List<InsuranceCustomerRegister> getAllInsuranceCustomerRegister() {
		return insCustRegisterRepository.findAll();
	}

	@Override
	public List<InsuranceCustomerRegister> findByInsCompanyNameAndInsSchemaName(String insCompanyName,
			String insSchemeName) {
		return insCustRegisterRepository.findByInsCompanyNameAndInsSchemaName(insCompanyName, insSchemeName);
	}

	@Override
	public List<InsuranceCustomerRegister> findByInsStartedDateIsBetween(Date firstDate, Date secondDate) {
		return insCustRegisterRepository.findByInsStartedDateBetween(firstDate, secondDate);
	}

	@Override
	public InsuranceCustomerRegister saveInsCustRegister(InsuranceCustomerRegister insCustRegister) {
		insCustRegisterRepository.save(insCustRegister);
		return insCustRegisterRepository.save(insCustRegister);
	}
}
