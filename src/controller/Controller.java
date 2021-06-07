package controller;

import javax.swing.JPanel;

/**
 * 
 * Controller.java Interface Klasse wird von Controllern implementiert um
 * angezeigt werden zu können.
 * 
 */
public interface Controller {
	void init(Share share);

	JPanel toJPanel();
}
