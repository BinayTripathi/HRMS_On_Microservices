package com.binay.microservices.webservice.restresource;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.binay.microservices.persistence.dao.PersonDao;
import com.binay.microservices.persistence.entity.Person;
import com.binay.microservices.webservice.exception.PersonNotFoundException;

@CrossOrigin
@RestController
public class PersonResource {

	@Autowired
	private PersonDao personDao;
	
	@GetMapping(path = "/person/id/{id}")
	public Person getPerson(@PathVariable Long id) 
	{
		Optional<Person> personOptional = personDao.findAllPersonByID(id);
		if(personOptional.isPresent())
			return personOptional.get();
		else
			throw new PersonNotFoundException("Person Id - " + id);
		
	}
	
	@GetMapping(path = "/person/name/{personName}")
	public List<Person> findAllUserByName(@PathVariable String personName)
	{
		List<Person> persons = personDao.findPersonsByName(personName);
		return persons;
	}
	
	@PutMapping("/person")
	public ResponseEntity<Object> createPerson(@RequestBody Person person)
	{
		Person personCreated = personDao.createPerson(person);
		URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").buildAndExpand(personCreated.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	public Person deletePerson(Long id) 
	{
		Person personToDelete = this.getPerson(id);
		if(personToDelete != null)
			personDao.deletePerson(id);
		
		return personToDelete;
	}
	
	
}
