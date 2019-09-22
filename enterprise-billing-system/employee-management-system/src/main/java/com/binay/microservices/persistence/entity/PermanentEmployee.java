package com.binay.microservices.persistence.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

import com.binay.microservices.persistence.entity.enums.Designation;
import com.binay.microservices.persistence.entity.enums.EMPLOYEE_TYPE;
import com.binay.microservices.persistence.entity.enums.PlantLocation;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class PermanentEmployee extends IEmployee {

	private Long annualSalary;

	@Builder
	public PermanentEmployee(Date joiningDate, Date exitDate, Designation designation, PlantLocation plantLocation,
			IEmployee manager, List<IEmployee> subordinates, Person personObj, Long monthlySalary) {
		super(joiningDate, exitDate,EMPLOYEE_TYPE.PERMANENT,  designation, plantLocation, manager, subordinates, personObj);
		this.annualSalary = monthlySalary;
	}

	@Override
	public long getMonthlySalary() {
		return annualSalary/12;
	}	
	
}
