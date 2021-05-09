package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import questions.Question;
import questions.QuestionStore;
import questions.Category;

public class StateBuilder {
	private QuestionStore store;
	
	public StateBuilder(QuestionStore s) {
		this.store = s;
	}
	
	public State newState(ArrayList<Category> cs, int levelfk, int levelMax) 
			throws MissingQuestionsException {
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
		
		ArrayList<Question> result = new ArrayList<Question>();
		int counter = 0;
		int currentLevel = 0;
		int lastDifficulty = -1;

		for (int i = 0; i < allQuestions.size() && currentLevel < levelMax; i++) {
			Question q = allQuestions.get(i);
			
			int newDifficulty = q.getDifficulty();
			if(newDifficulty > lastDifficulty) {
				if (counter < levelfk && i != 0) {
					throw new MissingQuestionsException();
				}
				counter = 0;
				currentLevel++;
				lastDifficulty = newDifficulty;
			}
			if(counter >= levelfk) {
				continue;
			}			
			counter++;
			result.add(allQuestions.get(i));
		}
		return new State(result, levelfk);
	}
}
