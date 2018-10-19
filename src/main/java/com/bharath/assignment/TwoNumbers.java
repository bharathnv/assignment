/*
 * Input number of test cases
 * Input alice's number, bob's number and number of turns in an array for each test case.
 * double the number alternatively i.e of alice's number and bob's number for given number of turns.
 * Then find maximum and minimum of those numbers 
 * print then quotient after dividing then maximum number by minimum number
 * Repeat the above process for all the test cases.
 * */

package com.bharath.assignment;

import java.util.Scanner;
import java.util.StringTokenizer;

public class TwoNumbers {
	
	public static void main(String[] args) {	
		Scanner scan = new Scanner(System.in);
		
		// get number of test cases and create arrays of appropriate length
		int numberOfTestCases = scan.nextInt();
		int[][] arrayOfTestCases = new int[numberOfTestCases][3];
		
		// for each test case input alice's, bob's number and number turns
		for(int i=0; i<numberOfTestCases; i++) {
			// get array in string format and converted to required format so that we can reduce number of reading operation which is costlier
			String inputInStringFormat = scan.nextLine();
			if(inputInStringFormat.equals("")) {
				inputInStringFormat = scan.nextLine();
			}
			
			// store alice's, bob's number and number turns in array using string tokenizer and store accordingly
			StringTokenizer tokenizer = new StringTokenizer(inputInStringFormat, " ");
			if(tokenizer.countTokens() == 3) {
				int j=0;
				while(tokenizer.hasMoreTokens()) {
					arrayOfTestCases[i][j] = Integer.parseInt(tokenizer.nextToken());
					j++;
				}
			} else {
				System.out.println("Wrong input");
			}
		}
		
		
		for(int i=0; i<arrayOfTestCases.length; i++) {
			for(int j=0; j<arrayOfTestCases[i][2]; j++) {
				// double the alice's number and bob's number alternatively for given number of turns
				if(j%2==0) {
					arrayOfTestCases[i][0] = arrayOfTestCases[i][0] * 2;
				} else {
					arrayOfTestCases[i][1] = arrayOfTestCases[i][1] * 2;
				}
			}
			
			// find maximum and minimum of those numbers
			int max = arrayOfTestCases[i][0] > arrayOfTestCases[i][1] ? arrayOfTestCases[i][0] : arrayOfTestCases[i][1];
			int min = arrayOfTestCases[i][0] < arrayOfTestCases[i][1] ? arrayOfTestCases[i][0] : arrayOfTestCases[i][1];
			
			// print max divided by min.
			System.out.println(max/min);
		}
		scan.close();
	}
}
