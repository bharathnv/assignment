package com.bharath.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class FibonacciSeries {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numberOfTestCases = scan.nextInt();
		String[] arrayOfStrings = new String[numberOfTestCases+1];
		for(int i=0; i<numberOfTestCases+1; i++) {
			arrayOfStrings[i] = scan.nextLine();
		}
		
		for (String inputString : arrayOfStrings) {
			if(inputString != null) {
				HashMap<Character, Integer> uniqueCharactersWithCount = new HashMap<>();
				char tempArray[] = inputString.toCharArray();
				List<Character> listOfUniqueCharacters = new ArrayList<>();
				if(tempArray.length >= 3) {
					Arrays.sort(tempArray);
					for(int i=0; i<tempArray.length; i++) {
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
				if(tempArray.length < 3 && tempArray.length != 0) {
					System.out.println("Dynamic");
					isDynamic = false;
				}else {
					for(int i=listOfUniqueCharacters.size()-1; i>=2; i--) {
						char currentCharacter = listOfUniqueCharacters.get(i);
						char lastButOneCharacter = listOfUniqueCharacters.get(i-1);
						char lastButTwoCharacter = listOfUniqueCharacters.get(i-2);
						if(uniqueCharactersWithCount.get(currentCharacter) != (uniqueCharactersWithCount.get(lastButOneCharacter)+uniqueCharactersWithCount.get(lastButTwoCharacter))) {
							isDynamic = false;
						}
					}
				}
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
