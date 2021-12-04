package cafe;

public class Cashier extends Employee {

	private Booking book;
	
	public Cashier(String name, int age, String address, String cnic, String phone, String emp_code) {
		super(name, age, address, cnic, phone, emp_code, "Manager");
		book = new Booking();
		book.populate(null);
		// TODO Auto-generated constructor stub
	}
	

	

	

}
