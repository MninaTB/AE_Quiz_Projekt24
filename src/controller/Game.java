package controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import game.State;
import model.Question;
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
	private view.Game view;

	public Game(Switcher s, QuestionStore store) {
		this.switcher = s;
	}

	/**
	 * Initialisiert das Start view element
	 */
	public void init(Share share) {
		this.view = new view.Game();
		
		final String key = "KEY_GAME_STATE";
		if (!share.entryExists(key)) {
			// TODO: maybe we should allow a screen switch from
			// the init func.
			System.out.println("missing game state");
			System.exit(1);
		}
		State s = (State) share.get(key);

		Question q = s.next();
		if (q == null) {
			// TODO: maybe we should allow a screen switch from
			// the init func.
			System.out.println("game: question is null");
			System.exit(1);
		}
		ArrayList<String> answers = q.getAnswers();
		
		
		this.initHomeButton();
		this.initTitleLabel();
		this.initExitButton();
		this.initQuestionLabel();
		this.initAnswerNo1Button(answers.get(0));
		this.initAnswerNo2Button(answers.get(1));
		this.initAnswerNo3Button(answers.get(2));
		this.initAnswerNo4Button(answers.get(3));
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

				// Reaktiviert Joker Button wenn man zurueck zum Start Screen geht und spiel neu
				// startet
				// Dies muss auch am Ende eines Spiels passieren also immer wenn man Game Screen
				// verlaesst
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
		this.view.getQuestionLabel().setText("Wie lautet die erste Frage?");// TODO muss automatisiert werden mit Frage
																			// laden
	}

	/**
	 * Initialisiert den AnswerNo1-Button
	 */
	public void initAnswerNo1Button(String a) {
		this.view.getAnswerNo1Button().setText(a);
		this.view.getAnswerNo1Button().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Temporaer Result-Screen auf AnswerNo1-Button gelegt zum Testen, wieder
				// entfernen bei Spiel-Implementation
				switcher.next(Screen.SCREEN_RESULT);
				// TODO hier Spielfunktion am besten auf eine gemeinsame Methode implementieren
			}
		});
	}

	/**
	 * Initialisiert den AnswerNo2-Button
	 */
	public void initAnswerNo2Button(String a) {
		this.view.getAnswerNo2Button().setText(a);
		this.view.getAnswerNo2Button().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO hier Spielfunktion am besten auf eine gemeinsame Methode implementieren
			}
		});
	}

	/**
	 * Initialisiert den AnswerNo3-Button
	 */
	public void initAnswerNo3Button(String a) {
		this.view.getAnswerNo3Button().setText(a);
		this.view.getAnswerNo3Button().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO hier Spielfunktion am besten auf eine gemeinsame Methode implementieren
			}
		});
	}

	/**
	 * Initialisiert den AnswerNo4-Button
	 */
	public void initAnswerNo4Button(String a) {
		this.view.getAnswerNo4Button().setText(a);
		this.view.getAnswerNo4Button().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO hier Spielfunktion am besten auf eine gemeinsame Methode implementieren
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
		this.view.getCurrentCategoryLabel().setText("  WGP");// TODO muss automatisiert werden mit Frage laden
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
		this.view.getLevelNo1Label().setText("  1. Level 10/10");// TODO muss automatisiert werden mit Frage laden
	}

	/**
	 * Initialisiert das LevelNo2-Label
	 */
	public void initLevelNo2Label() {
		this.view.getLevelNo2Label().setText("  2. Level 10/10");// TODO muss automatisiert werden mit Frage laden
	}

	/**
	 * Initialisiert das LevelNo3-Label
	 */
	public void initLevelNo3Label() {
		this.view.getLevelNo3Label().setText("  3. Level 5/10");// TODO muss automatisiert werden mit Frage laden
	}

	/**
	 * Initialisiert das LevelNo4-Label
	 */
	public void initLevelNo4Label() {
		this.view.getLevelNo4Label().setText("  4. Level 0/10");// TODO muss automatisiert werden mit Frage laden
	}

	/**
	 * Initialisiert das LevelNo5-Label
	 */
	public void initLevelNo5Label() {
		this.view.getLevelNo5Label().setText("  5. Level 0/10");// TODO muss automatisiert werden mit Frage laden
	}

	/**
	 * Initialisiert den Joker-Button
	 */
	public void initJokerButton() {
		this.view.getJokerButton().setText("50/50");
		this.view.getJokerButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO hier Jokerfunktion implementieren

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
