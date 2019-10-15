package com.customerapp.web;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.customerapp.model.persistance.Emp;
import com.customerapp.model.persistance.EmpNotFoundException;
import com.customerapp.model.service.EmpService;
@Controller
public class EmpController {
	@Autowired
	private EmpService empService;
	Emp emp = null;

/*	@PostConstruct
	public void init(){
		empService.addEmp(new Emp("devi@gmail.com","devi", "admin", true));
		empService.addEmp(new Emp("sai@gmail.com","sai","manager",  true));
		empService.addEmp(new Emp("tej@gmail.com","tej", "user", true));
	}*/
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "redirect:login";
	}
	
	@RequestMapping(value = "login")
	public String loginGet(HttpServletRequest req,ModelMap map) {
		map.addAttribute("empbean", new EmpFormBean());
		map.addAttribute("error",req.getParameter("error"));
		return "login";
	}
	
	@RequestMapping(value = "logout")
	public String logout(ModelMap map) {
		map.addAttribute("empbean", new EmpFormBean());
		map.addAttribute("message", "you are logged out successfully");
		return "login";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String loginPost(HttpServletRequest req,@Valid @ModelAttribute(value="empbean") EmpFormBean empBean, BindingResult bindingResult) {
		if(bindingResult.hasErrors()){
			return "login";
		}else{
			try{
				emp=empService.getEmpByEmail(empBean.getEmail(),empBean.getPassword());
			}catch(EmpNotFoundException e){
				return "redirect:login?error=login interrupted";
			}
			HttpSession httpSession=req.getSession();
			httpSession.setAttribute("emp", emp);
		}
		return "redirect:allcustomer";
	}
}
