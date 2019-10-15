package com.customerapp.model.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.customerapp.model.persistance.Customer;
import com.customerapp.model.persistance.CustomerDao;


@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{
	private CustomerDao custermerdao;
	@Autowired
	private SessionFactory factory;
	public Session getSession(){
		return factory.getCurrentSession();
	}

	@Override
	public List<Customer> getAllCustomers() {
		
		return getSession().createQuery("from Customer").list();
	}

	@Override
	public Customer getCustomer(int custid) {
		Customer customer=custermerdao.getCustomer(custid);
		if(customer==null)
			throw new CustomerNotFoundException("customer with id"+ custid+ "is not there");
		
		return customer;
	}

	@Override
	public Customer addCustomer(Customer customer) {
		
		 getSession().save(customer);
		 return customer;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		getSession().update(customer);
		return customer;
	}

	@Override
	public Customer removeCustomer(int custid) {
		Customer customerToBeDelete=getCustomer( custid);
		getSession().delete(customerToBeDelete);
		return customerToBeDelete;
	}

	
}
