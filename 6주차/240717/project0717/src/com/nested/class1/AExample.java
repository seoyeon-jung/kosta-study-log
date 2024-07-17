package com.nested.class1;

public class AExample {
	public static void main(String[] args) {
		// public B와 default C 사용 가능
		// A.B b = new B();
		// => 중첩 클래스는 인스턴스 필드와 동일하게 동작
		// 외부에서 중첩 클래스를 사용하기 위해서는 바깥 클래스(객체)를 생성한 뒤에 내부 중첩 클래스를 생성해야 한다.
		A a = new A();
		A.B b = a.new B();
	}

}
