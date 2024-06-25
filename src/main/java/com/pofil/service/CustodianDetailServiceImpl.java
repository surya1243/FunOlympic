package com.pofil.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pofil.model.Custodian;
import com.pofil.repository.CustodianRepository;

@Service
public class CustodianDetailServiceImpl implements CustodianDetailService{

	private String custodianTypeA;
	private String custodianTypeB;
	
	
	
	public CustodianDetailServiceImpl() {
		super();
		this.custodianTypeA = "A-Panel";
		this.custodianTypeB = "B-Panel";
	}

	@Autowired
	CustodianRepository custodianRepository;
	
	@Override
	public Custodian saveCustodian(Custodian custodian) {
		custodianRepository.save(custodian);
		return custodianRepository.save(custodian);
	}

	@Override
	public List<Custodian> getAllCustodianList() {
		return custodianRepository.findAll();
	}

	@Override
	public List<Custodian> findByCustodianTypeA() {
		return custodianRepository.findByCustodianType(this.custodianTypeA);
	}
	
	@Override
	public List<Custodian> findByCustodianTypeB() {
		return custodianRepository.findByCustodianType(this.custodianTypeB);
	}

}
