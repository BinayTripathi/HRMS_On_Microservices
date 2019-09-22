package com.binay.microservices;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.binay.microservices.businesslogic.StaticTaxData;
import com.binay.microservices.persistence.dao.EmployeeDao;
import com.binay.microservices.persistence.dao.PersonDao;
import com.binay.microservices.persistence.entity.Address;
import com.binay.microservices.persistence.entity.IEmployee;
import com.binay.microservices.persistence.entity.PermanentEmployee;
import com.binay.microservices.persistence.entity.Person;
import com.binay.microservices.persistence.entity.enums.Designation;
import com.binay.microservices.persistence.entity.enums.PlantLocation;

@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class}
        )
@EnableDiscoveryClient
public class EmployeeManagementSystemApplication implements CommandLineRunner{

	@Autowired
	PersonDao personDao;
	@Autowired
	EmployeeDao employeeDao;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		StaticTaxData.calculateTax(180010);
		
		Person person = new Person("Binay", new Date(), new Address(1,"ABC" , "48127"));
		personDao.createPerson(person);
		List<Person> findAllPerson = personDao.findAllPerson();
		findAllPerson.stream().forEach(e -> logger.info(e.getName()));
		

		PermanentEmployee.PermanentEmployeeBuilder builder = PermanentEmployee.builder();
		PermanentEmployee permanentEmployee = builder.joiningDate(new Date())
													.exitDate(null)
													.designation(Designation.DELIVERY_HEAD)
													.plantLocation(PlantLocation.INDIA)
													.manager(null)
													.personObj(person)
													.monthlySalary(250000L)
													.build();
		
		employeeDao.createEmployee(permanentEmployee);
		
	}

}
