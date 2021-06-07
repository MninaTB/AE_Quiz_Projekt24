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
 * 
 */
public class Game implements Controller {

	private Switcher switcher;
	private view.Game view;
	private State state;
	private Question question;
	private Share share;
	private int iter;
	private int levelOffset;

	public Game(Switcher s, QuestionStore store) {
		this.switcher = s;
		this.iter = 0;
	}

	/**
	 * Initialisiert das Start view element
	 */
	public void init(Share share) {
		this.share = share;
		this.view = new view.Game();
		Object offset = share.get("KEY_GAME_START_ITER");
		if (offset != null) {
			this.levelOffset = (int) share.get("KEY_GAME_START_ITER");			
		} else {
			this.levelOffset = 0;
		}
		final String key = "KEY_GAME_STATE";
		if (!share.entryExists(key)) {
			// TODO: maybe we should allow a screen switch from
			// the init func.
			System.out.println("missing game state");
			System.exit(1);
		}
		this.state = (State) share.get(key);

		this.next();
		if (this.question == null) {
			// TODO: maybe we should allow a screen switch from
			// the init func.
			System.out.println("game: question is null");
			System.exit(1);
		}

		this.initQuestion(share);

		this.initHomeButton();
		this.initTitleLabel();
		this.initExitButton();
		this.initCategoryLabel();
		this.initLevelLabel();
		this.initJokerButton();
	}

	private void next() {
		this.question = this.state.next();
		this.initQuestion(this.share);
	}

