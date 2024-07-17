package com.oop.interface2;

public class CarExample {

	public static void main(String[] args) {
		// car 생성
		Vehicle car = new Car();
		car.doorOpen();
		System.out.println();

		car.start();
		System.out.println();

		Car c = (Car) car; // 강제 형변환 (Vehicle 이므로 car accelerate 없기 때문)
		c.accelerate(60); // 현재 속도 : 70km/h
		System.out.println();
		c.accelerate(140); // 제한 속도 초과
		System.out.println();
		car.stop();

		// 정적 메소드니까 클래스 이름으로
		Vehicle.service();

	}

}
