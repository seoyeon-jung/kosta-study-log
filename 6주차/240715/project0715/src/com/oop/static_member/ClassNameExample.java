package com.oop.static_member;

public class ClassNameExample {

	public static void main(String[] args) {
		ClassName cn = new ClassName();
		cn.instanceMethod();
		// ClassName.staticField; => 값이 변경되어서 오류가 생긴다.

		ClassName.staticMethod1();

	}

}
