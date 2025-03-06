package edu.mu.middleearth.game;

import java.util.InputMismatchException;
import java.util.Arrays;
import java.util.Scanner;
import edu.mu.middleearth.charactermanagementsystem.CharacterManager;
import edu.mu.middleearth.charactermanagementsystem.MiddleEarthCouncil;
import edu.mu.middleearth.characters.MiddleEarthCharacter;

public class MiddleEarthUI {
	
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
					//this.getCharacter(manager);
					break;
				case 2:
					manager.displayAllCharacters();
					break;
				case 3:
					//this.updateCharacter(manager);
					break;
				case 4:
					//this.deleteCharacter(manager);
				case 5:
					//this.executeAttack(manager);
				case 6:
					//Exit
					System.out.println("Exiting...");
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
				scanner.close();
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
	 * Gets character attributes necessary for character creation from user and validates the input.
	 * 
	 * @return the character object with attributes chosen by the user
	 */
	public MiddleEarthCharacter getCharacter() {
		boolean validInput = false;
		
		while(!validInput) {
			try {
				//Get character race
				System.out.println("Enter Character Race from list below: ");
				for(String race : validRaces) {
					System.out.print(race + " ");
				}
				System.out.print(": ");
				name = scanner.nextLine();
				if(!(contains(validRaces, name))) {
					System.out.println("Invalid Race selected.");
					continue;
				}
				
				//Get character name
				System.out.print("Enter Character Name: ");
				name = scanner.nextLine();
				if(name.isBlank()) {
					System.out.println("Name cannot be blank.");
					continue; 
				}
				
				//Get character HP
				System.out.print("Enter character HP: ");
				HP = scanner.nextDouble();
				scanner.nextLine();
				
				//Get character attack damage
				System.out.println("Enter Character Attack Damage: ");
				attackDamage = scanner.nextDouble();
				scanner.nextLine();
				
				validInput = true;
				scanner.close();
			}
			catch(InputMismatchException e) {
				System.out.println("Invalid input. Please enter a valid number.");
				scanner.nextLine();
			}
		}
		return null;
		//return this.createCharacter();
		//prompt user to create a character
		//add using addCharacter from manager
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
	
	private MiddleEarthCharacter createCharacter(String Race, String name, double HP, double attackDamage) {
		//needs implementation
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
