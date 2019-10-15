package com.customerapp.model.persistance;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="customertable3")
public class Customer {
@Id
@GeneratedValue

	private int custid;
	@NotEmpty(message="name should not be empty")
	private String name;
	@NotEmpty(message="email should not be empty")
	@Email
	private String email;
	private String mobile;
	public int getCustid() {
		return custid;
	}
	public void setCustid(int custid) {
		this.custid = custid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Customer(int custid, String name, String email, String mobile) {
		
		this.custid = custid;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
	}
	public Customer() {
		
	}
	@Override
	public String toString() {
		return "Customer [custid=" + custid + ", name=" + name + ", email=" + email + ", mobile=" + mobile + "]";
	}

		

}
