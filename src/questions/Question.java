package questions;

public class Question {
	
	private String id;
	private String questions;
	private int iDifficulty;
	private String[] answers;
	private int iSolution;
	
	//TODO: Category muss hinzugefügt werden
//Category gibt es noch nicht -> private Category category;

	public String getID() {
		return this.id;
	}
	
	public String getQuestion() {
		return this.questions;
	}
	
	public int getDifficulty() {
		return this.iDifficulty;
	}
	
	public String[] getAnswers() {
		return this.answers;
	}
	
	public int getSolution() {
		return this.iSolution;
	}
	
	// TODO: Category muss hinzugefügt werden
	/*
	public Category getCategory() {
		return this.category;
	}
	*/
}
