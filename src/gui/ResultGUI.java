package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;

public class ResultGUI extends JPanel {
	//Wird vorgeschrieben, warum weiss ich nicht
	private static final long serialVersionUID = -4472412855669392418L;
	
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
	private JPanel labelPanel;
	private JButton homeButton;
	private JButton exitButton;
	private JPanel buttonPanel;
	
	public ResultGUI() {
		this.resultLabel = new JLabel("Verloren", SwingConstants.CENTER);
		this.levelLeftLabel = new JLabel(" Level erreicht:");
		this.levelRightLabel = new JLabel("3/5");
		this.scoreLeftLabel = new JLabel(" Fragen richtig beantwortet:");
		this.scoreRightLabel = new JLabel("35/50");
		this.questionLeftLabel = new JLabel(" 36. Frage:");
		this.questionRightLabel = new JLabel("Wie lautet die erste Frage?");
		this.playerAnswerLeftLabel = new JLabel(" Deine Antwort:");
		this.playerAnswerRightLabel = new JLabel("Zweite Antwort");
		this.correctAnswerLeftLabel = new JLabel(" Richtige Antwort:");
		this.correctAnswerRightLabel = new JLabel("Vierte Antwort");
		this.labelPanel = new JPanel();
		this.homeButton = new JButton("Zur Startseite");
		this.exitButton = new JButton("Ende");
		this.buttonPanel = new JPanel();
		
		createResultGUI();
	}
	
	private void createResultGUI() {
		setFonts();
		setFontColor();
		setComponentsTransparent();
		addComponents();
	}
	
	private void setFonts() {
		Font resultFont = new Font("Arial", Font.BOLD, 100);
		Font labelFont = new Font("Arial", Font.PLAIN, 40);
		Font buttonFont = new Font("Arial", Font.PLAIN, 50);
		
		this.resultLabel.setFont(resultFont);
		this.levelLeftLabel.setFont(labelFont);
		this.levelRightLabel.setFont(labelFont);
		this.scoreLeftLabel.setFont(labelFont);
		this.scoreRightLabel.setFont(labelFont);
		this.questionLeftLabel.setFont(labelFont);
		this.questionRightLabel.setFont(labelFont);
		this.playerAnswerLeftLabel.setFont(labelFont);
		this.playerAnswerRightLabel.setFont(labelFont);
		this.correctAnswerLeftLabel.setFont(labelFont);
		this.correctAnswerRightLabel.setFont(labelFont);
		this.homeButton.setFont(buttonFont);
		this.exitButton.setFont(buttonFont);
	}
	
	private void setFontColor() {
		this.resultLabel.setForeground(Color.RED);
		this.levelLeftLabel.setForeground(Color.CYAN);
		this.levelRightLabel.setForeground(Color.CYAN);
		this.scoreLeftLabel.setForeground(Color.CYAN);
		this.scoreRightLabel.setForeground(Color.CYAN);
		this.questionLeftLabel.setForeground(Color.CYAN);
		this.questionRightLabel.setForeground(Color.CYAN);
		this.playerAnswerLeftLabel.setForeground(Color.CYAN);
		this.playerAnswerRightLabel.setForeground(Color.CYAN);
		this.correctAnswerLeftLabel.setForeground(Color.CYAN);
		this.correctAnswerRightLabel.setForeground(Color.CYAN);
		this.homeButton.setForeground(Color.CYAN);
		this.exitButton.setForeground(Color.CYAN);
	}
	
	private void setComponentsTransparent() {
		this.setOpaque(false);
		this.labelPanel.setOpaque(false);
		this.buttonPanel.setOpaque(false);
		
		this.homeButton.setContentAreaFilled(false);
		this.homeButton.setBackground(new Color(0,0,0,0));
		this.homeButton.setBorder(null);
		this.homeButton.setFocusPainted(false);
		
		this.exitButton.setContentAreaFilled(false);
		this.exitButton.setBackground(new Color(0,0,0,0));
		this.exitButton.setBorder(null);
		this.exitButton.setFocusPainted(false);
	}
	
	private void addComponents() {
		this.labelPanel.setLayout(new GridLayout(5, 2));
		this.labelPanel.add(levelLeftLabel);
		this.labelPanel.add(levelRightLabel);
		this.labelPanel.add(scoreLeftLabel);
		this.labelPanel.add(scoreRightLabel);
		this.labelPanel.add(questionLeftLabel);
		this.labelPanel.add(questionRightLabel);
		this.labelPanel.add(playerAnswerLeftLabel);
		this.labelPanel.add(playerAnswerRightLabel);
		this.labelPanel.add(correctAnswerLeftLabel);
		this.labelPanel.add(correctAnswerRightLabel);
		
		this.buttonPanel.setLayout(new GridLayout(2, 1));
		this.buttonPanel.add(homeButton);
		this.buttonPanel.add(exitButton);
		
		this.setLayout(new GridLayout(3, 1));
		this.add(resultLabel);
		this.add(labelPanel);
		this.add(buttonPanel);
	}
	
	public JLabel getResultLabel() {
		return this.resultLabel;
	}
	
	public JLabel getLevelRightLabel() {
		return this.levelRightLabel;
	}
	
	public JLabel getScoreRightLabel() {
		return this.scoreRightLabel;
	}
	
	public JLabel getQuestionLeftLabel() {
		return this.questionLeftLabel;
	}
	
	public JLabel getQuestionRightLabel() {
		return this.questionRightLabel;
	}
	
	public JLabel getPlayerAnswerRightLabel() {
		return this.playerAnswerRightLabel;
	}
	
	public JLabel getCorrectAnswerRightLabel() {
		return this.correctAnswerRightLabel;
	}
	
	public JButton getHomeButton() {
		return this.homeButton;
	}
	
	public JButton getExitButton() {
		return this.exitButton;
	}
}
