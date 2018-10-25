package com.yash.manyToManyDemo.service;

import java.util.List;

import com.yash.manyToManyDemo.domain.Course;

public interface CourseService {
	void addCourse(Course course);

	void deleteCourse(int id);

	List<Course> allCourse();

	void searchCourse(int id);

}
