package com.yash.oneToManyDemo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.oneToManyDemo.dao.ProjectDao;
import com.yash.oneToManyDemo.domain.Project;
import com.yash.oneToManyDemo.service.ProjectService;

@Service("projectService")
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	ProjectDao projectDao;
	
	public void addProject(Project project) {
		projectDao.addProject(project);

	}

	public void deleteProject(int Id) {
		// TODO Auto-generated method stub

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
