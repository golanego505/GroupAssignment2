package edu.mu.middleearth.charactermanagementsystem;

import edu.mu.middleearth.characters.MiddleEarthCharacter;

public class CharacterManager {
	private MiddleEarthCharacter[] characters;
	
	private int size = 0;
	private int index = 0;
	
	/**
	 * USED ONLY IN OUR TESTING FILE
	 * LETS US TEST IF SIZE IF DYNAMICALLY CHANGING CORRECTLY
	 * RETURNS SIZE OF CHARACTER ARRAY
	 * 
	 * @return size of MiddleEarthCharacter array
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * Adds Character to Array
	 * If space runs out, array is doubled in size and character is added.
	 * 
	 * @param c the character you are adding 
	 * @return true if character is added successfully false if unsuccessful
	 */
	public boolean addCharacter(MiddleEarthCharacter c) {
		if(c == null) {
			return false;
		}
		//Catch case to give character array its first element
		if(size == 0) {
			size = 1;
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
	
	/**
	 * Displays all characters in array using displayInfo()
	 * 
	 */
	public void displayAllCharacters() {
		for(int i = 0; i < index; i++) {
			characters[i].displayInfo();
			
		}	
	}
	
	/**
	 * Searches character array for character by name
	 * Returns MiddleEarthCharacter if found
	 * Returns null if character not found
	 * 
	 * @param name Name of character being searched for
	 * @return Character object found with name
	 */
	public MiddleEarthCharacter getCharacter(String name) {
		for(int i = 0; i < index; i++) {
			if(characters[i].getName().equals(name)) {
				return characters[i];
			}
		}
		return null;
	}
	
	/**
	 * Allows user to update the fields of the MiddleEarthCharacter provided
	 * 
	 * @param character Character being updated
	 * @param name New character name
	 * @param health New character health
	 * @param power New character power
	 * @return true if character attributes were successfully updated. false if unsuccessful
	 */
	public boolean updateCharacter(MiddleEarthCharacter character, String name, double health, double power) {
		for(int i = 0; i < index; i++) {
			if(characters[i].equals(character)) {
				characters[i].setName(name);
				characters[i].setHealth(health);
				characters[i].setPower(power);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Deletes the character provided from the list
	 * dynamically shrinks the array size by half as space allows
	 * 
	 * @param character Character being deleted from array
	 * @return True if deleted. False if not found
	 */
	public boolean deleteCharacter(MiddleEarthCharacter character) {
		int removedIndex = -1;
		for(int i = 0; i < index; i++) {
			if(characters[i].equals(character)) {
				removedIndex = i;
			}
		}
		if(removedIndex == -1) {
			return false;
		}
		if(index == 0) {
			size = 0;
			return false;
		}
		
		index--;
		
		MiddleEarthCharacter[] halfArray;
		
		if(index <= (size/2)) {
			size /= 2;
			halfArray = new MiddleEarthCharacter[size];
		} else {
			halfArray = new MiddleEarthCharacter[size];
		}
		
		int counter = 0;
		for(int i = 0; i < (index + 1); i++) {
			if(i == removedIndex) {
				continue;
			}
			halfArray[counter] = characters[i];
			counter++;
		}
		characters = halfArray;
		return true;
	}
	
	
}
