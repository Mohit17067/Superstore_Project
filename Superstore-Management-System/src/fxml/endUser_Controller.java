package fxml;

import java.util.LinkedList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import model.EndUser;
import model.Main;
import model.Store;
import model.Warehouse;

public class endUser_Controller {
	
	private ObservableList<Store> allStores;
	
	private Main application;
	
	private EndUser endUser;
	
	@FXML
	private ListView lsvStore;
	
	@FXML
	private Button btnCart;
	
	/**
	 * set app for the fxml view
	 * initializes every thing
	 * @param application
	 */
	public void setApp(Main application) {
		this.application = application;
		this.endUser = this.application.getSystem().getDatabase().getEndUser();
		this.defaultSetup();
	}
	
	/**
	 * constructor for this file
	 */
	public endUser_Controller() {
		lsvStore = new ListView();
	}
	
	/**
	 * default setup for the page
	 * all used by refresh button.
	 */
	public void defaultSetup() {
		allStores = FXCollections.observableList(this.application.getSystem().getDatabase().getStores());
		lsvStore.setItems(allStores);
	}
	
	/**
	 * refresh button for the page
	 * calls default setup method
	 */
	public void refreshButton() {
		this.defaultSetup();
	}
	
	/**
	 * open button for stores in the end user view
	 */
	public void openButton() {
		Store toOpen = (Store) lsvStore.getSelectionModel().getSelectedItem();
		
		if (toOpen != null) {
			this.application.categoriesDisplay(toOpen, "endUser", "Categories", null, null, this.endUser);
		}
	}
	
	/**
	 * cart button action event for the view
	 */
	public void Cart_button() {
		this.application.Cart(endUser, null);
	}
		
}

