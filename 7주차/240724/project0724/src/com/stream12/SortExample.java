package com.stream12;

import java.util.ArrayList;
import java.util.List;

public class SortExample {

	public static void main(String[] args) {
		List<Student> sList = new ArrayList<>();
		sList.add(new Student("박명수", 60));
		sList.add(new Student("유재석", 100));
		sList.add(new Student("정준하", 40));

		// score 기준으로 오름차순 정렬된다
		// Student 클래스에 implements Comparable<Student>가 없으므로 ClassCastException 에러 발생
		// sList.stream().sorted().forEach(s -> System.out.println(s));

		// 익명 구현 객체를 넣어서 Comparable을 구현한다
		sList.stream().sorted((s1, s2) -> s1.getScore() - s2.getScore()).forEach(s -> System.out.println(s));

		System.out.println();

		// score 기준 내림차순 정렬
		sList.stream().sorted((s1, s2) -> s2.getScore() - s1.getScore()).forEach(s -> System.out.println(s));

	}

}
