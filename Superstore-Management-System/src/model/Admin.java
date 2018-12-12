package model;


import java.io.Serializable;
import java.util.*;

/**
 * The {@code Admin} class represents the administrators that
 * are in charge of warehouses and stores.
 */
public class Admin implements Serializable{
	
	/** Generated serial version ID */
	private static final long serialVersionUID = 1557988801683342404L;
	
	/** Username for the admin */
	private String name;
	
	/** Unique ID for each {@code Admin} instance */
	private String ID;
	
	/** password set at the time of object creation */
	private String pswd;
	
	/** Reference to the warehouse or store the admin is in charge of. */
	private room myRoom;
	
	/**
	 * Constructor
	 * 
	 * @param name
	 * @param ID
	 * @param pswd
	 * @param myRoom
	 */
	public Admin(String name, String ID, String pswd, room myRoom) {
		this.name = name;
		this.ID = ID;
		this.pswd = pswd;
		this.myRoom = myRoom;
	}

	/** Returns the name */
	public String getName() {
		return name;
	}

	/** Returns the unique ID */
	public String getID() {
		return ID;
	}

	/** Returns the password */
	public String getPswd() {
		return pswd;
	}

	/** Returns reference to the warehouse or store the admin is in charge of. */
	public room getMyRoom() {
		return myRoom;
	}
	
	/**
	 * Creates and adds a new category using the given name and description
	 * to admin's warehouse or store.
	 * 
	 * @param name
	 * @param Description
	 */
	public void addCategory(String name, String Description) {
		Category new_category = new Category(name, Description, this.myRoom);
		this.myRoom.add_category(new_category);
	};

	/**
	 * Updates provided category's name and description.
	 * 
	 * @param category
	 * @param name
	 * @param Description
	 */
	public void updateCategory(Category category, String name, String Description) {
		this.myRoom.update_category(category, name, Description);
	};

	/**
	 * Deletes the provided category.
	 * 
	 * @param category
	 */
	public void deleteCategory(Category category) {
		this.myRoom.delete_category(category);
	};
	
	/**
	 * Creates new subcategory and passes it to warehouse or store method.
	 * 
	 * @param name
	 * @param Description
	 * @param parent
	 */
	public void addSubCategory(String name, String Description, Category parent) {
		subCategory new_subCategory = new subCategory(name, Description, parent);
		this.myRoom.add_subCategory(parent, new_subCategory);
	}

	/**
	 * Updates provided subcategory's name and description.
	 * 
	 * @param SubCategory
	 * @param name
	 * @param Description
	 */
	public void updateSubCategory(subCategory SubCategory, String name, String Description) {
		this.myRoom.update_subCategory(SubCategory, name, Description);
	}
	
	/**
	 * Deletes the provided subcategory.
	 * 
	 * @param parent
	 * @param SubCategory
	 */
	public void deleteSubCategory(Category parent, subCategory SubCategory) {
		parent.deleteSubCategory(SubCategory);
	}
	
	/**
	 * Creates a new product using the provided parameters and passes it
	 * to warehouse or store's method.
	 * 
	 * @param Name
	 * @param Description
	 * @param Units
	 * @param fixedCost
	 * @param carryingCost
	 * @param Demand
	 * @param price
	 * @param parent
	 */
	public void addProduct(String Name, String Description, int Units, int fixedCost, int carryingCost, int Demand, int price, subCategory parent) {
		Product new_product = new Product(Name, Description, Units, fixedCost, carryingCost, Demand, price, parent);
		this.myRoom.add_product(parent, new_product);
	};


	/**
	 * Updates provided product's arguments.
	 * 
	 * @param product
	 * @param Name
	 * @param Description
	 * @param Units
	 * @param fixedCost
	 * @param carryingCost
	 * @param Demand
	 * @param price
	 */
	public void updateProduct(Product product, String Name, String Description, int Units, int fixedCost, int carryingCost, int Demand, int price) {
		this.myRoom.update_product(product, Name, Description, Units, fixedCost, carryingCost, Demand, price);
	};

	/**
	 * Deletes the provided product.
	 * 
	 * @param parent
	 * @param product
	 */
	public void deleteProduct(subCategory parent, Product product) {
		this.myRoom.delete_product(parent, product);
	};

}