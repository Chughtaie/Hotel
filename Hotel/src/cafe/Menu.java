package cafe;

import java.util.Vector;

public class Menu {

	private String name;
	private String num;
	private Vector<Item> items;
	
	
	
	public Menu(String name, String num) {
		super();
		this.name = name;
		this.num = num;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public Vector<Item> getItems() {
		return items;
	}
	public void setItems(Vector<Item> items) {
		this.items = items;
	}
	
	public boolean addItem(Item item) {
		return items.add(item);
	}
	public boolean delItem(Item item) {
		return items.remove(item);
	}
	public void show() {
		for(Item i : items)
			i.show();
	}
}
