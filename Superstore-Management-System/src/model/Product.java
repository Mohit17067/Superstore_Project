package model;

import java.io.Serializable;

/**
 * The {@code Product} class is used to represent each product
 * in the warehouses and stores.
 */
public class Product implements Serializable{
	
	/** Generated serial version ID */
	private static final long serialVersionUID = 17740109174622983L;

	/** The name of the product. */
	private String productName;
	
	/** The description of the product. */
	private String Description;
	
	/** The stock of the product. */
	private int Units;
	
	/** The fixed cost of the product. */
	private int fixedCost;
	
	/** The carrying cost of the product. */
	private int carryingCost;
	
	/** The demand of the product. */
	private int Demand;
	
	/** The price of the product. */
	private int price;
	
	/** The subcategory under which this product comes under. */
	private subCategory parent;
	

	/**
	 * Constructor
	 */
	public Product(String Name, String Description, int Units, int fixedCost, int carryingCost, int Demand, int price, subCategory parent) {
		this.productName = Name;
		this.Description = Description;
		this.Units = Units;
		this.fixedCost = fixedCost;
		this.carryingCost = carryingCost;
		this.Demand = Demand;
		this.price = price;
		this.parent = parent;
	}


	/**
	 * Calculates and returns the EOQ for a product.
	 */
	public int calculateEOQ() {
		int EOQ = (int) Math.ceil(Math.sqrt(2*this.fixedCost*this.Demand/this.carryingCost));
		return EOQ;
	}

	/**
	 * This method is used to update any of the arguments of a product.
	 */
	public void update(String Name, String Description, int Units, int fixedCost, int carryingCost, int Demand, int price) {
		// TODO implement here
		this.productName = Name;
		this.Description = Description;
		this.Units = Units;
		this.fixedCost = fixedCost;
		this.carryingCost = carryingCost;
		this.Demand = Demand;
		this.price = price;
	}
	
	/**
	 * @return the name of the product.
	 */
	public String toString() {
		return this.productName;
	}

	/**
	 * @return the name of the product.
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @return the description of the product.
	 */
	public String getDescription() {
		return Description;
	}

	/**
	 * @return the stock of the product.
	 */
	public int getUnits() {
		return this.Units;
	}

	/**
	 * @return the fixed cost of the product.
	 */
	public int getFixedCost() {
		return fixedCost;
	}

	/**
	 * @return the carrying cost of the product.
	 */
	public int getCarryingCost() {
		return carryingCost;
	}

	/**
	 * @return the demand of the product.
	 */
	public int getDemand() {
		return Demand;
	}

	/**
	 * @return the price of the product.
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @return the parent subcategory of the product.
	 */
	public subCategory getParent() {
		return parent;
	}
	
	/**
	 * Reduces the stock by the provided amount.
	 * 
	 * @param units
	 */
	public void reduceUnits(int units) {
		this.Units -= units;
		if (this.Units <= 0) {
			this.parent.getParent().getParent().orderProducts(this);
		}
	}
	
	/**
	 * used to reduce units from the room
	 * @param units
	 */
	public void reduceWarehouse(int units) {
		this.Units -= units;
	}
	
	/**
	 * used to inc units in the room
	 */
	public void incUnits() {
		this.Units += this.calculateEOQ();
	}

}