$(document).ready(function() {

	$('#btnUploadFile').attr("disabled", true);
	$("#customFile").change(function() {
		var fileName = $(this).val().replace(/C:\\fakepath\\/i, '');

		var ext = fileName.split('.').pop().toLowerCase();

		if ($.inArray(ext, ['pdf','png','jpg','jpeg', 'doc', 'docx', 'txt', 'xls', 'xlsx']) != -1) {
			$("#customFileHolder").val(fileName);
			$('#btnUploadFile').removeAttr("disabled");
		}
	});

	if ($('#divUploadSuccess').is(':visible')) {
		$('#divUploadSuccess').show(0).delay(10000).hide(0);
	}

	listUploadedFiles();
	
});

function listUploadedFiles() {
	$.ajax({
		url : $('#urlFileList').val(),
		error : function() {
			$('#fileList').html('<p>An error has occurred</p>');
		},
		success : function(data) {
			$('#fileList').html(data);
		},
		type : 'GET'
	});
}