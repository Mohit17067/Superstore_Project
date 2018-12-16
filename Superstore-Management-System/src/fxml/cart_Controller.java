package fxml;

import java.util.LinkedList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import model.Cart;
import model.EndUser;
import model.Product;
import model.Store;
import model.room;

public class cart_Controller {
	
	private EndUser endUser;
	
	private room Room;
	
	private Cart cart;
	
	private ObservableList<Product> allProducts;
	
	private ObservableList<Integer> allPrices;
	
	private ObservableList<Integer> allUnits;
	
	@FXML
	private ListView lsvProduct;
	
	@FXML
	private ListView lsvPrice;
	
	@FXML
	private ListView lsvUnit;
	
	@FXML
	private Button btnCheckout;
	
	@FXML
	private Button btnExit;
	
	@FXML
	private Button btnRemove;
	
	@FXML
	private Button btnRefresh;
	
	@FXML
	private Label lblTotal;
	
	/**
	 * Creates the basic setup page for the fxml file
	 * @param endUser
	 * @param Room
	 */
	public void setApp(EndUser endUser, room Room) {
		this.endUser = endUser;
		this.Room = Room;
		this.cart = this.endUser.getCart();
		this.defaultSetup();
	}
	
	/**
	 * Constructor for controller
	 */
	public cart_Controller() {
		this.lsvPrice = new ListView();
		this.lsvProduct = new ListView();
		this.lsvUnit = new ListView();
	}
	
	/**
	 * Set the default setup of the page.
	 */
	public void defaultSetup() {
		this.cart = this.endUser.getCart();
		LinkedList<Integer> prices = cart.getPrices();
		LinkedList<Integer> units = cart.getUnits();
		allProducts = FXCollections.observableList(cart.getProducts());
		allPrices = FXCollections.observableList(cart.getPrices());
		allUnits  = FXCollections.observableList(cart.getUnits());
		lsvProduct.setItems(allProducts);
		lsvPrice.setItems(allPrices);
		lsvUnit.setItems(allUnits);
		int total_value = 0;
		for (int i=0; i<prices.size();i++) {
			total_value += prices.get(i)*units.get(i);
		}
		lblTotal.setText(Integer.toString(total_value));
	}
	
	/**
	 * Refreshes the fxml page for the view
	 * Used by refresh button
	 */
	public void Refresh_button() {
		this.defaultSetup();
	}
	
	/**
	 * Exits the page. Action Event for exit button
	 */
	public void Exit_button() {
	 	   Stage stage = (Stage) btnExit.getScene().getWindow();
	 	   
	 	   stage.close();
	 }
	
	/**
	 * Action event for remove button.
	 * Removes items from the cart.
	 */
	public void Remove_button() {
		Product product = (Product) lsvProduct.getSelectionModel().getSelectedItem();
		if (product!=null) {
			int ind = lsvProduct.getSelectionModel().getSelectedIndex();
			cart.removeProduct(product);
			cart.removePrice(ind);
			cart.removeUnit(ind);
		}
		this.defaultSetup();
	}
	
	/**
	 * Checkout button for end user
	 * Decreases quantity of the project.
	 */
	public void Checkout_button() {
		this.endUser.checkOut();
		this.defaultSetup();
	}
	
	

	
}
