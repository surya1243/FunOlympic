$(document).ready(function() {
	ajaxGetMCList();
});

function ajaxGetMCList() {
	const url = '/getmclist';
	$.getJSON(url, function(data) {
		createDataTable(data);
	});
}

$("#idMCStauts").change(function() {
	if (!$('#branchName-dropdown').val()) {
		ajaxgetMcRecordByMcStatus();
	} else {
		ajaxgetMcRecordByBranchStatus();
	}
});

$("#branchName-dropdown").change(function() {
	if (!$('#idMCStauts').val()) {
		ajaxgetMcRecordByBranchName();
	} else {
		ajaxgetMcRecordByBranchStatus();
	}

});

function ajaxgetMcRecordByBranchStatus() {
	let mcStatusVal = $('#idMCStauts').val();
	let branchVal = $('#branchName-dropdown').val();
	const url = '/getmclist/filter/' + branchVal + '/' + mcStatusVal;
	$.getJSON(url, function(data) {
		createDataTable(data);
	});
}

function ajaxgetMcRecordByBranchName() {
	let branchName = $('#branchName-dropdown').val();
	const url = '/getmclist/branch/' + branchName;
	$.getJSON(url, function(data) {
		createDataTable(data);
	});
}

// By category
function ajaxgetMcRecordByMcStatus() {
	let mcStatusVal = $('#idMCStauts').val();
	const url = '/getmclist/status/' + mcStatusVal;
	$.getJSON(url, function(data) {
		createDataTable(data);
	});
}

function ajaxGetMcRecordIssuedDateBetween(start, end) {
	let startDate = start.format('YYYY-MM-DD');
	let endDate = end.format('YYYY-MM-DD');
	const url = '/getmclist/' + startDate + '/' + endDate;
	console.log(startDate, endDate);
	$.getJSON(url, function(data) {
		console.log(data);
		createDataTable(data);
	});
}

