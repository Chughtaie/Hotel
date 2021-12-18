package cafe;

import java.io.IOException;
import java.util.Map;
import java.util.Vector;

import cafe.App6;

import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Handler {

	Database db;
	//Cashier cash;
	//Waiter wait;
	static Menu menu;
	static Order order;
	static Customer cust;
	static Booking book;
	
	
	@FXML
	private AnchorPane CAFE;
	@FXML
	private ChoiceBox<String> entity;
	@FXML
	private ChoiceBox<String> cb2;
	@FXML
	private TextField name;
	@FXML
	private TextField phone;
	@FXML
	private TextField identity;
	@FXML
	private TextField password;
	@FXML
	private Label error;
	@FXML
	private Label error1;
	@FXML
	private ListView<String> list;
	@FXML
	private ListView<String> list1;
	
	
	@FXML
	public void Init() {
		db = new Database();
		book  = new Booking(20);
		// cash = new Cashier("name", 20, "address", "35202-344", "0337654678",
		// "code_567");
		// wait = new Waiter("name12", 25, "address", "35202-656", "033763434",
		// "code_657");
	}

	@FXML
	public void confirmOrder() {
		//order.confirm
	}
	
	@FXML
	public void addItem() throws IOException {
		if (cb2.getValue() == null) {
			error.setText("Select all fields!!");
			return;
		}

		String size = cb2.getValue();
		int index = size.indexOf(" ");
		int quant = Integer.parseInt(phone.getText().toString());
		int price = Integer.parseInt(size.substring(index + 1));
		OrderItem orderItem = new OrderItem(1, entity.getValue(), size.substring(0, index), quant, price);
		orderItem.display();
		order.addOrderItem(orderItem);
		// cb2.getItems().clear();
		// entity.getItems().clear();
		// phone.clear();

		openPage("Menu");
	}
	
	@FXML
	public void payInvoice() throws IOException {
		if(cb2.getValue()==null )
		{	error1.setText("Select a Payment Type"); return;	}
		if(entity.getValue()==null )
		{	error1.setText("Select a Table"); return;	}
		
		cust.setTable(book.book(Integer.parseInt(entity.getValue().toString())).getTable_no());
		
		if(cb2.getValue().toString().equals("Cash"))
			System.out.println("Go to Counter");
		else {
			if(name.getText().isBlank() || password.getText().isBlank())
				{error1.setText("Enter card details"); return;}
			else if(password.getText().toString().equals("123"))
				System.out.println("Order Confirmed");
				order.setStatus(true);
				
		}
		//order.save
		openPage("Main");
	}
	
	@FXML
	public void populateTotalPrice() {
		if (order.order.isEmpty()) {
			error.setText("No Items selected");
			return;
		}
		order.calculateTotal();
		error.setText(Float.toString(order.getPrice()));
		
		if(cb2.getItems().isEmpty()) {
		cb2.getItems().add("Cash");
		cb2.getItems().add("Card");
		}
		if(entity.getItems().isEmpty()) {
			for(Table i:book.getTable())
				if(!i.isStatus())
					//System.out.println(i.getTable_no());
					entity.getItems().add(Integer.toString(i.getTable_no()));					
		}
	}
	
	@FXML
	public void populateOrder() {
		if (order.order.isEmpty()) {
			error.setText("No Items selected");
			return;
		}
		if (!list.getItems().isEmpty()) {
			list.getItems().clear();
			return;
		}

		list.getItems().add("Code\t" + "Size\t" + "Quantity\t" + "Price");
		for (OrderItem i : order.getOrder())
			list.getItems().add(i.getItemCode() + "\t" + i.getSize() + "\t" + i.getQuantity() + "\t" + i.getPrice());

	}

	@FXML
	public void populateMenuItems() {
		if (!entity.getItems().isEmpty()) {
			entity.getItems().clear();
			list.getItems().clear();
			list1.getItems().clear();
			return;
		}

		menu = new Menu(entity.getValue(), 1);
		Item item = new Item("Karahi", "23", "BUTT KARAHI WITH SPIcE");
		item.addSize("small", 200);
		item.addSize("large", 400);
		Item item2 = new Item("Karahies", "24", "BUTT KARAHI WITH SPIcEs and salad");
		item2.addSize("medium", 700);
		System.out.println(menu.addItem(item));
		menu.addItem(item2);
		// Vector<String> show=new Vector<String>();
		list.getItems().add("Code" + "\t" + "Name");
		list1.getItems().add("Description");
		for (Item i : menu.getItems()) {
			list.getItems().add(i.getCode() + "\t" + i.getName());
			list1.getItems().add(i.getDescription());
			entity.getItems().add(i.getCode());
		}
	}

	@FXML
	public void populateSize() {
		if (entity.getValue() == null) {
			error.setText("Select a fucking Item");
			return;
		}
		if (!cb2.getItems().isEmpty()) {
			cb2.getItems().clear();
			return;
		}

		Vector<String> type = new Vector<String>();
		// type.add("Customer");
		// type.add("Cashier");
		for (Item i : menu.getItems()) {
			if (i.getCode() == entity.getValue()) {
				for (Map.Entry<String, Integer> e : i.getSize().entrySet())
					cb2.getItems().add(e.getKey() + " " + e.getValue());
				return;
			}
		}
	}

	@FXML
	public void populateEntity() {
		if (!entity.getItems().isEmpty()) {
			entity.getItems().clear();
			return;
		}

		Vector<String> type = new Vector<String>();
		type.add("Customer");
		type.add("Manager");

		entity.getItems().addAll(type);
	}

	@FXML
	public void populateMenu() {
		if (!entity.getItems().isEmpty()) {
			entity.getItems().clear();
			return;
		}

		Vector<String> type = new Vector<String>();
		type.add("Desi");
		type.add("Fast Food");
		type.add("Chinese");
		type.add("Desert");
		type.add("Beverages");

		entity.getItems().addAll(type);
	}

	@FXML
	public void loginUser() throws SQLException, IOException { // 1 Main Page

		if (identity.getText().isBlank() || password.getText().isBlank() || entity.getValue() == null) {
			error.setText("Fill all the blanks");
			return;
		}

		String type = entity.getValue().toString();
		db = new Database();
		 cust = db.readCustomer(identity.getText());
		//cust = new Customer("abdullah", "4656456", "f4cc", "4343");

		String pass = cust.getPassword();
		if (pass.equals(password.getText().toString()))
			if (type.equals("Manager"))
				openPage("Manager");
			else
				{
				order = new Order(1, false, new Table(1, false), cust.getCid());				
				openPage("selectMenu");
				}
	}

	@FXML
	public void SignUpUser() throws SQLException, IOException { // 1 Main Page

		if (identity.getText().isBlank() || password.getText().isBlank() || name.getText().isBlank()
				|| phone.getText().isBlank()) {
			error.setText("Fill all the blanks");
			return;
		}

		cust = new Customer(name.getText(), phone.getText(), password.getText(),identity.getText());
		db=new Database();
		db.addCustomer(cust);
		//order = new Order(1, false, new Table(1, false), cust.getCid());		

		//openPage("selectMenu");
		
	}

	@FXML
	public void openMain(ActionEvent event) throws IOException {

		Parent window;
		window = FXMLLoader.load(getClass().getResource("Main.fxml"));
		Stage mainStage;
		// mainStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		mainStage = App6.pStage;
		mainStage.getScene().setRoot(window); // we dont need to change whole sceene, only set new root.

	}

	@FXML
	public void openCashier() throws IOException {

		Parent window;
		window = FXMLLoader.load(getClass().getResource("loginCashier.fxml"));
		Stage mainStage;
		// mainStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		mainStage = App6.pStage;
		mainStage.getScene().setRoot(window); // we dont need to change whole sceene, only set new root.

	}

	@FXML
	public void openSelectMenu(ActionEvent event) throws IOException {

		Parent window;
		window = FXMLLoader.load(getClass().getResource("selectMenu.fxml"));
		Stage mainStage;
		// mainStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		mainStage = App6.pStage;
		mainStage.getScene().setRoot(window); // we dont need to change whole sceene, only set new root.

	}

	@FXML
	public void openSignUp(ActionEvent event) throws IOException {

		Parent window;
		window = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
		Stage mainStage;
		// mainStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		mainStage = App6.pStage;
		mainStage.getScene().setRoot(window); // we dont need to change whole sceene, only set new root.

	}

	public void openPage(String ab) throws IOException {

		String opens = ab + ".fxml";
		System.out.println(opens);

		Parent window;
		window = FXMLLoader.load(getClass().getResource(opens));
		Stage mainStage;
		// mainStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		mainStage = App6.pStage;
		mainStage.getScene().setRoot(window); // we dont need to change whole sceene, only set new root.

	}

	@FXML
	public void openOrderItems() throws IOException {
		openPage("Order");
	}

	@FXML
	public void openCheck() throws IOException {
		openPage("Check");
	}

	@FXML
	public void openMenu() throws IOException {

		if (entity.getValue() == null) {
			error.setText("Select a Damn Menu!!");
			return;
		}
		openPage("Menu");

		// if(entity.getValue().toString())
	}

}

