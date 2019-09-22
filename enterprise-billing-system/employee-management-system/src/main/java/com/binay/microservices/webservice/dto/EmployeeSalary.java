package com.binay.microservices.webservice.dto;

import com.binay.microservices.businesslogic.StaticTaxData;

import lombok.Data;

@Data
public class EmployeeSalary {

	String name;
	String payPeriod;
	int grossIncome;
	int incomeTax;
	int netIncome;
	int superAnn ; 
	
	public void createSalaryDataForCurrentMonth(int grossMonthlySalary)
	{
		this.grossIncome = grossMonthlySalary; 
		this.incomeTax = StaticTaxData.calculateTax(grossMonthlySalary);
		this.netIncome = this.grossIncome - this.incomeTax/12;
		this.superAnn = (int) (this.netIncome*0.9F);
	}
}
