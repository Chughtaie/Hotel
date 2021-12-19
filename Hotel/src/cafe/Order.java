package cafe;

import java.util.Vector;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.persistence.Table;

@Entity
@Table(name="Ordera")
public class Order {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int order_id;
	private boolean status;
	private int tablee;
	private int total_price;
	private String cid;
	//Dictionary<Item, Integer> item;
	//@OneToMany
	@Transient
	Vector<OrderItem> order;
	
	Order(){}
	public Vector<OrderItem> getOrder() {
		return order;
	}

	public void setOrder(Vector<OrderItem> order) {
		this.order = order;
	}

	
	
	 
	public Order( boolean status, int table_no,String cid) {
		super();
		this.status = status;
		this.tablee = table_no;
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
	public int getTable_no() {
		return tablee;
	}
	public void setTable_no(int table_no) {
		this.tablee = table_no;
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
			total_price += i.getItem().getPrice() *i.getQuantity();
	}


}
