package com.assignment;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

public class BookManager {
	private List<Book> books;

	public BookManager() {
		this.setBooks(new ArrayList<Book>());
	}

	// void addBook(Book book)
	// books에 book 추가
	public void addBook(Book book) {
		getBooks().add(book);
	}

	// void removeBook(Book book)
	// books에 book 제거
	public void removeBook(Book book) {
		getBooks().remove(book);
	}

	// void sortBooksBy(Comparator<Book> comparator)
	// 해당 comparator에 따라 정렬
	public void sortBooksBy(Comparator<Book> comparator) {
		// List 컬렉션의 sort라는 메소드
		// sort(Comparator 인터페이스) -> 인터페이스의 추상 메소드를 재정의한 메소드가 동작되어 정렬
		getBooks().sort(comparator);
	}

	// Stack<Book> getStack()
	// 스택을 생성하여, Books의 book들을 모두 스택에 넣고 반환
	public Stack<Book> getStack() {
		Stack<Book> stack = new Stack<>();
		for (Book book : getBooks()) {
			stack.push(book);
		}
		return stack;
	}

	// Queue<Book> getQueue()
	// 큐를 생성하여, Books의 book들을 모두 큐에 넣고 반환
	public Queue<Book> getQueue() {
		Queue<Book> queue = new LinkedList<>();
		for (Book book : getBooks()) {
			queue.offer(book);
		}
		return queue;
	}

	// Map<String, Book> getBookMap()
	// HashMap을 생성하여, Books의 book들을 모두 맵<제목, Book>에 넣고 반환
	public Map<String, Book> getBookMap() {
		Map<String, Book> map = new HashMap<>();
		for (Book book : getBooks()) {
			map.put(book.getTitle(), book);
		}
		return map;
	}

	// TreeMap<String, Book> getBookTreeMap()
	// TreeMap을 생성하여, Books의 book들을 모두 트리맵<제목, Book>에 넣고 반환
	public TreeMap<String, Book> getBookTreeMap() {
		TreeMap<String, Book> treeMap = new TreeMap<>();
		for (Book book : getBooks()) {
			treeMap.put(book.getTitle(), book);
		}
		return treeMap;
	}

	// TreeSet getBookTreeSet()
	// TreeSet을 생성하여, Books의 book들을 모두 트리셋<Book>에 넣고 반환
	public TreeSet<Book> getBookTreeSet() {
		TreeSet<Book> bookTreeSet = new TreeSet<>(BookComparator.byTitle());
		bookTreeSet.addAll(getBooks());
		return bookTreeSet;
//		TreeSet<Book> bookTreeSet = new TreeSet<>(books);
//		return bookTreeSet;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

}
