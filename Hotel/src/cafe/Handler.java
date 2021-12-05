package cafe;

import java.util.Vector;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class Handler {
	
	Database db;
	Booking book;
	Cashier cash;
	Waiter wait;
	
	@FXML
	private AnchorPane CAFE;
	
	@FXML
	public void Init() {
		db = new Database();
		cash = new Cashier("name", 20, "address", "35202-344", "0337654678", "code_567");
		wait = new Waiter("name12", 25, "address", "35202-656", "033763434", "code_657");
	}
	
	@FXML
	public void login() {	// 1	Main Page
		int select = db.readCustomer("0333456", "Newpassword123");
		
		if(select==1)
		{
			// 3	Load Menu Page and populate Data from file
		}
		else if(select==4)
		{
			// 4	Admin Page
		}
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
