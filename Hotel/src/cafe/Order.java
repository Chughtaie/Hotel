package cafe;

import java.util.Vector;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Order {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int order_id;
	private boolean status;
	private Table table;
	private int total_price;
	private String cid;
	//Dictionary<Item, Integer> item;
	Vector<OrderItem> order;
	
	
	public Vector<OrderItem> getOrder() {
		return order;
	}

	public void setOrder(Vector<OrderItem> order) {
		this.order = order;
	}

	
	
	
	public Order(int order_id, boolean status, Table table_no,String cid) {
		super();
		this.order_id = order_id;
		this.status = status;
		this.table = table_no;
		this.total_price = 0;
		this.setCid(cid);
		order = new Vector<OrderItem>();
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
	public void addOrderItem(OrderItem order) {
		this.order.add(order);
//		return calculateTotal(order.getPrice());
	}
	public void calculateTotal() {
		total_price = 0;
		for(OrderItem i:order)
			total_price += i.getPrice()*i.getQuantity();
	}


}
