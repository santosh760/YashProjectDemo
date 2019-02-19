package com.yash.crudboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yash.crudboot.domain.Employee;
import com.yash.crudboot.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public int registerEmployee(Employee employee) {
		try {
			employeeRepository.save(employee);
			return 1;
		}
		catch (Exception e) {
			return 0;
		}
		
	}

	public int deleteEmployeeById(int id) {
		try {
			employeeRepository.deleteById(id);
			return 1;
		}
		catch (Exception e) {
			return 0;
		}
	}

	public Employee getEmployee(int id) {
		
		return employeeRepository.findById(id).get();
	}

	public int updateEmployee(Employee employee) {
		Employee emp=getEmployee(employee.getId());
		emp.setName(employee.getName());
		emp.setSalary(employee.getSalary());
		emp.setDepartment(employee.getDepartment());
		return registerEmployee(emp);
	}
}
