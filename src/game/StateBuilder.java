package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import model.Question;
import questions.QuestionStore;
import model.Category;

public class StateBuilder {
	private QuestionStore store;
	
	/**
	 * Konstruktor mit einem Parameter, welcher an die Variable store uebergeben wird
	 * @param s
	 */
	public StateBuilder(QuestionStore s) {
		this.store = s;
	}

	/*
	 * Berechnet im wie vielten Level man ist und erhoeht somit den
	 * Schwierigkeitsgrad
	 * 
	 * @return neue State
	 */
	public State newState(ArrayList<Category> cs, int levelfk, int levelMax, int levelMin) throws MissingQuestionsException {
		ArrayList<Question> allQuestions = this.fetchAndSortbyDifficulty(cs);
		return new State(this.limitQuestions(allQuestions, levelfk, levelMax, levelMin), levelfk);
	}

	/**
	 * Prueft ob genug Fragen in den Kategorien vorhanden sind um das Spiel starten zu koennen
	 * @param cs
	 * @param levelfk
	 * @param levelMax
	 * @param levelMin
	 * @return true (wenn moeglich), false (wenn nicht moeglich)
	 */
	public boolean verify(ArrayList<Category> cs, int levelfk, int levelMax, int levelMin) {
		ArrayList<Question> allQuestions = this.fetchAndSortbyDifficulty(cs);
		try {
			this.limitQuestions(allQuestions, levelfk, levelMax, levelMin);
		} catch (MissingQuestionsException e) {
			System.out.print("fucking false;");
			return false;
		}
		return true;
	}

	private ArrayList<Question> fetchAndSortbyDifficulty(ArrayList<Category> cs) {
		ArrayList<Question> allQuestions = new ArrayList<Question>();
		// Get all Questions from the given Categories
		for (Category c : cs) {
			ArrayList<Question> q = this.store.getByCategory(c);
			allQuestions.addAll(q);
		}
		Collections.shuffle(allQuestions);

		Comparator<Question> compareByDifficulty = new Comparator<Question>() {
			@Override
			public int compare(Question q1, Question q2) {
				int x = q1.getDifficulty() - q2.getDifficulty();
				if (x > 0) {
					return 1;
				} else if (x == 0) {
					return 0;
				}
				return -1;
			}
		};
		Collections.sort(allQuestions, compareByDifficulty);
		return allQuestions;
	}

	private ArrayList<Question> limitQuestions(ArrayList<Question> input, int levelfk, int levelMax, int levelMin) throws MissingQuestionsException {
		ArrayList<Question> result = new ArrayList<Question>();

		if (input.size() == 0 && (levelfk > 0 || levelMax > 0 || levelMin < 1)) {
			throw new MissingQuestionsException();
		}

		int counter = 0;
		int currentLevel = 0;
		int lastDifficulty = -1;

		for (int i = 0; i < input.size() && currentLevel < levelMax && currentLevel > levelMin; i++) {
			Question q = input.get(i);

			int newDifficulty = q.getDifficulty();
			if (newDifficulty > lastDifficulty) {
				if (counter < levelfk && i != 0) {
					throw new MissingQuestionsException();
				}
				counter = 0;
				currentLevel++;
				lastDifficulty = newDifficulty;
			}
			if (counter >= levelfk) {
				continue;
			}
			counter++;
			result.add(input.get(i));
		}
		return result;
	}
}
