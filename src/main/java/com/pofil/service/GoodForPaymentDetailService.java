package com.pofil.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.pofil.model.GoodForPayment;

/**
 * GoodForPaymentDetailService
 */
public interface GoodForPaymentDetailService {

    Optional<GoodForPayment> getGfpById(String id);

	List<GoodForPayment> getGfpByPartiesName(String partiesName);

	List<GoodForPayment> getAllGfpList();

    GoodForPayment saveGfpRecords(GoodForPayment gfpRecords);
    
    List<GoodForPayment> getByBranchName(String branchName);

    List<GoodForPayment> getByGfpStatus(String gfpStatus);
    
	List<GoodForPayment> getByBranchNameAndGFPStatus(String branchName, String mcStatus);

	List<GoodForPayment> getByIssueDateBetween(Date start, Date end);
    
	List<GoodForPayment> getByBranchNameAndIssueDateBetween(String branchName, Date start, Date end);
	
	Long countGoodForPayment(String field, String value);
}