package tools.draw_uml;


import java.io.FileNotFoundException;
import java.io.PrintWriter;

import ch.ifocusit.plantuml.classdiagram.ClassDiagramBuilder;
import controller.Screen;
import questions.QuestionParser;
import questions.QuestionStore;
import ui.Router;

public class Main {
	public static void main(String[] args) {
		var builder = new ClassDiagramBuilder();
		var diagram = builder
				.addClasse(ui.Router.class)
				.addClasse(ui.Registry.class)
				.addClasse(questions.QuestionParser.class)
				.addClasse(questions.QuestionStore.class)
				.addClasse(model.Category.class)
				.addClasse(model.Question.class)
				.addClasse(game.MissingQuestionsException.class)
				.addClasse(game.State.class)
				.addClasse(game.StateBuilder.class)
				.addClasse(controller.Controller.class)
				.addClasse(controller.Create.class)
				.addClasse(controller.Edit.class)
				.addClasse(controller.Game.class)
				.addClasse(controller.Options.class)
				.addClasse(controller.Result.class)
				.addClasse(controller.Screen.class)
				.addClasse(controller.Share.class)
				.addClasse(controller.Start.class)
				.addClasse(controller.Switcher.class)
				.addClasse(view.Edit.class)
				.addClasse(view.Game.class)
				.addClasse(view.Options.class)
				.addClasse(view.OptionsQuestionRow.class)
				.addClasse(view.Result.class)
				.addClasse(view.Start.class)
				.build();
		
		System.out.println("done!");
		try (PrintWriter out = new PrintWriter("diagram.puml")) {
		    out.println(diagram);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.exit(0);
	}
}