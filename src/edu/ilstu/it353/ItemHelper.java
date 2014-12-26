package edu.ilstu.it353;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ItemHelper 

{
	boolean merged = false;
	
	int itemID = 0;
	String itemName = null;
	String description = null;
	double price = 0;
	String userID = null;
	String category = null;
	String img_path = null;

	private static Connection conn = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	
	
	public ItemHelper()
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

	public ItemList getAllItems() throws SQLException
	{
		
	ItemList itemList = new ItemList();


	try
	{
		
		
		statement = conn.createStatement();
						
		resultSet = statement.executeQuery("SELECT * FROM catalogue.item");  // Change table name

		

		while(resultSet.next()) 
		{
			int itemID = resultSet.getInt("itemID");
			String itemName= resultSet.getString("itemName"); 
			String description= resultSet.getString("description");
			double price= resultSet.getDouble("price");
			String userID = resultSet.getString("userID");
			String category = resultSet.getString("category");
			String img_path = resultSet.getString("img_path");
			
			
			
			Item item = new Item();
			
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
	finally 
	{
		

		if(statement != null)
		{
			statement.close();
		}

		if(conn != null)
		{
			conn.close();
		}
	}
	

	return itemList;
}

	
	public ItemList getAllItemsByCategory(String category) throws SQLException
	{
		
	ItemList itemList = new ItemList();
	

	try
	{

		String querySQL = "SELECT * FROM catalogue.item WHERE category=?";
		
		preparedStatement =conn.prepareStatement(querySQL);
		
		preparedStatement.setString(1, category);

		resultSet = preparedStatement.executeQuery(); 
		
		while(resultSet.next()) 
		{
			int itemID = resultSet.getInt("itemID");
			String itemName= resultSet.getString("itemName"); 
			String description= resultSet.getString("description");
			double price= resultSet.getDouble("price");
			String userID = resultSet.getString("userID");
			String img_path = resultSet.getString("img_path");
			
			
			
			Item item = new Item();
			
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
	finally 
	{
		

		if(statement != null)
		{
			statement.close();
		}

		if(conn != null)
		{
			conn.close();
		}
	}
	

	return itemList;
}
	public ItemList getItemByUser(String userID) throws SQLException
	{
		
	ItemList itemList = new ItemList();
	

	try
	{

		String querySQL = "SELECT * FROM catalogue.item WHERE userID=?";
		
		preparedStatement =conn.prepareStatement(querySQL);
		
		preparedStatement.setString(1, userID);

		resultSet = preparedStatement.executeQuery(); 
		
		while(resultSet.next()) 
		{
			int itemID = resultSet.getInt("itemID");
			String itemName= resultSet.getString("itemName"); 
			String description= resultSet.getString("description");
			double price= resultSet.getDouble("price");
			String category = resultSet.getString("category");
			String img_path = resultSet.getString("img_path");
			
			
			
			Item item = new Item();
			
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
	finally 
	{
		

		if(statement != null)
		{
			statement.close();
		}

		if(conn != null)
		{
			conn.close();
		}
	}
	

	return itemList;
}
	public boolean insertItem(Item item) throws Exception
	{
	
			price = item.getPrice();
			itemName = item.getItemName();
			description = item.getDescription();
			category = item.getCategory();
			userID = item.getUserID();
			img_path = item.getImg_path();
		

		
		int affectedRows = 0;
		
		try
		{
			String querySQL = "insert into item values(default,?, ?, ?,?,?,?)";
			
			preparedStatement =conn.prepareStatement(querySQL);
			
			preparedStatement.setString(1, itemName);
			preparedStatement.setString(2, description);
			preparedStatement.setDouble(3, price);
			preparedStatement.setString(4, category);
			preparedStatement.setString(5, userID);
			preparedStatement.setString(6, img_path);
			
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
	
	public boolean deleteItem(int itemID) throws Exception
	{
		    boolean deleted = false;
	
		    CartHelper helper = new CartHelper();
		    helper.deleteItemFromCart(itemID);
		
		int affectedRows = 0;
		
		try
		{
			String querySQL = "delete from catalogue.item where itemID=?";
			
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

