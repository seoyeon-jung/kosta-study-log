package com.anonymous.inheritance;

public class CarExample {
	public static void main(String[] args) {
		Car c = new Car();
		c.run1();

		System.out.println();

		c.run2();

		System.out.println();

		c.start();

		System.out.println();

		c.curve(new Handle());
		c.curve(new PowerHandle());

		// 메소드의 매개변수 값으로 대입되는 익명 자식 객체
		// 필드 로컬 변수 매개값으로 사용하는 익명 자식 객체
		c.curve(new Handle() {
			@Override
			void turn() {
				System.out.println("익명 핸들을 돌립니다");
			}
		});
	}
}
