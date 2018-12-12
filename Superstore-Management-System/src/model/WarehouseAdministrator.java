package model;

import java.io.Serializable;
import java.util.*;

/**
 * This {@code WarehouseAdministrator} class is used to represent the
 * administrators who are in charge of the warehouses of the superstore.
 */
public class WarehouseAdministrator extends Admin implements Serializable{

	/** Generated serial version ID */
	private static final long serialVersionUID = 3697727863991709580L;

	/**
	 * Constructor
	 * 
	 * @param name
	 * @param ID
	 * @param pswd
	 * @param myRoom
	 */
	public WarehouseAdministrator(String name, String ID, String pswd, room myRoom) {
		super(name, ID, pswd, myRoom);
	}

	/**
	 * reference to the warehouse assigned to this warehouse administrator
	 */
	private Warehouse myWarehouse;


	/**
	 * @return
	 */
	public String alert_message() {
		// TODO implement here
		return "";
	}

	/**
	 * 
	 */
	public void checkInventoryLevels() {
		// TODO implement here
	}

	/**
	 * 
	 */
	public void orderInventory() {
		// TODO implement here
	}

}