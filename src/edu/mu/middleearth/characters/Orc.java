package edu.mu.middleearth.characters;

public class Orc extends MiddleEarthCharacter{

	/*
	 * Constructor method
	 * Initializes all fields
	 * Fields are name, health, and power
	 */
	public Orc(String name, Double health, Double power) {
		super(name, health, power);
		
	}

	/*
	 * Attack function takes a MiddleEarthCharacter and subtracts from the health depending on how strong the sustained attack was
	 * Returns a boolean, true if attack was successful, false if attack did no damage.
	 * Certain MiddleEarthCharacters will have races in which they have normal effectiveness, increased effectiveness, or no effect whatsoever
	 * Orc deals normal damage against Dwarfs and Wizards
	 * Orc deals increased damage against Humans
	 * Orc deals no damage against Elves and other Orcs
	 */
	@Override
	public boolean attack(MiddleEarthCharacter target) {
		if(target == null) {
			return false;
		}
		double criticalStrike = this.getPower()*1.5;
		
		if(target instanceof Elf) {
			System.out.println("Attack ineffective against: " + target.getRace() + " Zero damage dealt");
			return false;
		}
		else if(target instanceof Orc) {
			System.out.println("Attack ineffective, cannot attack your own kin: " + target.getRace() + " Zero damage dealt");
			return false;
		}
		else if(target instanceof Dwarf || target instanceof Wizard) {
			// Do normal attack damage
			target.setHealth(target.getHealth() - this.getPower());
			System.out.println(this.getName() + " smashes " + target.getName() + " with a Rebar club for " + this.getPower() + ".");
		} else {
			// Super effective attack 1.5 times damage against Humans
			target.setHealth(target.getHealth() - criticalStrike);
			System.out.println(this.getName() + " hits a critical on " + target.getName() + " with a Rebar club for " + criticalStrike + ".");
		}
		if(target.getHealth() <= 0.0) {
			System.out.println(target.getName() + " was brutally slain!!!");
			target.setHealth(0.0);
		}
		
		return true;
	}

	
	@Override
	public String getRace() {
		return "Orc";
	}	
}
