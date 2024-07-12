package com.oop.basic.ch02;

public class CarExmaple {

	public static void main(String[] args) {
		Car myCar = new Car();

		System.out.println("내 자동자 모델은? " + myCar.model);
		System.out.println("내 자동차는 지금 시동이 걸려있나? " + myCar.start);
		System.out.println("내 자동차의 속도는? " + myCar.speed + "km/h");
		System.out.println("내 자동차 휠의 브랜드는? " + myCar.tire.brand);
		System.out.println(myCar);

		myCar.start = false;
		myCar.speed = 200;
		System.out.println("내 자동차는 지금 시동이 걸려있나? " + myCar.start);
		System.out.println("내 자동차의 속도는? " + myCar.speed + "km/h");

		System.out.println();

		Car fatherCar = new Car();

		fatherCar.model = "포르쉐 911";
		System.out.println("내 자동자 모델은? " + fatherCar.model);
		System.out.println("내 자동차는 지금 시동이 걸려있나? " + fatherCar.start);
		System.out.println("내 자동차의 속도는? " + fatherCar.speed + "km/h");
		System.out.println("내 자동차 휠의 브랜드는? " + fatherCar.tire.brand);
		System.out.println(fatherCar);

		System.out.println(fatherCar == myCar); // false (메모리 주소가 다름)

	}

}
