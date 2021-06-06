package questions;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.stream.Collectors;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import model.Question;
import model.Category;


public class QuestionParser implements QuestionStore {

	private ArrayList<Question> questions;

	/**
	 * Standard Konstruktor
	 * hier wird die ArrayList initialisiert
	 */
	public QuestionParser() {
		this.questions = new ArrayList<Question>();
	}
	
	/**
	 * Konstruktor mit Parameter zur Uebergabe beim initialisieren
	 * @param q
	 */
	public QuestionParser(ArrayList<Question> q) {
		this.questions = q;
	}

	/**
	 * Laedt die Fragen aus einem json File in das Array "questions"
	 * @param sr
	 */
	public void load(InputStreamReader sr) {
		Gson gson = new Gson();
		String json = new BufferedReader(sr)
				   .lines().collect(Collectors.joining("\n"));
		var t = TypeToken.getParameterized(ArrayList.class, Question.class).getType();
		this.questions = gson.fromJson(json, t);
	}
	
	/**
	 * Speichert die neuen Fragen in die ArrayList von questions
	 * @param w
	 */
	public void save(OutputStreamWriter w) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		gson.toJson(this.questions, w);
	}

	/**
	 * Gibt alle Fragen in einer ArrayList zurueck
	 */
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Question> getAllQuestions() {
		return (ArrayList<Question>) this.questions.clone();
	}

	/**
	 * Gibt eine Frage zurueck mit Angabe einer ID
	 * @param id
	 */
	@Override
	public Question getByID(int id) {
		for (Question q : this.questions) {
			if (q.getID() == id) {
				return q;
			}
		}
		return null;
	}

	/**
	 * Gibt eine oder mehrere Fragen zurueck mit Angabe des Schwierigkeitsgrades
	 * @param difficulty
	 */
	@Override
	public ArrayList<Question> getByDifficulty(int difficulty) {
		ArrayList<Question> questions = new ArrayList<Question>();
		for (Question q : this.questions) {
			if (q.getDifficulty() == difficulty) {
				try {
					questions.add((Question) q.clone()); // ;
				} catch (CloneNotSupportedException e) {
				}
			}
		}
		return questions;
	}

	/**
	 * Gibt Fragen zurueck mit Angabe der Kategorie
	 * @param c
	 */
	@Override
	public ArrayList<Question> getByCategory(Category c) {
		ArrayList<Question> questions = new ArrayList<Question>();
		for (Question q : this.questions) {
			if (q.getCategory() == c) {
				try {
					questions.add((Question) q.clone());
				} catch (CloneNotSupportedException e) {
				}
			}
		}
		return questions;
	}

	/**
	 * Erstellt eine neue Frage fuer das Quiz
	 * @param q
	 */
	@Override
	public void create(Question q) {
		try {
			this.questions.add((Question) q.clone());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Updated das Quiz mit den neuen Fragen
	 * @param qu
	 */
	@Override
	public void update(Question qu) {
		for (int i = 0; i < this.questions.size(); i++) {
			if (this.questions.get(i).getID() == qu.getID()) {
				Question newQuestion;
				try {
					newQuestion = (Question) qu.clone();
				} catch (CloneNotSupportedException e) {
					e.printStackTrace();
					continue;
				}
				this.questions.add(i, newQuestion);
				return;
			}
		}
	}

	/**
	 * Loescht die Fragen mit der dazugehoerigen ID
	 * @param id
	 */
	@Override
	public void delete(int id) {
		for (Question q : this.questions) {
			if (q.getID() == id) {
				this.questions.remove(q);
				return;
			}
		}
	}
}