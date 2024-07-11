package com.reference.list;

public class ListPractice4 {

	public static void main(String[] args) {
		// 배열의 짝수 번째 정수의 합을 구하는 프로그램
		int[] arr = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };
		int sum = 0;

		for (int i = 1; i < arr.length; i += 2) {
			sum += arr[i];
		}

//		for (int i = 0; i < arr.length; i++) {
//			if (i % 2 == 1) {
//				sum += arr[i];
//			}
//		}

		System.out.println("짝수 번재 정수의 합: " + sum);
	}

}
