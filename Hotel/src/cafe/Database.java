package cafe;

import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Database {
	
	
	public void addCustomer(Customer customer) {
		  	Configuration con = new Configuration();
	        con.configure().addAnnotatedClass(Customer.class);
	        SessionFactory sf= con.buildSessionFactory();
	        Session session= sf.openSession();
	        Transaction trans= session.beginTransaction();
	        
			session.save(customer);
			trans.commit();
	}
	public void updateCustomer(Customer customer) {
	  	Configuration con = new Configuration();
        con.configure().addAnnotatedClass(Customer.class);
        SessionFactory sf= con.buildSessionFactory();
        Session session= sf.openSession();
        Transaction trans= session.beginTransaction();
        
		session.update(customer);
		trans.commit();
}

	public Customer readCustomer(String identity) {
	  	Configuration con = new Configuration();
        con.configure().addAnnotatedClass(Customer.class);
        SessionFactory sf= con.buildSessionFactory();
        Session session= sf.openSession();
        Transaction trans= session.beginTransaction();
        
		Customer customer = session.get(Customer.class,identity);
		System.out.println(customer.getName());
		trans.commit();
		return customer;
	}

	public Employee readEmployee(String identity) {
	  	Configuration con = new Configuration();
        con.configure().addAnnotatedClass(Employee.class);
        SessionFactory sf= con.buildSessionFactory();
        Session session= sf.openSession();
        Transaction trans= session.beginTransaction();
        
		Employee emp = session.get(Employee.class,identity);
		System.out.println(emp.getName());
		trans.commit();
		return emp;
	}

	public void addEmployee(Employee emp) {
	  	Configuration con = new Configuration();
        con.configure().addAnnotatedClass(Employee.class);
        SessionFactory sf= con.buildSessionFactory();
        Session session= sf.openSession();
        Transaction trans= session.beginTransaction();
        
        session.save(emp);
		trans.commit();

	}
	
	public void addItem(Item item) {
	  	Configuration con = new Configuration();
        con.configure().addAnnotatedClass(Item.class);
        SessionFactory sf= con.buildSessionFactory();
        Session session= sf.openSession();
        Transaction trans= session.beginTransaction();
        
		session.save(item);
		trans.commit();
	}
	public void updateItem(Item item) {
	  	Configuration con = new Configuration();
        con.configure().addAnnotatedClass(Item.class);
        SessionFactory sf= con.buildSessionFactory();
        Session session= sf.openSession();
        Transaction trans= session.beginTransaction();
        
		session.update(item);
		trans.commit();
	}
	
	public Item getItem(int id) {
	  	Configuration con = new Configuration();
        con.configure().addAnnotatedClass(Item.class);
        SessionFactory sf= con.buildSessionFactory();
        Session session= sf.openSession();
        Transaction trans= session.beginTransaction();
        
		Item item = session.get(Item.class,id);
		trans.commit();
		return item;
	}
	
	public List<Item> getAllItem() {
	  	Configuration con = new Configuration();
        con.configure().addAnnotatedClass(Item.class);
        SessionFactory sf= con.buildSessionFactory();
        Session session= sf.openSession();
        Transaction trans= session.beginTransaction();
        
        CriteriaBuilder builder = session.getCriteriaBuilder();

        // Create CriteriaQuery
        CriteriaQuery<Item> criteria = builder.createQuery(Item.class);

        // Specify criteria root
        criteria.from(Item.class);

        // Execute query
        List<Item> itemList = session.createQuery(criteria).getResultList();

        
		//Item item = session.get(Item.class,id);
		trans.commit();
		return itemList;
	}

	public void addOrderItem(OrderItem orderitem) {
	  	Configuration con = new Configuration();
        con.configure().addAnnotatedClass(OrderItem.class);
        SessionFactory sf= con.buildSessionFactory();
        Session session= sf.openSession();
        Transaction trans= session.beginTransaction();
        
		session.save(orderitem);
		trans.commit();
	}

	public void addOrder(Order order) {
	  	Configuration con = new Configuration();
        con.configure().addAnnotatedClass(Order.class);
        SessionFactory sf= con.buildSessionFactory();
        Session session= sf.openSession();
        Transaction trans= session.beginTransaction();
        
		session.save(order);
		trans.commit();
	}
	
	
	public void deleteOrder(int order) {
	  	Configuration con = new Configuration();
        con.configure().addAnnotatedClass(Order.class);
        SessionFactory sf= con.buildSessionFactory();
        Session session= sf.openSession();
        Transaction trans= session.beginTransaction();
        
		Order ord = session.get(Order.class,order);
		session.delete(ord);
		trans.commit();
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
