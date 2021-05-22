package questions;

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
	private int answer_id;
	private int solution;
	private int category_id;

	public Question(int id, String q, int d, int aw, int s, int c) {
		this.id = id;
		this.question = q;
		this.difficulty = d;
		this.answer_id = aw;
		this.solution = s;
		this.category_id = c;
	}

	/**
	 * Gibt die ID zurueck
	 * @return id (int)
	 */
	public int getID() {
		return id;
	}

	public void setID(int id) {		
		this.id = id;
	}
	
	/**
	 * Gibt die Question als String zurueck
	 * @return question (String)
	 */
	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {		
		this.question = question;
	}

  /**
   * Gibt den Schwierigkeitsgrad zurueck
   * @return difficulty
   */
  public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

  /**
   * Gibt die Antworten in einer ArrayList zurueck
   * @return answers
   */
	public int getAnswerId() {
		return answer_id;
	}

	public void setAnswerId(int answer_id) {
		this.answer_id = answer_id;
	}

    /**
     * Gibt die Loesungen zurueck
     * @return solution
     */
	public int getSolution() {
		return solution;
	}

	public void setSolution(int solution) {		
		this.solution = solution;
	}
	
	/**
	 * Gibt die Kategorien zurueck
	 * @return category
	 */
	public int getCategoryId() {
		return category_id;
	}

	public void setCategory(int category_id) {
		this.category_id = category_id;
	}

 /**
  * Methode zum Klonen des Objekts
  */
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

