package com.kelton;

import java.util.Objects;

public class Book {

	private final Integer id;
	private final String title;
	private final String author;
	private final Integer year;
	private final Integer pages;

	public Book(Integer id, String title, String author, Integer year, Integer pages) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.year = year;
		this.pages = pages;
	}

	public Integer getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public Integer getYear() {
		return year;
	}

	public Integer getPages() {
		return pages;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Book book = (Book) o;
		return id.equals(book.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
