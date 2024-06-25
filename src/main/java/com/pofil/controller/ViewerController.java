package com.pofil.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pofil.model.AppUser;
import com.pofil.model.Sports;
import com.pofil.repository.UserRepository;
import com.pofil.service.CustomUserDetailsService;
import com.pofil.service.SportsDetailService;
import com.pofil.service.UserDetailService;

@Controller
public class ViewerController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserDetailService userDetailService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private SportsDetailService sportsDetailService;
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR', 'HOD', 'CAD','GAD','MAKER', 'VIEWER','FEEDBACK', 'LOCKER', 'MINUTES')")
	@GetMapping("/changePassword")
	public String updatePassword(Model model, @AuthenticationPrincipal UserDetails currentUser) {
		AppUser user = userRepository.findByEmail(currentUser.getUsername());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String currentDate = LocalDateTime.now().format(formatter);
        model.addAttribute("currentDate", currentDate);
		model.addAttribute("user", user);
		return "user/change_password_form";
	}

	/*
	 * @PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR', 'HOD', 'CAD','GAD','MAKER', 'VIEWER','FEEDBACK', 'LOCKER', 'MINUTES')"
	 * )
	 * 
	 * @PostMapping("/changePassword") public ModelAndView
	 * saveUpdatedPassword(@Valid @ModelAttribute("appUser") AppUser appUser,
	 * 
	 * @RequestParam("password") String password, @RequestParam("roles") String
	 * roles, BindingResult result) { ModelAndView modelAndView = new
	 * ModelAndView(); if(result.hasErrors()){ modelAndView.addObject("message",
	 * "Could not Update Password");
	 * modelAndView.setViewName("fragments/dashboard"); } if (!((password == null)
	 * || (password.isEmpty()))) { customUserDetailsService.saveUser(appUser,
	 * roles); modelAndView.addObject("successMessage",
	 * "Password updated successfully.");
	 * modelAndView.setViewName("fragments/dashboard"); } return modelAndView; }
	 */
	
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR', 'HOD', 'CAD','GAD','MAKER', 'VIEWER','FEEDBACK', 'LOCKER', 'MINUTES')")
	@PostMapping("/changePassword")
	public ModelAndView saveUpdatedPassword(@Valid @ModelAttribute("appUser") AppUser appUser,@AuthenticationPrincipal UserDetails currentUser,
			@RequestParam("password") String password, BindingResult result) {
				ModelAndView modelAndView = new ModelAndView();
				if(result.hasErrors()){
					modelAndView.addObject("message", "Could not Update Password");
					modelAndView.setViewName("fragments/dashboard");
				}
				if (!((password == null) || (password.isEmpty()))) {
					userDetailService.updatePassword(currentUser.getUsername(), bCryptPasswordEncoder.encode(password));
					
					modelAndView.addObject("successMessage", "Password updated successfully.");
					modelAndView.setViewName("fragments/dashboard");
				}
		return modelAndView;
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR', 'HOD', 'CAD','GAD','MAKER', 'VIEWER','FEEDBACK', 'LOCKER', 'MINUTES')")
	@GetMapping("/getuserprofile")
	public String showUserProfile(Model model, @AuthenticationPrincipal UserDetails currentUser) {
		AppUser user = userRepository.findByEmail(currentUser.getUsername());
		model.addAttribute("currentUser", user);
		return "user/user_profile";
	}

}
