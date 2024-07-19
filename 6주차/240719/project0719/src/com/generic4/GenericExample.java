package com.generic4;

public class GenericExample {

	public static void main(String[] args) {
		boolean result1 = compare(10, 20);
		System.out.println(result1); // false

		boolean result2 = compare(20L, 20D);
		System.out.println(result2); // true

		boolean result3 = compare(4.5, 4.5);
		System.out.println(result3); // true
	}

	public static <T extends Number> boolean compare(T t1, T t2) {
		// T 값 비교 (Number에 저장되어있는 메소드 이용)
		double v1 = t1.doubleValue();
		double v2 = t2.doubleValue();

		return v1 == v2;

	}

}
