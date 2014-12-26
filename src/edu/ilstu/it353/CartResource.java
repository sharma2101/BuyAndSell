package edu.ilstu.it353;

import java.sql.SQLException;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;





@Path("cart/")
public class CartResource 
{

	@GET
	@Path("getCart/{userID}")
	@Produces("application/json; charset=UTF-8")
	public Response getItemByUser(@PathParam("userID") String userID) throws SQLException
	{
		

		ResponseBuilder responseBuilder = null;
		
		CartHelper cartHelper = new CartHelper();
			
		ItemList itemList = new ItemList();
		
		itemList  = cartHelper.getCartItems(userID); 
		
		if(itemList == null)
		{
			responseBuilder = Response.status(Status.NO_CONTENT);
		}
		else
		{
			responseBuilder = Response.status(Status.OK);
			responseBuilder.entity(itemList);
		}

		Response response = responseBuilder.build();

		return response;
	}
	
	@DELETE
	@Path("emptyCart/{userID}")
	public Response emptyCart(@PathParam("userID") String userID) throws Exception
	{
		CartHelper helper = new CartHelper();
		
		boolean deleted = helper.deleteItem(userID);

		ResponseBuilder responseBuilder = null;

		if(deleted)
		{
			responseBuilder = Response.status(Status.OK);
		}
		else
		{
			responseBuilder = Response.status(Status.NO_CONTENT);
		}

		Response response = responseBuilder.build();

		return response;
	}
	
	@DELETE
	@Path("deleteItem/{itemID}")
	public Response deleteEntry(@PathParam("itemID") int itemID) throws Exception
	{
		CartHelper helper = new CartHelper();
		
		boolean deleted = helper.deleteItemFromCart(itemID);

		ResponseBuilder responseBuilder = null;

		if(deleted)
		{
			responseBuilder = Response.status(Status.OK);
		}
		else
		{
			responseBuilder = Response.status(Status.NO_CONTENT);
		}

		Response response = responseBuilder.build();

		return response;
	}
	
}
