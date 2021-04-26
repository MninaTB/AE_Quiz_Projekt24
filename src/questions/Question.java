package questions;

public class Question implements Cloneable {

	private int id;
	private String questions;
	private int difficulty;
	private String[] answers;
	private int solution;
	private Category category;

	public Question() {
	}

	public int GetID() {
		return this.id;
	}

	public String GetQuestion() {
		return this.questions;
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
