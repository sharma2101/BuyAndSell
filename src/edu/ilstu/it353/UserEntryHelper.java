package edu.ilstu.it353;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class UserEntryHelper
{
	
	boolean merged = false;
	String last_name = null;
	String first_name = null;
	String userID = null;
	String password = null;
	String email = null;
	String phoneNum = null;
	private static Connection conn = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	
public UserEntryHelper()
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
	
public UserList  getAllUsers() throws SQLException
{
	UserList userList = new UserList();


	try
	{
		
		
		statement = conn.createStatement();
						
		resultSet = statement.executeQuery("SELECT * FROM catalogue.userdata"); 

		

		while(resultSet.next()) 
		{
			String lastName= resultSet.getString("last_name"); 
			String firstName= resultSet.getString("first_name");
			String userID= resultSet.getString("userID");
			String password= resultSet.getString("password");
			String email= resultSet.getString("email");
			String phoneNum= resultSet.getString("phoneNum");
			
			
			User user = new User();
			
			user.setEmailID(email);
			user.setLastName(lastName);
			user.setFirstName(firstName);
			user.setPassword(password);
			user.setUserID(userID);
			user.setPhoneNumber(phoneNum);
			
			userList.add(user);
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
	

	return userList;
}

public boolean  getUserIDAvailability(String userID) throws SQLException
{
	boolean available = true;


	try
	{
		String querySQL = "SELECT * FROM catalogue.userdata WHERE userID=?";
		
		preparedStatement =conn.prepareStatement(querySQL);
		
		preparedStatement.setString(1, userID);
		
		resultSet = preparedStatement.executeQuery();
		
		
		
		System.out.println("in try before while");
		System.out.println(resultSet);

		
		if(resultSet.next()) 
		{
			available = false;
			System.out.println("in while");
			System.out.println(resultSet.getString(2));
		}
			
		System.out.println(available);
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
	

	return available;
}

public boolean insertUser(User user) throws Exception
	{
	

		
		last_name = user.getLastName();
		first_name = user.getFirstName() ;
		userID =  user.getUserID();
		password = user.getPassword();
		email = user.getEmailID() ;
		phoneNum = user.getPhoneNumber();
		
		int affectedRows = 0;
		
		try
		{
			String querySQL = "insert into UserData values(?, ?, ?,?,?,?)";
			
			preparedStatement =conn.prepareStatement(querySQL);
			
			preparedStatement.setString(1, last_name);
			preparedStatement.setString(2, first_name);
			preparedStatement.setString(3, userID);
			preparedStatement.setString(4, password);
			preparedStatement.setString(5, email);
			preparedStatement.setString(6, phoneNum);
			
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

public boolean updateUser(User user) throws Exception
{


	
	last_name = user.getLastName();
	first_name = user.getFirstName() ;
	userID =  user.getUserID();
	password = user.getPassword();
	email = user.getEmailID() ;
	phoneNum = user.getPhoneNumber();
	
	int affectedRows = 0;
	

	
	try
	{
		
		
		String querySQL = "UPDATE UserData SET last_name=?, first_name=?, password=?, email=?, phoneNum=? WHERE userID=?";
		
		preparedStatement =conn.prepareStatement(querySQL);
		
		preparedStatement.setString(1, last_name);
		preparedStatement.setString(2, first_name);
		preparedStatement.setString(3, password);
		preparedStatement.setString(4, email);
		preparedStatement.setString(5, phoneNum);
		preparedStatement.setString(6, userID);
		
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



public User  matchPassword(String userID, String password) throws SQLException
{
	
	User user = new User();

	try
	{
		String querySQL = "SELECT * FROM catalogue.userdata WHERE userID=? AND password=?";
		
		preparedStatement =conn.prepareStatement(querySQL);
		
		preparedStatement.setString(1, userID);
		preparedStatement.setString(2, password);
		resultSet = preparedStatement.executeQuery();
		
		
		

		
		while(resultSet.next()) 
		{
			String lastName= resultSet.getString("last_name"); 
			String firstName= resultSet.getString("first_name");
			
			String email= resultSet.getString("email");
			String phoneNum= resultSet.getString("phoneNum");
			
			
		
			
			user.setEmailID(email);
			user.setLastName(lastName);
			user.setFirstName(firstName);
			user.setPassword(password);
			user.setUserID(userID);
			user.setPhoneNumber(phoneNum);
			
			
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
	

	return user;
}

}
