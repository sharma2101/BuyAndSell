$(function()
{
	
	$("#inserItem").submit(function(event)
	{
			
		
			

				if($('#itemName').val()!=null||($('#description').val()) == "")
				{
				
					if(($('#description').val())!=null||($('#description').val()) != "")
					{
					
						if(($('#price').val())!=null||($('#price').val()) != "")
						{
							if(($('#fileInput').val())!=null||($('#fileInput').val()) != "")
							{
								 $.ajax({
							            type: form.attr("method"), // use method specified in form attributes
							            url: form.attr("action"), // use action specified in form attributes
							            data: form.serialize(), // encodes set of form elements as string for submission
							           
							        });
								
							}
							
							else{
								alert("Please upload an image for your product");
							}
							
						}
						
						else{
							alert("Please enter a price");
						}
					}
					
					else{
						alert("Please enter a description");
					}
				}
				
				else{
					alert("Please enter an item name");
				}
				
				event.preventDefault();	
				
			

	
 
  

	});
});
