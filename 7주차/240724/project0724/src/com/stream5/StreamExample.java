package com.stream5;

import java.util.stream.IntStream;

public class StreamExample {

	public static void main(String[] args) {

		// 특정 범위의 정수 스트림을 만들기
		int sum1 = IntStream.range(1, 10).sum(); // 1 이상 10 미만
		System.out.println(sum1 + "\n"); // 45

		int sum2 = IntStream.rangeClosed(1, 10).sum(); // 1 이상 10 이하
		System.out.println(sum2); // 55

	}

}
