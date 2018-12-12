package model;

import java.io.Serializable;
import java.util.LinkedList;

public abstract class room implements Serializable{
	
	/** Generated serial version ID */
	private static final long serialVersionUID = -4634684587662534383L;

	/** Name of the facility */
	private String Name;
	
	/** Unique ID of the facility */
	private String ID;
	
	/** The administrator of the facility */
	private Admin admin;
	
	/** The list of categories inside this facility. */
	protected LinkedList<Category> Categories;
	
	/** The current category */
	protected Category Current_Category;
	
	/**
	 * Constructor
	 * 
	 * @param room_Name
	 * @param room_ID
	 * @param admin_name
	 * @param admin_ID
	 * @param admin_pswd
	 */
	public room(String room_Name, String room_ID, String admin_name, String admin_ID, String admin_pswd) {
		this.Name = room_Name;
		this.ID = room_ID;
		admin = new Admin(admin_name, admin_ID, admin_pswd, this);
		this.Categories = new LinkedList<Category>();
	}
	
	/**
	 * Adds a new category to the list of categories.
	 * 
	 * @param category
	 */
	public void add_category(Category category) {
		this.Categories.add(category);
	}
	
	/**
	 * Deletes a cateogry from the list of categories.
	 * 
	 * @param category
	 */
	public void delete_category(Category category) {
		this.Categories.remove(category);
	}
	
	/**
	 * Updates the provided category's name and description.
	 * 
	 * @param category
	 * @param name
	 * @param Description
	 */
	public void update_category(Category category, String name, String Description) {
		category.update(name, Description);
	}
	
	/**
	 * Adds the provided subcategory to the provided category.
	 * 
	 * @param parent
	 * @param SubCategory
	 */
	public void add_subCategory(Category parent, subCategory SubCategory) {
		parent.addSubCategory(SubCategory);
	}
	
	/**
	 * Deletes the provided subcategory from the provided category.
	 * 
	 * @param parent
	 * @param SubCategory
	 */
	public void delete_subCategory(Category parent, subCategory SubCategory) {
		parent.deleteSubCategory(SubCategory);
	}

	/**
	 * Updates name and description in the provided subcategory.
	 * 
	 * @param SubCategory
	 * @param name
	 * @param Description
	 */
	public void update_subCategory(subCategory SubCategory, String name, String Description) {
		SubCategory.update(name, Description);
	}
	
	/**
	 * Adds the provided product int he provided subcategory.
	 * 
	 * @param parent
	 * @param product
	 */
	public void add_product(subCategory parent, Product product) {
		parent.addProduct(product);
	}
	
	/**
	 * Updates arguments of the provided product.
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
	public void update_product(Product product, String Name, String Description, int Units, int fixedCost, int carryingCost, int Demand, int price) {
		product.update(Name, Description, Units, fixedCost, carryingCost, Demand, price);
	}
	
	/**
	 * Deletes a product from the provided subcategory.
	 * 
	 * @param parent
	 * @param product
	 */
	public void delete_product(subCategory parent, Product product) {
		parent.deleteProduct(product);
	}

	/**
	 * @return the administrator of the store or warehouse.
	 */
	public Admin getAdmin() {
		return this.admin;
	}
	/**
	 * @return return the name of the facility.
	 */
	public String getRoomName() {
		return this.Name;
	}
	
	/**
	 * @return the name of the facility.
	 */
	public String toString() {
		return this.Name;
	}
	
	/**
	 * @return the list of categories in the facility.
	 */
	public LinkedList<Category> getCategories() {
		return this.Categories;
	}
	
	public String getID() {
		return this.ID;
	}
	
	public abstract String orderProducts(Product product);
	
}
