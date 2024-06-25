package com.pofil.controller;

import java.util.Date;
import java.util.List;

import com.pofil.model.AccountInfo;
import com.pofil.model.ErrorIssueLog;
import com.pofil.model.GoodForPayment;
import com.pofil.model.ManagerCheque;
import com.pofil.model.Minutes;
import com.pofil.model.UtilityBills;
import com.pofil.repository.FeedbackRepository;
import com.pofil.repository.LockerLogRepository;
import com.pofil.repository.MinutesRepository;
import com.pofil.repository.UtilityBillsRepository;
import com.pofil.service.AccountInfoDetailService;
import com.pofil.service.ErrorIssueLogDetailService;
import com.pofil.service.GoodForPaymentDetailService;
import com.pofil.service.ManagerChequeDetailService;
import com.pofil.service.UtilityBillsDetailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bm")
public class BmRestController {
	
	@Autowired
	MongoTemplate mongoTemplate;
	@Autowired
	UtilityBillsDetailService utilityDetailService;
	@Autowired
	FeedbackRepository feedbackRepository;
	@Autowired
	UtilityBillsRepository utilityBillsRepository;
	@Autowired
	private GoodForPaymentDetailService goodForPaymentDetailService;
	@Autowired
	private ManagerChequeDetailService managerChequeDetailService;
	@Autowired
	private ErrorIssueLogDetailService errorIssueLogDetailService;
	
	@Autowired
	private AccountInfoDetailService accountInfoDetailService;
	
	@Autowired
	private MinutesRepository minutesRepository;
	
	@Autowired
	LockerLogRepository lockerLogRepository;
	
