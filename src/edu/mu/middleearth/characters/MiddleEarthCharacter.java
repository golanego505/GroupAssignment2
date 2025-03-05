package edu.mu.middleearth.characters;

public abstract class MiddleEarthCharacter {
	private String name;
	private Double health;
	private Double power;
	
	/*
	 * Constructor method
	 * Initializes all fields
	 * Fields are name, health, and power
	 */
	public MiddleEarthCharacter(String name, Double health, Double power) {
		this.name = name;
		this.health = health;
		this.power = power;
	}
	
	/*
	 * Attack function takes a MiddleEarthCharacter and subtracts from the health depending on how strong the sustained attack was
	 * Returns a boolean, true if attack was successful, false if attack did no damage.
	 * Certain MiddleEarthCharacters will have races in which they have normal effectiveness, increased effectiveness, or no effect whatsoever
	 */
	public abstract boolean attack(MiddleEarthCharacter target);
	
	/*
	 * Returns a string containing the race of a character
	 */
	public abstract String getRace();
	
	/*
	 * Prints a characters' name and stats to the terminal
	 */
	public void displayInfo() {
		System.out.println(name + "'s" + "stats are: health = " + health + ", power = " + power);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getHealth() {
		return health;
	}

	public void setHealth(Double health) {
		this.health = health;
	}

	public Double getPower() {
		return power;
	}

	public void setPower(Double power) {
		this.power = power;
	}
	

}
