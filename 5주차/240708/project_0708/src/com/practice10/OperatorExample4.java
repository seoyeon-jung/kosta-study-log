package com.practice10;

import java.util.Scanner;

public class OperatorExample4 {

	public static void main(String[] args) {
		System.out.println('A' == 65); // true
		System.out.println(3 == 3.0); // true

		System.out.println(3 == 3.0); // true

		// 실수 타입은 정밀도 차이로 인해 정확한 비교가 안된다.
		// System.out.println(0.1 == 0.1f); // false
		// System.out.println(0.1 < 0.1f); // true
		System.out.println((float) 0.1 == 0.1f); // true

		// 문자열 비교
		// => 비교 연산자 사용이 불가능하다 (참조 타입이기 때문 - 메모리 주소를 비교하기 때문)
		String name1 = "Hello";
		String name2 = "Hell";
		name2 = name2 + "o";

		// System.out.println(name1 == name2); // false
		System.out.println(name1.equals(name2)); // true
		System.out.println(!name1.equals(name2)); // false

		Scanner sc = new Scanner(System.in);
		String target = "Hello";
		System.out.print("비교 대상 문자열 입력: ");
		String input = sc.nextLine();

		// 동일하게 입력해도 첫번째 콘솔에는 false가 찍힌다 (문자열 비교이기 때문)
		System.out.println("target과 input의 연산자 비교: " + (target == input)); // false
		System.out.println("target과 input의 연산자 비교: " + (target.equals(input))); // true

		sc.close();
	}

}
