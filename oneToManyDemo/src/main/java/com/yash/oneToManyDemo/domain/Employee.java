package com.yash.oneToManyDemo.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "EmployeeOneToMany")
public class Employee implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EMPLOYEE_ID", unique = true, nullable = false)
	private int empId;

	@Column(name = "name")
	private String empName;

	@Column(name = "salary")
	private int empSalary;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PROJECT_ID", nullable = false)
	private Project projects;
	
	
	

	public Employee(int empId, String empName, int empSalary, Project projects) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;
		this.projects = projects;
	}




	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSalary=" + empSalary + ", projects="
				+ projects + "]";
	}




	public int getEmpId() {
		return empId;
	}




	public void setEmpId(int empId) {
		this.empId = empId;
	}




	public String getEmpName() {
		return empName;
	}




	public void setEmpName(String empName) {
		this.empName = empName;
	}




	public int getEmpSalary() {
		return empSalary;
	}




	public void setEmpSalary(int empSalary) {
		this.empSalary = empSalary;
	}




	public Project getProjects() {
		return projects;
	}




	public void setProjects(Project projects) {
		this.projects = projects;
	}




	public Employee() {
		// TODO Auto-generated constructor stub
	}
}
