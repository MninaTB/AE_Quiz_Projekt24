package controller;

/**
 * 
 * Switcher.java
 * Interface Klasse wird von Switchern implementiert.
 * Ein next() call ueberfuehrt ein Objekt in den naechsten
 * Zustand.
 * 
 * @author Nina
 * @since 24-05-2021
 */
public interface Switcher {
	void next(Screen s);
}
