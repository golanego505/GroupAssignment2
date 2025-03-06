package edu.mu.middleearth.game;

import java.util.InputMismatchException;
import java.util.Scanner;
import edu.mu.middleearth.charactermanagementsystem.CharacterManager;
import edu.mu.middleearth.charactermanagementsystem.MiddleEarthCouncil;
import edu.mu.middleearth.characters.MiddleEarthCharacter;
import edu.mu.middleearth.characters.*;

public class MiddleEarthUI {
	
	private String race;
	private String name;
	private double HP;
	private double attackDamage;
	Scanner scanner = new Scanner(System.in);
	String[] validRaces = {"DWARF", "ELF", "HUMAN", "ORC", "WIZARD"}; //Contains all available races for addCharacter method
	
	/**
	 * Runs the menu until exit is selected (6). 
	 * Calls functions to run each menu option separately based on users choice
	 * @return true when exit is selected
	 */
	public boolean runGame() {
		MiddleEarthCouncil council = MiddleEarthCouncil.getInstance();
		CharacterManager manager = council.getCharacterManager();
		int menuChoice;
		
		while(true) { 
			this.displayMenu();
			menuChoice = this.getMenuInput();
			
			switch (menuChoice) {
				case 1:
					manager.addCharacter(this.createCharacter());
					break;
				case 2:
					manager.displayAllCharacters();
					break;
				case 3:
					this.updateCharacter(manager);
					break;
				case 4:
					break;
					//this.deleteCharacter(manager);
				case 5:
					break;
					//this.executeAttack(manager);
				case 6:
					//Exit
					System.out.println("Exiting...");
					scanner.close();
					return true;
			}
					
		}
	}
	
	/**
	 * Gets user input for a menu option.
	 * Ensures the input is an integer between 1 and 6.
	 * 
	 * @return the selected menu option (1-6)
	 */
	public int getMenuInput() {
		boolean validInput = false;
		
		while(!validInput) {
			try {
				System.out.print("Choose Menu Option (1-6): ");
				int menuChoice = scanner.nextInt();
				scanner.nextLine();
				
				// Choice must be between 1-6
				if(menuChoice < 1 || menuChoice > 6) {
					System.out.println("Invalid input. Please enter an int 1-6.");
					continue;
				}
				
				validInput = true;
				return menuChoice;
			} 
			catch (InputMismatchException e){
				System.out.println("Invalid input. Please enter an int 1-6.");
				scanner.nextLine();
			}
		}
		return 6; // Exit code if something goes wrong
	}
	
	/**
	 * Gets character attributes necessary for character creation from user and validates the inputs.
	 * 
	 * @return the character object with attributes chosen by the user
	 */
	public void getCharacterAttributes() {
		// Get character race
		while (true) {
			System.out.println("Enter Character Race from list below: ");
			for(String validRace : validRaces) {
				System.out.print(validRace + " ");
			}
			System.out.print(": ");
			race = scanner.nextLine();
			
			if(contains(validRaces, race)) {
				break; // Valid name move to next input
			}
			else {
				System.out.println("Invalid Race selected. Please try again.");			}
			}
		
		// Get character name
		while (true) {
			System.out.print("Enter Character Name: ");
			name = scanner.nextLine();
			
			if(!name.isBlank()) {
				break; // Valid name move to next input
			} 
			else {
				System.out.print("Name cannot be blank. Please try again.");
			}
		}
		
		// Get character HP
		while (true) {
			try {
				System.out.print("Enter character HP: ");
				HP = scanner.nextDouble();
				scanner.nextLine();
				break;
			}
			catch(InputMismatchException e) {
				System.out.println("Invalid input. Enter a valid number.");
				scanner.nextLine();
			}
		}
		// Get character attack damage
		while (true) {
			try {
                System.out.print("Enter Character Attack Damage: ");
                attackDamage = scanner.nextDouble();
                scanner.nextLine();
                break;
            }
            catch(InputMismatchException e) {
            	System.out.println("Invalid input. Enter a valid number.");
            	scanner.nextLine();
            }
		}
		//return this.createCharacter(race, name, HP, attackDamage);
	}
	
	/**
	 * Checks if the race chosen by the user is contained within validRaces array
	 * @param arr 
	 * @param value
	 * @return true if value is in arr false if not
	 */
	private boolean contains(String[] arr, String value) {
		for(String race : arr) {
			if(race.equalsIgnoreCase(value)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Creates a new MiddleEarthCharacter
	 * 
	 * @param race The race of the character
	 * @param name The name of the character
	 * @param HP The health points of the character
	 * @param attackDamage the attack damage of the character
	 * @return a new MiddleEarthCharacter object
	 */
	private MiddleEarthCharacter createCharacter() {
		this.getCharacterAttributes();
		race = race.toUpperCase();
		//String[] validRaces = {"DWARF", "ELF", "HUMAN", "ORC", "WIZARD"};
		switch (race) {
			case "DWARF":
				return new Dwarf(name, HP, attackDamage);
			case "ELF":
				return new Elf(name, HP, attackDamage);
			case "HUMAN":
				return new Human(name, HP, attackDamage);
			case "ORC":
				return new Orc(name, HP, attackDamage);
			case "WIZARD":
				return new Wizard(name, HP, attackDamage);
			default:
				throw new IllegalArgumentException("Invalid race: " + race);
		}
	}
	
	// Updates character with new attributes
	private boolean updateCharacter(CharacterManager manager) {
		while(true) {
			System.out.print("Enter name of character you want to update: ");
			name = scanner.nextLine();
			if(manager.getCharacter(name) == null) {
				System.out.println("Character not found.");
				continue;
			}
			MiddleEarthCharacter c = manager.getCharacter(name);
			this.getCharacterAttributes();
			manager.updateCharacter(c, name, attackDamage, HP);
			return true;
		}
	}	
	
	// Displays the Menu used to play the game
	public void displayMenu() {
		System.out.println("1. Add a new character.");
		System.out.println("2. View all characters.");
		System.out.println("3. Update a character.");
		System.out.println("4. Delete a character.");
		System.out.println("5. Execute all characters' attack actions.");
		System.out.println("6. Exit.");
	}
	
	
}
