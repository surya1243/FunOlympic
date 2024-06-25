package com.pofil.service;

import java.util.List;

import com.pofil.model.Custodian;

public interface CustodianDetailService {
	
	List<Custodian> getAllCustodianList();
	Custodian saveCustodian(Custodian custodian);
	
	List<Custodian> findByCustodianTypeA();
	List<Custodian> findByCustodianTypeB();
	

}
