package com.yash.oneToManyDemo.dao;

import java.util.List;

import com.yash.oneToManyDemo.domain.Employee;

public interface EmployeeDao {


	void addEmployee(Employee employee);

	void deleteEmployee(int Id);

	List<Employee> showAllEmployee();

	void searchById(int Id);

	void updateProject(Employee employee);
}
