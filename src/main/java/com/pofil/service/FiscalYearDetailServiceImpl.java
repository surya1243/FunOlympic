package com.pofil.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.pofil.model.FiscalYear;
import com.pofil.repository.FiscalYearRepository;
@Service
public class FiscalYearDetailServiceImpl implements FiscalYearDetailService {
	
	private FiscalYearRepository fiscalYearRepository;
	
	@Autowired
	public FiscalYearDetailServiceImpl(FiscalYearRepository fiscalYearRepository) {
		this.fiscalYearRepository = fiscalYearRepository;
	}


	@Override
	public Optional<FiscalYear> getFiscalYearById(String id) {
		return fiscalYearRepository.findById(id);
	}

	@Override
	public FiscalYear getFiscalYearName(String fiscalYear) {
		return fiscalYearRepository.findByFiscalYears(fiscalYear);
	}

	@Override
	public List<FiscalYear> getAllFiscalYear() {
		return fiscalYearRepository.findAll(Sort.by(Sort.Direction.DESC, "fiscalYears"));
	}

	@Override
	public FiscalYear saveFiscalYear(FiscalYear fiscalYear) {		
		fiscalYearRepository.save(fiscalYear);
		return fiscalYearRepository.save(fiscalYear);
	}

}
