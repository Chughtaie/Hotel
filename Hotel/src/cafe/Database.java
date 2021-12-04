package cafe;

public class Database {

	public boolean addCustomer(Customer customer){	// Add in Oracle (true=ok , false=already exist/Invalid User)
		return true;
	}
	
	public int readCustomer(String phone,String password) { // Read from Oracle (1=ok , 2=no user , 3=incorrect password , 4=Admin(abdul mannan))

		return 1;
	}
}
