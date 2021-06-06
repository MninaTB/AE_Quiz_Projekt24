package questions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import model.Category;
import model.Question;

@ExtendWith(MockitoExtension.class)
public class QuestionDBTest {
	  
	@Mock Connection connectionMock;
	@Mock PreparedStatement preparedStatementMock;
	@Mock ResultSet resultSetMock;
	
	QuestionDB QuestionDBMock;
	
	static ArrayList<String> answers = new ArrayList<String>(); 		
	static Category category1 = new Category("Test Category");
	static Category category2 = new Category("Test Category 2");
	
	@BeforeAll
	public static void setUpBeforeAll() throws SQLException {

		//	Create questions list for assertion
		answers.add("Test 1");
		answers.add("Test 2");
		answers.add("Test 3");
		answers.add("Test 4");
	}
	
	@BeforeEach
	public void setUpBeforeEach() throws SQLException {

		assertNotNull(connectionMock);
		assertNotNull(preparedStatementMock);
		
		QuestionDBMock  = new QuestionDB(connectionMock); 
	}
	
	@Test
	public void testGetByID() throws SQLException {
		
		String query = "SELECT questions.*, answers.a, answers.b, answers.c, answers.d, categories.name"
				+ " FROM questions"
				+ " LEFT JOIN answers ON questions.answer_id = answers.id"
				+ " LEFT JOIN categories ON questions.category_id = categories.id"
				+ " WHERE questions.id = ?";		

		//	----- Prepare mockery
		Mockito.when(connectionMock.prepareStatement(query)).thenReturn(preparedStatementMock);	
		Mockito.when(preparedStatementMock.executeQuery()).thenReturn(resultSetMock);
		Mockito.when(resultSetMock.next()).thenReturn(false).thenReturn(true);	
		Mockito.when(resultSetMock.getString("answers.a")).thenReturn("Test 1");
		Mockito.when(resultSetMock.getString("answers.b")).thenReturn("Test 2");
		Mockito.when(resultSetMock.getString("answers.c")).thenReturn("Test 3");
		Mockito.when(resultSetMock.getString("answers.d")).thenReturn("Test 4");
		Mockito.when(resultSetMock.getString("categories.name")).thenReturn("Test Category");
		
		Mockito.when(resultSetMock.getInt("id")).thenReturn(1);
		Mockito.when(resultSetMock.getString("question")).thenReturn("Test Frage");
		Mockito.when(resultSetMock.getInt("difficulty")).thenReturn(2);
		Mockito.when(resultSetMock.getInt("solution")).thenReturn(3);
		
		//	----- Run Tests
		// 	Test 1: Null
		assertNull(QuestionDBMock.getByID(1));
		
		//	Test 2: Not null - Don't equals	
		Question question = new Question(2,	"Test Frage", 2, answers, 3, category1);
		
		assertNotNull(QuestionDBMock.getByID(1));
		assertNotEquals(QuestionDBMock.getByID(1).getID(), question.getID());
		
		//	Test 2: Not null - Equals	
		question.setID(1);		
		assertNotNull(QuestionDBMock.getByID(1));
		assertEquals(question.getID(), QuestionDBMock.getByID(1).getID());
	}
	
	@Test
	public void testGetByDifficulty() throws SQLException {
		
		String query = "SELECT questions.*, answers.a, answers.b, answers.c, answers.d, categories.name"
				+ " FROM questions"
				+ " LEFT JOIN answers ON questions.answer_id = answers.id"
				+ " LEFT JOIN categories ON questions.category_id = categories.id"
				+ " WHERE questions.difficulty = ?";
	
		//	----- Prepare mockery
		Mockito.when(connectionMock.prepareStatement(query)).thenReturn(preparedStatementMock);	
		Mockito.when(preparedStatementMock.executeQuery()).thenReturn(resultSetMock);
		
		Mockito.when(resultSetMock.getString("answers.a")).thenReturn("Test 1");
		Mockito.when(resultSetMock.getString("answers.b")).thenReturn("Test 2");
		Mockito.when(resultSetMock.getString("answers.c")).thenReturn("Test 3");
		Mockito.when(resultSetMock.getString("answers.d")).thenReturn("Test 4");
		Mockito.when(resultSetMock.getString("categories.name")).thenReturn("Test Category");
		Mockito.when(resultSetMock.next())
			.thenReturn(false)
			.thenReturn(true).thenReturn(true).thenReturn(false)
			.thenReturn(true).thenReturn(true).thenReturn(false);
		Mockito.when(resultSetMock.getInt("id")).thenReturn(1).thenReturn(1).thenReturn(1).thenReturn(4);
		Mockito.when(resultSetMock.getString("question")).thenReturn("Test Frage");
		Mockito.when(resultSetMock.getInt("difficulty")).thenReturn(2);
		Mockito.when(resultSetMock.getInt("solution")).thenReturn(3);	
		
		//	----- Run Tests
		// 	Test 1: Empty array
		assertEquals(new ArrayList<Question>(), QuestionDBMock.getByDifficulty(2));
		
		//	Test 2: Not empty	
		assertNotEquals(new ArrayList<Question>(), QuestionDBMock.getByDifficulty(2));	

		ArrayList<Question> questions = new ArrayList<Question>();
		questions.add(new Question(1, "Test Frage #1", 2, answers, 1, category1));
		questions.add(new Question(2, "Test Frage #2", 2, answers, 2, category1));
		ArrayList<Question> arrayList = QuestionDBMock.getByDifficulty(2);
		assertEquals(questions.size(), arrayList.size());
		assertEquals(questions.get(0).getID(), arrayList.get(0).getID());
		assertNotEquals(questions.get(1).getID(), arrayList.get(1).getID());
	} 
	
