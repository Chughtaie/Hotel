package cafe;

import java.util.Date;
import java.util.Queue;

public class Waiter extends Employee {

	private Queue<Order> order;

	public Waiter(String name, int age, String address, String cnic, String emp_code, String post, Date join_date,
			Queue<Order> order) {
		super(name, age, address, cnic, emp_code, post, join_date);
		this.setOrder(order);
	}

	public Queue<Order> getOrder() {
		return order;
	}

	public void setOrder(Queue<Order> order) {
		this.order = order;
	}
	
	public void addOrder(Order order) {
		this.order.add(order);		
	}
	public void delOrder() {
		this.order.remove();
	}
}
