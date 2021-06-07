package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;

import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

/**
 * 
 * Edit ist ein view, welches JComponents haelt und anbietet.
 */
public class Edit {
	private JPanel content;

	private JLabel questionLabel;
	private JTextField questionTextField;
	private JPanel questionPanel;
	private JLabel categoryLabel;
	private JComboBox<Object> categoryComboBox;
	private JPanel categoryPanel;
	private JLabel levelLabel;
	private JComboBox<Object> levelComboBox;
	private JPanel levelPanel;
	private JPanel categoryLevelPanel;
	private JRadioButton answerNo1Button;
	private JLabel answerNo1Label;
	private JTextField answerNo1TextField;
	private JPanel answerNo1Panel;
	private JRadioButton answerNo2Button;
	private JLabel answerNo2Label;
	private JTextField answerNo2TextField;
	private JPanel answerNo2Panel;
	private JRadioButton answerNo3Button;
	private JLabel answerNo3Label;
	private JTextField answerNo3TextField;
	private JPanel answerNo3Panel;
	private JRadioButton answerNo4Button;
	private JLabel answerNo4Label;
	private JTextField answerNo4TextField;
	private JPanel answerNo4Panel;
	private ButtonGroup buttonGroup;
	private JButton saveButton;
	private JButton cancelButton;
	private JPanel bottomPanel;

	private final Font ARIAL_BOLD_50 = new Font("Arial", Font.BOLD, 50);
	private final Font ARIAL_PLAIN_50 = new Font("Arial", Font.PLAIN, 50);
	private final Color STANDARD_COLOR = Color.CYAN;
	private final Color TRANSPARENT_COLOR = new Color(0, 0, 0, 0);
	private final Color BACKGROUND_COLOR = new Color(77, 77, 77);

	/**
	 * Konstrukor zum erzeugen eines Edit views.
	 */
	public Edit() {
		this.content = new JPanel();
		this.initComponents();
		this.initLayout();
	}

