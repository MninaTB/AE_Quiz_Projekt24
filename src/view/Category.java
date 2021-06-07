package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;

import java.awt.Font;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;

/**
 * 
 * Category ist ein view, welches JComponents haelt und anbietet.
 */
public class Category {
	private JPanel content;

	private JLabel categoryLabel;
	private JPanel categoryPanel;
	private JPanel leftPanel;
	private JLabel levelLabel;
	private JRadioButton levelNo1Button;
	private JRadioButton levelNo2Button;
	private JRadioButton levelNo3Button;
	private JRadioButton levelNo4Button;
	private JRadioButton levelNo5Button;
	private ButtonGroup buttonGroup;
	private JPanel levelPanel;
	private JPanel rightPanel;
	private JPanel centerPanel;
	private JButton startButton;

	private final Font ARIAL_PLAIN_20 = new Font("Arial", Font.PLAIN, 20);
	private final Font ARIAL_BOLD_35 = new Font("Arial", Font.BOLD, 35);
	private final Font ARIAL_BOLD_70 = new Font("Arial", Font.BOLD, 70);
	private final Color STANDARD_COLOR = Color.CYAN;
	private final Color TRANSPARENT_COLOR = new Color(0, 0, 0, 0);
	private final Color BACKGROUND_COLOR = new Color(77, 77, 77);

	/**
	 * Konstrukor zum erzeugen eines Category views.
	 */
	public Category() {
		this.content = new JPanel();
		this.initComponents();
		this.initLayout();
	}

	/**
	 * Initialisiert components.
	 */
	private void initComponents() {
		this.categoryLabel = new JLabel();
		this.categoryLabel.setFont(ARIAL_BOLD_35);
		this.categoryLabel.setForeground(STANDARD_COLOR);

		this.categoryPanel = new JPanel();
		this.categoryPanel.setOpaque(false);

		this.leftPanel = new JPanel();
		this.leftPanel.setOpaque(false);

		this.levelLabel = new JLabel();
		this.levelLabel.setFont(ARIAL_BOLD_35);
		this.levelLabel.setForeground(STANDARD_COLOR);

		this.levelNo1Button = new JRadioButton();
		this.levelNo1Button.setFont(ARIAL_PLAIN_20);
		this.levelNo1Button.setForeground(STANDARD_COLOR);
		this.levelNo1Button.setBackground(BACKGROUND_COLOR);
		this.levelNo1Button.setFocusable(false);
		this.levelNo1Button.setSelected(true);

		this.levelNo2Button = new JRadioButton();
		this.levelNo2Button.setFont(ARIAL_PLAIN_20);
		this.levelNo2Button.setForeground(STANDARD_COLOR);
		this.levelNo2Button.setBackground(BACKGROUND_COLOR);
		this.levelNo2Button.setFocusable(false);

		this.levelNo3Button = new JRadioButton();
		this.levelNo3Button.setFont(ARIAL_PLAIN_20);
		this.levelNo3Button.setForeground(STANDARD_COLOR);
		this.levelNo3Button.setBackground(BACKGROUND_COLOR);
		this.levelNo3Button.setFocusable(false);

		this.levelNo4Button = new JRadioButton();
		this.levelNo4Button.setFont(ARIAL_PLAIN_20);
		this.levelNo4Button.setForeground(STANDARD_COLOR);
		this.levelNo4Button.setBackground(BACKGROUND_COLOR);
		this.levelNo4Button.setFocusable(false);

		this.levelNo5Button = new JRadioButton();
		this.levelNo5Button.setFont(ARIAL_PLAIN_20);
		this.levelNo5Button.setForeground(STANDARD_COLOR);
		this.levelNo5Button.setBackground(BACKGROUND_COLOR);
		this.levelNo5Button.setFocusable(false);

		this.buttonGroup = new ButtonGroup();

		this.levelPanel = new JPanel();
		this.levelPanel.setOpaque(false);

		this.rightPanel = new JPanel();
		this.rightPanel.setOpaque(false);

		this.centerPanel = new JPanel();
		this.centerPanel.setOpaque(false);

		this.startButton = new JButton();
		this.startButton.setFont(ARIAL_BOLD_70);
		this.startButton.setForeground(STANDARD_COLOR);
		this.startButton.setBackground(TRANSPARENT_COLOR);
		this.startButton.setContentAreaFilled(false);
		this.startButton.setBorder(BorderFactory.createMatteBorder(5, 0, 0, 0, STANDARD_COLOR));
		this.startButton.setFocusPainted(false);
	}

