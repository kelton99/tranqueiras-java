package com.kelton.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public enum DataHandler {
    INSTANCE;
    private final List<Book> books = new ArrayList<>();

    private List<Book> getBooks() {
        if(books.isEmpty()) {
            books.add(new Book("ANSI C Programming Language", "Keith Richard", 50.5));
            books.add(new Book("Effective Java", "Joshua Bloch", 200.9));
            books.add(new Book("Clean Code", "Robert C. Martin", 150.4));
        }
        return books;
    }

    public void createBook(Book book) {
        getBooks().add(book);
    }

    public void deleteBook(Book book) {
        this.books.remove(book);
    }

    public ObservableList<Book> bookObservableList() {
        ObservableList<Book> ol = FXCollections.observableArrayList(getBooks());
        return ol;
    }
}
