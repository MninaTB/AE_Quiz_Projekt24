package questions;

import java.util.ArrayList;

/**
 * Diese Klasse ist nur fuer die Fragen im Quiz.
 * Hier haben wir einen Konstruktor und ausserdem verschiedene Getter-Methoden
 * fuer den Zugriff von anderen Klassen
 * 
 */

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

	/**
	 * Gibt die ID zurueck
	 * @return id (int)
	 */
	public int getID() {
		return this.id;
	}
	
	/**
	 * Gibt die Question als String zurueck
	 * @return question (String)
	 */
	public String getQuestion() {
		return this.question;
	}
	

	public void setID(int id) {		
		this.id = id;
	}

	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {		
		this.question = question;
	}

  /**
   * Gibt den Schwierigkeitsgrad zurueck
   * @return difficulty
   */
  public int getDifficulty() {
		return this.difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

  /**
   * Gibt die Antworten in einer ArrayList zurueck
   * @return answers
   */
	public ArrayList<String> getAnswers() {
		return this.answers;
	}

	public void setAnswers(ArrayList<String> answers) {
		this.answers = answers;
	}

    /**
     * Gibt die Loesungen zurueck
     * @return solution
     */
	public int getSolution() {
		return this.solution;
	}
	
	/**
	 * Gibt die Kategorien zurueck
	 * @return category
	 */
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

 /**
  * Methode zum Klonen des Objekts
  */
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

