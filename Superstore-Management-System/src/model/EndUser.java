package model;

import java.io.Serializable;
import java.util.*;

/**
 * The {@code EndUser} class represents the customers of a store.
 */
public class EndUser implements Serializable{
	
	/** Generated serial version ID */
	private static final long serialVersionUID = 7033958869979060232L;

	/** The name of the enduser. */
	private String Name;
	
	/** The password of the enduser. */
	private String Password;
	
	/** The cart of the enduser. */
	private Cart cart;
	
	

	/**
	 * Constructor
	 */
	public EndUser() {
		this.Name = "EndUser";
		this.Password = "Password";
		this.cart = new Cart();
		
	}
	
	/**
	 * Returns the cart of the enduser.
	 * @return
	 */
	public Cart getCart() {
		return this.cart;
	}
	
	/**
	 * Calls the checkout method in cart.
	 */
	public void checkOut() {
		this.cart.checkOut();
		this.cart = new Cart();
	}

	/**
	 * Adds the provided product to the cart along with the desired quantity.
	 * 
	 * @param product
	 * @param Units
	 */
	public void addToCart(Product product, int Units) {
		// TODO implement here
		this.cart.add(product, Units);
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public Collection<Product> showCart() {
		// TODO implement here
		return null;
	}


}