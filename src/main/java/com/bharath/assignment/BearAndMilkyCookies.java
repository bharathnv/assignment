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
		int numberOfTestCases = scan.nextInt();
		int[] arrayOfMinutes = new int[numberOfTestCases];
		String[] arrayOfStrings = new String[numberOfTestCases];
		for(int i=0; i<numberOfTestCases; i++) {
			arrayOfMinutes[i] = scan.nextInt();
			arrayOfStrings[i] = scan.nextLine();
			if(arrayOfStrings[i].equals("")) {
				arrayOfStrings[i] = scan.nextLine();
			}
		}
		
		for(int i=0; i<arrayOfMinutes.length; i++) {
			int currentNumberOfMinutes = arrayOfMinutes[i];
			boolean isRuleFollowed = true;
			StringTokenizer tokenizer = new StringTokenizer(arrayOfStrings[i], " ");
			if(tokenizer.countTokens() == 1) {
				if((tokenizer.nextToken()).equals("cookie")) {
					System.out.println("NO");
				} else {
					System.out.println("YES");
				}
			}else {
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
					if(isRuleFollowed) {
						System.out.println("YES");
					}
				} else {
					System.out.println("Wrong Input");
				}
			}
		}
		scan.close();
	}
}
