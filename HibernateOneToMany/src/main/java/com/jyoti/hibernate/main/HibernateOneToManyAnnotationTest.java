package com.jyoti.hibernate.main;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.jyoti.hibernate.model.BranchAnno;
import com.jyoti.hibernate.model.CustomerAnno;
import com.jyoti.hibernate.util.HibernateAnnotationUtil;

/*
 * Implement One to Many Mapping using Hibernate Annotations
 */
public class HibernateOneToManyAnnotationTest {
	
	public static void main(String[] args) {

		BranchAnno branchAnno = new BranchAnno();
		
		branchAnno.setAddress("Mumbai");
		branchAnno.setEmail("mumbai@bank");
		
		CustomerAnno customerAnno1=new CustomerAnno("C12", "Abhineet" ,"Bangalore", branchAnno);
		CustomerAnno customerAnno2=new CustomerAnno("C13", "Pall" ,"Patna", branchAnno);

		
		Set<CustomerAnno> customerAnno = new HashSet<CustomerAnno>();
		customerAnno.add(customerAnno1);
		customerAnno.add(customerAnno2);
		
		branchAnno.setCustomerAnno(customerAnno);
		
		
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try{
		//Get Session
			sessionFactory = HibernateAnnotationUtil.getSessionFactory();
			session = sessionFactory.getCurrentSession();
		System.out.println("Session created");
		//start transaction
		tx = session.beginTransaction();
		//Save the Model object
		session.save(branchAnno);
		session.save(customerAnno1);
		session.save(customerAnno2);
		//Commit transaction
		tx.commit();
		
		
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


