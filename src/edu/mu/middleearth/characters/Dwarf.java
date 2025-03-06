package edu.mu.middleearth.characters;

public class Dwarf extends MiddleEarthCharacter{

	/*
	 * Constructor method
	 * Initializes all fields
	 * Fields are name, health, and power
	 */
	public Dwarf(String name, Double health, Double power) {
		super(name, health, power);
	}

	/*
	 * Attack function takes a MiddleEarthCharacter and subtracts from the health depending on how strong the sustained attack was
	 * Returns a boolean, true if attack was successful, false if attack did no damage.
	 * Certain MiddleEarthCharacters will have races in which they have normal effectiveness, increased effectiveness, or no effect whatsoever
	 * Dwarf deals normal damage against Humans and Orcs
	 * Dwarf deals increased damage against Elves
	 * Dwarf deals no damage against Wizards and other Dwarfs
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
		
		if(target instanceof Wizard || target instanceof Dwarf) {
			System.out.println("Attack pitiful, zero damage dealt. " + attackerRace + " race is ineffective against the " + targetRace + " race.");
			return false;
		} else if (target instanceof Human || target instanceof Orc) {
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
		return "Dwarf";
	}
}
