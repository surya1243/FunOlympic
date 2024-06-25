package com.pofil.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pofil.model.InsuranceCompany;
import com.pofil.repository.InsuranceCompanyRepository;

@Service
public class InsuranceCompanyDetailServiceImpl implements InsuranceCompanyDetailService {

	private InsuranceCompanyRepository companyRepository;

	@Autowired
	public InsuranceCompanyDetailServiceImpl(InsuranceCompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}

	@Override
	public Optional<InsuranceCompany> getInsCompanyByName(String insCompanyName) {
		return companyRepository.findByInsCompanyName(insCompanyName);
	}

	@Override
	public Optional<InsuranceCompany> getInsCompanyById(String id) {
		return companyRepository.findById(id);
	}

	@Override
	public InsuranceCompany getInsCompanyByCode(String insCompanyCode) {
		return companyRepository.findByInsCompanyCode(insCompanyCode);
	}

	@Override
	public List<InsuranceCompany> getAllInsCompany() {
		return companyRepository.findAll();
	}

	@Override
	public InsuranceCompany saveInsCompany(InsuranceCompany insCompany) {
		companyRepository.save(insCompany);
		return companyRepository.save(insCompany);
	}

}
