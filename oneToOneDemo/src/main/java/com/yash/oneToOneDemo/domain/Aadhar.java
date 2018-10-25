package com.yash.oneToOneDemo.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Aadhar")
public class Aadhar implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="AadharNumber")
	private int aadharNumber;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(int aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	@Override
	public String toString() {
		return "Aadhar [id=" + id + ", aadharNumber=" + aadharNumber + "]";
	}

	public Aadhar(int id, int aadharNumber) {
		super();
		this.id = id;
		this.aadharNumber = aadharNumber;
	}

	public Aadhar() {
		// TODO Auto-generated constructor stub
	}
}
