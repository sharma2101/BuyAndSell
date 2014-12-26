package edu.ilstu.it353;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.PathParam;



@Path("user/")
public class UserResource 

{
	
	@GET
	@Path("getAll")
	@Produces("application/json; charset=UTF-8")
	public Response getUserInfo() throws SQLException
	{
		

		ResponseBuilder responseBuilder = null;
		
		UserEntryHelper helper = new UserEntryHelper();
		
		UserList userList = new UserList();
		userList = helper.getAllUsers(); 
		if(userList == null)
		{
			responseBuilder = Response.status(Status.NO_CONTENT);
		}
		else
		{
			responseBuilder = Response.status(Status.OK);
			responseBuilder.entity(userList);
		}

		Response response = responseBuilder.build();

		return response;
	}
	
	@GET
	@Path("userIDAvailability/{userID}")
	@Produces("text/plain")
	public Response getUserIDAvailability(@PathParam("userID") String userID) throws SQLException
	{
		

		ResponseBuilder responseBuilder = null;
		
		UserEntryHelper helper = new UserEntryHelper();
		String availibility = null;
		
		
		boolean available = helper.getUserIDAvailability(userID); 
		if(available)
		{
			responseBuilder = Response.status(Status.CREATED);
			availibility = "yes";
			
			
		}
		else
		{
			responseBuilder = Response.status(Status.CREATED);
			availibility = "no";
		}

		responseBuilder.entity(availibility);
		Response response = responseBuilder.build();

		return response;
	}
	
	@POST
	@Path("register")						
	@Consumes("application/json")
	public Response createEntry(User user) throws Exception
	{
		

		
		boolean merged = false;
		UserEntryHelper helper = new UserEntryHelper();

		if(user != null)
		{
			synchronized(this)
			{
				merged = helper.insertUser(user);
		
			}

		}


		ResponseBuilder responseBuilder = null;

		if(merged)
		{
			responseBuilder = Response.status(Status.CREATED);
		}
		else
		{
			responseBuilder = Response.status(Status.NO_CONTENT);
		}

		Response response = responseBuilder.build();

		return response;
	}
		
	@PUT
	@Path("update")
	@Consumes("application/json")
	@Produces("application/json; charset=UTF-8")
	public Response updateEntry(User user) throws Exception
	{
		

		
		boolean merged = false;
		UserEntryHelper helper = new UserEntryHelper();

		if(user != null)
		{
			synchronized(this)
			{
				merged = helper.updateUser(user);
		
			}

		}


		ResponseBuilder responseBuilder = null;

		if(merged)
		{
			responseBuilder = Response.status(Status.CREATED);
		}
		else
		{
			responseBuilder = Response.status(Status.NO_CONTENT);
		}

		Response response = responseBuilder.build();

		return response;
	}
}
