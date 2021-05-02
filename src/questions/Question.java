package questions;

import java.util.ArrayList;

public class Question implements Cloneable {

	private int id;
	private String question;
	private int difficulty;
	private ArrayList<String> answers;
	private int solution;
	private Category category;

	public Question(int id, String q, int d, ArrayList<String> aw, int s, Category c) {
		this.id = id;
		this.question = q;
		this.difficulty = d;
		this.answers = aw;
		this.solution = s;
		this.category = c;
	}

	public int GetID() {
		return this.id;
	}

	public String GetQuestion() {
		return this.question;
	}

	public int GetDifficulty() {
		return this.difficulty;
	}

	public ArrayList<String> GetAnswers() {
		return this.answers;
	}

	public int GetSolution() {
		return this.solution;
	}

	public Category GetCategory() {
		return this.category;
	}

	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
