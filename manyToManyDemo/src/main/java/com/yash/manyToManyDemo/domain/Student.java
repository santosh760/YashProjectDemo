package com.yash.manyToManyDemo.domain;

import java.util.Set;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="STUDENT_ID")
	private int studentId;

	@Column(name = "STUDENT_NAME")
	private String studentName;

	@Column(name = "CITY")
	private String city;

	@Column(name = "CONTACT")
	private long contact;

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "STUDENT_COURSE", joinColumns = { @JoinColumn(name = "STUDENT_ID") }, inverseJoinColumns = { @JoinColumn(name = "COURSE_ID") })
	private Set<Course> courses;

	public Student(int studentId, String studentName, String city, long contact, Set<Course> courses) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.city = city;
		this.contact = contact;
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", city=" + city + ", contact="
				+ contact + ", courses=" + courses + "]";
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	public Student() {
		// TODO Auto-generated constructor stub
	}
}
