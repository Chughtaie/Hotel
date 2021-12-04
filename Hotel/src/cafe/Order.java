package cafe;

import java.util.Dictionary;

public class Order {
	
	private int order_id;
	private boolean status;
	private Table table;
	Dictionary<Item, Integer> item;
	private float total_price;
	
	
	
	
	public Order(int order_id, boolean status, Table table_no, Dictionary<Item, Integer> item, float price) {
		super();
		this.order_id = order_id;
		this.status = status;
		this.table = table_no;
		this.item = item;
		this.total_price = price;
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
	public void setPrice(float price) {
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
	

	
}
