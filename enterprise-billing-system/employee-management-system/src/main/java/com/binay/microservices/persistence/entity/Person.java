package com.binay.microservices.persistence.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter  @NoArgsConstructor
public class Person {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private	Date birthDate;
	
	@Embedded
	private Address currentAddress;
	
	@JsonManagedReference
	@OneToMany(mappedBy="personObj", fetch = FetchType.LAZY)
	private List<IEmployee> employmentRecord = new ArrayList<IEmployee>();

	public Person(String name, Date birthDate, Address currentAddress) {
		super();
		this.name = name;
		this.birthDate = birthDate;
		this.currentAddress = currentAddress;
	}
	
	
	public void addEmploymentRecord(IEmployee employee)
	{
		employmentRecord.add(employee);
	}
	
	public void removeEmploymentRecord(IEmployee employee)
	{
		employmentRecord.remove(employee);
	}
}
