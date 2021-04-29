/**
 * 
 */
package questions;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author nina
 *
 */
class QuestionParserTest {

	String text;
	
	@BeforeEach
	void setUp() throws Exception {
    	this.text = "[\n"
				+ "  {\n"
				+ "    \"id\": 1,\n"
				+ "    \"question\": \"wie alt\",\n"
				+ "    \"difficulty\": 5,\n"
				+ "    \"answers\": [\n"
				+ "      \"a1\",\n"
				+ "      \"a2\",\n"
				+ "      \"a3\",\n"
				+ "      \"a4\"\n"
				+ "    ],\n"
				+ "    \"solution\": 3,\n"
				+ "    \"category\": \"CATEGORY_FUN\"\n"
				+ "  },\n"
				+ "  {\n"
				+ "    \"id\": 2,\n"
				+ "    \"question\": \"wie toll\",\n"
				+ "    \"difficulty\": 3,\n"
				+ "    \"answers\": [\n"
				+ "      \"a1\",\n"
				+ "      \"a2\",\n"
				+ "      \"a3\",\n"
				+ "      \"a4\"\n"
				+ "    ],\n"
				+ "    \"solution\": 3,\n"
				+ "    \"category\": \"CATEGORY_FUN\"\n"
				+ "  }\n"
				+ "]\n"
				+ "";
    }
    
	/**
	 * Test method for
	 * {@link questions.QuestionParser#Load(java.io.InputStreamReader)}.
	 */
	@Test
	final void testLoad() {
		InputStream input = new ByteArrayInputStream(this.text.getBytes());
		QuestionParser q = new QuestionParser();
		try {
			InputStreamReader s = new InputStreamReader(input);
			q.Load(s);
		} catch (Exception e) {
			fail(e);
		}
		assertEquals(q.GetAllQuestions().size(), 2);
	}
	
	/**
	 * Test method for
	 * {@link questions.QuestionParser#Save(java.io.OutputStreamWriter)}.
	 * @throws  
	 */
	@SuppressWarnings("serial")
	@Test
	final void testSave() {
		ArrayList<Question> questions = new ArrayList<Question>();
		ArrayList<String> aw = new ArrayList<String>() {{ add("a1"); add("a2"); add("a3"); add("a4"); }};
		questions.add(new Question(1, "wie alt", 5, aw, 3, Category.CATEGORY_FUN));
		questions.add(new Question(2, "wie toll", 3, aw, 3, Category.CATEGORY_FUN));
		QuestionParser q = new QuestionParser(questions);
        OutputStream buf = new ByteArrayOutputStream();
        OutputStreamWriter w = new OutputStreamWriter(buf);
		q.Save(w);
		try {
			w.flush();
			buf.flush();
		} catch (IOException e) {
			fail("could not flush data");
		}
		// NOTE: remove all whitespaces and non-visible characters (e.g., tab, \n).
		assertEquals(this.text.replaceAll("\\s+",""), buf.toString().replaceAll("\\s+",""));
	}

	/**
	 * Test method for {@link questions.QuestionParser#GetAllQuestions()}.
	 */
	@SuppressWarnings("serial")
	@Test
	final void testGetAllQuestions() {
		ArrayList<Question> questions = new ArrayList<Question>();
		ArrayList<String> aw = new ArrayList<String>() {{ add("a1"); add("a2"); add("a3"); add("a4"); }};
		questions.add(new Question(1, "wie", 100, aw, 2, Category.CATEGORY_FUN));
		questions.add(new Question(2, "wo", 100, aw, 2, Category.CATEGORY_FUN));
		questions.add(new Question(3, "was", 100, aw, 2, Category.CATEGORY_FUN));
		QuestionParser q = new QuestionParser(questions);
		ArrayList<Question> nq = q.GetAllQuestions();
		
		assertEquals(questions,nq);
	}

	/**
	 * Test method for {@link questions.QuestionParser#GetQuestionByID(int)}.
	 */
	@SuppressWarnings("serial")
	@Test
	final void testGetQuestionByID() {
		ArrayList<Question> questions = new ArrayList<Question>();
		ArrayList<String> aw = new ArrayList<String>() {{ add("a1"); add("a2"); add("a3"); add("a4"); }};
		Question question = new Question(2, "wo", 100, aw, 2, Category.CATEGORY_FUN);
		questions.add(new Question(1, "wie", 100, aw, 2, Category.CATEGORY_FUN));
		questions.add(question);
		questions.add(new Question(3, "was", 100, aw, 2, Category.CATEGORY_FUN));
		QuestionParser q = new QuestionParser(questions);
		
		assertEquals(question,q.GetQuestionByID(question.GetID()));
	}

