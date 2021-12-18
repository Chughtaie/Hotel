package cafe;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer extends Person {
	@Id
	//@GeneratedValue (strategy = GenerationType.IDENTITY)
	private String cid;
	private int tablee;
	private String password;
	private int total_orders;
	
	Customer(){ }
	
	public Customer(String name, int age, String address, String cnic, String phone,String password,String cid) {
		super(name, age, address, cnic, phone);
		//this.table = table;
		this.password = password;
		this.setCid(cid);
		setTotal_orders(0);
	}
	
	public Customer(String name, String phone,String password,String cid) {
		super(name, phone);
		//this.table = table;
		this.password = password;
		this.cid = cid;
	}

	public int getTable() {
		return tablee;
	}
	public void setTable(int table) {
		this.tablee = table;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public int getTotal_orders() {
		return total_orders;
	}

	public void setTotal_orders(int total_orders) {
		this.total_orders = total_orders;
	}
	
}
