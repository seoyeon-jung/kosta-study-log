package com.oop.practice5.library.book;

public class Book {
	public String title, author, isbn;
	private static int bookCount = 0;

	public Book(String title, String author, String isbn) {
		setTitle(title);
		this.author = author;
		this.isbn = isbn;
		bookCount++;
	}

	private void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public static int getBookCount() {
		return bookCount;
	}

	public void printBookInfo() {
		System.out.println("Title: " + title + ", Author: " + author + ", ISBN: " + isbn);
	}

}
