package edu.mu.middleearth.characters;

public abstract class MiddleEarthCharacter {
	private String name;
	private Double health;
	private Double power;
	
	/**
	 * Constructor method
	 * Initializes all fields
	 * Fields are name, health, and power
	 *
	 * @param name Character name
	 * @param health Character health
	 * @param power Character attack damage
	 */
	public MiddleEarthCharacter(String name, Double health, Double power) {
		this.name = name;
		this.health = health;
		this.power = power;
	}
	
	/**
	 * Attack function takes a MiddleEarthCharacter and subtracts from the health depending on how strong the sustained attack was
	 * Returns a boolean, true if attack was successful, false if attack did no damage.
	 * Certain MiddleEarthCharacters will have races in which they have normal effectiveness, increased effectiveness, or no effect whatsoever
	 *
	 * @param target Character being attacked
	 * @return true if attack does damage, false if attack does not damage or target is null
	 */
	public abstract boolean attack(MiddleEarthCharacter target);
	
	/**
	 * Returns a string containing the race of a character
	 *
	 * @return Character race as a string 
	 */
	public abstract String getRace();
	
	/**
	 * Prints a characters' name and stats to the terminal
	 */
	public void displayInfo() {
		System.out.println(name + "'s " + "stats are: health = " + health + ", power = " + power);
	}
	
	
	/**
	 * Gets character name
	 * 
	 * @return Character name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets character name to name passed in
	 * 
	 * @param name Character name being set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets character health
	 * 
	 * @return Character health
	 */
	public Double getHealth() {
		return health;
	}

	/**
	 * Sets character health to health passed in
	 * 
	 * @param health Character health being set
	 */
	public void setHealth(Double health) {
		this.health = health;
	}

	/**
	 * Gets character attack damage
	 * 
	 * @return Character attack damage
	 */
	public Double getPower() {
		return power;
	}

	/**
	 * Sets Character power to power passed
	 * 
	 * @param power Character attack damage being set
	 */
	public void setPower(Double power) {
		this.power = power;
	}
	

}
