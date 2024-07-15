package com.oop.static_member;

public class SmartPhone {
	static String company = "Apple";
	static String model = "iPhone16";
	static String info;
	static {
		System.out.println("정적 블록을 실행합니다.");
		info = company + "-" + model;
	}
}
