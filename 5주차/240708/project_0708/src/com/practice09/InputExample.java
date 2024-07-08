package com.practice09;

import java.util.Scanner;

public class InputExample {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("x값 입력: ");

		String strX = sc.nextLine();
		int x = Integer.parseInt(strX);

		System.out.print("y값 입력: ");
		String strY = sc.nextLine();
		int y = Integer.parseInt(strY);

		int result = x + y;
		System.out.println("x + y = " + result);

		sc.close();
	}

}
