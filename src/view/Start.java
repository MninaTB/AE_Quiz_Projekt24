package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.GridLayout;

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
		this.startButton = new JButton();
		this.optionsButton = new JButton();
		this.exitButton = new JButton();
	}
	
	/**
	 * Initialisiert view layout.
	 */
	public void initLayout() {
		this.content = new JPanel();
		this.content.setLayout(new GridLayout(4, 1));
		
		this.content.add(this.titleLabel);
		this.content.add(this.startButton);
		this.content.add(this.optionsButton);
		this.content.add(this.exitButton);
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
