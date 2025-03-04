package edu.mu.middleearth.characters;

public abstract class MiddleEarthCharacter {
	private String name;
	private Double health;
	private Double power;
	
	public MiddleEarthCharacter(String name, Double health, Double power) {
		this.name = name;
		this.health = health;
		this.power = power;
	}
	
	public abstract boolean attack(MiddleEarthCharacter target);
	
	public abstract String getRace();
	
	public void displayInfo() {
		System.out.println(name + "'s" + "stats are: health = " + health + ", power = " + power);
	}
	

}
