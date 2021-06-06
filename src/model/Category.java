package model;

/**
 * Enum "Category" fuer die verschiedenen Kategorien
 * welche wir fuer die Fragen benutzen wollen
 * 
 */

public class Category {
	
	private final String text;
	
	public Category(final String text) {
		
		this.text = text;
	}
	
	public String getName() {
		return this.text;
	}
}