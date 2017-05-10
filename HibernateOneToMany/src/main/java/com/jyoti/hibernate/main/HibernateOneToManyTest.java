package com.jyoti.hibernate.main;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.jyoti.hibernate.model.Branch;
import com.jyoti.hibernate.model.Customer;
import com.jyoti.hibernate.util.HibernateUtil;
/*
 * Implement One to Many Mapping using XML based configuratio
 */
public class HibernateOneToManyTest {

	public static void main(String[] args) {
		
		Branch branch = new Branch();
		branch.setAddress("Delhi");
		branch.setEmail("delhi@bank.com");
		
		
		Customer customer1 = new Customer("C23", "Amit", "RaeBareily", branch);
		Customer customer2 = new Customer("C24", "Dravesh", "Ghazipur", branch);
		Set<Customer> customerSet = new HashSet<Customer>();
		customerSet.add(customer1);
		customerSet.add(customer2);
		
		
		branch.setCustomers(customerSet);
		
		
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try{
		//Get Session
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.getCurrentSession();
		System.out.println("Session created");
		//start transaction
		tx = session.beginTransaction();
		
		//Save the Model objects
		session.save(branch);
		session.save(customer1);
		session.save(customer2);
		
		//Commit transaction
		tx.commit();
		System.out.println("Branch ID="+branch.getId());
		
		}catch(Exception e){
			System.out.println("Exception occured. "+e.getMessage());
			e.printStackTrace();
		}finally{
			if(!sessionFactory.isClosed()){
				System.out.println("Closing SessionFactory");
				sessionFactory.close();
			}
		}
	}

}
