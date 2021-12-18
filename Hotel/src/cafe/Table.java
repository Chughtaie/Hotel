package cafe;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Table {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int table_no;
	private boolean status;
	

	public Table(int table_no, boolean status) {
		super();
		this.table_no = table_no;
		this.status = status;
	}
	public int getTable_no() {
		return table_no;
	}
	public void setTable_no(int table_no) {
		this.table_no = table_no;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
}