function createDataTable(data) {
	var table = $('#mc-table')
			.DataTable(
					{
						"order" : [ 1, "desc" ],
						destroy : true,
						"data" : data,
						select : "single",

						"columns" : [
								{
									"className" : 'details-control',
									"orderable" : false,
									"data" : null,
									"defaultContent" : '',
									"render" : function() {
										return '<i class="ace-icon fa fa-angle-double-down fa-2x" title="Show details" aria-hidden="true"></i>';
									},
									width : "15px"
								},
								{
									"data" : "issueDate",
									"render" : function(data, type, row, meta) {
										if (data === null)
											return "";
										var thisDate = moment(new Date(data))
												.format("YYYY-MM-DD");
										return thisDate
									}
								},
								{
									"data" : "branchName",
									"render" : function(data, type, row, meta) { // render
																					// event
																					// defines
																					// the
																					// markup
																					// of
																					// the
																					// cell
																					// text
										var a = '<a href="getmc/' + row["id"]
												+ '">' + row.branchName
												+ '</a>'; // row object
															// contains the row
															// data
										return a;
									}
								},
								{
									"data" : "chequeDate",
									"render" : function(data, type, row, meta) {
										if (data === null)
											return "";
										var thisDate = moment(new Date(data))
												.format("YYYY-MM-DD");
										return thisDate
									}
								},
								{
									"data" : "partiesName"
								},
								{
									"data" : "amount",
									render : function(data, type,
											row) {
										return currency(row.amount, {useVedic: true, decimal: '.', precision: 2}).format();
									}
								},
								{
									"data" : "purposeOfPayment"
								},
								{
									"data" : "systemInputBy"
								},
								{
									"data" : "systemApprovedBy"
								},
								{
									"data" : "mcStatus",
										"render" : function(data, type, row, meta) {
						                	 if (row.mcStatus === "Active") {
						                         return '<span class="label label-lg label-success arrowed-in arrowed-in-right" /*aria-hidden="true"*/>Active</span>';
						                     }
						                	 else if(row.mcStatus === "Cancel"){
						                		 return '<span class="label label-lg label-pink" /*aria-hidden="true"*/>Cancelled</span>';
						                     }
						                	 else if(row.mcStatus === "Paid"){
						                		 return '<span class="label label-lg label-info" /*aria-hidden="true"*/>Paid</span>';
						                     }
						                	 }
								},
								{
									"data" : "paidCancelDate",
									"render" : function(data, type, row, meta) {
										if (data === null)
											return "";
										var thisDate = moment(new Date(data))
												.format("YYYY-MM-DD");
										return thisDate
									}
								} ],

						dom : 'Blfrtip',
						buttons : [
								{
									"extend" : "copy",
									"text" : "<i class='fa fa-copy bigger-110 pink'></i> <span class='hidden'>Copy to clipboard</span>",
									"className" : "btn btn-white btn-primary btn-bold"
								},
								{
									"extend" : "csv",
									"text" : "<i class='fa fa-file-excel-o bigger-110 blue'></i> <span class='hidden'>Export to CSV</span>",
									"className" : "btn btn-white btn-primary btn-bold"
								},
								{
									"extend" : "excel",
									"text" : "<i class='fa fa-file-excel-o bigger-110 green'></i> <span class='hidden'>Export to Excel</span>",
									"className" : "btn btn-white btn-primary btn-bold",
									"exportOptions" : {
										modifier : {
											page : 'all'
										}
									}
								},
								{
									"extend" : "pdf",
									"text" : "<i class='fa fa-file-pdf-o bigger-110 red'></i> <span class='hidden'>Export to PDF</span>",
									"className" : "btn btn-white btn-primary btn-bold",
									"exportOptions" : {
										modifier : {
											page : 'all'
										}
									}
								},
								{
									"extend" : "print",
									"text" : "<i class='fa fa-print bigger-110 grey'></i> <span class='hidden'>Print</span>",
									"className" : "btn btn-white btn-primary btn-bold",
									autoPrint : true,
									orientation : 'landscape',
									title : "Manager's Cheque Record"
								} ]

					});

	// Add event listener for opening and closing details
	$('#mc-table tbody').on('click', 'td.details-control', function() {
		var tr = $(this).closest('tr');
		var tdi = tr.find("i.fa");
		var row = table.row(tr);

		if (row.child.isShown()) {
			// This row is already open - close it
			row.child.hide();
			tr.removeClass('shown');
			tdi.first().removeClass('fa fa-angle-double-up fa-2x');
			tdi.first().addClass('fa fa-angle-double-down fa-2x');
		} else {
			// Open this row
			row.child(format(row.data())).show();
			tr.addClass('shown');
			tdi.first().removeClass('fa fa-angle-double-down fa-2x');
			tdi.first().addClass('fa fa-angle-double-up fa-2x');
		}
	});

	table.on("user-select", function(e, dt, type, cell, originalEvent) {
		if ($(cell.node()).hasClass("details-control")) {
			e.preventDefault();
		}
	});

	function format(d) {
		// `d` is the original data object for the row
		return '<table class="table table-striped table-bordered table-hover">'
				+ '<tr>'
				+ '<td width="25%"><strong> Issue Date: </strong></td>'
				+ '<td>'
				+ moment(new Date(d.issueDate)).format("YYYY-MM-DD")
				+ '</td>'
				+ '</tr>'
				+ '<tr>'
				+ '<td width="25%"><strong> Branch: </strong></td>'
				+ '<td>'
				+ d.branchName
				+ '</td>'
				+ '</tr>'
				+ '<tr>'
				+ '<td width="25%"><strong> Cheque Date: </strong></td>'
				+ '<td>'
				+ moment(new Date(d.chequeDate)).format("YYYY-MM-DD")
				+ '</td>'
				+ '</tr>'
				+ '<tr>'
				+ '<td width="25%"><strong> Partys Name: </strong></td>'
				+ '<td>'
				+ d.partiesName
				+ '</td>'
				+ '</tr>'
				+ '<tr>'
				+ '<td width="25%"><strong> Amount: </strong></td>'
				+ '<td>'
				+ currency(d.amount, {useVedic: true, decimal: '.',symbol: 'Rs. ', formatWithSymbol: true, precision: 2}).format()
				+ '</td>'
				+ '</tr>'
				+ '<tr>'
				+ '<td width="25%"><strong> Purpose of Payment: </strong></td>'
				+ '<td>'
				+ d.purposeOfPayment
				+ '</td>'
				+ '</tr>'
				+ '<tr>'
				+ '<td width="25%"><strong> System Input By: </strong></td>'
				+ '<td>'
				+ d.systemInputBy
				+ '</td>'
				+ '</tr>'
				+ '<tr>'
				+ '<td width="25%"><strong> System Approved By: </strong></td>'
				+ '<td>'
				+ d.systemApprovedBy
				+ '</td>'
				+ '</tr>'
				+ '<tr>'
				+ '<td width="25%"><strong> Manager Cheque Status: </strong></td>'
				+ '<td>'
				+ d.mcStatus
				+ '</td>'
				+ '</tr>'
				+ '<tr>'
				+ '<td width="25%"><strong> MC Record Lodged By: </strong></td>'
				+ '<td>'
				+ d.mcLodgedBy
				+ '</td>'
				+ '</tr>'
				+ '<tr>'
				+ '<td width="25%"><strong> MC Record Modified By: </strong></td>'
				+ '<td>'
				+ d.mcLodgedModifiedBy
				+ '</td>'
				+ '</tr>'
				+ '</table>';
	}
}
