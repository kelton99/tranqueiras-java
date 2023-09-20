package com.kelton;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Connector {

	public static Connection getConnection() {
		final Connection conn;

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "123");
			return conn;
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			return null;
		}
	}

	public ObservableList<Book> getBooksList() {
		final ObservableList<Book> bookList = FXCollections.observableArrayList();
		final Connection conn = getConnection();
		final String query = "SELECT * FROM book";
		final Statement statement;
		final ResultSet resultSet;

		try {
			statement = conn.createStatement();
			resultSet = statement.executeQuery(query);
			Book book;
			while(resultSet.next()) {
				book = new Book(resultSet.getInt("id"), resultSet.getString("title"), resultSet.getString("author"), resultSet.getInt("year"), resultSet.getInt("pages"));
				bookList.add(book);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return bookList;

	}

	public void insertBook(Book book) {
		final String query = String.format("INSERT INTO book VALUES ('%s', '%s', '%s', '%s', '%s')", book.getId(), book.getTitle(), book.getAuthor(), book.getYear(), book.getPages());

		executeQuery(query);

	}
	public void updateBook(Book book) {
		String query = String.format("UPDATE book SET title = '%s', author= '%s', year = '%s', pages = '%s' WHERE id == '%s'",
				book.getTitle(), book.getAuthor(), book.getYear(), book.getPages(), book.getId());
		executeQuery(query);
	}

	public void deleteBook(Integer id) {
		String query = String.format("DELETE FROM book WHERE id = '%d'", id);
		executeQuery(query);
	}

	private void executeQuery(String query) {
		Connection conn = getConnection();
		Statement statement;
		try {
			statement = conn.createStatement();
			statement.executeQuery(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
