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


@Path("item/")
public class ItemResource 

{	
	@GET
	@Path("getItems")
	@Produces("application/json; charset=UTF-8")
	public Response getItemInfo() throws SQLException
	{
		

		ResponseBuilder responseBuilder = null;
		
		ItemHelper helper = new ItemHelper();
		
		ItemList itemList = new ItemList();
		itemList = helper.getAllItems(); 
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
	
	
	@GET
	@Path("getItems/{category}")
	@Produces("application/json; charset=UTF-8")
	public Response getItemInfoByCategory(@PathParam("category") String category) throws SQLException
	{
		

		ResponseBuilder responseBuilder = null;
		
		ItemHelper helper = new ItemHelper();
		
		ItemList itemList = new ItemList();
		itemList = helper.getAllItemsByCategory(category); 
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
	
	@GET
	@Path("getItemsByUser/{userID}")
	@Produces("application/json; charset=UTF-8")
	public Response getItemByUser(@PathParam("userID") String userID) throws SQLException
	{
		

		ResponseBuilder responseBuilder = null;
		
		ItemHelper helper = new ItemHelper();
		
		ItemList itemList = new ItemList();
		itemList = helper.getItemByUser(userID); 
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
	@Path("deleteItem/{itemID}")
	public Response deleteEntry(@PathParam("itemID") int itemID) throws Exception
	{
		ItemHelper helper = new ItemHelper();
		
		boolean deleted = helper.deleteItem(itemID);

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
