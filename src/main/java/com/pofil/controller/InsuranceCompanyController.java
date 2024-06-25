package com.pofil.controller;

import com.pofil.model.InsuranceSchema;
import com.pofil.repository.InsuranceSchemaRepository;
import com.pofil.service.InsuranceSchemaDetailService;
import com.pofil.util.RandomKeyGenerator;
import com.pofil.util.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pofil.model.InsuranceCompany;
import com.pofil.repository.InsuranceCompanyRepository;
import com.pofil.service.InsuranceCompanyDetailService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import java.util.Optional;

@Controller
public class InsuranceCompanyController {
	@Autowired
	private InsuranceCompanyRepository insuranceCompanyRepository;

	@Autowired
	private InsuranceSchemaRepository schemaRepository;

	@Autowired
	private InsuranceCompanyDetailService insCompanyService;

	@Autowired
	private InsuranceSchemaDetailService insuranceSchemaDetailService;

	@GetMapping(value = "/insSchema")
	public String getInsSchemaForm(HttpServletRequest request, Model model) {
		model.addAttribute("insCompanyList", insCompanyService.getAllInsCompany());
		model.addAttribute("insSchemaList", insuranceSchemaDetailService.getInsuranceSchemas());
		return "insurance/insurance_and_schema_form";
	}

	@PostMapping(value = "/addinscompany")
	public String saveInsuranceCompany(InsuranceCompany insCompany, BindingResult bindingResult,
			RedirectAttributes redirAttrs) {
		InsuranceCompany insCompanyExists = insCompanyService.getInsCompanyByCode(insCompany.getInsCompanyCode());
		if (insCompanyExists != null) {
			bindingResult.rejectValue("insCompanyName", "error.insuranceCompany",
					"There is already a Insurance Company registered with the name provided");
		}
		if (bindingResult.hasErrors()) {
			redirAttrs.addFlashAttribute("message", "Could not Register the new Insurance Company");
		} else {
			insCompany.setId(RandomKeyGenerator.generateUniqueId());
			insuranceCompanyRepository.save(insCompany);
			redirAttrs.addFlashAttribute("successMessage", "Insurance Company has been registered successfully");
		}
		return "redirect:/insSchema";
	}

