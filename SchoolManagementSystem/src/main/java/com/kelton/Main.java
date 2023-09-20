package com.kelton;

import com.kelton.views.MainScreen;
import com.kelton.views.studentpanel.StudentPanel;
import com.kelton.views.students.StudentsView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	private static final MainScreen mainScreen = new MainScreen();
	private static final StudentPanel studentPanel = new StudentPanel();
	private static final StudentsView studentsView = new StudentsView();

	public static final int screenHeight = 600;
	public static final int screenWidth = 600;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		Scene scene = new Scene(mainScreen);
		mainScreen.addEventFilter(CustomEvent.goToStudents, e -> {
			stage.setScene(new Scene(studentsView));
		});
		studentsView.addEventFilter(CustomEvent.goToStudentPanel, e -> {
			stage.setScene(new Scene(studentPanel));
		});

		stage.setTitle("School Management System");
		stage.setScene(scene);
		stage.show();
	}
}
