package fxml;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Admin;
import model.Product;
import model.subCategory;

public class updateProduct_Controller {

	private Admin admin;
	
	private Product product;
	
	@FXML
	private TextField txtName;
	
	@FXML
	private TextField txtDescription;
	
	@FXML
	private TextField txtPrice;
	
	@FXML
	private TextField txtQuantity;
	
	@FXML
	private TextField txtFixedCost;
	
	@FXML
	private TextField txtCarryingCost;
	
	@FXML
	private TextField txtDemand;
	
	@FXML
	private Button btnCancel;
	
	@FXML
	private Button btnUpdate;
	
	/**
	 * setup page for the fxml page
	 * @param admin
	 * @param product
	 */
	public void setApp(Admin admin, Product product) {
		this.admin = admin;
		this.product = product;
		txtName.setText(this.product.getProductName());
		txtDescription.setText(this.product.getDescription());
		txtPrice.setText(Integer.toString(this.product.getPrice()));
		txtQuantity.setText(Integer.toString(this.product.getUnits()));
		txtFixedCost.setText(Integer.toString(this.product.getFixedCost()));
		txtCarryingCost.setText(Integer.toString(this.product.getCarryingCost()));
		txtDemand.setText(Integer.toString(this.product.getDemand()));
	}
	
	/**
	 * cancel button event handler
	 */
	public void Cancel_button() {
	 	   Stage stage = (Stage) btnCancel.getScene().getWindow();
	 	   
	 	   stage.close();
	 }
	
	
	/**
	 * used to update the page
	 * update button event handler
	 */
	public void Update_button() {
		String Name = txtName.getText();
		String Description = txtDescription.getText();
		String Price = txtPrice.getText();
		String Quantity = txtQuantity.getText();
		String FixedCost = txtFixedCost.getText();
		String CarryingCost = txtCarryingCost.getText();
		String Demand = txtDemand.getText();
		
		this.admin.updateProduct(this.product, Name, Description, Integer.parseInt(Quantity), Integer.parseInt(FixedCost), Integer.parseInt(CarryingCost), Integer.parseInt(Demand), Integer.parseInt(Price));
		
		this.Cancel_button();
	}
}
