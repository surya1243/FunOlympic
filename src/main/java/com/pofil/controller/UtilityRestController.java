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
import com.pofil.repository.CardRenewRepository;
import com.pofil.repository.CardRepository;
import com.pofil.repository.FeedbackRepository;
import com.pofil.repository.InsuranceCustomerRegisterRepository;
import com.pofil.repository.InsuranceCustomerRepository;
import com.pofil.repository.LockerLogRepository;
import com.pofil.repository.MaintenanceLogRepository;
import com.pofil.repository.MinutesRepository;
import com.pofil.repository.UserRepository;
import com.pofil.repository.UtilityBillsRepository;
import com.pofil.service.AccountInfoDetailService;
import com.pofil.service.BudgetDetailService;
import com.pofil.service.CardDeliveryDetailService;
import com.pofil.service.CardDetailService;
import com.pofil.service.CardRenewDetailService;
import com.pofil.service.ErrorIssueLogDetailService;
import com.pofil.service.FeedbackDetailService;
import com.pofil.service.FiscalYearDetailService;
import com.pofil.service.GoodForPaymentDetailService;
import com.pofil.service.InsuranceCompanyDetailService;
import com.pofil.service.InsuranceCustomerRegisterDetailService;
import com.pofil.service.InsuranceSchemaDetailService;
import com.pofil.service.LockerDetailService;
import com.pofil.service.LockerLogDetailService;
import com.pofil.service.MaintenanceLogDetailService;
import com.pofil.service.ManagerChequeDetailService;
import com.pofil.service.SportsDetailService;
import com.pofil.service.UserDetailService;
import com.pofil.service.UtilityBillsDetailService;
import com.pofil.util.Response;

@RestController
public class UtilityRestController {
	@Autowired
	MongoTemplate mongoTemplate;
	@Autowired
	private FeedbackDetailService feedbackDetailService;
	
	@Autowired
	private MinutesRepository minutesRepository;
	
	@Autowired
	private UserDetailService userDetailService;
	
	@Autowired
	private InsuranceCustomerRegisterRepository insCustRegisterRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	UtilityBillsDetailService utilityDetailService;
	@Autowired
	FeedbackRepository feedbackRepository;
	@Autowired
	UtilityBillsRepository utilityBillsRepository;
	@Autowired
	private FiscalYearDetailService fiscalYearDetailService;
	
	@Autowired
	private SportsDetailService sportsDetailService;
	
	@Autowired
	private InsuranceCustomerRegisterDetailService insCustRegisterDetailService;
	@Autowired
	private InsuranceCompanyDetailService insuranceCompanyDetailService;
	@Autowired
	private InsuranceSchemaDetailService insuranceSchemaDetailService;
	@Autowired
	private GoodForPaymentDetailService goodForPaymentDetailService;
	@Autowired
	private InsuranceCustomerRepository insuranceCustomerRepository;
	@Autowired
	private ManagerChequeDetailService managerChequeDetailService;
	
	@Autowired
	private LockerLogDetailService lockerLogDetailService;	
	
	@Autowired
	private ErrorIssueLogDetailService errorIssueLogDetailService;
	
	@Autowired
	LockerLogRepository lockerLogRepository;
	
	@Autowired
	BudgetDetailService budgetDetailService;
	
	@Autowired
	private CardDetailService cardDetailService;
	@Autowired
	private CardRenewDetailService cardRenewDetailService;
	
	@Autowired
	private CardDeliveryDetailService cardDeliverDetailService;
	
	@Autowired
	private CardRepository cardRepository;
	@Autowired
	private CardRenewRepository cardRenewRepository;
	@Autowired
	private MaintenanceLogRepository maintenanceLogRepository;
	@Autowired
	private MaintenanceLogDetailService maintenanceLogDetailService;
	@Autowired
	private LockerDetailService lockerDetailService;
	@Autowired
	private AccountInfoDetailService accountInfoDetailService;

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
}