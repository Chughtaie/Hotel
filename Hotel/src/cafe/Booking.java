package cafe;

import java.util.Timer;
import java.util.Vector;

public class Booking {

	private Vector<Table> table;
	
	public void populate(Table table){	
		if(table!=null) this.table.add(table);
		else 
			for(int i=0;i<20;i++)
				this.table.add(new Table(i+1,false));		
	}
	
	public Table book() {
		
		for( Table i : table){
			if(!i.isStatus())
			{
				i.setStatus(true);
				return i;
			}
		}
		System.out.println("No Table's Available");
		return null;	
	}
	
	public Table book(int no) {
		Timer time = new Timer();
		for( Table i : table){
			if(i.getTable_no()==no && !(i.isStatus()))
			{
				i.setStatus(true);
				return i;
			}
		}
		System.out.println("No Table's Available");
		return null;	
	}
	
	public void freeTable(Table table) {
		table.setStatus(false);
	}
	
}
