package edu.mu.middleearth.game;

import java.util.InputMismatchException;
import java.util.Scanner;
import edu.mu.middleearth.charactermanagementsystem.CharacterManager;
import edu.mu.middleearth.charactermanagementsystem.MiddleEarthCouncil;
import edu.mu.middleearth.characters.MiddleEarthCharacter;

public class MiddleEarthUI {
	
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
					//this.addCharacter(manager);
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
		Scanner scanner = new Scanner(System.in);
		
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
	

	public MiddleEarthCharacter getCharacter() {
		return null;
		//prompt user to create a character
		//add using addCharacter from manager
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
