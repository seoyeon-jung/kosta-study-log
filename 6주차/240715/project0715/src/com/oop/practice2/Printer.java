package com.oop.practice2;

public class Printer {
	// 매소드 오버로딩 -> 변수 타입이 다르기 때문

	// 변수가 공통되면 필드에서 접근하는 방법도 있음 (변경되지 않도록 상수화)
	private static final String MSG = "나와라 ";

	public static void println(int p) {
		System.out.println(MSG + p);
	}

	public static void println(boolean p) {
		System.out.println(MSG + p);
	}

	public static void println(double p) {
		System.out.println(MSG + p);
	}

	public static void println(String p) {
		System.out.println(MSG + p);
	}
}
