package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import questions.QuestionStore;

public class Create implements Controller {

	private Switcher switcher;
	private QuestionStore store;
	private view.Edit view;

	public Create(Switcher s, QuestionStore store) {
		this.switcher = s;
		this.store = store;
	}

	/**
	 * Initialisiert das Edit view element
	 */
	public void init(Share share) {
		this.view = new view.Edit();
		this.initQuestionLabel();
		this.initCategoryLabel();
		this.initLevelLabel();
		this.initAnswerNo1Label();
		this.initAnswerNo2Label();
		this.initAnswerNo3Label();
		this.initAnswerNo4Label();
		this.initSaveButton();
		this.initCancelButton();
	}

	/**
	 * Initialisiert das Question-Label
	 */
	public void initQuestionLabel() {
		this.view.getQuestionLabel().setText("Frage:");
	}

	/**
	 * Initialisiert das Category-Label
	 */
	public void initCategoryLabel() {
		this.view.getCategoryLabel().setText("Kategorie:");
	}

	/**
	 * Initialisiert das Level-Label
	 */
	public void initLevelLabel() {
		this.view.getLevelLabel().setText("Level:");
	}

	/**
	 * Initialisiert das AnswerNo1-Label
	 */
	public void initAnswerNo1Label() {
		this.view.getAnswerNo1Label().setText("Antwort Nr.1:");
	}

	/**
	 * Initialisiert das AnswerNo2-Label
	 */
	public void initAnswerNo2Label() {
		this.view.getAnswerNo2Label().setText("Antwort Nr.2:");
	}

	/**
	 * Initialisiert das AnswerNo3-Label
	 */
	public void initAnswerNo3Label() {
		this.view.getAnswerNo3Label().setText("Antwort Nr.3:");
	}

	/**
	 * Initialisiert das AnswerNo4-Label
	 */
	public void initAnswerNo4Label() {
		this.view.getAnswerNo4Label().setText("Antwort Nr.4:");
	}

	/**
	 * Initialisiert den Save-Button
	 */
	public void initSaveButton() {
		this.view.getSaveButton().setText("Frage speichern");
		this.view.getSaveButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Neue Frage dem QuestionStore hinzufuegen
				switcher.next(Screen.SCREEN_OPTIONS);
			}
		});
	}

	/**
	 * Initialisiert den Cancel-Button
	 */
	public void initCancelButton() {
		this.view.getCancelButton().setText("Abbrechen");
		this.view.getCancelButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switcher.next(Screen.SCREEN_OPTIONS);
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
