package com.oop.basic;

public class OopExample1 {

	public static void main(String[] args) {
		// 클래스 만들기
		Korean k1 = new Korean("정서연", "990101-2001234");

		System.out.println(k1.name);
		System.out.println(k1.gender);
		System.out.println(k1.birthYear);
		System.out.println(k1.birthMonth);
		System.out.println(k1.birthDay);

		System.out.println(Korean.nation);
	}

}
