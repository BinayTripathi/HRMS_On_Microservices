package com.binay.microservices.businesslogic;

import java.util.ArrayList;
import java.util.List;

public class StaticTaxData {
	
	public static int calculateTax(int salary)
	{
		float tax = new TAX_SLAB().findTax(salary);
		return Math.round(tax);
	}

	//Change it to Interval tree
	private static class TAX_SLAB
	{
		private List<Integer> SLAB_UPPER_LIMIT = new ArrayList<Integer>();
		private List<Integer> BASE_TAX = new ArrayList<Integer>();
		private List<Float> TAX_RATE = new ArrayList<Float>();
		
		
		private TAX_SLAB()
		{
			SLAB_UPPER_LIMIT.add(18200);
			BASE_TAX.add(0);
			TAX_RATE.add(0F);
			
			SLAB_UPPER_LIMIT.add(37000);
			BASE_TAX.add(0);
			TAX_RATE.add(.19F);
			
			SLAB_UPPER_LIMIT.add(87000);
			BASE_TAX.add(3572);
			TAX_RATE.add(0.325F);
			
			SLAB_UPPER_LIMIT.add(180000);
			BASE_TAX.add(19822);
			TAX_RATE.add(0.37F);
			
			SLAB_UPPER_LIMIT.add(Integer.MAX_VALUE);
			BASE_TAX.add(54232);
			TAX_RATE.add(0.45F);
		}
		
		float findTax(int salary)
		{
			salary = salary * 12;
			int index = -1;
			int remainingSalary = salary;
			float tax = 0;
			for(int uSlab:SLAB_UPPER_LIMIT)
			{
				
				int lowerRangeSlab;
				int upperRangeSlab;
				if(index++ ==-1)
					lowerRangeSlab=0;
				else
					lowerRangeSlab = SLAB_UPPER_LIMIT.get(index-1)+1;
				
				upperRangeSlab = uSlab;
				int slabRange = upperRangeSlab - lowerRangeSlab;
				if(remainingSalary > slabRange)
				{
					remainingSalary = remainingSalary - slabRange;
					tax += BASE_TAX.get(index) + TAX_RATE.get(index) * slabRange;
				}	
				else
					tax += BASE_TAX.get(index) + TAX_RATE.get(index) * remainingSalary;
					
			}
			return tax;
			
		}
	}
	
}
