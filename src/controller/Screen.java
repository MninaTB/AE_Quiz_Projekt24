package controller;

/**
 * 
 * Screen.java Enum zum identifizieren verschiedener screens.
 * 
 * @author Nina
 * @since 24-05-2021
 */
public enum Screen {
	SCREEN_EXIT("exit"), 
	SCREEN_WELCOME("welcome"), 
	SCREEN_CATEGORIES("categories"), 
	SCREEN_OPTIONS("options"),
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