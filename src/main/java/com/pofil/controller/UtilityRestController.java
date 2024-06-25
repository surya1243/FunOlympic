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

	//Account Opening Log
	@GetMapping(value = "/getallaccountlog")
	public List<AccountInfo> findAllAccountInfo(){
		return accountInfoDetailService.findAll();
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR','HOD', 'GAD','MAKER', 'VIEWER','FEEDBACK','LOCKER','CARDMAKER','CARDSUPERVISOR', 'CARDCUSTODIAN')")
	@GetMapping(value = "/getaccountlog/branchname/{branchName}")
	public List<AccountInfo> findAccountIngoByBranch(@PathVariable String branchName){
		return accountInfoDetailService.findByBranchName(branchName);
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR','HOD', 'GAD','MAKER', 'VIEWER','FEEDBACK','LOCKER','CARDMAKER','CARDSUPERVISOR', 'CARDCUSTODIAN')")
	@GetMapping("/getaccountlog/date/{firstDate}/{secondDate}")
	public List<AccountInfo> getAccountLogsDateBetween(@PathVariable(value = "firstDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date firstDate,
			@PathVariable(value = "secondDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date secondDate) {
		return accountInfoDetailService.findByRegisteredDateBetween(firstDate, secondDate, Sort.by("registeredDate").descending());
	}
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR','HOD', 'GAD','MAKER', 'VIEWER','FEEDBACK','LOCKER','CARDMAKER','CARDSUPERVISOR', 'CARDCUSTODIAN')")
	@GetMapping("/getaccountinfo/date/{firstDate}/{secondDate}/{branchName}")
	public List<AccountInfo> getAccountLogsDateBetweenBranch(@PathVariable(value = "firstDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date firstDate,
			@PathVariable(value = "secondDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date secondDate, @PathVariable String branchName) {
		return accountInfoDetailService.findByRegisteredDateBetweenAndBranchName(firstDate, secondDate,branchName, Sort.by("registeredDate").descending());
	}
	
	@GetMapping("/getaccountinfo/bydate/{date}")
	public List<AccountInfo> getAccountLogsByDate(@PathVariable(value = "date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
		return accountInfoDetailService.findByRegisteredDate(date);
	}
	
	@PostMapping(value = "/dailyreportcheck")
	public Response checkDailyReport(@RequestParam("branchName") String branchName, @RequestParam("registeredDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date registeredDate) {
		List<AccountInfo> exists = accountInfoDetailService.findByBranchNameAndRegisteredDate(branchName, registeredDate);
		if (exists.isEmpty()) {
			return new Response("Empty", false, null);
		}
		
		else {
			return new Response("There is already registered with the data provided", true, exists);
		}
	}
	
	//card maintenance log
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR','CARDMAKER','CARDSUPERVISOR', 'CARDCUSTODIAN')")
	@GetMapping(value = "/getalllog")
	public List<MaintenanceLog> findAllLogs(){
		return maintenanceLogRepository.findAll();
	}
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR','CARDMAKER','CARDSUPERVISOR', 'CARDCUSTODIAN')")
	@GetMapping(value = "/getLogs/branchname/{branchName}")
	public List<MaintenanceLog> findLogsByBranch(@PathVariable String branchName){
		return maintenanceLogDetailService.findByBranchName(branchName);
	}
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR','CARDMAKER','CARDSUPERVISOR', 'CARDCUSTODIAN')")
	@GetMapping("/getLogs/date/{firstDate}/{secondDate}")
	public List<MaintenanceLog> getLogsDateBetween(@PathVariable(value = "firstDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date firstDate,
			@PathVariable(value = "secondDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date secondDate) {
		return maintenanceLogDetailService.findByCustomerAppDateBetween(firstDate, secondDate);
	}
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR','CARDMAKER','CARDSUPERVISOR', 'CARDCUSTODIAN')")
	@GetMapping("/getLogs/{firstDate}/{secondDate}/{branchName}")
	public List<MaintenanceLog> getLogsDateBetweenBranch(@PathVariable(value = "firstDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date firstDate,
			@PathVariable(value = "secondDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date secondDate, @PathVariable String branchName) {
		return maintenanceLogDetailService.findByCustomerAppDateBetweenAndBranchName(firstDate, secondDate,branchName );
	}
	
	// card Delivery
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR','GAD','MAKER','VIEWER','CARDMAKER','CARDSUPERVISOR', 'CARDCUSTODIAN')")
	@GetMapping("/getcarddelivery/phase1")
	public List<CardDelivery> getCardDeliveryPhase() {
		return cardDeliverDetailService.getByDeliveryStatus("In_Transit", Sort.by("dispatchedDate").descending());
	}
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR','GAD','MAKER','VIEWER','CARDMAKER','CARDSUPERVISOR', 'CARDCUSTODIAN')")
	@GetMapping("/editcarddelivery/phase2")
	public List<CardDelivery> editCardDeliveryPhase2() {
		return cardDeliverDetailService.getByDeliveryStatus("Delivered", Sort.by("dispatchedDate").descending());
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR','GAD','MAKER','VIEWER','CARDMAKER','CARDSUPERVISOR', 'CARDCUSTODIAN')")
	@PostMapping("/getReferenceNumber")
	public Response getReferenceNumberData(@RequestParam("referenceNumber") String  referenceNumber) {
		CardDelivery refNoExist = cardDeliverDetailService.findByReferenceNumber(referenceNumber);
		if (refNoExist == null) {
			return new Response("Empty", false, null);
		}
		else {
		return new Response("There is already registered with the reference number provided", true, null);
		}
		
	}
	
	@GetMapping(value = "/countdeliverystatus/{fieldName}")
	public Map<String, Long> getDeliveryCount(@PathVariable String fieldName) {
		Map<String, Long> map = new HashMap<String, Long>();
		DistinctIterable<String> coll = mongoTemplate.getCollection("carddelivery").distinct(fieldName, String.class);
		MongoCursor<String> cursor = coll.iterator();
		while (cursor.hasNext()) {
			String field = cursor.next();
			map.put(field, cardDeliverDetailService.countDeliveryStatus(fieldName, field));
		}
		return map;
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR','GAD','MAKER','VIEWER','CARDMAKER','CARDSUPERVISOR', 'CARDCUSTODIAN')")
	@GetMapping("/getReferenceNumber/{referenceNumber}/{deliveryStatus}")
	public List<CardDelivery> getCardDeliveryByRefNo(@PathVariable String referenceNumber, @PathVariable String deliveryStatus) {
		return cardDeliverDetailService.getByReferenceNumberAndDeliveryStatus(referenceNumber, deliveryStatus);
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR','GAD','MAKER','VIEWER','CARDMAKER','CARDSUPERVISOR', 'CARDCUSTODIAN')")
	@GetMapping("/getReferenceNumber/branchname/{branchName}/{deliveryStatus}")
	public List<CardDelivery> CardDeliveryByRefNoBranch(@PathVariable String branchName, @PathVariable String deliveryStatus) {
		return cardDeliverDetailService.getByDestinationBranchAndDeliveryStatus(branchName, deliveryStatus);
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR','GAD','MAKER','VIEWER','CARDMAKER','CARDSUPERVISOR', 'CARDCUSTODIAN')")
	@GetMapping("/getReferenceNumber/date/{firstDate}/{secondDate}/{deliveryStatus}")
	public List<CardDelivery> getCardDeliveryDateBetween(@PathVariable(value = "firstDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date firstDate,
			@PathVariable(value = "secondDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date secondDate, @PathVariable String deliveryStatus) {
		return cardDeliverDetailService.getByDispatchedDateIsBetweenAndDeliveryStatus(firstDate, secondDate, deliveryStatus);
	}
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR','GAD','MAKER','VIEWER','CARDMAKER','CARDSUPERVISOR', 'CARDCUSTODIAN')")
	@GetMapping("/getCardDelivered/date/{firstDate}/{secondDate}/{deliveryStatus}/{destinationBranch}")
	public List<CardDelivery> getCardDeliveryDateBetweenBranch(@PathVariable(value = "firstDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date firstDate,
			@PathVariable(value = "secondDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date secondDate, @PathVariable String deliveryStatus, @PathVariable String destinationBranch) {
		return cardDeliverDetailService.getByDispatchedDateIsBetweenAndDeliveryStatusAndDestinationBranch(firstDate, secondDate, deliveryStatus, destinationBranch);
	}
	
	// Card Request
	
	@GetMapping(value = "/count/{fieldName}")
	public Map<String, Long> getCardWithCount(@PathVariable String fieldName) {
		Map<String, Long> map = new HashMap<String, Long>();
		DistinctIterable<String> coll = mongoTemplate.getCollection("cards").distinct(fieldName, String.class);
		MongoCursor<String> cursor = coll.iterator();
		while (cursor.hasNext()) {
			String field = cursor.next();
			map.put(field, cardRepository.countOrderOf(fieldName, field));
		}
		return map;
	}
	
	
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR','CARDMAKER','CARDSUPERVISOR', 'CARDCUSTODIAN')")
	@GetMapping("/getallcardrequest")
	public List<Card> getAllCardRequest() {
		return cardDetailService.findAllByEnabledStatus(true, Sort.by("requestDate").descending());
	}
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR','CARDMAKER','CARDSUPERVISOR', 'CARDCUSTODIAN')")
	@GetMapping("/getallcard")
	public List<Card> getAllCardEdit() {
		return cardDetailService.findAll(Sort.by("requestDate").descending());
	}

	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR','CARDMAKER','CARDSUPERVISOR', 'CARDCUSTODIAN')")
	@GetMapping("/getactivecard")
	public List<Card> getAllActiveCard() {
		return cardDetailService.findByCardStatus("Active", Sort.by("cardExpiryDate").ascending());
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR','CARDMAKER','CARDSUPERVISOR', 'CARDCUSTODIAN')")
	@GetMapping("/getcardusers/{accountNumber}")
	public Optional<Card> getCardRequestByAccNo(@PathVariable String accountNumber) {
		return cardDetailService.findByAccountNumber(accountNumber);
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR','CARDMAKER','CARDSUPERVISOR', 'CARDCUSTODIAN')")
	@GetMapping("/getcard/branchname/{branchName}")
	public List<Card> getCardByBranchName(@PathVariable String branchName) {
		return cardDetailService.findByCardReqOriginatingBranchAndEnabledStatus(branchName, true);
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR','CARDMAKER','CARDSUPERVISOR', 'CARDCUSTODIAN')")
	@GetMapping("/getallcard/branchname/{branchName}")
	public List<Card> getAllCardByBranchName(@PathVariable String branchName) {
		return cardDetailService.findByCardReqOriginatingBranch(branchName, Sort.by("requestDate").descending());
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR','CARDMAKER','CARDSUPERVISOR', 'CARDCUSTODIAN')")
	@GetMapping("/getcard/cardstatus/{cardStatus}")
	public List<Card> getCardByCardStatus(@PathVariable String cardStatus) {
		return cardDetailService.findByCardStatusAndEnabledStatus(cardStatus, true);
	}
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR','CARDMAKER','CARDSUPERVISOR', 'CARDCUSTODIAN')")
	@GetMapping("/getallcard/cardstatus/{cardStatus}")
	public List<Card> getAllCardByCardStatus(@PathVariable String cardStatus) {
		return cardDetailService.findByCardStatus(cardStatus, Sort.by("requestDate").descending());
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR','CARDMAKER','CARDSUPERVISOR', 'CARDCUSTODIAN')")
	@GetMapping("/getcard/group/{branchName}/{cardStatus}")
	public List<Card> getCardByBranchAndCardStatus(@PathVariable String branchName, @PathVariable String cardStatus) {
		return cardDetailService.findByCardReqOriginatingBranchAndCardStatusAndEnabledStatus(branchName, cardStatus, true);
	}
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR','CARDMAKER','CARDSUPERVISOR', 'CARDCUSTODIAN')")
	@GetMapping("/getallcard/group/{branchName}/{cardStatus}")
	public List<Card> getAllCardByBranchAndCardStatus(@PathVariable String branchName, @PathVariable String cardStatus) {
		return cardDetailService.findByCardStatusAndCardReqOriginatingBranch(cardStatus, branchName, Sort.by("requestDate").descending());
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR','CARDMAKER','CARDSUPERVISOR', 'CARDCUSTODIAN')")
	@GetMapping("/getcard/{firstDate}/{secondDate}")
	public List<Card> getCardDateBetween(@PathVariable(value = "firstDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date firstDate,
			@PathVariable(value = "secondDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date secondDate) {
		return cardDetailService.findByRequestDateBetweenAndEnabledStatus(firstDate, secondDate, true);
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR','CARDMAKER','CARDSUPERVISOR', 'CARDCUSTODIAN')")
	@GetMapping("/getallcard/{firstDate}/{secondDate}")
	public List<Card> getAllCardDateBetween(@PathVariable(value = "firstDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date firstDate,
			@PathVariable(value = "secondDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date secondDate) {
		return cardDetailService.findByRequestDateBetween(firstDate, secondDate, Sort.by("requestDate").descending());
	}
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR','CARDMAKER','CARDSUPERVISOR', 'CARDCUSTODIAN')")
	@GetMapping("/getactivecard/{firstDate}/{secondDate}/{cardStatus}")
	public List<Card> getActiveCardDateBetween(@PathVariable(value = "firstDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date firstDate,
			@PathVariable(value = "secondDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date secondDate,@PathVariable String cardStatus ) {
		return cardDetailService.findByRequestDateBetweenAndCardStatus(firstDate, secondDate,cardStatus, Sort.by("requestDate").descending());
	}
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR','CARDMAKER','CARDSUPERVISOR', 'CARDCUSTODIAN')")
	@GetMapping("/getactivecard/date/{firstDate}/{secondDate}/{cardStatus}/{cardReqOriginatingBranch}")
	public List<Card> getActiveCardDateBetweenBranch(@PathVariable(value = "firstDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date firstDate,
			@PathVariable(value = "secondDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date secondDate,@PathVariable String cardStatus ,@PathVariable String cardReqOriginatingBranch) {
		return cardDetailService.findByRequestDateBetweenAndCardStatusAndCardReqOriginatingBranch(firstDate, secondDate,cardStatus, cardReqOriginatingBranch, Sort.by("requestDate").descending());
	}
	
	
	
	//renew card
	
	@GetMapping(value = "/renewcount/{fieldValue}")
	public Map<String, Long> getCardRenewWithCount(@PathVariable String fieldValue) {
		Map<String, Long> map = new HashMap<String, Long>();
		DistinctIterable<String> coll = mongoTemplate.getCollection("cardrenewrequest").distinct(fieldValue, String.class);
		MongoCursor<String> cursor = coll.iterator();
		while (cursor.hasNext()) {
			String fieldVal = cursor.next();
			map.put(fieldVal, cardRenewRepository.countStatusOf(fieldValue, fieldVal));
		}
		return map;
	}
	
	
	
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR','CARDMAKER','CARDSUPERVISOR', 'CARDCUSTODIAN')")
	@GetMapping("/getstatuscardrenew")
	public List<CardRenew> getAllCardRenewRequest() {
		return cardRenewDetailService.findAllByEnabledStatus(true, Sort.by("renewRequestDate").descending());
	}
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR','CARDMAKER','CARDSUPERVISOR', 'CARDCUSTODIAN')")
	@GetMapping("/getactivecardrenew")
	public List<CardRenew> getActiveCardRenewRequest() {
		return cardRenewDetailService.findByCardStatus("Active", Sort.by("renewRequestDate").descending());
	}
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR','CARDMAKER','CARDSUPERVISOR', 'CARDCUSTODIAN')")
	@GetMapping("/getallrenew")
	public List<CardRenew> getAllCardRenewRequestEdit() {
		return cardRenewRepository.findAll();
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR','CARDMAKER','CARDSUPERVISOR', 'CARDCUSTODIAN')")
	@GetMapping("/getcardrenew/branchname/{branchName}")
	public List<CardRenew> getCardRenewByBranchName(@PathVariable String branchName) {
		return cardRenewDetailService.findByCardReqOriginatingBranchAndEnabledStatus(branchName, true);
	}
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR','CARDMAKER','CARDSUPERVISOR', 'CARDCUSTODIAN')")
	@GetMapping("/editcardrenew/{branchName}")
	public List<CardRenew> getEditCardRenewByBranchName(@PathVariable String branchName) {
		return cardRenewDetailService.findByCardReqOriginatingBranch(branchName,  Sort.by("renewRequestDate").descending());
	}
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR','CARDMAKER','CARDSUPERVISOR', 'CARDCUSTODIAN')")
	@GetMapping("/editcardrenew/status/{cardStatus}")
	public List<CardRenew> getEditCardRenewByCardStatus(@PathVariable String cardStatus) {
		return cardRenewDetailService.findByCardStatus(cardStatus,  Sort.by("renewRequestDate").descending());
	}
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR','CARDMAKER','CARDSUPERVISOR', 'CARDCUSTODIAN')")
	@GetMapping("/editcardrenew/status/{cardReqOriginatingBranch}/{cardStatus}")
	public List<CardRenew> getEditCardRenewByCardStatusBranch(@PathVariable String cardStatus, @PathVariable String cardReqOriginatingBranch) {
		return cardRenewDetailService.findByCardReqOriginatingBranchAndCardStatus(cardReqOriginatingBranch, cardStatus,  Sort.by("renewRequestDate").descending());
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR','CARDMAKER','CARDSUPERVISOR', 'CARDCUSTODIAN')")
	@GetMapping("/getactivecardrenewbranch/{branchName}")
	public List<CardRenew> getCardRenewByBranchNameActive(@PathVariable String branchName) {
		return cardRenewDetailService.findByCardReqOriginatingBranchAndCardStatus(branchName, "Active", Sort.by("renewRequestDate").descending());
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR','CARDMAKER','CARDSUPERVISOR', 'CARDCUSTODIAN')")
	@GetMapping("/getactivecardrenew/{firstDate}/{secondDate}")
	public List<CardRenew> getCardRenewDateBetweenActive(@PathVariable(value = "firstDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date firstDate,
			@PathVariable(value = "secondDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date secondDate) {
		return cardRenewDetailService.findByRenewRequestDateBetweenAndCardStatus(firstDate, secondDate, "Active");
	}
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR','CARDMAKER','CARDSUPERVISOR', 'CARDCUSTODIAN')")
	@GetMapping("/geteditcardrenew/{firstDate}/{secondDate}")
	public List<CardRenew> getEditCardRenewDateBetween(@PathVariable(value = "firstDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date firstDate,
			@PathVariable(value = "secondDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date secondDate) {
		return cardRenewDetailService.findByRenewRequestDateBetween(firstDate, secondDate, Sort.by("renewRequestDate").descending());
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR','CARDMAKER','CARDSUPERVISOR', 'CARDCUSTODIAN')")
	@GetMapping("/getactivecardrenew/date/{firstDate}/{secondDate}/{cardReqOriginatingBranch}")
	public List<CardRenew> getCardRenewDateBetweenActiveBranch(@PathVariable(value = "firstDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date firstDate,
			@PathVariable(value = "secondDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date secondDate, @PathVariable String cardReqOriginatingBranch) {
		
		return cardRenewDetailService.findByRenewRequestDateBetweenAndCardStatusAndCardReqOriginatingBranch(firstDate, secondDate, "Active", cardReqOriginatingBranch);
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR','CARDMAKER','CARDSUPERVISOR', 'CARDCUSTODIAN')")
	@GetMapping("/getcardrenew/cardstatus/{cardStatus}")
	public List<CardRenew> getCardRenewByCardStatus(@PathVariable String cardStatus) {
		return cardRenewDetailService.findByCardStatusAndEnabledStatus(cardStatus, true);
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR','CARDMAKER','CARDSUPERVISOR', 'CARDCUSTODIAN')")
	@GetMapping("/getcardrenew/group/{branchName}/{cardStatus}")
	public List<CardRenew> getCardRenewByBranchAndCardStatus(@PathVariable String branchName, @PathVariable String cardStatus) {
		return cardRenewDetailService.findByCardReqOriginatingBranchAndCardStatusAndEnabledStatus(branchName, cardStatus, true);
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR','CARDMAKER','CARDSUPERVISOR', 'CARDCUSTODIAN')")
	@GetMapping("/getcardrenew/{firstDate}/{secondDate}")
	public List<CardRenew> getCardRenewDateBetween(@PathVariable(value = "firstDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date firstDate,
			@PathVariable(value = "secondDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date secondDate) {
		return cardRenewDetailService.findByRenewRequestDateBetweenAndEnabledStatus(firstDate, secondDate, true);
	}
	
	//Budget
	
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR', 'HOD', 'CAD','GAD','MAKER', 'VIEWER','FEEDBACK', 'LOCKER', 'MINUTES')")
	@PostMapping("/getbudgetval")
	public Response getBudgetByTitle(@RequestParam("budgetTitle") String  budgetTitle) {
		List<Budget> budgetExist = budgetDetailService.findByBudgetTitle(budgetTitle);
		if (budgetExist.isEmpty()) {
			return new Response("Empty", false, null);
		}
		else {
		return new Response("There is already registered with the expenses provided", true, budgetExist);
		}
		
	}
	
	
	//LockerLog
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR', 'HOD','MAKER', 'VIEWER', 'LOCKER', 'MINUTES')")
	@GetMapping("/getlockerLoglist/all")
	public List<LockerLog> getAlllockerLogList() {
		return lockerLogDetailService.findAllByOrderByCheckednDateDesc();
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR', 'HOD','MAKER', 'VIEWER', 'LOCKER', 'MINUTES')")
	@GetMapping("/getlockerLoglist/branchname/{branchName}")
	public List<LockerLog> getLockerLogByBranchName(@PathVariable String branchName) {
		return lockerLogDetailService.getByLockerExistBranch(branchName);
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR', 'HOD','MAKER', 'VIEWER', 'LOCKER', 'MINUTES')")
	@GetMapping("/getlockerLoglist/status/{lockerStatus}")
	public List<LockerLog> getLockerLogByStatus(@PathVariable String lockerStatus) {
		return lockerLogDetailService.getByLockerStatus(lockerStatus);
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR', 'HOD','MAKER', 'VIEWER', 'LOCKER', 'MINUTES')")
	@GetMapping("/getlockerLoglist/status/{lockerStatus}/{lockerExistBranch}")
	  public List<LockerLog> getLockerLogByStatusAndbranch(@PathVariable String
	  lockerStatus, @PathVariable String lockerExistBranch) { 
		  return lockerLogRepository.findByLockerStatusAndLockerExistBranch(lockerStatus, lockerExistBranch);
	  }
	 
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR', 'HOD','MAKER', 'VIEWER', 'LOCKER', 'MINUTES')")
	@GetMapping("/getlockerLoglist/{firstDate}/{secondDate}")
	public List<LockerLog> getLockerLogBetween(@PathVariable(value = "firstDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date firstDate,
			@PathVariable(value = "secondDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date secondDate) {
		return lockerLogRepository.findByCheckednDateIsBetween(firstDate, secondDate);
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	@RequestMapping(value = "/insCustTest", method = RequestMethod.POST)
	public Response getInsCustDetail(@RequestParam("clientCode") int clientCode) {
		InsuranceCustomer exists = insuranceCustomerRepository.findInsuranceCustomerByClientCode(clientCode);
		if (exists != null)
			return new Response("There is already registered with the Client Code provided", true, exists);
		else
			return new Response("Empty", false, null);
	}

	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR', 'HOD','BM', 'CAD','GAD','MAKER', 'VIEWER','FEEDBACK', 'LOCKER', 'MINUTES')")
	@RequestMapping(value = "/getfiscalyear", method = RequestMethod.GET)
	public List<FiscalYear> getFiscalYear() {
		List<FiscalYear> fiscalYear = fiscalYearDetailService.getAllFiscalYear();
		return fiscalYear;
	}

/*	@RequestMapping(value = "/api/getutility", method = RequestMethod.GET)
	public List<UtilityBills> getApiUtility() {
		// List<UtilityBills> utilityListApi =
		// utilityDetailService.findByFiscalYear(Sort.by(Sort.Direction.ASC,
		// "fiscalYear"));
		List<UtilityBills> utilityListApi = utilityDetailService.findUtilityBillsGroupByFiscalYear();
		return utilityListApi;
	}*/

	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR', 'HOD','BM', 'CAD','GAD','MAKER', 'VIEWER','FEEDBACK', 'LOCKER', 'MINUTES')")
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/api/getutilitycount", method = RequestMethod.GET)
	public Map<String, Long> getUniqueGenericClassesWithCount() {
		Map map = new HashMap<String, Integer>();
		DistinctIterable<String> coll = mongoTemplate.getCollection("utilitybills").distinct("fiscalYear",
				String.class);
		MongoCursor<String> cursor = coll.iterator();
		while (cursor.hasNext()) {
			String field = cursor.next();
			map.put(field, utilityBillsRepository.countOrderOf("fiscalYear", field));
		}
		return map;
	}

	@PreAuthorize("hasAnyAuthority('ADMIN')")
	@GetMapping("/getinsurancecompanylist")
	public List<InsuranceCompany> getInsuranceCompanyList() {
		return insuranceCompanyDetailService.getAllInsCompany();
	}

	@PreAuthorize("hasAnyAuthority('ADMIN')")
	@GetMapping("/getinsurancecompany/{insCompanyName}")
	public Optional<InsuranceCompany> getInsuranceCompanyByName(@PathVariable String insCompanyName) {
		return insuranceCompanyDetailService.getInsCompanyByName(insCompanyName);
	}

	@PreAuthorize("hasAnyAuthority('ADMIN')")
	@GetMapping("/getinsurancescheme/{insCompanyName}")
	public List<InsuranceSchema> getInsSchemeByCompanyName(@PathVariable String insCompanyName) {
		return insuranceSchemaDetailService.getInsuranceSchemaByCompanyName(insCompanyName);
	}

	@PreAuthorize("hasAnyAuthority('ADMIN')")
	@GetMapping("/getbyschemename/{insSchemaName}")
	public Optional<InsuranceSchema> getInsSchemeCodeBySchemeName(@PathVariable String insSchemaName) {
		return insuranceSchemaDetailService.findByInsSchemaName(insSchemaName);
	}

	@PreAuthorize("hasAnyAuthority('ADMIN')")
	@GetMapping("/getbycompanyname/{insCompanyName}")
	public List<InsuranceCustomerRegister> getInsCustByCompanyName(@PathVariable String insCompanyName) {
		return insCustRegisterDetailService.findByInsCompanyName(insCompanyName);
	}
	
	//Feedback
	
	
	@GetMapping(value = "/countfeedback/{fieldName}")
	public Map<String, Long> getFeedbackCount(@PathVariable String fieldName) {
		Map<String, Long> map = new HashMap<String, Long>();
		DistinctIterable<String> coll = mongoTemplate.getCollection("feedbacks").distinct(fieldName, String.class);
		MongoCursor<String> cursor = coll.iterator();
		while (cursor.hasNext()) {
			String field = cursor.next();
			map.put(field, feedbackDetailService.countFeedbackRating(fieldName, field));
		}
		return map;
	}
	
	
	
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR', 'HOD', 'CAD','GAD','MAKER', 'VIEWER','FEEDBACK', 'MINUTES')")
	@GetMapping("/getfeedback/branchname/{branchName}")
	public List<Feedback> getFeedbackByBranchName(@PathVariable String branchName) {
		return feedbackDetailService.findByBranchName(branchName);
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR', 'HOD', 'CAD','GAD','MAKER', 'VIEWER','FEEDBACK', 'MINUTES')")
	@GetMapping("/getfeedback/servicetype/{serviceType}")
	public List<Feedback> getFeedbackByServiceType(@PathVariable String serviceType) {
		return feedbackDetailService.findByTypeOfService(serviceType);
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR', 'HOD', 'CAD','GAD','MAKER', 'VIEWER','FEEDBACK', 'MINUTES')")
	@GetMapping("/getfeedback/rating/{ratings}")
	public List<Feedback> getFeedbackByRating(@PathVariable String ratings) {
		return feedbackDetailService.findByRating(ratings);
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR', 'HOD', 'CAD','GAD','MAKER', 'VIEWER','FEEDBACK', 'MINUTES')")
	@GetMapping("/getfeedback/brgroup/{branch}/{rating}")
	public List<Feedback> getFeedbackByBranchRating(@PathVariable String branch, @PathVariable String rating) {
		return feedbackDetailService.findByBranchNameAndRating(branch, rating);
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR', 'HOD', 'CAD','GAD','MAKER', 'VIEWER','FEEDBACK', 'MINUTES')")
	@GetMapping("/getfeedback/srgroup/{serviceType}/{rating}")
	public List<Feedback> getFeedbackByServiceRating(@PathVariable String serviceType, @PathVariable String rating ) {
		return feedbackDetailService.findByTypeOfServiceAndRating(serviceType, rating);
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR', 'HOD', 'CAD','GAD','MAKER', 'VIEWER','FEEDBACK', 'MINUTES')")
	@GetMapping("/getfeedback/bsgroup/{branch}/{serviceType}")
	public List<Feedback> getFeedbackByBranchService(@PathVariable String branch, @PathVariable String serviceType) {
		return feedbackDetailService.findByBranchNameAndTypeOfService(branch, serviceType);
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR', 'HOD', 'CAD','GAD','MAKER', 'VIEWER','FEEDBACK', 'MINUTES')")
	@GetMapping("/getfeedback/bsrgroup/{branchName}/{serviceType}/{rating}")
	public List<Feedback> getFeedbackByBranchServiceRating(@PathVariable String branchName, @PathVariable String serviceType, @PathVariable String rating) {
		return feedbackDetailService.findByBranchNameAndTypeOfServiceAndRating(branchName, serviceType, rating);
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR', 'HOD', 'CAD','GAD','MAKER', 'VIEWER','FEEDBACK', 'MINUTES')")
	@GetMapping("/getfeedback/all")
	public List<Feedback> getAllFeedback() {
		return feedbackDetailService.findAll();
	}

	@PreAuthorize("hasAnyAuthority('ADMIN' )")
	@GetMapping("/getbycompanyandscheme/{insCompanyName}/{insSchemeName}")
	public List<InsuranceCustomerRegister> getInsCustByCompanyAndSchemeName(@PathVariable String insCompanyName,
			@PathVariable String insSchemeName) {
		return insCustRegisterDetailService.findByInsCompanyNameAndInsSchemaName(insCompanyName, insSchemeName);
	}

	@PreAuthorize("hasAnyAuthority('ADMIN' )")
	@GetMapping("/getbystartdaterange/{firstDate}/{secondDate}")
	public List<InsuranceCustomerRegister> getInsCustByStartDateRange(@PathVariable(value = "firstDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date firstDate,
			@PathVariable(value = "secondDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date secondDate) {
		return insCustRegisterRepository.findByInsStartedDateBetween(firstDate, secondDate);
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN' )")
	@GetMapping("/getbyenddaterange/{firstDate}/{secondDate}")
	public List<InsuranceCustomerRegister> getInsCustByEndDateRange(@PathVariable(value = "firstDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date firstDate,
			@PathVariable(value = "secondDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date secondDate) {
		return insCustRegisterRepository.findByInsEndDateBetween(firstDate, secondDate);
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR', 'HOD', 'CAD','GAD','MAKER', 'VIEWER','FEEDBACK', 'MINUTES')")
	@GetMapping("/getfeedbackdaterange/{firstDate}/{secondDate}")
	public List<Feedback> getFeedbackByDateRange(@PathVariable(value = "firstDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date firstDate,
			@PathVariable(value = "secondDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date secondDate) {
		return feedbackRepository.findByDateBetween(firstDate, secondDate);
	}

	
	// Error Log
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR', 'HOD', 'CAD','GAD','MAKER', 'VIEWER', 'MINUTES')")
	@GetMapping("/geterrorissuelist")
	public List<ErrorIssueLog> getErrorIssueList() {
		return errorIssueLogDetailService.getAll();
	}

	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR', 'HOD', 'CAD','GAD','MAKER', 'VIEWER', 'MINUTES')")
	@GetMapping("/geterrorissue/branch/{branchName}")
	public List<ErrorIssueLog> getErrorLogByBranch(@PathVariable String branchName) {
		return errorIssueLogDetailService.getByBranchName(branchName);
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR', 'HOD', 'CAD','GAD','MAKER', 'VIEWER', 'MINUTES')")
	@GetMapping("/geterrorissue/nature/{natureOfError}")
	public List<ErrorIssueLog> getErrorLogByNatureOfError(@PathVariable String natureOfError) {
		return errorIssueLogDetailService.getByNatureOfError(natureOfError);
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR', 'HOD', 'CAD','GAD','MAKER', 'VIEWER', 'MINUTES')")
	@GetMapping("/geterrorissue/filter/{branchName}/{natureOfError}")
	public List<ErrorIssueLog> getErrorLogByBranchAndNatureOfError(@PathVariable String branchName, @PathVariable String natureOfError) {
		return errorIssueLogDetailService.getByBranchNameAndNatureOfError(branchName, natureOfError);
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR', 'HOD', 'CAD','GAD','MAKER', 'VIEWER', 'MINUTES')")
	@GetMapping("/geterrorissue/{start}/{end}")
	public List<ErrorIssueLog> getErrorLogIssueIncidentDateBetween(@PathVariable(value = "start") @DateTimeFormat(pattern = "yyyy-MM-dd") Date start,
			@PathVariable(value = "end") @DateTimeFormat(pattern = "yyyy-MM-dd") Date end) {
		return errorIssueLogDetailService.getByIncidentValueDateBetween(start, end);
	}
	
	// GFP record
	
	@GetMapping(value = "/countgfp/{fieldName}")
	public Map<String, Long> getGfpCount(@PathVariable String fieldName) {
		Map<String, Long> map = new HashMap<String, Long>();
		DistinctIterable<String> coll = mongoTemplate.getCollection("goodforpaymentcheques").distinct(fieldName, String.class);
		MongoCursor<String> cursor = coll.iterator();
		while (cursor.hasNext()) {
			String field = cursor.next();
			map.put(field, goodForPaymentDetailService.countGoodForPayment(fieldName, field));
		}
		return map;
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR', 'HOD', 'CAD', 'MAKER', 'VIEWER', 'MINUTES')")
	@GetMapping("/getgfplist")
	public List<GoodForPayment> getGFPRecordList() {
		return goodForPaymentDetailService.getAllGfpList();
	}

	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR', 'HOD', 'CAD', 'MAKER', 'VIEWER', 'MINUTES')")
	@GetMapping("/getgfplist/branch/{branchName}")
	public List<GoodForPayment> getGFPRecordByBranch(@PathVariable String branchName) {
		return goodForPaymentDetailService.getByBranchName(branchName);
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR', 'HOD', 'CAD', 'MAKER', 'VIEWER', 'MINUTES')")
	@GetMapping("/getgfplist/status/{gfpStatus}")
	public List<GoodForPayment> getGFPRecordByStatus(@PathVariable String gfpStatus) {
		return goodForPaymentDetailService.getByGfpStatus(gfpStatus);
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR', 'HOD', 'CAD', 'MAKER', 'VIEWER', 'MINUTES')")
	@GetMapping("/getgfplist/filter/{branchName}/{gfpStatus}")
	public List<GoodForPayment> getGFPRecordByBranchAndStatus(@PathVariable String branchName, @PathVariable String gfpStatus) {
		return goodForPaymentDetailService.getByBranchNameAndGFPStatus(branchName, gfpStatus);
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR', 'HOD', 'CAD', 'MAKER', 'VIEWER', 'MINUTES')")
	@GetMapping("/getgfplist/{start}/{end}")
	public List<GoodForPayment> getGFPRecordIssueDateBetween(@PathVariable(value = "start") @DateTimeFormat(pattern = "yyyy-MM-dd") Date start,
			@PathVariable(value = "end") @DateTimeFormat(pattern = "yyyy-MM-dd") Date end) {
		return goodForPaymentDetailService.getByIssueDateBetween(start, end);
	}
	
	// MC record
	
	@GetMapping(value = "/countmc/{fieldName}")
	public Map<String, Long> getMCCount(@PathVariable String fieldName) {
		Map<String, Long> map = new HashMap<String, Long>();
		DistinctIterable<String> coll = mongoTemplate.getCollection("managercheques").distinct(fieldName, String.class);
		MongoCursor<String> cursor = coll.iterator();
		while (cursor.hasNext()) {
			String field = cursor.next();
			map.put(field, managerChequeDetailService.countManagerCheque(fieldName, field));
		}
		return map;
	}
	
	
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR', 'HOD', 'CAD', 'MAKER', 'VIEWER', 'MINUTES')")
	@GetMapping("/getmclist")
	public List<ManagerCheque> getMCRecordList() {
		return managerChequeDetailService.getAllMcList();
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR', 'HOD', 'CAD', 'MAKER', 'VIEWER', 'MINUTES')")
	@GetMapping("/getmclist/branch/{branchName}")
	public List<ManagerCheque> getMCRecordByBranch(@PathVariable String branchName) {
		return managerChequeDetailService.getByBranchName(branchName);
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR', 'HOD', 'CAD', 'MAKER', 'VIEWER', 'MINUTES')")
	@GetMapping("/getmclist/status/{mcStatus}")
	public List<ManagerCheque> getMCRecordByStatus(@PathVariable String mcStatus) {
		return managerChequeDetailService.getByMcStatus(mcStatus);
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR', 'HOD', 'CAD', 'MAKER', 'VIEWER', 'MINUTES')")
	@GetMapping("/getmclist/filter/{branchName}/{mcStatus}")
	public List<ManagerCheque> getMCRecordByBranchAndStatus(@PathVariable String branchName,
			@PathVariable String mcStatus) {
		return managerChequeDetailService.getByBranchNameAndMcStatus(branchName, mcStatus);
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR', 'HOD', 'CAD', 'MAKER', 'VIEWER', 'MINUTES')")
	@GetMapping("/getmclist/{start}/{end}")
	public List<ManagerCheque> getMCRecordIssueDateBetween(@PathVariable(value = "start") @DateTimeFormat(pattern = "yyyy-MM-dd") Date start,
			@PathVariable(value = "end") @DateTimeFormat(pattern = "yyyy-MM-dd") Date end) {
		return managerChequeDetailService.getByIssueDateBetween(start, end);
	}
	
// insurence
	/*@GetMapping("/getallcustomer")
	public List<InsuranceCustomerRegister> getAllInsuranceCustomerList() {
		return insCustRegisterDetailService.getAllInsuranceCustomerRegister();
	}*/
	
	
	// Utility 
	
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR', 'HOD', 'CAD','GAD','MAKER', 'VIEWER','FEEDBACK', 'LOCKER', 'MINUTES')")
	@GetMapping("/getutility/all")
	public List<UtilityBills> getAllUtilityList() {
		return utilityDetailService.findAllList();
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR', 'HOD', 'CAD','GAD','MAKER', 'VIEWER','FEEDBACK', 'LOCKER', 'MINUTES')")
	@GetMapping("/searchutility/fiscal/{fiscalYear}")
	  public List<UtilityBills> getUtilityByFiscal(HttpServletRequest request, @PathVariable String fiscalYear) { 
		  return utilityDetailService.findByFiscalYearContaining(fiscalYear, Sort.by("fiscalYear").descending());
	  }
	
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR', 'HOD', 'CAD','GAD','MAKER', 'VIEWER','FEEDBACK', 'LOCKER', 'MINUTES')")
	@GetMapping("/searchutility/branch/{branchName}")
	public List<UtilityBills> getUtilityByBranch(HttpServletRequest request, @PathVariable String branchName) { 
		return utilityDetailService.findByBranchNameContaining(branchName, Sort.by("branchName").ascending());
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR', 'HOD', 'CAD','GAD','MAKER', 'VIEWER','FEEDBACK', 'LOCKER', 'MINUTES')")
	@GetMapping("/getutility/months/{fiscalYear}/{month}")
	public List<UtilityBills> getUtilityByFiscalAndMonth(HttpServletRequest request,  @PathVariable String month,  @PathVariable String fiscalYear) { 
		return utilityDetailService.getByFiscalYearAndMonth(fiscalYear, month);
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR', 'HOD', 'CAD','GAD','MAKER', 'VIEWER','FEEDBACK', 'LOCKER', 'MINUTES')")
	@GetMapping("/getutility/branch/{branchName}/{fiscalYear}")
	  public List<UtilityBills> getUtilityByFiscalAndBranch(@PathVariable String branchName,  @PathVariable String fiscalYear) { 
		  return utilityDetailService.getByFiscalYearAndBranchName(fiscalYear, branchName);
	  }
	
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR','BM', 'SUPERVISOR', 'HOD', 'CAD','GAD','MAKER', 'VIEWER','FEEDBACK', 'LOCKER', 'MINUTES')")
	@PostMapping(value = "/utilitySubmitTest")
	public Response getUtilityDetail(@RequestParam("branchName") String branchName,
			@RequestParam("fiscalYear") String fiscalYear, @RequestParam("month") String month) {
		List<UtilityBills> exists = utilityDetailService.findByBranchNameAndFiscalYearAndMonth(branchName, fiscalYear, month);
		if (exists.isEmpty()) {
			return new Response("Empty", false, null);
		}

		else {
		return new Response("There is already registered with the expenses provided", true, exists);
		}
	}
	
	   // Customer;s Locker
	
	@GetMapping(value = "/countlocker/{fieldName}")
	public Map<String, Long> getLockerCount(@PathVariable String fieldName) {
		Map<String, Long> map = new HashMap<String, Long>();
		DistinctIterable<String> coll = mongoTemplate.getCollection("locker").distinct(fieldName, String.class);
		MongoCursor<String> cursor = coll.iterator();
		while (cursor.hasNext()) {
			String field = cursor.next();
			map.put(field, lockerDetailService.countLocker(fieldName, field));
		}
		return map;
	}
	
	// Minutes 
	
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR', 'HOD', 'CAD','GAD','MAKER', 'VIEWER','FEEDBACK', 'LOCKER', 'MINUTES')")
	@GetMapping("/getallminutes")
	public List<Minutes> getAllMinutes() {
		return minutesRepository.findAll(Sort.by("meetingsDate").descending());
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR', 'HOD', 'CAD','GAD','MAKER', 'VIEWER','FEEDBACK', 'LOCKER', 'MINUTES')")
	@GetMapping("/getminuteslist/branch/{branchName}")
	public List<Minutes> getMinutesByBranchName(@PathVariable String branchName) {
		return minutesRepository.findByBranchNameOrderByMeetingsDateDesc(branchName);
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR', 'HOD', 'CAD','GAD','MAKER', 'VIEWER','FEEDBACK', 'LOCKER', 'MINUTES')")
	@GetMapping("/getminuteslist/category/{category}")
	public List<Minutes> getMinutesByCategory(@PathVariable String category) {
		return minutesRepository.findByCategoryOrderByMeetingsDateDesc(category);
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR', 'HOD', 'CAD','GAD','MAKER', 'VIEWER','FEEDBACK', 'LOCKER', 'MINUTES')")
	@GetMapping("/getminuteslist/both/{categoryVal}/{branchVal}")
    public List<Minutes> getMinutesByCategoryBranch(@PathVariable String categoryVal, @PathVariable String branchVal) {
		return minutesRepository.findAllByCategoryAndBranchNameOrderByMeetingsDateDesc(categoryVal,branchVal);
    }
	
	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR', 'HOD', 'CAD','GAD','MAKER', 'VIEWER','FEEDBACK', 'LOCKER', 'MINUTES')")
	@GetMapping("/getminuteslist/{firstDate}/{secondDate}")
	public List<Minutes> getMinutesDateBetween(@PathVariable(value = "firstDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date firstDate,
			@PathVariable(value = "secondDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date secondDate) {
		return minutesRepository.findAllByMeetingsDateIsBetweenOrderByMeetingsDateDesc(firstDate, secondDate);
	}
	

	@PreAuthorize("hasAnyAuthority('ADMIN','HIGHSUPERVISOR', 'SUPERVISOR', 'HOD','BM', 'CAD','GAD','MAKER', 'VIEWER','FEEDBACK', 'LOCKER', 'MINUTES')")
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
	
	/*
	 * @GetMapping(value = "/countuser/{fieldName}") public Map<String, Long>
	 * getGenderCount(@PathVariable String fieldName) { Map<String, Long> map = new
	 * HashMap<>(); DistinctIterable<String> coll =
	 * mongoTemplate.getCollection("AppUser").distinct(fieldName, String.class);
	 * MongoCursor<String> cursor = coll.iterator(); while (cursor.hasNext()) {
	 * String field = cursor.next(); if (field.equalsIgnoreCase("Viewer")) {
	 * map.put(field, userDetailService.countUser(fieldName, field)); } } return
	 * map; }
	 */

}
