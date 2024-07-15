package com.oop.practice5.library.main;

import com.oop.practice5.library.book.Book;
import com.oop.practice5.library.book.EBook;

public class BookExmaple {
	public static void main(String[] args) {
		// Book 인스턴스 생성
		Book book1 = new Book("삼국지", "이문열", "1234567890");
		Book book2 = new Book("갈매기의 꿈", "리처드바크", "0987654321");

		// EBook 인스턴스 생성
		EBook ebook1 = new EBook("소설가 구보씨의 일일", "최인훈", "1122334455", 1.5);

		// 정보 출력
		book1.printBookInfo();
		book2.printBookInfo();
		ebook1.printBookInfo();

		// 총 도서수 출력
		System.out.println("총 도서 수 : " + Book.getBookCount());
	}
}
