package com.statement.condition;

import java.util.Scanner;

public class SwtichExample3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("등급을 입력하세요: ");
		char grade = sc.nextLine().charAt(0);

		sc.close();

		switch (grade) {
		case 'A', 'a' -> {
			System.out.println("훌륭합니다!");
		}
		case 'B', 'b' -> {
			System.out.println("좋습니다!");
		}
		case 'C', 'c' -> {
			System.out.println("나쁘지 않습니다!");
		}
		case 'D', 'd' -> {
			System.out.println("조금 아쉽습니다!");
		}
		case 'E', 'e' -> {
			System.out.println("나쁩니다!");
		}
		case 'F', 'f' -> {
			System.out.println("실패했습니다");
		}
		default -> {
			System.out.println("잘못된 등급입니다.");
		}
		}
	}

}
