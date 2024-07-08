package com.practice10;

import java.util.Scanner;

public class MistakeExample2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int apple = 1;
		int totalPiece = apple * 10;

		System.out.print("몇 조각을 드셨나요?: ");
		int number = sc.nextInt();

		double result = (totalPiece - number) / 10.0;
		System.out.println("사과 1개에서 남은 양: " + result);

		sc.close();

	}

}
