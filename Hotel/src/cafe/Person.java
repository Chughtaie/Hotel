package cafe;

public class Person {

	private String name;
	private int age;
	private String address;
	private String cnic;
	


	
	
	public Person(String name, int age, String address, String cnic) {
		this.name = name;
		this.age = age;
		this.address = address;
		this.setCnic(cnic);
	}
	
	
	public Person(String name, String cnic) {
		this.name = name;
		this.setCnic(cnic);
	}
	
	public Person(String name) {
		super();
		this.name = name;
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
	
}
