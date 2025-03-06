package edu.mu.middleearth.characters;

public class Wizard extends MiddleEarthCharacter {

	/**
	 * Constructor method
	 * Initializes all fields
	 * Fields are name, health, and power
	 *
	 * @param name Name to assign to Character
	 * @param health Health to assign to Character
	 * @param power Attack damage to assign to character
	 */
	public Wizard(String name, Double health, Double power) {
		super(name, health, power);
	}
	
	/**
	 * Attack function takes a MiddleEarthCharacter and subtracts from the health depending on how strong the sustained attack was
	 * Returns a boolean, true if attack was successful, false if attack did no damage.
	 * Certain MiddleEarthCharacters will have races in which they have normal effectiveness, increased effectiveness, or no effect whatsoever
	 * Wizard deals normal damage against Elves and Orcs
	 * Wizard deals increased damage against Dwarfs
	 * Wizard deals no damage against Humans and other Wizards
	 */
	public boolean attack(MiddleEarthCharacter target) {
		if(target == null) {
			return false;
		}
		
		double criticalStrike = this.getPower()*1.5;
		
		if(target instanceof Human) {
			System.out.println("Attack ineffective against: " + target.getRace() + " Zero damage dealt");
			return false;
		}
		else if(target instanceof Wizard) {
			System.out.println("Attack ineffective, cannot attack your own kin: " + target.getRace() + " Zero damage dealt");
			return false;
		}
		else if(target instanceof Elf || target instanceof Orc) {
			// Do normal attack damage
			target.setHealth(target.getHealth() - this.getPower());
			System.out.println(this.getName() + " spears " + target.getName() + " with an ice spike " + this.getPower() + ".");
		} else {
			// Super effective attack 1.5 times damage against Dwarf
			target.setHealth(target.getHealth() - criticalStrike);
			System.out.println("Attack devistating! " + this.getName() + " hits a critical on " + target.getName() + " with an ice spike " + criticalStrike + ".");
		}
		if(target.getHealth() <= 0.0) {
			System.out.println(target.getName() + " was brutally slain!!!");
			target.setHealth(0.0);
		}
		
		return true;
	}

	
	/**
	 * Gets character race
	 * 
	 * @return Character race as a string
	 */
	@Override
	public String getRace() {
		return "Wizard";
	}	

}
