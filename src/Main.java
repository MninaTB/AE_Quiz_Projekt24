import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Main {
		JFrame f = new JFrame("Fenster");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel contentPanel = new JPanel();
		contentPanel.setLayout(new FlowLayout());
		
		f.setTitle("Ein GUI");
		f.setSize(250, 250);
		f.setVisible(true);
		
		f.getContentPane().add(BorderLayout.CENTER, contentPanel);
	}
}
