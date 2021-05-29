import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

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

		JFrame f = new JFrame("Fenster");

		Registry reg = new Registry();
		Router router = new Router(f, reg, Screen.SCREEN_WELCOME);
		reg.init(router.getSwitcher(), q);

		Runnable spawner = new Runnable() {
			public void run() {
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.setTitle("Ein GUI");
				f.setSize(800, 600);
				f.setVisible(true);
				// NOTE: vielleicht muessen wir das laden vom screen mit dem starten
				// des routers synchronisieren.
			}
		};

		SwingUtilities.invokeLater(spawner);
		System.out.println("Run router!");
		router.Run();
		System.out.println("Bye!");
		System.exit(0);
	}
}
