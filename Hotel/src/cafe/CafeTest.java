package cafe;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;

public class CafeTest {

	static Customer cust;
	static Order order;
	static OrderItem  orderItem;
	static Item item;
	@BeforeClass
	public static void start() {
		
		cust = new Customer("name","8hh7u","pass","cid");
		
		item = new Item("chips","34","Aloo Mix","small",500);
		
		orderItem = new OrderItem(1,5,item);
		orderItem.setId(12);
		
		order = new Order(false,3,"cid");
		order.setOrder_id(1);
		
		
	}

	@Test
	public void test1() {
		assertEquals(order.removeOrderItem(1), false);		
	}
	
	@Test
	public void test2() {
		order.addOrderItem(orderItem);
		assertEquals(order.removeOrderItem(12), true);		
	}
	
	@Test
	public void test3() {
		order.addOrderItem(orderItem);
		order.addOrderItem(orderItem);		
		order.calculateTotal();
		assertEquals(order.getPrice(), 5000.0,.5);		
	}

	@Test
	public void test4() {
		order.updateOrderItem(12,2);
		assertEquals(order.getOrder().elementAt(0).getQuantity(), 2);	
	}
	
	@Test
	public void test5() {
		order.updateOrderItem(12,2);
		order.calculateTotal();
		assertEquals(order.getPrice(), 2000.0,.5);		

	}
}