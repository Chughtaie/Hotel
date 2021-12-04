package cafe;

import java.util.Vector;

public class Booking {

	Vector<Table> table;
	
	Booking(){
		
		for(int i=0;i<20;i++)
			table.add(new Table(i+1,false));
		
	}
	
	
}
