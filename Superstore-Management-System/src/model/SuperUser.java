package model;

import java.io.Serializable;

/**
 * 
 */
public class SuperUser implements Serializable{

	/** Generated serial version ID */
	private static final long serialVersionUID = 6404178839321868426L;

	/** reference to the main database */
	private Database db;

	/** name of the superuser */
	private String Name;
	
	/** unique id of the superuser */
	private String ID;
	
	/** password of the superuser */
	private String pswd;
	
	/**
	 * constructor
	 * @param db
	 * @param Name
	 * @param ID
	 * @param pswd
	 */
	public SuperUser(Database db, String Name, String ID, String pswd) {
		this.db = db;
		this.Name = Name;
		this.ID = ID;
		this.pswd = pswd;
	}

	/**
	 * @return the name of the superuser
	 */
	public String getName() {
		return Name;
	}

	/**
	 * @return the id of the superuser
	 */
	public String getID() {
		return ID;
	}

	/**
	 * @return the password of the superuser
	 */
	public String getPswd() {
		return pswd;
	}

	/**
	 * @return the reference to the database
	 */
	public Database getDatabase() {
		return this.db;
	}
	
	/**
	 * method to create warehouse
	 * 
	 * @param room_Name
	 * @param room_ID
	 * @param admin_name
	 * @param admin_ID
	 * @param admin_pswd
	 */
	public void createWarehouse(String room_Name, String room_ID, String admin_name, String admin_ID, String admin_pswd) {
		// TODO implement here
		Warehouse new_warehouse = new Warehouse(room_Name, room_ID, admin_name, admin_ID, admin_pswd, this.getDatabase());
		db.add_warehouse(new_warehouse);
	}

	/**
	 * method to create store
	 * 
	 * @param room_Name
	 * @param room_ID
	 * @param admin_name
	 * @param admin_ID
	 * @param admin_pswd
	 */
	public void createStore(String room_Name, String room_ID, String admin_name, String admin_ID, String admin_pswd) {
		// check ID already created , throw exception.
		Store new_store = new Store(room_Name, room_ID, admin_name, admin_ID, admin_pswd);
		db.add_store(new_store);
	}

	/**
	 * Adds store reference to warehouse and warehouse reference to store.
	 * 
	 * @param warehouse
	 * @param store
	 */
	public void updateLink(Warehouse warehouse, Store store) {
		store.linkWarehouse(warehouse);
		warehouse.linkStore(store);
	}

	/**
	 * Creates new warehouse administrator.
	 * 
	 * @param username 
	 * @param password 
	 * @param warehouse
	 */
	public void createWarehouseAdmin(String username, String password, Warehouse warehouse) {
		// TODO implement here
	}

	/**
	 * Creates new store administrator.
	 * 
	 * @param username 
	 * @param password 
	 * @param store
	 */
	public void createStoreAdmin(String username, String password, Store store) {
		// TODO implement here
	}

}