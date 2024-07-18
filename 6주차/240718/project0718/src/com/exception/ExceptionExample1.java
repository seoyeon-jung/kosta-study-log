package com.exception;

public class ExceptionExample1 {

	public static void main(String[] args) {
		System.out.println("프로그램 시작");

		printLength("exception");
		printLength(null);
		printLength("PLEASE SHOW ME");

		System.out.println("프로그램을 종료합니다.");

	}

	private static void printLength(String data) {
		try {
			int len = data.length();
			System.out.println("글자 수 : " + len);
		} catch (NullPointerException e) {
			// 예외 출력 방법 3가지
			// 1. e.printStackTrace(); : 에러 내용 출력 후 다시 진행
			e.printStackTrace();

			// 2. System.err.println(e.getMessage());
			System.err.println(e.getMessage());
			// Cannot invoke "String.length()" because "data" is null 출력

			// 3. e.toString()
			System.err.println(e.toString());
			// java.lang.NullPointerException: Cannot invoke "String.length()" because
			// "data" is null
		}
	}

}
