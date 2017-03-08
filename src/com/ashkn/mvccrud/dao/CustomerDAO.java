package com.ashkn.mvccrud.dao;

import java.util.List;

import com.ashkn.mvccrud.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();
}
