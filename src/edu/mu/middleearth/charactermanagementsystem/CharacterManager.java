package edu.mu.middleearth.charactermanagementsystem;

import edu.mu.middleearth.characters.MiddleEarthCharacter;

public class CharacterManager {
	private MiddleEarthCharacter[] characters;
	
	private int size = 1;
	private int index = 0;
	
	/*
	 * Adds Character to Array
	 * If space runs out, array is doubled in size and character is added.
	 */
	public boolean addCharacter(MiddleEarthCharacter c) {
		if(c == null) {
			return false;
		}
		//Catch case to give character array its first element
		if(index == 0) {
			characters = new MiddleEarthCharacter[size];
			characters[index] = c;
			index++;
			return true;
		}
		//Detects if array is out of space for new Character
		//Doubles array size
		//Copies elements to new larger array
		if(size == index) {
			size *= 2;
			MiddleEarthCharacter[] arrayX2 = new MiddleEarthCharacter[size];
			for(int i = 0; i < (index); i++) {
				arrayX2[i] = characters[i];
			}
			arrayX2[index] = c;
			index++;
			characters = arrayX2;
			return true;
		}
		//Runs if plenty of space for new character in array
		//Adds character to the next location array
		characters[index] = c;
		index++;
		return true;
	}
	
	/*
	 * Displays all characters in array using displayInfo()
	 */
	public void displayAllCharacters() {
		for(int i = 0; i < index; i++) {
			characters[i].displayInfo();
		}	
	}
}
