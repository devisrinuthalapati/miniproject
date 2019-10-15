package com.customerapp.model.persistance;

import java.util.List;

public interface CustomerDao {
	public	List<Customer> getAllCustomers();
	public Customer getCustomer(int custid);
	public Customer addCustomer(Customer customer);
	public Customer updateCustomer(Customer customer);
	public Customer removeCustomer(int custid);

}
