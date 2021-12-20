package cafe;

public class Threader implements Runnable {

	Customer cust;
	Threader(Customer c){
		cust = c;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Database db = new Database();
		db.addCustomer(cust);
	}	
}
