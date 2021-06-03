package view;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;

/**
 * 
 * Result ist ein view, welches JComponents
 * haelt und anbietet.
 */
public class Result {
	private JPanel content;
	
	private JLabel resultLabel;
	private JLabel levelLeftLabel;
	private JLabel levelRightLabel;
	private JLabel scoreLeftLabel;
	private JLabel scoreRightLabel;
	private JLabel questionLeftLabel;
	private JLabel questionRightLabel;
	private JLabel playerAnswerLeftLabel;
	private JLabel playerAnswerRightLabel;
	private JLabel correctAnswerLeftLabel;
	private JLabel correctAnswerRightLabel;
	private JPanel resultPanel;
	private JButton homeButton;
	private JButton exitButton;
	private JPanel buttonPanel;
	
	private final Font ARIAL_BOLD_100 = new Font("Arial", Font.BOLD, 100);
	private final Font ARIAL_PLAIN_50 = new Font("Arial", Font.PLAIN, 50);
	private final Font ARIAL_PLAIN_30 = new Font("Arial", Font.PLAIN, 30);
	private final Color STANDARD_COLOR = Color.CYAN;
	private final Color TRANSPARENT_COLOR = new Color(0,0,0,0);
	
	/**
	 * Konstrukor zum erzeugen eines Start views.
	 */
	public Result() {
		this.content = new JPanel();
		this.initComponents();
		this.initLayout();
	}
	
	/**
	 * Initialisiert components.
	 */
	private void initComponents() {
		this.resultLabel = new JLabel();
		this.resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
		this.resultLabel.setFont(ARIAL_BOLD_100);
		this.resultLabel.setForeground(Color.RED);
		
		this.levelLeftLabel = new JLabel();
		this.levelLeftLabel.setFont(ARIAL_PLAIN_30);
		this.levelLeftLabel.setForeground(STANDARD_COLOR);
		
		this.levelRightLabel = new JLabel();
		this.levelRightLabel.setFont(ARIAL_PLAIN_30);
		this.levelRightLabel.setForeground(STANDARD_COLOR);
		
		this.scoreLeftLabel = new JLabel();
		this.scoreLeftLabel.setFont(ARIAL_PLAIN_30);
		this.scoreLeftLabel.setForeground(STANDARD_COLOR);
		
		this.scoreRightLabel = new JLabel();
		this.scoreRightLabel.setFont(ARIAL_PLAIN_30);
		this.scoreRightLabel.setForeground(STANDARD_COLOR);
		
		this.questionLeftLabel = new JLabel();
		this.questionLeftLabel.setFont(ARIAL_PLAIN_30);
		this.questionLeftLabel.setForeground(STANDARD_COLOR);
		
		this.questionRightLabel = new JLabel();
		this.questionRightLabel.setFont(ARIAL_PLAIN_30);
		this.questionRightLabel.setForeground(STANDARD_COLOR);
		
		this.playerAnswerLeftLabel = new JLabel();
		this.playerAnswerLeftLabel.setFont(ARIAL_PLAIN_30);
		this.playerAnswerLeftLabel.setForeground(STANDARD_COLOR);
		
		this.playerAnswerRightLabel = new JLabel();
		this.playerAnswerRightLabel.setFont(ARIAL_PLAIN_30);
		this.playerAnswerRightLabel.setForeground(STANDARD_COLOR);
		
		this.correctAnswerLeftLabel = new JLabel();
		this.correctAnswerLeftLabel.setFont(ARIAL_PLAIN_30);
		this.correctAnswerLeftLabel.setForeground(STANDARD_COLOR);
		
		this.correctAnswerRightLabel = new JLabel();
		this.correctAnswerRightLabel.setFont(ARIAL_PLAIN_30);
		this.correctAnswerRightLabel.setForeground(STANDARD_COLOR);
		
		this.resultPanel = new JPanel();
		this.resultPanel.setOpaque(false);
		
		this.homeButton = new JButton();
		this.homeButton.setFont(ARIAL_PLAIN_50);
		this.homeButton.setForeground(STANDARD_COLOR);
		this.homeButton.setBackground(TRANSPARENT_COLOR);
		this.homeButton.setContentAreaFilled(false);
		this.homeButton.setBorder(null);
		this.homeButton.setFocusPainted(false);
		
		this.exitButton = new JButton();
		this.exitButton.setFont(ARIAL_PLAIN_50);
		this.exitButton.setForeground(STANDARD_COLOR);
		this.exitButton.setBackground(TRANSPARENT_COLOR);
		this.exitButton.setContentAreaFilled(false);
		this.exitButton.setBorder(null);
		this.exitButton.setFocusPainted(false);
		
		this.buttonPanel = new JPanel();
		this.buttonPanel.setOpaque(false);
	}
	
