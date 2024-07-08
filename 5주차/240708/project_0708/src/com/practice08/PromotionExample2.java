package com.practice08;

public class PromotionExample2 {
	public static void main(String[] args) {
		int x = 1;
		int y = 2;

		// 정수 연산의 결과는 항상 정수이기 때문에 결과가 0 => double 타입에 저장해서 0.0 출력
		double result = x / y;
		System.out.println(result); // 0.0

		// 0을 double 타입 변수에 저정하기 때문에 둘 중 하나 또는 모두를 double 타입으로 변환해야 한다
		double double_result = x / (double) y;
		System.out.println(double_result); // 0.5

		// ----------------------------------------

		byte result1 = 10 + 20;
		System.out.println("result1: " + result1); // 30

		byte v1 = 10;
		byte v2 = 20;
		int result2 = v1 + v2;
		System.out.println("result2: " + result2); // 30

		byte v3 = 10;
		int v4 = 100;
		long v5 = 1000L;
		long result3 = v3 + v4 + v5;
		System.out.println("result3: " + result3); // 1100

		char v6 = 'A';
		char v7 = 1;
		int result4 = v6 + v7;
		System.out.println("result4: " + result4); // 66
		System.out.println("result4: " + (char) result4); // B

		int v8 = 10;
		int result5 = v8 / 4;
		System.out.println("result5: " + result5); // 2

		int v9 = 10;
		double result6 = v9 / 4.0;
		System.out.println("result6: " + result6); // 2.5

		int v10 = 1;
		int v11 = 2;
		double result7 = (double) v10 / v11;
		System.out.println("result7: " + result7); // 0.5

	}
}
