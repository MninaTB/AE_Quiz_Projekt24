package questions;

public interface QuestionStore {
	public Question[] getAllQuestions();
	public Question getQuestionByID(int id);
	public Question[] getQuestionByDifficulty(int difficulty);
	//TODO: Sobald es Category gibt, auskommentieren.
	//public Category getQuestionsByCategory(Category c);
	public void createQuestion(Question q);
	public void UpdateQuestion(Question q);
	public void DeleteQuestion(int id);
}
