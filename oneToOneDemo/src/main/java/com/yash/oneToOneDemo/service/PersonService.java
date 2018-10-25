package com.yash.oneToOneDemo.service;

import java.util.List;

import com.yash.oneToOneDemo.domain.Person;

public interface PersonService {

	int addPerson(Person person);

	int deletePerson(int Id);

	List<Person> showAllPerson();

	Person searchById(int Id);

	Person updatePerson(Person person);
}
