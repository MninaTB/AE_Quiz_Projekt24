package view;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

/**
 * 
 * Game ist ein view, welches JComponents haelt und anbietet.
 * 
 */
public class Game {
	private JPanel content;

	private JButton homeButton;
	private JLabel titleLabel;
	private JButton exitButton;
	private JPanel topPanel;
	private JLabel questionLabel;
	private JButton answerNo1Button;
	private JButton answerNo2Button;
	private JButton answerNo3Button;
	private JButton answerNo4Button;
	private JPanel answerPanel;
	private JPanel centerPanel;
	private JLabel categoryLabel;
	private JLabel currentCategoryLabel;
	private JPanel categoryPanel;
	private JLabel levelLabel;
	private JLabel levelNo1Label;
	private JLabel levelNo2Label;
	private JLabel levelNo3Label;
	private JLabel levelNo4Label;
	private JLabel levelNo5Label;
	private JPanel levelPanel;
	private JButton jokerButton;
	private JPanel jokerPanel;
	private JPanel rightPanel;

	private final Font ARIAL_BOLD_70 = new Font("Arial", Font.BOLD, 70);
	private final Font ARIAL_PLAIN_50 = new Font("Arial", Font.PLAIN, 50);
	private final Font ARIAL_PLAIN_35 = new Font("Arial", Font.PLAIN, 35);
	private final Font ARIAL_PLAIN_20 = new Font("Arial", Font.PLAIN, 20);
	private final Color STANDARD_COLOR = Color.CYAN;
	private final Color TRANSPARENT_COLOR = new Color(0, 0, 0, 0);

	/**
	 * Konstrukor zum erzeugen eines Game views.
	 */
	public Game() {
		this.content = new JPanel();
		this.initComponents();
		this.initLayout();
	}

