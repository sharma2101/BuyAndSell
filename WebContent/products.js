$(function() {

	$(window).load(function() {
		
		$("#allItems").empty();
		

		$
				.ajax(
						{

							type : 'GET',
							url : "http://localhost:8080/M2_S2-GA/rs/item/getItems",
									
							dataType : 'JSON'

						})
				.done(
						function(response)

						{

							var items = response.itemList;

							for ( var i = 0; i < items.length; i++) {

								var item = items[i].item;
								var description = item.description;
								var img_path = item.img_path;
								var itemID =item.itemID;
								var itemName = item.itemName;
								var price = item.price;
								var userID = item.userID;
								var divID = "item" + i;
								$("#allItems").append("<div id=\"" + divID+ "\" class=\"items\"><h3>"+ itemName+ "</h3>");
								$("#" + divID).append("<img src=\""+ img_path+ "\" width=\"150\" height=\"130\" class=\"product\">");
								$("#" + divID).append("<span class=\"text\"><br>"+"Description: "+description + "<br>"+ "Price: "+price+ "<br>By: "+ userID);
								
								$("#" + divID).append("<form action=\"CartServlet\" method=\"POST\" class=\"allForm\"><input type=\"submit\" value=\"Add to cart\" ><input type=\"hidden\" value=\""+itemID+"\" name=\"itemID\"></span>");
								$("#allItems").append("<br><br><br><br><br>");
							
								

							}

						}).fail(
						function(jqXHR, status, message) {

							window.location.assign("error.jsp");

						});
		});
	$("li").click(function() {

						$("#allItems").empty();
						var value = $(this).attr('data-value');

						$
								.ajax(
										{

											type : 'GET',
											url : "http://localhost:8080/M2_S2-GA/rs/item/getItems/"+ value,
											dataType : 'JSON'

										})
								.done(
										function(response)

										{

											var items = response.itemList;

											for ( var i = 0; i < items.length; i++) {

												var item = items[i].item;
												var description = item.description;
												var img_path = item.img_path;
												var itemID =item.itemID;
												var itemName = item.itemName;
												var price = item.price;
												var userID = item.userID;
												var divID = "item" + i;
												$("#allItems").append("<div id=\"" + divID+ "\" class=\"items\"><h3>"+ itemName+ "</h3>");
												$("#" + divID).append("<img src=\""	+ img_path+ "\" width=\"150\" height=\"130\" class=\"product\">");
												$("#" + divID).append("<span class=\"text\"><br>"+"Description: "+description + "<br>"+ "Price: "+price+ "<br>By: "+ userID);
												
												$("#" + divID).append("<form action=\"CartServlet\" method=\"POST\" class=\"allForm\"><input type=\"submit\" value=\"Add to cart\" ><input type=\"hidden\" value=\""+itemID+"\" name=\"itemID\"></span>");
												$("#allItems").append("<br><br><br><br><br>");
												

											}

										}).fail(
										function(jqXHR, status, message) {

											window.location.assign("error.jsp");

										});

					});
});
