package com.binay.microservices.persistence.dao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.binay.microservices.persistence.entity.IEmployee;
import com.binay.microservices.persistence.entity.Person;
import com.binay.microservices.persistence.repository.EmployeeRepository;

@Transactional
@Repository
public class EmployeeDao {
	
	@Autowired
	EmployeeRepository employeeRepo;
	
	@Autowired
	PersonDao personDao;
	
	public List<IEmployee> findAllEmployees()
	{
		List<IEmployee> findAll = employeeRepo.findAll();
		return findAll;
	}
	
	public IEmployee findEmployeeById(long id)
	{
		Optional<IEmployee> findById = employeeRepo.findById(id);
		
		if(findById.isPresent())
			return findById.get();
		else
			return null;
	}
	
	
	public IEmployee createEmployee(IEmployee employee)
	{
		Person person = employee.getPersonObj();
		Long personId = person.getId();
		Optional<Person> pPersonOpt = personDao.findAllPersonByID(personId);
		
		Person pPerson = null;
		if(pPersonOpt.isPresent())
			pPerson = pPersonOpt.get();
		else
			pPerson = personDao.createPerson(person);
		
		IEmployee pEmployee = employeeRepo.save(employee);		
		pPerson.addEmploymentRecord(employee);	
		
		return pEmployee;
	}
	
	public IEmployee latestEmploymentDetailOfPerson(Person person)
	{
		IEmployee employee = null;
		employee = employeeRepo.findLastByPersonObjOrderByIdDesc(person);
		return employee;
	}	
	
}
