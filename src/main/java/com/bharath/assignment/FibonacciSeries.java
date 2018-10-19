/*
 * Input number of test cases.
 * Input the string for each test case.
 * Convert string to char array.
 * Sort the array in ascending order.
 * Store each unique character in list and key value pairs in HashMap (In value number of occurrences are stored in value)
 * then for each unique character stored in list check the given condition of fibonacci series. If any of the pairs dont satisfy the given condition then print Not Dyanamic
 * If all character pairs satisfies the given condition then print Dynamic
 * Repeat the above process for all the strings given in test cases.
 * */

package com.bharath.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class FibonacciSeries {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// get number of test cases and create arrays of appropriate length
		int numberOfTestCases = scan.nextInt();
		String[] arrayOfStrings = new String[numberOfTestCases+1];
		
		// get string for each test case
		for(int i=0; i<numberOfTestCases+1; i++) {
			arrayOfStrings[i] = scan.nextLine();
		}
		
		for (String inputString : arrayOfStrings) {
			if(inputString != null) {
				
				// hash map is used to store character and its number of occurences in key-value pair
				HashMap<Character, Integer> uniqueCharactersWithCount = new HashMap<>();
				
				// input string is stored into character array.
				char tempArray[] = inputString.toCharArray();
				
				// list is instantiated to store unique characters occurring in string.
				List<Character> listOfUniqueCharacters = new ArrayList<>();
				
				// check whether length is greater than or equal to 3. if not print dynamic
				if(tempArray.length >= 3) {
					// sort the character array
					Arrays.sort(tempArray);
					
					for(int i=0; i<tempArray.length; i++) {
						
						//get current character and check if it is already stored in hashmap and list.
						//If stored already then get value of character in hash map and increment by 1 and then store it
						// If not stored then add character to both list and hash map
						char character = tempArray[i];
						boolean isCharacterPresent = uniqueCharactersWithCount.containsKey(character);
						if(isCharacterPresent) {
							Integer currentCountOfCharacter = uniqueCharactersWithCount.get(character);
							currentCountOfCharacter++;
							uniqueCharactersWithCount.put(character, currentCountOfCharacter);
						}else {
							uniqueCharactersWithCount.put(character, 1);
							listOfUniqueCharacters.add(character);
						}
					}
				}
				boolean isDynamic = true;
				
				// if input string length is less than three then print dynamic and set flag appropriately
				if(tempArray.length < 3 && tempArray.length != 0) {
					System.out.println("Dynamic");
					isDynamic = false;
				}else {
					
					// for all list of unique characters check whether fibonacci law is satisfied. If not then set flag variable 
					for(int i=listOfUniqueCharacters.size()-1; i>=2; i--) {
						char currentCharacter = listOfUniqueCharacters.get(i);
						char lastButOneCharacter = listOfUniqueCharacters.get(i-1);
						char lastButTwoCharacter = listOfUniqueCharacters.get(i-2);
						if(uniqueCharactersWithCount.get(currentCharacter) != (uniqueCharactersWithCount.get(lastButOneCharacter)+uniqueCharactersWithCount.get(lastButTwoCharacter))) {
							isDynamic = false;
						}
					}
				}
				
				// print message according to the flag variable.
				if(isDynamic && tempArray.length != 0) {
					System.out.println("Dynamic");
				}else if(tempArray.length != 0 && !isDynamic) {
					System.out.println("Not");
				}
			}
		}
		scan.close();
	}

}
