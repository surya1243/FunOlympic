package com.pofil.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.client.DistinctIterable;
import com.mongodb.client.MongoCursor;
import com.pofil.model.AccountInfo;
import com.pofil.model.AppUser;
import com.pofil.model.Budget;
import com.pofil.model.Card;
import com.pofil.model.CardDelivery;
import com.pofil.model.CardRenew;
import com.pofil.model.CustomerLocker;
import com.pofil.model.ErrorIssueLog;
import com.pofil.model.Feedback;
import com.pofil.model.FiscalYear;
import com.pofil.model.GoodForPayment;
import com.pofil.model.InsuranceCompany;
import com.pofil.model.InsuranceCustomer;
import com.pofil.model.InsuranceCustomerRegister;
import com.pofil.model.InsuranceSchema;
import com.pofil.model.LockerLog;
import com.pofil.model.MaintenanceLog;
import com.pofil.model.ManagerCheque;
import com.pofil.model.Minutes;
import com.pofil.model.Sports;
import com.pofil.model.UtilityBills;

import com.pofil.repository.UserRepository;
import com.pofil.service.SportsDetailService;
import com.pofil.service.UserDetailService;

@RestController
public class UtilityRestController {
	@Autowired
	MongoTemplate mongoTemplate;
	
	@Autowired
	private UserDetailService userDetailService;
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private SportsDetailService sportsDetailService;
	

	@RequestMapping(value = "/getsports", method = RequestMethod.GET)
	public List<Sports> getSports() {
		List<Sports> sports = sportsDetailService.getAllSports();
		return sports;
	}
	
	@GetMapping("/sports/count")
    public Map<String, Long> getSportsCount() {
        List<AppUser> users = userRepository.findAll();
        Map<String, Long> sportsCount = new HashMap<>();

        for (AppUser user : users) {
            String[] selectedSports = user.getSelectedSports();
            if (selectedSports != null) { // Check if selectedSports is not null
                for (String sport : selectedSports) {
                    sportsCount.put(sport, sportsCount.getOrDefault(sport, 0L) + 1);
                }
            }
        }
        return sportsCount;
    }
	
	@GetMapping(value = "/viewer/getsportscount/{fieldName}")
	public int getViewerSelectedCount(@PathVariable String fieldName,@AuthenticationPrincipal UserDetails currentUser) {
		userDetailService.getUserByEmail(fieldName);
		AppUser currentUsers = userRepository.findByEmail(currentUser.getUsername());
		return currentUsers.getSelectedSports().length;
	}
}