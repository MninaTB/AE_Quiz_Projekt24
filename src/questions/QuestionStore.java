package questions;

import java.util.ArrayList;

public interface QuestionStore {
	public ArrayList<Question> getAllQuestions();
	public Question getByID(int id);
	public ArrayList<Question> getByDifficulty(int difficulty);
	public ArrayList<Question> getByCategory(Category c);
	public void create(Question q);
	public void update(Question q);
	public void delete(int id);
}
