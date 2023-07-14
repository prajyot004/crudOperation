package com.newproject.agentCrud;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
	public static Configuration con = new Configuration().configure().addAnnotatedClass(Agent.class);
	public static SessionFactory sf = con.buildSessionFactory();
	
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        CreateAgent("Anil","anil12@gmail.com",342342343);  				
    	CreateAgent("Nitin","nititn@gmail.com",4434534);			
    	CreateAgent("Mukesh","Mukesh@gmail.com",34544322);
    	
    	getAgentbyId(2);
    	
    	deleteAgentbyId(3);
    	
    	updateAgentbyId(1, "munaf","munaf@123@gmail.com", 333333333);
    }
    
    public static void CreateAgent(String name,String Email,long phno)
	{
    	Session ss=sf.openSession();
    	Transaction t1=ss.beginTransaction();
    	Agent a1=new Agent();
    	a1.setName(name);
    	a1.setEmail(Email);
    	a1.setPhoneNumber(phno);
    	ss.save(a1);
    	t1.commit();
	}
    
    public static void getAgentbyId(int id) {
    	Session ss=sf.openSession();
    	Transaction t1=ss.beginTransaction();
    	Agent a1=ss.get(Agent.class, id);
    	System.out.print(a1.getAid()+" ");
    	System.out.print(a1.getName()+" ");
    	System.out.print(a1.getEmail()+" ");
    	System.out.print(a1.getPhoneNumber()+" ");	
    	System.out.println();
    }
    
    public static void deleteAgentbyId(int id) {
    	Session ss=sf.openSession();
    	Transaction t1=ss.beginTransaction();
    	Agent a1=ss.get(Agent.class, id);
    	ss.delete(a1);
    	t1.commit();
}
    
    public static void updateAgentbyId(int id,String name,String Email,long phno) {
    	Session ss=sf.openSession();
    	Transaction t1=ss.beginTransaction();
    	Agent a1=ss.get(Agent.class, id);
    	a1.setName(name);
    	a1.setEmail(Email);
    	a1.setPhoneNumber(phno);
    	ss.save(a1);
    	t1.commit();
    }
    
    
}
