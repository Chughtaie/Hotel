package cafe;

public class Customer extends Person {

	private Table table;



	public Customer(String name, int age, String address, String cnic, String phone, Table table) {
		super(name, age, address, cnic, phone);
		this.table = table;
	}
	
	public Customer(String name, String phone, Table table) {
		super(name, phone);
		this.table = table;
	}

	public Table getTable() {
		return table;
	}
	public void setTable(Table table) {
		this.table = table;
	}
	
}
