package com.exception;

public class ExceptionExample3 {

	public static void main(String[] args) {
		String[] classArr = { "java.lang.String", null };
		try {
			for (String s : classArr) {
				Class.forName(s);
				System.out.println(s + "이 존재합니다.");
			}
		} catch (ClassNotFoundException e) {
			System.out.println("클래스를 찾을 수 없습니다.");
		} catch (NullPointerException e) {
			System.out.println("값이 null입니다.");
		}

		System.out.println("프로그램을 종료합니다.");
	}

}