	/**
	 * Initialisiert view layout.
	 */
	private void initLayout() {
		this.resultPanel.setLayout(new GridLayout(5, 2));
		this.resultPanel.add(levelLeftLabel);
		this.resultPanel.add(levelRightLabel);
		this.resultPanel.add(scoreLeftLabel);
		this.resultPanel.add(scoreRightLabel);
		this.resultPanel.add(questionLeftLabel);
		this.resultPanel.add(questionRightLabel);
		this.resultPanel.add(playerAnswerLeftLabel);
		this.resultPanel.add(playerAnswerRightLabel);
		this.resultPanel.add(correctAnswerLeftLabel);
		this.resultPanel.add(correctAnswerRightLabel);
		
		this.buttonPanel.setLayout(new GridLayout(2, 1));
		this.buttonPanel.add(homeButton);
		this.buttonPanel.add(exitButton);
		
		this.content.setLayout(new GridLayout(3, 1));
		this.content.add(resultLabel);
		this.content.add(resultPanel);
		this.content.add(buttonPanel);
	}
	
	/**
	 * Gibt das Content-Panel zurueck
	 * @return JPanel
	 */
	public JPanel getContent() {
		return this.content;
	}
	
	/**
	 * Gibt das Result-Label zurueck
	 * @return JLabel
	 */
	public JLabel getResultLabel() {
		return this.resultLabel;
	}
	
	/**
	 * Gibt das LevelLeft-Label zurueck
	 * @return JLabel
	 */
	public JLabel getLevelLeftLabel() {
		return this.levelLeftLabel;
	}
	
	/**
	 * Gibt das LevelRight-Label zurueck
	 * @return JLabel
	 */
	public JLabel getLevelRightLabel() {
		return this.levelRightLabel;
	}
	
	/**
	 * Gibt das ScoreLeft-Label zurueck
	 * @return JLabel
	 */
	public JLabel getScoreLeftLabel() {
		return this.scoreLeftLabel;
	}
	
	/**
	 * Gibt das ScoreRight-Label zurueck
	 * @return JLabel
	 */
	public JLabel getScoreRightLabel() {
		return this.scoreRightLabel;
	}
	
	/**
	 * Gibt das QuestionLeft-Label zurueck
	 * @return JLabel
	 */
	public JLabel getQuestionLeftLabel() {
		return this.questionLeftLabel;
	}
	
	/**
	 * Gibt das QuestionRight-Label zurueck
	 * @return JLabel
	 */
	public JLabel getQuestionRightLabel() {
		return this.questionRightLabel;
	}
	
	/**
	 * Gibt das PlayerAnswerLeft-Label zurueck
	 * @return JLabel
	 */
	public JLabel getPlayerAnswerLeftLabel() {
		return this.playerAnswerLeftLabel;
	}
	
	/**
	 * Gibt das PlayerAnswerRight-Label zurueck
	 * @return JLabel
	 */
	public JLabel getPlayerAnswerRightLabel() {
		return this.playerAnswerRightLabel;
	}
	
	/**
	 * Gibt das CorrectAnswerLeft-Label zurueck
	 * @return JLabel
	 */
	public JLabel getCorrectAnswerLeftLabel() {
		return this.correctAnswerLeftLabel;
	}
	
	/**
	 * Gibt das CorrectAnswerRight-Label zurueck
	 * @return JLabel
	 */
	public JLabel getCorrectAnswerRightLabel() {
		return this.correctAnswerRightLabel;
	}
	
	/**
	 * Gibt den Home-Button zurueck
	 * @return JButton
	 */
	public JButton getHomeButton() {
		return this.homeButton;
	}
	
	/**
	 * Gibt den Exit-Button zurueck
	 * @return JButton
	 */
	public JButton getExitButton() {
		return this.exitButton;
	}
}
