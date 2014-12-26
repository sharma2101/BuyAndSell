package edu.ilstu.it353;

import java.text.NumberFormat;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Item

{
	
	private int itemID;
	private String itemName;
	private String description;
	private double price;
	private String category;
	private String userID;
	private String img_path;

	@XmlElement
	public double getPrice()
	{
		return price;
	}

	public void setPrice(double price)
	{
		this.price = price;
	}

	@XmlElement
	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	@XmlElement
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@XmlElement
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	

	@XmlElement
	public String getUserID() {
		return userID;
	}



	public void setUserID(String userID) {
		this.userID = userID;
	}


	@XmlElement
	public String getImg_path() {
		return img_path;
	}



	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}

	@XmlElement
	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}



}
