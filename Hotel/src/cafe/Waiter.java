package cafe;

import java.util.Queue;

public class Waiter extends Employee {

	private Queue<Order> order;

	public Waiter(String name, int age, String address, String cnic, String phone, String emp_code) {
		super(name, age, address, cnic, phone, emp_code, "Waiter");
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
