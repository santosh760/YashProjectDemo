package com.yash.oneToOneDemo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.oneToOneDemo.dao.PersonDao;
import com.yash.oneToOneDemo.domain.Person;
import com.yash.oneToOneDemo.service.PersonService;

@Service("personService")
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonDao personDao;
	
	public int addPerson(Person person) {
		return personDao.addPerson(person);

	}

	public int deletePerson(int Id) {
		return personDao.deletePerson(Id);

	}

	public List<Person> showAllPerson() {
		
		return personDao.showAllPerson();
	}

	public Person searchById(int Id) {
		return personDao.searchById(Id);

	}

	public Person updatePerson(Person person) {
		return personDao.updatePerson(person);

	}

}
