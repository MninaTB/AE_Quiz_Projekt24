package ui;

import java.awt.Color;
import java.util.function.Function;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.Screen;
import controller.Switcher;

/**
 * Wird genutzt um verschiedene JPanel zu laden. Ein Screen wechsel ist
 * threadsafe.
 * 
 * @author nina
 *
 */
public class Router {

	private Screen next;
	private Registry registry;
	private JFrame frame;
	private Object mutex;

	/**
	 * Konstruktor zum erzeugen eines Routers. In der Registry hinterlegte JPanel
	 * koennen geladen und auf dem uebergebenen JFrame angezeigt werden.
	 * 
	 * @param frame
	 * @param reg
	 */
	public Router(JFrame frame, Registry reg, Screen start) {
		this.frame = frame;
		this.registry = reg;
		this.next = start;
		this.mutex = new Object();
	}

	/**
	 * Run blockiert einen thread und wartet auf eine aenderung des aktuellen
	 * screens.
	 */
	public void Run() {
		while (this.next != Screen.SCREEN_EXIT) {
			System.out.print("Load screen: ");
			System.out.println(this.next.toString());
			JPanel current = this.registry.get(this.next);
			current.setBorder(BorderFactory.createLineBorder(Color.CYAN, 5));
			current.setBackground(new Color(77, 77, 77));
			this.frame.add(current);
			this.frame.setVisible(true);
			this.frame.revalidate();
			this.frame.repaint();

			synchronized (this.mutex) {
				try {
					// wait() blockiert diesen thread bis ein anderer
					// thread next() aufruft.
					this.mutex.wait();
				} catch (InterruptedException e) {
					System.exit(1);
				}
				this.frame.remove(current);
			}

		}
	}

	/**
	 * performSwitch aendert zunaechst zu ladenen screen und informiert das objekt
	 * ueber eine zustandsaenderung.
	 * 
	 * @param s
	 */
	public void performSwitch(Screen s) {
		synchronized (this.mutex) {
			this.next = s;
			this.mutex.notify();
		}
	}

	/**
	 * Gibt einen thread-safen switcher zuruek um den aktuellen screen zu wechseln.
	 * 
	 * @return Switcher
	 */
	public Switcher getSwitcher() {
		Function<Screen, Integer> perform = nextScreen -> {
			this.performSwitch(nextScreen);
			return 0;
		};
		return new Switcher() {
			@Override
			public void next(Screen s) {
				perform.apply(s);
			}
		};
	}
}
