import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import controller.Screen;
import questions.QuestionDB;
import questions.QuestionParser;
import questions.QuestionStore;
import ui.Registry;
import ui.Router;

/**
 * Klasse / Methode wo alles zusammen laeuft Methode erstellt das GUI und sucht
 * nach der Datei "question.json"
 * 
 */
public class Main {
	public static void main(String[] args) {
		final String fallback = "questions.json";
		String filename = "";
		File file = null;
		QuestionParser q = null;
		QuestionStore store = null;
		if (args.length > 0) {
			if (args[0].contains("sql")) {
				if (args.length < 2) {
					System.out.println("missing arguments (url, username, password) want: 3 got: " + args.length);
				}
				Connection connection = null;
				String url = args[0];
				String username = args[1];
				String password = args[2];
				try {
					connection = DriverManager.getConnection(url, username, password);
				} catch (SQLException e) {
					System.out.println("An error occurred while connecting MySQL databse");
					e.printStackTrace();
				}
				store = new QuestionDB(connection);
			} else if (args[0].contains("json")) {
				filename = args[0];
			} else {
				System.out.println("invalid argument: " + args[0]);
				System.exit(1);
			}
		} else {
			System.out.println("missing connection arguments, use fallback store: " + fallback);
			filename = fallback;
		}
		
		if (store == null) {
			q = new QuestionParser();
			file = new File(filename);
			try {
				InputStreamReader sr = new InputStreamReader(new FileInputStream(file));
				q.load(sr);
			} catch (FileNotFoundException e) {
				System.out.printf("could not load: %s\n", filename);
			}
			store = q;
		}


		JFrame f = new JFrame();

		Registry reg = new Registry();
		Router router = new Router(f, reg, Screen.SCREEN_START);
		reg.init(router.getSwitcher(), store);

		Runnable spawner = new Runnable() {
			public void run() {
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.setSize(1280, 720);
				f.setResizable(false);
				// Entfernt Fensterrahmen, erst nachdem alle Exit-Buttons implementiert sind
				// aktivieren
				// f.setUndecorated(true);
				f.setLocationRelativeTo(null);
				f.setVisible(true);
				// NOTE: vielleicht muessen wir das laden vom screen mit dem starten
				// des routers synchronisieren.
			}
		};

		SwingUtilities.invokeLater(spawner);
		System.out.println("Run router!");
		router.Run();
		if (file != null) {
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
		}
		System.out.println("Bye!");
		System.exit(0);
	}
}
