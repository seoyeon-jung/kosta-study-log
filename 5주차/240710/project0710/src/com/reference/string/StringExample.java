package com.reference.string;

public class StringExample {

	public static void main(String[] args) {
		String subject = "자바 프로그래밍";
		char var = subject.charAt(3);
		int len = subject.length();

		System.out.println(var); // 프
		System.out.println(len); // 8

		for (int i = 0; i < subject.length(); i++) {
			System.out.println(subject.charAt(i));
		}

	}

}
