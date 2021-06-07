package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import model.Question;
import questions.QuestionStore;

/**
 * 
 * Result.java Result ist ein Controller zur verwaltung von aktionen des result
 * screens.
 */
public class Result implements Controller {

	private Switcher switcher;
	// private QuestionStore store;
	private view.Result view;

	public Result(Switcher s, QuestionStore store) {
		this.switcher = s;
		// this.store = store;
	}

	/**
	 * Initialisiert das Result view element
	 */
	public void init(Share share) {
		this.view = new view.Result();
		
		Question q = (Question) share.get("KEY_GAME_QUESTION");
		boolean win = share.get("KEY_GAME_WIN") != null;
		this.initResultLabel(win);
		if (!win) {
			this.initLevelLeftLabel();
			this.initLevelRightLabel();
			this.initScoreLeftLabel();
			this.initScoreRightLabel();
			this.initQuestionLeftLabel();
			this.initQuestionRightLabel(q.getAnswers().get(q.getSolution()));
			this.initPlayerAnswerLeftLabel();
			this.initPlayerAnswerRightLabel();
			this.initCorrectAnswerLeftLabel();
			this.initCorrectAnswerRightLabel(q.getAnswers().get(q.getSolution()));			
		}
		this.initHomeButton();
		this.initExitButton();
	}

	/**
	 * Initialisiert das Result-Label
	 */
	public void initResultLabel(boolean win) {
		this.view.getResultLabel().setText("Verloren!");
		if (win) {
			this.view.getResultLabel().setText("Gewonnen!");
		}
		
	}

	/**
	 * Initialisiert das LevelLeft-Label
	 */
	public void initLevelLeftLabel() {
		this.view.getLevelLeftLabel().setText(" Level erreicht:");
	}

	/**
	 * Initialisiert das LevelRight-Label
	 */
	public void initLevelRightLabel() {
		this.view.getLevelRightLabel().setText("3/5");
	}

	/**
	 * Initialisiert das ScoreLeft-Label
	 */
	public void initScoreLeftLabel() {
		this.view.getScoreLeftLabel().setText(" Fragen richtig beantwortet:");
	}

	/**
	 * Initialisiert das ScoreRight-Label
	 */
	public void initScoreRightLabel() {
		this.view.getScoreRightLabel().setText("35/50");
	}

	/**
	 * Initialisiert das QuestionLeft-Label
	 */
	public void initQuestionLeftLabel() {
		this.view.getQuestionLeftLabel().setText(" 36. Frage:");
	}

	/**
	 * Initialisiert das QuestionRight-Label
	 */
	public void initQuestionRightLabel(String question) {
		this.view.getQuestionRightLabel().setText(question);
	}

	/**
	 * Initialisiert das PlayerAnswerLeft-Label
	 */
	public void initPlayerAnswerLeftLabel() {
		this.view.getPlayerAnswerLeftLabel().setText(" Deine Antwort:");
	}

	/**
	 * Initialisiert das PlayerAnswerRight-Label
	 */
	public void initPlayerAnswerRightLabel() {
		this.view.getPlayerAnswerRightLabel().setText("Zweite Antwort");
	}

	/**
	 * Initialisiert das CorrectAnswerLeft-Label
	 */
	public void initCorrectAnswerLeftLabel() {
		this.view.getCorrectAnswerLeftLabel().setText(" Richtige Antwort:");
	}

	/**
	 * Initialisiert das CorrectAnswerRight-Label
	 */
	public void initCorrectAnswerRightLabel(String solution) {
		this.view.getCorrectAnswerRightLabel().setText(solution);
	}

	/**
	 * Initialisiert den Start-Button
	 */
	private void initHomeButton() {
		this.view.getHomeButton().setText("Zur Startseite");
		this.view.getHomeButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switcher.next(Screen.SCREEN_START);
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
