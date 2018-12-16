package model;


import java.io.IOException;
import java.io.Serializable;
import fxml.cart_Controller;
import fxml.categoriesDisplay_Controller;
import fxml.endUser_Controller;
import fxml.loginController;
import fxml.newProduct_Controller;
import fxml.newStore_Controller;
import fxml.newWarehouse_Controller;
import fxml.otherWarehouses_Controller;
import fxml.productOrder_Controller;
import fxml.productView_Controller;
import fxml.productsDisplay_Controller;
import fxml.storeAdmin_Controller;
import fxml.superUser_Controller;
import fxml.updateCategory_Controller;
import fxml.updateLink_Controller;
import fxml.updateProduct_Controller;
import fxml.warehouseAdmin_Controller;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class Main extends Application implements Serializable{
	
	private static Main mainInstance;
	private Parent root;
	private system APP;
	
	/**
	 * constuctor for the main file
	 * thhrows exception required for serialization
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
    public Main() throws ClassNotFoundException, IOException {
        mainInstance = this;
        APP = new system();
    }
    
    /**
     * return the instance of this file
     * @return
     */
    public static Main getInstance() {
        return mainInstance;
    }
    
    /**
     * returns the system field
     * @return
     */
    public system getSystem() {
    	return this.APP;
    }
    
    /**
     * Main start method for the Application 
     * used to set all stages
     */
	@Override
	public void start(Stage primaryStage) {
		try {
			Login();
		} catch(Exception e) {
			e.printStackTrace();
		}		
	}
	
	/**
	 * used to login the page
	 * calls stage method 
	 */
	public void Login() {
		FXMLLoader loader;
		try {
			loader = new_stage("/fxml/loginPage.fxml");
			loginController login = loader.getController();
			login.setApp(this);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * used to start the superuser page
	 */
	public void SuperUser() {
		FXMLLoader loader;
		try {
			loader = new_stage("/fxml/superuserMainPage.fxml");
			superUser_Controller superUser = loader.getController();
			superUser.setApp(this);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * used to create new warehouse
	 * sets new page
	 * @param SUser
	 * @param SuperController
	 */
	public void newWarehouse(SuperUser SUser, superUser_Controller SuperController) {
		FXMLLoader loader;
		try {
			loader = new_stage("/fxml/newWarehouse.fxml");
		    newWarehouse_Controller newWarehouse = loader.getController();
		    newWarehouse.setApp(SUser, SuperController, this);
		  }
		  catch (Exception e) {
		  e.printStackTrace();
		   }
		 }
		     
	/**
	 * set new stage for the 
	 * @param SUser
	 * @param SuperController
	 */
		public void newStore(SuperUser SUser, superUser_Controller SuperController) {
		 FXMLLoader loader;
		 try {
		    loader = new_stage("/fxml/newStore.fxml");
		    newStore_Controller newStore = loader.getController();
		    newStore.setApp(SUser, SuperController);
		   }
		 catch (Exception e) {
		      e.printStackTrace();
		   }
		       }
		
		/**
		 * used to call the update link page
		 * @param SUser
		 * @param store
		 */
		 public void updateLink(SuperUser SUser, Store store) {
		 FXMLLoader loader;
		 try {
		 loader = new_stage("/fxml/updateLink.fxml");
		 updateLink_Controller UpdateLink = loader.getController();
		 UpdateLink.setApp(SUser, this, store);
		  }
		 catch (Exception e) {
		 e.printStackTrace();
		 }
		}

		 /**
		  * used to opend store admin page
		  * @param myStore
		  * @param labelCategories
		  * @param parent_category
		  */
	public void storeAdmin(room myStore, String labelCategories, Category parent_category) {
		FXMLLoader loader;
		try {
			loader = new_stage("/fxml/storeAdmin.fxml");
			storeAdmin_Controller storeAdmin = loader.getController();
			storeAdmin.setApp(myStore, this, labelCategories, parent_category);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param myWarehouse
	 * @param labelCategories
	 * @param parent_category
	 */
	public void warehouseAdmin(room myWarehouse, String labelCategories, Category parent_category) {
		FXMLLoader loader;
		try {
			loader = new_stage("/fxml/warehouseAdmin.fxml");
			warehouseAdmin_Controller warehouseAdmin = loader.getController();
			warehouseAdmin.setApp(myWarehouse, this, labelCategories, parent_category);;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * used to create the endUser page
	 */
	public void endUser() {
		FXMLLoader loader;
		try {
			loader = new_stage("/fxml/enduserStoresDisplay.fxml");
			endUser_Controller endUser = loader.getController();
			endUser.setApp(this);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * used to set stage for the category view
	 * @param Room
	 * @param userType
	 * @param labelCategories
	 * @param parent_category
	 * @param parent_subCategory
	 * @param endUser
	 */
	public void categoriesDisplay(room Room, String userType, String labelCategories, Category parent_category, subCategory parent_subCategory, EndUser endUser) {
		FXMLLoader loader;
		try {
			loader = new_stage("/fxml/categoriesDisplay.fxml");
			categoriesDisplay_Controller categoryDisplay = loader.getController();
			categoryDisplay.setApp(Room, this, userType, labelCategories, parent_category, parent_subCategory, endUser);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * used to set stage for the other warehouse page
	 * @param Warehouse
	 */
	public void otherWarehouses(room Warehouse) {
		FXMLLoader loader;
		try {
			loader = new_stage("/fxml/otherWarehouses.fxml");
			otherWarehouses_Controller otherWarehouses = loader.getController();
			otherWarehouses.setApp(Warehouse, this);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * used to set update category stage
	 * @param admin
	 * @param category
	 * @param SubCategory
	 */
	public void updateCategory(Admin admin, Category category, subCategory SubCategory) {
		FXMLLoader loader;
		try {
			loader = new_stage("/fxml/updateCategory.fxml");
			updateCategory_Controller updateCategory = loader.getController();
			updateCategory.setApp(admin, category, SubCategory);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * used to set stage for the products to display
	 * @param Room
	 * @param SubCategory
	 */
	public void productsDisplay(room Room, subCategory SubCategory) {
		FXMLLoader loader;
		try {
			loader = new_stage("/fxml/productsDisplay.fxml");
			productsDisplay_Controller productsDisplay = loader.getController();
			productsDisplay.setApp(Room, this, SubCategory);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * used to open new Product
	 * and set its stage
	 * @param admin
	 * @param SubCategory
	 */
	public void newProduct(Admin admin, subCategory SubCategory) {
		FXMLLoader loader;
		try {
			loader = new_stage("/fxml/newProduct.fxml");
			newProduct_Controller newProduct = loader.getController();
			newProduct.setApp(admin, SubCategory);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * used to set update page
	 * @param admin
	 * @param product
	 */
	public void updateProduct(Admin admin, Product product) {
		FXMLLoader loader;
		try {
			loader = new_stage("/fxml/Update_Product.fxml");
			updateProduct_Controller updateProduct = loader.getController();
			updateProduct.setApp(admin, product);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * used to set product stage.
	 * @param product
	 */
	public void productView(Product product) {
		FXMLLoader loader;
		try {
			loader = new_stage("/fxml/ProductView.fxml");
			productView_Controller productView = loader.getController();
			productView.setApp(product);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * used to set stage for the product order page
	 * @param product
	 * @param Room
	 * @param endUser
	 */
	public void productOrder(Product product, room Room, EndUser endUser) {
		FXMLLoader loader;
		try {
			loader = new_stage("/fxml/productOrder_endUser.fxml");
			productOrder_Controller productOrder = loader.getController();
			productOrder.setApp(product, Room, this, endUser);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * used to open cart stage
	 * call setapp method
	 * @param endUser
	 * @param Room
	 */
	public void Cart(EndUser endUser, room Room) {
		FXMLLoader loader;
		try {
			loader = new_stage("/fxml/cart.fxml");
			cart_Controller Cart = loader.getController();
			Cart.setApp(endUser, Room);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * method used by all methods above to create stage for the page
	 * returns loader for the page
	 * @param fxml
	 * @return
	 * @throws Exception
	 */
	public FXMLLoader new_stage(String fxml) throws Exception {
		Stage stage = new Stage();
		stage.setTitle("SuperStore");
		FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
		root = (Parent) loader.load();
		stage.setScene(new Scene(root));
		stage.show();
		stage.setOnCloseRequest( event -> {try {
			this.getSystem().serialize();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};} );
		return loader;
	}
	
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
