package com.practice10;

import java.util.Scanner;

public class OperatorExample6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("점수를 입력해주세요: ");
		int score = sc.nextInt();

		char grade = (score > 90) ? 'A' : (score > 80) ? 'B' : (score > 70) ? 'C' : (score > 60) ? 'D' : 'F';

		System.out.println(score + "점은 " + grade + "등급입니다.");

		sc.close();

	}

}
