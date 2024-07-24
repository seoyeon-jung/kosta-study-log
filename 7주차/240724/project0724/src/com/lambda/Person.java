package com.lambda;

public class Person {
	public void ordering(Comparable comparable) {
		// 사람을 정렬해주는 메소드
		String value1 = "Dog";
		String value2 = "cat";

		int result = comparable.compare(value1, value2);

		if (result < 0) {
			System.out.println(value1 + "은 " + value2 + "보다 앞에 옵니다.");
		} else if (result > 0) {
			System.out.println(value1 + "은 " + value2 + "보다 뒤에 옵니다.");
		} else {
			System.out.println(value1 + "은 " + value2 + "과 같습니다.");
		}
	}
}
