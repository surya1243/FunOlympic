package com.pofil.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.pofil.model.Budget;
import com.pofil.model.FiscalYear;
import com.pofil.repository.BudgetRepository;
import com.pofil.repository.FiscalYearRepository;
import com.pofil.service.BudgetDetailService;
import com.pofil.service.FiscalYearDetailService;
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

@Controller
public class BudgetController {
	@Autowired
	private BudgetRepository budgetRepository;
	
	
	@Autowired
	BudgetDetailService budgetDetailService;
	
	@Autowired
	FiscalYearRepository fiscalYearRepository;
	
	@Autowired
	FiscalYearDetailService fiscalYearDetailService;

	
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR')")
	@GetMapping("/addbudget")
	public String getBudgetForm(HttpServletRequest request, Model model) {
		return "budget/budget_form";
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR')")
	@PostMapping("/addbudget")
	public String saveBudgetDetail(@Valid Budget budget, BindingResult bindingResult, RedirectAttributes redirAttrs) {
		List<Budget> existBudget = budgetDetailService.findByBudgetTitle(budget.getBudgetTitle());
		
		if(existBudget != null && !existBudget.isEmpty()) {
			redirAttrs.addFlashAttribute("message", "Budget with same Title already exists.");
			return "redirect:/addbudget";
		}
	
		if (bindingResult.hasErrors()) {
			redirAttrs.addFlashAttribute("message", "Could not Register the new Budget data");
			return "redirect:/addbudget";
		} else {
			budget.setId(RandomKeyGenerator.generateUniqueId());
			budgetRepository.save(budget);
			redirAttrs.addFlashAttribute("successMessage", "Budget details has been registered successfully");
		}
		return "redirect:/getbudget";
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR', 'HOD', 'CAD','GAD','MAKER', 'VIEWER','FEEDBACK', 'LOCKER', 'MINUTES')")
	@GetMapping("/getbudget")
	public String getBudgetList(HttpServletRequest request, Model model) {
		List<Budget> budgetQuaterly = budgetRepository.findByTargetType("Quarterly");
		List<Budget> budgetMonthly = budgetRepository.findByTargetType("Monthly");
		List<Budget> budgetAnnual = budgetRepository.findByTargetType("Annual");
		model.addAttribute("budgetQuaterly",budgetQuaterly);
		model.addAttribute("budgetMonthly",budgetMonthly);
		model.addAttribute("budgetAnnual",budgetAnnual);
		return "budget/budget_list";
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR', 'HOD', 'CAD','GAD','MAKER', 'VIEWER','FEEDBACK', 'LOCKER', 'MINUTES')")
	@GetMapping("/getbudget/{id}")
	public String getSingleBudget(Model model, @PathVariable String id) {
		Optional<Budget> budgetDetail = budgetRepository.findById(id);
		if (budgetDetail.isPresent()) {
	        model.addAttribute("budgetValue", budgetDetail.get());
	        return "budget/budget_details";
		}
		return "redirect:/getbudget";
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR')")
	@GetMapping("/updatebudget/{id}")
	public String updateSingleBudget(Model model, @PathVariable String id) {
		Optional<Budget> budgetValue = budgetRepository.findById(id);
		List<FiscalYear> fiscalYearValue = fiscalYearRepository.findAll();
		if (budgetValue.isPresent()) {
	        model.addAttribute("budgetValue", budgetValue.get());
	        model.addAttribute("fiscalYearValue",fiscalYearValue );
	        return "budget/update_budget_form";
		}
		return "redirect:/getbudget";
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR')")
	@PostMapping("/updatebudget")
	public ModelAndView saveupdatedBudgetData(@Valid @ModelAttribute("budget") Budget budget, BindingResult bindingResult, RedirectAttributes redirAttrs) {
		ModelAndView modelView = new ModelAndView();
        if(bindingResult.hasErrors()){
        	modelView.addObject("message", "Could not Update Budget data");
        	modelView.setViewName("budget/budget_form");
        }
        if (budget.getId() != null  && !StringUtils.isEmpty(budget.getId())) {
        	budget.setId(budget.getId());
        }
        try {
        	budgetRepository.save(budget);
        	redirAttrs.addFlashAttribute("successMessage", "Budget details has been updated successfully");
		} catch (Exception  e) {
			redirAttrs.addFlashAttribute("message", "Could not Update Budget due to Duplicate Budget Title.");
			modelView.setViewName("budget/update_budget_form");
		}finally {
			redirAttrs.addFlashAttribute("budgetList", budgetRepository.findAll());
	        modelView.setViewName("budget/budget_list");
		}
		return new ModelAndView("redirect:/getbudget");
		}
	
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR')")
	@DeleteMapping("/updatebudget/delete/{id}")
	public @ResponseBody Response deleteBudget(@PathVariable String id) {
		Budget budgetId = budgetRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Error Issue Id:" + id));
		budgetRepository.delete(budgetId);
		return new Response(("Title: "+budgetId.getBudgetTitle()), true, " Has been deleted successfully!!!");
	}

}