	@PostMapping(value = "/addinsschema")
	public String saveInsuranceSchema(InsuranceSchema insSchema, BindingResult bindingResult,
			RedirectAttributes redirAttrs) {
		InsuranceSchema insSchemeExists = insuranceSchemaDetailService
				.getInsuranceSchemaByInsSchemaCode(insSchema.getInsSchemaCode());
		if (insSchemeExists != null) {
			bindingResult.rejectValue("insSchemaCode", "error.insSchema",
					"There is already a code registered with the Schema Code provided");
		}
		if (bindingResult.hasErrors()) {
			redirAttrs.addFlashAttribute("message", "Could not Register the new Schema Product");
		} else {
			insSchema.setId(RandomKeyGenerator.generateUniqueId());
			schemaRepository.save(insSchema);
			redirAttrs.addFlashAttribute("successMessage", "Schema Product has been registered successfully");
		}
		return "redirect:/insSchema";
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/updateinscompany")
	public ModelAndView saveUpdatedInsCompany(
			@Valid @ModelAttribute("insuranceCompany") InsuranceCompany insuranceCompany, BindingResult bindingResult, RedirectAttributes redirAttrs) {
		ModelAndView modelView = new ModelAndView();
		InsuranceCompany insCompanyExists = insCompanyService.getInsCompanyByCode(insuranceCompany.getInsCompanyCode());
		if (insCompanyExists != null) {
			bindingResult.rejectValue("insCompanyName", "error.insuranceCompany",
					"There is already a Insurance Company registered with the name provided");
		}
		if (bindingResult.hasErrors()) {
			modelView.addObject("message", "Could not Register the new Insurance Company");
			modelView.setViewName("register");
		}
        if (insuranceCompany.getId() != null && !StringUtils.isEmpty(insuranceCompany.getId())) {
        	insuranceCompany.setId(insuranceCompany.getId());
        }
        try {
        	insuranceCompanyRepository.save(insuranceCompany);
            redirAttrs.addFlashAttribute("successMessage", "Insurance Company has been updated successfully");
        } catch (Exception e) {
            modelView.addObject("message", "Could not Update Insurance Company data due to Duplicate Id");
            modelView.setViewName("register");
        } finally {
        	modelView.addObject("insCompanyList", insCompanyService.getAllInsCompany());
        	modelView.addObject("insSchemaList", insuranceSchemaDetailService.getInsuranceSchemas());
            modelView.setViewName("insurance/insurance_and_schema_form");
        }
		return new ModelAndView("redirect:/insSchema");
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/updateinscompanyscheme")
	public ModelAndView saveUpdatedInsScheme(@Valid @ModelAttribute("insuranceSchema") InsuranceSchema insuranceSchema,
			BindingResult bindingResult, RedirectAttributes redirAttrs) {
		ModelAndView modelView = new ModelAndView();
		InsuranceSchema insSchemeExists = insuranceSchemaDetailService
				.getInsuranceSchemaByInsSchemaCode(insuranceSchema.getInsSchemaCode());
		if (insSchemeExists != null) {
			bindingResult.rejectValue("insSchemaCode", "error.insSchema",
					"There is already a code registered with the Schema Code provided");
		}
		if (bindingResult.hasErrors()) {
			modelView.addObject("message", "Could not Register the new Schema Product");
			modelView.setViewName("register");
		}
		
		if (insuranceSchema.getId() != null && !StringUtils.isEmpty(insuranceSchema.getId())) {
			insuranceSchema.setId(insuranceSchema.getId());
        }
        try {
        	schemaRepository.save(insuranceSchema);
            redirAttrs.addFlashAttribute("successMessage", "Insurance Schema has been updated successfully");
        } catch (Exception e) {
            modelView.addObject("message", "Could not Update Insurance Schema data due to Duplicate Id");
            modelView.setViewName("register");
        } finally {
        	modelView.addObject("insCompanyList", insCompanyService.getAllInsCompany());
        	modelView.addObject("insSchemaList", insuranceSchemaDetailService.getInsuranceSchemas());
            modelView.setViewName("insurance/insurance_and_schema_form");
        }
		return new ModelAndView("redirect:/insSchema");
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/updateinscompany/{id}")
	public String updateInsCompany(Model model, @PathVariable String id) {
		Optional<InsuranceCompany> fiscalYears = insuranceCompanyRepository.findById(id);
		if (fiscalYears.isPresent()) {
			InsuranceCompany fiscalYearValue = fiscalYears.get();
			model.addAttribute("insuranceCompanyValue", fiscalYearValue);
			return "insurance/update_insurance_company_form";
		} else {
			return "redirect:/insSchema";
		}
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/updateinscompanyscheme/{id}")
	public String updateInsCompanyScheme(Model model, @PathVariable String id) {
		Optional<InsuranceSchema> fiscalYears = schemaRepository.findById(id);
		if (fiscalYears.isPresent()) {
			InsuranceSchema fiscalYearValue = fiscalYears.get();
			model.addAttribute("insuranceSchemeValue", fiscalYearValue);
			return "insurance/update_insurance_schema_form";
		}
		return "redirect:/insSchema";
	}

	@DeleteMapping("/updateinscompany/delete/{id}")
	public @ResponseBody Response deleteInsCompany(@PathVariable String id) {
		InsuranceCompany user = insuranceCompanyRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Insurance Company Id:" + id));
		insuranceCompanyRepository.delete(user);
		return new Response((user.getInsCompanyCode() + ' ' + user.getInsCompanyName()), true,
				"Has been deleted successfully!!!");
	}

	@DeleteMapping("/updateinscompanyscheme/delete/{id}")
	public @ResponseBody Response deleteInsCompanyScheme(@PathVariable String id) {
		InsuranceSchema user = schemaRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Insurance Company Id:" + id));
		schemaRepository.delete(user);
		return new Response((user.getInsSchemaCode() + ' ' + user.getInsSchemaName()), true,
				"Has been deleted successfully!!!");
	}
}
