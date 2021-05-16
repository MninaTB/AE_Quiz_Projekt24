package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.BorderFactory;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI {
	private JFrame frame;
	private JPanel frameContentPane;
	private StartGUI startGUI;
	//private GameGUI gameGUI;
	//private OptionsGUI optionsGUI;
	//private ResultGUI resultGUI;
	
	public static void main(String[] args) {
		new MainGUI();
	}
	
	public MainGUI() {
		this.frame = new JFrame();
		this.frameContentPane = new JPanel();
		this.frame.add(this.frameContentPane);
		this.startGUI = new StartGUI();
		//this.gameGUI = new GameGUI();
		//this.optionsGUI = new OptionsGUI();
		//this.resultGUI = new ResultGUI();
		
		createAndShowGUI();
	}
	
	private void createAndShowGUI() {
		setDefaultFrame();
		setActionEvents();
		this.frameContentPane.add(this.startGUI, BorderLayout.SOUTH);
	}
	
	private void setDefaultFrame() {
		this.frame.setSize(1280, 720);
		this.frame.setResizable(false);
		//this.frame.setUndecorated(true);
		this.frame.setLocationRelativeTo(null);
		this.frame.setVisible(true);
		
		this.frameContentPane.setLayout(new BorderLayout());
		
		Border frameBorder = BorderFactory.createLineBorder(Color.CYAN, 5);
		this.frameContentPane.setBorder(frameBorder);
		
		Color backgroundColor = new Color(77, 77, 77);
		this.frameContentPane.setBackground(backgroundColor);
	}
	
	private void setActionEvents() {
		setStartEvent();
		setOptionsEvent();
		setExitEvent();
	}
	
	private void setStartEvent() {
		this.startGUI.getStartButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				start();
			}
		});
	}
	
	private void setOptionsEvent() {
		this.startGUI.getOptionsButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				options();
			}
		});
	}
	
	private void setExitEvent() {
		this.startGUI.getExitButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				exit();
			}
		});
	}
	
	private void start() {
		this.frameContentPane.removeAll();
		//this.frameContentPane.add(this.gameGUI);
		this.frameContentPane.revalidate();
		this.frameContentPane.repaint();
		//Button-Test Ausgabe
		System.out.println("GameGUI");
	}
	
	private void options() {
		this.frameContentPane.removeAll();
		//this.frameContentPane.add(this.optionsGUI);
		this.frameContentPane.revalidate();
		this.frameContentPane.repaint();
		//Button-Test Ausgabe
		System.out.println("OptionsGUI");
	}
	
	private void exit() {
		System.exit(0);
	}
}

