package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

/**
 * 
 * Start.java Start ist ein Controller zur verwaltung von aktionen des start
 * screens.
 * 
 * @author Nina, Niklas E.
 * @since 24-05-2021
 */
public class Start implements Controller {

	private Switcher switcher;
	private view.Start view;

	public Start(Switcher s) {
		this.switcher = s;
	}

	/**
	 * Initialisiert das Start view element
	 */
	public void init(Share share) {
		this.view = new view.Start();
		this.initTitleLabel();
		this.initStartButton();
		this.initOptionsButton();
		this.initExitButton();
	}

	/**
	 * Initialisiert das Title-Label
	 */
	private void initTitleLabel() {
		this.view.getTitleLabel().setText("Quiz Projekt24");
	}

	/**
	 * Initialisiert den Start-Button
	 */
	private void initStartButton() {
		this.view.getStartButton().setText("Start");
		this.view.getStartButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switcher.next(Screen.SCREEN_CATEGORY);
			}
		});
	}

	/**
	 * Initialisiert den Options-Button
	 */
	private void initOptionsButton() {
		this.view.getOptionsButton().setText("Optionen");
		this.view.getOptionsButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switcher.next(Screen.SCREEN_OPTIONS);
			}
		});
	}

	/**
	 * Initialisiert den Exit-Button
	 */
	private void initExitButton() {
		this.view.getExitButton().setText("Beenden");
		this.view.getExitButton().addActionListener(new ActionListener() {
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
