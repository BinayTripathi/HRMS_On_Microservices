package com.binay.microservices.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.binay.microservices.persistence.entity.IEmployee;
import com.binay.microservices.persistence.entity.Person;

public interface EmployeeRepository extends JpaRepository<IEmployee, Long>{
	
	Optional<IEmployee> findById(Long id);
	List<IEmployee> findByManager(IEmployee manager);
	
	//Find latest employment detail given the person id
	IEmployee findLastByPersonObjOrderByIdDesc(Person person);

}
