package com.binay.microservices.persistence.dao;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.binay.microservices.persistence.entity.Address;
import com.binay.microservices.persistence.entity.Person;
import com.binay.microservices.persistence.repository.PersonRepository;


@Transactional
@Repository
public class PersonDao {

	@Autowired
	PersonRepository personRepo;
	
	public List<Person> findAllPerson(){
		List<Person> findAll = personRepo.findAll();
		return findAll;
		
	}
	
	public Optional<Person> findAllPersonByID(Long personId)
	{
		Optional<Person> personById = personRepo.findById(personId);
		return personById;
	}
	
	public List<Person> findPersonsByName(String nameWildChar)
	{
		List<Person> allPeronsByName = personRepo.selectByNameLike(nameWildChar+"%");
		return allPeronsByName;
	}
	
	public Person createPerson(Person person)
	{
		Person pPerson = personRepo.save(person);
		return pPerson;
	}
	
	public void deletePerson(Long id)
	{
		 personRepo.deleteById(id);
	}
}
