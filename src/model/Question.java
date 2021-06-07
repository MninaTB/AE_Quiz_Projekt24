package model;

import java.util.ArrayList;

/**
 * Diese Klasse ist nur fuer die Fragen im Quiz. Hier haben wir einen
 * Konstruktor und ausserdem verschiedene Getter-Methoden fuer den Zugriff von
 * anderen Klassen
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
	 * 
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
	 * 
	 * @return question (String)
	 */
	public String getQuestion() {
		return this.question;
	}

	/**
	 * Ueberschreibt Frage
	 * 
	 */
	public void setQuestion(String q) {
		this.question = q;
	}

	/**
	 * Gibt den Schwierigkeitsgrad zurueck
	 * 
	 * @return difficulty
	 */
	public int getDifficulty() {
		return this.difficulty;
	}

	/**
	 * Ueberschreibt Schwierigkeitsgrad
	 * 
	 */
	public void getDifficulty(int d) {
		this.difficulty = d;
	}

	/**
	 * Gibt die Antworten in einer ArrayList zurueck
	 * 
	 * @return answers
	 */
	public ArrayList<String> getAnswers() {
		return this.answers;
	}

	/**
	 * Setzt Antwort moeglichkeiten, mindestens 4 antworten muessen existieren
	 * 
	 */
	public void setAnswers(ArrayList<String> a) throws IllegalArgumentException {
		if (a.size() < 4) {
			throw new IllegalArgumentException();
		}
		this.answers = a;
	}

	/**
	 * Gibt die Loesungen zurueck
	 * 
	 * @return solution
	 */
	public int getSolution() {
		return this.solution;
	}

	/**
	 * Setzt index der Loesung
	 * 
	 */
	public void setSolution(int s) {
		if (s > 3) {
			throw new IllegalArgumentException();
		}
		this.solution = s;
	}

	/**
	 * Gibt die Kategorien zurueck
	 * 
	 * @return category
	 */
	public Category getCategory() {
		return this.category;
	}

	/**
	 * Legt Category fuer Frage fest
	 * 
	 */
	public void setCategory(Category c) {
		this.category = c;
	}

	/**
	 * Methode zum Klonen des Objekts
	 */
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
