package com.practice;

public class Example2 {

	public static void main(String[] args) {
		// 100의 자리만 남기고 나머지 자리 수는 0으로 바꾸는 프로그램
		int num = 456;
		int result = (num / 100) * 100;
		// int result = num - num % 100;

		System.out.println(result); // 400

	}

}
