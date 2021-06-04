package questions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.when; 

import model.Category;
import model.Question;
 
public class QuestionDBTest {
 
	@InjectMocks 
	private QuestionDB mockQuestionDB;
	  
	@Mock 
	private Connection mockConnection;
	private Statement mockStatement;
	private PreparedStatement mockPreparedStatement;
	private ResultSet resultSet;
	
	@BeforeEach
	public void setUp() throws SQLException {
	}
	
	@Test
	public void testGetAllQuestions() throws SQLException {
	
		ResultSet resultSet = Mockito.mock(ResultSet.class);
		Mockito.when(resultSet.next()).thenReturn(true);

		PreparedStatement mockPreparedStatement = Mockito.mock(PreparedStatement.class);
		Mockito.when(mockPreparedStatement.executeQuery()).thenReturn(resultSet);

		Connection mockConnection = Mockito.mock(Connection.class);
		Mockito.when(mockConnection.prepareStatement("SELECT questions.*, answers.a, answers.b, answers.c, answers.d, categories.name"
				+ "FROM questions"
				+ "LEFT JOIN answers ON questions.answer_id = answers.id"
				+ "LEFT JOIN categories ON questions.category_id = categories.id")).thenReturn(mockPreparedStatement);
		
		QuestionDB mockQuestionDB = Mockito.mock(QuestionDB.class);
		Mockito.when(mockQuestionDB.getAllQuestions()).thenReturn(new ArrayList<Question>());

		
	    assertEquals(mockQuestionDB.getAllQuestions(), new ArrayList<Question>());	
	} 
}