package com.yash.manyToManyDemo.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.yash.manyToManyDemo.dao.StudentDao;
import com.yash.manyToManyDemo.domain.Student;

@Repository("dao")
public class StudentDaoImpl implements StudentDao {

	@Autowired
	HibernateTemplate hibernateTemplate;
	
	public void addStudent(Student student) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		try {
			session.getTransaction().begin();
			session.save(student);
			System.out.println("Project Saved "+student.getStudentId()+"------------*****************");
			System.out.println("saved...");
			session.getTransaction().commit();
			hibernateTemplate.flush();
		} catch (Exception e) {
			System.out.println("Exception Occured " + e);
		}

	}

	public void deleteStudent(int id) {
		// TODO Auto-generated method stub

	}

	public List<Student> allStudent() {
		// TODO Auto-generated method stub
		return null;
	}

	public void searchStudent(int id) {
		// TODO Auto-generated method stub

	}

}
