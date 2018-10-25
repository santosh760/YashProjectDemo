package com.yash.oneToOneDemo.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="person")
public class Person implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Contact")
	private int contact;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Aadhar aadhar;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getContact() {
		return contact;
	}

	public void setContact(int contact) {
		this.contact = contact;
	}

	public Aadhar getAadhar() {
		return aadhar;
	}

	public void setAadhar(Aadhar aadhar) {
		this.aadhar = aadhar;
	}

	public Person(int id, String name, int contact, Aadhar aadhar) {
		super();
		this.id = id;
		this.name = name;
		this.contact = contact;
		this.aadhar = aadhar;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", contact=" + contact + ", aadhar=" + aadhar + "]";
	}

	public Person() {
		// TODO Auto-generated constructor stub
	}
}
