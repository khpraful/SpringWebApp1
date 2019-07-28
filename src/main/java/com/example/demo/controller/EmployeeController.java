package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.model.Employee;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeDao empDao;
	
	@RequestMapping("/")
		public String homepage() {
		return "homepage.jsp";
	}

	@PostMapping("/employee")
	public Employee addEmployee(Employee emp){
		
		empDao.save(emp);
		return emp;
	}
	
	@RequestMapping("/getEmployee")
	public ModelAndView getEmployee(@RequestParam int empNo){
		
		ModelAndView mv = new ModelAndView("showEmployee.jsp");
		Employee emp = empDao.findById(empNo).orElse(new Employee());
		System.out.println(empDao.findByempName("Finance"));
		System.out.println(empDao.findByempNoGreaterThan(103));
		mv.addObject("emp",emp);
		return mv;
		
	}
	
	@RequestMapping("/employees")
	public List<Employee> getEmployees(){
		
		return empDao.findAll();
				
	}
	
	@RequestMapping("/employee/{empNo}")
	public Optional<Employee> getEmp(@PathVariable int empNo){
		
		return empDao.findById(empNo);
				
	}
}
