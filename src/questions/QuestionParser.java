package questions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;

import com.google.gson.*;

public class QuestionParser implements QuestionStore {

	private ArrayList<Question> questions;

	public QuestionParser() {
		this.questions = new ArrayList<Question>();
	}
	
	public QuestionParser(ArrayList<Question> q) {
		this.questions = q;
	}

	public void Load(InputStreamReader sr) {
		Gson gson = new Gson();
		String json = new BufferedReader(sr)
				   .lines().collect(Collectors.joining("\n"));
		@SuppressWarnings("unchecked")
		ArrayList<Question> questions = gson.fromJson(json, this.questions.getClass());
		this.questions = questions;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Question> GetAllQuestions() {
		return (ArrayList<Question>) this.questions.clone();
	}

	@Override
	public Question GetQuestionByID(int id) {
		for (Question q : this.questions) {
			if (q.GetID() == id) {
				return q;
			}
		}
		return null;
	}

	@Override
	public ArrayList<Question> GetQuestionByDifficulty(int difficulty) {
		ArrayList<Question> questions = new ArrayList<Question>();
		for (Question q : this.questions) {
			if (q.GetDifficulty() == difficulty) {
				try {
					questions.add((Question) q.clone()); // ;
				} catch (CloneNotSupportedException e) {
				}
			}
		}
		return questions;
	}

	@Override
	public ArrayList<Question> GetQuestionsByCategory(Category c) {
		ArrayList<Question> questions = new ArrayList<Question>();
		for (Question q : this.questions) {
			if (q.GetCategory() == c) {
				try {
					questions.add((Question) q.clone());
				} catch (CloneNotSupportedException e) {
				}
			}
		}
		return questions;
	}

	@Override
	public void CreateQuestion(Question q) {
		try {
			this.questions.add((Question) q.clone());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void UpdateQuestion(Question qu) {
		for (int i = 0; i < this.questions.size(); i++) {
			if (this.questions.get(i).GetID() == qu.GetID()) {
				Question newQuestion;
				try {
					newQuestion = (Question) qu.clone();
				} catch (CloneNotSupportedException e) {
					e.printStackTrace();
					continue;
				}
				this.questions.add(i, newQuestion);
				return;
			}
		}
	}

	@Override
	public void DeleteQuestion(int id) {
		for (Question q : this.questions) {
			if (q.GetID() == id) {
				this.questions.remove(q);
				return;
			}
		}
	}
}
