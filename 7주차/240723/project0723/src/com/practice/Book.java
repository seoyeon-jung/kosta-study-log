package com.practice;

public class Book {
	// 속성 : title, isbn, author, year, category
	private String title, isbn, author;
	private int year;
	private String category;

	public Book(String title, String isbn, String author, int year, String category) {
		this.title = title;
		this.isbn = isbn;
		this.author = author;
		this.year = year;
		this.category = category;
	}

	// getter, setter
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	// toString
	@Override
	public String toString() {
		return "[title : " + title + ", isbn : " + isbn + ", author : " + author + ", year : " + year + ", category : "
				+ category + "]";
	}

}
