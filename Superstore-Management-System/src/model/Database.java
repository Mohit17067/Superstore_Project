package model;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

/**
 * The {@code Database} class houses all the data for the superstore.
 */
public class Database implements Serializable{

	/** Generated serial version ID */
	private static final long serialVersionUID = 1844598343845993056L;

	/** One and only one superuser for the superstore */
	private SuperUser SUser;
	
	/** Enduser */
	private EndUser endUser;
	
	/** List of all the warehouses present in the superstore. */
	private LinkedList<Warehouse> warehouses;

	/** List of all the stores present in the superstore. */
	private LinkedList<Store> stores;

	/** List of all the warehouse admins present in the superstore. */
	private LinkedList<Admin> WarehouseAdmins;

	/** List of all the store admins present in the superstore. */
	private LinkedList<Admin> StoreAdmins;
	
	/**
	 * Constructor
	 */
	public Database() {
		this.SUser = new SuperUser(this, "SUser", "SUser", "SUser");
		warehouses = new LinkedList<Warehouse>();
		stores = new LinkedList<Store>();
		WarehouseAdmins = new LinkedList<Admin>();
		StoreAdmins = new LinkedList<Admin>();
	}
		
	

	/**
	 * Adds provided store to the list of all stores.
	 * 
	 * @param store
	 */
	public void add_store(Store store) {
		stores.add(store);
		StoreAdmins.add(store.getAdmin());
	}
	
	/**
	 * Adds provided warehouse to the list of all warehouses.
	 * 
	 * @param warehouse
	 */
	public void add_warehouse(Warehouse warehouse) {
		warehouses.add(warehouse);
		WarehouseAdmins.add(warehouse.getAdmin());
	}
	
	/**
	 * Iterates through the stores list and returns the store with
	 * the provided ID.
	 * 
	 * @param S_ID
	 * @return
	 */
	public Store getStore(String S_ID) {
		//TODO implement here
		return null;
	}
	
	/**
	 * Iterates through the warehouses and returns the warehouse
	 * with the provided ID.
	 * 
	 * @param W_ID
	 * @return
	 */
	public Warehouse getWarehouse(String W_ID) {
		//TODO implement here
		return null;
	}
	
	/**
	 * Returns the list of all stores.
	 * 
	 * @return
	 */
	public LinkedList<Store> getStores() {
		return this.stores;
	}
	
	/**
	 * Returns the list of all warehouses.
	 * 
	 * @return
	 */
	public LinkedList<Warehouse> getWarehouses() {
		return this.warehouses;
	}
	
	/**
	 * Returns reference to the superuser.
	 * 
	 * @return
	 */
	public SuperUser getSuperUser() {
		return this.SUser;
	}
	
	/**
	 * Returns the list of all store administrators.
	 * 
	 * @return
	 */
	public LinkedList<Admin> getStoreAdmins() {
		return this.StoreAdmins;
	}
	
	/**
	 * Returns the list of all warehouse administrators.
	 * @return
	 */
	public LinkedList<Admin> getWarehouseAdmins() {
		return this.WarehouseAdmins;
	}
	
	/**
	 * Returns the enduser.
	 * 
	 * @return
	 */
	public EndUser getEndUser() {
		this.endUser = new EndUser();
		return this.endUser;
	}
	
}