package com.statement.loop;

import java.util.Scanner;

public class WhileExample2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// boolean run = true; // while 문 빠져나가기 위한 코드
		int speed = 0;

		while (true) {
			System.out.println("---".repeat(8));
			System.out.println("1. 종속 | 2. 감속 | 3. 중지");
			System.out.println("---".repeat(8));
			System.out.print("선택 : ");
			int num = sc.nextInt();

			if (num == 1) {
				speed++;
				System.out.println("현재 속도 = " + speed);
			} else if (num == 2) {
				speed--;
				System.out.println("현재 속도 = " + speed);
			} else if (num == 3) {
				// run = false;
				break;
			}

//			switch (num) {
//			case 1 -> System.out.println("현재 속도 = " + ++speed);
//			case 2 -> System.out.println("현재 속도 = " + --speed);
//			case 3 -> run = false;
//
//			}
		}

		System.out.println("프로그램 종료");

		sc.close();

	}

}
