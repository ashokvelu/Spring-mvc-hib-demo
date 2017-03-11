package com.ashkn.mvccrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		
		//create model attribute to bind form data
		Customer theCustomer = new Customer();
		
		theModel.addAttribute("customer",theCustomer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer)
	{
		//save the customer using our Service 
		customerService.saveCustomer(theCustomer);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel)
	{
		//get the customer from the database
		
		Customer theCustomer = customerService.getCustomer(theId);
		
		
		//set customer as a model attribute to pre-populate the form
		
		theModel.addAttribute("customer",theCustomer);
		
		
		
		//send over to our form
		
		
		return "customer-form";
	}
	
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId") int theId)
	{
		//delete the customer 
		customerService.deleteCustomer(theId);
		
		
		return "redirect:/customer/list";
		
	}
	
	
}
