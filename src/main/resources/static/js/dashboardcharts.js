$(window).load(function() {
	$("#container").html('<div class="blue bigger-150">Loading  <i class="ace-icon fa fa-spinner fa-spin blue bigger-150"></i>  </div>')
	var container = $("#container");

	$("#mCcontainer").html('<div class="blue bigger-150">Loading  <i class="ace-icon fa fa-spinner fa-spin blue bigger-150"></i>  </div>')
	var mCcontainer = $("#mCcontainer");

	$("#gfpContainer").html('<div class="blue bigger-150">Loading  <i class="ace-icon fa fa-spinner fa-spin blue bigger-150"></i>  </div>')
	var gfpContainer = $("#gfpContainer");

	$("#lockerContainer").html('<div class="blue bigger-150">Loading  <i class="ace-icon fa fa-spinner fa-spin blue bigger-150"></i>  </div>')
	var lockerContainer = $("#lockerContainer");

	$("#accReportContainer").html('<div class="blue bigger-150">Loading  <i class="ace-icon fa fa-spinner fa-spin blue bigger-150"></i>  </div>')
	var accReportContainer = $("#accReportContainer");

	$("#feedbackContainer").html('<div class="blue bigger-150">Loading  <i class="ace-icon fa fa-spinner fa-spin blue bigger-150"></i>  </div>')
	var feedbackContainer = $("#feedbackContainer");

	var today = new Date();
	var yesterday = new Date(today);

	yesterday.setDate(today.getDate() - 1);
	let formatedYesterday = yesterday.toISOString().slice(0, 10);

	$.ajax({
		url: '/sports/count',  // Adjust the URL to match your Spring Boot endpoint
		type: "GET",
		dataType: 'json',
		contentType: 'application/json',
		success: function(response) {
			var data = [];

			// Process response into Highcharts data format
			for (var key in response) {
				if (response.hasOwnProperty(key)) {
					data.push({ name: key, y: response[key] });
				}
			}

			// Check if there is any data to display
			if (data.length > 0) {
				Highcharts.setOptions({
					colors: ['#50B432', '#ED561B', '#058DC7', '#DDDF00', '#24CBE5', '#64E572', '#FF9655', '#FFF263', '#6AF9C4']
				});

				Highcharts.chart('feedbackContainer', {
					chart: {
						type: 'pie'
					},
					title: {
						text: "Sports Selection Statistics"
					},
					legend: {
						labelFormat: '{name}: <span style="opacity: 0.9">{y}</span>'
					},
					credits: {
						enabled: false
					},
					tooltip: {
						pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
					},
					plotOptions: {
						pie: {
							allowPointSelect: true,
							cursor: 'pointer',
							depth: 35,
							dataLabels: {
								enabled: true,
								format: '{point.name}'
							}
						}
					},
					series: [{
						type: 'pie',
						name: 'Sports Count',
						data: data,
						showInLegend: true
					}]
				});
			} else {
				$("#feedbackContainer").html("<strong>No data available.</strong>");
			}
		},
		error: function(xhr, status, error) {
			console.error("Error fetching sports count:", error);
			$("#feedbackContainer").html("<strong>Error fetching data.</strong>");
		}
	});


	/*$.ajax({
		url: '/countfeedback/rating',
		type: "GET",
		dataType: 'json',
		contentType: 'application/json',
		success: function(response) {
			var processed_json = new Array();
			for (var key in response) {
				if (response.hasOwnProperty(key)) {
					processed_json.push([key, response[key]])
				}
			}

			if (response) {
				Highcharts.setOptions({
					colors: ['#50B432', '#ED561B', '#058DC7', '#DDDF00', '#24CBE5', '#64E572', '#FF9655', '#FFF263', '#6AF9C4']
				});

				Highcharts.chart('feedbackContainer', {
					chart: {
						type: 'pie'
					},
					title: {
						text: "Feedback Statistics"
					},
					legend: {
						labelFormat: '{name}: <span style="opacity: 0.9">{y}</span>'
					},
					credits: {
						enabled: false
					},
					tooltip: {
						pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
					},
					plotOptions: {
						pie: {
							allowPointSelect: true,
							cursor: 'pointer',
							depth: 35,
							dataLabels: {
								enabled: true,
								format: '{point.name}'
							}
						}
					},
					series: [{
						type: 'pie',
						name: 'Rating of Service',
						data: processed_json,
						showInLegend: true
					}]
				});
			} else {
				$("#feedbackContainer").html("<strong>Oops, an error occured fetching the data.</strong>");
			}


		}
	});

*/

	$.ajax({
		url: '/countdeliverystatus/deliveryStatus',
		type: "GET",
		dataType: 'json',
		contentType: 'application/json',
		success: function(response) {
			var processed_json = new Array();
			for (var key in response) {
				if (response.hasOwnProperty(key)) {
					processed_json.push([key, response[key]])
				}
			}

			if (response) {
				Highcharts.setOptions({
					colors: ['#DDDF00', '#24CBE5', '#64E572', '#50B432', '#ED561B', '#058DC7', '#FF9655', '#FFF263', '#6AF9C4']
				});

				Highcharts.chart('container', {
					chart: {
						type: 'pie',
						options3d: {
							enabled: true,
							alpha: 45,
							beta: 0
						}
					},
					title: {
						text: 'Card Delivered Status'
					},
					legend: {
						labelFormat: '{name}: <span style="opacity: 0.9">{y}</span>'
					},
					credits: {
						enabled: false
					},
					tooltip: {
						pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
					},
					plotOptions: {
						pie: {
							allowPointSelect: true,
							cursor: 'pointer',
							depth: 35,
							dataLabels: {
								enabled: true,
								format: '{point.name}'
							}
						}
					},
					series: [{
						type: 'pie',
						name: 'Card Delivered Status',
						data: processed_json,
						showInLegend: true
					}]
				});
			} else {
				$("#container").html("<strong>Oops, an error occured fetching the data.</strong>");
			}


		}
	});

	$.ajax({
		url: '/countmc/mcStatus',
		type: "GET",
		dataType: 'json',
		contentType: 'application/json',
		success: function(response) {
			var processed_json = new Array();
			for (var key in response) {
				if (response.hasOwnProperty(key)) {
					processed_json.push([key, response[key]])
				}
			}

			if (response) {
				Highcharts.setOptions({
					colors: ['#50B432', '#ED561B', '#058DC7', '#DDDF00', '#24CBE5', '#64E572', '#FF9655', '#FFF263', '#6AF9C4']
				});

				Highcharts.chart('mCcontainer', {
					chart: {
						type: 'pie',
						options3d: {
							enabled: true,
							alpha: 45,
							beta: 0
						}
					},
					title: {
						text: "Manager's Cheque Status"
					},
					legend: {
						labelFormat: '{name}: <span style="opacity: 0.9">{y}</span>'
					},
					credits: {
						enabled: false
					},
					tooltip: {
						pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
					},
					plotOptions: {
						pie: {
							allowPointSelect: true,
							cursor: 'pointer',
							depth: 35,
							dataLabels: {
								enabled: true,
								format: '{point.name}'
							}
						}
					},
					series: [{
						type: 'pie',
						name: 'Card Delivered Status',
						data: processed_json,
						showInLegend: true
					}]
				});
			} else {
				$("#container").html("<strong>Oops, an error occured fetching the data.</strong>");
			}


		}
	});

	$.ajax({
		url: '/countgfp/gfpStatus',
		type: "GET",
		dataType: 'json',
		contentType: 'application/json',
		success: function(response) {
			var processed_json = new Array();
			for (var key in response) {
				if (response.hasOwnProperty(key)) {
					processed_json.push([key, response[key]])
				}
			}

			if (response) {
				Highcharts.setOptions({
					colors: ['#FF9655', '#FFF263', '#ED561B', '#6AF9C4', '#50B432', '#058DC7', '#DDDF00', '#24CBE5', '#64E572']
				});

				Highcharts.chart('gfpContainer', {
					chart: {
						type: 'pie',
						options3d: {
							enabled: true,
							alpha: 45,
							beta: 0
						}
					},
					title: {
						text: "Good for Payment Status"
					},
					legend: {
						labelFormat: '{name}: <span style="opacity: 0.9">{y}</span>'
					},
					credits: {
						enabled: false
					},
					tooltip: {
						pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
					},
					plotOptions: {
						pie: {
							allowPointSelect: true,
							cursor: 'pointer',
							depth: 35,
							dataLabels: {
								enabled: true,
								format: '{point.name}'
							}
						}
					},
					series: [{
						type: 'pie',
						name: 'Card Delivered Status',
						data: processed_json,
						showInLegend: true
					}]
				});
			} else {
				$("#container").html("<strong>Oops, an error occured fetching the data.</strong>");
			}


		}
	});

	$.ajax({
		url: '/countlocker/lockerStatus',
		type: "GET",
		dataType: 'json',
		contentType: 'application/json',
		success: function(response) {
			var processed_json = new Array();
			for (var key in response) {
				if (response.hasOwnProperty(key)) {
					processed_json.push([key, response[key]])
				}
			}

			if (response) {
				Highcharts.setOptions({
					colors: ['#50B432', '#ED561B', '#058DC7', '#DDDF00', '#24CBE5', '#64E572', '#FF9655', '#FFF263', '#6AF9C4']
				});

				Highcharts.chart('lockerContainer', {
					chart: {
						type: 'pie'
					},
					title: {
						text: "Locker Status"
					},
					legend: {
						labelFormat: '{name}: <span style="opacity: 0.9">{y}</span>'
					},
					credits: {
						enabled: false
					},
					tooltip: {
						pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
					},
					plotOptions: {
						pie: {
							allowPointSelect: true,
							cursor: 'pointer',
							depth: 35,
							dataLabels: {
								enabled: true,
								format: '{point.name}'
							}
						}
					},
					series: [{
						type: 'pie',
						name: 'Card Delivered Status',
						data: processed_json,
						showInLegend: true
					}]
				});
			} else {
				$("#container").html("<strong>Oops, an error occured fetching the data.</strong>");
			}


		}
	});

/*
	//test for account report log
	$.ajax({
		//url: '/getallaccountlog',
		url: '/getaccountinfo/bydate/' + formatedYesterday,
		type: "GET",
		dataType: 'json',
		contentType: 'application/json',
		success: function(response) {
			console.log(response);


			var val = response.reduce(function(previousValue, currentValue) {
				return {
					currentAccNatural: previousValue.currentAccNatural + currentValue.currentAccNatural,
					currentCallAccInstitutional: previousValue.currentCallAccInstitutional + currentValue.currentCallAccInstitutional,
					savingAcc: previousValue.savingAcc + currentValue.savingAcc,
					fdAcc: previousValue.fdAcc + currentValue.fdAcc,
					termLoanAcc: previousValue.termLoanAcc + currentValue.termLoanAcc,
					wcLoanAcc: previousValue.wcLoanAcc + currentValue.wcLoanAcc,
					odLoanAcc: previousValue.odLoanAcc + currentValue.odLoanAcc,
					mobileBanking: previousValue.mobileBanking + currentValue.mobileBanking,
					atm: previousValue.atm + currentValue.atm,
					iBanking: previousValue.iBanking + currentValue.iBanking,
					qrCode: previousValue.qrCode + currentValue.qrCode,
					loanRepayments: previousValue.loanRepayments + currentValue.loanRepayments,
				}
			});

			var show = Highcharts.chart('accReportContainer', {
				chart: {
					type: 'column',
				},
				title: {
					text: 'Product Wise Daily Report '
				},
				subtitle: {
					text: 'Date: ' + formatedYesterday
				},
				accessibility: {
					announceNewData: {
						enabled: true
					}
				},
				xAxis: {
					type: 'category',
					labels: {
						rotation: -45,
						style: {
							fontSize: '13px',
							fontFamily: 'Verdana, sans-serif'
						}
					}
				},
				yAxis: {
					title: {
						text: 'Total Number Count'
					}

				},
				legend: {
					enabled: false
				},
				plotOptions: {
					series: {
						borderWidth: 0,
						dataLabels: {
							enabled: true,
							format: '{point.y}'
						}
					}
				},
				credits: {
					enabled: false
				},
				tooltip: {
					headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
					pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y}</b><br/>'
				},

				series: [
					{
						name: "Number of",
						colorByPoint: true,
						data: [
							{
								name: "Current (Natural)",
								y: val.currentAccNatural
							},
							{
								name: "Current/Call (Institutional) ",
								y: val.currentCallAccInstitutional

							},
							{
								name: "Savings Account",
								y: val.savingAcc
							},
							{
								name: "FD Account",
								y: val.fdAcc
							},
							{
								name: "Term Loan Account ",
								y: val.termLoanAcc
							},
							{
								name: "WC Loan Account ",
								y: val.wcLoanAcc
							},
							{
								name: "OD Loan Account",
								y: val.odLoanAcc
							},
							{
								name: "Mobile Banking",
								y: val.mobileBanking
							},
							{
								name: "ATM ",
								y: val.atm
							},
							{
								name: "Internet Banking",
								y: val.iBanking
							},
							{
								name: "QR Code",
								y: val.qrCode
							},
							{
								name: "Loan Repayments",
								y: val.loanRepayments
							}
						]
					}
				]

			});


		}
	});*/

$.ajax({
    url: '/sports/count',
    type: "GET",
    dataType: 'json',
    contentType: 'application/json',
    success: function(response) {
        console.log(response);

        // Prepare data for Highcharts
        var data = [];
        for (var sport in response) {
            if (response.hasOwnProperty(sport)) {
                data.push({
                    name: sport,
                    y: response[sport]
                });
            }
        }

        // Initialize Highcharts chart
        var chart = Highcharts.chart('accReportContainer', {
            chart: {
                type: 'column'
            },
            title: {
                text: 'Selected Sports Count'
            },
            xAxis: {
                type: 'category',
                labels: {
                    rotation: -45,
                    style: {
                        fontSize: '13px',
                        fontFamily: 'Verdana, sans-serif'
                    }
                }
            },
            yAxis: {
                title: {
                    text: 'Count'
                }
            },
            legend: {
                enabled: false
            },
            plotOptions: {
                series: {
                    borderWidth: 0,
                    dataLabels: {
                        enabled: true,
                        format: '{point.y}'
                    }
                }
            },
            series: [{
                name: 'Sports',
                colorByPoint: true,
                data: data
            }],
            credits: {
                enabled: false
            }
        });
    }
});
/*$.ajax({
    url: '/users/gender/count',
    type: "GET",
    dataType: 'json',
    contentType: 'application/json',
    success: function(response) {
        console.log(response);

        // Prepare data for Highcharts
        var data = [
            { name: 'Male', y: response.male },
            { name: 'Female', y: response.female }
        ];

        // Initialize Highcharts chart
        var chart = Highcharts.chart('mCcontainer', {
            chart: {
                type: 'pie'
            },
            title: {
                text: 'Gender Distribution'
            },
            tooltip: {
                pointFormat: '{series.name}: <b>{point.y}</b>'
            },
            plotOptions: {
                pie: {
                    allowPointSelect: true,
                    cursor: 'pointer',
                    dataLabels: {
                        enabled: true,
                        format: '<b>{point.name}</b>: {point.percentage:.1f} %'
                    }
                }
            },
            series: [{
                name: 'Count',
                colorByPoint: true,
                data: data
            }],
            credits: {
                enabled: false
            }
        });
    }
});

*/

});

