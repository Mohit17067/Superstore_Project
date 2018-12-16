package model;

import java.io.Serializable;
import java.util.*;

/**
 * The {@code Cart} class is for representing each EndUser's
 * shopping cart. Each EndUser has one cart for each {@code Store}.
 */
public class Cart implements Serializable{
	
	/** Generated serial version ID */
	private static final long serialVersionUID = -1151928213757975566L;

	/** Collection of all the products in the cart */
	private LinkedList<Product> products;
	
	/** Collection for quantities corresponding to each product in the cart. */
	private LinkedList<Integer> units;
	
	/** Collection for prices corresponding to each product in the cart.*/
	private LinkedList<Integer> prices;
	


	/**
	 * Constructor
	 */
	public Cart() {
		this.products = new LinkedList<Product>();
		this.units = new LinkedList<Integer>();
		this.prices = new LinkedList<Integer>();
	}
	
	/**
	 * Adds a product to cart.
	 * 
	 * @param product
	 * @param Units
	 */
	public void add(Product product, int Units) {
		this.products.add(product);
		this.units.add(Units);
		this.prices.add(product.getPrice());
	}

	/**
	 * Returns the collection of all products in the cart.
	 * 
	 * @return
	 */
	public LinkedList<Product> getProducts() {
		return products;
	}

	/**
	 * Returns the collection of all quantities in the cart.
	 * 
	 * @return
	 */
	public LinkedList<Integer> getUnits() {
		return units;
	}

	/**
	 * Returns the prices of all quantities in the cart.
	 * 
	 * @return
	 */
	public LinkedList<Integer> getPrices() {
		return prices;
	}

	/**
	 * Removes a product from the {@code products} linkedlist.
	 * 
	 * @param product
	 */
	public void removeProduct(Product product) {
		products.remove(product);
	}
	
	/**
	 * Removes a price from the {@code prices} linkedlist
	 * 
	 * @param ind
	 */
	public void removePrice(int ind) {
		prices.remove(ind);
	}
	
	/**
	 * Removes a quantity from the {@code quantity} linkedlist
	 * 
	 * @param ind
	 */
	public void removeUnit(int ind) {
		units.remove(ind);
	}
	
	/**
	 * This method is used when the EndUser wants to buy all the
	 * products in the cart.
	 */
	public void checkOut() {
		for (int i=0; i<products.size(); i++) {
			Product product = products.get(i);
			product.reduceUnits(this.units.get(i));
		}
	}

}