package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import model.Question;

/**
 * 
 * Result.java Result ist ein Controller zur verwaltung von aktionen des result
 * screens.
 */
public class Result implements Controller {

	private Switcher switcher;
	private view.Result view;

	public Result(Switcher s) {
		this.switcher = s;
	}

	/**
	 * Initialisiert das Result view element
	 */
	public void init(Share share) {
		this.view = new view.Result();
		int levelFK = (int) share.get("KEY_GAME_LEVEL_FK");

		Question q = (Question) share.get("KEY_GAME_QUESTION");
		boolean win = share.get("KEY_GAME_WIN") != null;
		this.initResultLabel(win);
		if (!win) {
			int iter = (int) share.get("KEY_GAME_ITERATION");
			int iterMax = (int) share.get("KEY_GAME_ITERATION_MAX");
			int offset = (int) share.get("KEY_GAME_START_ITER");

			int level = (iter / levelFK) + 1 + (offset/levelFK);
			this.initLevelLeftLabel();
			this.initLevelRightLabel(level, iterMax/levelFK);
			this.initScoreLeftLabel();
			this.initScoreRightLabel(iter+offset, iterMax);
			this.initQuestionLeftLabel(iter + 1);
			this.initQuestionRightLabel(q.getQuestion());
			this.initPlayerAnswerLeftLabel();

			int playerAnswer = (int) share.get("KEY_GAME_YOUR_ANSWER");

			this.initPlayerAnswerRightLabel(q.getAnswers().get(playerAnswer));
			this.initCorrectAnswerLeftLabel();
			this.initCorrectAnswerRightLabel(q.getAnswers().get(q.getSolution()));
		}
		this.initHomeButton(share);
		this.initExitButton();
	}

	/**
	 * Initialisiert das Result-Label
	 */
	public void initResultLabel(boolean win) {
		this.view.getResultLabel().setText("Verloren!");
		if (win) {
			this.view.getResultLabel().setText("Gewonnen!");
			this.view.getResultLabel().setForeground(Color.GREEN);
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
	public void initLevelRightLabel(int level, int max) {
		this.view.getLevelRightLabel().setText(level + "/" + max);
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
	public void initScoreRightLabel(int reached, int max) {
		this.view.getScoreRightLabel().setText(reached + "/" + max);
	}

	/**
	 * Initialisiert das QuestionLeft-Label
	 */
	public void initQuestionLeftLabel(int iter) {
		this.view.getQuestionLeftLabel().setText(" " + iter + ". Frage:");
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
	public void initPlayerAnswerRightLabel(String answer) {
		this.view.getPlayerAnswerRightLabel().setText(answer);
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
	private void initHomeButton(Share share) {
		this.view.getHomeButton().setText("Zur Startseite");
		this.view.getHomeButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				share.put("KEY_GAME_WIN", null);
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
