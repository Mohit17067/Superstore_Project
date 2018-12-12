package model;


import java.io.Serializable;
import java.util.*;

/**
 * The (@code Store) class represents the stores that are part of the superstore.
 */
public class Store extends room implements Serializable{

	/** Generated serial version ID */
	private static final long serialVersionUID = -2080380385842714571L;

	/** The warehouse that this store is linked to */
	private Warehouse warehouse;
	
	/**
	 * 
	 */
	private float fixedCost_D;

	
	/**
	 * Default constructor
	 */
	public Store(String room_Name, String room_ID, String admin_name, String admin_ID, String admin_pswd) {
		super(room_Name, room_ID, admin_name, admin_ID, admin_pswd);
	}
	
	/**
	 * Adds the provided warehouse as the linked warehouse for the store.
	 * 
	 * @param warehouse
	 */
	public void linkWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}
	
	/**
	 * @param productName 
	 * @return product if it exists
	 */
	public Product search(String productName) {
		// TODO implement here
		return null;
	}

	@Override
	public String orderProducts(Product product) {
		// TODO Auto-generated method stub
		String response = this.warehouse.orderProducts(product);
		if (response.equals("successful")) {
		product.incUnits();}
		return "successful";
	}

}