	@Test
	public void testGetByCategory() throws SQLException {
		
		String query = "SELECT questions.*, answers.a, answers.b, answers.c, answers.d, categories.name"
				+ " FROM questions"
				+ " LEFT JOIN answers ON questions.answer_id = answers.id"
				+ " LEFT JOIN categories ON questions.category_id = categories.id"
				+ " WHERE questions.category_id = ?";
		String query2 = "SELECT id FROM categories WHERE name = ? LIMIT 1";

		//	----- Prepare mockery
		Mockito.when(connectionMock.prepareStatement(query)).thenReturn(preparedStatementMock);
		Mockito.when(connectionMock.prepareStatement(query2)).thenReturn(preparedStatementMock);	
		Mockito.when(preparedStatementMock.executeQuery()).thenReturn(resultSetMock);
		
		Mockito.when(resultSetMock.getString("answers.a")).thenReturn("Test 1");
		Mockito.when(resultSetMock.getString("answers.b")).thenReturn("Test 2");
		Mockito.when(resultSetMock.getString("answers.c")).thenReturn("Test 3");
		Mockito.when(resultSetMock.getString("answers.d")).thenReturn("Test 4");
		Mockito.when(resultSetMock.next())
			.thenReturn(false).thenReturn(false)
			.thenReturn(true).thenReturn(false).thenReturn(true).thenReturn(false)
			.thenReturn(true).thenReturn(false).thenReturn(true).thenReturn(true).thenReturn(false);
		Mockito.when(resultSetMock.getInt("id"))
			.thenReturn(1)
			.thenReturn(1)
			.thenReturn(1)
			.thenReturn(1)
			.thenReturn(4);
		Mockito.when(resultSetMock.getString("question")).thenReturn("Test Frage");
		Mockito.when(resultSetMock.getInt("difficulty")).thenReturn(2);
		Mockito.when(resultSetMock.getInt("solution")).thenReturn(3);	
		
		//	----- Run Tests
		// 	Test 1: Empty array
		assertEquals(new ArrayList<Question>(), QuestionDBMock.getByCategory(category1));
		
		//	Test 2: Not empty	
		assertNotEquals(new ArrayList<Question>(), QuestionDBMock.getByCategory(category1));

		ArrayList<Question> questions = new ArrayList<Question>();
		questions.add(new Question(1, "Test Frage #1", 2, answers, 1, category1));
		questions.add(new Question(2, "Test Frage #2", 2, answers, 2, category1));
		ArrayList<Question> arrayList = QuestionDBMock.getByCategory(category1);
		assertEquals(questions.size(), arrayList.size());
		assertEquals(questions.get(0).getID(), arrayList.get(0).getID());
		assertNotEquals(questions.get(1).getID(), arrayList.get(1).getID());
	} 
	
	@Test
	public void testGetAllQuestions() throws SQLException {
		
		String query = "SELECT questions.*, answers.a, answers.b, answers.c, answers.d, categories.name"
				+ " FROM questions"
				+ " LEFT JOIN answers ON questions.answer_id = answers.id"
				+ " LEFT JOIN categories ON questions.category_id = categories.id";	
	
		//	----- Prepare mockery
		Mockito.when(connectionMock.prepareStatement(query)).thenReturn(preparedStatementMock);	
		Mockito.when(preparedStatementMock.executeQuery()).thenReturn(resultSetMock);
		Mockito.when(resultSetMock.getString("answers.a")).thenReturn("Test 1");
		Mockito.when(resultSetMock.getString("answers.b")).thenReturn("Test 2");
		Mockito.when(resultSetMock.getString("answers.c")).thenReturn("Test 3");
		Mockito.when(resultSetMock.getString("answers.d")).thenReturn("Test 4");
		Mockito.when(resultSetMock.getString("categories.name")).thenReturn("Test Category");
		Mockito.when(resultSetMock.next()).thenReturn(false).thenReturn(true).thenReturn(true).thenReturn(true).thenReturn(false);
		Mockito.when(resultSetMock.getInt("id")).thenReturn(1);
		Mockito.when(resultSetMock.getString("question")).thenReturn("Test Frage");
		Mockito.when(resultSetMock.getInt("difficulty")).thenReturn(2);
		Mockito.when(resultSetMock.getInt("solution")).thenReturn(3);
		
		//	----- Run Tests
		// 	Test 1: Empty array
		assertEquals(new ArrayList<Question>(), QuestionDBMock.getAllQuestions());
		
		//	Test 2: Not null - Don't equals	
		//	Id, Question, Difficulty, Answers, Solution, Category
		ArrayList<Question> questions = new ArrayList<Question>();
		questions.add(new Question(1, "Test Frage #1", 2, answers, 1, category1));
		questions.add(new Question(2, "Test Frage #2", 3, answers, 2, category1));
		questions.add(new Question(3, "Test Frage #3", 4, answers, 3, category2));
		assertEquals(questions.size(), QuestionDBMock.getAllQuestions().size());
	} 
}