package edu.mu.middleearth.charactermanagementsystem;

import edu.mu.middleearth.characters.MiddleEarthCharacter;

public class CharacterManager {
	private MiddleEarthCharacter[] characters;
	
	private int size = 1;
	private int index = 0;
	
	
	boolean addCharacter(MiddleEarthCharacter c) {
		if(index == 0) {
			characters = new MiddleEarthCharacter[size];
			characters[index] = c;
			index++;
			//size++;
			return true;
		}
		
		MiddleEarthCharacter[] arrayX2;
		if(size - 1 <= index) {
			size *= 2;
			arrayX2 = new MiddleEarthCharacter[size];
			
			for(int i = 0; i < (index); i++) {
				arrayX2[i] = characters[i];
			}
			index++;
			arrayX2[index] = c;
			characters = arrayX2;
			return true;
		}
		index++;
		characters[index] = c;
		return true;
	}
	
	private void displayAllCharacters() {
		if(characters != null) {
			if(size == 1) {
				characters[0].displayInfo();
			} else {
				for(int i = 0; i < index; i++) {
					characters[i].displayInfo();
				}
			}
		}
	}
}
