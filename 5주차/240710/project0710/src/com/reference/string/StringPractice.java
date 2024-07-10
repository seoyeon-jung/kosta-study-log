package com.reference.string;

import java.util.Scanner;

public class StringPractice {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("입력한 메시지를 한 글자씩 출력합니다.");
		System.out.print("메시지를 입력하세요 : ");
		String msg = sc.nextLine();

		for (int i = 0; i < msg.length(); i++) {
			char var = msg.charAt(i);
			System.err.println(var);
		}

		sc.close();

	}

}
