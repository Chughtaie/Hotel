package cafe;

import java.util.HashMap;
import java.util.Map;

public class Item {

	private String name;
	private String code;
	private Map<String,Integer> size;	//small 300 (Rs)
	private String description;
	
	
	public Item(String name, String code, String description) {
		super();
		this.name = name;
		this.code = code;
		this.setDescription(description);
		size = new HashMap<String,Integer>();
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
	public Map<String, Integer> getSize() {
		return size;
	}
	public void setSize(Map<String, Integer> size) {
		this.size = size;
	}
	public void addSize(String size,Integer price) {
		this.size.put(size, price);
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void show() {
		for(Map.Entry<String, Integer> e : size.entrySet() )
			System.out.println(code + "\t" + name + "(" + description + ")\t" + e.getKey()+": "+e.getValue());
	}
	
}
