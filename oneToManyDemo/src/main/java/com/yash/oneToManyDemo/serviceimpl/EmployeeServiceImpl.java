package com.yash.oneToManyDemo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.oneToManyDemo.dao.EmployeeDao;
import com.yash.oneToManyDemo.dao.ProjectDao;
import com.yash.oneToManyDemo.domain.Employee;
import com.yash.oneToManyDemo.service.EmployeeService;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;
	
	public void addEmployee(Employee employee) {
		employeeDao.addEmployee(employee);

	}

	public void deleteEmployee(int Id) {
		employeeDao.deleteEmployee(Id);

	}

	public List<Employee> showAllEmployee() {
		
		return employeeDao.showAllEmployee();
	}

	public void searchById(int Id) {
		employeeDao.searchById(Id);

	}

	public void updateProject(Employee employee) {
		employeeDao.updateProject(employee);

	}

}
