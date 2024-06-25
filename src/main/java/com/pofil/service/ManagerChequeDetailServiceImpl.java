
package com.pofil.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pofil.model.ManagerCheque;
import com.pofil.repository.ManagerChequeRepository;

@Service
public class ManagerChequeDetailServiceImpl implements ManagerChequeDetailService {

    @Autowired
    private ManagerChequeRepository mcRepository;
    
    @Override
    public List<ManagerCheque> getAllMcList() {
        return mcRepository.findAll();
    }

    @Override
    public List<ManagerCheque> getByBranchName(String branchName) {
        return mcRepository.findByBranchName(branchName);
    }

    @Override
    public List<ManagerCheque> getByMcStatus(String mcStatus) {
        return mcRepository.findByMcStatus(mcStatus);
    }

    @Override
    public List<ManagerCheque> getGfpByPartiesName(String partiesName) {
        return null;
    }

    @Override
    public Optional<ManagerCheque> getMcById(String id) {
        return mcRepository.findById(id);
    }

    @Override
    public ManagerCheque saveMcRecords(ManagerCheque mcRecords) {
    	mcRepository.save(mcRecords);
        return mcRepository.save(mcRecords);
    }

	@Override
	public List<ManagerCheque> getByBranchNameAndMcStatus(String branchName, String mcStatus) {
		return mcRepository.findByBranchNameAndMcStatus(branchName, mcStatus);
	}

	@Override
	public List<ManagerCheque> getByIssueDateBetween(Date start, Date end) {
		return mcRepository.findByIssueDateBetween(start, end);
	}

	@Override
	public List<ManagerCheque> getByBranchNameAndIssueDateBetween(String branchName, Date start, Date end) {
		return mcRepository.findByBranchNameAndIssueDateBetween(branchName,  start,  end);
	}

	@Override
	public Long countManagerCheque(String field, String value) {
		return mcRepository.countManagerCheque(field, value);
	}
}