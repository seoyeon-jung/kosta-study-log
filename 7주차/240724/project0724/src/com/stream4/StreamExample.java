package com.stream4;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {

	public static void main(String[] args) {
		String[] strArr = { "맥북", "아이폰", "에어팟" };
		// 배열로부터 스트림 얻는 두 가지 방법
		Stream<String> strStream1 = Stream.of(strArr);
		Stream<String> strStream2 = Arrays.stream(strArr);

		strStream1.forEach(i -> System.out.print(i + ", "));
		System.out.println();
		strStream2.forEach(i -> System.out.print(i + ", "));

		System.out.println("\n");

		int[] intArr = { 3, 1, 4, 1, 5, 9, 2 };
		// 배열로부터 스트림 얻는 두 가지 방법
		IntStream intStream1 = IntStream.of(intArr);
		IntStream intStream2 = Arrays.stream(intArr);

		intStream1.forEach(i -> System.out.print(i + ", "));
		System.out.println();
		intStream2.forEach(i -> System.out.print(i + ", "));
	}

}
