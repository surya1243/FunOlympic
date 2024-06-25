$( document ).ready(function() {		
		ajaxGetInsuranceCompany();
		$("#idInsCompanyName").change(function() {
			let test = $('#idInsSchemeName');
			test.empty();
			ajaxGetInsCompanyScheme();
	    });
		$("#idInsSchemeName").change(function() {
			ajaxGetInsSchemeCode();
	    });
	});	

	function ajaxGetInsuranceCompany(){		
		let dropdown1 = $('#idInsCompanyName');
		let dropdowntest = $('#idInsSchemeName');
		dropdown1.empty();
		dropdowntest.empty();
		dropdown1.append('<option selected="true" disabled>Choose Insurance Company...</option>');
		dropdown1.prop('selectedIndex', 0);
		const url = '/getinsurancecompanylist';
		$.getJSON(url, function (data) {
			dropdowntest.append('<option selected="true" disabled>Choose Insurance Company Name First...</option>');
		$.each(data, function (key, entry) {
		    dropdown1.append($('<option></option>').attr('value', entry.insCompanyName).text(entry.insCompanyName));
		  })
		  dropdown1.chosen();
		});
		$(window)
		.off('resize.chosen')
		.on('resize.chosen', function() {
			$('#idInsCompanyName').each(function() {
				 var $this = $(this);
				 $this.next().css({minWidth: '220px', width: 'auto'});
			})
		}).trigger('resize.chosen'); 
		
	}
	function ajaxGetInsCompanyScheme(){		
		let insCompany = $('#idInsCompanyName').val();
		let insSchemeName = $('#idInsSchemeName');
		insSchemeName.empty();
		$('#idSchemeCode').empty();
		$('#idSchemaTenure').empty();
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
	}
	
	function ajaxGetInsSchemeCode(){		
		let schemeName = $('#idInsSchemeName').val();
		console.log(schemeName);
		let insSchemeCode = $('#idSchemeCode');
		let insSchemeTenure = $('#idSchemaTenure');
		let insCompanyCode = $('#idInsCompanyCode');
		insSchemeCode.empty();
		insSchemeTenure.empty();
		insCompanyCode.empty();
		const url = '/getbyschemename/'+schemeName;
		$.getJSON(url, function (data) {
			insSchemeCode.empty();
			insSchemeTenure.empty();
			insCompanyCode.empty();
			insSchemeCode.append($("<input class='hidden' name='insSchemaCode'>").attr('value', data.insSchemaCode).text(data.insSchemaCode));
			insSchemeCode.append("<div class='dd-handle'>Insurance Scheme Code: <span class='orange'>" + data.insSchemaCode+"</span></div>");
			insSchemeTenure.append($("<input class='hidden' name='insSchemaTenure'>").attr('value', data.insSchemaTenure).text(data.insSchemaTenure));
			insSchemeTenure.append("<div class='dd-handle'>SchemaTenure (Years): <span class='orange'>" + data.insSchemaTenure+"</span></div>");
			insCompanyCode.append($("<input class='hidden' name='insCompanyCode'>").attr('value', data.insCompanyCode).text(data.insCompanyCode));
			insCompanyCode.append("<div class='dd-handle'>Insurance Company Code: <span class='orange'>" + data.insCompanyCode+"</span></div>");
			});
	}
	