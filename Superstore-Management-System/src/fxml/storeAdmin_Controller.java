package fxml;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import model.Category;
import model.Main;
import model.Product;
import model.Store;
import model.room;
import model.subCategory;

public class storeAdmin_Controller {
	
private room Room;
	
	private Main application;
	
	private String labelCategories;
	
	private Category parent_category;
	
	private ObservableList<Category> allCategories;
	
	private ObservableList<subCategory> allSubCategories;
	
	@FXML
	private Label lblCategory;
	
	@FXML
	private Label lblRoomName;
	
	@FXML
	private Text txtAdminName;
	
	@FXML
	private ListView lsvGeneral;
	
	@FXML
	private TextField txName;
	
	@FXML
	private Button btnRefresh;
	
	/**
	 * initial setup for the page
	 * called by previous constructor to initiliaze the page
	 * @param Room
	 * @param application
	 * @param labelCategories
	 * @param parent_category
	 */
	public void setApp(room Room, Main application, String labelCategories, Category parent_category) {
		this.Room = Room;
		this.application = application;
		this.labelCategories = labelCategories;
		this.parent_category = parent_category;
		lblCategory.setText(labelCategories);
		lblRoomName.setText(Room.getRoomName());
		txtAdminName.setText(Room.getAdmin().getName());
		this.defaultSetup();
	}
	
	/**
	 * constructor for the page
	 */
	public storeAdmin_Controller() {
		lsvGeneral = new ListView();
	}
	
	/**
	 * default setup for the page
	 * used by refresh button
	 */
	public void defaultSetup() {
		if (labelCategories.equals("Categories")) {
			allCategories = FXCollections.observableList(this.Room.getCategories());
			lsvGeneral.setItems(allCategories);
		}
		else {
			allSubCategories = FXCollections.observableList(parent_category.getSubCategories());
			lsvGeneral.setItems(allSubCategories);
		}
	}
	
	/**
	 * open button event handler for the page
	 * used to open category/subcategory
	 */
	public void openButton() {
		if (lsvGeneral.getSelectionModel().getSelectedItem() != null) {
			if (this.labelCategories.equals("Categories")) {
				Category toOpen = (Category) lsvGeneral.getSelectionModel().getSelectedItem();
				this.application.warehouseAdmin(Room, "subCategories", toOpen);
			}
			else if (this.labelCategories.equals("subCategories")) {
				subCategory toOpen = (subCategory) lsvGeneral.getSelectionModel().getSelectedItem();
				this.application.productsDisplay(Room, toOpen);
			}
		}		
	}
	
	public void refreshButton() {
		this.defaultSetup();
	}
	
	/**
	 * create button event handler
	 * used to create category/subCategory
	 */
	public void createButton() {
		String Name = txName.getText();
		if (!Name.equals("")) {
			if (this.labelCategories.equals("Categories"))
				Room.getAdmin().addCategory(Name, "No Description!");
			else if (this.labelCategories.equals("subCategories"))
				Room.getAdmin().addSubCategory(Name, "NO Description!", this.parent_category);
			this.defaultSetup();
		}
		txName.setText("");
	}
	
	/**
	 * update button event handler
	 * used to update the category/subCategory
	 */
	public void updateButton() {
		if (lsvGeneral.getSelectionModel().getSelectedItem() != null) {
			if (this.labelCategories.equals("Categories")) {
				this.application.updateCategory(this.Room.getAdmin(), (Category) lsvGeneral.getSelectionModel().getSelectedItem(), null);
			}
			else if (this.labelCategories.equals("subCategories")) {
				this.application.updateCategory(this.Room.getAdmin(), null, (subCategory) lsvGeneral.getSelectionModel().getSelectedItem());
			}
		}
	}
	
	/**
	 * delete button event handler 
	 * used to delete the category/subCategory
	 */
	public void deleteButton() {
		if (lsvGeneral.getSelectionModel().getSelectedItem() != null) {
			if (this.labelCategories.equals("Categories")) {
				Category selected = (Category) lsvGeneral.getSelectionModel().getSelectedItem();
				this.Room.delete_category(selected);
			}
			else if (this.labelCategories.equals("subCategories")) {
				subCategory selected = (subCategory) lsvGeneral.getSelectionModel().getSelectedItem();
				this.Room.delete_subCategory(parent_category, selected);
			}
			this.defaultSetup();
		}
		
	}
	

}
