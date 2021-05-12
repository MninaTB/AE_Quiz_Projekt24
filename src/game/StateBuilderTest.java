package game;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import questions.Question;
import questions.Category;

/**
 * Klasse zum testen des Spiels mit der Datenbank
 */
class StateBuilderTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@SuppressWarnings("serial")
	@Test
	final void testNewState() {
		ArrayList<Question> questions = new ArrayList<Question>();
		MockQuestionStoreTest mockDB = new MockQuestionStoreTest(questions);
		StateBuilder sb = new StateBuilder(mockDB);
		try {
			sb.newState(new ArrayList<Category>(), 2, 2);
		} catch (MissingQuestionsException e) {
			assertTrue(true);
		} catch (Exception e) {
			fail(e);
		}
		
		Question q1 = new Question(1, "wer", 1, null, 0, Category.CATEGORY_FUN);
		Question q2 = new Question(2, "wie", 1, null, 0, Category.CATEGORY_FUN);
		Question q3 = new Question(3, "wo", 2, null, 0, Category.CATEGORY_FUN);
		Question q4 = new Question(4, "warum", 3, null, 0, Category.CATEGORY_FUN);
		Question q5 = new Question(5, "was", 4, null, 0, Category.CATEGORY_FUN);
		questions.add(q1);
		questions.add(q2);
		questions.add(q3);
		questions.add(q4);
		questions.add(q5);
        mockDB = new MockQuestionStoreTest(questions);
		sb = new StateBuilder(mockDB);
		State s = null;
		int expect = 1;
		try {
			s = sb.newState(new ArrayList<Category>() {{add(Category.CATEGORY_FUN);}}, 1, expect);
		} catch (Exception e) {
			fail(e);
		}
		int got = 0;
		while(s.next() != null) {
			got++;
		}
		assertEquals(expect, got);
		
		expect = 3;
		try {
			s = sb.newState(new ArrayList<Category>() {{add(Category.CATEGORY_FUN);}}, 1, expect);
		} catch (Exception e) {
			fail(e);
		}
		got = 0;
		while(s.next() != null) {
			got++;
		}
		assertEquals(expect, got);
	}
	
	@SuppressWarnings("serial")
	@Test
	final void testVerify() {
		ArrayList<Question> questions = new ArrayList<Question>();
		MockQuestionStoreTest mockDB = new MockQuestionStoreTest(questions);
		StateBuilder sb = new StateBuilder(mockDB);
		
		assertFalse(sb.verify(new ArrayList<Category>(), 2, 2));
	
		Question q1 = new Question(1, "wer", 1, null, 0, Category.CATEGORY_FUN);
		Question q2 = new Question(2, "wie", 1, null, 0, Category.CATEGORY_FUN);
		Question q3 = new Question(3, "wo", 2, null, 0, Category.CATEGORY_FUN);
		Question q4 = new Question(4, "warum", 3, null, 0, Category.CATEGORY_FUN);
		Question q5 = new Question(5, "was", 4, null, 0, Category.CATEGORY_FUN);
		questions.add(q1);
		questions.add(q2);
		questions.add(q3);
		questions.add(q4);
		questions.add(q5);
        mockDB = new MockQuestionStoreTest(questions);
		sb = new StateBuilder(mockDB);
		int expect = 1;
		
		assertTrue(sb.verify(new ArrayList<Category>() {{add(Category.CATEGORY_FUN);}}, 1, 1));
		
		expect = 3;
		assertTrue(sb.verify(new ArrayList<Category>() {{add(Category.CATEGORY_FUN);}}, 1, expect));
	}	

}
