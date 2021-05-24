package ui;

import java.util.function.Function;

import javax.swing.JFrame;

import controller.Screen;
import controller.Switcher;

/**
 * Wird genutzt um verschiedene JPanel zu laden.
 * Ein Screen wechsel ist threadsafe.
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
	 * Konstruktor zum erzeugen eines Routers.
	 * In der Registry hinterlegte JPanel koennen geladen
	 * und auf dem uebergebenen JFrame angezeigt werden.
	 * 
	 * @param frame
	 * @param reg
	 */
	public Router(JFrame frame, Registry reg) {
		this.frame = frame;
		this.registry = reg;
		this.mutex = new Object();
	}

	/**
	 * Run blockiert einen thread und wartet auf eine
	 * aenderung des aktuellen screens.
	 */
	public void Run() {
		while (this.next != Screen.SCREEN_EXIT) {
			synchronized (this.mutex) {
				try {
					// wait() blockiert diesen thread bis ein anderer
					// thread next() aufruft.
					this.mutex.wait();
				} catch (InterruptedException e) {
					System.exit(1);
				}
			}
			System.out.print("Load screen: ");
			System.out.println(this.next.toString());
			this.frame.removeAll();
			var next = this.registry.get(this.next);
			/**
			 * @debug begin
			 */
			System.out.print("Components in Panel: ");
			System.out.println(next.getComponentCount());
			/**
			 * @debug end
			 */
			this.frame.add(next);
			/**
			 * @debug begin
			 */
			System.out.print("Components in Frame: ");
			System.out.println(this.frame.getComponentCount());
			/**
			 * @debug end
			 */
			this.frame.setVisible(true);
			this.frame.revalidate();
			this.frame.repaint();
		}
	}

	/**
	 * setStartScreen wird genutzt um den ersten screen zu laden.
	 * @param s
	 */
	public void setStartScreen(Screen s) {
		this.performSwitch(s);
	}

	/**
	 * performSwitch aendert zunaechst zu ladenen screen und 
	 * informiert das objekt ueber eine zustandsaenderung.
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
	 * Gibt einen thread-safen switcher zuruek um den aktuellen 
	 * screen zu wechseln.
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
