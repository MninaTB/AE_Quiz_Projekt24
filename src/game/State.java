package game;

import java.util.ArrayList;

import questions.Question;

public class State {
	private ArrayList<Question> questions;
	private int iter;
	private int levelfk = 10;

	public State(ArrayList<Question> questions, int levelfk) {
		this.questions = questions;
		this.iter = 0;
		if (levelfk > 0) {
			this.levelfk = levelfk;
		}
	}

	public Question next() {
		if (this.questions.size() == this.iter) {
			return null;
		}
		Question q = this.questions.get(this.iter);
		this.iter++;
		return q;
	}

	public int getLevel() {
		return 1 + this.iter / this.levelfk;
	}
}
