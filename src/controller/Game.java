package controller;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import questions.QuestionStore;

/**
 * 
 * Game.java Game ist ein Controller zur verwaltung von aktionen des game
 * screens.
 * 
 * @author Niklas E.
 * 
 */
public class Game implements Controller {

	private Switcher switcher;
	//private QuestionStore store;
	private view.Game view;

	public Game(Switcher s, QuestionStore store) {
		this.switcher = s;
		//this.store = store;
		this.init();
	}

	/**
	 * Initialisiert das Start view element
	 */
	public void init() {
		this.view = new view.Game();
		this.initHomeButton();
		this.initTitleLabel();
		this.initExitButton();
		this.initQuestionLabel();
		this.initAnswerNo1Button();
		this.initAnswerNo2Button();
		this.initAnswerNo3Button();
		this.initAnswerNo4Button();
		this.initCategoryLabel();
		this.initCurrentCategoryLabel();
		this.initLevelLabel();
		this.initLevelNo1Label();
		this.initLevelNo2Label();
		this.initLevelNo3Label();
		this.initLevelNo4Label();
		this.initLevelNo5Label();
		this.initJokerButton();
	}
	
	/**
	 * Initialisiert den Home-Button
	 */
	public void initHomeButton() {
		this.view.getHomeButton().setText(" H ");
		this.view.getHomeButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switcher.next(Screen.SCREEN_START);
				
				// Reaktiviert Joker Button wenn man zurueck zum Start Screen geht und spiel neu startet
				// Dies muss auch am Ende eines Spiels passieren also immer wenn man Game Screen verlaesst
				view.getJokerButton().setEnabled(true);
				view.getJokerButton().setText("50/50");
			}
		});
	}
	
	/**
	 * Initialisiert das Title-Label
	 */
	public void initTitleLabel() {
		this.view.getTitleLabel().setText("Quiz Projekt24");
	}
	
	/**
	 * Initialisiert den Exit-Button
	 */
	public void initExitButton() {
		this.view.getExitButton().setText(" X ");
		this.view.getExitButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switcher.next(Screen.SCREEN_EXIT);
			}
		});
	}
	
	/**
	 * Initialisiert das Question-Label
	 */
	public void initQuestionLabel() {
		this.view.getQuestionLabel().setText("Wie lautet die erste Frage?");//TODO muss automatisiert werden mit Frage laden
	}
	
	/**
	 * Initialisiert den AnswerNo1-Button
	 */
	public void initAnswerNo1Button() {
		this.view.getAnswerNo1Button().setText("Erste Antwort");//TODO muss automatisiert werden mit Frage laden
		this.view.getAnswerNo1Button().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO hier Spielfunktion am besten auf eine gemeinsame Methode implementieren
			}
		});
	}
	
	/**
	 * Initialisiert den AnswerNo2-Button
	 */
	public void initAnswerNo2Button() {
		this.view.getAnswerNo2Button().setText("Zweite Antwort");//TODO muss automatisiert werden mit Frage laden
		this.view.getAnswerNo2Button().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO hier Spielfunktion am besten auf eine gemeinsame Methode implementieren
			}
		});
	}
	
	/**
	 * Initialisiert den AnswerNo3-Button
	 */
	public void initAnswerNo3Button() {
		this.view.getAnswerNo3Button().setText("Dritte Antwort");//TODO muss automatisiert werden mit Frage laden
		this.view.getAnswerNo3Button().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO hier Spielfunktion am besten auf eine gemeinsame Methode implementieren
			}
		});
	}
	
	/**
	 * Initialisiert den AnswerNo4-Button
	 */
	public void initAnswerNo4Button() {
		this.view.getAnswerNo4Button().setText("Vierte Antwort");//TODO muss automatisiert werden mit Frage laden
		this.view.getAnswerNo4Button().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO hier Spielfunktion am besten auf eine gemeinsame Methode implementieren
			}
		});
	}
	
	/**
	 * Initialisiert das Category-Label
	 */
	public void initCategoryLabel() {
		this.view.getCategoryLabel().setText(" Aktuelle Kategorie:   ");
	}
	
	/**
	 * Initialisiert das CurrentCategory-Label
	 */
	public void initCurrentCategoryLabel() {
		this.view.getCurrentCategoryLabel().setText("  WGP");//TODO muss automatisiert werden mit Frage laden
	}
	
	/**
	 * Initialisiert das Level-Label
	 */
	public void initLevelLabel() {
		this.view.getLevelLabel().setText(" Level:");
	}
	
	/**
	 * Initialisiert das LevelNo1-Label
	 */
	public void initLevelNo1Label() {
		this.view.getLevelNo1Label().setText("  1. Level 10/10");//TODO muss automatisiert werden mit Frage laden
	}
	
	/**
	 * Initialisiert das LevelNo2-Label
	 */
	public void initLevelNo2Label() {
		this.view.getLevelNo2Label().setText("  2. Level 10/10");//TODO muss automatisiert werden mit Frage laden
	}
	
	/**
	 * Initialisiert das LevelNo3-Label
	 */
	public void initLevelNo3Label() {
		this.view.getLevelNo3Label().setText("  3. Level 5/10");//TODO muss automatisiert werden mit Frage laden
	}
	
	/**
	 * Initialisiert das LevelNo4-Label
	 */
	public void initLevelNo4Label() {
		this.view.getLevelNo4Label().setText("  4. Level 0/10");//TODO muss automatisiert werden mit Frage laden
	}
	
	/**
	 * Initialisiert das LevelNo5-Label
	 */
	public void initLevelNo5Label() {
		this.view.getLevelNo5Label().setText("  5. Level 0/10");//TODO muss automatisiert werden mit Frage laden
	}
	
	/**
	 * Initialisiert den Joker-Button
	 */
	public void initJokerButton() {
		this.view.getJokerButton().setText("50/50");
		this.view.getJokerButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO hier Jokerfunktion implementieren
				
				view.getJokerButton().setEnabled(false);
				view.getJokerButton().setText("X");
				view.getJokerButton().setFont(new Font("Arial", Font.BOLD, 150));
				view.getJokerButton().setBorder(BorderFactory.createLineBorder(Color.GRAY, 5));
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
