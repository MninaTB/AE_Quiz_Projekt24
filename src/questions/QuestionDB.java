/**
 * @author Rogér
 */

package questions;

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
	
	/*
	public Statement getStatement() {
		return statement;
	}
	
	public void setStatement(Statement statement) {
		this.statement = statement;
	}
	
	public PreparedStatement getPreparedStatement() {
		return preparedStatement;
	}
	
	public void setPreparedStatement(PreparedStatement preparedStatement) {
		this.preparedStatement = preparedStatement;
	}
	
	public ResultSet getResultSet() {
		return resultSet;
	}
	
	public void setResultSet(ResultSet resultSet) {
		this.resultSet = resultSet;
	}*/

	
	@Override
	public Question getByID(int id) {

		try {

			String query = "SELECT * FROM questions WHERE Id = " + id + " LIMIT 1";
			preparedStatement = connection.prepareStatement(query);			
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {

				Question question = new Question(
					resultSet.getInt("id"),
					resultSet.getString("question"),
					resultSet.getInt("difficulty"),
					resultSet.getInt("answer_id"),
					resultSet.getInt("solution"),
					resultSet.getInt("category_id")
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
			
			ArrayList<Question> questions = new ArrayList<Question>();
			
			String query = "SELECT * FROM questions WHERE difficulty = " + difficulty;
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				Question question = new Question(
					resultSet.getInt("id"),
					resultSet.getString("question"),
					resultSet.getInt("difficulty"),
					resultSet.getInt("answer_id"),
					resultSet.getInt("solution"),
					resultSet.getInt("category_id")
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
	public ArrayList<Question> getByCategory(int c) {

		try {

			ArrayList<Question> questions = new ArrayList<Question>();
			String query = "SELECT * FROM questions WHERE category_id = " + c;
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				Question question = new Question(
					resultSet.getInt("id"),
					resultSet.getString("question"),
					resultSet.getInt("difficulty"),
					resultSet.getInt("answer_id"),
					resultSet.getInt("solution"),
					resultSet.getInt("category_id")
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

			ArrayList<Question> questions = new ArrayList<Question>();
			String query = "SELECT * FROM questions";
			preparedStatement = connection.prepareStatement(query);			
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {

				Question question = new Question(
					resultSet.getInt("id"),
					resultSet.getString("question"),
					resultSet.getInt("difficulty"),
					resultSet.getInt("answer_id"),
					resultSet.getInt("solution"),
					resultSet.getInt("category_id")
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
	public void create(Question q) {

		try {
			
			// Insert query
			String query = "INSERT INTO questions (question, difficulty, answer_id, solution, category_id)"
	        		+ " values (?, ?, ?, ?, ?)";
			
			preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, q.getQuestion());
			preparedStatement.setInt(2, q.getDifficulty());
			preparedStatement.setInt(3, q.getAnswerId());
			preparedStatement.setInt(4, q.getSolution());
			preparedStatement.setInt(5, q.getCategoryId());
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
			preparedStatement.setInt(3, q.getAnswerId());
			preparedStatement.setInt(4, q.getSolution());
			preparedStatement.setInt(5, q.getCategoryId());
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