package fxml;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.Product;

public class productView_Controller {
	
	private Product product;
	
	@FXML
	private Label lblName;
	
	@FXML
	private Label lblDescription;
	
	@FXML
	private Label lblPrice;

	@FXML
	private Label lblQuantity;
	
	@FXML
	private Label lblFixedCost;

	@FXML
	private Label lblCarryingCost;
	
	@FXML
	private Label lblDemand;
	
	@FXML
	private Button btnExit;
	
	/**
	 * Used to set up the page
	 * called by previous contructor
	 * @param product
	 */
	public void setApp(Product product) {
		this.product = product;
		lblName.setText(product.getProductName());
		lblDescription.setText(product.getDescription());
		lblPrice.setText(Integer.toString(product.getPrice()));
		lblQuantity.setText(Integer.toString(product.getUnits()));
		lblFixedCost.setText(Integer.toString(product.getFixedCost()));
		lblCarryingCost.setText(Integer.toString(product.getCarryingCost()));
		lblDemand.setText(Integer.toString(product.getDemand()));
	}
	
	/**
	 * exit button event handler
	 */
	public void Exit_button() {
	 	   Stage stage = (Stage) btnExit.getScene().getWindow();
	 	   
	 	   stage.close();
	 }
	
}
