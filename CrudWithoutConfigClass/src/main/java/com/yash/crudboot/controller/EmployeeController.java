package com.yash.crudboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.crudboot.domain.Employee;
import com.yash.crudboot.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/createEmployee")
	public ResponseEntity<Employee> registerEmployee(@RequestBody Employee employee) {

		int result = employeeService.registerEmployee(employee);

		if (result == 1) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}

	}

	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity<Employee> deleteEmployeeById(@PathVariable int id) {

		int result = employeeService.deleteEmployeeById(id);

		if (result == 1) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}

	@GetMapping("/getEmployee/{id}")
	public Employee findEmployeeById(@PathVariable int id) {

		return employeeService.getEmployee(id);
	}

	@PutMapping("/updateEmployee")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		int result = employeeService.updateEmployee(employee);
		if (result == 1) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}
}
