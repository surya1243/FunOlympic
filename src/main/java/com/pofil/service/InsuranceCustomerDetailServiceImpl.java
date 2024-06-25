package com.pofil.service;

import com.pofil.model.InsuranceCustomer;
import com.pofil.repository.InsuranceCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class InsuranceCustomerDetailServiceImpl implements InsuranceCustomerDetailService {

    @Autowired
    private InsuranceCustomerRepository insuranceCustomerRepository;

    private InsuranceCustomerDetailService insuranceCustomerDetailService;

    @Override
    public Optional<InsuranceCustomer> getInsCustomerById(String id) {
        return insuranceCustomerRepository.findById(id);
    }

    @Override
    public InsuranceCustomer getInsuranceCustomerByName(String insCustomerName) {
        return insuranceCustomerDetailService.getInsuranceCustomerByName(insCustomerName);
    }

    @Override
    public InsuranceCustomer getInsuranceCustomerByClientCode(int cCode) {
        return insuranceCustomerRepository.findInsuranceCustomerByClientCode(cCode);
    }

    @Override
    public List<InsuranceCustomer> getAllInsuranceCustomers() {
        return insuranceCustomerRepository.findAll();
    }

    @Override
    public InsuranceCustomer saveInsCustomer(InsuranceCustomer insuranceCustomer) {
        insuranceCustomerRepository.save(insuranceCustomer);
        return insuranceCustomerRepository.save(insuranceCustomer);
    }
}
