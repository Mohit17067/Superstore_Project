package fxml;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.Category;
import model.Main;
import model.Product;
import model.room;
import model.subCategory;

public class productsDisplay_Controller {

	private room Room;
	
	private Main application;
	
	private subCategory parent_subCategory;
	
	private ObservableList<Product> allProducts;
	
	@FXML
	private Label lblRoomName;
	
	@FXML
	private Text txtAdminName;
	
	@FXML
	private ListView lsvProducts;
	
	@FXML
	private Button btnRefresh;
	
	/**
	 * method used to set the app
	 * called by previous controller
	 * @param Room
	 * @param application
	 * @param parent_subCategory
	 */
	public void setApp(room Room, Main application, subCategory parent_subCategory) {
		this.Room = Room;
		this.application = application;
		this.parent_subCategory = parent_subCategory;
		lblRoomName.setText(Room.getRoomName());
		txtAdminName.setText(Room.getAdmin().getName());
		this.defaultSetup();
	}
	
	/**
	 * constructor for the page
	 */
	public productsDisplay_Controller() {
		lsvProducts = new ListView();
	}
	
	/**
	 * default setup for the page
	 * called by refresh button
	 */
	public void defaultSetup() {
		 	this.allProducts = FXCollections.observableList(parent_subCategory.getProducts());
			lsvProducts.setItems(allProducts);
	}
	
	public void refreshButton() {
		this.defaultSetup();
	}
	
	/**
	 * used to create new product
	 * event handler for the new product button
	 */
	public void createButton() {
		this.application.newProduct(Room.getAdmin(), parent_subCategory);
	}
	
	/**
	 * event handler for the update button
	 */
	public void updateButton() {
		if (lsvProducts.getSelectionModel().getSelectedItem() != null)
		this.application.updateProduct(Room.getAdmin(), (Product) lsvProducts.getSelectionModel().getSelectedItem());
	}
	
	/**
	 * delete button event handles
	 * used to delete the product
	 */
	public void deleteButton() {
		if (lsvProducts.getSelectionModel().getSelectedItem() != null) {
				Product selected = (Product) lsvProducts.getSelectionModel().getSelectedItem();
				this.Room.delete_product(parent_subCategory, selected);
			}
			this.defaultSetup();
		}
		
	
}
