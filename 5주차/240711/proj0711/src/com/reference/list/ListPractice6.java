package com.reference.list;

//import java.util.Random;

public class ListPractice6 {

	public static void main(String[] args) {
		// 선언된 배열에 1~10까지의 랜덤한 숫자(중복 허용)을 넣은 뒤
		// 해당 배열에 어떤 값이 세팅되어있는지 출력하고 배열 데이터의 합과 평균을 구하는 프로그램
		int[] arr = new int[5];
		int sum = 0; // 배열 값의 합

		// 1 ~10 random 숫자 생성
//		Random random = new Random();
//		for (int i = 0; i < arr.length; i++) {
//			arr[i] = random.nextInt(10);
//		}

		for (int i = 0; i < arr.length; i++) {
			// 다른 방법으로 random 숫자 생성
			arr[i] = (int) (Math.random() * 10) + 1;

			// 배열의 값 출력
			System.out.print(arr[i] + " ");

			// 합 구하기
			sum += arr[i];

		}

		System.out.println();

		double avg = (double) sum / arr.length;

		System.out.println("데이터의 합: " + sum + ", 평균: " + avg);
	}

}
