package com.oop.basic.ch03;

public class CarExmaple {

	public static void main(String[] args) {
		Car myCar = new Car("페라리", 200, true);

		System.out.println("내 자동자 모델은? " + myCar.model);
		System.out.println("내 자동차는 지금 시동이 걸려있나? " + myCar.start);
		System.out.println("내 자동차의 속도는? " + myCar.speed + "km/h");
		System.out.println("내 자동차 휠의 브랜드는? " + myCar.tire.brand);
		System.out.println(myCar);

	}

}
