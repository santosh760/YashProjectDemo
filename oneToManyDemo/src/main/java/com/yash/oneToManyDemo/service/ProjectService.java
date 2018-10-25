package com.yash.oneToManyDemo.service;

import java.util.List;

import com.yash.oneToManyDemo.domain.Project;

public interface ProjectService {

	void addProject(Project project);

	void deleteProject(int Id);

	List<Project> showAllProject();

	void searchById(int Id);

	void updateProject(Project project);
}
