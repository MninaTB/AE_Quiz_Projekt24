package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

/**
 * 
 * Start.java Start ist ein Controller zur verwaltung von aktionen des start
 * screens.
 * 
 * @author Nina
 * @since 24-05-2021
 */
public class Start implements Controller {

	Switcher switcher;
	view.Start view;

	public Start(Switcher s) {
		this.switcher = s;
		this.init();
	}

	/**
	 * Initialisiert das Start view element
	 */
	public void init() {
		this.view = new view.Start();
		this.view.getFirst().setText("Start");
		this.view.getFirst().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switcher.next(Screen.SCREEN_CATEGORIES);
			}
		});
		this.view.getSecond().setText("Optionen");
		this.view.getSecond().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switcher.next(Screen.SCREEN_OPTIONS);
			}
		});

		this.view.getThird().setText("Beenden");
		this.view.getThird().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switcher.next(Screen.SCREEN_EXIT);
			}
		});
	}

	/**
	 * Implementiert das Controller interface.
	 * 
	 * @return JPanel
	 */
	public JPanel toJPanel() {
		return this.view.getContent();
	}
}
