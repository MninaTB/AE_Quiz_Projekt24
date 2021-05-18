package gui;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;

import java.awt.Font;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class GameGUI extends JPanel {
	//Wird vorgeschrieben, warum weiss ich nicht
	private static final long serialVersionUID = -5841256047843668485L;
	
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
	private JPanel rightPanel;
	
	public GameGUI() {
		this.homeButton = new JButton(" H ");
		this.titleLabel = new JLabel("Quiz Projekt24", SwingConstants.CENTER);
		this.exitButton = new JButton(" X ");
		this.topPanel = new JPanel();
		this.questionLabel = new JLabel("Wie lautet die erste Frage?", SwingConstants.CENTER);
		this.answerNo1Button = new JButton("Erste Antwort");
		this.answerNo2Button = new JButton("Zweite Antwort");
		this.answerNo3Button = new JButton("Dritte Antwort");
		this.answerNo4Button = new JButton("Vierte Antwort");
		this.answerPanel = new JPanel();
		this.centerPanel = new JPanel();
		this.categoryLabel = new JLabel(" Aktuelle Kategorie: ");
		this.currentCategoryLabel = new JLabel("  WGP");
		this.categoryPanel = new JPanel();
		this.levelLabel = new JLabel(" Level:");
		this.levelNo1Label = new JLabel("  1. Level 10/10");
		this.levelNo2Label = new JLabel("  2. Level 10/10");
		this.levelNo3Label = new JLabel("  3. Level 5/10");
		this.levelNo4Label = new JLabel("  4. Level 0/10");
		this.levelNo5Label = new JLabel("  5. Level 0/10");
		this.levelPanel = new JPanel();
		this.jokerButton = new JButton("50/50");
		this.rightPanel = new JPanel();
		
		createGameGUI();
	}
	
	private void createGameGUI() {
		setFonts();
		setFontColors();
		setComponentsTransparent();
		setBorders();
		addComponents();
	}
	
	private void setFonts() {
		Font topPanelFont = new Font("Arial", Font.BOLD, 70);
		Font centerPanelFont = new Font("Arial", Font.PLAIN, 50);
		Font rightPanelFont = new Font("Arial", Font.PLAIN, 20);
		
		this.homeButton.setFont(topPanelFont);
		this.titleLabel.setFont(topPanelFont);
		this.exitButton.setFont(topPanelFont);
		this.questionLabel.setFont(centerPanelFont);
		this.answerNo1Button.setFont(centerPanelFont);
		this.answerNo2Button.setFont(centerPanelFont);
		this.answerNo3Button.setFont(centerPanelFont);
		this.answerNo4Button.setFont(centerPanelFont);
		this.categoryLabel.setFont(rightPanelFont);
		this.currentCategoryLabel.setFont(rightPanelFont);
		this.levelLabel.setFont(rightPanelFont);
		this.levelNo1Label.setFont(rightPanelFont);
		this.levelNo2Label.setFont(rightPanelFont);
		this.levelNo3Label.setFont(rightPanelFont);
		this.levelNo4Label.setFont(rightPanelFont);
		this.levelNo5Label.setFont(rightPanelFont);
		this.jokerButton.setFont(centerPanelFont);
	}
	
	private void setFontColors() {
		this.homeButton.setForeground(Color.GREEN);
		this.titleLabel.setForeground(Color.CYAN);
		this.exitButton.setForeground(Color.RED);
		this.questionLabel.setForeground(Color.CYAN);
		this.answerNo1Button.setForeground(Color.CYAN);
		this.answerNo2Button.setForeground(Color.CYAN);
		this.answerNo3Button.setForeground(Color.CYAN);
		this.answerNo4Button.setForeground(Color.CYAN);
		this.categoryLabel.setForeground(Color.CYAN);
		this.currentCategoryLabel.setForeground(Color.CYAN);
		this.levelLabel.setForeground(Color.CYAN);
		this.levelNo1Label.setForeground(Color.GREEN);
		this.levelNo2Label.setForeground(Color.GREEN);
		this.levelNo3Label.setForeground(Color.YELLOW);
		this.levelNo4Label.setForeground(Color.RED);
		this.levelNo5Label.setForeground(Color.RED);
		this.jokerButton.setForeground(Color.CYAN);
	}
	
	private void setComponentsTransparent() {
		this.setOpaque(false);
		this.topPanel.setOpaque(false);
		this.answerPanel.setOpaque(false);
		this.centerPanel.setOpaque(false);
		this.categoryPanel.setOpaque(false);
		this.levelPanel.setOpaque(false);
		this.rightPanel.setOpaque(false);
		
		this.homeButton.setContentAreaFilled(false);
		this.homeButton.setBackground(new Color(0,0,0,0));
		this.homeButton.setBorder(null);
		this.homeButton.setFocusPainted(false);
		
		this.exitButton.setContentAreaFilled(false);
		this.exitButton.setBackground(new Color(0,0,0,0));
		this.exitButton.setBorder(null);
		this.exitButton.setFocusPainted(false);
		
		this.answerNo1Button.setContentAreaFilled(false);
		this.answerNo1Button.setBackground(new Color(0,0,0,0));
		this.answerNo1Button.setBorder(null);
		this.answerNo1Button.setFocusPainted(false);
		
		this.answerNo2Button.setContentAreaFilled(false);
		this.answerNo2Button.setBackground(new Color(0,0,0,0));
		this.answerNo2Button.setBorder(null);
		this.answerNo2Button.setFocusPainted(false);
		
		this.answerNo3Button.setContentAreaFilled(false);
		this.answerNo3Button.setBackground(new Color(0,0,0,0));
		this.answerNo3Button.setBorder(null);
		this.answerNo3Button.setFocusPainted(false);
		
		this.answerNo4Button.setContentAreaFilled(false);
		this.answerNo4Button.setBackground(new Color(0,0,0,0));
		this.answerNo4Button.setBorder(null);
		this.answerNo4Button.setFocusPainted(false);
		
		this.jokerButton.setContentAreaFilled(false);
		this.jokerButton.setBackground(new Color(0,0,0,0));
		this.jokerButton.setBorder(null);
		this.jokerButton.setFocusPainted(false);
	}
	
	private void setBorders() {
		this.titleLabel.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 5, Color.CYAN));
		this.topPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, Color.CYAN));
		this.questionLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, Color.CYAN));
		this.answerNo1Button.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 2, Color.CYAN));
		this.answerNo2Button.setBorder(BorderFactory.createMatteBorder(0, 3, 2, 0, Color.CYAN));
		this.answerNo3Button.setBorder(BorderFactory.createMatteBorder(3, 0, 0, 2, Color.CYAN));
		this.answerNo4Button.setBorder(BorderFactory.createMatteBorder(3, 3, 0, 0, Color.CYAN));
		this.rightPanel.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 0, Color.CYAN));
	}
	
	private void addComponents() {
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
		
		this.categoryPanel.setLayout(new BorderLayout());
		this.categoryPanel.add(categoryLabel, BorderLayout.NORTH);
		this.categoryPanel.add(currentCategoryLabel, BorderLayout.CENTER);
		
		this.levelPanel.setLayout(new GridLayout(6, 1));
		this.levelPanel.add(levelLabel);
		this.levelPanel.add(levelNo1Label);
		this.levelPanel.add(levelNo2Label);
		this.levelPanel.add(levelNo3Label);
		this.levelPanel.add(levelNo4Label);
		this.levelPanel.add(levelNo5Label);
		
		this.rightPanel.setLayout(new GridLayout(3, 1));
		this.rightPanel.add(categoryPanel);
		this.rightPanel.add(levelPanel);
		this.rightPanel.add(jokerButton);
		
		this.setLayout(new BorderLayout());
		this.add(topPanel, BorderLayout.NORTH);
		this.add(centerPanel, BorderLayout.CENTER);
		this.add(rightPanel, BorderLayout.EAST);
	}
	
	public JButton getHomeButton() {
		return this.homeButton;
	}
	
	public JButton getExitButton() {
		return this.exitButton;
	}
}
