package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

import game.MissingQuestionsException;
import game.State;
import game.StateBuilder;
import questions.QuestionStore;

public class Category implements Controller {
	private Switcher switcher;
	private QuestionStore store;
	private view.Category view;
	private int startLevel;
	private ActionListener actionContinue;
	private State gameState;
	private ArrayList<model.Category> selectedCategories;

	public Category(Switcher s, QuestionStore store) {
		this.switcher = s;
		this.store = store;
		this.startLevel = 1;
		this.selectedCategories = new ArrayList<model.Category>();
	}

	/**
	 * Initialisiert das Edit view element
	 */
	public void init(Share share) {
		this.view = new view.Category();
		this.initCategoryLabel();
		this.initCategoriesCheckBoxes(share);
		this.initLevelLabel();
		this.initLevelNo1Button(share);
		this.initLevelNo2Button(share);
		this.initLevelNo3Button(share);
		this.initLevelNo4Button(share);
		this.initLevelNo5Button(share);
		this.initStartButton(share);
		this.actionContinue = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				share.put("KEY_GAME_STATE", gameState);
				selectedCategories = new ArrayList<model.Category>();
				switcher.next(Screen.SCREEN_GAME);
			}
		};
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
	public void initCategoriesCheckBoxes(Share share) {
		for (model.Category category : this.store.getCategories()) {
			model.Category c = category;
			if (c.toString() != "unknown" && c.toString() != "fun") {
				JCheckBox box = this.view.initAndAddNewCategoryCheckBox(category.toString());
				box.addItemListener(new ItemListener() {
					@Override
					public void itemStateChanged(ItemEvent e) {
						if (e.getStateChange() == ItemEvent.SELECTED) {
							selectedCategories.add(c);
						} else {
							selectedCategories.remove(c);
						}
						;
						updateStartButton(share);
					}
				});
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
	public void initLevelNo1Button(Share share) {
		this.view.getLevelNo1Button().setText("Level 1");
		this.view.getLevelNo1Button().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startLevel = 1;
				updateStartButton(share);
			}
		});
	}

	/**
	 * Initialisiert das LevelNo2-Button
	 */
	public void initLevelNo2Button(Share share) {
		this.view.getLevelNo2Button().setText("Level 2");
		this.view.getLevelNo2Button().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startLevel = 2;
				updateStartButton(share);
			}
		});
	}

	/**
	 * Initialisiert das LevelNo3-Button
	 */
	public void initLevelNo3Button(Share share) {
		this.view.getLevelNo3Button().setText("Level 3");
		this.view.getLevelNo3Button().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startLevel = 3;
				updateStartButton(share);
			}
		});
	}

	/**
	 * Initialisiert das LevelNo4-Button
	 */
	public void initLevelNo4Button(Share share) {
		this.view.getLevelNo4Button().setText("Level 4");
		this.view.getLevelNo4Button().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startLevel = 4;
				updateStartButton(share);
			}
		});
	}

	/**
	 * Initialisiert das LevelNo5-Button
	 */
	public void initLevelNo5Button(Share share) {
		this.view.getLevelNo5Button().setText("Level 5");
		this.view.getLevelNo5Button().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startLevel = 5;
				updateStartButton(share);
			}
		});
	}

	/**
	 * Initialisiert den Start-Button
	 */
	public void initStartButton(Share share) {
		this.view.getStartButton().setText("Bitte Kategorien auswaehlen!");
	}

	private void updateStartButton(Share share) {
		final int levelFK = 10;
		final int maxLevel = 5;
		StateBuilder s = new StateBuilder(store);
		if (s.verify(this.selectedCategories, levelFK, maxLevel, startLevel)) {
			this.view.getStartButton().setText("Weiter!");
			this.view.getStartButton().addActionListener(this.actionContinue);
			try {
				this.gameState = s.newState(this.selectedCategories, levelFK, maxLevel, startLevel);
			} catch (MissingQuestionsException e) {
				System.out.println("ups!");
				this.switcher.next(Screen.SCREEN_START);
			}
		} else {
			this.view.getStartButton().setText("Zu wenig Fragen zum starten!");
			this.view.getStartButton().removeActionListener(this.actionContinue);
		}
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
