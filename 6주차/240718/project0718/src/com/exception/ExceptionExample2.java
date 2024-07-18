package com.exception;

public class ExceptionExample2 {

	public static void main(String[] args) {
		String classname1 = "java.lang.String";
		try {
			Class.forName(classname1);
			System.out.println(classname1 + "이 존재합니다.");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// Unhandled exception type ClassNotFoundException (error 발생)

		System.out.println();

		String classname2 = "java.lang.String2";
		try {
			Class.forName(classname2);
			System.out.println(classname2 + "이 존재합니다.");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// try-catch로 했는데 className2가 ClassNotFoundException 오류 발생
	}

}
