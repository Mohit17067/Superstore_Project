package model;

import java.io.Serializable;
import java.util.*;

/**
 * This {@code StoreAdministrator} class is used to represent the
 * administrators who are in charge of the stores of the superstore.
 */
public class StoreAdministrator extends Admin implements Serializable{

	/** Generated serial version ID */
	private static final long serialVersionUID = 1603250062236453741L;


	/**
	 * Default constructor
	 */
	public StoreAdministrator(String name, String ID, String pswd, room myRoom) {
		super(name, ID, pswd, myRoom);
	}

	/**
	 * The store to which the store administrator is assigned.
	 */
	private Store myStore;

}