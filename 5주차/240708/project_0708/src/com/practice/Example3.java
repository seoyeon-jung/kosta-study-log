package com.practice;

public class Example3 {

	public static void main(String[] args) {
		// 영문자(대문자 또는 소문자)일 때만, 변수 b의 값이 true가 되도록 하는 프로그램
		char ch = 'z';
		boolean b = (ch >= 'A' && ch <= 'Z' || (ch >= 'a' && ch <= 'z'));
		System.out.println(b); // true
	}

}
