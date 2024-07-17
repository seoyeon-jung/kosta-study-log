package com.nested.class1;

public class A {
	// 인스턴스 필드
	int number = 1;

	// 중첩 클래스를 인스턴스 용도로 사용
	B b = new B();
	C c = new C();
	D d = new D();

	// 정적 필드
	static int totalNumber;

	// 기본 생성자 (클래스이면 기본으로 들어있음)
	A() {
		// 중첩 클래스를 생성자 내부에서 사용
		this.b = new B();
		this.c = new C();
		this.d = new D();
	}

	// 인스턴스 메소드
	void hello() {

		// 중첩 클래스를 메소드 내부에서 사용 (로컬 클래스)
		B b = new B();
		C c = new C();
		D d = new D();

		System.out.println("Hello");
	}

	// 정적 메소드
	static void staticHello() {
		System.out.println("static Hello");

	}

	// 중첩 클래스 (인스턴스 필드와 동일하게 동작)
	public class B {
		// 다른 패키지에서도 사용 가능
		// 필드, 생성자, 메소드
		// 원래는 정적 필드와 정적 메소드는 올 수 없다
		// 그러나 java 17부터 정적 필드와 정적 메소드의 선언도 가능하다.
	}

	class C {
		// 같은 패키지에서만 사용 가능
	}

	private class D {
		// A 클래스 내부에서만 사용 가능
	}
}
