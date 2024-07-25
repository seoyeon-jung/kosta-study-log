package com.stream3;

import java.util.Arrays;
import java.util.OptionalDouble;

public class ReductionExample {

	public static void main(String[] args) {
		int[] intArr = {};

		OptionalDouble optAvg = Arrays.stream(intArr).average();

		// 집계값이 없는 경우 대비하는 방법 1
		// isPresent() 메소드를 통해 조건문을 만들고, true를 반환할 때만 집계값을 얻는다
		if (optAvg.isPresent()) {
			System.out.println("평균 : " + optAvg.getAsDouble());
		} else {
			System.out.println("평균 : " + 0.0);
		}

		// 집계값이 없는 경우 대비하는 방법 2
		// orElse() 메소드를 통해 집계값이 없는 경우의 디폴트 값을 정해 놓는다.
		double avg = Arrays.stream(intArr).average().orElse(10.0);
		System.out.println("평균 : " + avg);

		// 집계값이 없는 경우 대비하는 방법 3
		// ifPresent() 메소드를 통해 집계값이 있는 경우에만 동작하는 Consumer 람다식을 사용
		// 집계값이 없으면 아예 찍히지 않는다.
		Arrays.stream(intArr).average().ifPresent(a -> System.out.println("평균 : " + a));
	}

}
