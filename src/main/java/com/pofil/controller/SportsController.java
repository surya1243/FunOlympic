package com.pofil.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pofil.model.AppUser;
import com.pofil.model.Sports;
import com.pofil.repository.SportsRepository;
import com.pofil.service.FileSystemStorageService;
import com.pofil.service.SportsDetailService;
import com.pofil.util.RandomKeyGenerator;
import com.pofil.util.Response;
import com.pofil.util.StorageFileNotFoundException;

@Controller
public class SportsController {

	@Autowired
	private SportsRepository sportsRepository;
	@Autowired
	private FileSystemStorageService storageService;
	@Autowired
	private SportsDetailService sportsDetailService;

	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping(value = "/addsports")
	public String getDefault(HttpServletRequest request, Model model) {
		List<Sports> sportsList = sportsDetailService.getAllSports();
		model.addAttribute("sportsList", sportsList);
		return "sportslist/add_sports";
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping(value = "/addsports")
	public String saveSportDetail(@Valid @ModelAttribute("sports") Sports sports,
			@RequestParam("file") MultipartFile file, BindingResult bindingResult, RedirectAttributes redirAttrs) {
		Sports sportsExists = sportsRepository.findBySportsName(sports.getSportsName());
		if (file == null || file.isEmpty()) {
			redirAttrs.addFlashAttribute("message", "Empty file!!!");
		}
		if (sportsExists != null) {
			bindingResult.rejectValue("sportsName", "error.sports",
					"There is already a sports name registered with the sports name provided");
		}
		if (bindingResult.hasErrors()) {
			redirAttrs.addFlashAttribute("message", "Could not Register the new Sports Name");
			return "redirect:/addsports";
		} else {
			sports.setId(RandomKeyGenerator.generateUniqueId());
			String fileLocationUrl = saveImageinFile(file);
			sports.setFileLocationUrl(fileLocationUrl);
			sportsRepository.save(sports);
			redirAttrs.addFlashAttribute("successMessage", "New Sports Name has been registered successfully.");
		}
		return "redirect:/addsports";
	}

	@ExceptionHandler(StorageFileNotFoundException.class)
	public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
		return ResponseEntity.notFound().build();
	}

	public String saveImageinFile(MultipartFile file) {
		return storageService.store(file);
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/updatesports/{id}")
	public String updateSports(Model model, @PathVariable String id) {

		Optional<Sports> sportsValue = sportsRepository.findById(id);
		if (sportsValue.isPresent()) {
			model.addAttribute("sportsValue", sportsValue.get());
			return "sportslist/edit_sports_form";
		} else {
			return "redirect:/addsports";
		}
	}

	@PreAuthorize("hasAnyAuthority('ADMIN', 'VIEWER')")
	@GetMapping("/file/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

		Resource file = storageService.loadAsResource(filename);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.body(file);
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/updatesports")
	public ModelAndView saveUpdatedSports(@Valid @ModelAttribute("sports") Sports sports,
			@RequestParam(value = "file", required = false) MultipartFile file, RedirectAttributes redirectAttributes,
			BindingResult bindingResult) {
		ModelAndView modelView = new ModelAndView();
		Optional<Sports> sportsExists = sportsRepository.findById(sports.getId());
		if (sportsExists != null) {
			bindingResult.rejectValue("id", "error.sports",
					"There is already a sports name registered with the same data provided");
		}
		if (bindingResult.hasErrors()) {
			modelView.addObject("message", "Could not Update Sports data");
			modelView.setViewName("sportslist/add_sports");
		}
		if (sports.getId() != null && !StringUtils.isEmpty(sports.getId())) {
			sports.setId(sports.getId());
		}
		try {
			if (!((file == null) || (file.isEmpty()))) {

				String fileLocationUrl = saveImageinFile(file);
				sports.setFileLocationUrl(fileLocationUrl);
				redirectAttributes.addFlashAttribute("successMessage",
						"You have successfully saved " + file.getOriginalFilename() + "!");
				storageService.delete(sportsExists.get().getFileLocationUrl());

			} else {
				redirectAttributes.addFlashAttribute("successMessage",
						"Sports details has been updated successfully!!! ");
			}

			sportsRepository.save(sports);
			redirectAttributes.addFlashAttribute("successMessage", "Sports data has been updated successfully.");
		} catch (Exception e) {
			modelView.addObject("message", "Could not Update Sports data due to Duplicate Id.");
			modelView.addObject("lockerValue", sportsExists);
			modelView.setViewName("sportslist/add_sports");
		}

		return new ModelAndView("redirect:/addsports");
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@DeleteMapping("/updatesports/delete/{id}")
	public @ResponseBody Response deleteSports(@PathVariable String id) {
		Sports sports = sportsRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Sports Id:" + id));
		try {
			sportsRepository.delete(sports);
			storageService.delete(sports.getFileLocationUrl());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Response((sports.getSportsCode() + ' ' + sports.getSportsName()), true,
				"has been deleted successfully!!!");
	}
}
