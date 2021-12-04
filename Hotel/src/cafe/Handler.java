package cafe;

import java.util.Vector;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class Handler {
	
	Database db;
	Vector<Menu> menu;
	
	@FXML
	private AnchorPane CAFE;
	
	 
	
	@FXML
	public void Init() {
		db = new Database();
		
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
	public void registerNewCustomer() {	// 2	Register New Customer
		db.addCustomer(new Customer("Ahad","0333456","Newpassword123"));
		//Back to main Page
	}
	
	@FXML
	public void placeOrder() {	// 3	On Menu Page
		
		
	}
	

	
}
