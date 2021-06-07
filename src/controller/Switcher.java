package controller;

/**
 * 
 * Switcher.java Interface Klasse wird von Switchern implementiert. Ein next()
 * call ueberfuehrt ein Objekt in den naechsten Zustand.
 * 
 */
public interface Switcher {
	void next(Screen s);
}
