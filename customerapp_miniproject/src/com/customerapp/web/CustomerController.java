package com.customerapp.web;




import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.customerapp.model.persistance.Customer;
import com.customerapp.model.service.CustomerService;



@Controller
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	

	@RequestMapping(value = "allcustomer", method = RequestMethod.GET)
	public String getCustomers(ModelMap map) {
		map.addAttribute("customers", customerService.getAllCustomers());
		return "allcustomers";
	}

	@RequestMapping(value = "addcustomer", method = RequestMethod.GET)
	public String addCustomerGet(ModelMap map) {
		map.addAttribute("customer", new Customer());
		return "addcustomer";
	}

	@RequestMapping(value = "addcustomer", method = RequestMethod.POST)
	public String addCustomerPost(@Valid Customer customer, BindingResult bindingResult) {
		if(bindingResult.hasErrors()){
			return "addcustomer";
		}else{
		if (customer.getCustid() == 0) {
			customerService.addCustomer(customer);
		} else {
			customerService.updateCustomer(customer);
		}
		return "redirect:allcustomer";
		}
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteCustomer(HttpServletRequest req) {
		int custId = Integer.parseInt(req.getParameter("custid"));
		customerService.removeCustomer(custId);
		return "redirect:allcustomer";
	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String updateCustomer(HttpServletRequest req, ModelMap map) {
		int custId = Integer.parseInt(req.getParameter("custid"));
		Customer customerToBeUpdated = customerService.getCustomer(custId);
		map.addAttribute("customer", customerToBeUpdated);
		return "addcustomer";
	}
	
	
}
