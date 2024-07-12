package com.oop.basic.ch03;

public class Car {
	String model = "람보르기니";
	// String model; => null 출력
	int speed;
	boolean start;
	Tire tire = new Tire();

	// 기본 생성자
	// Car() {}

	// 개발자가 선언한 생성자
	Car(String m, int sp, boolean st) {
		model = m;
		speed = sp;
		start = st;
	}
}
