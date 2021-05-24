package view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * 
 * Start ist ein view, welches JComponents
 * haelt und anbietet.
 * 
 * @author nina
 *
 */
public class Start {
	private JPanel content;

	private JButton first;
	private JButton second;
	private JButton third;

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
		this.first = new JButton();
		this.second = new JButton();
		this.third = new JButton();
	}

	/**
	 * Initialisiert view layout.
	 */
	public void initLayout() {
		this.content = new JPanel();
		this.content.setLayout(new FlowLayout());

		this.content.add(this.first);
		this.content.add(this.second);
		this.content.add(this.third);
	}

	/**
	 * Gibt den ersten Button zurueck
	 * @return JButton
	 */
	public JButton getFirst() {
		return this.first;
	}

	/**
	 * Gibt den zweiten Button zurueck
	 * @return JButton
	 */
	public JButton getSecond() {
		return this.second;
	}

	/**
	 * Gibt den dritten Button zurueck
	 * @return JButton
	 */
	public JButton getThird() {
		return this.third;
	}
	
	public JPanel getContent() {
		return this.content;
	}
}
