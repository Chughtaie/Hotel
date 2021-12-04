package cafe;

public class Customer extends Person {

	private Table table;

	public Customer(String name, int age, String address, String cnic, Table table) {
		super(name, age, address, cnic);
		this.setTable(table);
	}

	public Customer(String name, String cnic, Table table) {
		super(name, cnic);
		this.setTable(table);
	}
	
	public Customer(String name, Table table) {
		super(name);
		this.table = table;
	}

	public Table getTable() {
		return table;
	}
	public void setTable(Table table) {
		this.table = table;
	}
	
	
	
}
