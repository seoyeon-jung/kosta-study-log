package com.statement.practice;

public class Practice3 {

	public static void main(String[] args) {
		// 두 개의 주사위를 던졌을 때, 눈의 합이 6이 되는 모든 경우의 수 출력하는 프로그램

		for (int dice1 = 1; dice1 <= 6; dice1++) {
			for (int dice2 = 1; dice2 <= 6; dice2++) {
				if (dice1 + dice2 == 6) {
					System.out.println(dice1 + "+" + dice2 + "=" + (dice1 + dice2));
					break; // 숫자 하나가 6일 때는 확인 안해도 되니까 훨씬 더 효율적이게 된다.
				}
			}
		}

	}

}
