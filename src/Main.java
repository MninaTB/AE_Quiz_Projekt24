import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

import javax.swing.*;

import gui.MainGUI;
import questions.QuestionParser;

public class Main {
	public static void main(String[] args) {
		String filename = "questions.json";
		QuestionParser q = new QuestionParser();
		File file = new File(filename);
		try {
			InputStreamReader sr = new InputStreamReader(new FileInputStream(file));
			q.load(sr);
		} catch (FileNotFoundException e) {
			System.out.printf("could not load: %s\n", filename);
		}

		MainGUI mainGUI = new MainGUI();
	}
}
