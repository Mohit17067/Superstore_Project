package model;

import java.io.Serializable;
import java.util.*;

/**
 * 
 */
public class Warehouse extends room implements Serializable{
	
	private Database database;
	
	private LinkedList<Warehouse> OtherWarehouses;
	
	private String city;
	
	private String[] cities = new String[] {"Delhi",  "Patna", "Banglore"};
	
	public static LinkedList<Warehouse> Delhi = new LinkedList<Warehouse>();
	public static LinkedList<Warehouse> Patna = new LinkedList<Warehouse>();
	public static LinkedList<Warehouse> Banglore = new LinkedList<Warehouse>();
	
	public static LinkedList<LinkedList<Warehouse>> all_cities = new LinkedList<LinkedList<Warehouse>>();
	
	/** Generated serial version ID */
	private static final long serialVersionUID = -6126848837759993505L;
	
	/** the list of all store */
	private LinkedList<Store> stores;

	/**
	 * Default constructor
	 */
	public Warehouse(String room_Name, String room_ID, String admin_name, String admin_ID, String admin_pswd, Database database) {
		super(room_Name, room_ID, admin_name, admin_ID, admin_pswd);
		all_cities.add(Delhi);
		all_cities.add(Patna);
		all_cities.add(Banglore);
		Random rand = new Random();
		int num = rand.nextInt(3);
		this.city = cities[num];
		all_cities.get(num).add(this);
		
		this.database = database;
		this.OtherWarehouses = this.database.getWarehouses();
		this.OtherWarehouses.remove(this);
		stores = new LinkedList<Store>();
	}

	/** adds provided store to the list of all stores */
	public void linkStore(Store store) {
		this.stores.add(store);
	}

	/**
	 * searches for the product matching the product name
	 * 
	 * @param productName 
	 * @return
	 */
	public Product search(String productName) {
		// TODO implement here
		return null;
	}

	/**
	 * orders more stock of products
	 */
	public void orderInventory() {
		// TODO implement here
	}

	/**
	 * chooses most appropriate warehouse for requesting help to fulfill an order
	 * 
	 * @param warehouses
	 * @param product
	 * @return
	 */
	public Warehouse chooseWarehouse(Collection<Warehouse> warehouses, Product product) {
		// TODO implement here
		return null;
	}

	/**
	 * order products from alternate warehouse
	 * 
	 * @param warehouse 
	 * @param product
	 */
	public void orderInventoryFromOtherWarehouse(Warehouse warehouse, Product product) {
		// TODO implement here
	}

	/**
	 * updates the fixed cost
	 */
	public void updateFixedCost() {
		// TODO implement here
	}

	/**
	 * generates alert
	 */
	public void generateAlert() {
		// TODO implement here
	}


	@Override
	public String orderProducts(Product product) {
		System.out.println("check");
		// TODO Auto-generated method stub
		for (int i=0; i<this.Categories.size();i++) {
			Category c = this.Categories.get(i);
			for (int j=0; j<c.getSubCategories().size(); j++) {
				subCategory s = c.getSubCategories().get(j);
				for (int k=0; k<s.getProducts().size(); k++) {
					Product p = s.getProducts().get(k);
					if (p.getProductName().equals(product.getProductName())) {
						if (p.getUnits() >= product.calculateEOQ()) {
							p.reduceWarehouse(product.calculateEOQ());
							return "successful";
						}
					}
				}
			}
		}
		return this.chooseOther(product);
	}
	
	public String chooseOther(Product product) {
		if (this.city.equals("Delhi")) {
			if (city_order(Delhi, product).equals("successful"))
				return "successful";
			else if (city_order(Patna, product).equals("successful"))
				return "successful";
			else if (city_order(Banglore, product).equals("successful"))
				return "successful";
		}
		else if (this.city.equals("Patna")) {
			if (city_order(Patna, product).equals("successful"))
				return "successful";
			else if (city_order(Delhi, product).equals("successful"))
				return "successful";
			else if (city_order(Banglore, product).equals("successful"))
				return "successful";
		}
		if (this.city.equals("Banglore")) {
			if (city_order(Banglore, product).equals("successful"))
				return "successful";
			else if (city_order(Delhi, product).equals("successful"))
				return "successful";
			else if (city_order(Patna, product).equals("successful"))
				return "successful";
		}
		return "unsuccessful";
	}
	
	public String city_order(LinkedList<Warehouse> city_name, Product product) {
		for (int i=0; i<city_name.size(); i++) {
			Warehouse w = city_name.get(i);
			if (!w.getID().equals(this.getID())) {
				for (int j=0;j<w.getCategories().size();j++) {
					Category c = this.Categories.get(j);
					for (int k=0;k<c.getSubCategories().size();k++) {
						subCategory s = c.getSubCategories().get(k);
						for (int l=0;l<s.getProducts().size();l++) {
							Product p = s.getProducts().get(l);
							if (p.getProductName().equals(product.getProductName())) {
								if (p.getUnits() >= product.calculateEOQ()) {
									p.reduceWarehouse(product.calculateEOQ());
									return "successful";
								}
							}
						}
					}
				}
			}
		}
		return "unsuccessful";
	}
	
	public static LinkedList<Warehouse> getDelhi(){
		return Delhi;
	}
	
	public static LinkedList<Warehouse> getBanglore(){
		return Banglore;
	}
	
	public static LinkedList<Warehouse> getPatna(){
		return Patna;
	}
	
	public static LinkedList<LinkedList<Warehouse>> getAll(){
		return all_cities;
	}
	
	public String getCity() {
		return this.city;
	}
}