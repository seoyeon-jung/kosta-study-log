package com.practice10;

public class OperatorExample3 {

	public static void main(String[] args) {
		byte v1 = 10;
		byte v2 = 4;
		long v3 = 10L;

		int result1 = v1 + v2; // 10 + 4
		System.out.println("result1: " + result1); // 14

		long result2 = v1 + v2 - v3; // 10 + 4 - 10
		System.out.println("result2: " + result2); // 4

		double result3 = (double) v1 / v2; // 10 / 4 = 2.5
		System.out.println("result3: " + result3); // 2.5

		int result4 = v1 % v2; // 10 / 4 = 몫 2, 나머지 2
		System.out.println("result4: " + result4); // 2
	}

}
