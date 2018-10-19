/*
 * Input number of test cases
 * Input number for each test case.
 * convert number to string and then eventually to char array.
 * reverse the char array
 * form string using reversed char array.
 * then convert it to integer format.
 * Repeat the above process for all the test cases.
 * */

package com.bharath.assignment;

import java.util.Scanner;

public class ReverseNumber {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// get number of test cases and create arrays of appropriate length
		int numberOfTestCases = scan.nextInt();
		int[] arrayOfIntegers = new int[numberOfTestCases];
		
		// get integers for each test case
		for(int i=0; i<numberOfTestCases; i++) {
			arrayOfIntegers[i] = scan.nextInt();
		}
		
		for (int inputInteger : arrayOfIntegers) {
			// convert integer to string get characters in string stored to anarray
			String integerInString = Integer.toString(inputInteger);
			char[] charArrayOfIntegers = integerInString.toCharArray();
			char[] reverseCharArrayOfIntegers = new char[charArrayOfIntegers.length];
			
			// reverse the characters present in the array
			int j=0;
			for(int i=charArrayOfIntegers.length - 1; i>=0; i--) {
				reverseCharArrayOfIntegers[j] = charArrayOfIntegers[i];
				j++;
			}
			
			// convert reversed array of characters to string and then string to integer
			// and print reversed integer
			String reverseIntegerInString = new String(reverseCharArrayOfIntegers);
			Integer reverseInteger = Integer.parseInt(reverseIntegerInString);
			System.out.println(reverseInteger);
		}
		scan.close();
	}

}
