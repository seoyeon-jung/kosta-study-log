package com.practice;

import java.util.Scanner;

public class BookExample {

	public static void main(String[] args) {

		BookManagementSystem system = new BookManagementSystem();

//		// 도서 추가
//		system.addBook("Effective Java", "978-0134685991", "Joshua Bloch", 2018, "Programming");
//		system.addBook("Clean Code", "978-0132350884", "Robert C. Martin", 2008, "Programming");
//
//		// 전체 도서 출력
//		system.listBooks();
//
//		System.out.println();
//
//		// 도서 정보 수정
//		system.updateBook("978-0134685991", "Effective Java (3rd Edition)", "Joshua Bloch", 2018, "Programming");
//		// 도서 검색
//		system.searchBook("978-0134685991");
//
//		System.out.println();
//
//		// 도서 제거
//		system.removeBook("978-0132350884");
//		// 전체 도서 출력
//		system.listBooks();

		try (// 입력받기
				Scanner sc = new Scanner(System.in)) {
			boolean run = true;

			// while true로 계산
			// 1. 책 추가 2. 정보 수정 3. 도서 검색 4. 도서 제거 5. 전체 도서 출력
			while (run) {
				System.out.println("1. 책 추가\t2. 정보 수정\t3. 도서 검색\t4. 도서 제거\t5. 전체 도서 출력\t6.종료");
				int num = sc.nextInt();

				switch (num) {
				case 1:
					system.addBook(getTextInput("Title"), getTextInput("ISBN"), getTextInput("Author"),
							Integer.parseInt(getTextInput("Year")), getTextInput("Category"));
					break;
				case 2:
					system.updateBook(getTextInput("Title"), getTextInput("ISBN"), getTextInput("Author"),
							Integer.parseInt(getTextInput("Year")), getTextInput("Category"));
					break;
				case 3:
					system.searchBook(getTextInput("ISBN 또는 title"));
					break;
				case 4:
					system.removeBook(getTextInput("ISBN"));
					break;
				case 5:
					system.listBooks();
					break;
				case 6:
					run = false;
					break;
				}

			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}

	public static String getTextInput(String key) {
		Scanner sc = new Scanner(System.in);
		System.out.print(key + " 을/를 입력하세요");
		return sc.nextLine();
	}

}
