package com.stream2;

import java.util.Arrays;
import java.util.List;

public class StudentStreamExample {

	public static void main(String[] args) {
		// 불변 객체 생성
		List<Student> sList = Arrays.asList(new Student("Alice", 90), new Student("Bob", 80), new Student("Carol", 85),
				new Student("David", 95));

//		Stream<Student> originStream = sList.stream();
//		IntStream intStream = originStream.mapToInt(Student::getScore);
//		OptionalDouble optAverage = intStream.average();
//		double average = optAverage.getAsDouble();
		// 변수를 계속 생성해야 하는 번거로움이 있다.

		// method chaining
		double average = sList.stream().mapToInt(Student::getScore).average().getAsDouble();

		System.out.println("평균 점수 : " + average); // 87.5

	}

}
