package cafe;

public class Table {

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
