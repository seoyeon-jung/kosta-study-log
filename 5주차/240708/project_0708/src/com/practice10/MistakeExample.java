package com.practice10;

import java.util.Scanner;

public class MistakeExample {

	public static void main(String[] args) {
		// 산술 연산을 정확하게 하려면 실수 타입을 사용하지 않는 것이 좋다
		Scanner sc = new Scanner(System.in);

		int apple = 1;
		// double pieceUnit = 0.1;
		int totalPiece = apple * 10;

		// 10진수 1 -> 2진수 1
		// 10진수 0.75 -> 2진수 0.11
		// 10진수 0.5 -> 2진수 0.1
		// 10진수 0.25 -> 2진수 0.01
		// 10진수 0.125 -> 2진수 0.001
		// 10진수 0.0625 -> 2진수 0.0001

		// 2진수는 0과 1만 존재하기 때문에 2가 나올 수가 없다
		// 소수점도 마찬가지로 0과 1만 존재한다.
		// => 소수점은 우리가 표현할 수 있는 자리수를 넘는 순간 정확한 연산이 불가능하다.

		System.out.print("몇 조각을 드셨나요?: ");
		int number = sc.nextInt();

		// double result = apple - number * pieceUnit;
		double result = (totalPiece - number) / 10.0;
		System.out.println("사과 1개에서 남은 양: " + result);

		/*
		 * 실수 타입을 사용하니까 7을 입력받으면 사과 1개에서 남은 양: 0.29999999999999993 이런 식으로 출력된다 실수 타입을
		 * 사용하지 않는 것이 좋다.
		 */

		sc.close();

	}

}
