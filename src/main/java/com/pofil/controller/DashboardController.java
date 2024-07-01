package com.pofil.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pofil.model.AppUser;
import com.pofil.repository.UserRepository;
import com.pofil.service.SportsDetailService;

@Controller
public class DashboardController {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private SportsDetailService sportsDetailService;
	
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String getDemo(HttpServletRequest request, Model model, @AuthenticationPrincipal UserDetails currentUser) {
		AppUser currentUsers = userRepository.findByEmail(currentUser.getUsername());
		model.addAttribute("currentUser", currentUsers);
		return "fragments/dashboard";
	}
	
	@PreAuthorize("hasAnyAuthority('VIEWER')")
	@RequestMapping(value = "/viewer/dashboard", method = RequestMethod.GET)
	public String getViewerDashboard(HttpServletRequest request, Model model, @AuthenticationPrincipal UserDetails currentUser) {
		AppUser currentUsers = userRepository.findByEmail(currentUser.getUsername());
		String[] selectedSports = currentUsers.getSelectedSports(); // Assuming currentUsers is accessible
	    model.addAttribute("sportsList", selectedSports);
		model.addAttribute("currentUser", currentUsers);
		model.addAttribute("selectedUserSports", sportsDetailService.getSportsBySportsNameList(selectedSports));
		return "viewer/viewerdashboard";
	}
	
}
