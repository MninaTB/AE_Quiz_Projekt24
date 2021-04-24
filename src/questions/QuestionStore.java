package questions;

public interface QuestionStore {
	public Question[] GetAllQuestions();
	public Question GetQuestionByID(int id);
	public Question[] GetQuestionByDifficulty(int difficulty);
	public Category GetQuestionsByCategory(Category c);
	public void CreateQuestion(Question q);
	public void UpdateQuestion(Question q);
	public void DeleteQuestion(int id);
}
