package com.oop.basic;

public class Car {
	String model;
	int gas, speed;

	Car(String model) {
		this.model = model;
	}

	void setSpeed(int speed) {
		this.speed = speed;
	}

	void run() {
		setSpeed(100); // this 생략 가능
		System.out.println(model + "이/가 달립니다. (시속: " + speed + "km/h)");
	}
}
