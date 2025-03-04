package edu.mu.middleearth.characters;

public class Dwarf extends MiddleEarthCharacter{

	public Dwarf(String name, Double health, Double power) {
		super(name, health, power);
	}

	@Override
	public boolean attack(MiddleEarthCharacter target) {
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
		target.setHealth(targetHealth);
		return true;
	}

	@Override
	public String getRace() {
		return "Dwarf";
	}
}
