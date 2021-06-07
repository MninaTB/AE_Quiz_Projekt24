package game;

import java.util.ArrayList;

import model.Category;
import model.Question;
import questions.QuestionStore;

/**
 * Klasse wird benoetigt um eine Datenbank zu simulieren in spaeteren verlaeufen
 */
public class MockQuestionStoreTest implements QuestionStore {

	private ArrayList<Question> db;

	public MockQuestionStoreTest(ArrayList<Question> db) {
		this.db = db;
	}

	@Override
	public ArrayList<Question> getAllQuestions() {
		// NOTE: unused
		return null;
	}

	@Override
	public Question getByID(int id) {
		// NOTE: unused
		return null;
	}

	@Override
	public ArrayList<Question> getByDifficulty(int difficulty) {
		// NOTE: unused
		return null;
	}

	@Override
	public ArrayList<Question> getByCategory(Category c) {
		ArrayList<Question> result = new ArrayList<Question>();
		for (Question q : this.db) {
			if (c == q.getCategory()) {
				result.add(q);
			}
		}
		return result;
	}

	@Override
	public void create(Question q) {
		// NOTE: unused

	}

	@Override
	public void update(Question q) {
		// NOTE: unused
	}

	@Override
	public void delete(int id) {
		// NOTE: unused
	}

	@Override
	public ArrayList<Category> getCategories() {
		// TODO Auto-generated method stub
		return null;
	}

}
