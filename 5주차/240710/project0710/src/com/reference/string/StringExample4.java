package com.reference.string;

import java.util.Scanner;

public class StringExample4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("책 제목을 입력하세요: ");
		String title = sc.nextLine();

		sc.close();

		if (title.contains("자바") || title.contains("Java") || title.contains("java")) {
			System.out.println("Java와 관련된 책이군요.");
		} else {
			System.out.println("Java와 관련없는 책이군요.");
		}

	}

}
