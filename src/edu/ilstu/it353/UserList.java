package edu.ilstu.it353;



import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserList extends ArrayList<User> 
{
	private static final long serialVersionUID = 1;
	
	@XmlElement(name="users")
	public ArrayList<User> getUsers()
	{
		return this;
	}
}

