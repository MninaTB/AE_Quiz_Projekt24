package questions;

/**
 * Enum "Category" fuer die verschiedenen Kategorien
 * welche wir fuer die Fragen benutzen wollen
 * 
 */
public enum Category {
	CATEGORY_UNKNOWN("unknown"),
	CATEGORY_FUN("fun");
	
	private final String text;
	
	Category(final String text){
		this.text = text;
	}
	
	@Override
	public String toString() {
		return this.text;
	}

}
