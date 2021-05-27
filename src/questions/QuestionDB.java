package questions;

import model.Question;
import model.Category;

/**
 * @author Roger
 */

import java.sql.*;
import java.util.ArrayList;

public class QuestionDB implements QuestionStore {

	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	

	public QuestionDB(Connection connection) {

		this.setConnection(connection);
	}

	public Connection getConnection() {
		return connection;
	}

	private void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public Question getByID(int id) {

		try {

			String query = "SELECT questions.*, answers.a, answers.b, answers.c, answers.d, categories.name"
					+ "FROM questions"
					+ "LEFT JOIN answers ON questions.answer_id = answers.id"
					+ "LEFT JOIN categories ON questions.category_id = categories.id"
					+ "WHERE questions.id = " + id;
			
			preparedStatement = connection.prepareStatement(query);			
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
				//	Prepare answers
				ArrayList<String> answers = new ArrayList<String>(); 
				answers.add(resultSet.getString("answers.a"));
				answers.add(resultSet.getString("answers.b"));
				answers.add(resultSet.getString("answers.c"));
				answers.add(resultSet.getString("answers.d"));
				
				//	Prepare category
				Category category = null;

				//	Create object
				Question question = new Question(
					resultSet.getInt("id"),
					resultSet.getString("question"),
					resultSet.getInt("difficulty"),
					answers,
					resultSet.getInt("solution"),
					category
				);
				return question;
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Question> getByDifficulty(int difficulty) {

		try {

			String query = "SELECT questions.*, answers.a, answers.b, answers.c, answers.d, categories.name"
					+ "FROM questions"
					+ "LEFT JOIN answers ON questions.answer_id = answers.id"
					+ "LEFT JOIN categories ON questions.category_id = categories.id"
					+ "WHERE questions.difficulty = " + difficulty;
			
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			//	Prepare answers
			ArrayList<String> answers = new ArrayList<String>(); 
			answers.add(resultSet.getString("answers.a"));
			answers.add(resultSet.getString("answers.b"));
			answers.add(resultSet.getString("answers.c"));
			answers.add(resultSet.getString("answers.d"));
			
			//	Prepare category
			Category category = null;
			
			//	Prepare 
			ArrayList<Question> questions = new ArrayList<Question>();

			while (resultSet.next()) {

				Question question = new Question(
					resultSet.getInt("id"),
					resultSet.getString("question"),
					resultSet.getInt("difficulty"),
					answers,
					resultSet.getInt("solution"),
					category
				);
				questions.add((Question) question);
			}
			return questions;
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Question> getByCategory(Category c) {

		try {

			String query = "SELECT questions.*, answers.a, answers.b, answers.c, answers.d, categories.name"
					+ "FROM questions"
					+ "LEFT JOIN answers ON questions.answer_id = answers.id"
					+ "LEFT JOIN categories ON questions.category_id = categories.id"
					+ "WHERE questions.category = " + c;
			
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			//	Prepare answers
			ArrayList<String> answers = new ArrayList<String>(); 
			answers.add(resultSet.getString("answers.a"));
			answers.add(resultSet.getString("answers.b"));
			answers.add(resultSet.getString("answers.c"));
			answers.add(resultSet.getString("answers.d"));
			
			//	Prepare category
			Category category = null;
			
			//	Prepare 
			ArrayList<Question> questions = new ArrayList<Question>();

			while (resultSet.next()) {

				Question question = new Question(
					resultSet.getInt("id"),
					resultSet.getString("question"),
					resultSet.getInt("difficulty"),
					answers,
					resultSet.getInt("solution"),
					category
				);
				questions.add((Question) question);
			}
			return questions;

		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Question> getAllQuestions() {

		try {

			String query = "SELECT questions.*, answers.a, answers.b, answers.c, answers.d, categories.name"
					+ "FROM questions"
					+ "LEFT JOIN answers ON questions.answer_id = answers.id"
					+ "LEFT JOIN categories ON questions.category_id = categories.id";
			
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			//	Prepare answers
			ArrayList<String> answers = new ArrayList<String>(); 
			answers.add(resultSet.getString("answers.a"));
			answers.add(resultSet.getString("answers.b"));
			answers.add(resultSet.getString("answers.c"));
			answers.add(resultSet.getString("answers.d"));
			
			//	Prepare category
			Category category = null;
			
			//	Prepare 
			ArrayList<Question> questions = new ArrayList<Question>();
			
			while (resultSet.next()) {

				Question question = new Question(
					resultSet.getInt("id"),
					resultSet.getString("question"),
					resultSet.getInt("difficulty"),
					answers,
					resultSet.getInt("solution"),
					category
				);
				questions.add((Question) question);
			}
			return questions;
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private int getAnswerIdByAnswers(ArrayList<String> a) {
		
		int id = 0;
		
		try {
			
			String query = "SELECT id FROM answers WHERE a = ?, b = ?, c = ?, d = ? LIMIT 1";
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, a.get(0));
			preparedStatement.setString(2, a.get(1));
			preparedStatement.setString(3, a.get(2));
			preparedStatement.setString(4, a.get(3));
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {

				id = resultSet.getInt("id");
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return id;
	}
	
	private int getCategoryIdByCategory(Category c) {
		
		int id = 0;		
		return id;
	}

	@Override
	public void create(Question q) {

		try {
			
			//	Get answer reference ID
			int answer_id = this.getAnswerIdByAnswers(q.getAnswers());
			
			//	Get category reference ID
			int category_id = this.getCategoryIdByCategory(q.getCategory());
			
			// Insert query
			String query = "INSERT INTO questions (question, difficulty, answer_id, solution, category_id)"
	        		+ " values (?, ?, ?, ?, ?)";
			
			preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, q.getQuestion());
			preparedStatement.setInt(2, q.getDifficulty());
			preparedStatement.setInt(3, answer_id);
			preparedStatement.setInt(4, q.getSolution());
			preparedStatement.setInt(5, category_id);
			preparedStatement.execute();

			resultSet = preparedStatement.getGeneratedKeys();
			int insertedId = 0;

			if (resultSet.next()) {

				insertedId = resultSet.getInt(1);
				q.setID(insertedId);
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(Question q) {

		try {

			//	Get answer reference ID
			int answer_id = this.getAnswerIdByAnswers(q.getAnswers());
			
			//	Get category reference ID
			int category_id = this.getCategoryIdByCategory(q.getCategory());
			
			String query = "UPDATE questions SET " 
					+ "question = ? " 
					+ "difficulty = ? " 
					+ "answer_id = ? " 
					+ "solution = ? " 
					+ "category_id = ? "
					+ "WHERE id = ?";

			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, q.getQuestion());
			preparedStatement.setInt(2, q.getDifficulty());
			preparedStatement.setInt(3, answer_id);
			preparedStatement.setInt(4, q.getSolution());
			preparedStatement.setInt(5, category_id);
			preparedStatement.setInt(5, q.getID());
			preparedStatement.execute();
			preparedStatement.execute();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {

		try {

			String query = "DELETE FROM questions WHERE id = ?";

			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setInt(1, id);
			preparedStmt.execute();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}