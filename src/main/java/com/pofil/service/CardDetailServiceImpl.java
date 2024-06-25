package com.pofil.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.pofil.model.Card;
import com.pofil.repository.CardRepository;

@Service
public class CardDetailServiceImpl implements CardDetailService {

	@Autowired
	private CardRepository cardRepository;
	
	@Override
	public Card saveCardDetails(Card card) {
		cardRepository.save(card);
		return cardRepository.save(card);
	}

	@Override
	public List<Card> findAllByRequestDateDesc(Sort sort) {
		return cardRepository.findAll(Sort.by(Sort.Direction.DESC, "requestDate"));
	}

	@Override
	public List<Card> findAllByEnabledStatus(boolean enabledStatus, Sort sort) {
		return cardRepository.findByEnabledStatus(enabledStatus, Sort.by(Sort.Direction.DESC, "requestDate"));
	}

	@Override
	public Optional<Card> findById(String id) {
		return cardRepository.findById(id);
	}

	@Override
	public Optional<Card> findByAccountNumber(String accountNuber) {
		return cardRepository.findByAccountNumber(accountNuber);
	}

	@Override
	public List<Card> findByCardReqOriginatingBranchAndEnabledStatus(String branchName, boolean enabledStatus) {
		return cardRepository.findByCardReqOriginatingBranchAndEnabledStatus(branchName, enabledStatus);
	}

	@Override
	public List<Card> findByCardStatusAndEnabledStatus(String cardStatus, boolean enabledStatus) {
		return cardRepository.findByCardStatusAndEnabledStatus(cardStatus, enabledStatus);
	}

	@Override
	public List<Card> findByCardReqOriginatingBranchAndCardStatusAndEnabledStatus(String branchName, String cardStatus,
			boolean enabledStatus) {
		return cardRepository.findByCardReqOriginatingBranchAndCardStatusAndEnabledStatus(branchName, cardStatus, enabledStatus);
	}

	@Override
	public List<Card> findByRequestDateBetweenAndEnabledStatus(Date start, Date end, boolean enabledStatus) {
		return cardRepository.findByRequestDateBetweenAndEnabledStatus(start, end, enabledStatus);
	}

	@Override
	public List<Card> findByCardStatus(String cardStatus, Sort sort) {
		return cardRepository.findByCardStatus(cardStatus, sort);
	}

	@Override
	public List<Card> findAll(Sort sort) {
		return cardRepository.findAll(Sort.by(Sort.Direction.DESC, "requestDate"));
	}

	@Override
	public List<Card> findByCardReqOriginatingBranch(String branchName, Sort sort) {
		return cardRepository.findByCardReqOriginatingBranch(branchName,  Sort.by(Sort.Direction.DESC, "requestDate"));
	}

	@Override
	public List<Card> findByCardStatusAndCardReqOriginatingBranch(String cardStatus, String branchName, Sort sort) {
		return cardRepository.findByCardStatusAndCardReqOriginatingBranch(cardStatus, branchName, Sort.by(Sort.Direction.DESC, "requestDate"));
	}

	@Override
	public List<Card> findByRequestDateBetween(Date start, Date end, Sort sort) {
		return cardRepository.findByRequestDateBetween(start, end, sort);
	}

	@Override
	public List<Card> findByRequestDateBetweenAndCardStatus(Date start, Date end, String cardStatus, Sort sort) {
		return cardRepository.findByRequestDateBetweenAndCardStatus(start, end, cardStatus, sort);
	}

	@Override
	public List<Card> findByRequestDateBetweenAndCardStatusAndCardReqOriginatingBranch(Date start, Date end,
			String cardStatus, String branchName, Sort sort) {
		return cardRepository.findByRequestDateBetweenAndCardStatusAndCardReqOriginatingBranch(start, end, cardStatus, branchName, sort);
	}
}
