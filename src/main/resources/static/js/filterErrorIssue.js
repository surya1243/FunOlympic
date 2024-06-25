$( document ).ready(function() {		
	ajaxGetErrorIssueList();
	});	

function ajaxGetErrorIssueList(){
		const url = '/geterrorissuelist';
		$.getJSON(url, function (data) {
			console.log(data);
			createDataTable(data);
		});
	}
	

$("#idNatureVal").change(function() {
	if (!$('#branchName-dropdown').val()) {
		ajaxgetErrorLogByMcStatus();
	} else {
		ajaxgetErrorLogByBranchStatus();
	}
});

$("#branchName-dropdown").change(function() {
	if (!$('#idNatureVal').val()) {
		ajaxgetErrorLogByBranchName();
	} else {
		ajaxgetErrorLogByBranchStatus();
	}

});

function ajaxgetErrorLogByBranchStatus() {
	let mcStatusVal = $('#idNatureVal').val();
	let branchVal = $('#branchName-dropdown').val();
	const url = '/geterrorissue/filter/' + branchVal + '/' + mcStatusVal;
	$.getJSON(url, function(data) {
		createDataTable(data);
	});
}

function ajaxgetErrorLogByBranchName() {
	let branchName = $('#branchName-dropdown').val();
	const url = '/geterrorissue/branch/' + branchName;
	$.getJSON(url, function(data) {
		createDataTable(data);
	});
}

// By category
function ajaxgetErrorLogByMcStatus() {
	let mcStatusVal = $('#idNatureVal').val();
	const url = '/geterrorissue/nature/' + mcStatusVal;
	$.getJSON(url, function(data) {
		createDataTable(data);
	});
}

