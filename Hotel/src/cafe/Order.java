package cafe;

import java.util.Dictionary;
import java.util.Vector;

public class Order {
	
	private int order_id;
	private boolean status;
	private Table table;
	//Dictionary<Item, Integer> item;
	Vector<OrderItem> order;
	private int total_price;
	private String cid;
	
	
	
	public Order(int order_id, boolean status, Table table_no,String cid) {
		super();
		this.order_id = order_id;
		this.status = status;
		this.table = table_no;
		this.total_price = 0;
		this.setCid(cid);
	}
	
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public float getPrice() {
		return total_price;
	}
	public void setPrice(int price) {
		this.total_price = price;
	}
	public Table getTable_no() {
		return table;
	}
	public void setTable_no(Table table_no) {
		this.table = table_no;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	
	
	
	public void updateOrderItem(int id,int quantity) {
		for(OrderItem i:order) {
			if(i.getId()==id)
				{i.setQuantity(quantity); return;}
		}
	}	
	public boolean removeOrderItem(int id) {
		for(OrderItem i:order) {
			if(i.getId()==id)
				return order.remove(i);
		}
		return false;
	}
	public int addOrderItem(OrderItem order) {
		this.order.add(order);
		return calculateTotal(order.getPrice());
	}
	public int calculateTotal(int price) {
		total_price += price;
		return total_price;
	}


}
