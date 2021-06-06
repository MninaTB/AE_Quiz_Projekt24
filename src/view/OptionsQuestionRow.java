package view;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.Color;

/**
 * 
 * OptionsQuestionRow ist ein view Teil von Options, welches JComponents
 * haelt und anbietet.
 */
public class OptionsQuestionRow {
	JCheckBox questionCheckBox;
	JPanel checkBoxPanel;
	JLabel questionLabel;
	JLabel categoryLabel;
	JLabel levelLabel;
	JButton editButton;

	private final Font ARIAL_PLAIN_20 = new Font("Arial", Font.PLAIN, 20);
	private final Color STANDARD_COLOR = Color.CYAN;
	private final Color TRANSPARENT_COLOR = new Color(0,0,0,0);

	public OptionsQuestionRow() {
		this.initComponents();
	}
	
	public void addItemListener(ItemListener il) {
		this.questionCheckBox.addItemListener(il);
	}
	
	/**
	 * Initialisiert components.
	 */
	private void initComponents() {
		this.questionCheckBox = new JCheckBox();
		this.questionCheckBox.setBackground(STANDARD_COLOR);
		
		this.checkBoxPanel = new JPanel();
		this.checkBoxPanel.add(questionCheckBox);
		this.checkBoxPanel.setOpaque(false);
		this.checkBoxPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, STANDARD_COLOR));
		
		this.questionLabel = new JLabel();
		this.questionLabel.setFont(ARIAL_PLAIN_20);
		this.questionLabel.setForeground(STANDARD_COLOR);
		this.questionLabel.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 0, STANDARD_COLOR));
		
		this.categoryLabel = new JLabel();
		this.categoryLabel.setFont(ARIAL_PLAIN_20);
		this.categoryLabel.setForeground(STANDARD_COLOR);
		this.categoryLabel.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, STANDARD_COLOR));
		
		this.levelLabel = new JLabel();
		this.levelLabel.setFont(ARIAL_PLAIN_20);
		this.levelLabel.setForeground(STANDARD_COLOR);
		this.levelLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, STANDARD_COLOR));
		
		this.editButton = new JButton();
		this.editButton.setFont(ARIAL_PLAIN_20);
		this.editButton.setForeground(STANDARD_COLOR);
		this.editButton.setBackground(TRANSPARENT_COLOR);
		this.editButton.setContentAreaFilled(false);
		this.editButton.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, STANDARD_COLOR));
		this.editButton.setFocusPainted(false);
	}
	
	/**
	 * Gibt das CheckBox-Panel zurueck
	 * @return JPanel
	 */
	public JPanel getCheckBoxPanel() {
		return this.checkBoxPanel;
	}
	
	/**
	 * Gibt das Question-Label zurueck
	 * @return JLabel
	 */
	public JLabel getQuestionLabel() {
		return this.questionLabel;
	}
	
	/**
	 * Gibt das Category-Label zurueck
	 * @return JLabel
	 */
	public JLabel getCategoryLabel() {
		return this.categoryLabel;
	}
	
	/**
	 * Gibt das Level-Label zurueck
	 * @return JLabel
	 */
	public JLabel getLevelLabel() {
		return this.levelLabel;
	}
	
	/**
	 * Gibt den Edit-Button zurueck
	 * @return JButton
	 */
	public JButton getEditButton() {
		return this.editButton;
	}
}
