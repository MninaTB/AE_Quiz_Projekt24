package controller;

import java.util.HashMap;

/**
 * Share wird genutzt um Daten zwischen controllern auszutauschen.
 */
public class Share {

	private HashMap<String, Object> intern;

	public Share() {
		this.intern = new HashMap<String, Object>();
	}

	public boolean entryExists(String k) {
		return this.intern.get(k) != null;
	}

	public Object get(String k) {
		return this.intern.get(k);
	}

	public void put(String k, Object v) {
		this.intern.put(k, v);
	}

}
