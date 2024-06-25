package com.pofil.service;

import java.util.List;
import java.util.Optional;

import com.pofil.model.FiscalYear;

public interface FiscalYearDetailService {
	Optional<FiscalYear> getFiscalYearById(String id);

	FiscalYear getFiscalYearName(String fiscalYear);

	List<FiscalYear> getAllFiscalYear();

	FiscalYear saveFiscalYear(FiscalYear fiscalYear);

}
