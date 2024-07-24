package com.stream7;

import java.util.stream.IntStream;

public class StreamFilerExample2 {

	public static void main(String[] args) {
		// 1부터 1000까지 숫자 생성
		// IntStream numbers = IntStream.rangeClosed(1, 1000);

		// 스트림으로 소수만 포함하는 새로운 리스트로 반환
		// boxed : IntStream 같이 원시타입에 대한 스트림 지원을 클래스 타입으로 전환해준다
		// IntStream -> Stream<Integer>
		// List<Integer> primeNumbers = numbers.filter((n) ->
		// isPrime(n)).boxed().collect(Collectors.toList());

		IntStream.rangeClosed(1, 1000).filter(x -> isPrime(x)).forEach(i -> System.out.println(i + ", "));

		// 필터링된 새로운 리스트를 출력
		// System.out.println(primeNumbers);
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
