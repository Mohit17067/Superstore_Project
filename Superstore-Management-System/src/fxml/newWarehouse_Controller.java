package fxml;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Main;
import model.SuperUser;

public class newWarehouse_Controller {
       
       private SuperUser SUser;
       private superUser_Controller SuperController;
       
       @FXML
       private Button btnCreate;
       
       @FXML
       private Button btnCancel;
       
       @FXML
       private TextField txWarehouseName;
       
       @FXML
       private TextField txWarehouseID;
       
       @FXML
       private TextField txAdminName;
       
       @FXML
       private TextField txAdminID;
       
       @FXML
       private TextField txPassword;
       
       private Main application;
       
       /**
        * setup method for the page
        * @param SUser
        * @param SuperController
        * @param application
        */
       public void setApp(SuperUser SUser, superUser_Controller SuperController, Main application) {
               this.SUser = SUser;
               this.SuperController = SuperController;
               this.application = application;
       }
       
       /**
        * cancel button for the user
        * exits the page
        * @param event
        */
       public void Cancel_button(ActionEvent event) {
    	   Stage stage = (Stage) btnCancel.getScene().getWindow();
    	   
    	   stage.close();
       }
       
       /**
        * Event handler for the create button
        * used to create it
        * @param event
        * @throws IOException
        */
       public void Create_button(ActionEvent event) throws IOException {
    	   this.SUser.createWarehouse(txWarehouseName.getText(), txWarehouseID.getText(), txAdminName.getText(), txAdminID.getText(), txPassword.getText());
    	   this.SuperController.defaultSetup();
    	   this.application.getSystem().serialize();
       }
}