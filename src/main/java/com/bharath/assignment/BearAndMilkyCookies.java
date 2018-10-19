/*
 * Input number of test cases
 * Input number minutes limak stays in kitchen for each test case along with string of what limak eats (which is " " separated).
 * for each input check whether number of minutes and number of foods matches. 
 * if not print wrong input
 * if yes then check whether number of minutes is equal to 1. If yes then check what limak has ate in that minute. If its is cookie then print No
 * if number of minutes is greater than 1 then for each minute's food compare previous minute's food. If they are both equal to cookie then print No
 * If above condition is not satisfied then print yes
 * Follow the above procedure all the test cases
 * */
package com.bharath.assignment;

import java.util.Scanner;
import java.util.StringTokenizer;

public class BearAndMilkyCookies {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// get number of test cases and create arrays of appropriate length
		int numberOfTestCases = scan.nextInt();
		int[] arrayOfMinutes = new int[numberOfTestCases];
		String[] arrayOfStrings = new String[numberOfTestCases];
		
		// get input for each test case and store in array 
		for(int i=0; i<numberOfTestCases; i++) {
			arrayOfMinutes[i] = scan.nextInt();
			arrayOfStrings[i] = scan.nextLine();
			
			// below code is written because after pressing enter it directly takes as input even though user has not entered input string
			if(arrayOfStrings[i].equals("")) {
				arrayOfStrings[i] = scan.nextLine();
			}
		}
		
		// Now for each test check the given rule and if it satisfies then print yes else print no.
		for(int i=0; i<arrayOfMinutes.length; i++) {
			
			// getting number of minutes limak stayed in kitchen from array and setting flag
			int currentNumberOfMinutes = arrayOfMinutes[i];
			boolean isRuleFollowed = true;
			
			// break input string where ever the space occurs using string tokenizer
			StringTokenizer tokenizer = new StringTokenizer(arrayOfStrings[i], " ");
			
			// if number of minutes limak stayed in kitchen is equal to one then check what he ate. If it is equal to cookie then print No
			// else print yes.
			if(tokenizer.countTokens() == 1) {
				if((tokenizer.nextToken()).equals("cookie")) {
					System.out.println("NO");
				} else {
					System.out.println("YES");
				}
			}else {
				
				//if number of minutes limak stayed in kitchen is greater than one minute compare string of previous minute and
				//current minute. If both are equal to cookie then print no and get out of the loop while setting the flag variable
				if(tokenizer.countTokens() == currentNumberOfMinutes) {
					String previousWord = "";
					while(tokenizer.hasMoreTokens()) {
						String currentWord = tokenizer.nextToken();
						if(currentWord.equals("cookie")) {
							if(previousWord.equals(currentWord) ) {
								System.out.println("NO");
								isRuleFollowed = false;
								break;
							}
						}
						previousWord = currentWord;
					}
					
					// if flag variable is not set to false then print yes
					if(isRuleFollowed) {
						System.out.println("YES");
					}
				} else {
					// if number of minutes and input string doesnt match then print wrong input.
					System.out.println("Wrong Input");
				}
			}
		}
		scan.close();
	}
}
