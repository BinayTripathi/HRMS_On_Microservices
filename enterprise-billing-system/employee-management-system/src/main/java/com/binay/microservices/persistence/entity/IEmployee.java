package com.binay.microservices.persistence.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.binay.microservices.persistence.entity.enums.Designation;
import com.binay.microservices.persistence.entity.enums.EMPLOYEE_TYPE;
import com.binay.microservices.persistence.entity.enums.PlantLocation;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor    /*Boiler plate getter/setter constructor removed*/
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class IEmployee {
	
	@Id
	@GeneratedValue
	private Long id;
	private Date joiningDate;
	
	@Column(nullable=true)
	private Date exitDate;
	
	@Enumerated(EnumType.STRING)
	private EMPLOYEE_TYPE employeeType;
	
	@Enumerated(EnumType.STRING)
	private Designation designation;
	
	@Enumerated(EnumType.ORDINAL)
	private PlantLocation plantLocation;	

	@JsonBackReference
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="manager_id")    /*New column referencing the same table*/
	private IEmployee manager;
	
	@JsonManagedReference
	@OneToMany(mappedBy="manager")   // Mapped by should be on 'One's side and One to May by default is lazy fetch
	private List<IEmployee> subordinates = new ArrayList<IEmployee>();
	
	@JsonBackReference
	@ManyToOne(fetch=FetchType.LAZY)
	private Person personObj;
	
	public abstract long getMonthlySalary();


	public void addSubordinate(IEmployee subordinate)
	{
		subordinates.add(subordinate);
	}
	
	public void removeSubordinate(IEmployee subordinate)
	{
		subordinates.remove(subordinate);
	}

	public IEmployee(Date joiningDate, Date exitDate,EMPLOYEE_TYPE employeeType, Designation designation, PlantLocation plantLocation,
			IEmployee manager, List<IEmployee> subordinates, Person personObj) {
		super();
		this.joiningDate = joiningDate;
		this.exitDate = exitDate;
		this.employeeType = employeeType;
		this.designation = designation;
		this.plantLocation = plantLocation;
		this.manager = manager;
		this.subordinates = subordinates;
		this.personObj = personObj;
	}

}
