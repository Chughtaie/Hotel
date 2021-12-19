package cafe;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * @author Mr.Chughtai
 *
 */
/**
 * @author Mr.Chughtai
 *
 */
@Entity
public class OrderItem {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	private int order_id;
	private int quantity;
	@Transient
	private Item item;
	
	
	OrderItem(){}
	public OrderItem(int order_id, int quantity, Item item) {
		super();
		this.order_id = order_id;
		this.quantity = quantity;
		this.item = item;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public OrderItem(int quantity, Item item) {
		super();
		this.quantity = quantity;
		this.item = item;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
/*
	@Column(nullable=false)
	private String itemCode;
	private String size;
	private int quantity;
	private int price;
	
	public OrderItem(String itemCode, String size, int quantity, int price) {
		super();
		this.itemCode = itemCode;
		this.size = size;
		this.quantity = quantity;
		this.price = price;
	}
	
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void display() {
		System.out.println(itemCode+"\t"+size+"\t"+quantity+"\t"+price);
	}
	*/
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

}
