package com.stream9;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MappingExample {

	public static void main(String[] args) {
		// 1부터 1000까지 숫자 생성
		// 스트림으로 소수만 포함하는 새로운 리스트로 반환
		List<Integer> primeList = IntStream.rangeClosed(1, 1000).filter(x -> isPrime(x)).boxed()
				.collect(Collectors.toList());
		System.out.println(primeList);

		System.out.println();

		// 1부터 5까지 IntStream 생성, double 타입으로 반환하고 출력하기
		IntStream.range(1, 6).asDoubleStream().forEach(v -> System.out.println(v));

		System.out.println();

		// 1부터 5까지 IntStream 생성, double 타입의 리스트로 변환하고 출력하기
		IntStream.range(1, 6).asDoubleStream().boxed().collect(Collectors.toList());

	}

	// 소수임을 판단
	public static boolean isPrime(int num) {
		if (num <= 1) {
			return false;
		}

		// sprt() : 제곱근
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

}
