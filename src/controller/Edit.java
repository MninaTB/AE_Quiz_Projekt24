package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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

		this.question = this.store.getByID((int) share.get("KEY_EDIT_QUESTION_ID"));
		if (this.question == null) {
			// TODO: vielleicht sollten wir einen Fehlerscreen einfuehren?
			this.switcher.next(Screen.SCREEN_EXIT);
		}

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
		this.view.getQuestionTextField().setText(this.question.getQuestion());
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
		this.view.getAnswerNo1TextField().setText(this.question.getAnswers().get(0));
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
		this.view.getAnswerNo2TextField().setText(this.question.getAnswers().get(1));
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
		this.view.getAnswerNo3TextField().setText(this.question.getAnswers().get(2));
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
		this.view.getAnswerNo4TextField().setText(this.question.getAnswers().get(3));
	}

	/**
	 * Initialisiert den Save-Button
	 */
	public void initSaveButton() {
		this.view.getSaveButton().setText("Frage speichern");
		this.view.getSaveButton().addActionListener(new ActionListener() {
			@SuppressWarnings("serial")
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> aw = new ArrayList<String>() {
					{
						add(view.getAnswerNo1TextField().getText());
						add(view.getAnswerNo2TextField().getText());
						add(view.getAnswerNo3TextField().getText());
						add(view.getAnswerNo4TextField().getText());
					}
				};
				// TODO: update difficutly, solution and category
				question.setAnswers(aw);
				question.setQuestion(view.getQuestionTextField().getText());

				store.update(question);
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
				question = null;
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
