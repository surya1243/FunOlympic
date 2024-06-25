package com.pofil.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pofil.model.InsuranceCustomer;

public interface InsuranceCustomerRepository extends MongoRepository<InsuranceCustomer, String> {
    InsuranceCustomer findInsuranceCustomerByBankAccNo(String accountNo);

    InsuranceCustomer findInsuranceCustomerByClientCode(int cCode);
}
