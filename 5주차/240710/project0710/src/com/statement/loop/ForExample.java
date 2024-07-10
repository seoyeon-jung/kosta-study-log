package com.statement.loop;

public class ForExample {

	public static void main(String[] args) {
		// ctrl + alt + 위/아래 방향기 -> 동일한 내용 복사

//		for (int i = 0; i < 10; i++) {
//			System.out.println("안녕하세요");
//		}
//
//		for (int i = 0; i <= 9; i++) {
//			System.out.println("안녕하세요");
//		}
//
//		for (int i = 1; i <= 10; i++) {
//			System.out.println("안녕하세요");
//		}
//
//		for (int i = 10; i >= 1; i--) {
//			System.out.println("안녕하세요");
//		}
//
//		for (int i = 9; i >= 0; i--) {
//			System.out.println("안녕하세요");
//		}

		int sum = 0;

		// 45~99까지 더하기
		for (int i = 45; i < 100; i++) {
			sum += i;
		}
		System.out.println("합: " + sum);

//		int sum2 = (45 + 99) * (99 - 45 + 1) / 2;
//		System.out.println("합: " + sum2);

	}

}
