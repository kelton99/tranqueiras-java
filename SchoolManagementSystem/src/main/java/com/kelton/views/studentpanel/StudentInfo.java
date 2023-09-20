package com.kelton.views.studentpanel;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class StudentInfo extends GridPane {

	public StudentInfo() {

		this.setPadding(new Insets(10, 10, 10, 10));
		this.setHgap(10);
		this.setVgap(2);
		Label nameLbl = new Label("Name");
		Label registryLbl = new Label("Registry");
		Label emailLbl = new Label("Email");

		TextField nameField = new TextField("");
		nameField.prefWidth(nameField.getMaxWidth());
		TextField codeField = new TextField("123456");
		TextField emailField = new TextField("kelton@gmail.com");

		this.add(nameLbl, 0, 0);
		this.add(nameField, 0, 1);

		this.add(registryLbl, 1, 0);
		this.add(codeField, 1, 1);

		this.add(emailLbl,0, 3);
		this.add(emailField, 0, 4);
	}
}
