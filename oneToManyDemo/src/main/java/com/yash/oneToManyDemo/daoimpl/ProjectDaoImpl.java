package com.yash.oneToManyDemo.daoimpl;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.yash.oneToManyDemo.dao.ProjectDao;
import com.yash.oneToManyDemo.domain.Employee;
import com.yash.oneToManyDemo.domain.Project;

@Repository("projectDao")
public class ProjectDaoImpl implements ProjectDao {

	@Autowired
	HibernateTemplate hibernateTemplate;
	
	public void addProject(Project project) {
		
		Session session = hibernateTemplate.getSessionFactory().openSession();
		try {
			System.out.println("\n\n"+project);
			session.getTransaction().begin();
			System.out.println("Project Saved "+project.getProjectId()+"------------*****************");
			Set<Employee> employeeSet= project.getEmployee();
			session.save(project);
			for (Employee employee : employeeSet) {
				System.out.println(employee);
				employee.setProjects(project);
				session.save(employee);
			}
			System.out.println("saved...");
			session.getTransaction().commit();
			hibernateTemplate.flush();
		} catch (Exception e) {
			System.out.println("Exception Occured " + e);
		}
		

	}

	public void deleteProject(int Id) {


	}

	public List<Project> showAllProject() {
		// TODO Auto-generated method stub
		return null;
	}

	public void searchById(int Id) {
		// TODO Auto-generated method stub

	}

	public void updateProject(Project project) {
		// TODO Auto-generated method stub

	}

}
