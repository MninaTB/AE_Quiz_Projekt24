package controller;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


import javax.swing.SwingConstants;
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
		this.initTitleLabel();
		this.initStartButton();
		this.initOptionsButton();
		this.initExitButton();
	}
	
	/**
	 * Initialisiert das Title-Label
	 */
	public void initTitleLabel() {
		this.view.getTitleLabel().setText("Quiz Projekt24");
		this.view.getTitleLabel().setHorizontalAlignment(SwingConstants.CENTER);
		this.view.getTitleLabel().setFont(new Font("Arial", Font.BOLD, 100));
		this.view.getTitleLabel().setForeground(Color.CYAN);
	}
	
	/**
	 * Initialisiert den Start-Button
	 */
	public void initStartButton() {
		this.view.getStartButton().setText("Start");
		this.view.getStartButton().setFont(new Font("Arial", Font.PLAIN, 50));
		this.view.getStartButton().setForeground(Color.CYAN);
		this.view.getStartButton().setContentAreaFilled(false);
		this.view.getStartButton().setBackground(new Color(0,0,0,0));
		this.view.getStartButton().setBorder(null);
		this.view.getStartButton().setFocusPainted(false);
		
		this.view.getStartButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switcher.next(Screen.SCREEN_CATEGORIES);
			}
		});
	}
	
	/**
	 * Initialisiert den Options-Button
	 */
	public void initOptionsButton() {
		this.view.getOptionsButton().setText("Optionen");
		this.view.getOptionsButton().setFont(new Font("Arial", Font.PLAIN, 50));
		this.view.getOptionsButton().setForeground(Color.CYAN);
		this.view.getOptionsButton().setContentAreaFilled(false);
		this.view.getOptionsButton().setBackground(new Color(0,0,0,0));
		this.view.getOptionsButton().setBorder(null);
		this.view.getOptionsButton().setFocusPainted(false);
		
		this.view.getOptionsButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switcher.next(Screen.SCREEN_OPTIONS);
			}
		});
	}
	
	/**
	 * Initialisiert den Exit-Button
	 */
	public void initExitButton() {
		this.view.getExitButton().setText("Beenden");
		this.view.getExitButton().setFont(new Font("Arial", Font.PLAIN, 50));
		this.view.getExitButton().setForeground(Color.CYAN);
		this.view.getExitButton().setContentAreaFilled(false);
		this.view.getExitButton().setBackground(new Color(0,0,0,0));
		this.view.getExitButton().setBorder(null);
		this.view.getExitButton().setFocusPainted(false);
		
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
