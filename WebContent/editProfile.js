$(function() {

	$("#edit").submit(function(event) {
		event.preventDefault();
		

	    var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	   var no = /^\d{10}$/;
	
	if($('#last_name').val().length>0 && $('#last_name').val().length<30 )
		{
			if($('#first_name').val().length>0 && $('#first_name').val().length<30)
				{
				if($('#password').val().length>0 && $('#password').val().length<15)
				{
					if(re.test($('#email').val()))
					{
						if(no.test($('#phoneNum').val()))
						{

							$.ajax({
								type : 'PUT',
								contentType : 'application/json',
								url : "http://localhost:8080/M2_S2-GA/rs/user/update",
								data : formToJSON()
							}).done(function(response) {

								$("#editResult").empty();
								$("#editResult").append("Successfully Updated");

							}).fail(function(jqXHR, status, message) {

								window.location.assign("error.jsp");

							});
						}
						else
						{
						alert("Please enter a 10 digit number");
						}
					}
					else
					{
					alert("Please enter a valid email id");
					}
				}
				else
				{
				alert("Password must be between 1-15 characters");
				}
				}
			else
			{
			alert("First Name should be have 1 - 30 characters");
			}
		}
	else
		{
		alert("Last Name should be have 1 - 30 characters");
		}
	

		

	});

});

function formToJSON() {

	return JSON.stringify({
		"user" : {
			"emailID" : $('#email').val(),
			"firstName" : $('#first_name').val(),
			"lastName" : $('#last_name').val(),
			"password" : $('#password').val(),
			"phoneNumber" : $('#phoneNum').val(),
			"userID" : $('#userID').val()
		}

	});
}







