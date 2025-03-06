package edu.mu.middleearth.game;

import edu.mu.middleearth.charactermanagementsystem.CharacterManager;
import edu.mu.middleearth.charactermanagementsystem.MiddleEarthCouncil;
import edu.mu.middleearth.characters.*;

public class MiddleEarthAppTest {

	public void runTest() {
		// *********** Testing Characters ************
		double HP = 100.00;
		double attackPower = 50.00;
		
		Dwarf dwarf1 = new Dwarf("Dwarf", HP, attackPower);
		Elf elf1 = new Elf("Elf", HP, attackPower);
		Human human1 = new Human("Human", HP, attackPower);
		Orc orc1 = new Orc("Orc", HP, attackPower);
		Wizard wizard1 = new Wizard("Wizard", HP, attackPower);
		
		Wizard wizard2 = new Wizard("Wizard", HP, attackPower);
		
		//************ Display Info ******************
		System.out.println("******************** Display Info ********************");
		dwarf1.displayInfo();
		elf1.displayInfo();
		human1.displayInfo();
		orc1.displayInfo();
		wizard1.displayInfo();
		System.out.println();
		
		//************ Get Race **********************
		System.out.println("******************** Get Race ********************");
		System.out.println(dwarf1.getRace());
		System.out.println(elf1.getRace());
		System.out.println(human1.getRace());
		System.out.println(orc1.getRace());
		System.out.println(wizard1.getRace());
		System.out.println();
		
		//************ Attack Ineffective Race ************************
		System.out.println("******************** Attack Ineffective Race *********************");
		dwarf1.attack(wizard1);
		dwarf1.attack(dwarf1);
		elf1.attack(dwarf1);
		elf1.attack(elf1);
		human1.attack(orc1);
		human1.attack(human1);
		orc1.attack(elf1);
		orc1.attack(orc1);
		wizard1.attack(human1);
		wizard1.attack(wizard1);
		System.out.println();
		
		//************ Attack Super Effective Race *********************
		System.out.println("********************* Attack Super Effective Race ********************");
		dwarf1.attack(elf1);
		elf1.attack(orc1);
		human1.attack(wizard1);
		orc1.attack(human1);
		wizard1.attack(dwarf1);
		System.out.println();
		
		//*************** Check Health **********************
		System.out.println("*************** Check Health *****************");
		dwarf1.displayInfo();
		elf1.displayInfo();
		human1.displayInfo();
		orc1.displayInfo();
		wizard1.displayInfo();
		System.out.println();
		
		//************* Reset Health ******************
		System.out.println("Resetting Health....");
		dwarf1.setHealth(HP);
		elf1.setHealth(HP);
		human1.setHealth(HP);
		orc1.setHealth(HP);
		wizard1.setHealth(HP);
		System.out.println();
		
		//************* Normal Attack (Race 1) *****************
		System.out.println("************ Normal Attack **************");
		dwarf1.attack(human1);
		elf1.attack(human1);
		human1.attack(elf1);
		orc1.attack(dwarf1);
		wizard1.attack(elf1);
		System.out.println();
		
		//*************** Check Health **********************
		System.out.println("*************** Check Health *****************");
		dwarf1.displayInfo();
		elf1.displayInfo();
		human1.displayInfo();
		orc1.displayInfo();
		wizard1.displayInfo();
		System.out.println();
		
		//************* Reset Health ******************
		System.out.println("Resetting Health....");
		dwarf1.setHealth(HP);
		elf1.setHealth(HP);
		human1.setHealth(HP);
		orc1.setHealth(HP);
		wizard1.setHealth(HP);
		System.out.println();
		
		//************* Normal Attack (Race 2) *****************
		System.out.println("************ Normal Attack **************");
		dwarf1.attack(orc1);
		elf1.attack(wizard1);
		human1.attack(dwarf1);
		orc1.attack(wizard1);
		wizard1.attack(orc1);
		System.out.println();
		
		//*************** Check Health **********************
		System.out.println("*************** Check Health *****************");
		dwarf1.displayInfo();
		elf1.displayInfo();
		human1.displayInfo();
		orc1.displayInfo();
		wizard1.displayInfo();
		System.out.println();
		
		//************* Reset Health ******************
		System.out.println("Resetting Health....");
		dwarf1.setHealth(HP);
		elf1.setHealth(HP);
		human1.setHealth(HP);
		orc1.setHealth(HP);
		wizard1.setHealth(HP);
		System.out.println();
		
		System.out.println("******************* Testing Dynamic Array Sizing *********************");
		MiddleEarthCouncil council = MiddleEarthCouncil.getInstance();
		CharacterManager manager = council.getCharacterManager();
		
		//*********** Testing Dynamic Array Sizing ********
		
		System.out.println("--------------------------------------------------------");
		
		manager.addCharacter(dwarf1);
		System.out.println("Adding Dwarf:");
		System.out.println("Array Size: " + manager.getSize());
		manager.displayAllCharacters();
		
		System.out.println("--------------------------------------------------------");
		
		manager.addCharacter(elf1);
		System.out.println("Adding Elf:");
		System.out.println("Array Size: " + manager.getSize());
		manager.displayAllCharacters();
		
		System.out.println("--------------------------------------------------------");
		
		manager.addCharacter(human1);
		System.out.println("Adding Human:");
		System.out.println("Array Size: " + manager.getSize());
		manager.displayAllCharacters();
		
		System.out.println("--------------------------------------------------------");
		
		manager.addCharacter(orc1);
		System.out.println("Adding Orc:");
		System.out.println("Array Size: " + manager.getSize());
		manager.displayAllCharacters();
		
		System.out.println("--------------------------------------------------------");
		
		manager.addCharacter(wizard1);
		System.out.println("Adding Wizard:");
		System.out.println("Array Size: " + manager.getSize());
		manager.displayAllCharacters();
		
		System.out.println("--------------------------------------------------------");
		System.out.println("---------------------Display All------------------------");
		manager.displayAllCharacters();
		System.out.println("--------------------------------------------------------");
		System.out.println("--------------------------------------------------------");
		
		manager.deleteCharacter(dwarf1);
		System.out.println("Deleting Dwarf:");
		System.out.println("Array Size: " + manager.getSize());
		manager.displayAllCharacters();
		
		System.out.println("--------------------------------------------------------");
		
		manager.deleteCharacter(elf1);
		System.out.println("Deleting Elf:");
		System.out.println("Array Size: " + manager.getSize());
		manager.displayAllCharacters();
		
		System.out.println("--------------------------------------------------------");
		
		manager.deleteCharacter(human1);
		System.out.println("Deleting Human:");
		System.out.println("Array Size: " + manager.getSize());
		manager.displayAllCharacters();
		
		System.out.println("--------------------------------------------------------");
		
		manager.deleteCharacter(orc1);
		System.out.println("Deleting Orc:");
		System.out.println("Array Size: " + manager.getSize());
		manager.displayAllCharacters();
		
		System.out.println("--------------------------------------------------------");
		
		manager.deleteCharacter(wizard1);
		System.out.println("Deleting wizard:");
		System.out.println("Array Size: " + manager.getSize());
		manager.displayAllCharacters();
		
		System.out.println("--------------------------------------------------------");
		System.out.println("--------------------------------------------------------");
		System.out.println("------------------Delete From Empty---------------------");
		System.out.println("---------------------Print Empty------------------------");
		manager.deleteCharacter(wizard1);
		System.out.println("Attempting to delete Wizard from empty array:");
		System.out.println("Array Size: " + manager.getSize());
		manager.displayAllCharacters();
		System.out.println("--------------------------------------------------------");
		System.out.println("--------------------------------------------------------");
		System.out.println("--------------------------------------------------------");
		manager.addCharacter(dwarf1);
		System.out.println("Adding Dwarf");
		System.out.println("Array Size: " + manager.getSize());
		manager.displayAllCharacters();
		
		System.out.println("--------------------------------------------------------");
		
		manager.addCharacter(elf1);
		System.out.println("Adding Elf");
		System.out.println("Array Size: " + manager.getSize());
		manager.displayAllCharacters();
		
		System.out.println("--------------------------------------------------------");
		
		manager.addCharacter(human1);
		System.out.println("Adding Human");
		System.out.println("Array Size: " + manager.getSize());
		manager.displayAllCharacters();
		
		System.out.println("--------------------------------------------------------");
		
		manager.addCharacter(orc1);
		System.out.println("Adding Orc");
		System.out.println("Array Size: " + manager.getSize());
		manager.displayAllCharacters();
		
		System.out.println("--------------------------------------------------------");
		manager.addCharacter(wizard1);
		System.out.println("Adding Wizards");
		System.out.println("Array Size: " + manager.getSize());
		manager.displayAllCharacters();
		
		System.out.println("--------------------------------------------------------");
		System.out.println("--------------------------------------------------------");
		System.out.println("--------------------------------------------------------");
		manager.deleteCharacter(wizard2);
		System.out.println("Trying to delete character not found:");
		System.out.println("Array Size: " + manager.getSize());
		manager.displayAllCharacters();
		System.out.println("--------------------------------------------------------");
		System.out.println("--------------------------------------------------------");
		System.out.println("----------------------Display All-----------------------");
		
		manager.displayAllCharacters();
		
		System.out.println("--------------------------------------------------------");
		
	}
}
