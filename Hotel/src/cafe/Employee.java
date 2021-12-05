package cafe;

import java.util.Date;

public class Employee extends Person {

	private String emp_id;
	private String post;
	private Date join_date;
	


	public Employee(String name, int age, String address, String cnic, String phone, String emp_code, String post) {
		super(name, age, address, cnic, phone);
		this.emp_id = emp_code;
		this.post = post;
		this.join_date = new Date();
	}
	
	public String getEmp_code() {
		return emp_id;
	}
	public void setEmp_code(String emp_code) {
		this.emp_id = emp_code;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public Date getJoin_date() {
		return join_date;
	}
	public void setJoin_date(Date join_date) {
		this.join_date = join_date;
	}	
	
}