	private ActionListener AnswerWrong(int idx) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				share.put("KEY_GAME_QUESTION", question);
				share.put("KEY_GAME_YOUR_ANSWER", idx);
				share.put("KEY_GAME_ITERATION", iter);
				share.put("KEY_GAME_ITERATION_MAX", 50);
				share.put("KEY_GAME_LEVEL_FK", state.getLevelfk());
				switcher.next(Screen.SCREEN_RESULT);
			}
		};
	}

	private void initQuestion(Share share) {

		ActionListener right = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				share.put("KEY_GAME_WIN", new Object());
				next();
				if (question == null) {
					switcher.next(Screen.SCREEN_RESULT);
				}
			}
		};

		ArrayList<String> answers = this.question.getAnswers();

		this.initQuestionLabel(this.question.getQuestion());

		this.initCurrentCategoryLabel(this.question.getCategory().toString());
		switch (this.question.getSolution()) {
		case 0:
			this.initAnswerNo1Button(answers.get(0), right);
			this.initAnswerNo2Button(answers.get(1), this.AnswerWrong(1));
			this.initAnswerNo3Button(answers.get(2), this.AnswerWrong(2));
			this.initAnswerNo4Button(answers.get(3), this.AnswerWrong(3));
			break;
		case 1:
			this.initAnswerNo1Button(answers.get(0), this.AnswerWrong(0));
			this.initAnswerNo2Button(answers.get(1), right);
			this.initAnswerNo3Button(answers.get(2), this.AnswerWrong(2));
			this.initAnswerNo4Button(answers.get(3), this.AnswerWrong(3));
			break;
		case 2:
			this.initAnswerNo1Button(answers.get(0), this.AnswerWrong(0));
			this.initAnswerNo2Button(answers.get(1), this.AnswerWrong(1));
			this.initAnswerNo3Button(answers.get(2), right);
			this.initAnswerNo4Button(answers.get(3), this.AnswerWrong(3));
			break;
		case 3:
			this.initAnswerNo1Button(answers.get(0), this.AnswerWrong(0));
			this.initAnswerNo2Button(answers.get(1), this.AnswerWrong(1));
			this.initAnswerNo3Button(answers.get(2), this.AnswerWrong(2));
			this.initAnswerNo4Button(answers.get(3), right);
			break;
		default:
		}
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
	public void initQuestionLabel(String q) {
		this.view.getQuestionLabel().setText("<html><p style=\"width:800px\">"+q+"</p></html>");
	}

	/**
	 * Initialisiert den AnswerNo1-Button
	 */
	public void initAnswerNo1Button(String a, ActionListener al) {
		this.view.getAnswerNo1Button().setText("<html><p style=\"width:300px\">"+a+"</p></html>");
		this.view.getAnswerNo1Button().setVisible(true);
		this.view.getAnswerNo1Button().addActionListener(al);
	}

	/**
	 * Initialisiert den AnswerNo2-Button
	 */
	public void initAnswerNo2Button(String a, ActionListener al) {
		this.view.getAnswerNo2Button().setText("<html><p style=\"width:300px\">"+a+"</p></html>");
		this.view.getAnswerNo2Button().setVisible(true);
		this.view.getAnswerNo2Button().addActionListener(al);
	}

	/**
	 * Initialisiert den AnswerNo3-Button
	 */
	public void initAnswerNo3Button(String a, ActionListener al) {
		this.view.getAnswerNo3Button().setText("<html><p style=\"width:300px\">"+a+"</p></html>");
		this.view.getAnswerNo3Button().setVisible(true);
		this.view.getAnswerNo3Button().addActionListener(al);
	}

	/**
	 * Initialisiert den AnswerNo4-Button
	 */
	public void initAnswerNo4Button(String a, ActionListener al) {
		this.view.getAnswerNo4Button().setText("<html><p style=\"width:300px\">"+a+"</p></html>");
		this.view.getAnswerNo4Button().setVisible(true);
		this.view.getAnswerNo4Button().addActionListener(al);
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
	public void initCurrentCategoryLabel(String c) {
		this.view.getCurrentCategoryLabel().setText("  " + c);
	}

	/**
	 * Initialisiert das Level-Label
	 */
	public void initLevelLabel() {
		this.view.getLevelLabel().setText(" Level:");
		int levelfk = this.state.getLevelfk();
		int iter = this.state.getIter()+this.levelOffset+this.state.getLevelfk();
		System.out.println(iter);
		int level5 = 0;
		int level4 = 0;
		int level3 = 0;
		int level2 = 0;
		int level1 = 0;
		
		if (iter > 5*levelfk && iter <= 6*levelfk) {
			level5 = iter%levelfk;
		} else if (iter > 5*levelfk) {
			level5 = levelfk;
		}
		
		if (iter > 4*levelfk && iter <= 5*levelfk) {
			level4 = iter%levelfk;
		} else if (iter > 4*levelfk) {
			level4 = levelfk;
		}
		
		if (iter > 3*levelfk && iter <= 4*levelfk) {
			level3 = iter%levelfk;
		} else if (iter > 3*levelfk) {
			level3 = levelfk;
		}
		
		if (iter > 2*levelfk && iter <= 3*levelfk) {
			level2 = iter%levelfk;
		} else if (iter > 2*levelfk) {
			level2 = levelfk;
		}

		if (iter > 1*levelfk && iter <= 2*levelfk) {
			level1 = iter%levelfk;
		} else if (iter > 1*levelfk) {
			level1 = levelfk;
		}
		
		this.view.getLevelNo1Label().setText("  1. Level " + level1 + "/" + this.state.getLevelfk());
		this.view.getLevelNo2Label().setText("  2. Level " + level2 + "/" + this.state.getLevelfk());
		this.view.getLevelNo3Label().setText("  3. Level " + level3 + "/" + this.state.getLevelfk());
		this.view.getLevelNo4Label().setText("  4. Level " + level4 + "/" + this.state.getLevelfk());
		this.view.getLevelNo5Label().setText("  5. Level " + level5 + "/" + this.state.getLevelfk());
	}

	/**
	 * Initialisiert den Joker-Button
	 */
	public void initJokerButton() {
		this.view.getJokerButton().setEnabled(true);
		this.view.getJokerButton().setText("50/50");
		this.view.getJokerButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (question.getSolution()) {
				case 0:
					view.getAnswerNo3Button().setVisible(false);
					view.getAnswerNo4Button().setVisible(false);
					break;
				case 1:
					view.getAnswerNo3Button().setVisible(false);
					view.getAnswerNo4Button().setVisible(false);
					break;
				case 2:
					view.getAnswerNo1Button().setVisible(false);
					view.getAnswerNo4Button().setVisible(false);
					break;
				case 3:
					view.getAnswerNo1Button().setVisible(false);
					view.getAnswerNo2Button().setVisible(false);
					break;
				default:
				}
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
