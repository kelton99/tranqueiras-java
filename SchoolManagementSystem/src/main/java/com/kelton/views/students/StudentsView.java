package com.kelton.views.students;

import com.kelton.CustomEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class StudentsView extends BorderPane {

	private final StudentsTable studentsTable = new StudentsTable();
	private final VBox leftSide = new VBox();

	public StudentsView() {
		final Button consult = new Button("Consult");
		final Button delete = new Button("Delete");

		this.leftSide.getChildren().addAll(consult, delete);

		this.setLeft(leftSide);
		this.setRight(studentsTable);

		consult.setOnAction(e -> fireEvent(new CustomEvent(CustomEvent.goToStudentPanel)));
	}
}
