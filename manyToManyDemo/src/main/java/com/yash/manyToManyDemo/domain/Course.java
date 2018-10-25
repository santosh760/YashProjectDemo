package com.yash.manyToManyDemo.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "COURSE")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="COURSEID")
	private int courseId;

	@Column(name = "COURSE_NAME")
	private String courseName;

	@Column(name = "DURATION_IN_YEARS")
	private int durationInYears;

	@ManyToMany(mappedBy="courses")
	//@JoinTable(name="COURSE_STUDENT",joinColumns= {@JoinColumn(referencedColumnName="STUDENTID")},inverseJoinColumns= {@JoinColumn(referencedColumnName="COURSEID")})
	private Set<Student> students;

	public Course(int courseId, String courseName, int durationInYears, Set<Student> students) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.durationInYears = durationInYears;
		this.students = students;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", durationInYears=" + durationInYears
				+ ", students=" + students + "]";
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getDurationInYears() {
		return durationInYears;
	}

	public void setDurationInYears(int durationInYears) {
		this.durationInYears = durationInYears;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public Course() {
		// TODO Auto-generated constructor stub
	}
}
