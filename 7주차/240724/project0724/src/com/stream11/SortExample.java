package com.stream11;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortExample {

	public static void main(String[] args) {
		List<Student> sList = new ArrayList<>();
		sList.add(new Student("박명수", 60));
		sList.add(new Student("유재석", 100));
		sList.add(new Student("정준하", 40));

		// score 기준으로 오름차순 정렬된다
		sList.stream().sorted().forEach(s -> System.out.println(s));

		System.out.println();

		// score 기준 내림차순 정렬
		// reverseOrder() 사용해서 거꾸로 정렬
		sList.stream().sorted(Comparator.reverseOrder()).forEach(s -> System.out.println(s));
		;
	}

}
