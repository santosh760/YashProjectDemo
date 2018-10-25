package com.yash.oneToManyDemo.dao;

import java.util.List;

import com.yash.oneToManyDemo.domain.Project;

public interface ProjectDao {

	void addProject(Project project);

	void deleteProject(int Id);

	List<Project> showAllProject();

	void searchById(int Id);

	void updateProject(Project project);
}
