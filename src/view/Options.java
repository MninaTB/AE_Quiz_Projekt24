package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
 * Options ist ein view, welches JComponents haelt und anbietet.
 */
public class Options {
	private JPanel content;

	private JButton homeButton;
	private JLabel titleLabel;
	private JButton exitButton;
	private JPanel topPanel;
	private JLabel checkboxFieldnameLabel;
	private JLabel questionFieldnameLabel;
	private JLabel categoryFieldnameLabel;
	private JLabel levelFieldnameLabel;
	private JLabel editFieldnameLabel;
	private JPanel centerPanel;
	private JScrollPane centerScrollPane;
	private JButton addButton;
	private JButton deleteButton;
	private JPanel bottomPanel;

	private final Font ARIAL_BOLD_70 = new Font("Arial", Font.BOLD, 70);
	private final Font ARIAL_BOLD_50 = new Font("Arial", Font.BOLD, 50);
	private final Color STANDARD_COLOR = Color.CYAN;
	private final Color TRANSPARENT_COLOR = new Color(0, 0, 0, 0);

	/**
	 * Konstrukor zum erzeugen eines Result views.
	 */
	public Options() {
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

		this.checkboxFieldnameLabel = new JLabel();
		this.checkboxFieldnameLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, STANDARD_COLOR));

		this.questionFieldnameLabel = new JLabel();
		this.questionFieldnameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		this.questionFieldnameLabel.setFont(ARIAL_BOLD_50);
		this.questionFieldnameLabel.setForeground(STANDARD_COLOR);
		this.questionFieldnameLabel.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 0, STANDARD_COLOR));

		this.categoryFieldnameLabel = new JLabel();
		this.categoryFieldnameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		this.categoryFieldnameLabel.setFont(ARIAL_BOLD_50);
		this.categoryFieldnameLabel.setForeground(STANDARD_COLOR);
		this.categoryFieldnameLabel.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, STANDARD_COLOR));

		this.levelFieldnameLabel = new JLabel();
		this.levelFieldnameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		this.levelFieldnameLabel.setFont(ARIAL_BOLD_50);
		this.levelFieldnameLabel.setForeground(STANDARD_COLOR);
		this.levelFieldnameLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, STANDARD_COLOR));

		this.editFieldnameLabel = new JLabel();
		this.editFieldnameLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, STANDARD_COLOR));

		this.centerPanel = new JPanel();
		this.centerPanel.setOpaque(false);

		this.centerScrollPane = new JScrollPane(centerPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		this.centerScrollPane.setOpaque(false);
		this.centerScrollPane.getViewport().setOpaque(false);
		this.centerScrollPane.setBorder(null);
		this.centerScrollPane.getVerticalScrollBar().setOpaque(false);
		this.centerScrollPane.getVerticalScrollBar().setBorder(null);
		this.centerScrollPane.getVerticalScrollBar().getComponent(0).setBackground(STANDARD_COLOR);
		this.centerScrollPane.getVerticalScrollBar().getComponent(1).setBackground(STANDARD_COLOR);
		this.centerScrollPane.getHorizontalScrollBar().setOpaque(false);
		this.centerScrollPane.getHorizontalScrollBar().setBorder(null);
		this.centerScrollPane.getHorizontalScrollBar().getComponent(0).setBackground(STANDARD_COLOR);
		this.centerScrollPane.getHorizontalScrollBar().getComponent(1).setBackground(STANDARD_COLOR);

		this.addButton = new JButton();
		this.addButton.setFont(ARIAL_BOLD_50);
		this.addButton.setForeground(STANDARD_COLOR);
		this.addButton.setBackground(TRANSPARENT_COLOR);
		this.addButton.setContentAreaFilled(false);
		this.addButton.setBorder(null);
		this.addButton.setFocusPainted(false);

		this.deleteButton = new JButton();
		this.deleteButton.setFont(ARIAL_BOLD_50);
		this.deleteButton.setForeground(STANDARD_COLOR);
		this.deleteButton.setBackground(TRANSPARENT_COLOR);
		this.deleteButton.setContentAreaFilled(false);
		this.deleteButton.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 0, STANDARD_COLOR));
		this.deleteButton.setFocusPainted(false);

		this.bottomPanel = new JPanel();
		this.bottomPanel.setOpaque(false);
		this.bottomPanel.setBorder(BorderFactory.createMatteBorder(5, 0, 0, 0, STANDARD_COLOR));
	}

	/**
	 * Initialisiert view layout.
	 */
	public void initLayout() {
		this.topPanel.setLayout(new BorderLayout());
		this.topPanel.add(homeButton, BorderLayout.WEST);
		this.topPanel.add(titleLabel, BorderLayout.CENTER);
		this.topPanel.add(exitButton, BorderLayout.EAST);

		this.centerPanel.setLayout(new GridLayout(0, 5));
		this.centerPanel.add(checkboxFieldnameLabel);
		this.centerPanel.add(questionFieldnameLabel);
		this.centerPanel.add(categoryFieldnameLabel);
		this.centerPanel.add(levelFieldnameLabel);
		this.centerPanel.add(editFieldnameLabel);

		this.bottomPanel.setLayout(new GridLayout(1, 2));
		this.bottomPanel.add(addButton);
		this.bottomPanel.add(deleteButton);

		this.content.setLayout(new BorderLayout());
		this.content.add(this.topPanel, BorderLayout.NORTH);
		this.content.add(this.centerScrollPane, BorderLayout.CENTER);
		this.content.add(this.bottomPanel, BorderLayout.SOUTH);
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
	 * Gibt das QuestionFieldname-Label zurueck
	 * 
	 * @return JLabel
	 */
	public JLabel getQuestionFieldnameLabel() {
		return this.questionFieldnameLabel;
	}

	/**
	 * Gibt das CategoryFieldname-Label zurueck
	 * 
	 * @return JLabel
	 */
	public JLabel getCategoryFieldnameLabel() {
		return this.categoryFieldnameLabel;
	}

	/**
	 * Gibt das LevelFieldname-Label zurueck
	 * 
	 * @return JLabel
	 */
	public JLabel getLevelFieldnameLabel() {
		return this.levelFieldnameLabel;
	}

	/**
	 * Gibt das Center-Panel zurueck
	 * 
	 * @return JPanel
	 */
	public JPanel getCenterPanel() {
		return this.centerPanel;
	}

	/**
	 * Gibt den Add-Button zurueck
	 * 
	 * @return JButton
	 */
	public JButton getAddButton() {
		return this.addButton;
	}

	/**
	 * Gibt den Delete-Button zurueck
	 * 
	 * @return JButton
	 */
	public JButton getDeleteButton() {
		return this.deleteButton;
	}
}
