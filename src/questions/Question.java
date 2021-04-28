package questions;

public class Question implements Cloneable {

	private int id;
	private String question;
	private int difficulty;
	private String[] answers;
	private int solution;
	private Category category;

	public Question(int id, String q, int d, String[] aw, int s, Category c) {
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

	public String[] GetAnswers() {
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
