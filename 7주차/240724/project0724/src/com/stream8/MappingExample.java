package com.stream8;

import java.util.Arrays;
import java.util.List;

public class MappingExample {

	public static void main(String[] args) {
		List<Student> sList = Arrays.asList(new Student("Aclice", 90), new Student("Bob", 80), new Student("Carol", 85),
				new Student("David", 95));

		sList.stream().map(Student::getName).forEach(System.out::println);

	}

}
