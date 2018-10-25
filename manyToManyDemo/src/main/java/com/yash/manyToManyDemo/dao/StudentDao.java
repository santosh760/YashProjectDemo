package com.yash.manyToManyDemo.dao;

import java.util.List;

import com.yash.manyToManyDemo.domain.Student;

public interface StudentDao {

	void addStudent(Student student);

	void deleteStudent(int id);

	List<Student> allStudent();

	void searchStudent(int id);

}
