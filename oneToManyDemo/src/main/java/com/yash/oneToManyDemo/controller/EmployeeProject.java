package com.yash.oneToManyDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yash.oneToManyDemo.domain.Employee;
import com.yash.oneToManyDemo.service.EmployeeService;

@RestController
@RequestMapping(value="/employee")
public class EmployeeProject {

	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value="/addEmployee",method=RequestMethod.POST)
	public void addEmployee(@RequestBody Employee employee) {
		
		employeeService.addEmployee(employee);
	}
	
	@RequestMapping(value="/getAllEmployee",method=RequestMethod.GET)
	public List<Employee> getAllEmployee(){
		
		return employeeService.showAllEmployee();
	}
}

