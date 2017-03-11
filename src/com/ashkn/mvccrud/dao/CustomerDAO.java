package com.ashkn.mvccrud.dao;

import java.util.List;

import com.ashkn.mvccrud.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomers(int theId);

	public void deleteCustomer(int theId);

}
