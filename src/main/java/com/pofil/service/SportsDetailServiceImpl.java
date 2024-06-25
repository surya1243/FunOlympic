package com.pofil.service;
import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.pofil.model.Sports;

import com.pofil.repository.SportsRepository;

@Service
public class SportsDetailServiceImpl implements SportsDetailService{
	
	@Autowired
	private SportsRepository sportsRepository;
	
	@Override
	public Optional<Sports> getSportsById(String id) {
		// TODO Auto-generated method stub
		return sportsRepository.findById(id);
	}

	@Override
	public Optional<Sports> getSportsBySportsName(String sportsName) {
		// TODO Auto-generated method stub
		return sportsRepository.findBySportsNameEquals(sportsName);
	}

	@Override
	public Optional<Sports> getSportsBySportsCode(String sportsCode) {
		// TODO Auto-generated method stub
		return sportsRepository.findBySportsCode(sportsCode);
	}

	@Override
	public List<Sports> getAllSports() {
		// TODO Auto-generated method stub
		return sportsRepository.findAll(Sort.by(Sort.Direction.ASC, "sportsName"));
	}

	@Override
	public Sports saveSports(Sports sports) {
		sportsRepository.save(sports);
		return sportsRepository.save(sports);
	}

	@Override
	public List<Sports> getSportsListBySportsName(String sportsName) {
		// TODO Auto-generated method stub
		return sportsRepository.findAllByOrderBySportsNameAsc(sportsName);
	}

}
