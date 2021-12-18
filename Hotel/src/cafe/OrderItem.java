package cafe;

/**
 * @author Mr.Chughtai
 *
 */
/**
 * @author Mr.Chughtai
 *
 */
public class OrderItem {

	private int id;
	private String itemCode;
	private String size;
	private int quantity;
	private int price;
	
	public OrderItem(int id,String itemCode, String size, int quantity, int price) {
		super();
		this.itemCode = itemCode;
		this.size = size;
		this.quantity = quantity;
		this.price = price;
		this.setId(id);
		
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
		return price*quantity;
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
}
