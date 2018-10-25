package com.yash.oneToManyDemo.service;

import java.util.List;

import com.yash.oneToManyDemo.domain.Employee;

public interface EmployeeService {

	void addEmployee(Employee employee);

	void deleteEmployee(int Id);

	List<Employee> showAllEmployee();

	void searchById(int Id);

	void updateProject(Employee employee);
}
