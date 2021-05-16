/**
 * @author Rogér
 */

package questions;
package de.vogella.mysql.first;

import java.sql.*;
import java.util.Date;
import java.util.ArrayList;

import com.google.gson.*;

public class QuestionDB implements QuestionStore {

	private String dbTable = null;
	Connection conn = null;
/*
	public QuestionDB() {

		// create a connection to the database
		this.conn = DriverManager.getConnection(
			"jdbc:odbc:mysql",
			"root",
			""
		);
	}

	protected void finalize() {  

		try {
		
			if (this.conn != null)
				this.conn.close();
		}
		catch (SQLException ex) {
	
			System.out.println(ex.getMessage());
		}
	} */

	@Override
	public Question getByID(int id) {

		ResultSet result;
		String query = "SELECT * FROM " + this.dbTable + " WHERE Id = " + id + " LIMIT 1";
		PreparedStatement preparedStmt = this.conn.prepareStatement(query);
		preparedStmt.execute();
		
		// Temp
		ArrayList<String> aw = new ArrayList<String>();
		Category category = null;

		while (result.next()) {

			Question question = new Question(
				result.getInt("id"),
				result.getString("question"),
				result.getInt("difficulty"),
				aw,
				result.getInt("solution"),
				category
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
		PreparedStatement preparedStmt = this.conn.prepareStatement(query);
		preparedStmt.execute();
		
		// Temp
		ArrayList<String> aw = new ArrayList<String>();
		Category category = null;

		while (result.next()) {

			Question question = new Question(
				result.getInt("id"),
				result.getString("question"),
				result.getInt("difficulty"),
				aw,
				result.getInt("solution"),
				category
			);
			questions.add((Question) question);
		}
		return questions;
	}

	@Override
	public ArrayList<Question> getByCategory(Category c) {

		ResultSet result;
		ArrayList<Question> questions = new ArrayList<Question>();
		String query = "SELECT * FROM " + this.dbTable + " WHERE category = " + category;
		PreparedStatement preparedStmt = this.conn.prepareStatement(query);
		preparedStmt.execute();
		
		// Temp
		ArrayList<String> aw = new ArrayList<String>();
		Category category = null;

		while (result.next()) {

			Question question = new Question(
				result.getInt("id"),
				result.getString("question"),
				result.getInt("difficulty"),
				aw,
				result.getInt("solution"),
				category
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
		PreparedStatement preparedStmt = this.conn.prepareStatement(query);
		preparedStmt.execute();
		
		// Temp
		ArrayList<String> aw = new ArrayList<String>();
		Category category = null;

		while (result.next()) {

			Question question = new Question(
				result.getInt("id"),
				result.getString("question"),
				result.getInt("difficulty"),
				aw,
				result.getInt("solution"),
				category
			);
			questions.add((Question) question);
		}
		return questions;
	}

	@Override
	public void create(Question q) {
		
		// Fragen mit answer Tabelle abgleichen
		
		// ID rausziehen
		int category_id = 0;
		
		// Fragen mit category Tabelle abgleichen
		
		// ID rausziehen
		int answer_id = 0;
		
		// Insert query bauen
		String query = "INSERT INTO " + this.dbTable + " (question, difficulty, answer_id, solution, category_id)"
        		+ " values (?, ?, ?, ?, ?)";
		
		// create the mysql insert preparedstatement
		PreparedStatement preparedStmt = this.conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		preparedStmt.setString(1, q.getQuestion());
		preparedStmt.setInt(2, q.getDifficulty());
		preparedStmt.setInt(3, answer_id);
		preparedStmt.setInt(4, q.getSolution());
		preparedStmt.setInt(5, category_id);
		preparedStmt.execute();

		ResultSet result = preparedStmt.getGeneratedKeys();
		int insertedId = 0;

		if (result.next()) {

			insertedId = result.getInt(1);
			q.setID(insertedId);
		}
	}

	@Override
	public void update(Question q) {
		
		// Fragen mit answer Tabelle abgleichen
		
		// ID rausziehen
		int category_id = 0;
		
		// Fragen mit category Tabelle abgleichen
		
		// ID rausziehen
		int answer_id = 0;

		String query = "UPDATE " + this.dbTable + " SET " 
				+ "question = ? " 
				+ "difficulty = ? " 
				+ "answer_id = ? " 
				+ "solution = ? " 
				+ "category_id = ? "
				+ "WHERE id = ?";
		
		// create the mysql update preparedstatement
		PreparedStatement preparedStmt = this.conn.prepareStatement(query);
		preparedStmt.setString(1, q.getQuestion());
		preparedStmt.setInt(2, q.getDifficulty());
		preparedStmt.setInt(3, answer_id);
		preparedStmt.setInt(4, q.getSolution());
		preparedStmt.setInt(5, category_id);
		preparedStmt.setInt(5, q.getID());
		preparedStmt.execute();
		preparedStmt.execute();
	}

	@Override
	public void delete(int id) {

		String query = "DELETE FROM " + this.dbTable + " WHERE id = ?";
		
		// create the mysql delete preparedstatement
		PreparedStatement preparedStmt = this.conn.prepareStatement(query);
		preparedStmt.setInt(1, id);
		preparedStmt.execute();
	}
}