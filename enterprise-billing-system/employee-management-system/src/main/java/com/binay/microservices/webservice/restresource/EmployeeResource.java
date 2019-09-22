package com.binay.microservices.webservice.restresource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.binay.microservices.businesslogic.StaticTaxData;
import com.binay.microservices.persistence.dao.EmployeeDao;
import com.binay.microservices.persistence.entity.IEmployee;
import com.binay.microservices.webservice.dto.EmployeeSalary;

@CrossOrigin
@RestController
public class EmployeeResource {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@GetMapping(path="/employee/salary/{employeeId}")
	public EmployeeSalary getEmployeeSalaryForMonth(@PathVariable int employeeId)
	{
		EmployeeSalary employeeSalary = new EmployeeSalary();
		
		IEmployee findEmployeeById = employeeDao.findEmployeeById(employeeId);
		if(findEmployeeById != null)
		{
			employeeSalary.setName(findEmployeeById.getPersonObj().getName());
			long monthylySalary = findEmployeeById.getMonthlySalary();
			employeeSalary.createSalaryDataForCurrentMonth((int) monthylySalary);			
		}
		else
		{
			employeeSalary.setName("EMPLOYEE NOT FOUND");
		}
		return employeeSalary;
	}
	
	@GetMapping(path="/employee")
	public List<IEmployee> getAllEmployees()
	{
		return employeeDao.findAllEmployees();
	}
	

}
