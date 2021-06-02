package view;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.BorderLayout;

/**
 * 
 * Start ist ein view, welches JComponents
 * haelt und anbietet.
 * 
 * @author nina, niklas e.
 *
 */
public class Start {
	private JPanel content;
	
	private JLabel titleLabel;
	private JButton startButton;
	private JButton optionsButton;
	private JButton exitButton;
	private JPanel gridPanel;
	
	private final Font ARIAL_BOLD_100 = new Font("Arial", Font.BOLD, 100);
	private final Font ARIAL_PLAIN_50 = new Font("Arial", Font.PLAIN, 50);
	private final Color STANDARD_COLOR = Color.CYAN;
	private final Color TRANSPARENT_COLOR = new Color(0,0,0,0);
	
	/**
	 * Konstrukor zum erzeugen eines Start views.
	 */
	public Start() {
		this.content = new JPanel();
		this.initComponents();
		this.initLayout();
	}
	
	/**
	 * Initialisiert components.
	 */
	private void initComponents() {
		this.titleLabel = new JLabel();
		this.titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		this.titleLabel.setFont(ARIAL_BOLD_100);
		this.titleLabel.setForeground(STANDARD_COLOR);
		
		this.startButton = new JButton();
		this.startButton.setFont(ARIAL_PLAIN_50);
		this.startButton.setForeground(STANDARD_COLOR);
		this.startButton.setBackground(TRANSPARENT_COLOR);
		this.startButton.setContentAreaFilled(false);
		this.startButton.setBorder(null);
		this.startButton.setFocusPainted(false);
		
		this.optionsButton = new JButton();
		this.optionsButton.setFont(ARIAL_PLAIN_50);
		this.optionsButton.setForeground(STANDARD_COLOR);
		this.optionsButton.setBackground(TRANSPARENT_COLOR);
		this.optionsButton.setContentAreaFilled(false);
		this.optionsButton.setBorder(null);
		this.optionsButton.setFocusPainted(false);
		
		this.exitButton = new JButton();
		this.exitButton.setFont(ARIAL_PLAIN_50);
		this.exitButton.setForeground(STANDARD_COLOR);
		this.exitButton.setBackground(TRANSPARENT_COLOR);
		this.exitButton.setContentAreaFilled(false);
		this.exitButton.setBorder(null);
		this.exitButton.setFocusPainted(false);
		
		this.gridPanel = new JPanel();
		this.gridPanel.setOpaque(false);
	}
	
	/**
	 * Initialisiert view layout.
	 */
	private void initLayout() {
		this.gridPanel.setLayout(new GridLayout(4, 1));
		this.gridPanel.add(this.titleLabel);
		this.gridPanel.add(this.startButton);
		this.gridPanel.add(this.optionsButton);
		this.gridPanel.add(this.exitButton);
		
		this.content.setLayout(new BorderLayout());
		this.content.add(gridPanel, BorderLayout.SOUTH);
	}
	
	/**
	 * Gibt das Content-Panel zurueck
	 * @return JPanel
	 */
	public JPanel getContent() {
		return this.content;
	}
	
	/**
	 * Gibt das Title-Label zurueck
	 * @return JLabel
	 */
	public JLabel getTitleLabel() {
		return this.titleLabel;
	}
	
	/**
	 * Gibt den Start-Button zurueck
	 * @return JButton
	 */
	public JButton getStartButton() {
		return this.startButton;
	}
	
	/**
	 * Gibt den Options-Button zurueck
	 * @return JButton
	 */
	public JButton getOptionsButton() {
		return this.optionsButton;
	}
	
	/**
	 * Gibt den Exit-Button zurueck
	 * @return JButton
	 */
	public JButton getExitButton() {
		return this.exitButton;
	}
}
