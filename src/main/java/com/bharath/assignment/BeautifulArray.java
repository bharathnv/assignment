package com.bharath.assignment;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BeautifulArray {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numberOfTestCases = scan.nextInt();
		Integer[][] arrayOfIntegerArray = new Integer[numberOfTestCases][];
		for(int i=0; i<numberOfTestCases; i++) {
			int numberOfElementsInArray = scan.nextInt();
			arrayOfIntegerArray[i] = new Integer[numberOfElementsInArray];
			String arrayInStringFormat = scan.nextLine();
			if(arrayInStringFormat.equals("")) {
				arrayInStringFormat = scan.nextLine();
			}
			StringTokenizer tokenizer = new StringTokenizer(arrayInStringFormat, " ");
			if(tokenizer.countTokens() == numberOfElementsInArray) {
				int j = 0;
				while(tokenizer.hasMoreTokens()) {
					arrayOfIntegerArray[i][j] = Integer.parseInt(tokenizer.nextToken());
					j++;
				}
			} else {
				System.out.println("Wrong number of inputs");
			}
		}
		
		for(int i=0; i<arrayOfIntegerArray.length; i++) {
			boolean isBeautifulArray = true;
			for(int j=0; j<arrayOfIntegerArray[i].length; j++) {
				for(int k=0; k<arrayOfIntegerArray[i].length; k++) {
					if(j!=k) {
						Integer[] currentArray = arrayOfIntegerArray[i];
						if(Arrays.asList(currentArray).indexOf(Integer.valueOf(arrayOfIntegerArray[i][j] * arrayOfIntegerArray[i][k])) < 0) {
							System.out.println("NO");
							isBeautifulArray = false;
							break;
						}
					}
				}
				if(!isBeautifulArray) {
					break;
				}
			}
			if(isBeautifulArray) {
				System.out.println("YES");
			}
		}
		scan.close();
	}

}
