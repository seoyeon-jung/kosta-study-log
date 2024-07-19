package com.system;

public class MeasureRunTimeExample {

	public static void main(String[] args) {
		// 나노초 단위의 시간 반환 (시스템과 무관 (1/1_000_000_000)
		// 정말히나 시간 측정 (경과 시간)
		System.out.println(System.nanoTime());

		long start = System.nanoTime();

		// 복잡한 연산
		int sum = 0;
		for (int i = 0; i <= 1000000; i++) {
			sum += i;
		}

		long end = System.nanoTime();

		long result = end - start;
		System.out.println(result + "ns 소요");

		// 밀리초 단위의 시간 반환 (1/1000초)
		// 현재 날자와 시간 (시스템 기준)
		// 시간 기록, 로깅
		System.out.println(System.currentTimeMillis());
	}

}
