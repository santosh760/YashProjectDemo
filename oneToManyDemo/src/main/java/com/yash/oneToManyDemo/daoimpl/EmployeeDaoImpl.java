package com.yash.oneToManyDemo.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.yash.oneToManyDemo.dao.EmployeeDao;
import com.yash.oneToManyDemo.domain.Employee;
import com.yash.oneToManyDemo.domain.Project;

@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	HibernateTemplate hibernateTemplate;
	
	public void addEmployee(Employee employee) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		try {
			session.getTransaction().begin();
			session.save(employee);
			System.out.println("Project Saved "+employee.getEmpId()+"------------*****************");
			System.out.println("saved...");
			session.getTransaction().commit();
			hibernateTemplate.flush();
		} catch (Exception e) {
			System.out.println("Exception Occured " + e);
		}

	}

	public void deleteEmployee(int Id) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		try {
			session.getTransaction().begin();

			Employee employee = session.get(Employee.class, Id);
			session.delete(employee);
			System.out.println("deleted...");
			session.getTransaction().commit();
			hibernateTemplate.flush();
		
		} catch (Exception e) {
			System.out.println("Exception Occured " + e);
		}

	}

	public List<Employee> showAllEmployee() {
		
		return hibernateTemplate.loadAll(Employee.class);
	}

	public void searchById(int Id) {
		// TODO Auto-generated method stub

	}

	public void updateProject(Employee employee) {
		// TODO Auto-generated method stub

	}

}