	/**
	 * Initialisiert components.
	 */
	private void initComponents() {
		this.homeButton = new JButton();
		this.homeButton.setFont(ARIAL_BOLD_70);
		this.homeButton.setForeground(Color.GREEN);
		this.homeButton.setBackground(TRANSPARENT_COLOR);
		this.homeButton.setContentAreaFilled(false);
		this.homeButton.setBorder(null);
		this.homeButton.setFocusPainted(false);

		this.titleLabel = new JLabel();
		this.titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		this.titleLabel.setFont(ARIAL_BOLD_70);
		this.titleLabel.setForeground(STANDARD_COLOR);
		this.titleLabel.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 5, STANDARD_COLOR));

		this.exitButton = new JButton();
		this.exitButton.setFont(ARIAL_BOLD_70);
		this.exitButton.setForeground(Color.RED);
		this.exitButton.setBackground(TRANSPARENT_COLOR);
		this.exitButton.setContentAreaFilled(false);
		this.exitButton.setBorder(null);
		this.exitButton.setFocusPainted(false);

		this.topPanel = new JPanel();
		this.topPanel.setOpaque(false);
		this.topPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, STANDARD_COLOR));

		this.questionLabel = new JLabel();
		this.questionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		this.questionLabel.setFont(ARIAL_PLAIN_50);
		this.questionLabel.setForeground(STANDARD_COLOR);

		this.answerNo1Button = new JButton();
		this.answerNo1Button.setFont(ARIAL_PLAIN_35);
		this.answerNo1Button.setForeground(STANDARD_COLOR);
		this.answerNo1Button.setBackground(TRANSPARENT_COLOR);
		this.answerNo1Button.setContentAreaFilled(false);
		this.answerNo1Button.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 2, STANDARD_COLOR));
		this.answerNo1Button.setFocusPainted(false);

		this.answerNo2Button = new JButton();
		this.answerNo2Button.setFont(ARIAL_PLAIN_35);
		this.answerNo2Button.setForeground(STANDARD_COLOR);
		this.answerNo2Button.setBackground(TRANSPARENT_COLOR);
		this.answerNo2Button.setContentAreaFilled(false);
		this.answerNo2Button.setBorder(BorderFactory.createMatteBorder(0, 3, 2, 0, STANDARD_COLOR));
		this.answerNo2Button.setFocusPainted(false);

		this.answerNo3Button = new JButton();
		this.answerNo3Button.setFont(ARIAL_PLAIN_35);
		this.answerNo3Button.setForeground(STANDARD_COLOR);
		this.answerNo3Button.setBackground(TRANSPARENT_COLOR);
		this.answerNo3Button.setContentAreaFilled(false);
		this.answerNo3Button.setBorder(BorderFactory.createMatteBorder(3, 0, 0, 2, STANDARD_COLOR));
		this.answerNo3Button.setFocusPainted(false);

		this.answerNo4Button = new JButton();
		this.answerNo4Button.setFont(ARIAL_PLAIN_35);
		this.answerNo4Button.setForeground(STANDARD_COLOR);
		this.answerNo4Button.setBackground(TRANSPARENT_COLOR);
		this.answerNo4Button.setContentAreaFilled(false);
		this.answerNo4Button.setBorder(BorderFactory.createMatteBorder(3, 3, 0, 0, STANDARD_COLOR));
		this.answerNo4Button.setFocusPainted(false);

		this.answerPanel = new JPanel();
		this.answerPanel.setOpaque(false);
		this.answerPanel.setBorder(BorderFactory.createMatteBorder(5, 0, 0, 0, STANDARD_COLOR));

		this.centerPanel = new JPanel();
		this.centerPanel.setOpaque(false);

		this.categoryLabel = new JLabel();
		this.categoryLabel.setFont(ARIAL_PLAIN_20);
		this.categoryLabel.setForeground(STANDARD_COLOR);

		this.currentCategoryLabel = new JLabel();
		this.currentCategoryLabel.setFont(ARIAL_PLAIN_20);
		this.currentCategoryLabel.setForeground(STANDARD_COLOR);

		this.categoryPanel = new JPanel();
		this.categoryPanel.setOpaque(false);

		this.levelLabel = new JLabel();
		this.levelLabel.setFont(ARIAL_PLAIN_20);
		this.levelLabel.setForeground(STANDARD_COLOR);

		this.levelNo1Label = new JLabel();
		this.levelNo1Label.setFont(ARIAL_PLAIN_20);
		this.levelNo1Label.setForeground(Color.GREEN);// TODO muss automatisiert werden mit Frage laden

		this.levelNo2Label = new JLabel();
		this.levelNo2Label.setFont(ARIAL_PLAIN_20);
		this.levelNo2Label.setForeground(Color.GREEN);// TODO muss automatisiert werden mit Frage laden

		this.levelNo3Label = new JLabel();
		this.levelNo3Label.setFont(ARIAL_PLAIN_20);
		this.levelNo3Label.setForeground(Color.YELLOW);// TODO muss automatisiert werden mit Frage laden

		this.levelNo4Label = new JLabel();
		this.levelNo4Label.setFont(ARIAL_PLAIN_20);
		this.levelNo4Label.setForeground(Color.RED);// TODO muss automatisiert werden mit Frage laden

		this.levelNo5Label = new JLabel();
		this.levelNo5Label.setFont(ARIAL_PLAIN_20);
		this.levelNo5Label.setForeground(Color.RED);// TODO muss automatisiert werden mit Frage laden

		this.levelPanel = new JPanel();
		this.levelPanel.setOpaque(false);

		this.jokerButton = new JButton();
		this.jokerButton.setBounds(15, 20, 160, 160);
		this.jokerButton.setFont(ARIAL_PLAIN_50);
		this.jokerButton.setForeground(STANDARD_COLOR);
		this.jokerButton.setBackground(TRANSPARENT_COLOR);
		this.jokerButton.setContentAreaFilled(false);
		this.jokerButton.setBorder(BorderFactory.createLineBorder(STANDARD_COLOR, 5));
		this.jokerButton.setFont(new Font("Arial", Font.PLAIN, 50));
		this.jokerButton.setBorder(BorderFactory.createLineBorder(Color.CYAN, 5));
		this.jokerButton.setFocusPainted(false);

		this.jokerPanel = new JPanel();
		this.jokerPanel.setOpaque(false);

		this.rightPanel = new JPanel();
		this.rightPanel.setOpaque(false);
		this.rightPanel.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 0, STANDARD_COLOR));
	}

	/**
	 * Initialisiert view layout.
	 */
	public void initLayout() {
		this.topPanel.setLayout(new BorderLayout());
		this.topPanel.add(homeButton, BorderLayout.WEST);
		this.topPanel.add(titleLabel, BorderLayout.CENTER);
		this.topPanel.add(exitButton, BorderLayout.EAST);

		this.answerPanel.setLayout(new GridLayout(2, 2));
		this.answerPanel.add(answerNo1Button);
		this.answerPanel.add(answerNo2Button);
		this.answerPanel.add(answerNo3Button);
		this.answerPanel.add(answerNo4Button);

		this.centerPanel.setLayout(new GridLayout(2, 1));
		this.centerPanel.add(questionLabel);
		this.centerPanel.add(answerPanel);

		this.categoryPanel.setLayout(new GridLayout(6, 1));
		this.categoryPanel.add(new JLabel());
		this.categoryPanel.add(new JLabel());
		this.categoryPanel.add(categoryLabel);
		this.categoryPanel.add(currentCategoryLabel);
		this.categoryPanel.add(new JLabel());
		this.categoryPanel.add(new JLabel());

		this.levelPanel.setLayout(new GridLayout(6, 1));
		this.levelPanel.add(levelLabel);
		this.levelPanel.add(levelNo1Label);
		this.levelPanel.add(levelNo2Label);
		this.levelPanel.add(levelNo3Label);
		this.levelPanel.add(levelNo4Label);
		this.levelPanel.add(levelNo5Label);

		this.jokerPanel.setLayout(null);
		this.jokerPanel.add(jokerButton);

		this.rightPanel.setLayout(new GridLayout(3, 1));
		this.rightPanel.add(categoryPanel);
		this.rightPanel.add(levelPanel);
		this.rightPanel.add(jokerPanel);

		this.content.setLayout(new BorderLayout());
		this.content.add(this.topPanel, BorderLayout.NORTH);
		this.content.add(this.centerPanel, BorderLayout.CENTER);
		this.content.add(this.rightPanel, BorderLayout.EAST);
	}

	/**
	 * Gibt das Content-Panel zurueck
	 * 
	 * @return JPanel
	 */
	public JPanel getContent() {
		return this.content;
	}

	/**
	 * Gibt den Home-Button zurueck
	 * 
	 * @return JButton
	 */
	public JButton getHomeButton() {
		return this.homeButton;
	}

	/**
	 * Gibt das Title-Label zurueck
	 * 
	 * @return JLabel
	 */
	public JLabel getTitleLabel() {
		return this.titleLabel;
	}

	/**
	 * Gibt den Exit-Button zurueck
	 * 
	 * @return JButton
	 */
	public JButton getExitButton() {
		return this.exitButton;
	}

	/**
	 * Gibt das Question-Label zurueck
	 * 
	 * @return JLabel
	 */
	public JLabel getQuestionLabel() {
		return this.questionLabel;
	}

	/**
	 * Gibt den AnswerNo1-Button zurueck
	 * 
	 * @return JButton
	 */
	public JButton getAnswerNo1Button() {
		return this.answerNo1Button;
	}

	/**
	 * Gibt den AnswerNo2-Button zurueck
	 * 
	 * @return JButton
	 */
	public JButton getAnswerNo2Button() {
		return this.answerNo2Button;
	}

	/**
	 * Gibt den AnswerNo3-Button zurueck
	 * 
	 * @return JButton
	 */
	public JButton getAnswerNo3Button() {
		return this.answerNo3Button;
	}

	/**
	 * Gibt den AnswerNo4-Button zurueck
	 * 
	 * @return JButton
	 */
	public JButton getAnswerNo4Button() {
		return this.answerNo4Button;
	}

	/**
	 * Gibt das Category-Label zurueck
	 * 
	 * @return JLabel
	 */
	public JLabel getCategoryLabel() {
		return this.categoryLabel;
	}

	/**
	 * Gibt das CurrentCategory-Label zurueck
	 * 
	 * @return JLabel
	 */
	public JLabel getCurrentCategoryLabel() {
		return this.currentCategoryLabel;
	}

	/**
	 * Gibt das Level-Label zurueck
	 * 
	 * @return JLabel
	 */
	public JLabel getLevelLabel() {
		return this.levelLabel;
	}

	/**
	 * Gibt das LevelNo1-Label zurueck
	 * 
	 * @return JLabel
	 */
	public JLabel getLevelNo1Label() {
		return this.levelNo1Label;
	}

	/**
	 * Gibt das LevelNo2-Label zurueck
	 * 
	 * @return JLabel
	 */
	public JLabel getLevelNo2Label() {
		return this.levelNo2Label;
	}

	/**
	 * Gibt das LevelNo3-Label zurueck
	 * 
	 * @return JLabel
	 */
	public JLabel getLevelNo3Label() {
		return this.levelNo3Label;
	}

	/**
	 * Gibt das LevelNo4-Label zurueck
	 * 
	 * @return JLabel
	 */
	public JLabel getLevelNo4Label() {
		return this.levelNo4Label;
	}

	/**
	 * Gibt das LevelNo5-Label zurueck
	 * 
	 * @return JLabel
	 */
	public JLabel getLevelNo5Label() {
		return this.levelNo5Label;
	}

	/**
	 * Gibt den Joker-Button zurueck
	 * 
	 * @return JButton
	 */
	public JButton getJokerButton() {
		return this.jokerButton;
	}
}
