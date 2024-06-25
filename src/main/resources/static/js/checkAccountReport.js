$(document).ready(function () {
    $('#idRegisteredDate, #idBranchName').change(function () {
    	$('p').empty();
        $.post('/dailyreportcheck',   // url
            {
                branchName: $("#idBranchName").val(),
                registeredDate: $("#idRegisteredDate").val()
            }, // data to be submit

            function (result, status, jqXHR) {// success callback
                if (result.status) {
                    $('p').html("<p style='background-color:#B74635; color:white; padding:20px 20px 20px 20px'>" +
                        "Given data already exists!!! <br>" 
                    	+ "Branch: " + result.data[0].branchName +"<br> Date: "+moment(new Date(result.data[0].registeredDate)).format("YYYY-MM-DD") 
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