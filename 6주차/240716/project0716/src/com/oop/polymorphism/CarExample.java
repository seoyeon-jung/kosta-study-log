package com.oop.polymorphism;

public class CarExample {

	public static void main(String[] args) {
		Car c = new Car();
		// 굴러갑니다
		c.settire(new Tire());
		c.drive();

		System.out.println();

		// 대한민국 타이어의 자존심!!
		// 금호타이어가 굴러갑니다.
		c.settire(new HankookTire());
		c.drive();

		System.out.println();

		// 금호타이어가 굴러갑니다
		c.settire(new KumhoTire());
		c.drive();

	}

}
