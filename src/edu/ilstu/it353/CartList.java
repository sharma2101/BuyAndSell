package edu.ilstu.it353;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class CartList extends ArrayList<Cart>
{
	private static final long serialVersionUID = 1;

	@XmlElement(name="cart")
	public ArrayList<Cart> getCart()
	{
		return this;
	}
}