	// route for BM only-Account info
	@PreAuthorize("hasAnyAuthority('BM')")
	@GetMapping("/getallaccountlog/{branchName}")
	public List<AccountInfo> getAllAccountInfo(@PathVariable String branchName) {
		return accountInfoDetailService.findByBranchName(branchName);
	}
	@PreAuthorize("hasAnyAuthority('BM')")
	@GetMapping("/getaccountinfo/date/{firstDate}/{secondDate}/{branchName}")
	public List<AccountInfo> getAccountLogsDateBetweenBranchBM(@PathVariable(value = "firstDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date firstDate,
			@PathVariable(value = "secondDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date secondDate, @PathVariable String branchName) {
		return accountInfoDetailService.findByRegisteredDateBetweenAndBranchName(firstDate, secondDate,branchName, Sort.by("registeredDate").descending());
	}
	
	@PreAuthorize("hasAnyAuthority('BM')")
	@GetMapping("/getaccountinfo/bydate/{branchName}/{date}")
	public List<AccountInfo> getAccountLogsByDate(@PathVariable String branchName, @PathVariable(value = "date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
		return accountInfoDetailService.findByBranchNameAndRegisteredDate(branchName, date);
	}
	
	
	// Minutes 
	
	@PreAuthorize("hasAnyAuthority('BM')")
	@GetMapping("/getallminutes/{branchName}")
	public List<Minutes> getMinutesList(@PathVariable String branchName) {
		return minutesRepository.findByBranchNameOrderByMeetingsDateDesc(branchName);
	}
	
	@PreAuthorize("hasAnyAuthority('BM')")
	@GetMapping("/getallminutes/branch/{categoryVal}/{branchVal}")
    public List<Minutes> getMinutesByCategoryBranch(@PathVariable String categoryVal, @PathVariable String branchVal) {
		return minutesRepository.findAllByCategoryAndBranchNameOrderByMeetingsDateDesc(categoryVal,branchVal);
    }
	
	// Utility 
	@PreAuthorize("hasAuthority('BM')")
	@GetMapping("/getutilitylist/{branchName}")
	public List<UtilityBills> getAllUtilityList(@PathVariable String branchName) {
		return utilityDetailService.getByBranchName(branchName);
	}
	
	@PreAuthorize("hasAuthority('BM')")
	@GetMapping("/getutility/month/{branchName}/{month}")
	public List<UtilityBills> getUtilityByBranchAndMonth(@PathVariable String branchName, @PathVariable String month) {
		return utilityDetailService.getByBranchNameAndMonth(branchName, month);
	}
	
	@PreAuthorize("hasAuthority('BM')")
	@GetMapping("/getutility/fy/{branchName}/{fiscalYear}")
	public List<UtilityBills> getUtilityByBranchAndFiscalYearVal(@PathVariable String branchName, @PathVariable String fiscalYear) {
		return utilityDetailService.getByFiscalYearAndBranchName(fiscalYear, branchName);
	}
	
	@PreAuthorize("hasAuthority('BM')")
	@GetMapping("/getutility//branch/{branchName}/{month}/{fiscalYear}")
	public List<UtilityBills> getUtilityByBranchAndMonthFiscalYear(@PathVariable String branchName, @PathVariable String month, @PathVariable String fiscalYear) {
		return utilityDetailService.findByBranchNameAndFiscalYearAndMonth(branchName, fiscalYear, month);
	}
	
	//Error Issues
	
	@PreAuthorize("hasAuthority('BM')")
	@GetMapping("/geterrorissue/branch/{branchName}")
	public List<ErrorIssueLog> getErrorLogByBranch(@PathVariable String branchName) {
		return errorIssueLogDetailService.getByBranchName(branchName);
	}
	
	@PreAuthorize("hasAuthority('BM')")
	@GetMapping("/geterrorissue/nature/{branchName}/{natureOfError}")
	public List<ErrorIssueLog> getErrorLogByBranchAndNatureOfError(@PathVariable String branchName, @PathVariable String natureOfError) {
		return errorIssueLogDetailService.getByBranchNameAndNatureOfError(branchName, natureOfError);
	}

	@PreAuthorize("hasAuthority('BM')")
	@GetMapping("/geterrorissue/cause/{branchName}/{causeOfError}")
	public List<ErrorIssueLog> getErrorLogByBranchAndCauseOfError(@PathVariable String branchName, @PathVariable String causeOfError) {
		return errorIssueLogDetailService.getByBranchNameAndCauseOfError(branchName, causeOfError);
	}
	
	@PreAuthorize("hasAuthority('BM')")
	@GetMapping("/geterrorissue/branch/{branchName}/{start}/{end}")
	public List<ErrorIssueLog> getErrorLogIssueIncidentDateBetween(@PathVariable String branchName, @PathVariable(value = "start") @DateTimeFormat(pattern = "yyyy-MM-dd") Date start,
			@PathVariable(value = "end") @DateTimeFormat(pattern = "yyyy-MM-dd") Date end) {
		return errorIssueLogDetailService.ggetByBranchNameAndIncidentValueDateBetween(branchName, start, end);
	}
	
	//MC 
	
	@PreAuthorize("hasAuthority('BM')")
	@GetMapping("/getmclist/{branchName}")
	public List<ManagerCheque> getMCByBranch(@PathVariable String branchName) {
		return managerChequeDetailService.getByBranchName(branchName);
	}
	
	@PreAuthorize("hasAuthority('BM')")
	@GetMapping("/getmclist/filter/{branchName}/{mcStatus}")
	public List<ManagerCheque> getMCByBranchAndStatus(@PathVariable String branchName,
			@PathVariable String mcStatus) {
		return managerChequeDetailService.getByBranchNameAndMcStatus(branchName, mcStatus);
	}
	
	@PreAuthorize("hasAuthority('BM')")
	@GetMapping("/getmclist/{branchName}/{start}/{end}")
	public List<ManagerCheque> getMCBranchIssueDateBetween(@PathVariable String branchName, @PathVariable(value = "start") @DateTimeFormat(pattern = "yyyy-MM-dd") Date start,
			@PathVariable(value = "end") @DateTimeFormat(pattern = "yyyy-MM-dd") Date end) {
		return managerChequeDetailService.getByBranchNameAndIssueDateBetween(branchName,start, end);
	}
	
	//GFP
	
	@PreAuthorize("hasAuthority('BM')")
	@GetMapping("/getgfplist/{branchName}")
	public List<GoodForPayment> getGFPRecordByBranch(@PathVariable String branchName) {
		return goodForPaymentDetailService.getByBranchName(branchName);
	}
	
	@PreAuthorize("hasAuthority('BM')")
	@GetMapping("/getgfplist/filter/{branchName}/{gfpStatus}")
	public List<GoodForPayment> getGFPRecordByBranchAndStatus(@PathVariable String branchName, @PathVariable String gfpStatus) {
		return goodForPaymentDetailService.getByBranchNameAndGFPStatus(branchName, gfpStatus);
	}
	
	@PreAuthorize("hasAuthority('BM')")
	@GetMapping("/getgfplist/{branchName}/{start}/{end}")
	public List<GoodForPayment> getGFPBranchIssueDateBetween(@PathVariable String branchName, @PathVariable(value = "start") @DateTimeFormat(pattern = "yyyy-MM-dd") Date start,
			@PathVariable(value = "end") @DateTimeFormat(pattern = "yyyy-MM-dd") Date end) {
		return goodForPaymentDetailService.getByBranchNameAndIssueDateBetween(branchName, start, end);
	}
	
}
