package edu.mu.middleearth.charactermanagementsystem;

public class MiddleEarthCouncil {
	
	
	private static MiddleEarthCouncil instance = null;
	
	private CharacterManager manager;
	
	
	private MiddleEarthCouncil() {
		manager = new CharacterManager();
	}
	
	/**
	 * returns single instance of MiddleEarthCouncil
	 * 
	 * @return Singleton instance
	 */
	public static MiddleEarthCouncil getInstance() {
		if (instance == null) {
			instance = new MiddleEarthCouncil();
		}
		return instance;
	}
	
	/**
	 * Provides access to the CharacterManager instance
	 * @return CharacterManager instance
	 */
	public CharacterManager getCharacterManager() {
		return manager;
	}
}
