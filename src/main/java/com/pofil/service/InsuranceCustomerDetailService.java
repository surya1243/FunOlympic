package com.pofil.service;

import com.pofil.model.InsuranceCustomer;

import java.util.List;
import java.util.Optional;

public interface InsuranceCustomerDetailService {
    Optional<InsuranceCustomer> getInsCustomerById(String id);

    InsuranceCustomer getInsuranceCustomerByName(String insCustomerName);

InsuranceCustomer getInsuranceCustomerByClientCode(int cCode);

    List<InsuranceCustomer> getAllInsuranceCustomers();

    InsuranceCustomer saveInsCustomer(InsuranceCustomer insuranceCustomer);

}
