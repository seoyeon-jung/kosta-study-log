package com.oop.access;

public class Car {
	String name;
	private int speed;
	final int MAX_SPEED = 200;

	// 숨겨져 있는 기본 생성자 (없어도 존재한다)
//	Car() {
//		this.name = null;
//		this.speed = 0;
//	}

	Car(String name) {
		this.name = name;
	}

	// setter 메소드
	// speed 의 조건을 지키는 유효한 값만 저장할 수 있도록 만드는 메소드
	public void setSpeed(int speed) {
		this.speed = speed >= 0 && MAX_SPEED >= speed ? speed : 0;
	}

	// getter 메소드
	public int getSpeed() {
		return speed;
	}

	void Info() {
		System.out.println(name + "의 현재 속도: " + speed + "km/h");
	}
}
