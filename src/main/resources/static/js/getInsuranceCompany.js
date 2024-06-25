$( document ).ready(function() {		
		ajaxGetInsuranceCompany();
		$("#insCompanyName").change(function() {
			ajaxGetInsuranceCompanyCode();
	    });
	});	
	// DO GET Branch
	function ajaxGetInsuranceCompany(){		
		let dropdown1 = $('#insCompanyName');
		dropdown1.empty();
		dropdown1.append('<option selected="true" disabled>Choose Insurance Company...</option>');
		dropdown1.prop('selectedIndex', 0);
		const url = '/getinsurancecompanylist';
		$.getJSON(url, function (data) {
		$.each(data, function (key, entry) {			  
		    dropdown1.append($('<option></option>').attr('value', entry.insCompanyName).text(entry.insCompanyName));
		  })
		  //dropdown1.chosen();
		});
		$(window)
		.off('resize.chosen')
		.on('resize.chosen', function() {
			$('#insCompanyName').each(function() {
				 var $this = $(this);
				 $this.next().css({minWidth: '380px'});
			})
		}).trigger('resize.chosen'); 
		
	}
	function ajaxGetInsuranceCompanyCode(){		
		let dropdown2 = $('#insCompanyName').val();
		console.log(dropdown2);
		let insCompanyCodes = $('#insCompanyCode');
		const url = '/getinsurancecompany/'+dropdown2;
		$.getJSON(url, function (data) {
			insCompanyCodes.empty();
			insCompanyCodes.append($("<input class='hidden' name='insCompanyCode'>").attr('value', data.insCompanyCode).text(data.insCompanyCode));
			insCompanyCodes.append("<div class='dd-handle'>Insurance Company Code: <span class='orange'>" + data.insCompanyCode+"</span></div>");
			});
	}
	