package model;

import java.io.Serializable;
import java.util.*;

/**
 * The {@code Category} class is used to represent the categories
 * in the store and warehouse classes.
 */
public class Category implements Serializable{
	
	/** Generated serial version ID */
	private static final long serialVersionUID = 4370856794001585086L;

	/** The name of the category. */
	private String categoryName;
	
	/** The description of the category */
	private String Description;
	
	/** The store or warehouse in which this category is located. */
	private room parent;
	
	/** The list of subcategories which come under this category */
	private LinkedList<subCategory> subCategories;
	
	/* The current subcategory. */
	private subCategory current_subCategory;
	
	

	/**
	 * Constructor
	 */
	public Category(String Name, String Description, room parent) {
		this.categoryName = Name;
		this.Description = Description;
		this.parent = parent;
		subCategories = new LinkedList<subCategory>();
	}
	
	/**
	 * Updates name and description if provided.
	 * 
	 * @param name
	 * @param Description
	 */
	public void update(String name, String Description) {
		this.categoryName = name;
		this.Description = Description;
	}

	/**
	 * Adds a subcategory to the subcategory linkedlist.
	 * 
	 * @param SubCategory
	 */
	public void addSubCategory(subCategory SubCategory) {
		// TODO implement here
		this.subCategories.add(SubCategory);
	}

	/**
	 * Deletes a subcategory in the subcategory linkedlist.
	 * 
	 * @param subCategory
	 */
	public void deleteSubCategory(subCategory subCategory) {
		// TODO implement here
		this.subCategories.remove(subCategory);
	}

	/**
	 * Returns the linkedlist of subcategories.
	 * 
	 * @return
	 */
	public LinkedList<subCategory> getSubCategories() {
		return this.subCategories;
	}
	
	/**
	 * Returns category name
	 */
	public String toString() {
		return this.categoryName;
	}
	
	/**
	 * Returns caregory name
	 * 
	 * @return
	 */
	public String getName() {
		return this.categoryName;
	}
	
	/**
	 * Returns description
	 * @return
	 */
	public String getDescription() {
		return this.Description;
	}
	
	/**
	 * return the parent for a category
	 * @return
	 */
	public room getParent() {
		return this.parent;
	}
	
}