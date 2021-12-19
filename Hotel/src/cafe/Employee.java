package cafe;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Employee extends Person {

	@Id
	private String emp_id;
	private String post;
	private Date join_date;
//	private String password;


	public Employee(String name, int age, String address, String cnic, String phone, String emp_code, String post,String password) {
		super(name, age, address, cnic, phone, password);
		this.emp_id = emp_code;
		this.post = post;
		this.join_date = new Date();
	}
	
	Employee(){
		
	}
	public Employee(String name,String emp_id, String password,String phone) {
		super(name,phone,password);
		this.emp_id = emp_id;
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
