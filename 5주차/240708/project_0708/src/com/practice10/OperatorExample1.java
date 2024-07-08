package com.practice10;

public class OperatorExample1 {

	public static void main(String[] args) {
		int x = 1;
		int y = 1;
		// int result1 = ++x + 10; // x가 먼저 증가 => 2 + 10
		// int result2 = y++ + 10; // y가 나중에 증가 => 1 + 10 (y 값은 그대로, 더한 다음에 y+1)
		int result1 = ++x; // 2
		int result2 = y++; // 1

		System.out.println("result1: " + result1 + " result2: " + result2); // 12, 11
		System.out.println("x: " + x + " y: " + y); // x: 2 y: 2

	}

}
