package com.pofil.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pofil.model.Custodian;

public interface CustodianRepository extends MongoRepository<Custodian, String>{
	
	List<Custodian> findByCustodianTypeAndCustodianName(String custodianType, String custodianName);
	Custodian findByCustodianName(String custodianName);
	List<Custodian> findByCustodianType(String custodianType);
}
