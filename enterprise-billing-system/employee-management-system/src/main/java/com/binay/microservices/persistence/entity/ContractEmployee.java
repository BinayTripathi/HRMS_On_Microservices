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
public class ContractEmployee extends IEmployee {
	
	private int contractDuration;  //Based on this exit date to be populated
	private Long hourlyRate;
	
	@Builder
	public ContractEmployee(Date joiningDate, Date exitDate, Designation designation, PlantLocation plantLocation,
			IEmployee manager, List<IEmployee> subordinates, Person personObj, int contractDuration, Long hourlyRate) {
		super(joiningDate, exitDate, EMPLOYEE_TYPE.CONTRACT, designation, plantLocation, manager, subordinates, personObj);
		this.contractDuration = contractDuration;
		this.hourlyRate = hourlyRate;
	}

	@Override
	public long getMonthlySalary() {
		return hourlyRate * 158;
	}
	
	
	
	
	
	

}
