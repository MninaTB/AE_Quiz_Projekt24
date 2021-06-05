package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import model.Question;
import questions.QuestionStore;

public class Edit implements Controller {

	private Switcher switcher;
	private QuestionStore store;
	private Question question;
	private view.Edit view;

	public Edit(Switcher s, QuestionStore store) {
		this.switcher = s;
		this.store = store;
	}

	/**
	 * Initialisiert das Edit view element
	 */
	public void init(Share share) {
		this.view = new view.Edit();
		this.initQuestionLabel();
		this.initQuestionTextField();
		this.initCategoryLabel();
		this.initLevelLabel();
		this.initAnswerNo1Label();
		this.initAnswerNo1TextField();
		this.initAnswerNo2Label();
		this.initAnswerNo2TextField();
		this.initAnswerNo3Label();
		this.initAnswerNo3TextField();
		this.initAnswerNo4Label();
		this.initAnswerNo4TextField();
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
	 * Initialisiert das Question-TextField
	 */
	public void initQuestionTextField() {
		// TODO this.view.getQuestionTextField().setText(hier uebergebene Question);
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
	 * Initialisiert das AnswerNo1-TextField
	 */
	public void initAnswerNo1TextField() {
		// TODO this.view.getAnswerNo1TextField().setText(hier uebergebene
		// QuestionAnswerNo1);
	}

	/**
	 * Initialisiert das AnswerNo2-Label
	 */
	public void initAnswerNo2Label() {
		this.view.getAnswerNo2Label().setText("Antwort Nr.2:");
	}

	/**
	 * Initialisiert das AnswerNo2-TextField
	 */
	public void initAnswerNo2TextField() {
		// TODO this.view.getAnswerNo2TextField().setText(hier uebergebene
		// QuestionAnswerNo2);
	}

	/**
	 * Initialisiert das AnswerNo3-Label
	 */
	public void initAnswerNo3Label() {
		this.view.getAnswerNo3Label().setText("Antwort Nr.3:");
	}

	/**
	 * Initialisiert das AnswerNo3-TextField
	 */
	public void initAnswerNo3TextField() {
		// TODO this.view.getAnswerNo3TextField().setText(hier uebergebene
		// QuestionAnswerNo3);
	}

	/**
	 * Initialisiert das AnswerNo4-Label
	 */
	public void initAnswerNo4Label() {
		this.view.getAnswerNo4Label().setText("Antwort Nr.4:");
	}

	/**
	 * Initialisiert das AnswerNo4-TextField
	 */
	public void initAnswerNo4TextField() {
		// TODO this.view.getAnswerNo4TextField().setText(hier uebergebene
		// QuestionAnswerNo4);
	}

	/**
	 * Initialisiert den Save-Button
	 */
	public void initSaveButton() {
		this.view.getSaveButton().setText("Frage speichern");
		this.view.getSaveButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Aenderungen an der Frage im QuestionStore abspeichern
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
