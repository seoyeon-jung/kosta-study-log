package com.report.domain;

import java.time.LocalDateTime;

import com.report.entity.Book;

import lombok.Builder;
import lombok.Data;

@Data
public class BookDTO {
	private Long id;
	private String bookTitle, author, publisher, genre;
	private LocalDateTime updatedAt;

	@Builder
	public BookDTO(Long id, String bookTitle, String author, String publisher, String genre, LocalDateTime updatedAt) {
		this.id = id;
		this.bookTitle = bookTitle;
		this.author = author;
		this.publisher = publisher;
		this.genre = genre;
		this.updatedAt = updatedAt;
	}

	public Book setBook() {
		Book book = new Book();
		book.setBookTitle(bookTitle);
		book.setAuthor(author);
		book.setPublisher(publisher);
		book.setGenre(genre);
		book.setUpdatedAt(LocalDateTime.now());
		return book;
	}

}
