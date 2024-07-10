package com.statement.practice;

public class Practice4 {

	public static void main(String[] args) {
		// 세 개의 주사위를 던졌을 때, 눈의 곱이 3의 배수인 값을 출력하는 프로그램

		for (int dice1 = 1; dice1 <= 6; dice1++) {
			for (int dice2 = 1; dice2 <= 6; dice2++) {
				for (int dice3 = 1; dice3 <= 6; dice3++) {
					int sum = dice1 * dice2 * dice3;
					if (sum % 3 == 0) {
						System.out.println(dice1 + "*" + dice2 + "*" + dice3 + "=" + sum);
					}
				}
			}
		}

		// 무조건 세 주사위 중 하나는 3의 배수여야 한다.
		// if (dice1 % 3 == 0 || dice2 % 3 == 0 || dice2 % 3 == 0)

	}

}
