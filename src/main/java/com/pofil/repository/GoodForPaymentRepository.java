package com.pofil.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.pofil.model.GoodForPayment;

public interface GoodForPaymentRepository extends MongoRepository<GoodForPayment, String> {
    Optional<GoodForPayment> findById(String id);

    List<GoodForPayment> findByBranchName(String branchName);

    List<GoodForPayment> findByGfpStatus(String gfpStatus);

	List<GoodForPayment> findByBranchNameAndGfpStatus(String branchName, String gfpStatus);

	List<GoodForPayment> findByIssueDateBetween(Date start, Date end);
	
	List<GoodForPayment> findByBranchNameAndIssueDateBetween(String branchName, Date start, Date end);
	
	@Query(value = "{?0: ?1}", count = true)
	Long countGoodForPayment(String field, String value);
}
