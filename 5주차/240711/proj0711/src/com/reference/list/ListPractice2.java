package com.reference.list;

import java.util.Scanner;

public class ListPractice2 {

	public static void main(String[] args) {
		// 5개의 점수를 입력받아, 합계와 평균을 반환하는 코드

		Scanner sc = new Scanner(System.in);
		int[] score = new int[5];

		for (int i = 0; i < score.length; i++) {
			System.out.println((i + 1) + "번째 점수를 입력하세요.");
			score[i] = Integer.parseInt(sc.next());
		}

		int sum = 0;

		for (int i = 0; i < score.length; i++) {
			sum += score[i];
		}

		double avg = (double) sum / score.length;

		System.out.println("합계: " + sum + ", 평균: " + avg);

		sc.close();

	}

}
