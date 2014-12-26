var sum=0;
$(window).load(function() {

	$("#myCart").empty();


	$
	.ajax(
			{

				type : 'GET',
				url : "http://localhost:8080/M2_S2-GA/rs/cart/getCart/"+$("#userID").val() ,

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
							sum=sum+price;

							var divID = "item" + i;
							$("#myCart").append("<div id=\"" + divID+ "\" class=\"items\"><h3>"+ itemName+ "</h3>");
							$("#" + divID).append("<img src=\""+ img_path+ "\" width=\"150\" height=\"130\" class=\"product\">");
							$("#" + divID).append("<span class=\"textCart\">"+"Description:"+description + "<br>"+ "Price:"+price+ "<br>"+ "Item ID:"+itemID+ "<br>"+"Category:"+category+"<br>");
							$("#" + divID).append("<input type=\"button\" value=\"Delete\" onCLick=\"deleteItem("+itemID+")\" ><input type=\"hidden\" value=\""+price+"\" id=\"price\"></span>");
							$("#myCart").append("<br><br><br><br><br>");

						}
						$("#checkout").append("Total cost:"+sum);



					}).fail(
							function(jqXHR, status, message) {

								window.location.assign("error.jsp");

							});
});


function checkout()
{
	$.ajax	({


		type: 'DELETE',
		url: "http://localhost:8080/M2_S2-GA/rs/cart/emptyCart/"+$("#userID").val(),
		

	}).done(function(response) {

		window.location.assign("thankyou.jsp");
	


	}).fail(function(jqXHR, status, message){

		window.location.assign("error.jsp");

	});

	
}

function deleteItem(itemID)
{
	console.log("http://localhost:8080/M2_S2-GA/rs/cart/deleteItem/"+itemID);

	$.ajax	({


		type: 'DELETE',
		url: "http://localhost:8080/M2_S2-GA/rs/cart/deleteItem/"+itemID,
		dataType: 'text'

	}).done(function(response) {

	
		var price = $("#price").val();
		sum=sum-price;
		alert("Item Deleted");
		var thisDiv = $("#divID").val();
		$("#checkout").empty();
		$("#checkout").append("Total cost:"+sum);
		window.location.assign("myCart.jsp");


	}).fail(function(jqXHR, status, message){

		window.location.assign("error.jsp");

	});


}
