package controller;

/**
 * 
 * Screen.java Enum zum identifizieren verschiedener screens.
 * 
 * @author Nina
 * @since 24-05-2021
 */
public enum Screen {
	SCREEN_START("start"),
	SCREEN_CATEGORY("category"),
	SCREEN_GAME("game"),
	SCREEN_RESULT("result"),
	SCREEN_OPTIONS("options"),
	SCREEN_EDIT("edit"),
	SCREEN_CREATE("create"),
	SCREEN_EXIT("exit"),
	;
	
	private final String text;
	
	/**
	 * Konstruktor mit einem uebergabe Parameter
	 * 
	 * @param text
	 */
	Screen(final String text) {
		this.text = text;
	}
	
	/**
	 * Gibt den screen namen als string zurueck.
	 * 
	 * @returns string
	 */
	@Override
	public String toString() {
		return this.text;
	}
}