package com.bharath.assignment;

import java.util.Scanner;
import java.util.StringTokenizer;

public class TwoNumbers {
	
	public static void main(String[] args) {	
		Scanner scan = new Scanner(System.in);
		int numberOfTestCases = scan.nextInt();
		int[][] arrayOfTestCases = new int[numberOfTestCases][3];
		for(int i=0; i<numberOfTestCases; i++) {
			String inputInStringFormat = scan.nextLine();
			if(inputInStringFormat.equals("")) {
				inputInStringFormat = scan.nextLine();
			}
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
				if(j%2==0) {
					arrayOfTestCases[i][0] = arrayOfTestCases[i][0] * 2;
				} else {
					arrayOfTestCases[i][1] = arrayOfTestCases[i][1] * 2;
				}
			}
			int max = arrayOfTestCases[i][0] > arrayOfTestCases[i][1] ? arrayOfTestCases[i][0] : arrayOfTestCases[i][1];
			int min = arrayOfTestCases[i][0] < arrayOfTestCases[i][1] ? arrayOfTestCases[i][0] : arrayOfTestCases[i][1];
			System.out.println(max/min);
		}
		scan.close();
	}
}
