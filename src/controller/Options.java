package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import model.Category;
import model.Question;
import questions.QuestionStore;
import view.OptionsQuestionRow;

public class Options implements Controller {

	private Switcher switcher;
	private QuestionStore store;
	private view.Options view;

	public Options(Switcher s, QuestionStore store) {
		this.switcher = s;
		this.store = store;
		this.init();
	}
	
	/**
	 * Initialisiert das Start view element
	 */
	public void init() {
		this.view = new view.Options();
		this.initHomeButton();
		this.initTitleLabel();
		this.initExitButton();
		this.initQuestionFieldnameLabel();
		this.initCategoryFieldnameLabel();
		this.initLevelFieldnameLabel();
		this.initQuestionRows();
		this.initAddButton();
		this.initDeleteButton();
	}
	
	/**
	 * Initialisiert den Home-Button
	 */
	public void initHomeButton() {
		this.view.getHomeButton().setText(" H ");
		this.view.getHomeButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switcher.next(Screen.SCREEN_START);
			}
		});
	}
	
	/**
	 * Initialisiert das Title-Label
	 */
	public void initTitleLabel() {
		this.view.getTitleLabel().setText("Optionen");
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
	 * Initialisiert das QuestionFieldname-Label
	 */
	public void initQuestionFieldnameLabel() {
		this.view.getQuestionFieldnameLabel().setText("Frage");
	}
	
	/**
	 * Initialisiert das CategoryFieldname-Label
	 */
	public void initCategoryFieldnameLabel() {
		this.view.getCategoryFieldnameLabel().setText("Kategorie");
	}
	
	/**
	 * Initialisiert das LevelFieldname-Label
	 */
	public void initLevelFieldnameLabel() {
		this.view.getLevelFieldnameLabel().setText("Level");
	}
	
	/**
	 * Initialisiert die QuestionRows-ArrayList
	 */
	public void initQuestionRows() {
		for(Question q : this.store.getAllQuestions()) {
			OptionsQuestionRow oqr = new OptionsQuestionRow();
			oqr.getQuestionLabel().setText(q.getQuestion());
			var c = q.getCategory();
			if (c == null)
			{
				c = Category.CATEGORY_UNKNOWN;
			}
			oqr.getCategoryLabel().setText(c.toString());
			oqr.getLevelLabel().setText(String.valueOf(q.getDifficulty()));
			oqr.getEditButton().setText("Bearbeiten");
			oqr.getEditButton().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					switcher.next(Screen.SCREEN_EDIT);
					//TODO Infos muessen irgendwie mit in den Edit Screen uebernommen werden
				}
			});
			
			// Konnte nirgendswo im View die QuestionRows adden, funktionierte nur hier
			this.view.getCenterPanel().add(oqr.getCheckBoxPanel());
			this.view.getCenterPanel().add(oqr.getQuestionLabel());
			this.view.getCenterPanel().add(oqr.getCategoryLabel());
			this.view.getCenterPanel().add(oqr.getLevelLabel());
			this.view.getCenterPanel().add(oqr.getEditButton());
		}
	}
	
	/**
	 * Initialisiert den Add-Button
	 */
	public void initAddButton() {
		this.view.getAddButton().setText("Neue Frage erstellen");
		this.view.getAddButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switcher.next(Screen.SCREEN_CREATE);
			}
		});
	}
	
	/**
	 * Initialisiert den Delete-Button
	 */
	public void initDeleteButton() {
		this.view.getDeleteButton().setText("Frage(n) entfernen");
		this.view.getDeleteButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Ausgewaehlte Fragen loeschen
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