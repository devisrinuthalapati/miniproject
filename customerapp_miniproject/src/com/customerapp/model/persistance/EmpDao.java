package com.customerapp.model.persistance;

import java.util.List;
public interface EmpDao {
	public Emp getEmpByEmail(String email,String password);

	public void addEmp(Emp empl);

	public List<Emp> getAllEmp();

}
