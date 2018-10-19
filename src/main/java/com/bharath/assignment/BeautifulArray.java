/*
 * Input number of test cases
 * Input number of elements in that array and then accordingly list of elements in array separated by " "
 * list of elements is taken as string so that in only one input operation we can get all the values.
 * then using String Tokenizer and Integer.parseInt() string is converted to required format.
 * check if number of elements entered and actual number mentioned in input is same or not. If not print wrong input
 * Then for each test case ai, aj where i is not equal to j check whether ak exists or not in that list of elements. If not print No and exit for that test case.
 * If above condition satisfies for all list of elements in array then print yes.
 * Repeat above process for all the test cases.
 * */

package com.bharath.assignment;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BeautifulArray {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// get number of test cases and create arrays of appropriate length
		int numberOfTestCases = scan.nextInt();
		Integer[][] arrayOfIntegerArray = new Integer[numberOfTestCases][];
		
		// for each test case get number elements so that we can form jagged array.
		for(int i=0; i<numberOfTestCases; i++) {
			int numberOfElementsInArray = scan.nextInt();
			arrayOfIntegerArray[i] = new Integer[numberOfElementsInArray];
			
			// get array in string format and converted to required format so that we can reduce number of reading operation which is costlier
			String arrayInStringFormat = scan.nextLine();
			
			// below code is written because after pressing enter it directly takes as input even though user has not entered input string
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
				// if number elements provided by the user and elements present in the array are not same then print wrong input
				System.out.println("Wrong number of inputs");
			}
		}
		
		for(int i=0; i<arrayOfIntegerArray.length; i++) {
			
			// set flag variable
			boolean isBeautifulArray = true;
			
			// for all elements in array where j is not equal to k, there should be element in array when they are multiplied 
			for(int j=0; j<arrayOfIntegerArray[i].length; j++) {
				for(int k=0; k<arrayOfIntegerArray[i].length; k++) {
					
					// this condition satisfies the above comment
					if(j!=k) {
						Integer[] currentArray = arrayOfIntegerArray[i];
						
						// check whether element is present in array or not. If not then print no and set the flag and break out of the loop
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
			
			// if flag variable is not set to false then print yes
			if(isBeautifulArray) {
				System.out.println("YES");
			}
		}
		scan.close();
	}

}
