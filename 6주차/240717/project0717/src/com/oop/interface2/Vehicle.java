package com.oop.interface2;

// car 클래스에 들어갈 수 있는 기본 동작들
public interface Vehicle {
	// 정적 상수 필드
	int MAX_SPEED = 200;

	// public abstract method
	void start();

	void stop();

	// default method
	// 차의 스피드 출력
	default void displaySpeed(int speed) {
		if (speed > MAX_SPEED) {
			System.out.println("제한 속도 초과");
		} else {
			System.out.println("현재 속도 : " + speed + "km/h");
		}
	}

	default void doorOpen() {
		System.out.println("문이 열렸습니다.");
		log("7월 17일 문이 열림");
	}

	// static method
	static void service() {
		System.out.println("6개월 단위로 서비스 점검을 받으세요.");
	}

	// 문이 열릴 때마다 기록하는 private method
	private void log(String msg) {
		System.out.println("log : " + msg);
	}
}
