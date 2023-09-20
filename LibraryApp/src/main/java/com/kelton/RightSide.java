package com.kelton;

import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class RightSide extends TableView<Book> {

	private final TableColumn<Book, Integer> idColumn = new TableColumn<>("ID");
	private final TableColumn<Book, String> titleColumn = new TableColumn<>("Title");
	private final TableColumn<Book, String> authorColumn = new TableColumn<>("Author");
	private final TableColumn<Book, Integer> yearColumn = new TableColumn<>("Year");
	private final TableColumn<Book, Integer> pagesColumn = new TableColumn<>("Pages");

	public RightSide() {

		idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
		titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
		authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
		yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
		pagesColumn.setCellValueFactory(new PropertyValueFactory<>("pages"));

		this.getColumns().addAll(idColumn, titleColumn, authorColumn, yearColumn, pagesColumn);

		this.showBooks();
	}

	public void showBooks() {
		final Connector connector = new Connector();
		ObservableList<Book> books = connector.getBooksList();
		this.setItems(books);

	}

}
