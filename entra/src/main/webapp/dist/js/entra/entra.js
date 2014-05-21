$(document).on('click', '.btn-sms', function() {
	var couponId = $(this).data('id');
	// alert(couponId);
});

$('#loginBtn').click(function() {
	var client = new $.RestClient('/entra/');
	client.add('auth', {
		url : '${postLoginUrl}',
		stripTrailingSlash : true
	});
	var userName = $('#userName').val();
	var password = $('#userPassword').val();
	client.auth.create({
		j_username : userName,
		j_password : password
	}).done(successHandler).error(failureHandler);

	function successHandler(xhr, result, statusText) {
		alert('success');
	}

	function failureHandler(xhr, result, statusText) {
		alert('bad');
	}
});// end of click event