	/**
	 * Initialisiert view layout.
	 */
	private void initLayout() {
		this.categoryPanel.setLayout(new BoxLayout(categoryPanel, BoxLayout.Y_AXIS));
		this.categoryPanel.add(categoryLabel);

		this.leftPanel.setLayout(new GridBagLayout());
		this.leftPanel.add(categoryPanel);

		this.buttonGroup.add(levelNo1Button);
		this.buttonGroup.add(levelNo2Button);
		this.buttonGroup.add(levelNo3Button);
		this.buttonGroup.add(levelNo4Button);
		this.buttonGroup.add(levelNo5Button);

		this.levelPanel.setLayout(new BoxLayout(levelPanel, BoxLayout.Y_AXIS));
		this.levelPanel.add(levelLabel);
		this.levelPanel.add(levelNo1Button);
		this.levelPanel.add(levelNo2Button);
		this.levelPanel.add(levelNo3Button);
		this.levelPanel.add(levelNo4Button);
		this.levelPanel.add(levelNo5Button);

		this.rightPanel.setLayout(new GridBagLayout());
		this.rightPanel.add(levelPanel);

		this.centerPanel.setLayout(new GridLayout(1, 2));
		this.centerPanel.add(leftPanel);
		this.centerPanel.add(rightPanel);

		this.content.setLayout(new BorderLayout());
		this.content.add(centerPanel, BorderLayout.CENTER);
		this.content.add(startButton, BorderLayout.SOUTH);
	}

	/**
	 * Initialisiert und hinzufuegt die Category-CheckBox
	 */
	public JCheckBox initAndAddNewCategoryCheckBox(String categoryText) {
		JCheckBox categoryCheckBox = new JCheckBox(categoryText);
		categoryCheckBox.setFont(ARIAL_PLAIN_20);
		categoryCheckBox.setForeground(STANDARD_COLOR);
		categoryCheckBox.setBackground(BACKGROUND_COLOR);
		categoryCheckBox.setFocusable(false);

		this.categoryPanel.add(categoryCheckBox);
		return categoryCheckBox;
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
	 * Gibt das Category-Label zurueck
	 * 
	 * @return JLabel
	 */
	public JLabel getCategoryLabel() {
		return this.categoryLabel;
	}

	/**
	 * Gibt das Category-Panel zurueck
	 * 
	 * @return JPanel
	 */
	public JPanel getCategoryPanel() {
		return this.categoryPanel;
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
	 * Gibt den LevelNo1-Button zurueck
	 * 
	 * @return JRadioButton
	 */
	public JRadioButton getLevelNo1Button() {
		return this.levelNo1Button;
	}

	/**
	 * Gibt den LevelNo2-Button zurueck
	 * 
	 * @return JRadioButton
	 */
	public JRadioButton getLevelNo2Button() {
		return this.levelNo2Button;
	}

	/**
	 * Gibt den LevelNo3-Button zurueck
	 * 
	 * @return JRadioButton
	 */
	public JRadioButton getLevelNo3Button() {
		return this.levelNo3Button;
	}

	/**
	 * Gibt den LevelNo4-Button zurueck
	 * 
	 * @return JRadioButton
	 */
	public JRadioButton getLevelNo4Button() {
		return this.levelNo4Button;
	}

	/**
	 * Gibt den LevelNo5-Button zurueck
	 * 
	 * @return JRadioButton
	 */
	public JRadioButton getLevelNo5Button() {
		return this.levelNo5Button;
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
	 * Gibt den Start-Button zurueck
	 * 
	 * @return JButton
	 */
	public JButton getStartButton() {
		return this.startButton;
	}
}
