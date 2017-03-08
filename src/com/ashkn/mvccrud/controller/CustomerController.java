package com.ashkn.mvccrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ashkn.mvccrud.dao.CustomerDAO;
import com.ashkn.mvccrud.entity.Customer;
import com.ashkn.mvccrud.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	//need to inject our Customer Services
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomer(Model theModel){
		
		//get customers from DAO
		List<Customer> theCustomers = customerService.getCustomer();
		
		//add customer to the spring mvc model
		theModel.addAttribute("customer", theCustomers);
		
		return "list-customer";
		
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel){
		return "customer-form";
	}
	
}
