package questions;

/**
 * Enum "Category" für die verschiedenen Kategorien
 * welche wir für die Fragen benutzen wollen
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
