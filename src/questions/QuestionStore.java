package questions;

import java.util.ArrayList;

/**
 * Interface welches benutzt wird fuer die Implementation von den Methoden aus QuestionParser
 */
public interface QuestionStore {
	public ArrayList<Question> getAllQuestions();
	public Question getByID(int id);
	public ArrayList<Question> getByDifficulty(int difficulty);
	public ArrayList<Question> getByCategory(Category c);
	public void create(Question q);
	public void update(Question q);
	public void delete(int id);
}
