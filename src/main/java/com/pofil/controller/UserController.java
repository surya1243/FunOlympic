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
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pofil.model.AppUser;
import com.pofil.model.Sports;
import com.pofil.repository.RoleRepository;
import com.pofil.repository.SportsRepository;
import com.pofil.repository.UserRepository;
import com.pofil.service.CustomUserDetailsService;
import com.pofil.service.SportsDetailService;
import com.pofil.service.UserDetailService;
import com.pofil.util.Response;

@Controller
@RequestMapping("/admin")
public class UserController {
	public static final int ID_LENGTH = 5;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Autowired
	private UserDetailService userService;

	@Autowired
	private SportsRepository sportsRepository;

	@Autowired
	private SportsDetailService sportsDetailService;

	@Autowired
	private RoleRepository roleRepository;

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/default", method = RequestMethod.GET)
	public String getDefault(HttpServletRequest request) {
		return "layouts/default";
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String getHello(HttpServletRequest request) {
		return "test";
	}

	@PreAuthorize("hasAuthority('ADMIN')") 
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String getRegisterForm(Model model, @AuthenticationPrincipal UserDetails currentUser,
			HttpServletRequest request) {
		
		  AppUser user = userRepository.findByEmail(currentUser.getUsername());
		  model.addAttribute("currentUser", user);
		 
		model.addAttribute("roleValue", roleRepository.findAll());
		return "register";
	}

	@PreAuthorize("hasAuthority('ADMIN')") 
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String saveUserDetail(@Valid AppUser user, BindingResult bindingResult, @RequestParam("roles") String roles, 
			RedirectAttributes redirAttrs) {
		AppUser userExists = userService.getUserByEmail(user.getEmail());
		if (userExists != null) {
			redirAttrs.addFlashAttribute("message", "There is already a user registered with the username provided");
			return "redirect:/admin/userlist";
		}
		if (bindingResult.hasErrors()) {
			redirAttrs.addFlashAttribute("message", "Could not Register the new User");
			return "redirect:/admin/register";
		} else {
			user.setId(generateUniqueId());
			user.setEnabled(true);
			user.setCreatedDate(LocalDateTime.now());
			customUserDetailsService.saveUser(user, roles);
			redirAttrs.addFlashAttribute("successMessage", "User has been registered successfully");
		}
		return "redirect:/admin/userlist";
	}
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/userlist", method = RequestMethod.GET)
	public String getUserList(Model model) {
		List<AppUser> userList = userRepository.findAll();
		model.addAttribute("userList", userList);
		model.addAttribute("count", userRepository.count());
		return "userlist";
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/updateuser/{id}")
	public String updateUser(Model model, @PathVariable String id, @AuthenticationPrincipal UserDetails currentUser,
			HttpServletRequest request) {
		AppUser currentUsers = userRepository.findByEmail(currentUser.getUsername());
		List<Sports> sports = sportsDetailService.getAllSports();
	    model.addAttribute("sports", sports);
		
		model.addAttribute("currentUser", currentUsers);
		Optional<AppUser> user = userRepository.findById(id);
		model.addAttribute("roleValue", roleRepository.findAll());
		model.addAttribute("user", user.get());
		return "updateuser";
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/updateuser")
	public String saveUpdatedUser(@Valid @ModelAttribute("user") AppUser user, RedirectAttributes redirAttrs,
			@RequestParam("password") String password, @RequestParam("chpassword") String chpassword,
			@RequestParam("roles") String roles) {
		if (!((password == null) || (password.isEmpty()))) {
			customUserDetailsService.saveUser(user, roles);
		} else {
			user.setPassword(chpassword);

		}
		try {
			user.setLastModifiedDate(LocalDateTime.now());
			customUserDetailsService.updateUser(user, roles);
			redirAttrs.addFlashAttribute("successMessage", "User data has been updated successfully");
		} catch (Exception e) {
			redirAttrs.addFlashAttribute("message", "Could not Update User data due to Duplicate email Id");
		}

		return "redirect:/admin/userlist";
	}


	@PreAuthorize("hasAuthority('ADMIN')")
	@DeleteMapping("/updateuser/delete/{id}")
	public @ResponseBody Response deleteAppUser(@PathVariable String id) {
		AppUser appUserValue = userRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid App User Id:" + id));
		userRepository.delete(appUserValue);
		return new Response(("User Name: " + appUserValue.getFirstName() + " Email: " + appUserValue.getEmail()), true,
				"Has been deleted successfully!!!");
	}

	public String generateUniqueId() {
		return RandomStringUtils.randomAlphanumeric(ID_LENGTH);
	}

}
