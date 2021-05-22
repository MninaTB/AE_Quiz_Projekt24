import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import javax.swing.*;

import questions.QuestionParser;

/**
 * Klasse / Methode wo alles zusammen laeuft
 * Methode erstellt das GUI und sucht nach der Datei "question.json"
 * 
 */
public class Main {
	public static void main(String[] args) {
		String filename = "questions.json";
		var q = new QuestionParser();
		File file = new File(filename);
		try {
			InputStreamReader sr = new InputStreamReader(new FileInputStream(file));
			q.load(sr);
		} catch (FileNotFoundException e) {
			System.out.printf("could not load: %s\n", filename);
		}

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
