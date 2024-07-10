package com.statement.practice;

public class Practice6 {

	public static void main(String[] args) {
		// 1부터 100까지 반복하면서 3의 배수는 three, 5의 배수는 five, 7의 배수는 seven 값을 출력하는 프로그램

		for (int i = 1; i <= 100; i++) {
//			if (i % 3 == 0 && i % 5 == 0 && i % 7 == 0) {
//				System.out.println(i + " three five seven");
//			} else if (i % 3 == 0 && i % 5 == 0) {
//				System.out.println(i + " three five");
//			} else if (i % 3 == 0 && i % 7 == 0) {
//				System.out.println(i + " three seven");
//			} else if (i % 5 == 0 && i % 7 == 0) {
//				System.out.println(i + " five seven");
//			} else if (i % 3 == 0) {
//				System.out.println(i + " three");
//			} else if (i % 5 == 0) {
//				System.out.println(i + " five");
//			} else if (i % 7 == 0) {
//				System.out.println(i + " seven");
//			} else {
//				System.out.println(i);
//			}

			String result = i + "";
			if (i % 3 == 0) {
				result += " three";
			} else if (i % 5 == 0) {
				result += " five";
			} else if (i % 7 == 0) {
				result += " seven";
			}
			System.out.println(result);
		}

	}

}
