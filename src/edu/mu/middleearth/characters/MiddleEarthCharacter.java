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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getHealth() {
		return health;
	}

	public void setHealth(Double health) {
		this.health = health;
	}

	public Double getPower() {
		return power;
	}

	public void setPower(Double power) {
		this.power = power;
	}
	

}
