package model;

import java.io.Serializable;
import java.util.LinkedList;

public class subCategory implements Serializable{
	
	/** Generated serial version ID */
	private static final long serialVersionUID = -4999229528849581448L;

	/** The name of the subcategory */
	private String subCategoryName;
	
	/** The description of the subcategory */
	private String Description;
	
	/** The parent category of the subcategory */
	private Category parent;
	
	/**
	 * 
	 */
	private LinkedList<Product> products;
	

	/**
	 * Default constructor
	 */
	public subCategory(String Name, String Description, Category parent) {
		this.subCategoryName = Name;
		this.Description = Description;
		this.parent = parent;
		this.products = new LinkedList<Product>();
	}
	
	/**
	 * Update the name and description of the subcategory.
	 * @param name
	 * @param Description
	 */
	public void update(String name, String Description) {
		this.subCategoryName = name;
		this.Description = Description;
	}
	
	/**
	 * Adds the provided product to the list of products.
	 * @param product
	 */
	public void addProduct(Product product) {
		this.products.add(product);
	}

	/**
	 * Deletes the provided product from the list of products.
	 * @param product
	 */
	public void deleteProduct(Product product) {
		this.products.remove(product);
	}
	
	/**
	 * @return the name of the subcategory
	 */
	public String toString() {
		return this.subCategoryName;
	}
	
	/**
	 * @return the list of all products
	 */
	public LinkedList<Product> getProducts() {
		return this.products;
	}
	
	/**
	 * @return the name of the subcategory
	 */
	public String getName() {
		return this.subCategoryName;
	}

	/**
	 * @return the description of the subcategory
	 */
	public String getDescription() {
		return this.Description;
	}
	
	/**
	 * return parent for the subCategory
	 * @return
	 */
	public Category getParent() {
		return this.parent;
	}
}
