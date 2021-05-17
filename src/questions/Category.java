package questions;

/**
 * Enum "Category" f�r die verschiedenen Kategorien
 * welche wir f�r die Fragen benutzen wollen
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
