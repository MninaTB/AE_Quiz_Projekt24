package controller;

import javax.swing.JLabel;
import javax.swing.JPanel;

import questions.QuestionStore;

public class Categories implements Controller {

	private Switcher switcher;
	private QuestionStore store;

	public Categories(Switcher s, QuestionStore store) {
		this.switcher = s;
		this.store = store;
	}

	@Override
	public JPanel toJPanel() {
		// TODO create view
		var r = new JPanel();
		r.add(new JLabel("Categories"));
		return r;
	}

}
