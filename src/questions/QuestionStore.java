package questions;

import java.util.ArrayList;

public interface QuestionStore {
	public ArrayList<Question> GetAllQuestions();
	public Question GetQuestionByID(int id);
	public ArrayList<Question> GetQuestionByDifficulty(int difficulty);
	public ArrayList<Question> GetQuestionsByCategory(Category c);
	public void CreateQuestion(Question q);
	public void UpdateQuestion(Question q);
	public void DeleteQuestion(int id);
}
