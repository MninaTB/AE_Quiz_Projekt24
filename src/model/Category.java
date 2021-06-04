package model;

/**
 * Enum "Category" fuer die verschiedenen Kategorien
 * welche wir fuer die Fragen benutzen wollen
 * 
 */
public enum Category {
	CATEGORY_UNKNOWN("unknown"),
	CATEGORY_AE("Anwendungsentwicklung"),
	CATEGORY_ITS("IT-Systeme"),
	CATEGORY_FUN("fun"),
	CATEGORY_WGP("WGP");
	
	private final String text;
	
	Category(final String text){
		this.text = text;
	}
	
	@Override
	public String toString() {
		return this.text;
	}

}
