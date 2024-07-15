package com.oop.static_member;

public class StaticExample {
	// 인스턴스 생성 가능
	String instanceField = "Hello";

	void instanceMethod() {
		System.out.println("인스턴스 메소드를 호출합니다.");
		System.out.println("인스턴스 필드: " + instanceField);
	}

	public static void main(String[] args) {
		// static method 안에서는 instance 메소드 사용 불가능
		// instanceMethod();
		// Cannot make a static reference to the non-static field instanceField
		// System.out.println(instanceField);

		// 굳이 이용하고 싶다면 생성자 만들기
		StaticExample se = new StaticExample();
		System.out.println(se.instanceField);
		se.instanceMethod();
	}
}
