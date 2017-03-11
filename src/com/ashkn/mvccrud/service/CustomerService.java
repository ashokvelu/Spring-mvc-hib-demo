package com.ashkn.mvccrud.service;

import java.util.List;

import com.ashkn.mvccrud.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomer();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);

}
