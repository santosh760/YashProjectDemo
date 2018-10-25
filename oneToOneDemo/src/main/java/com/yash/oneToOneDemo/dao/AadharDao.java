package com.yash.oneToOneDemo.dao;

import java.util.List;

import com.yash.oneToOneDemo.domain.Aadhar;

public interface AadharDao {

	void addAadhar(Aadhar aadhar);

	void deleteAadhar(Aadhar aadhar);

	List<Aadhar> showAllAadhar();

	void searchById(Integer Id);

	void updateAadhar(Aadhar aadhar);
}
