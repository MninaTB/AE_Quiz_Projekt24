package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.BorderFactory;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainGUI {
	private JFrame frame;
	private JPanel frameContentPane;
	private StartGUI startGUI;
	private GameGUI gameGUI;
	//private OptionsGUI optionsGUI;
	private ResultGUI resultGUI;
	
	public MainGUI() {
		this.frame = new JFrame();
		this.frameContentPane = new JPanel(new BorderLayout());
		this.frame.add(this.frameContentPane);
		this.startGUI = new StartGUI();
		this.gameGUI = new GameGUI();
		//this.optionsGUI = new OptionsGUI();
		this.resultGUI = new ResultGUI();
		
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
		this.frame.setUndecorated(true);
		this.frame.setLocationRelativeTo(null);
		this.frame.setVisible(true);
		
		Border frameBorder = BorderFactory.createLineBorder(Color.CYAN, 5);
		this.frameContentPane.setBorder(frameBorder);
		
		Color backgroundColor = new Color(77, 77, 77);
		this.frameContentPane.setBackground(backgroundColor);
	}
	
	private void setActionEvents() {
		setStartEvent();
		setOptionsEvent();
		setHomeEvent();
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
	
	private void setHomeEvent() {
		this.gameGUI.getHomeButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				home();
			}
		});
		this.resultGUI.getHomeButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				home();
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
		this.gameGUI.getExitButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				exit();
			}
		});
		this.resultGUI.getExitButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				exit();
			}
		});
	}
	
	private void start() {
		this.frameContentPane.removeAll();
		this.frameContentPane.add(this.gameGUI);
		this.frameContentPane.revalidate();
		this.frameContentPane.repaint();
	}
	
	private void options() {
		this.frameContentPane.removeAll();
		//Temporaer ResultGUI auf OptionsButton gelegt zum Testen
		this.frameContentPane.add(this.resultGUI);
		//this.frameContentPane.add(this.optionsGUI);
		this.frameContentPane.revalidate();
		this.frameContentPane.repaint();
	}
	
	private void home() {
		this.frameContentPane.removeAll();
		this.frameContentPane.add(this.startGUI, BorderLayout.SOUTH);
		this.frameContentPane.revalidate();
		this.frameContentPane.repaint();
	}
	
	private void exit() {
		System.exit(0);
	}
}
