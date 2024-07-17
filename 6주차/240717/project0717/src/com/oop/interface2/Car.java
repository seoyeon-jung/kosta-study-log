package com.oop.interface2;

public class Car implements Vehicle {
	// car 의 동작을 인터페이스 Vehicle 에서 가져오기

	private int speed;

	@Override
	public void start() {
		System.out.println("출발합니다.");
		speed = 10;

	}

	@Override
	public void stop() {
		System.out.println("멈춥니다.");
		speed = 0;

	}

	// 자동차만의 기능 추가 (Vehicle 에는 없음)
	public void accelerate(int increment) {
		speed += increment;
		displaySpeed(speed);
	}

}
