$(document).ready(function () {
    $('#idMonth, #idMonth, #idFiscalYear').change(function () {
    	$('p').empty();
        $.post('/utilitySubmitTest',   // url
            {
                branchName: $("#idBranchName").val(),
                fiscalYear: $("#idFiscalYear").val(),
                month: $("#idMonth").val()
            }, // data to be submit

            function (result, status, jqXHR) {// success callback
                if (result.status) {
                    $('p').html("<p style='background-color:#B74635; color:white; padding:20px 20px 20px 20px'>" +
                        "Utility Expenses already registered."+"<br> Please insert new utility data!!! <br>" 
                    	+ "Branch: " + result.data[0].branchName + "<br>Fiscal Year: " +
                        result.data[0].fiscalYear + "<br>Month: " + result.data[0].month 
                        + "</p>");
                    $('#submit').hide();
                    return false;
                } else {
                    $('p').html("<strong style='color: #d50c56'>* Make sure to enter all the required fields.</strong>");
                    $('#submit').show();
                    return true;
                }
            });
    });
});