	/**
	 * Initialisiert components.
	 */
	private void initComponents() {
		this.questionLabel = new JLabel();
		this.questionLabel.setFont(ARIAL_PLAIN_50);
		this.questionLabel.setForeground(STANDARD_COLOR);

		this.questionTextField = new JTextField();
		this.questionTextField.setOpaque(false);
		this.questionTextField.setPreferredSize(new Dimension(1072, 50));
		this.questionTextField.setFont(ARIAL_PLAIN_50);
		this.questionTextField.setForeground(STANDARD_COLOR);
		this.questionTextField.setBackground(TRANSPARENT_COLOR);
		this.questionTextField.setBorder(BorderFactory.createLineBorder(STANDARD_COLOR, 1));

		this.questionPanel = new JPanel();
		this.questionPanel.setOpaque(false);

		this.categoryLabel = new JLabel();
		this.categoryLabel.setFont(ARIAL_PLAIN_50);
		this.categoryLabel.setForeground(STANDARD_COLOR);

		this.categoryComboBox = new JComboBox<Object>();
		this.categoryComboBox.setPreferredSize(new Dimension(350, 50));
		this.categoryComboBox.setFont(ARIAL_PLAIN_50);
		this.categoryComboBox.setForeground(STANDARD_COLOR);
		this.categoryComboBox.setBackground(BACKGROUND_COLOR);
		this.categoryComboBox.setBorder(BorderFactory.createLineBorder(STANDARD_COLOR, 1));
		this.categoryComboBox.setEditable(true);
		this.categoryComboBox.getEditor().getEditorComponent().setFont(ARIAL_PLAIN_50);
		this.categoryComboBox.getEditor().getEditorComponent().setForeground(STANDARD_COLOR);
		this.categoryComboBox.getEditor().getEditorComponent().setBackground(BACKGROUND_COLOR);
		this.categoryComboBox.getComponent(0).setBackground(STANDARD_COLOR);

		this.categoryPanel = new JPanel();
		this.categoryPanel.setOpaque(false);

		this.levelLabel = new JLabel();
		this.levelLabel.setFont(ARIAL_PLAIN_50);
		this.levelLabel.setForeground(STANDARD_COLOR);

		this.levelComboBox = new JComboBox<Object>();
		this.levelComboBox.setPreferredSize(new Dimension(100, 50));
		this.levelComboBox.setFont(ARIAL_PLAIN_50);
		this.levelComboBox.setForeground(STANDARD_COLOR);
		this.levelComboBox.setBackground(BACKGROUND_COLOR);
		this.levelComboBox.setBorder(BorderFactory.createLineBorder(STANDARD_COLOR, 1));
		this.levelComboBox.getComponent(0).setBackground(STANDARD_COLOR);

		this.levelPanel = new JPanel();
		this.levelPanel.setOpaque(false);

		this.categoryLevelPanel = new JPanel();
		this.categoryLevelPanel.setOpaque(false);

		this.answerNo1Button = new JRadioButton();
		this.answerNo1Button.setBackground(BACKGROUND_COLOR);

		this.answerNo1Label = new JLabel();
		this.answerNo1Label.setFont(ARIAL_PLAIN_50);
		this.answerNo1Label.setForeground(STANDARD_COLOR);

		this.answerNo1TextField = new JTextField();
		this.answerNo1TextField.setOpaque(false);
		this.answerNo1TextField.setPreferredSize(new Dimension(900, 50));
		this.answerNo1TextField.setFont(ARIAL_PLAIN_50);
		this.answerNo1TextField.setForeground(STANDARD_COLOR);
		this.answerNo1TextField.setBackground(TRANSPARENT_COLOR);
		this.answerNo1TextField.setBorder(BorderFactory.createLineBorder(STANDARD_COLOR, 1));

		this.answerNo1Panel = new JPanel();
		this.answerNo1Panel.setOpaque(false);

		this.answerNo2Button = new JRadioButton();
		this.answerNo2Button.setBackground(BACKGROUND_COLOR);

		this.answerNo2Label = new JLabel();
		this.answerNo2Label.setFont(ARIAL_PLAIN_50);
		this.answerNo2Label.setForeground(STANDARD_COLOR);

		this.answerNo2TextField = new JTextField();
		this.answerNo2TextField.setOpaque(false);
		this.answerNo2TextField.setPreferredSize(new Dimension(900, 50));
		this.answerNo2TextField.setFont(ARIAL_PLAIN_50);
		this.answerNo2TextField.setForeground(STANDARD_COLOR);
		this.answerNo2TextField.setBackground(TRANSPARENT_COLOR);
		this.answerNo2TextField.setBorder(BorderFactory.createLineBorder(STANDARD_COLOR, 1));

		this.answerNo2Panel = new JPanel();
		this.answerNo2Panel.setOpaque(false);

		this.answerNo3Button = new JRadioButton();
		this.answerNo3Button.setBackground(BACKGROUND_COLOR);

		this.answerNo3Label = new JLabel();
		this.answerNo3Label.setFont(ARIAL_PLAIN_50);
		this.answerNo3Label.setForeground(STANDARD_COLOR);

		this.answerNo3TextField = new JTextField();
		this.answerNo3TextField.setOpaque(false);
		this.answerNo3TextField.setPreferredSize(new Dimension(900, 50));
		this.answerNo3TextField.setFont(ARIAL_PLAIN_50);
		this.answerNo3TextField.setForeground(STANDARD_COLOR);
		this.answerNo3TextField.setBackground(TRANSPARENT_COLOR);
		this.answerNo3TextField.setBorder(BorderFactory.createLineBorder(STANDARD_COLOR, 1));

		this.answerNo3Panel = new JPanel();
		this.answerNo3Panel.setOpaque(false);

		this.answerNo4Button = new JRadioButton();
		this.answerNo4Button.setBackground(BACKGROUND_COLOR);

		this.answerNo4Label = new JLabel();
		this.answerNo4Label.setFont(ARIAL_PLAIN_50);
		this.answerNo4Label.setForeground(STANDARD_COLOR);

		this.answerNo4TextField = new JTextField();
		this.answerNo4TextField.setOpaque(false);
		this.answerNo4TextField.setPreferredSize(new Dimension(900, 50));
		this.answerNo4TextField.setFont(ARIAL_PLAIN_50);
		this.answerNo4TextField.setForeground(STANDARD_COLOR);
		this.answerNo4TextField.setBackground(TRANSPARENT_COLOR);
		this.answerNo4TextField.setBorder(BorderFactory.createLineBorder(STANDARD_COLOR, 1));

		this.answerNo4Panel = new JPanel();
		this.answerNo4Panel.setOpaque(false);

		this.buttonGroup = new ButtonGroup();

		this.saveButton = new JButton();
		this.saveButton.setFont(ARIAL_BOLD_50);
		this.saveButton.setForeground(STANDARD_COLOR);
		this.saveButton.setBackground(TRANSPARENT_COLOR);
		this.saveButton.setContentAreaFilled(false);
		this.saveButton.setBorder(null);
		this.saveButton.setFocusPainted(false);

		this.cancelButton = new JButton();
		this.cancelButton.setFont(ARIAL_BOLD_50);
		this.cancelButton.setForeground(STANDARD_COLOR);
		this.cancelButton.setBackground(TRANSPARENT_COLOR);
		this.cancelButton.setContentAreaFilled(false);
		this.cancelButton.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 0, STANDARD_COLOR));
		this.cancelButton.setFocusPainted(false);

		this.bottomPanel = new JPanel();
		this.bottomPanel.setOpaque(false);
		this.bottomPanel.setBorder(BorderFactory.createMatteBorder(5, 0, 0, 0, STANDARD_COLOR));
	}

	/**
	 * Initialisiert view layout.
	 */
	public void initLayout() {
		this.questionPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
		this.questionPanel.add(questionLabel);
		this.questionPanel.add(questionTextField);

		this.categoryPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.categoryPanel.add(categoryLabel);
		this.categoryPanel.add(categoryComboBox);

		this.levelPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.levelPanel.add(levelLabel);
		this.levelPanel.add(levelComboBox);

		this.categoryLevelPanel.setLayout(new GridLayout(1, 2));
		this.categoryLevelPanel.add(categoryPanel);
		this.categoryLevelPanel.add(levelPanel);

		this.answerNo1Panel.setLayout(new FlowLayout(FlowLayout.LEADING));
		this.answerNo1Panel.add(answerNo1Button);
		this.answerNo1Panel.add(answerNo1Label);
		this.answerNo1Panel.add(answerNo1TextField);

		this.answerNo2Panel.setLayout(new FlowLayout(FlowLayout.LEADING));
		this.answerNo2Panel.add(answerNo2Button);
		this.answerNo2Panel.add(answerNo2Label);
		this.answerNo2Panel.add(answerNo2TextField);

		this.answerNo3Panel.setLayout(new FlowLayout(FlowLayout.LEADING));
		this.answerNo3Panel.add(answerNo3Button);
		this.answerNo3Panel.add(answerNo3Label);
		this.answerNo3Panel.add(answerNo3TextField);

		this.answerNo4Panel.setLayout(new FlowLayout(FlowLayout.LEADING));
		this.answerNo4Panel.add(answerNo4Button);
		this.answerNo4Panel.add(answerNo4Label);
		this.answerNo4Panel.add(answerNo4TextField);

		this.buttonGroup.add(answerNo1Button);
		this.buttonGroup.add(answerNo2Button);
		this.buttonGroup.add(answerNo3Button);
		this.buttonGroup.add(answerNo4Button);

		this.bottomPanel.setLayout(new GridLayout(1, 2));
		this.bottomPanel.add(saveButton);
		this.bottomPanel.add(cancelButton);

		this.content.setLayout(new GridLayout(7, 1));
		this.content.add(questionPanel);
		this.content.add(categoryLevelPanel);
		this.content.add(answerNo1Panel);
		this.content.add(answerNo2Panel);
		this.content.add(answerNo3Panel);
		this.content.add(answerNo4Panel);
		this.content.add(bottomPanel);
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
	 * Gibt das Question-Label zurueck
	 * 
	 * @return JLabel
	 */
	public JLabel getQuestionLabel() {
		return this.questionLabel;
	}

	/**
	 * Gibt das Question-TextField zurueck
	 * 
	 * @return JTextField
	 */
	public JTextField getQuestionTextField() {
		return this.questionTextField;
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
	 * Gibt das Category-ComboBox zurueck
	 * 
	 * @return JComboBox
	 */
	public JComboBox<?> getCategoryComboBox() {
		return this.categoryComboBox;
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
	 * Gibt das Level-ComboBox zurueck
	 * 
	 * @return JComboBox
	 */
	public JComboBox<?> getLevelComboBox() {
		return this.levelComboBox;
	}

	/**
	 * Gibt den AnswerNo1-Button zurueck
	 * 
	 * @return JRadioButton
	 */
	public JRadioButton getAnswerNo1Button() {
		return this.answerNo1Button;
	}

	/**
	 * Gibt das AnswerNo1-Label zurueck
	 * 
	 * @return JLabel
	 */
	public JLabel getAnswerNo1Label() {
		return this.answerNo1Label;
	}

	/**
	 * Gibt das AnswerNo1-TextField zurueck
	 * 
	 * @return JTextField
	 */
	public JTextField getAnswerNo1TextField() {
		return this.answerNo1TextField;
	}

	/**
	 * Gibt den AnswerNo2-Button zurueck
	 * 
	 * @return JRadioButton
	 */
	public JRadioButton getAnswerNo2Button() {
		return this.answerNo2Button;
	}

	/**
	 * Gibt das AnswerNo2-Label zurueck
	 * 
	 * @return JLabel
	 */
	public JLabel getAnswerNo2Label() {
		return this.answerNo2Label;
	}

	/**
	 * Gibt das AnswerNo2-TextField zurueck
	 * 
	 * @return JTextField
	 */
	public JTextField getAnswerNo2TextField() {
		return this.answerNo2TextField;
	}

	/**
	 * Gibt den AnswerNo3-Button zurueck
	 * 
	 * @return JRadioButton
	 */
	public JRadioButton getAnswerNo3Button() {
		return this.answerNo3Button;
	}

	/**
	 * Gibt das AnswerNo3-Label zurueck
	 * 
	 * @return JLabel
	 */
	public JLabel getAnswerNo3Label() {
		return this.answerNo3Label;
	}

	/**
	 * Gibt das AnswerNo3-TextField zurueck
	 * 
	 * @return JTextField
	 */
	public JTextField getAnswerNo3TextField() {
		return this.answerNo3TextField;
	}

	/**
	 * Gibt den AnswerNo4-Button zurueck
	 * 
	 * @return JRadioButton
	 */
	public JRadioButton getAnswerNo4Button() {
		return this.answerNo4Button;
	}

	/**
	 * Gibt das AnswerNo4-Label zurueck
	 * 
	 * @return JLabel
	 */
	public JLabel getAnswerNo4Label() {
		return this.answerNo4Label;
	}

	/**
	 * Gibt das AnswerNo4-TextField zurueck
	 * 
	 * @return JTextField
	 */
	public JTextField getAnswerNo4TextField() {
		return this.answerNo4TextField;
	}

	/**
	 * Gibt die ButtonGroup zurueck
	 * 
	 * @return ButtonGroup
	 */
	public ButtonGroup getButtonGroup() {
		return this.buttonGroup;
	}

	/**
	 * Gibt den Save-Button zurueck
	 * 
	 * @return JButton
	 */
	public JButton getSaveButton() {
		return this.saveButton;
	}

	/**
	 * Gibt den Cancel-Button zurueck
	 * 
	 * @return JButton
	 */
	public JButton getCancelButton() {
		return this.cancelButton;
	}
}
