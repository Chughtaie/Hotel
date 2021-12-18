package cafe;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;


public class Database {

	
	 public Customer readCustomer(String identity) throws SQLException {
		ResultSet rs = read("select * from Customer where identity = '" + identity + "')");
		Customer cust = new Customer(rs.getString("name"),rs.getString("phone"),rs.getString("password"),rs.getString("cid"));
		return cust;
	}
	
	public boolean addCustomer(Customer customer) throws IOException, SQLException{	// Add in Oracle (true=ok , false=already exist/Invalid User)
	
		String query = "insert into Customer(name,phone,password,cid) values('" + customer.getName() + "'," + customer.getPhone() +"," +
					customer.getPassword() +",'" + customer.getCid() + "')";
			add(query);
			
		return true;
	}
	
	public void add(String query)throws IOException, SQLException {
		
		System.out.println(query);
		try 
		{
			//step1 load the driver class  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			  
			//step2 create  the connection object  
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@localhost:1521:xe","system","tiger1234");  
			  
			//step3 create the statement object  
			Statement stmt=con.createStatement();  
			stmt.executeQuery(query);	
    		con.close();
		}
    	catch(ClassNotFoundException e)
    	{
    		System.out.println("Diver not loaded..");
    	}
    	catch(SQLException e)
    	{
    		System.out.println("Connection not established...");
    	}
	} 

	public ResultSet read(String query) {
		try 
		{
			//step1 load the driver class  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			  
			//step2 create  the connection object  
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@localhost:1521:xe","system","tiger1234");  
			  
			Statement stmt=con.createStatement();  
			ResultSet rs = stmt.executeQuery(query);
			/*
    		Vector<String> data = new Vector<String>() ;
			while(rs.next()) {
				String reg = rs.getString(name);
				data.add(reg);
				System.out.println(reg);
			}*/
			//System.out.println("Connection Established");
    		con.close();
    		
    		return rs;
		}
    	catch(ClassNotFoundException e)
    	{
    		System.out.println("Diver not loaded..");
    	}
    	catch(SQLException e)
    	{
    		System.out.println("Connection not established...");
    	}
		
		return null;
		
	}
		
}
