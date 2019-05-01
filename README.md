# Superstore_Project
A Superstore management system made with JavaFX. <br> Superstore consists of stores and warehouses located in different cities.
There are four types of Users involved - SuperUser, StoreAdmin, WarehouseAdmin and EndUser. The functionality of the project is explained below with the gif.

## Requirement
`Java 8 or above` <br>
`javafx`<br>
`SceneBuilder` (optional)

## Functionality

![GIF FOR PROJECT](https://github.com/Mohit17067/Superstore_Project/blob/master/Superstore-Management-System/project.gif "GIF for project")
### Login Page
The Application starts with a Login Page with the user types on the left and the login bars on the right.
  * Select the type of User from the left. Login fields can't be filled without selecting the user type. On pressing Login,       an alert to select the user pops up.
  * Both fields are required and an alert is there if a field is empty. Invalid data in the fields is also not accepted.

### SuperUser
There is one SuperUser for the entire project with userID and password - "SUser" (same :P).<br>
  * SuperUser page shows the list of all stores and warehouses and a button to open a warehouse/store on selecting it.<br>
  * Super User has the ability to create a store/warehouse.<br>
**Every store is linked with one warehouse. Whenever quantity of any item in the store becomes 0, EOQ number of items are       orders from the attached warehouse.**<br>
  * UpdateLink button updates the link of a store with a warehouse.

### Warehouse Admin
  * Warehouse Page depicts the list of category of items present in the warehouse.<br>
**Every category is divided into subCategories and every subCategory is divided in products**<br>
  * Warehouse Admin can create, update and delete a category, subCategory and Product.
  * Warehouse Admin can also view the data of other warehouses. `Other warehouses` button is used for this.
  
### Store Admin
  Store Admin has similar functionality as that of a Warehouse Admin.<br>
**Unlike any Warehouse Admin, a store admin can not view data of other stores**
  
### End User
EndUser login as a Guest User (no userID and password required at the login page).
  * First Page depicts a list of stores. EndUser can enter in any store for shopping.
  * A store shows the list of categories. Opening any category shows the list of subCategories and then products.
  * EndUser can select a product and add the units of the product in the cart.
  * Cart shows the list of items along with their quantity and price. Total price is shown in the right bar.
  * On checkout, the purchased units of items are removed from the store. If number of items in a store reaches 0, EOQ items 
    ordered as explained above.<br>
**If the item is also not available in the linked warehouse, the warehouse tries to search that item in other warehouses and returns a success response if the item is found. The quantity used is then reduced from the appropriate warehouse**

**_The project uses Serialization and Deserialization. This means closing one instance of the project stores the work done in that instance in a text file `db` and starting the project again brings the last work done from the same file into the project._** To know more, Google it :p.
