/*
 * Input number of test cases
 * Input base salary for each test case.
 * if base salary is less than 1500 then hra is 0.1 multiplied by base salary and da is 0.9 multiplied by base salary
 * if base salary is greater than or equal to 1500 then hra is 500 and da is .98 multiplied by base salary
 * To get gross salary add results of hra and da with base salary. And then print base salary
 * Repeat above process for each test case.
 * */

package com.bharath.assignment;

import java.util.Scanner;

public class GrossSalary {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// get number of test cases and create arrays of appropriate length
		int numberOfTestCases = scan.nextInt();
		int[] arrayOfSalaries = new int[numberOfTestCases];
		
		// get salary for each test cases
		for(int i=0; i<numberOfTestCases; i++) {
			arrayOfSalaries[i] = scan.nextInt();
		}
		
		
		for (int inputSalary : arrayOfSalaries) {
			float grossSalary = 0.0f;
			
			// check if input salary is less than 1500 then hra is 10% of salary and da is 90% of salary
			// After calculating hra and da calculate gross salary accordingly.
			if(inputSalary < 1500) {
				float hra = (float) (0.1 * inputSalary);
				float da = (float) (0.9 * inputSalary);
				grossSalary = inputSalary + hra + da;
			} else if(inputSalary >= 1500) {
				
				
				// check if input salary is grater than or equal to 1500 then hra is 500 of salary and da is 98% of salary
				// After calculating hra and da calculate gross salary accordingly.
				float hra = 500.0f;
				float da = (float) (0.98 * inputSalary);
				grossSalary = inputSalary + hra + da;
			}
			
			// print gross salary.
			System.out.println(grossSalary);
		}
		scan.close();
	}

}
