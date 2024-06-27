package com.pofil.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang.RandomStringUtils;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pofil.model.AppUser;
import com.pofil.model.Sports;
import com.pofil.repository.RoleRepository;
import com.pofil.repository.UserRepository;
import com.pofil.service.CustomUserDetailsService;
import com.pofil.service.SportsDetailService;
import com.pofil.service.UserDetailService;

@Controller
public class ViewerController {
	public static final int ID_LENGTH = 5;
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
	@Autowired
	private RoleRepository roleRepository;
	
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
	
	@RequestMapping(value = "/viewer/register", method = RequestMethod.POST)
	public String saveUserDetail(@Valid AppUser user, BindingResult bindingResult, 
			RedirectAttributes redirAttrs) {
		AppUser userExists = userDetailService.getUserByEmail(user.getEmail());
		System.out.println(userExists);
		if (userExists != null) {
			redirAttrs.addFlashAttribute("message", "There is already a user registered with the username provided");
			return "redirect:/login";
		}
		if (bindingResult.hasErrors()) {
			redirAttrs.addFlashAttribute("message", "Could not Register the new User");
			return "redirect:/login";
		} else {
			user.setId(generateUniqueId());
			user.setEnabled(true);
			user.setUserCreatedBy(user.getEmail());
			user.setCreatedDate(LocalDateTime.now());
			customUserDetailsService.saveUser(user, "VIEWER");
			redirAttrs.addFlashAttribute("successMessage", "User has been registered successfully");
		}
		return "redirect:/login";
	}
	public String generateUniqueId() {
		return RandomStringUtils.randomAlphanumeric(ID_LENGTH);
	}
	
	@PreAuthorize("hasAnyAuthority('VIEWER')")
	@GetMapping("/getselectedsports")
	public String showSelectedGames(Model model, @AuthenticationPrincipal UserDetails currentUser) {
		AppUser user = userRepository.findByEmail(currentUser.getUsername());
		List<Sports> sports = sportsDetailService.getAllSports();
		model.addAttribute("sports", sports);
		
		
		model.addAttribute("currentUser", user);
		return "viewer/editviewersportslist";
	}
	
	/*
	 * @GetMapping("/updateuser/{id}") public String updateUser(Model
	 * model, @PathVariable String id, @AuthenticationPrincipal UserDetails
	 * currentUser, HttpServletRequest request) { AppUser currentUsers =
	 * userRepository.findByEmail(currentUser.getUsername()); List<Sports> sports =
	 * sportsDetailService.getAllSports(); model.addAttribute("sports", sports);
	 * 
	 * model.addAttribute("currentUser", currentUsers); Optional<AppUser> user =
	 * userRepository.findById(id); model.addAttribute("roleValue",
	 * roleRepository.findAll()); model.addAttribute("user", user.get()); return
	 * "updateuser"; }
	 */

	
}
