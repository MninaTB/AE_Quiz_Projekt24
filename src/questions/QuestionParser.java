package questions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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

	@SuppressWarnings("unchecked")
	public void load(InputStreamReader sr) {
		Gson gson = new Gson();
		String json = new BufferedReader(sr)
				   .lines().collect(Collectors.joining("\n"));
		this.questions = gson.fromJson(json, this.questions.getClass());
	}
	
	public void save(OutputStreamWriter w) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		gson.toJson(this.questions, w);
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Question> getAllQuestions() {
		return (ArrayList<Question>) this.questions.clone();
	}

	@Override
	public Question getByID(int id) {
		for (Question q : this.questions) {
			if (q.getID() == id) {
				return q;
			}
		}
		return null;
	}

	@Override
	public ArrayList<Question> getByDifficulty(int difficulty) {
		ArrayList<Question> questions = new ArrayList<Question>();
		for (Question q : this.questions) {
			if (q.getDifficulty() == difficulty) {
				try {
					questions.add((Question) q.clone()); // ;
				} catch (CloneNotSupportedException e) {
				}
			}
		}
		return questions;
	}

	@Override
	public ArrayList<Question> getByCategory(Category c) {
		ArrayList<Question> questions = new ArrayList<Question>();
		for (Question q : this.questions) {
			if (q.getCategory() == c) {
				try {
					questions.add((Question) q.clone());
				} catch (CloneNotSupportedException e) {
				}
			}
		}
		return questions;
	}

	@Override
	public void create(Question q) {
		try {
			this.questions.add((Question) q.clone());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Question qu) {
		for (int i = 0; i < this.questions.size(); i++) {
			if (this.questions.get(i).getID() == qu.getID()) {
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
	public void delete(int id) {
		for (Question q : this.questions) {
			if (q.getID() == id) {
				this.questions.remove(q);
				return;
			}
		}
	}
}
