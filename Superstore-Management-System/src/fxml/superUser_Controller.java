package fxml;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.scene.text.FontWeight;
import model.Main;
import model.Store;
import model.Warehouse;
import model.room;

public class superUser_Controller {
	
	private Main application;
	
	private ObservableList<Store> allStores;
	
	private ObservableList<Warehouse> allWarehouses;
	
	@FXML
	private Button btnNewWarehouse;
	       
	@FXML
	private Button btnNewStore;
	       
	@FXML
	private Button btnUpdateLink;
	
	@FXML
	private Button openStore;
	
	@FXML
	private Button openWarehouse;
	
	@FXML
	private ListView lsvWarehouse;
	
	@FXML
	private ListView lsvStore;
	       

	/**
	 * initialize the page for fxml view
	 * used by login page controller
	 * @param application
	 */
	public void setApp(Main application) {
    	this.application = application;
    	this.defaultSetup();
 	}
	
	public superUser_Controller() {
		lsvWarehouse = new ListView();
		lsvStore = new ListView();
	}

	/**
	 * new warehouse event handler       
	 * @param event
	 */
	public void newWarehouse_button(ActionEvent event) {
		this.application.newWarehouse(this.application.getSystem().getDatabase().getSuperUser(), this);
	}
		
	/**
	 * new store event handler
	 * @param event
	 */
	public void newStore_button(ActionEvent event) {
		this.application.newStore(this.application.getSystem().getDatabase().getSuperUser(), this);
	}
		       
	/**
	 * update link event handler
	 * used to update the link between warehouse and store
	 * @param event
	 */
	public void updateLink_button(ActionEvent event) {
		Store toOpen = (Store) lsvStore.getSelectionModel().getSelectedItem();
		
		if (toOpen!=null)
		this.application.updateLink(this.application.getSystem().getDatabase().getSuperUser(), toOpen);
	}
	
	/**
	 * used to open the selected store from the listview.
	 */
	public void Store_button() {
		Store toOpen = (Store) lsvStore.getSelectionModel().getSelectedItem();
		
		if (toOpen != null) {
			this.application.categoriesDisplay(toOpen, "SuperUser", "Categories", null, null, null);
		}
	}

	/**
	 * used to open the selected warehouse from the listview
	 */
	public void Warehouse_button() {
		Warehouse toOpen = (Warehouse) lsvWarehouse.getSelectionModel().getSelectedItem();
		
		if (toOpen != null) {
			this.application.categoriesDisplay(toOpen, "SuperUser", "Categories", null, null, null);
		}
	}
	
	/**
	 * default setup for the page
	 * used to initialize the page
	 */
	public void defaultSetup() {
		allStores = FXCollections.observableList(this.application.getSystem().getDatabase().getStores());
		lsvStore.setItems(allStores);
		allWarehouses = FXCollections.observableList(this.application.getSystem().getDatabase().getWarehouses());
		lsvWarehouse.setItems(allWarehouses);
	}

		       
}
