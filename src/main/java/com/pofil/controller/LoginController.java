package com.pofil.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	@GetMapping({"/login" })
	public String getLoginForm(HttpServletRequest request) {
		if (request.getRemoteUser() != null)
			return "redirect:/dashboard";
		return "login";
	}
	
	@GetMapping({ "/"})
	public String getHomePage(HttpServletRequest request) {
		if (request.getRemoteUser() != null)
			return "redirect:/dashboard";
		return "viewer/homepage";
	}
}
