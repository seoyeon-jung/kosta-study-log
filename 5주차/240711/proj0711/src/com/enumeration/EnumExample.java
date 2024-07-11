package com.enumeration;

public class EnumExample {
	public static void main(String[] args) {
		// 열거 타입 변수 선언
		Week today;
		// 변수 초기화
		today = Week.THURSDAY;

		// 열거타입 변수에 null 값 부여 가능
		Week holiday = null;

		// 열거 타입 변수 선언 및 초기화
		Week yesterday = Week.WEDNESDAY;
	}
}
