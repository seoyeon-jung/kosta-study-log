package com.oop.inheritance;

public class Child extends Parent {
	String job = "개발자";

	void Hello() {
		System.out.println("안녕하세요");
	}

	// override
	void walk() {
		System.out.println("뚜벅뚜벅");
	}
}
