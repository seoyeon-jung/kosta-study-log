package com.oop.interface6;

public class CarExample {

	public static void main(String[] args) {
		Car mycar = new Car();

		mycar.run();

		System.out.println();

		mycar.frontTire = new KumhoTire(); // forntTire 금호 타이어로 변경
		mycar.run();

	}

}
