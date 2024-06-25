$( document ).ready(function() {
		ajaxGetAllCustomer();
		ajaxGetInsCompany();
		
		$("#idFilterInsCompanyName").change(function() {
			$('#idFilterInsSchemeName').empty();
			ajaxGetInsScheme();
	    });
		$("#idFilterInsSchemeName").change(function() {
			ajaxGetInsCompanyAndSchemeName();
	    });
	});	

	function ajaxGetInsCompany(){		
		let insCompanyDropdown = $('#idFilterInsCompanyName');
		let insSchemeDropdown = $('#idFilterInsSchemeName');
		insCompanyDropdown.empty();
		insSchemeDropdown.empty();
		insCompanyDropdown.append('<option selected="true" disabled>Choose Insurance Company...</option>');
		insCompanyDropdown.prop('selectedIndex', 0);
		const url = '/getinsurancecompanylist';
		$.getJSON(url, function (data) {
			insSchemeDropdown.append('<option selected="true" disabled>Choose Insurance Company Name First...</option>');
		$.each(data, function (key, entry) {
		    insCompanyDropdown.append($('<option></option>').attr('value', entry.insCompanyName).text(entry.insCompanyName));
		  })
		  insCompanyDropdown.chosen();
		});
		$(window)
		.off('resize.chosen')
		.on('resize.chosen', function() {
			$('#idFilterInsCompanyName').each(function() {
				 var $this = $(this);
				 $this.next().css({minWidth: '220px', width: 'auto'});
			})
		}).trigger('resize.chosen'); 
		
	}
	
	function ajaxGetInsScheme(){		
		let insCompany = $('#idFilterInsCompanyName').val();
		let insSchemeName = $('#idFilterInsSchemeName');
		insSchemeName.empty();
		insSchemeName.append('<option selected="true" disabled>Choose Insurance Scheme Name...</option>');
		insSchemeName.prop('selectedIndex', 0);
		const url = '/getinsurancescheme/'+insCompany;
		$.getJSON(url, function (data) {
			$.each(data, function (key, entry) {			  
				insSchemeName.append($('<option></option>').attr('value', entry.insSchemaName).text(entry.insSchemaName));
			  })
			  insSchemeName.chosen();
			  insSchemeName.trigger('chosen:updated');
			});		
		ajaxGetCustomerByInsCompanyName(insCompany);
	}
	
	function ajaxGetInsCompanyAndSchemeName(){	
		let insCompanyName2 = $('#idFilterInsCompanyName').val();
		let schemeName2 = $('#idFilterInsSchemeName').val();
		ajaxGetCustomerByInsSchemeName(insCompanyName2, schemeName2);
	}
	
	
	
	function ajaxGetCustomerByInsCompanyName(insCompany){
		const url = '/getbycompanyname/'+insCompany;
		$.getJSON(url, function (data) {
			createDataTable(data);
		});
	}
	
	function ajaxGetCustomerByInsSchemeName(insCompany, insScheme){
		const url = '/getbycompanyandscheme/'+insCompany+'/'+insScheme;
		$.getJSON(url, function (data) {
			createDataTable(data);
		});
	}
	
	function ajaxGetAllCustomer(){
		const url = '/getallcustomer';
		$.getJSON(url, function (data) {
			createDataTable(data);
		});
	}
	
	function ajaxGetDetailByDateBetween(start, end){
		let startDate=start.format('YYYY-MM-DD');
		let endDate=end.format('YYYY-MM-DD');
		
		console.log(startDate+'--'+endDate);
		const url = '/getbystartdaterange/'+startDate+'/'+endDate;
		$.getJSON(url, function (data) {
			console.log(data);
			createDataTable(data);
		});
	}
	
	function ajaxGetDetailByEndDateBetween(start, end){
		let startDate=start.format('YYYY-MM-DD');
		let endDate=end.format('YYYY-MM-DD');
		const url = '/getbyenddaterange/'+startDate+'/'+endDate;
		$.getJSON(url, function (data) {
			console.log(data);
			createDataTable(data);
		});
	}	
	
	function createDataTable(data){
	         var table = $('#filter-table').DataTable({
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
	                 { "data": "clientCode" },
	                 { "data": "insCompanyName" },
	                 { "data": "insCompanyCode" },
	                 { "data": "insSchemaName" },
	                 { "data": "insSchemaCode" },
	                 { "data": "masterPolicyId" },
	                 { "data": "insStartedDate",
	                	 "render" : function(data, type, row, meta) {
								if (data === null) return "";
								var thisDate = moment(new Date(data)).format("YYYY-MM-DD");
								return thisDate
							}
	                	 },
	                 { "data": "insEndDate",
	                	 "render" : function(data, type, row, meta) {
								if (data === null) return "";
								var thisDate = moment(new Date(data)).format("YYYY-MM-DD");
								return thisDate
							}
	                	 },
	                 { "data": "insuredAmount" },
	                 { "data": "insInstallmentAmount" },
	                 { "data": "insPaymentFrequency" },
	                 { "data": "insStatus" },
	                 { "data": "bankBranchName" },
	                 { "data": "insMarketedBy" },
	                 { "data": "remarks" }
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
							autoPrint: true,
							orientation:'landscape',
							title: 'Customer Feedback (After Service)',
							message: 'DataTables from Utility Database'
						  }		  
	             ]
	            
	         });
	        
	         // Add event listener for opening and closing details
	         $('#filter-table tbody').on('click', 'td.details-control', function () {
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
	                 '<td width="15%"><strong>Insurance Company: </strong></td>' +
	                 '<td>' + d.insCompanyName + '</td>' +
	             '</tr>' +
	             '<tr>' +
	                 '<td width="15%"><strong>Insurance Company Code: </strong></td>' +
	                 '<td>' + d.insCompanyCode + '</td>' +
	             '</tr>' +
	             '<tr>' +
		             '<td width="15%"><strong>Scheme: </strong></td>' +
		             '<td>' + d.insSchemaName + '</td>' +
		         '</tr>' +
		         '<tr>' +
			         '<td width="15%"><strong>Scheme Code: </strong></td>' +
			         '<td>' + d.insSchemaCode + '</td>' +
			     '</tr>' +
			     '<tr>' +
			         '<td width="15%"><strong>Installment Amount: </strong></td>' +
			         '<td>' + d.insInstallmentAmount + '</td>' +
		         '</tr>' +
			     '<tr>' +
			         '<td width="15%"><strong>Payment Frequency: </strong></td>' +
			         '<td>' + d.insPaymentFrequency + '</td>' +
			     '</tr>' +
			     '<tr>' +
				     '<td width="15%"><strong>Remarks: </strong></td>' +
				     '<td>' + d.remarks + '</td>' +
				 '</tr>' +
	         '</table>';  
	    	}
	}
	
