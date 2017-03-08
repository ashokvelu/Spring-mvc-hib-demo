package com.ashkn.mvccrud.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ashkn.mvccrud.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	//need to inject the session factory
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//Query creation
		Query<Customer> theQuery = 
				currentSession.createQuery("from Customer ", Customer.class);
		
		//get the result List from the query
		
		List<Customer> customers = theQuery.getResultList();
		
		//return the result
	
		return customers;
	}

}




