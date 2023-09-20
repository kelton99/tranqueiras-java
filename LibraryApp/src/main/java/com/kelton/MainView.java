package com.kelton;

import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;

public class MainView extends BorderPane {

	private final LeftSide leftSide = new LeftSide();
	private final RightSide rightSide = new RightSide();

	public MainView() {
		this.setPrefSize(800, 600);
		this.setPadding(new Insets(10, 10, 10, 10));

		this.leftSide.getInsertButton().setOnAction(e -> insertBook());
		this.leftSide.getUpdateButton().setOnAction(e -> updateBook());
		this.leftSide.getDeleteButton().setOnAction(e -> deleteBook());

		this.setLeft(leftSide);
		this.setRight(rightSide);
	}

	private void insertBook() {
		Book book = new Book(Integer.parseInt(leftSide.getIdField().getText()), leftSide.getTitleField().getText(), leftSide.getAuthorField().getText(),
				Integer.parseInt(leftSide.getYearField().getText()), Integer.parseInt(leftSide.getPagesField().getText()));
		final Connector conn = new Connector();
		conn.insertBook(book);
		this.rightSide.showBooks();
	}

	private void updateBook() {
		Book book = new Book(Integer.parseInt(leftSide.getIdField().getText()), leftSide.getTitleField().getText(), leftSide.getAuthorField().getText(),
				Integer.parseInt(leftSide.getYearField().getText()), Integer.parseInt(leftSide.getPagesField().getText()));
		final Connector conn = new Connector();
		conn.updateBook(book);
		this.rightSide.showBooks();
	}

	private void deleteBook() {
		final Connector conn = new Connector();
		conn.deleteBook(Integer.parseInt(leftSide.getIdField().getText()));
		this.rightSide.showBooks();
	}


}
