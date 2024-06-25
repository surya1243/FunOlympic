package com.pofil.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.pofil.model.CardRenew;
import com.pofil.repository.CardRenewRepository;

@Service
public class CardRenewDetailServiceImpl implements CardRenewDetailService {
	
	@Autowired
	private CardRenewRepository cardRenewRepository;

	@Override
	public CardRenew saveCardRenewDetails(CardRenew cardRenew) {
		cardRenewRepository.save(cardRenew);
		return cardRenewRepository.save(cardRenew);
	}

	@Override
	public Optional<CardRenew> findById(String id) {
		return cardRenewRepository.findById(id);
	}

	@Override
	public List<CardRenew> findAllByRenewRequestDateDesc(Sort sort) {
		return cardRenewRepository.findAllByRenewRequestDate(Sort.by(Sort.Direction.DESC, "renewRequestDate"));
	}

	@Override
	public List<CardRenew> findAllByEnabledStatus(boolean enabledStatus, Sort sort) {
		return cardRenewRepository.findByEnabledStatus(enabledStatus, Sort.by(Sort.Direction.DESC, "renewRequestDate"));
	}

	@Override
	public List<CardRenew> findByAccountNumberAndEnabledStatus(String accountNumber, boolean enabledStatus) {
		return cardRenewRepository.findByAccountNumberAndEnabledStatus(accountNumber, enabledStatus);
	}

	@Override
	public List<CardRenew> findByCardReqOriginatingBranchAndEnabledStatus(String branchName, boolean enabledStatus) {
		return cardRenewRepository.findByCardReqOriginatingBranchAndEnabledStatus(branchName, enabledStatus);
	}

	@Override
	public List<CardRenew> findByCardStatusAndEnabledStatus(String cardStatus, boolean enabledStatus) {
		return cardRenewRepository.findByCardStatusAndEnabledStatus(cardStatus, enabledStatus);
	}

	@Override
	public List<CardRenew> findByCardReqOriginatingBranchAndCardStatusAndEnabledStatus(String branchName,
			String cardStatus, boolean enabledStatus) {
		return cardRenewRepository.findByCardReqOriginatingBranchAndCardStatusAndEnabledStatus(branchName, cardStatus, enabledStatus);
	}

	@Override
	public List<CardRenew> findByRenewRequestDateBetweenAndEnabledStatus(Date start, Date end, boolean enabledStatus) {
		return cardRenewRepository.findByRenewRequestDateBetweenAndEnabledStatus(start, end, enabledStatus);
	}

	@Override
	public List<CardRenew> findByCardStatus(String cardStatus, Sort sort) {
		return cardRenewRepository.findByCardStatus(cardStatus, Sort.by(Sort.Direction.DESC, "renewRequestDate"));
	}

	@Override
	public List<CardRenew> findByCardReqOriginatingBranchAndCardStatus(String cardReqOriginatingBranch,
			String cardStatus, Sort sort) {
		return cardRenewRepository.findByCardReqOriginatingBranchAndCardStatus(cardReqOriginatingBranch, cardStatus, Sort.by(Sort.Direction.DESC, "renewRequestDate"));
	}


	@Override
	public List<CardRenew> findByRenewRequestDateBetweenAndCardStatus(Date start, Date end, String cardStatus) {
		return cardRenewRepository.findByRenewRequestDateBetweenAndCardStatus(start, end, cardStatus);
	}

	@Override
	public List<CardRenew> findByRenewRequestDateBetweenAndCardStatusAndCardReqOriginatingBranch(Date start, Date end,
			String cardStatus, String cardReqOriginatingBranch) {
		return cardRenewRepository.findByRenewRequestDateBetweenAndCardStatusAndCardReqOriginatingBranch(start, end, cardStatus, cardReqOriginatingBranch);
	}

	@Override
	public List<CardRenew> findByCardReqOriginatingBranch(String cardReqOriginatingBranch, Sort sort) {
		return cardRenewRepository.findByCardReqOriginatingBranch(cardReqOriginatingBranch, Sort.by(Sort.Direction.DESC, "renewRequestDate"));
	}

	@Override
	public List<CardRenew> findByRenewRequestDateBetween(Date start, Date end, Sort sort) {
		return cardRenewRepository.findByRenewRequestDateBetween(start, end, Sort.by("renewRequestDate").descending());
	}

}
