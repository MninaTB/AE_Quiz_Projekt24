package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import questions.QuestionStore;

public class Category implements Controller {
	private Switcher switcher;
	private QuestionStore store;
	private view.Category view;
	
	public Category(Switcher s, QuestionStore store) {
		this.switcher = s;
		this.store = store;
	}
	
	/**
	 * Initialisiert das Edit view element
	 */
	public void init(Share share) {
		this.view = new view.Category();
		this.initCategoryLabel();
		this.initCategoriesCheckBoxes();
		this.initLevelLabel();
		this.initLevelNo1Button();
		this.initLevelNo2Button();
		this.initLevelNo3Button();
		this.initLevelNo4Button();
		this.initLevelNo5Button();
		this.initStartButton(share);
	}
	
	/**
	 * Initialisiert das Category-Label
	 */
	public void initCategoryLabel() {
		this.view.getCategoryLabel().setText("Auswahl der Kategorien:");
	}
	
	/**
	 * Initialisiert die Categories-CheckBoxes
	 */
	public void initCategoriesCheckBoxes() {
		for (model.Category category : model.Category.values()) {
			if(!category.equals(model.Category.CATEGORY_UNKNOWN) && !category.equals(model.Category.CATEGORY_FUN)) {
				this.view.initAndAddNewCategoryCheckBox(category.toString());
			}
		}
	}
	
	/**
	 * Initialisiert das Level-Label
	 */
	public void initLevelLabel() {
		this.view.getLevelLabel().setText("Auswahl des Start-Levels:");
	}
	
	/**
	 * Initialisiert das LevelNo1-Button
	 */
	public void initLevelNo1Button() {
		this.view.getLevelNo1Button().setText("Level 1");
	}
	
	/**
	 * Initialisiert das LevelNo2-Button
	 */
	public void initLevelNo2Button() {
		this.view.getLevelNo2Button().setText("Level 2");
	}
	
	/**
	 * Initialisiert das LevelNo3-Button
	 */
	public void initLevelNo3Button() {
		this.view.getLevelNo3Button().setText("Level 3");
	}
	
	/**
	 * Initialisiert das LevelNo4-Button
	 */
	public void initLevelNo4Button() {
		this.view.getLevelNo4Button().setText("Level 4");
	}
	
	/**
	 * Initialisiert das LevelNo5-Button
	 */
	public void initLevelNo5Button() {
		this.view.getLevelNo5Button().setText("Level 5");
	}
	
	/**
	 * Initialisiert den Start-Button
	 */
	public void initStartButton(Share share) {
		this.view.getStartButton().setText("Weiter");
		this.view.getStartButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Kategorien und Start-Level muss in den Game Screen uebernommen werden
				switcher.next(Screen.SCREEN_GAME);
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
