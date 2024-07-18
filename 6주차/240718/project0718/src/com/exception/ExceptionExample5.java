package com.exception;

public class ExceptionExample5 {

	public static void main(String[] args) {
		try {
			findClass();
		} catch (ClassNotFoundException e) {
			System.out.println("해당 클래스를 찾을 수 없습니다.");
		} catch (NullPointerException e) {
			System.out.println("입력값이 null입니다.");
		}

	}

	private static void findClass() throws ClassNotFoundException, NullPointerException {
		String className = null;
		Class.forName(className.substring(1));
	}

}
