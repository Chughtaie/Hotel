package cafe;

import java.util.Dictionary;

public class Item {

	private String name;
	private String code;
	private Dictionary<String,Integer> size;
	
	
	
	public Item(String name, String code, Dictionary<String, Integer> size) {
		super();
		this.name = name;
		this.code = code;
		this.size = size;
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
	public Dictionary<String, Integer> getSize() {
		return size;
	}
	public void setSize(Dictionary<String, Integer> size) {
		this.size = size;
	}
	public void addSize(String size,Integer price) {
		this.size.put(size, price);
	}

	
		

	
	
	
}
