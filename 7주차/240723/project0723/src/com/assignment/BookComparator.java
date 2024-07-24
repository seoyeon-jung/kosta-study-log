package com.assignment;

import java.util.Comparator;

public class BookComparator {
	// static Comparator<Book> byTitle()
	// 제목을 기준으로 정렬
	public static Comparator<Book> byTitle() {
//		return Comparator.comparing(new Function<Book, String>() {
//			@Override
//			public String apply(Book book) {
//				return book.getTitle();
//			}
//		});
		return Comparator.comparing(Book::getTitle);
	}

	// static Comparator<Book> byAuthor()
	// 글쓴이를 기준으로 정렬
	public static Comparator<Book> byAuthor() {
		return Comparator.comparing(Book::getAuthor);
	}

	// static Comparator<Book> byYear()
	// 출판연도를 기준으로 정렬
	public static Comparator<Book> byYear() {
		return Comparator.comparing(Book::getYear);
	}

	// static Comparator<Book> byPages()
	// 총 페이지를 기준으로 정렬
	public static Comparator<Book> byPages() {
		return Comparator.comparing(Book::getPages);
	}
}
