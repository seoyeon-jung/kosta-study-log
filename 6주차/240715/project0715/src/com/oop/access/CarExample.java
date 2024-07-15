package com.oop.access;

public class CarExample {

	public static void main(String[] args) {
		Car myCar = new Car("Jack");
		myCar.Info(); // Jack 의 현재 속도: 0km/h

		myCar.setSpeed(50);
		myCar.Info(); // Jack 의 현재 속도: 50km/h

//		myCar.setSpeed(-50);
//		myCar.Info(); // Jack 의 현재 속도: 0km/h
//
//		myCar.setSpeed(5000);
//		myCar.Info(); // Jack 의 현재 속도: 0km/h

		System.out.println(5 * myCar.getSpeed());

	}

}
