package com.oop.basic;

public class OopExample2 {

	public static void main(String[] args) {
		Car myCar = new Car("소나타");

		// myCar.model => 소나타
		// myCar.gas => 0
		// myCar.speed => 0

		// myCar.gas = 100; => gas 변경
		// setSpeed()로 speed 변경 가능함
		myCar.run();

	}

}
