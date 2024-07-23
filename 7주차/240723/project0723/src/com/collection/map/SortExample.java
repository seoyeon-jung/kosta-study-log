package com.collection.map;

import java.util.TreeSet;

public class SortExample {

	public static void main(String[] args) {
		TreeSet<Book> bookSet = new TreeSet<>();

		bookSet.add(new Book("개를 훔치는 완벽한 방법", "B1", 2002));
		bookSet.add(new Book("수상한 장미마을", "B2", 2000));
		bookSet.add(new Book("위대한 개츠비", "B3", 1980));
		bookSet.add(new Book("언어의 온도", "B4", 2015));
		bookSet.add(new Book("아몬드", "B5", 2006));

		System.out.println(bookSet);

	}

}