	/**
	 * Test method for
	 * {@link questions.QuestionParser#GetQuestionByDifficulty(int)}.
	 */
	@SuppressWarnings("serial")
	@Test
	final void testGetQuestionByDifficulty() {
		final int targetDifficulty = 200;
		ArrayList<Question> questions = new ArrayList<Question>();
		ArrayList<String> aw = new ArrayList<String>() {{ add("a1"); add("a2"); add("a3"); add("a4"); }};
		Question question = new Question(2, "wo", targetDifficulty, aw, 2, Category.CATEGORY_FUN);
		questions.add(new Question(1, "wie", 100, aw, 2, Category.CATEGORY_FUN));
		questions.add(question);
		questions.add(new Question(3, "was", 100, aw, 2, Category.CATEGORY_FUN));
		QuestionParser q = new QuestionParser(questions);
		
		Question queried = q.GetQuestionByDifficulty(targetDifficulty).get(0);
		assertEquals(question.GetID(), queried.GetID());
		assertEquals(question.GetQuestion(), queried.GetQuestion());
		assertEquals(question.GetDifficulty(), queried.GetDifficulty());
		assertEquals(question.GetSolution(), queried.GetSolution());
		assertEquals(question.GetCategory(), queried.GetCategory());
	}

	/**
	 * Test method for
	 * {@link questions.QuestionParser#GetQuestionsByCategory(questions.Category)}.
	 */
	@SuppressWarnings("serial")
	@Test
	final void testGetQuestionsByCategory() {
		final Category targetCategory = Category.CATEGORY_FUN;
		ArrayList<Question> questions = new ArrayList<Question>();
		ArrayList<String> aw = new ArrayList<String>() {{ add("a1"); add("a2"); add("a3"); add("a4"); }};
		Question question = new Question(2, "wo", 100, aw, 2, Category.CATEGORY_FUN);
		questions.add(new Question(1, "wie", 100, aw, 2, Category.CATEGORY_UNKNOWN));
		questions.add(question);
		questions.add(new Question(3, "was", 100, aw, 2, Category.CATEGORY_UNKNOWN));
		QuestionParser q = new QuestionParser(questions);
		
		Question queried = q.GetQuestionsByCategory(targetCategory).get(0);
		assertEquals(question.GetID(), queried.GetID());
		assertEquals(question.GetQuestion(), queried.GetQuestion());
		assertEquals(question.GetDifficulty(), queried.GetDifficulty());
		assertEquals(question.GetSolution(), queried.GetSolution());
		assertEquals(question.GetCategory(), queried.GetCategory());
	}

	/**
	 * Test method for
	 * {@link questions.QuestionParser#CreateQuestion(questions.Question)}.
	 */
	@SuppressWarnings("serial")
	@Test
	final void testCreateQuestion() {
		ArrayList<String> aw = new ArrayList<String>() {{ add("a1"); add("a2"); add("a3"); add("a4"); }};
		Question q1 = new Question(1, "wo", 100, aw, 2, Category.CATEGORY_FUN);
		Question q2 = new Question(2, "wer", 100, aw, 2, Category.CATEGORY_FUN);
		QuestionParser q = new QuestionParser();
		q.CreateQuestion(q1);
		q.CreateQuestion(q2);
		assertEquals(q.GetAllQuestions().size(), 2);
	}

	/**
	 * Test method for {@link questions.QuestionParser#DeleteQuestion(int)}.
	 */
	@SuppressWarnings("serial")
	@Test
	final void testDeleteQuestion() {
		final int targetID = 1;
		ArrayList<Question> questions = new ArrayList<Question>();
		ArrayList<String> aw = new ArrayList<String>() {{ add("a1"); add("a2"); add("a3"); add("a4"); }};
		questions.add(new Question(targetID, "wie", 100, aw, 2, Category.CATEGORY_FUN));
		questions.add(new Question(2, "was", 100, aw, 2, Category.CATEGORY_FUN));
		QuestionParser q = new QuestionParser(questions);
		q.DeleteQuestion(targetID);
		assertEquals(q.GetAllQuestions().size(), 1);
	}
}
