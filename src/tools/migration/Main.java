package tools.migration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import model.Category;
import model.Question;
import questions.QuestionDB;
import questions.QuestionParser;

public class Main {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {

		Connection connection = getDatabaseConnection();
		String filename = "questions.json";
		File file = new File(filename);

		try {

			InputStreamReader sr = new InputStreamReader(new FileInputStream(file));
			QuestionParser q = new QuestionParser();
			q.load(sr);

			ArrayList<Question> questions = q.getAllQuestions();
			Iterator iterator = questions.iterator();
			while (iterator.hasNext()) {

				Question nextQuestionObj = (Question) iterator.next();

				// get json column values
				Category category = nextQuestionObj.getCategory();
				String categoryName = category.toString();
				ArrayList<String> answers = nextQuestionObj.getAnswers();

				QuestionDB questionDB = new QuestionDB(connection);

				// save category in database
				Category Category = new Category(categoryName);

				// Save category in database
				questionDB.saveCategory(Category);

				// Save answers in database
				questionDB.saveAnswers(answers);

				// Save question in database
				questionDB.create(nextQuestionObj);
			}
			System.out.println("Migration: All questions, answers and categories have been added successfully.");
		} catch (FileNotFoundException e) {

			System.out.printf("could not load: %s\n", filename);
		}
	}

	private static Connection getDatabaseConnection() {

		Connection connection = null;

		try {

			String url = "jdbc:mysql://localhost:3306/quiz";
			String username = "root";
			String password = "";

			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException ex) {

			System.out.println("An error occurred while connecting MySQL databse");
			ex.printStackTrace();
		}

		return connection;
	}
}
