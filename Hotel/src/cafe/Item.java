package cafe;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Item {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	private int otimes;
	private String name;
	@Column(nullable=false)
	private String code;
	//private Map<String,Integer> size;	//small 300 (Rs)
	private String size;
	private Integer price;
	private String description;
	
	Item(){}

	
	public Item(String name, String code, String description) {
		super();
		this.name = name;
		this.code = code;
		this.setDescription(description);
		otimes = 0;
		//size = new HashMap<String,Integer>();
	}
	
	public Item(String name, String code, String description, String size, Integer price) {
		super();
		this.name = name;
		this.code = code;
		this.size = size;
		this.price = price;
		this.description = description;
		otimes = 0;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void addSize(String size,int price) {
		this.size = size;
		this.price = price;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public void displayItem() {
		System.out.println(code + "\t" + name + "(" + description + ")\t" + size +": "+price);
	}


	public int getOtimes() {
		return otimes;
	}


	public void setOtimes(int otimes) {
		this.otimes = otimes;
	}
	
}
