package com.practice09;

import java.util.Scanner;

public class AverageExample {

	public static void main(String[] args) {
		int sum = 0;
		double avg = 0;

		// 세 명의 수학 점수 입력
		Scanner sc = new Scanner(System.in);

		System.out.print("1번 수학점수: ");
//		String math1 = sc.nextLine();
//		int num1 = Integer.parseInt(math1);
		int math1 = sc.nextInt(); // int로 자동 변환된다

		System.out.print("2번 수학점수: ");
//		String math2 = sc.nextLine();
//		int num2 = Integer.parseInt(math2);
		int math2 = sc.nextInt();

		System.out.print("3번 수학점수: ");
//		String math3 = sc.nextLine();
//		int num3 = Integer.parseInt(math3);
		int math3 = sc.nextInt();

		sum = math1 + math2 + math3;
		avg = sum / 3.0;

		// 총 합게 출력
		System.out.println("총 합계: " + sum);
		System.out.println("평균: " + avg);

		sc.close();
	}

}
