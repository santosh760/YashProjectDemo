package com.yash.oneToOneDemo.dao;

import java.util.List;

import com.yash.oneToOneDemo.domain.Person;

public interface PersonDao {

	int addPerson(Person person);

	int deletePerson(int Id);

	List<Person> showAllPerson();

	Person searchById(int Id);

	Person updatePerson(Person person);

}
