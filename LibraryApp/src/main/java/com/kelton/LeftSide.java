package com.kelton;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class LeftSide extends VBox {

	private final TextField idField = new TextField();
	private final TextField titleField = new TextField();
	private final TextField authorField = new TextField();
	private final TextField yearField = new TextField();
	private final TextField pagesField = new TextField();
	private final Button insertButton = new Button("Insert");
	private final Button updateButton = new Button("Update");
	private final Button deleteButton = new Button("Delete");

	public LeftSide() {
		this.setPadding(new Insets(10, 10, 10, 10));
		this.setPadding(new Insets(10, 10, 10, 10));
		this.setSpacing(10);
		final GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);

		final Label idLabel = new Label("ID");
		final Label titleLabel = new Label("Title");
		final Label authorLabel = new Label("Author");
		final Label yearLabel = new Label("Year");
		final Label pagesLabel = new Label("Pages");

		grid.add(idLabel, 0, 0);
		grid.add(idField, 1, 0);

		grid.add(titleLabel, 0, 1);
		grid.add(titleField, 1, 1);

		grid.add(authorLabel, 0, 2);
		grid.add(authorField, 1, 2);

		grid.add(yearLabel, 0, 3);
		grid.add(yearField, 1, 3);

		grid.add(pagesLabel, 0, 4);
		grid.add(pagesField, 1, 4);

		setFontSize(idLabel, titleLabel, authorLabel, yearLabel, pagesLabel);

		final HBox buttons = new HBox();
		buttons.setAlignment(Pos.BOTTOM_LEFT);
		buttons.setPadding(new Insets(20, 20, 20, 20));
		buttons.setSpacing(10);

		buttons.getChildren().addAll(insertButton, updateButton, deleteButton);
		this.getChildren().addAll(grid, buttons);
	}

	private void setFontSize(Label ...labels) {
		for (Label label : labels) {
			label.setFont(Font.font(15));
		}
	}

	public TextField getIdField() {
		return idField;
	}

	public TextField getTitleField() {
		return titleField;
	}

	public TextField getAuthorField() {
		return authorField;
	}

	public TextField getYearField() {
		return yearField;
	}

	public TextField getPagesField() {
		return pagesField;
	}

	public Button getInsertButton() {
		return insertButton;
	}

	public Button getUpdateButton() {
		return updateButton;
	}

	public Button getDeleteButton() {
		return deleteButton;
	}
}
