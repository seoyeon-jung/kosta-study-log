package com.collection.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {

	public static void main(String[] args) {
		// ArrayList 객체 생성[문자열]
		List<String> list1 = new ArrayList<>();

		// LinkedList 객체 생성 [문자열]
		List<String> list2 = new LinkedList<>();

		// 시간 측정을 위한 변수 선언
		long startTime;
		long endTime;

		startTime = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			list1.add(0, String.valueOf(i));
		}
		endTime = System.nanoTime();

		System.out.println("걸린 시간 : " + (endTime - startTime));

		startTime = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			list2.add(0, String.valueOf(i));
		}
		endTime = System.nanoTime();

		System.out.println("걸린 시간 : " + (endTime - startTime));

		// 걸린 시간이 list1 > list2
		// LinkedList가 훨씬 더 빠르게 만들어진다.

		startTime = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			list1.get(i);
		}
		endTime = System.nanoTime();

		System.out.println("조회 시 걸린 시간 : " + (endTime - startTime));

		startTime = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			list1.get(i);
		}
		endTime = System.nanoTime();

		System.out.println("조회 시 걸린 시간 : " + (endTime - startTime));

	}

}
