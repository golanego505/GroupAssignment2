package edu.mu.middleearth.game;

import edu.mu.middleearth.charactermanagementsystem.CharacterManager;
import edu.mu.middleearth.charactermanagementsystem.MiddleEarthCouncil;
import edu.mu.middleearth.characters.Dwarf;
import edu.mu.middleearth.characters.Elf;
import edu.mu.middleearth.characters.Human;
import edu.mu.middleearth.characters.Orc;
import edu.mu.middleearth.characters.Wizard;

public class MiddleEarthApp {

	public static void main(String[] args) {
		
		// *********** Testing Characters ************
		double HP = 100.00;
		double attackPower = 50.00;
		
		Dwarf dwarf1 = new Dwarf("Jonas", HP, attackPower);
		Elf elf1 = new Elf("Kimber", HP, attackPower);
		Human human1 = new Human("Lane", HP, attackPower);
		Orc orc1 = new Orc("Craygar", HP, attackPower);
		Wizard wizard1 = new Wizard("Harley", HP, attackPower);
		
		MiddleEarthCouncil council = MiddleEarthCouncil.getInstance();
		CharacterManager manager = council.getCharacterManager();
		
		//*********** Testing Dynamic Array Sizing ********
		manager.addCharacter(dwarf1);
		manager.addCharacter(elf1);
		manager.addCharacter(human1);
		manager.addCharacter(orc1);
		manager.addCharacter(wizard1);
		manager.displayAllCharacters();
		

	}

}
