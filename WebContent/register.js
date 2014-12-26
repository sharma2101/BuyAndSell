$(function()
{
	
	$("#register").submit(function(event)
	{
			
				event.preventDefault();
			

		 
				    var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
				   var no = /^\d{10}$/;
				
				if($('#last_name').val().length>0 && $('#last_name').val().length<30 )
					{
						if($('#first_name').val().length>0 && $('#first_name').val().length<30)
							{
							if($('#userID').val().length>0 && $('#userID').val().length<15)
							{
								if($('#password').val().length>0 && $('#password').val().length<15)
								{
									if(re.test($('#email').val()))
									{
										if(no.test($('#phoneNum').val()))
										{
											$.ajax	({
												
												
												type: 'GET',
												url: "http://localhost:8080/M2_S2-GA/rs/user/userIDAvailability/"+$("#userID").val(),
												dataType: 'text'
									
												}).done(function(response) {

													console.log("done before if");
													if(response == 'yes')
														{
														register();
														
														}
													else
													{
														$("#registerResult").append("The userID is already taken. Please select a new one");
														
													}
													

												}).fail(function(jqXHR, status, message){

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
								alert("UserId should be from 1-15 characters");
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

function register()
{
	$.ajax
	({
		type: 'POST',
		contentType: 'application/json',
		url: "http://localhost:8080/M2_S2-GA/rs/user/register",
		data: 	formToJSON()			
	}).done(function(response) {

			$("#registerResult").empty();
			$("#registerResult").append("Successfully registered");

		}).fail(function(jqXHR, status, message){

			window.location.assign("error.jsp");

		});

}

// Helper function to serialize all the form fields into a JSON string
function formToJSON() 
{
	
	
    return JSON.stringify(
    		{
    			"user":	{
    				"lastName": $('#last_name').val(),
    				"firstName": $('#first_name').val(),
    				"userID": $('#userID').val(),
    				"password": $('#password').val(),
    				"emailID": $('#email').val(),
    				"phoneNumber": $('#phoneNum').val(),
    					}

    		});
}
