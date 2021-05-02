package questions;
package de.vogella.mysql.first;

import java.sql.*;
import java.util.Date;
import java.util.ArrayList;

import com.google.gson.*;

public class QuestionDB implements QuestionStore {

	private ArrayList<Question> questions;
	private dbTable = null;
	Connection conn = null;

	public QuestionDB() {

		this.questions = new ArrayList<Question>();
		initDatabaseConnection();
	}
	
	public QuestionDB(ArrayList<Question> q) {
		
		this.questions = q;
		initDatabaseConnection();
	}

	public void initDatabaseConnection() {

		try (FileInputStream f = new FileInputStream("db.config")) {
		
			// load the properties file
			Properties prop = new Properties();
			prop.load(f);

			// set database table
			this.dbTable = prop.getProperty("dbTable");
		
			// create a connection to the database
			this.conn = DriverManager.getConnection(
				prop.getProperty("url"), 
				prop.getProperty("user"), 
				prop.getProperty("password")
			);
		
		} 
		catch (IOException e) {
		
			System.out.println(e.getMessage());
		} 
	}

	protected void finalize() {  

		try {
		
			if (this.conn != null)
				this.conn.close();
		}
		catch (SQLException ex) {
	
			System.out.println(ex.getMessage());
		}
	} 

	@Override
	public Question getByID(int id) {

		ResultSet result;
		String query = "SELECT * FROM " + this.dbTable + " WHERE Id = " + id + " LIMIT 1";
		Statement statement = this.conn.createStatement(query);
		result = statement.execute();

		while (result.next()) {

			Question question = new Question(
				result.getString("id"),
				result.getString("question"),
				result.getString("difficulty"),
				result.getString("answers"),
				result.getString("solution"),
				result.getString("category"),
			);
			return question;
		}
		return null;
	}

	@Override
	public ArrayList<Question> getByDifficulty(int difficulty) {

		ResultSet result;
		ArrayList<Question> questions = new ArrayList<Question>();
		String query = "SELECT * FROM " + this.dbTable + " WHERE difficulty = " + difficulty;
		Statement statement = this.conn.createStatement(query);
		result = statement.execute();

		while (result.next()) {

			Question question = new Question(
				result.getString("id"),
				result.getString("question"),
				result.getString("difficulty"),
				result.getString("answers"),
				result.getString("solution"),
				result.getString("category"),
			);
			questions.add((Question) question);
		}
		return questions;
	}

	@Override
	public ArrayList<Question> getByCategory(int category) {

		ResultSet result;
		ArrayList<Question> questions = new ArrayList<Question>();
		String query = "SELECT * FROM " + this.dbTable + " WHERE category = " + category;
		Statement statement = this.conn.createStatement(query);
		result = statement.execute();

		while (result.next()) {

			Question question = new Question(
				result.getString("id"),
				result.getString("question"),
				result.getString("difficulty"),
				result.getString("answers"),
				result.getString("solution"),
				result.getString("category"),
			);
			questions.add((Question) question);
		}
		return questions;
	}

	@Override
	public ArrayList<Question> getAllQuestions() {

		ResultSet result;
		ArrayList<Question> questions = new ArrayList<Question>();
		String query = "SELECT * FROM " + this.dbTable;
		Statement statement = this.conn.createStatement(query);
		result = statement.execute();

		while (result.next()) {

			Question question = new Question(
				result.getString("question"),
				result.getString("difficulty"),
				result.getString("answers"),
				result.getString("solution"),
				result.getString("category"),
			);
			questions.add((Question) question);
		}
		return questions;
	}

	@Override
	public void create(Question q) {

		String query = "insert into " + this.dbTable + " (question, difficulty, answers, solution, category)"
        		+ " values (?, ?, ?, ?, ?)";		

		PreparedStatement preparedStat = this.conn.prepareStatement(query);
		preparedStmt.setString(1, q.get(0));
		preparedStmt.setInt(2, q.get(1);
		preparedStmt.setString(3, q.get(2));
		preparedStmt.setInt(4, q.get(3));
		preparedStmt.setInt(5, q.get(4));
		preparedStmt.execute();
	}

	@Override
	public void update(Question q) {

		String query = "update " + this.dbTable + " set " 
				+ "question = ? " 
				+ "difficulty = ? " 
				+ "answers = ? " 
				+ "solution = ? " 
				+ "category = ? "
				+ "where id = ?";
		
		// create the mysql insert preparedstatement
		PreparedStatement preparedStat = this.conn.prepareStatement(query);
		preparedStmt.setString(1, q.get(0));
		preparedStmt.setInt(2, q.get(1);
		preparedStmt.setString(3, q.get(2));
		preparedStmt.setInt(4, q.get(3));
		preparedStmt.setInt(5, q.get(4));
		preparedStmt.execute();
	}

	@Override
	public void delete(int id) {

		String query = "delete from " + this.dbTable + " where id = ?";
		
		// create the mysql insert preparedstatement
		PreparedStatement preparedStat = this.conn.prepareStatement(query);
		preparedStmt.setInt(1, id);
		preparedStmt.execute();
	}
}
