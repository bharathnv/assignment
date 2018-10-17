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
