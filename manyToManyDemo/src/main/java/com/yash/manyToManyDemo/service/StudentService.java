package com.yash.manyToManyDemo.service;

import java.util.List;

import com.yash.manyToManyDemo.domain.Student;

public interface StudentService {

	void addStudent(Student student);

	void deleteStudent(int id);

	List<Student> allStudent();

	void searchStudent(int id);


}
