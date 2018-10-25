package com.yash.oneToOneDemo.service;

import java.util.List;

import com.yash.oneToOneDemo.domain.Aadhar;

public interface AadharService {


	void addAadhar(Aadhar aadhar);

	void deleteAadhar(Aadhar aadhar);

	List<Aadhar> showAllAadhar();

	void searchById(Integer Id);

	void updateAadhar(Aadhar aadhar);
}
