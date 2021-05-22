/**
 * 
 */
package questions.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import questions.Question;
import questions.QuestionParser;

/**
 * Klasse zum Testen der verschiedenen Methoden
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
				+ "    \"answer_id\": 1,\n"
				+ "    \"solution\": 3,\n"
				+ "    \"category_id\": 1\n"
				+ "  },\n"
				+ "  {\n"
				+ "    \"id\": 2,\n"
				+ "    \"question\": \"wie toll\",\n"
				+ "    \"difficulty\": 3,\n"
				+ "    \"answer_id\": 1,\n"
				+ "    \"solution\": 3,\n"
				+ "    \"category_id\": 1\n"
				+ "  }\n"
				+ "]\n"
				+ "";
    }
    
	/**
	 * Test method for
	 * {@link questions.QuestionParser#load(java.io.InputStreamReader)}.
	 */
	@Test
	final void testLoad() {
		InputStream input = new ByteArrayInputStream(this.text.getBytes());
		QuestionParser q = new QuestionParser();
		try {
			InputStreamReader s = new InputStreamReader(input);
			q.load(s);
		} catch (Exception e) {
			fail(e);
		}
		assertEquals(q.getAllQuestions().size(), 2);
	}
	
	/**
	 * Test method for
	 * {@link questions.QuestionParser#save(java.io.OutputStreamWriter)}.
	 * @throws  
	 */
	@Test
	final void testSave() {
		ArrayList<Question> questions = new ArrayList<Question>();
		questions.add(new Question(1, "wie alt", 5, 1, 3, 1));
		questions.add(new Question(2, "wie toll", 3, 1, 3, 1));
		QuestionParser q = new QuestionParser(questions);
        OutputStream buf = new ByteArrayOutputStream();
        OutputStreamWriter w = new OutputStreamWriter(buf);
		q.save(w);
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
	 * Test method for {@link questions.QuestionParser#getAllQuestions()}.
	 */
	@SuppressWarnings("serial")
	@Test
	final void testGetAllQuestions() {
		ArrayList<Question> questions = new ArrayList<Question>();
		ArrayList<String> aw = new ArrayList<String>() {{ add("a1"); add("a2"); add("a3"); add("a4"); }};
		questions.add(new Question(1, "wie", 100, 1, 2, 1));
		questions.add(new Question(2, "wo", 100, 1, 2, 1));
		questions.add(new Question(3, "was", 100, 1, 2, 1));
		QuestionParser q = new QuestionParser(questions);
		ArrayList<Question> nq = q.getAllQuestions();
		
		assertEquals(questions,nq);
	}

	/**
	 * Test method for {@link questions.QuestionParser#getByID(int)}.
	 */
	@Test
	final void testGetQuestionByID() {
		ArrayList<Question> questions = new ArrayList<Question>();
		Question question = new Question(2, "wo", 100, 1, 2, 1);
		questions.add(new Question(1, "wie", 100, 1, 2, 1));
		questions.add(question);
		questions.add(new Question(3, "was", 100, 1, 2, 1));
		QuestionParser q = new QuestionParser(questions);
		
		assertEquals(question,q.getByID(question.getID()));
	}

	/**
	 * Test method for
	 * {@link questions.QuestionParser#getByDifficulty(int)}.
	 */
	@Test
	final void testGetQuestionsByDifficulty() {
		final int targetDifficulty = 200;
		ArrayList<Question> questions = new ArrayList<Question>();
		Question question = new Question(2, "wo", targetDifficulty, 1, 2, 1);
		questions.add(new Question(1, "wie", 100, 1, 2, 1));
		questions.add(question);
		questions.add(new Question(3, "was", 100, 1, 2, 1));
		QuestionParser q = new QuestionParser(questions);
		
		Question queried = q.getByDifficulty(targetDifficulty).get(0);
		assertEquals(question.getID(), queried.getID());
		assertEquals(question.getQuestion(), queried.getQuestion());
		assertEquals(question.getDifficulty(), queried.getDifficulty());
		assertEquals(question.getSolution(), queried.getSolution());
		assertEquals(question.getCategoryId(), queried.getCategoryId());
	}

	/**
	 * Test method for
	 * {@link questions.QuestionParser#getByCategory(questions.Category)}.
	 */
	@Test
	final void testGetQuestionsByCategory() {
		final int targetCategory = 1;
		ArrayList<Question> questions = new ArrayList<Question>();
		Question question = new Question(1, "wie", 100, 1, 2, 1);
		questions.add(new Question(1, "wie", 100, 1, 2, 1));
		questions.add(question);
		questions.add(new Question(3, "was", 100, 1, 2, 1));
		QuestionParser q = new QuestionParser(questions);
		
		Question queried = q.getByCategory(targetCategory).get(0);
		assertEquals(question.getID(), queried.getID());
		assertEquals(question.getQuestion(), queried.getQuestion());
		assertEquals(question.getDifficulty(), queried.getDifficulty());
		assertEquals(question.getSolution(), queried.getSolution());
		assertEquals(question.getCategoryId(), queried.getCategoryId());
	}

	/**
	 * Test method for
	 * {@link questions.QuestionParser#create(questions.Question)}.
	 */
	@Test
	final void testCreateQuestion() {
		Question q1 = new Question(1, "wo", 100, 1, 2, 1);
		Question q2 = new Question(2, "wer", 100, 1, 2, 1);
		QuestionParser q = new QuestionParser();
		q.create(q1);
		q.create(q2);
		assertEquals(q.getAllQuestions().size(), 2);
	}

	/**
	 * Test method for {@link questions.QuestionParser#delete(int)}.
	 */
	@Test
	final void testDeleteQuestion() {
		final int targetID = 1;
		ArrayList<Question> questions = new ArrayList<Question>();
		questions.add(new Question(targetID, "wie", 100, 1, 2, 1));
		questions.add(new Question(2, "was", 100, 1, 2, 1));
		QuestionParser q = new QuestionParser(questions);
		q.delete(targetID);
		assertEquals(q.getAllQuestions().size(), 1);
	}
}
