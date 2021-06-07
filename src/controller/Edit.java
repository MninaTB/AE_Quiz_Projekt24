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
		this.initCategoryComboBox();
		this.initLevelLabel();
		this.initLevelComboBox();
		this.initAnswerNo1Label();
		this.initAnswerNo1TextField();
		this.initAnswerNo2Label();
		this.initAnswerNo2TextField();
		this.initAnswerNo3Label();
		this.initAnswerNo3TextField();
		this.initAnswerNo4Label();
		this.initAnswerNo4TextField();
		this.initSolutionSelect();
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
	 * Initialisiert die Category-ComboBox
	 */
	public void initCategoryComboBox() {
		this.view.getCategoryComboBox().addItem("");
		for (model.Category category : this.store.getCategories()) {
			model.Category c = category;
			if (c.toString() != "unknown" && c.toString() != "fun") {
				this.view.getCategoryComboBox().addItem(c.toString());
			}
		}
		this.view.getCategoryComboBox().setSelectedItem(this.question.getCategory().toString());
	}

	/**
	 * Initialisiert das Level-Label
	 */
	public void initLevelLabel() {
		this.view.getLevelLabel().setText("Level:");
	}
	
	/**
	 * Initialisiert die Level-ComboBox
	 */
	public void initLevelComboBox() {
		this.view.getLevelComboBox().addItem("1");
		this.view.getLevelComboBox().addItem("2");
		this.view.getLevelComboBox().addItem("3");
		this.view.getLevelComboBox().addItem("4");
		this.view.getLevelComboBox().addItem("5");
		
		this.view.getLevelComboBox().setSelectedItem(String.valueOf(this.question.getDifficulty()));
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
	
	public void initSolutionSelect() {
		switch(this.question.getSolution()) {
        case 0:
        	this.view.getAnswerNo1Button().setSelected(true);
            break;
        case 1:
        	this.view.getAnswerNo2Button().setSelected(true);
            break;
        case 2:
        	this.view.getAnswerNo3Button().setSelected(true);
            break;
        case 3:
        	this.view.getAnswerNo4Button().setSelected(true);
            break;
        default:
            System.out.println("Fehler: Keine Solution vorhanden");
            break;
        }
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
				question.setQuestion(view.getQuestionTextField().getText());
				question.setDifficulty(Integer.parseInt(view.getLevelComboBox().getSelectedItem().toString()));
				question.setAnswers(aw);
				question.setSolution(Integer.parseInt(view.getButtonGroup().getSelection().getActionCommand()));
				model.Category c;
				String cString = view.getCategoryComboBox().getSelectedItem().toString();
				if(cString == "") {
					c = new model.Category("unknown");
				}
				else {
					c = new model.Category(cString);
				}
				question.setCategory(c);

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
