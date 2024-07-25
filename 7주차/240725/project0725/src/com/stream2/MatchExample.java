package com.stream2;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MatchExample {

	public static void main(String[] args) {
		int[] intArr1 = { 2, 4, 6, 8, 10 };
		int[] intArr2 = { 2, 3, 4, 6, 8 };

		// 모두 2의 배수이면 true를 반환
		boolean allEvenResult1 = Arrays.stream(intArr1).allMatch(i -> i % 2 == 0);
		boolean allEvenResult2 = IntStream.of(intArr2).allMatch(i -> i % 2 == 0);

		System.out.println("1번 배열이 모두 짝수인가? " + allEvenResult1); // true
		System.out.println("2번 배열이 모두 짝수인가? " + allEvenResult2); // false

		// 하나라도 2의 배수가 있으면 true를 반환
		boolean anyOddResult1 = Arrays.stream(intArr1).anyMatch(i -> i % 2 != 0);
		boolean anyOddResult2 = IntStream.of(intArr2).anyMatch(i -> i % 2 != 0);

		System.out.println("1번 배열 중 하나라도 홀수가 있는가? " + anyOddResult1); // false
		System.out.println("2번 배열 중 하나라도 홀수가 있는가? " + anyOddResult2); // true

		// 10의 배수가 없으면 true를 반환
		boolean notInTenTimes1 = Arrays.stream(intArr1).noneMatch(i -> i % 10 == 0);
		boolean notInTenTimes2 = IntStream.of(intArr2).noneMatch(i -> i % 10 == 0);

		System.out.println("1번 배열 중에는 10의 배수가 없는가? " + notInTenTimes1); // false
		System.out.println("2번 배열 중에는 10의 배수가 없는가? " + notInTenTimes2); // true

	}

}
