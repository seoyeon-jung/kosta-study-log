package com.stream3;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class ReductionExample2 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();

		// 리스트 안의 요소의 타입을 변경시켜준다 (Integer -> int)
		OptionalDouble optavg = list.stream().mapToInt(Integer::intValue).average();

		// isPresent() -> 평균 1) : 0.0
		if (optavg.isPresent()) {
			System.out.println("평균 1: " + optavg);
		} else {
			System.out.println("평균 1 : " + 0.0);
		}

		// orElse() -> 평균 2) : 0.0
		System.out.println("평균 2 : " + optavg.orElse(0.0));

		// ifPresent() -> 평균 3)
		optavg.ifPresent(a -> System.out.println("평균 3"));

	}

}
