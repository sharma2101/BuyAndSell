package edu.ilstu.it353;


import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class ItemList extends ArrayList<Item>
{
	private static final long serialVersionUID = 1;

	@XmlElement(name="items")
	public ArrayList<Item> getItems()
	{
		return this;
	}
}
