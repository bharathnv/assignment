package com.bharath.assignment;

import java.util.Scanner;

public class ReverseNumber {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numberOfTestCases = scan.nextInt();
		int[] arrayOfIntegers = new int[numberOfTestCases];
		for(int i=0; i<numberOfTestCases; i++) {
			arrayOfIntegers[i] = scan.nextInt();
		}
		
		for (int inputInteger : arrayOfIntegers) {
			String integerInString = Integer.toString(inputInteger);
			char[] charArrayOfIntegers = integerInString.toCharArray();
			char[] reverseCharArrayOfIntegers = new char[charArrayOfIntegers.length];
			int j=0;
			for(int i=charArrayOfIntegers.length - 1; i>=0; i--) {
				reverseCharArrayOfIntegers[j] = charArrayOfIntegers[i];
				j++;
			}
			String reverseIntegerInString = new String(reverseCharArrayOfIntegers);
			Integer reverseInteger = Integer.parseInt(reverseIntegerInString);
			System.out.println(reverseInteger);
		}
		scan.close();
	}

}
