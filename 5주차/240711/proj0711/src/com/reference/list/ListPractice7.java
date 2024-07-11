package com.reference.list;

import java.util.Scanner;

public class ListPractice7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		double[] arr = new double[num];
		double sum = 0;

		// 요소 수 받기
		System.out.print("요소 수: " + num);

		for (int i = 0; i < arr.length; i++) {
			// 배열 내역 입력 입력받기
			double arr_num = sc.nextDouble();

			// 배열 내역 출력
			System.out.print("doubleArr[" + i + "] = " + arr_num);

			// 모든 요소의 합
			sum += arr_num;
		}

		// 모든 요소의 합 출력
		System.out.println("모든 요소의 합은 " + sum + "입니다.");

		// 모든 요소의 평균
		double avg = sum / arr.length;
		System.out.println("모든 요소의 평균은 " + avg + "입니다.");

		sc.close();
	}

}
