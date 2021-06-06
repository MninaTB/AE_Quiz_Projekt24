package tools.migration;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import model.Category;
import model.Question;
import questions.QuestionDB;

public class Main {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws org.json.simple.parser.ParseException {

		Connection connection = getDatabaseConnection();

		JSONParser jsonparser = new JSONParser();
		
		try (FileReader reader = new FileReader("questions.json")) {
			
			//	read file
			Object obj = jsonparser.parse(reader);
			JSONArray list = (JSONArray) obj;
			Iterator iterator = list.iterator();
			
			while (iterator.hasNext()) {
				
				JSONObject nextJsonObj = (JSONObject) iterator.next();
				//QuestionDB questionDB = new QuestionDB();
				
				//	get json column values
				String question = (String) nextJsonObj.get("question");
				int difficulty = (int) (long) nextJsonObj.get("difficulty");
				int solution = (int) (long) nextJsonObj.get("solution");
				
				//	get category
				JSONObject category = (JSONObject) nextJsonObj.get("category");
				String categoryName = (String) category.get("text");
				
				//	get answers
				ArrayList<String> listAnswers = new ArrayList<String>();
				JSONArray answers = (JSONArray) nextJsonObj.get("answers");
                Iterator answersIterator = answers.iterator();                
                while (answersIterator.hasNext())
                {    				
                	listAnswers.add((String) answersIterator.next());
                }
				
				QuestionDB questionDB = new QuestionDB(connection);
				
				//	save category in database
				Category Category = new Category(categoryName);				
				
				//	Save category in database
				questionDB.saveCategory(Category);	
				
				//	Save answers in database
				questionDB.saveAnswers(listAnswers);

				//	Save question in database
				questionDB.create(new Question(0, question, difficulty, listAnswers, solution, Category));	
			}
			
			System.out.println("Migration: All questions, answers and categories have been added successfully.");
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static Connection getDatabaseConnection() {
		
		Connection connection = null;
		
		try {  

			String url = "jdbc:mysql://localhost:3306/quiz"; 
			String username = "root"; 
			String password = ""; 

			connection = DriverManager.getConnection(url, username, password); 
		}  
		catch (SQLException ex) {
			
			System.out .println("An error occurred while connecting MySQL databse"); 
			ex.printStackTrace();
		}
		
		return connection;
	}
}
