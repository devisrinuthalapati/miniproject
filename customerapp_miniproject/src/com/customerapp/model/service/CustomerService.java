package com.customerapp.model.service;

import java.util.List;

import com.customerapp.model.persistance.Customer;

public interface CustomerService {
	public	List<Customer> getAllCustomers();
	public Customer getCustomer(int custid);
	public Customer addCustomer(Customer customer);
	public Customer updateCustomer(Customer customer);
	public Customer removeCustomer(int custid);
	

}
