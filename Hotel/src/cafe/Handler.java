package cafe;

import java.io.IOException;
import java.util.Vector;

import cafe.App6;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Handler {
	
	Database db;
	Booking book;
	Cashier cash;
	Waiter wait;
	
	@FXML
	private AnchorPane CAFE;
	@FXML
	private Button loginCust;
	@FXML
	private Button loginCash;
	
	@FXML
	public void Init() {
		db = new Database();
		cash = new Cashier("name", 20, "address", "35202-344", "0337654678", "code_567");
		wait = new Waiter("name12", 25, "address", "35202-656", "033763434", "code_657");
	}
	
	@FXML
	public void openCashier(ActionEvent event) throws IOException {
	
		Parent window;
	    window = FXMLLoader.load(getClass().getResource("loginCashier.fxml"));
	    Stage mainStage;
	    //mainStage = (Stage)  ((Node)event.getSource()).getScene().getWindow();
	    mainStage = App6.pStage;
	    mainStage.getScene().setRoot(window); //we dont need to change whole sceene, only set new root.
	    
	}
	
	
	@FXML
	public void openCustomer(ActionEvent event) throws IOException {
	
		Parent window;
	    window = FXMLLoader.load(getClass().getResource("loginCustomer.fxml"));
	    Stage mainStage;
	    //mainStage = (Stage)  ((Node)event.getSource()).getScene().getWindow();
	    mainStage = App6.pStage;
	    mainStage.getScene().setRoot(window); //we dont need to change whole sceene, only set new root.
	    
	}
	
	
	@FXML
	public void loginCustomer() {	// 1	Main Page
		//int select = db.readCustomer("0333456", "Newpassword123");

	}
	
	@FXML
	public void loginCashier() {	// 1	Main Page
	}
	
	@FXML
	public void regCustomer() {	// 2	Register New Customer
		db.addCustomer(new Customer("Ahad","0333456","Newpassword123"));
		//Back to main Page
	}
	
	@FXML
	public void showMenu() {

		int menu_id=1; 
		
		Menu menu; //populate from DB
		if(menu_id==1)
			menu = new Fast_Food(menu_id);
		else if(menu_id==2)
			menu = new Desi(menu_id);
		
		
	}
	
	

	
	@FXML
	public void placeOrder() {	// 3	On Menu Page
		
		int orderId=1;	//get from Database
		int table_no = 3;	//get from checkbox
		String cid = "d34hd";
		
		Order order = new Order(orderId,false,book.book(table_no),cid);
		int orderItemId = 1;
		while(true) {

			String item_code = "254"; 	//Select from menu
			String size = "small";	//select from choicebox
			int quantity = 2;		//Select from GUI				
			int price = db.getPrice(item_code,size); //database
			
			order.addOrderItem(new OrderItem(item_code,size,quantity,price,orderItemId));
			orderItemId++;
			break;
		}	
	}
	
	@FXML
	public void cancelOrder() {
		
		int order_id = 3;
		db.cancelOrder(order_id);
	}
	
	
	@FXML
	public int orderDelivery() {
		
		return 1;
	} 
	

	
}
