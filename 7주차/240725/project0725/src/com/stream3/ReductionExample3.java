package com.stream3;

import java.util.Arrays;

public class ReductionExample3 {

	public static void main(String[] args) {
		int[] intArr = { 1, 2, 3, 4 };

		int result = Arrays.stream(intArr).reduce((a, b) -> a * b).getAsInt();

		// 초기값 설정 가능
		// 초기값을 설정하면 초기값이 int이므로 getAsInt()를 추가하지 않아도 된다.
		int result2 = Arrays.stream(intArr).reduce(100, (a, b) -> a * b);

		System.out.println("요소의 곱 : " + result);
		System.out.println("요소의 곱 : " + result2);

		System.out.println();

		// 초기값에서 계속 각 요소들을 곱하는 것
		int result3 = Arrays.stream(intArr).reduce(100, (a, b) -> {
			System.out.println(a); // 누적값
			System.out.println(b); // 각 요소
			return a * b;
		});
		System.out.println("요소의 곱 : " + result3);

	}

}
