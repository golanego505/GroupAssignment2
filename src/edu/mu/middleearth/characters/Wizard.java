package edu.mu.middleearth.characters;

public class Wizard extends MiddleEarthCharacter {

	public Wizard(String name, Double health, Double power) {
		super(name, health, power);
	}
	
	public boolean attack(MiddleEarthCharacter target) {
		
		double criticalStrike = this.getPower()*1.5;
		
		if(target instanceof Human) {
			System.out.println("Attack ineffective against: " + target.getRace());
			return false;
		}
		else if(target instanceof Wizard) {
			System.out.println("Attack was against their own kin: " + target.getRace());
			return false;
		}
		else if(target instanceof Elf || target instanceof Orc) {
			// Do normal attack damage
			target.setHealth(target.getHealth() - this.getPower());
			System.out.println(this.getName() + " smashes " + target.getName() + " with a Rebar club for " + this.getPower() + ".");
		} else {
			// Super effective attack 1.5 times damage against Dwarf
			target.setHealth(target.getHealth() - criticalStrike);
			System.out.println(this.getName() + " hits a critical " + target.getName() + " with a Rebar club for " + criticalStrike + ".");
		}
		
		//target.setHealth(targetHealth);
		return true;
	}

	@Override
	public String getRace() {
		return "Wizard";
	}	

}
