package com.practice10;

public class ExceptionExample {

	public static void main(String[] args) {
		// int exception = 5 / 0;
		// System.out.println(exception); // java.lang.ArithmeticException: / by zero

		double infinity = 5 / 0.0;
		System.out.println(infinity); // Infinity (무한대 출력)

		double notNumber = 5 % 0.0;
		System.out.println(notNumber); // NaN (Not a number) 출력

		// Infinity 아닌 경우에만 계산되도록 조건문 추가
		if (!Double.isInfinite(infinity)) {
			double result = infinity + 1;
			System.out.println(result); // Infinity
		}

	}

}
