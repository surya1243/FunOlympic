package com.pofil.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DashboardController {
	
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR', 'HOD', 'CAD','GAD','MAKER', 'VIEWER','FEEDBACK', 'LOCKER', 'MINUTES','CARDMAKER','CARDSUPERVISOR', 'CARDCUSTODIAN')")
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String getDemo(HttpServletRequest request, Model model) {		
		return "fragments/dashboard";
	}
	
}
