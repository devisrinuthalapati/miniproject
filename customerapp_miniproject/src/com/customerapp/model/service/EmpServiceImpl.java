package com.customerapp.model.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.customerapp.model.persistance.Emp;
import com.customerapp.model.persistance.EmpDao;

@Service
@Transactional
public class EmpServiceImpl implements EmpService {
	
	@Autowired
	private EmpDao empdao;
	
	@Override
	public Emp getEmpByEmail(String email, String password) {
		
		return empdao.getEmpByEmail(email,password);
	}
	@Override 
	public void addEmp(Emp empl) {
		
		empdao.addEmp(empl);
	}

	@Override
	public List<Emp> getAllEmp() {
		return empdao.getAllEmp();
	}

}
