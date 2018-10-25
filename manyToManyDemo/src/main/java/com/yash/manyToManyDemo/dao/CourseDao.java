package com.yash.manyToManyDemo.dao;

import java.util.List;

import com.yash.manyToManyDemo.domain.Course;
import com.yash.manyToManyDemo.domain.Student;

public interface CourseDao {

	void addCourse(Course course);

	void deleteCourse(int id);

	List<Course> allCourse();

	void searchCourse(int id);
}
