package com.pofil.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.pofil.model.GoodForPayment;
import com.pofil.repository.GoodForPaymentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodForPaymentDetailServiceImpl implements GoodForPaymentDetailService {

    @Autowired
    private GoodForPaymentRepository gfpRepository;

    @Override
    public List<GoodForPayment> getAllGfpList() {
        return gfpRepository.findAll();
    }

    @Override
    public List<GoodForPayment> getByBranchName(String branchName) {
        return gfpRepository.findByBranchName(branchName);
    }

    @Override
    public List<GoodForPayment> getByGfpStatus(String gfpStatus) {
        return gfpRepository.findByGfpStatus(gfpStatus);
    }

    @Override
    public Optional<GoodForPayment> getGfpById(String id) {
        return gfpRepository.findById(id);
    }

    @Override
    public List<GoodForPayment> getGfpByPartiesName(String partiesName) {
        return null;
    }

    @Override
    public GoodForPayment saveGfpRecords(GoodForPayment gfpRecords) {
    	gfpRepository.save(gfpRecords);
        return gfpRepository.save(gfpRecords);
    }

	@Override
	public List<GoodForPayment> getByBranchNameAndGFPStatus(String branchName, String gfpStatus) {
		return gfpRepository.findByBranchNameAndGfpStatus(branchName, gfpStatus);
	}

	@Override
	public List<GoodForPayment> getByIssueDateBetween(Date start, Date end) {
		return gfpRepository.findByIssueDateBetween(start, end);
	}

	@Override
	public List<GoodForPayment> getByBranchNameAndIssueDateBetween(String branchName, Date start, Date end) {
		return gfpRepository.findByBranchNameAndIssueDateBetween(branchName, start, end);
	}

	@Override
	public Long countGoodForPayment(String field, String value) {
		return gfpRepository.countGoodForPayment(field, value);
	}

  
    
}