package com.pofil.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pofil.model.BankCardInfo;

public interface BankCardInfoRepository extends MongoRepository<BankCardInfo, String> {
	
	BankCardInfo findByInstitution(String institution);

}
