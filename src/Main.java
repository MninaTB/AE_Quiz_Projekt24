import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import controller.Screen;
import questions.QuestionParser;
import ui.Registry;
import ui.Router;

/**
 * Klasse / Methode wo alles zusammen laeuft Methode erstellt das GUI und sucht
 * nach der Datei "question.json"
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

		JFrame f = new JFrame();

		Registry reg = new Registry();
		Router router = new Router(f, reg, Screen.SCREEN_START);
		reg.init(router.getSwitcher(), q);

		Runnable spawner = new Runnable() {
			public void run() {
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.setSize(1280, 720);
				f.setResizable(false);
				// Entfernt Fensterrahmen, erst nachdem alle Exit-Buttons implementiert sind aktivieren
				//f.setUndecorated(true);
				f.setLocationRelativeTo(null);
				f.setVisible(true);
				// NOTE: vielleicht muessen wir das laden vom screen mit dem starten
				// des routers synchronisieren.
			}
		};

		SwingUtilities.invokeLater(spawner);
		System.out.println("Run router!");
		router.Run();
		try {
			OutputStream os = new FileOutputStream(file);
			OutputStreamWriter osw = new OutputStreamWriter(os);
			q.save(osw);
			osw.flush();
		} catch (Exception e) {
			System.out.print("Failed to save questions, file: ");
			System.out.println(filename);
			System.exit(1);
		} 
		System.out.println("Saved questions!");
		System.out.println("Bye!");
		System.exit(0);
	}
}
