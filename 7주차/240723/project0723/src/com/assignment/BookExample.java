package com.assignment;

import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

public class BookExample {

	public static void main(String[] args) {
		BookManager bm = new BookManager();

		bm.addBook(new Book("언어의 온도", "이기주", 2018, 551));
		bm.addBook(new Book("자존감 수업", "윤홍균", 2006, 394));
		bm.addBook(new Book("나미야 잡화점의 기적", "히가시노 게이고", 2008, 468));
		bm.addBook(new Book("살인자의 기억법", "김영하", 2023, 264));

		System.out.println("제목을 기준으로 정렬 합니다.");
		bm.sortBooksBy(BookComparator.byTitle());
		bm.books.forEach(System.out::println);

		System.out.println("\n 작가를 기준으로 정렬 합니다.");
		bm.sortBooksBy(BookComparator.byAuthor());
		bm.books.forEach(System.out::println);

		System.out.println("\n 출판연도를 기준으로 정렬 합니다.");
		bm.sortBooksBy(BookComparator.byYear());
		bm.books.forEach(System.out::println);

		System.out.println("\n 총 페이지 수를 기준으로 정렬 합니다.");
		bm.sortBooksBy(BookComparator.byPages());
		bm.books.forEach(System.out::println);

		Stack<Book> stack = bm.getStack();
		System.out.println("\n 스택 출력");
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}

		Queue<Book> queue = bm.getQueue();
		System.out.println("\n 큐 출력");
		while (!queue.isEmpty()) {
			System.out.println(queue.poll());
		}

		Map<String, Book> bookMap = bm.getBookMap();
		System.out.println("\n 해시맵 출력");
		bookMap.values().forEach(System.out::println);

		TreeMap<String, Book> bookTreeMap = bm.getBookTreeMap();
		System.out.println("\n 트리맵 출력");
		bookTreeMap.values().forEach(System.out::println);

		TreeSet<Book> bookTreeSet = bm.getBookTreeSet();
		System.out.println("\n 트리셋 출력");
		bookTreeSet.forEach(System.out::println);
	}

}
