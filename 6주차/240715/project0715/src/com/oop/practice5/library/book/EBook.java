package com.oop.practice5.library.book;

public class EBook extends Book {
	double fileSize;

	public EBook(String title, String author, String isbn, double fileSize) {
		super(title, author, isbn);
		this.fileSize = fileSize;
	}

	@Override
	public void printBookInfo() {
		System.out.println(
				"Title: " + title + ", Author: " + author + ", ISBN: " + isbn + ", File Size: " + fileSize + " MB");
	}
}
