package fxml;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Admin;
import model.Category;
import model.subCategory;

public class updateCategory_Controller {

	private Admin admin;
	
	private Category category;
	
	private subCategory SubCategory;
	
	@FXML
	private TextField txtName;
	
	@FXML
	private TextField txtDescription;
	
	@FXML
	private Button btnCancel;
	
	@FXML
	private Button btnUpdate;
	
	/**
	 * setup page for the category
	 * used to initialize the page
	 * @param admin
	 * @param category
	 * @param SubCategory
	 */
	public void setApp(Admin admin, Category category, subCategory SubCategory) {
		this.admin = admin;
		this.category = category;
		this.SubCategory = SubCategory;
		if (this.category!=null) {
			this.txtName.setText(category.getName());
			this.txtDescription.setText(category.getDescription());
		}
		else if (this.SubCategory!=null) {
			this.txtName.setText(SubCategory.getName());
			this.txtDescription.setText(this.SubCategory.getDescription());
		}
	}
	
	/**
	 * cancel button for the page
	 */
	public void Cancel_button() {
 	   Stage stage = (Stage) btnCancel.getScene().getWindow();
 	   
 	   stage.close();
    }
	
	/**
	 * update button event handler
	 * used to update the selected category
	 */
	public void Update_Button() {
		String newDescription = this.txtDescription.getText();
		if (this.category!=null)
			admin.updateCategory(this.category, this.category.getName(), newDescription);
		else if (this.SubCategory!=null)
			admin.updateSubCategory(this.SubCategory, this.SubCategory.getName(), newDescription);
		this.Cancel_button();
	}
	
}
