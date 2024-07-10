package com.statement.condition;

import java.util.Scanner;

public class IfExample3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("점수 입력: ");
		int score = sc.nextInt();

		sc.close();

		if (score >= 90) {
			System.out.println("90점 이상으로 A등급 합격입니다.");
		} else if (score >= 80) {
			System.out.println("80점 이상으로 B등급 합격입니다.");
		} else if (score >= 70) {
			System.out.println("70점 이상으로 C등급 합격입니다.");
		} else if (score >= 60) {
			System.out.println("60점 이상으로 D등급 합격입니다.");
		} else {
			System.out.println("F등급, 불합격입니다.");
		}

	}

}
