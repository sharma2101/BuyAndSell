package edu.ilstu.it353;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CartHelper
{
	int itemID = 0;
	String itemName = null;
	String description = null;
	double price = 0;
	String userID = null;
	String category = null;
	String img_path = null;

	private static Connection conn = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	private PreparedStatement preparedStatement1 = null;
	private ResultSet resultSet1 = null;
	
	public CartHelper()
{
	try 
	{
		
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/catalogue","root","");
		
		
	} 
	catch (Exception e) 
	
	{
		
		e.printStackTrace();
	}
	
	
}
	public boolean insertItem(String userID, int itemID) throws Exception
	{
	

			boolean merged= false;
		

		
		int affectedRows = 0;
		
		try
		{
			String querySQL = "insert into cart values(default,?, ?)";
			
			preparedStatement =conn.prepareStatement(querySQL);
			
			preparedStatement.setString(1, userID);
			preparedStatement.setInt(2, itemID);

	
			affectedRows = preparedStatement.executeUpdate(); 
		}
		
		finally 
		{
			if(affectedRows != 0)
			{
				merged= true;
			}
	
			if(preparedStatement != null)
			{
				preparedStatement.close();
			}
	
			if(conn != null)
			{
				conn.close();
			}
		}
		
		

		return merged;
	}
	
	public ItemList getCartItems(String userID) throws SQLException
	{
		
	ItemList itemList = new ItemList();
	


	try
	{
		//create return cart object. retrieve that in get in cart helper. in cart helper take out item id , and then call itemhelper metho to get the item details. and add that to response.
		
		String querySQL = "SELECT * FROM catalogue.cart WHERE userID=?";
		
		preparedStatement =conn.prepareStatement(querySQL);
		
		preparedStatement.setString(1, userID);
		resultSet = preparedStatement.executeQuery(); 


		while(resultSet.next()) 
		{
			int itemID = resultSet.getInt("itemID");
			
			String querySQL1 = "SELECT * FROM catalogue.item WHERE itemID=?";
			
			preparedStatement1 =conn.prepareStatement(querySQL1);
			
			preparedStatement1.setInt(1, itemID);
			resultSet1 = preparedStatement1.executeQuery(); 
			Item item = null;
			while(resultSet1.next()) 
				
			{
				
			
				String itemName= resultSet1.getString("itemName"); 
				String description= resultSet1.getString("description");
				double price= resultSet1.getDouble("price");
				
				String category = resultSet1.getString("category");
				String img_path = resultSet1.getString("img_path");
				
				
				
				item = new Item();
				
				item.setItemID(itemID);
				item.setPrice(price);
				item.setItemName(itemName);
				item.setDescription(description);
				item.setCategory(category);
				item.setUserID(userID);
				item.setImg_path(img_path);
				
				itemList.add(item);
				
			}
			
		}
			
		
	}
	finally 
	{
		

		if(preparedStatement != null)
		{
			preparedStatement.close();
		}

		if(preparedStatement1 != null)
		{
			preparedStatement1.close();
		}
		
		if(conn != null)
		{
			conn.close();
		}
		
	}
	

	return itemList;
}
	
	public boolean deleteItem(String userID) throws Exception
	{
		    boolean deleted = false;
	

		
		int affectedRows = 0;
		
		try
		{
			String querySQL = "delete from catalogue.cart where userID=?";
			
			preparedStatement =conn.prepareStatement(querySQL);
			
			preparedStatement.setInt(1, itemID);
			

			affectedRows = preparedStatement.executeUpdate(); 
		}
		
		finally 
		{
			if(affectedRows != 0)
			{
				deleted = true;
			}
	
			if(preparedStatement != null)
			{
				preparedStatement.close();
			}
	
			if(conn != null)
			{
				conn.close();
			}
		}
		
		

		return deleted;
	}
	
	public boolean deleteItemFromCart(int itemID) throws Exception
	{
		    boolean deleted = false;
	

		
		int affectedRows = 0;
		
		try
		{
			String querySQL = "delete from catalogue.cart where itemID=?";
			
			preparedStatement =conn.prepareStatement(querySQL);
			
			preparedStatement.setInt(1, itemID);
			

			affectedRows = preparedStatement.executeUpdate(); 
		}
		
		finally 
		{
			if(affectedRows != 0)
			{
				deleted = true;
			}
	
			if(preparedStatement != null)
			{
				preparedStatement.close();
			}
	
			if(conn != null)
			{
				conn.close();
			}
		}
		
		

		return deleted;
	}


}
