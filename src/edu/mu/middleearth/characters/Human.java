package edu.mu.middleearth.characters;

public class Human extends MiddleEarthCharacter{

	/**
	 * Constructor method
	 * Initializes all fields
	 * Fields are name, health, and power
	 *
	 * @param name Human name 
	 * @param health Human health
	 * @param power Human attack damage
	 */
	public Human(String name, Double health, Double power) {
		super(name, health, power);
	}

	/**
	 * Attack function takes a MiddleEarthCharacter and subtracts from the health depending on how strong the sustained attack was
	 * Returns a boolean, true if attack was successful, false if attack did no damage.
	 * Certain MiddleEarthCharacters will have races in which they have normal effectiveness, increased effectiveness, or no effect whatsoever
	 * Human deals normal damage against Elves and Dwarfs
	 * Human deals increased damage against Wizard
	 * Human deals no damage against Orcs and other Humans.
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
		
		if(target instanceof Orc || target instanceof Human) {
			System.out.println("Attack pitiful, zero damage dealt. " + attackerRace + " race is ineffective against the " + targetRace + " race.");
			return false;
		} else if (target instanceof Elf || target instanceof Dwarf) {
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

	/**
	 * Get character race
	 * 
	 * @return Human race as a string
	 */
	@Override
	public String getRace() {
		return "Human";
	}
	
}
