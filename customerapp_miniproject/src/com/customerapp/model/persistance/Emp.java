package com.customerapp.model.persistance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="emptable")
public class Emp {

	@Id
	@GeneratedValue
	private int id;
	@Column(unique=true)
	private String name;
	
	private String email;
	private String password;
	private String profile;
	private boolean active;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Emp(int id, String name, String email, String password, String profile, boolean active) {
		
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.profile = profile;
		this.active = active;
	}
	public Emp() {
		
	}
	

}
