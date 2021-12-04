package cafe;

public class Person {

	private String name;
	private int age;
	private String address;
	private String cnic;
	private String phone;


	
	public Person(String name, String phone) {
		super();
		this.name = name;
		this.phone = phone;
	}

	public Person(String name, int age, String address, String cnic, String phone) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
		this.cnic = cnic;
		this.phone = phone;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}


	public String getCnic() {
		return cnic;
	}


	public void setCnic(String cnic) {
		this.cnic = cnic;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
