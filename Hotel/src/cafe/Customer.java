package cafe;

public class Customer extends Person {

	private Table table;
	private String password;
	


	public Customer(String name, int age, String address, String cnic, String phone,String password) {
		super(name, age, address, cnic, phone);
		//this.table = table;
		this.password = password;
	}
	
	public Customer(String name, String phone,String password) {
		super(name, phone);
		//this.table = table;
		this.password = password;
	}

	public Table getTable() {
		return table;
	}
	public void setTable(Table table) {
		this.table = table;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
