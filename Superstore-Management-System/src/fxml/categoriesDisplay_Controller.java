package fxml;




import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.Category;
import model.EndUser;
import model.Main;
import model.Product;
import model.room;
import model.subCategory;

public class categoriesDisplay_Controller {

	private room Room;
	
	private Main application;
	
	private String userType;
	
	private String labelCategories;
	
	private Category parent_category;
	
	private subCategory parent_subCategory;
	
	private EndUser endUser;
	
	private ObservableList<Category> allCategories;
	
	private ObservableList<subCategory> allSubCategories;
	
	private ObservableList<Product> allProducts;
	
	@FXML
	private Label lblCategory;
	
	@FXML
	private Label lblRoomName;
	
	@FXML
	private Text txtUserType;
	
	@FXML
	private ListView lsvGeneral;
	
	@FXML
	private Label lblDescription;
	
	@FXML
	private Button btnOpen;
	
	@FXML
	private VBox vboxSort;
	
	@FXML
	private Button btnCart;
	
	@FXML
	private AnchorPane apBar;
	
	@FXML
	private Button btnSort;
	
	@FXML
	private ComboBox cmbSearch;
	
	@FXML
	private Button btnSearch;
	
	/**
	 * Sets app for the project. Basic page functionality.
	 * @param Room
	 * @param application
	 * @param userType
	 * @param labelCategories
	 * @param parent_category
	 * @param parent_subCategory
	 * @param endUser
	 */
	public void setApp(room Room, Main application, String userType, String labelCategories, Category parent_category, subCategory parent_subCategory, EndUser endUser) {
		this.Room = Room;
		this.application = application;
		this.userType = userType;
		this.labelCategories = labelCategories;
		this.parent_category = parent_category;
		this.parent_subCategory = parent_subCategory;
		this.endUser = endUser;
		lblCategory.setText(labelCategories);
		lblRoomName.setText(Room.getRoomName());
		txtUserType.setText(userType);
		this.defaultSetup();
		if (this.userType.equals("endUser") && this.labelCategories.equals("Products")) {
			btnSort = new Button("Sort");
			vboxSort.getChildren().add(btnSort);
			btnSort.setOnAction(new EventHandler<ActionEvent>() {
			    @Override public void handle(ActionEvent e) {
					lsvGeneral.setItems(allProducts.sorted());
			    }
			});
		}
		if (!this.userType.equals("endUser"))
			this.apBar.getChildren().remove(btnCart);
		
		if (!this.userType.equals("endUser") && !this.labelCategories.equals("Products"))
			this.apBar.getChildren().remove(btnSearch);
	}
	
	
	/**
	 * constructor for the controller
	 */
	public categoriesDisplay_Controller() {
		this.lsvGeneral = new ListView();
		vboxSort = new VBox();	
	}
	
	/**
	 * Default setup page for the view.
	 * Initializes all the objects.
	 */
	public void defaultSetup() {
		if (this.labelCategories.equals("Categories")) {
			allCategories = FXCollections.observableList(this.Room.getCategories());
			lsvGeneral.setItems(allCategories);
		}
		
		else if (this.labelCategories.equals("subCategories")) {
			allSubCategories = FXCollections.observableList(parent_category.getSubCategories());
			lsvGeneral.setItems(allSubCategories);
		}
		
		else {
			allProducts = FXCollections.observableList(parent_subCategory.getProducts());
			cmbSearch.setItems(allProducts);
			lsvGeneral.setItems(allProducts);
		}
	}
	
	/**
	 * Open button for the categories Display
	 * Selected category got from the list view is opened.
	 */
	public void openButton() {
		if (lsvGeneral.getSelectionModel().getSelectedItem() != null) {
			if (this.labelCategories.equals("Categories")) {
				Category toOpen = (Category) lsvGeneral.getSelectionModel().getSelectedItem();
				this.application.categoriesDisplay(Room, userType, "subCategories", toOpen, null, this.endUser);
			}
			else if (this.labelCategories.equals("subCategories")) {
				subCategory toOpen = (subCategory) lsvGeneral.getSelectionModel().getSelectedItem();
				this.application.categoriesDisplay(Room, userType, "Products", parent_category, toOpen, this.endUser);
			}
			else {
				Product toOpen = (Product) lsvGeneral.getSelectionModel().getSelectedItem();
				if (this.userType.equals("SuperUser") || this.userType.equals("warehouseAdmin"))
					this.application.productView(toOpen);
				else
					this.application.productOrder(toOpen, Room, this.endUser);
			}
	}
}
	
	/**
	 * cart button for the end user
	 */
	public void Cart_button() {
		this.application.Cart(endUser, null);
	}
	
	public void Search_button() {
		String value = this.cmbSearch.getEditor().getText();
		if (value!=null) {
			List <String> list = new ArrayList();
			for (int i=0; i<allProducts.size();i++) {
				list.add(allProducts.get(i).getProductName());
				List <String> listClone = new ArrayList<String>();
				for (String string : list) {
		               if(string.matches("(?i)(" + value + ").*")){
		                   listClone.add(string);
		               }
				cmbSearch.setItems(FXCollections.observableList(listClone));
			}
		}
	}
	

}
	
}
