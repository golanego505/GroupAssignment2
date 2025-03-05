package edu.mu.middleearth.characters;

public class Orc extends MiddleEarthCharacter{

	/**
     * {@inheritDoc}
     */
	public Orc(String name, Double health, Double power) {
		super(name, health, power);
		// TODO Auto-generated constructor stub
	}

	/**
     * {@inheritDoc}
     */
	@Override
	public boolean attack(MiddleEarthCharacter target) {
		
		double criticalStrike = this.getPower()*1.5;
		
		if(target instanceof Elf) {
			System.out.println("Attack ineffective against: " + target.getRace());
			return false;
		}
		else if(target instanceof Orc) {
			System.out.println("Attack was against their own kin: " + target.getRace());
			return false;
		}
		else if(target instanceof Dwarf || target instanceof Wizard) {
			// Do normal attack damage
			target.setHealth(target.getHealth() - this.getPower());
			System.out.println(this.getName() + " smashes " + target.getName() + " with a Rebar club for " + this.getPower() + ".");
		} else {
			// Super effective attack 1.5 times damage against Humans
			target.setHealth(target.getHealth() - criticalStrike);
			System.out.println(this.getName() + " hits a critical " + target.getName() + " with a Rebar club for " + criticalStrike + ".");
		}
		return true;
	}

	/**
     * {@inheritDoc}
     */
	@Override
	public String getRace() {
		return "Orc";
	}	
}
