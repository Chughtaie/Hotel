package cafe;

public class Manager extends Employee {

	private Booking book;
	
	public Manager(String name, int age, String address, String cnic, String phone, String emp_code) {
		super(name, age, address, cnic, phone, emp_code, "Manager");
		book = new Booking();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
