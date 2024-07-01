package com.pofil.service;

import java.util.List;
import java.util.Optional;

import com.pofil.model.Sports;

public interface SportsDetailService {
	
	Optional<Sports> getSportsById(String id);
	Optional<Sports> getSportsBySportsName(String sportsName);
	Optional<Sports> getSportsBySportsCode(String sportsCode);
	List<Sports> getSportsListBySportsName(String sportsName);
	Sports saveSports(Sports sports);
	List<Sports> getAllSports();
	List<Sports> getSportsBySportsNameList(String[] sportsName);

}