function ajaxGetErrorByIncidentDateBetween(start, end) {
	let startDate = start.format('YYYY-MM-DD');
	let endDate = end.format('YYYY-MM-DD');
	const url = '/geterrorissue/' + startDate + '/' + endDate;
	console.log(startDate, endDate);
	$.getJSON(url, function(data) {
		console.log(data);
		createDataTable(data);
	});
}


	function createDataTable(data){
	         var table = $('#error-table').DataTable({
	        	 "order" : [ 1, "desc" ],
	        	 destroy: true,
	             "data": data,
	             select:"single",
	             "columns": [
	                 {
	                     "className": 'details-control',
	                     "orderable": false,
	                     "data": null,
	                     "defaultContent": '',
	                     "render": function () {
	                         return '<i class="ace-icon fa fa-angle-double-down fa-2x" title="Show details" aria-hidden="true"></i>';
	                     },
	                     width:"15px"
	                 },
	                 { "data": "incidentValueDate", 
	                   "render" : function(data, type, row, meta) {
							if (data === null) return "";
							var thisDate = moment(new Date(data)).format("YYYY-MM-DD hh:mm a");
							return thisDate
						}
	                 },
	 	                { "data": "branchName",
	 	                	"render": function(data,type,row,meta) { // render event defines the markup of the cell text 
	 	                       var a = '<a href="errorissue/detailpage/' + row["id"]+ '">' + row.branchName +'</a>'; // row object contains the row data
	 	                       return a;}
	 	                 },
	                 { "data": "departmentUnit" },
	                 { "data": "transactionId" },
	                 { "data": "transactionAmount",
	                	 "render" : function(data, type,
									row, meta) {
								return currency(row.transactionAmount, {useVedic: true, decimal: '.', precision: 2}).format();
							}
	                 
	                 
	                 
	                 },
	                 { "data": "trxnEnteredBy" },
	                 { "data": "trxnApprovedBy" },
	                 { "data": "natureOfError" },
	                 { "data": "errorDetail" },
	                 { "data": "reportedBy" },
	                 { "data": "causeOfError" },
	                 { "data": "stepsToAddressError" },
	                 { "data": "resolutionDetail" },
	                 { "data": "resolutionApprovalGivenBy" },
	                 { "data": "progressStatus"},
	                 { "data": "errorLodgedBy" },
	                 { "data": "errorLodgedModifiedBy" },
	             ], 
	             
	             dom: 'Blfrtip',
	             buttons: [
	            	 {
							"extend": "copy",
							"text": "<i class='fa fa-copy bigger-110 pink'></i> <span class='hidden'>Copy to clipboard</span>",
							"className": "btn btn-white btn-primary btn-bold"
						  },
						  {
							"extend": "csv",
							"text": "<i class='fa fa-file-excel-o bigger-110 blue'></i> <span class='hidden'>Export to CSV</span>",
							"className": "btn btn-white btn-primary btn-bold"
						  },
						  {
							"extend": "excel",
							"text": "<i class='fa fa-file-excel-o bigger-110 green'></i> <span class='hidden'>Export to Excel</span>",
							"className": "btn btn-white btn-primary btn-bold",
							"exportOptions": { modifier: { page: 'all'} }
						  },
						  {
							"extend": "pdf",
							"text": "<i class='fa fa-file-pdf-o bigger-110 red'></i> <span class='hidden'>Export to PDF</span>",
							"className": "btn btn-white btn-primary btn-bold",
							"exportOptions": { modifier: { page: 'all'} }
						  },
						  {
							"extend": "print",
							"text": "<i class='fa fa-print bigger-110 grey'></i> <span class='hidden'>Print</span>",
							"className": "btn btn-white btn-primary btn-bold",							
							autoPrint: false,
							orientation:'landscape',
							title: 'Error/Issue/Log'
						  }		  
	             ]
	            
	         });
	        
	         // Add event listener for opening and closing details
	         $('#error-table tbody').on('click', 'td.details-control', function () {
	             var tr = $(this).closest('tr');
	             var tdi = tr.find("i.fa");
	             var row = table.row(tr);

	             if (row.child.isShown()) {
	                 // This row is already open - close it
	                 row.child.hide();
	                 tr.removeClass('shown');
	                 tdi.first().removeClass('fa fa-angle-double-up fa-2x');
	                 tdi.first().addClass('fa fa-angle-double-down fa-2x');
	             }
	             else {
	                 // Open this row
	                 row.child(format(row.data())).show();
	                 tr.addClass('shown');
	                 tdi.first().removeClass('fa fa-angle-double-down fa-2x');
	                 tdi.first().addClass('fa fa-angle-double-up fa-2x');
	             }
	         });

	         table.on("user-select", function (e, dt, type, cell, originalEvent) {
	             if ($(cell.node()).hasClass("details-control")) {
	                 e.preventDefault();
	             }
	         });
	         
	    function format(d){
	         // `d` is the original data object for the row
	         return '<table class="table table-striped table-bordered table-hover">' +
	             '<tr>' +
					 	'<td width="25%"><strong> Incident Date: </strong></td>' +
						'<td>' + moment(new Date(d.incidentValueDate)).format("YYYY-MM-DD") + '</td>' +
	             '</tr>' +
	             '<tr>' +
	                 '<td width="25%"><strong> Branch: </strong></td>' +
	                 '<td>' + d.branchName + '</td>' +
	             '</tr>' +
	             '<tr>' +
		             '<td width="25%"><strong> Department: </strong></td>' +
		             '<td>' + d.departmentUnit + '</td>' +
		         '</tr>' +
		         '<tr>' +
			         '<td width="25%"><strong> Transaction ID: </strong></td>' +
			         '<td>' + d.transactionId + '</td>' +
			     '</tr>' +
			     '<tr>' +
			         '<td width="25%"><strong> Amount: </strong></td>' +
			         '<td>' + currency(d.transactionAmount, {useVedic: true, decimal: '.',symbol: 'Rs. ', formatWithSymbol: true, precision: 2}).format() + '</td>' +
		         '</tr>' +
			     '<tr>' +
			         '<td width="25%"><strong> Transaction Entered By: </strong></td>' +
			         '<td>' + d.trxnEnteredBy + '</td>' +
			     '</tr>' +
			     '<tr>' +
				     '<td width="25%"><strong> Transaction Approved By: </strong></td>' +
				     '<td>' + d.trxnApprovedBy + '</td>' +
				 '</tr>' +
			     '<tr>' +
			     	'<td width="25%"><strong> Nature of Error: </strong></td>' +
			     	'<td>' + d.natureOfError + '</td>' +
				 '</tr>' +	
			     '<tr>' +
			     	'<td width="25%"><strong> Details of Error: </strong></td>' +
			     	'<td>' + d.errorDetail + '</td>' +
				 '</tr>' +	
			     '<tr>' +
			     	'<td width="25%"><strong> Reported By: </strong></td>' +
			     	'<td>' + d.reportedBy + '</td>' +
				 '</tr>' +	
			     '<tr>' +
			     	'<td width="25%"><strong> Cause of Error: </strong></td>' +
			     	'<td>' + d.causeOfError + '</td>' +
				 '</tr>' +	
				 '<tr>' +
				 	'<td width="25%"><strong> Necessary Steps to Address Error: </strong></td>' +
				 	'<td>' + d.stepsToAddressError + '</td>' +
				'</tr>' +	
				'<tr>' +
					'<td width="25%"><strong> Brief Details of Resolutions (How to fix error???): </strong></td>' +
					'<td>' + d.resolutionDetail + '</td>' +
				'</tr>' +	
				'<tr>' +
					'<td width="25%"><strong> Approval Given By (For Resolution): </strong></td>' +
					'<td>' + d.resolutionApprovalGivenBy + '</td>' +
				'</tr>' +	
				'<tr>' +
					'<td width="25%"><strong> Progress Status of Issue: </strong></td>' +
					'<td>' + d.progressStatus + '</td>' +
				'</tr>' +	
				'<tr>' +
					'<td width="25%"><strong> Resolved Date: </strong></td>' +
					'<td>' + moment(new Date(d.resolvedDate)).format("YYYY-MM-DD hh:mm a") + '</td>' +
				'</tr>' +
				'<tr>' +
					'<td width="25%"><strong> Error Lodged By: </strong></td>' +
					'<td>' + d.errorLodgedBy + '</td>' +
				'</tr>' +
				'<tr>' +
					'<td width="25%"><strong> Error Lodged Modified By: </strong></td>' +
					'<td>' + d.errorLodgedModifiedBy + '</td>' +
				'</tr>' +
	        '</table>';  
	    	}
	}
	

