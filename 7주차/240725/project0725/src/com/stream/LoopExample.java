package com.stream;

import java.util.Arrays;

public class LoopExample {

	public static void main(String[] args) {
		int[] intArr = { 1, 2, 3, 4, 5 };
		int total = Arrays.stream(intArr).filter(i -> i % 2 == 0).peek(System.out::println).sum();
		System.out.println("총합 : " + total + "\n");

		Arrays.stream(intArr).filter(i -> i % 2 != 0).forEach(System.out::println);

	}

}
