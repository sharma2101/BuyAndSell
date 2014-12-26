$(function() {

	$(window).load(function() {
		
		$("#myProducts").empty();
		console.log("http://localhost:8080/M2_S2-GA/rs/item/getItemsByUser/"+$("#userID").val());

		$
		.ajax(
				{

					type : 'GET',
					url : "http://localhost:8080/M2_S2-GA/rs/item/getItemsByUser/"+$("#userID").val() ,

					dataType : 'JSON'

				})
				.done(
						function(response)

						{

							var items = response.itemList;

							for ( var i = 0; i < items.length; i++) {

								var item = items[i].item;
								var category =item.category;
								var description = item.description;
								var img_path = item.img_path;
								var itemID =item.itemID;
								var itemName = item.itemName;
								var price = item.price;
								var userID = item.userID;


								var divID = "item" + i;
								$("#myProducts").append("<div id=\"" + divID+ "\" class=\"items\"><h3>"+ itemName+ "</h3>");
								$("#" + divID).append("<img src=\""+ img_path+ "\" width=\"150\" height=\"130\" class=\"product\">");
								$("#" + divID).append("<span class=\"textProduct\">"+"Description:"+description + "<br>"+ "Price:"+price+ "<br>By:"+ userID + "<br>"+ "Item Id: "+itemID+ "<br>"+"Category: "+category+"<br>");
								$("#" + divID).append("<input type=\"button\" value=\"Delete\" onCLick=\"deleteItem("+itemID+")\"></span>");
								$("#myProducts").append("<br><br><br><br><br>");

							}


						}).fail(
								function(jqXHR, status, message) 
								{

									window.location.assign("error.jsp");

								});
	});



});

function deleteItem(itemID)
{


	$.ajax	({


		type: 'DELETE',
		url: "http://localhost:8080/M2_S2-GA/rs/item/deleteItem/"+itemID,
		dataType: 'text'

	}).done(function(response) {

		alert("Item Deleted");
		window.location.assign("myProducts.jsp");



	}).fail(function(jqXHR, status, message){

		window.location.assign("error.jsp");

	});






}