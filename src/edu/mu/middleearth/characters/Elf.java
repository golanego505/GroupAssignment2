package edu.mu.middleearth.characters;

public class Elf extends MiddleEarthCharacter{

	/*
	 * Constructor method
	 * Initializes all fields
	 * Fields are name, health, and power
	 */
	public Elf(String name, Double health, Double power) {
		super(name, health, power);
	}

	/*
	 * Attack function takes a MiddleEarthCharacter and subtracts from the health depending on how strong the sustained attack was
	 * Returns a boolean, true if attack was successful, false if attack did no damage.
	 * Certain MiddleEarthCharacters will have races in which they have normal effectiveness, increased effectiveness, or no effect whatsoever
	 * Elf deals normal damage against Humans and Wizards
	 * Elf deals increased damage against Orcs
	 * Elf deals no damage against Dwarf and other Elves
	 */
	@Override
	public boolean attack(MiddleEarthCharacter target) {
		if(target == null) {
			return false;
		}
		double attackPower = this.getPower();
		double targetHealth = target.getHealth();
		
		String targetRace = target.getRace();
		String attackerRace = this.getRace();
		
		if(target instanceof Dwarf || target instanceof Elf) {
			System.out.println("Attack pitiful, zero damage dealt. " + attackerRace + " race is ineffective against the " + targetRace + " race.");
			return false;
		} else if (target instanceof Human || target instanceof Wizard) {
			targetHealth -= attackPower;
			System.out.println("Attack effective, " + attackPower + " damage dealt. " + attackerRace + " race inflicts normal damage against the " + targetRace + " race.");
		} else {
			attackPower *= 1.5;
			targetHealth -= attackPower;
			System.out.println("Attack devastating, " + attackPower + " damage dealt. " + attackerRace + " race is ultra effective against the " + targetRace + " race.");
		}
		if(targetHealth <= 0.0) {
			System.out.println(target.getName() + " was brutally slain!!!");
			target.setHealth(0.0);
			return true;
		}
		target.setHealth(targetHealth);
		return true;
	}
	
	
	@Override
	public String getRace() {
		return "Elf";
	}

}
