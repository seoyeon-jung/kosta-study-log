package com.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BookManagementSystem {
	// 속성
	// books: List<Book> / bookIsbns: Set<String> / bookMap: Map<String, Book>
	private List<Book> books = new ArrayList<>();
	private Set<String> bookIsbns = new HashSet<>();
	private Map<String, Book> bookMap = new HashMap<>();

	// addBook(String title, String isbn, String author, int year, String
	// category):void
	// 도서 추가 (ISBN 중복 X, 중복인 경우 오류 메세지 출력)
	public void addBook(String title, String isbn, String author, int year, String category) {
		if (!bookIsbns.contains(isbn)) {
			Book newBook = new Book(title, isbn, author, year, category);
			books.add(newBook);
			bookIsbns.add(isbn);
			bookMap.put(isbn, newBook);
		} else {
			System.out.println("이미 존재하는 책입니다. (ISBN 중복)");
		}
	}

	// removeBook(String isbn): void
	// ISBN을 입력 받아 해당 ISBN의 도서를 삭제
	public void removeBook(String isbn) {
		Book removedBook = bookMap.get(isbn);
		if (removedBook != null) {
			books.remove(removedBook);
			bookIsbns.remove(isbn);
			bookMap.remove(isbn);
		} else {
			System.out.println("Error: 해당 ISBN을 가진 도서가 존재하지 않습니다.");
		}
	}

	// updateBook(String isbn, String newTitle, String newAuthor, int newYear,
	// String newCategory): void
	// ISBN을 입력받아 해당 ISBN의 도서 정보를 업데이트 (제목, 저자, 출판연도, 카테고리 업데이트)
	public void updateBook(String isbn, String newTitle, String newAuthor, int newYear, String newCategory) {
		Book bookToUpdate = bookMap.get(isbn);
		if (bookToUpdate != null) {
			bookToUpdate.setTitle(newTitle);
			bookToUpdate.setAuthor(newAuthor);
			bookToUpdate.setYear(newYear);
			bookToUpdate.setCategory(newCategory);
		} else {
			System.out.println("Error: 해당 ISBN을 가진 도서가 존재하지 않습니다.");
		}
	}

	// listBooks(): void
	// 전체 도서 목록 출력
	public void listBooks() {
		for (Book book : books) {
			System.out.println(book);
		}
	}

	// searchBook(String isbnOrTitle): void
	// ISBN 또는 제목을 입력받아 해당 도서를 검색하고, 도서 정보를 출력한다
	public void searchBook(String isbnOrTitle) {
		boolean found = false;
		for (Book book : books) {
			if (book.getIsbn().equals(isbnOrTitle) || book.getTitle().equalsIgnoreCase(isbnOrTitle)) {
				System.out.println(book);
				found = true;
				break;
			}
		}
		if (!found) {
			System.out.println("해당하는 도서를 찾지 못했습니다.");
		}

	}
}
