package com.yash.manyToManyDemo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.manyToManyDemo.dao.StudentDao;
import com.yash.manyToManyDemo.domain.Student;
import com.yash.manyToManyDemo.service.StudentService;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDao dao;
	
	public void addStudent(Student student) {
		dao.addStudent(student);

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
