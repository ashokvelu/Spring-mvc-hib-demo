package com.ashkn.mvccrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ashkn.mvccrud.dao.CustomerDAO;
import com.ashkn.mvccrud.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	//Need to inject Customer DAO
	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomer() {
		
		//
		return customerDAO.getCustomers();
	}

}
