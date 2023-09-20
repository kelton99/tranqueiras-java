package com.kelton.views;

import com.kelton.CustomEvent;
import com.kelton.Main;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class MainScreen extends BorderPane {

	private final HBox buttons = new HBox();

	public MainScreen() {
		this.setTop(new Label("School Management System"));
		this.setPrefSize(Main.screenWidth, Main.screenHeight);
		final Button toStudents = new Button("Students");
		final Button toDisciplines = new Button("Disciplines");

		toStudents.setOnAction(e -> fireEvent(new CustomEvent(CustomEvent.goToStudents)));
		toDisciplines.setOnAction(e -> fireEvent(new CustomEvent(CustomEvent.goToDisciplines)));

		buttons.getChildren().addAll(toStudents, toDisciplines);

		this.setCenter(buttons);
	}
}
