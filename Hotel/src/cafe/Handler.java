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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Handler {

	Database db = new Database();;
	//Cashier cash;
	//Waiter wait;
	static Menu menu;
	static Order order;
	static Customer cust;
	static Booking book;
	static Person user;
	
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
	private TextField price;
	@FXML
	private Label error;
	@FXML
	private Label error1;
	@FXML
	private Label error2;
	@FXML
	private ListView<String> list;
	@FXML
	private ListView<String> list1;
	@FXML
	private PasswordField var;
	
	@FXML
	public void Init() {
		db = new Database();
		book  = new Booking(20);
		db.addOrder(new Order(false,1,"dba"));
		db.addOrderItem(new OrderItem(1,4,new Item()));
		//db.addEmployee(new Employee("umer","yts","321","fg3844"));
		// cash = new Cashier("name", 20, "address", "35202-344", "0337654678",
		// "code_567");
		// wait = new Waiter("name12", 25, "address", "35202-656", "033763434",
		// "code_657");
	}

	@FXML
	public void confirmOrder() {
		if(price.getText().isBlank())
		{error.setText("Enter Order Number!!!"); return;}
		db.addOrder(order);

	}
	
	@FXML
	public void CancelOrder() {
		if(phone.getText().isBlank())
		{error.setText("Enter Order Number!!!"); return;}
		//db.addOrder(order);
		db.deleteOrder(Integer.parseInt(phone.getText()));
	}
	
	@FXML
	public void introItem() {
		

		if (identity.getText().isBlank() || password.getText().isBlank() || name.getText().isBlank()
				|| phone.getText().isBlank() || price.getText().isBlank() ) {
			error.setText("Fill all the blanks");
			return;
		}

		Item item = new Item(name.getText(), identity.getText(), password.getText());
		item.addSize(phone.getText(), Integer.parseInt(price.getText()));
		db = new Database();
		db.addItem(item);
		
	}
	
	@FXML
	public void addItem() throws IOException {
		if (entity.getValue() == null) {
			error.setText("Select all fields!!");
			return;
		}

	//	String size = cb2.getValue();
//		int index = size.indexOf(" ");
		int quant = Integer.parseInt(phone.getText());
		int id = Integer.parseInt(entity.getValue());
		//OrderItem orderItem = new OrderItem( entity.getValue(), size.substring(0, index), quant, price);
		db = new Database();
		Item item = db.getItem(id);
		item.setOtimes(item.getOtimes()+1);
		db.updateItem(item);
		OrderItem orderItem = new OrderItem(quant,item);
		//orderItem.display();
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
		cust.setTotal_orders(cust.getTotal_orders()+1);
		db.updateCustomer(cust);
		if(cb2.getValue().toString().equals("Cash"))
			{
			System.out.println("Go to Counter");
			db.addOrder(order);
			}
		else {
			if(name.getText().isBlank() || password.getText().isBlank())
				{error1.setText("Enter card details"); return;}
			else if(password.getText().toString().equals("123"))
				{System.out.println("Order Confirmed");
				order.setStatus(true);
				db.addOrder(order);
				}
			else 
			{error1.setText("Invalid Password"); return;}
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
		float total = order.getPrice();
		if(cust.getTotal_orders()%5==0)
			{
			System.out.println("discounted");
			total*=0.9; error2.setText("Discounted 10%");}
		error.setText(Float.toString(total));
		
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
			list.getItems().add(i.getItem().getCode() + "\t" + i.getItem().getSize() + "\t" + i.getQuantity() + "\t" + i.getItem().getPrice());

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
//		Item item = new Item("Karahi", "23", "BUTT KARAHI WITH SPIcE","small",200);
	//	Item item2 = new Item("Chicken", "24", "BUTT KARAHI WITH SPIcEs and salad","large",500);

//		System.out.println(menu.addItem(item));
		db = new Database();
		

		Vector<Item> itemss = new Vector<Item>();
		int j=-1;
		String name="";
		for(Item i: db.getAllItem())
			{
			itemss.add(i);
			if(i.getOtimes()>j)
				{
				j=i.getOtimes();
				name = i.getName();
				}
			}
		error1.setText(name);
		menu.setItems(itemss);
		// Vector<String> show=new Vector<String>();
		list.getItems().add("Id  Price  Code" + "\t" + "Name");
		list1.getItems().add("Description");
		for (Item i : menu.getItems()) {
			list.getItems().add(i.getId() +"  "+ i.getPrice()+"      "+i.getCode() + "\t" + i.getName());
			list1.getItems().add(i.getDescription());
			entity.getItems().add(Integer.toString(i.getId()));
		}
	}

	@FXML
	public void populateSize() {
		if (entity.getValue() == null) {
			error.setText("Select an Item");
			return;
		}
		if (!cb2.getItems().isEmpty()) {
			cb2.getItems().clear();
			return;
		}

		Vector<String> type = new Vector<String>();
		// type.add("Customer");
		// type.add("Cashier");
		//for (Item i : menu.getItems()) {
		//	if (i.getCode() == entity.getValue()) {
			//	for (Map.Entry<String, Integer> e : i.getSize().entrySet())
				//	cb2.getItems().add(e.getKey() + " " + e.getValue());
				//return;
			//}
		//}
	}

	@FXML
	public void populateEntity() {
		if (!entity.getItems().isEmpty()) {
			entity.getItems().clear();
			return;
		}

		Vector<String> type = new Vector<String>();
		type.add("Customer");
		type.add("Employee");

		entity.getItems().addAll(type);
	}

	@FXML
	public void populateMenu() {
		if (!entity.getItems().isEmpty()) {
			entity.getItems().clear();
			return;
		}

		Vector<String> type = new Vector<String>();
		type.add("See All Menus");
		//type.add("Fast Food");
		//type.add("Chinese");
		//type.add("Desert");
		//type.add("Beverages");

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
		user=null;
		if (type.equals("Employee"))			
			user = db.readEmployee(identity.getText());
		else	
			user = db.readCustomer(identity.getText());

		if(user==null)
				throw new UserException();
		
		String pass = user.getPassword();
		if (pass.equals(password.getText().toString()))

			if (type.equals("Employee"))			
				openPage("Employee");
			else
				{
				cust = (Customer) user;
				order = new Order(false, 1, cust.getCid());				
				openPage("selectMenu");
				}
		else throw new PasswordException();
	}

	@FXML
	public void SignUpUser() throws SQLException, IOException, NameException { // 1 Main Page

		if(name.getText().isBlank())
			throw new NameException();
		
		if (identity.getText().isBlank() || password.getText().isBlank()
				|| phone.getText().isBlank()) {
			error.setText("Fill all the blanks");
			return;
		}

		cust = new Customer(name.getText(), phone.getText(), password.getText(),identity.getText());

		order = new Order(false, 1, cust.getCid());
		//order = new Order(1, false, new Table(1, false), cust.getCid());		
		Thread t = new Thread(new Threader(cust));
		t.start();
		
		openPage("selectMenu");
		
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
	public void openAddItem() throws IOException {
		openPage("addItem");
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

