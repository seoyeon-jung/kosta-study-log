package com.statement.loop;

public class BreakExample {

	public static void main(String[] args) {
		System.out.println("주사위가 6이 나오면 프로그램을 종료합니다.");

		while (true) {
			System.out.println("주사위를 굴립니다.");
			int num = (int) (Math.random() * 6) + 1;
			System.out.println(num);

			if (num == 6) {
				System.out.println("6이 나왔습니다.");
				break;
			}
		}

		System.out.println("프로그램 종료");

	}

}
