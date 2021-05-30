package ui;

import java.util.HashMap;

import javax.swing.JPanel;

import controller.Categories;
import controller.Controller;
import controller.Options;
import controller.Screen;
import controller.Start;
import controller.Switcher;
import questions.QuestionStore;

/**
 * Registry wird zur verwaltung von Screens genutzt.
 * 
 * @author nina
 *
 */
public class Registry {
	private HashMap<Screen, Controller> intern;

	/**
	 * Konstruktor initialisiert interne map.
	 */
	public Registry() {
		this.intern = new HashMap<Screen, Controller>();
	}

	/**
	 * Initialisert Screens zusammen mit controllern.
	 * 
	 * @param s
	 */
	public void init(Switcher s, QuestionStore store) {
		this.intern.put(Screen.SCREEN_WELCOME, (Controller) new Start(s));
		this.intern.put(Screen.SCREEN_CATEGORIES, (Controller) new Categories(s, store));
		this.intern.put(Screen.SCREEN_OPTIONS, (Controller) new Options(s, store));
	}

	/**
	 * Gibt das passende panel zum uebergebenen screen zurueck.
	 * 
	 * @param s
	 * @return JPanel
	 */
	public JPanel get(Screen s) {
		return this.intern.get(s).toJPanel();
	}
}
