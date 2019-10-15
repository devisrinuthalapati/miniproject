package com.customerapp.model.persistance;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class EmpDaoImpl implements EmpDao {
	@Autowired
	private SessionFactory factory;
	public Session getSession(){
		return factory.getCurrentSession();
	}
	@Override
	public Emp getEmpByEmail(String email, String password) {
		@SuppressWarnings(value="unchecked")
		List<Emp> emp=getSession().createQuery("select e from Emp e where e.email=:email and e.password=:password").setString("email", email).setString("password", password).list();
		if(emp.size()>0)
			return emp.get(0);
		else
			throw new EmpNotFoundException("employee with email "+email+" is not found");	
	}
	@Override
	public void addEmp(Emp emp) {
		getSession().save(emp);	
	}
	@Override
	public List<Emp> getAllEmp() {
		return getSession().createQuery("from Emp").list() ;
	}
	
	}
