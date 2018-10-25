package com.yash.oneToOneDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yash.oneToOneDemo.domain.Person;
import com.yash.oneToOneDemo.service.PersonService;

@RestController
@RequestMapping(value="/person")
public class PersonController {

	@Autowired
	PersonService personService;
	
	@RequestMapping(value="/addPerson",method=RequestMethod.POST)
	public void addPerson(@RequestBody Person person) {
		
		personService.addPerson(person);
	}
	
	@RequestMapping(value="/deletePerson/{id}",method=RequestMethod.DELETE)
	public void deletePerson(@PathVariable int id) {
		personService.deletePerson(id);
	}
	
	@RequestMapping(value="/showAllPerson", method=RequestMethod.GET)
	public List<Person> getAllPerson(){
	
		return personService.showAllPerson();
	}
}
