package com.pofil.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	@GetMapping({"/login","/signup" })
	public String getLoginForm(HttpServletRequest request,@RequestParam(required = false) String action, Model model) {
		if (request.getRemoteUser() != null)
			return "redirect:/dashboard";
		model.addAttribute("showSignup", "signup".equals(action));
		return "login";
	}
	
	@GetMapping({ "/"})
	public String getHomePage(HttpServletRequest request) {
		if (request.getRemoteUser() != null)
			return "redirect:/viewer/dashboard";
		return "viewer/homepage";
	}
}
