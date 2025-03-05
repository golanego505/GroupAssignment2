package edu.mu.middleearth.characters;

public class Human extends MiddleEarthCharacter{

	/**
     * {@inheritDoc}
     */
	public Human(String name, Double health, Double power) {
		super(name, health, power);
	}

	/**
     * {@inheritDoc}
     */
	@Override
	public boolean attack(MiddleEarthCharacter target) {
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
		target.setHealth(targetHealth);
		return true;
	}

	/**
     * {@inheritDoc}
     */
	@Override
	public String getRace() {
		return "Human";
	}
	
}
