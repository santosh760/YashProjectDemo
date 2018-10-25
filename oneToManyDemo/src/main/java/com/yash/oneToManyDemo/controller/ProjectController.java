package com.yash.oneToManyDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yash.oneToManyDemo.domain.Project;
import com.yash.oneToManyDemo.service.ProjectService;

@RestController
@RequestMapping(value="/project")
public class ProjectController {

	@Autowired
	ProjectService projectService;
	
	@RequestMapping(value="/addproject",method=RequestMethod.POST)
	public void addProject(@RequestBody Project project) {
		
		projectService.addProject(project);
		
	}
}
