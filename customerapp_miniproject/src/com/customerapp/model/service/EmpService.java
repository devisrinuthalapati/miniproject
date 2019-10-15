package com.customerapp.model.service;

import java.util.List;

import com.customerapp.model.persistance.Emp;

public interface EmpService {
	public Emp getEmpByEmail(String email,String password);

	public void addEmp(Emp empl);

	public List<Emp> getAllEmp();
}
