package game;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import questions.Category;
import questions.Question;

/**
 * Klasse zum testen des Spiels
 */
class StateTest {

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

	@Test
	final void testNext() {
		State s = new State(new ArrayList<Question>(), 0);
		assertNull(s.next());
		
		ArrayList<Question> questions = new ArrayList<Question>();
		Question q1 = new Question(1, "wer", 2, 2, 0, 1);
		Question q2 = new Question(2, "wie", 2, 2, 0, 1);
		questions.add(q1);
		questions.add(q2);
		s = new State(questions, 0);
		assertEquals(q1, s.next());
		assertEquals(q2, s.next());
		assertEquals(null, s.next());
	}

	@Test
	final void testGetLevel() {
		ArrayList<Question> questions = new ArrayList<Question>();
		Question q1 = new Question(1, "wer", 2, 2, 0, 1);
		Question q2 = new Question(2, "wie", 2, 2, 0, 1);
		Question q3 = new Question(3, "wo", 2, 2, 0, 1);
		Question q4 = new Question(4, "warum", 2, 2, 0, 1);
		questions.add(q1);
		questions.add(q2);
		questions.add(q3);
		questions.add(q4);
		State s = new State(questions, 2);
		assertEquals(1, s.getLevel());
		
		s.next();
		s.next();
		assertEquals(2, s.getLevel());
	}

}
