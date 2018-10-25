package com.yash.oneToManyDemo.domain;


import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Project")
public class Project implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PROJECT_ID", unique = true, nullable = false)
	private int projectId;

	@Column(name = "name")
	private String name;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "projects")
	private Set<Employee> employee;

	

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", name=" + name + ", employee=" + employee + "]";
	}



	public Project(int projectId, String name, Set<Employee> employee) {
		super();
		this.projectId = projectId;
		this.name = name;
		this.employee = employee;
	}



	public int getProjectId() {
		return projectId;
	}



	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Set<Employee> getEmployee() {
		return employee;
	}



	public void setEmployee(Set<Employee> employee) {
		this.employee = employee;
	}



	public Project() {
		// TODO Auto-generated constructor stub
	}

}
