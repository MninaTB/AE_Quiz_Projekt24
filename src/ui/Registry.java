package ui;

import java.util.HashMap;

import controller.Category;
import controller.Controller;
import controller.Create;
import controller.Edit;
import controller.Game;
import controller.Options;
import controller.Result;
import controller.Screen;
import controller.Share;
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

	private Share share;

	/**
	 * Konstruktor initialisiert interne map.
	 */
	public Registry() {
		this.intern = new HashMap<Screen, Controller>();
		this.share = new Share();
	}

	/**
	 * Initialisert Screens zusammen mit controllern.
	 * 
	 * @param s
	 */
	public void init(Switcher s, QuestionStore store) {
		this.intern.put(Screen.SCREEN_START, (Controller) new Start(s));
		this.intern.put(Screen.SCREEN_CATEGORY, (Controller) new Category(s, store));
		this.intern.put(Screen.SCREEN_GAME, (Controller) new Game(s, store));
		this.intern.put(Screen.SCREEN_RESULT, (Controller) new Result(s, store));
		this.intern.put(Screen.SCREEN_OPTIONS, (Controller) new Options(s, store));
		this.intern.put(Screen.SCREEN_EDIT, (Controller) new Edit(s, store));
		this.intern.put(Screen.SCREEN_CREATE, (Controller) new Create(s, store));
	}

	/**
	 * Gibt das passende panel zum uebergebenen screen zurueck.
	 * 
	 * @param s
	 * @return JPanel
	 */
	public Controller get(Screen s) {
		return this.intern.get(s);
	}
}
