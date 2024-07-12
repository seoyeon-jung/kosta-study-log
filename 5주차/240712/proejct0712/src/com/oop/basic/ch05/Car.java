package com.oop.basic.ch05;

public class Car {
	String model;
	String color;
	int speed;
	boolean start;

	Car() {
		this("그랜저", "블랙", 0, false);
		System.out.println("기본 생성자 호출");
	}

	Car(String model) {
		this(model, "블랙", 0, false);
		System.out.println("모델명 생성자 호출");
		// this.model = model;
	}

	Car(String model, String color) {
		this(model, color, 0, false);
		System.out.println("모델명, 색상명 생성자 호출");
//		this.model = model;
//		this.color = color;
	}

	Car(String model, String color, int speed) {
		this(model, color, speed, false);
		System.out.println("모델명, 색상명, 스피드 생성자 호출");
//		this.model = model;
//		this.color = color;
//		this.speed = speed;
	}

	Car(String model, String color, int speed, boolean start) {
		System.out.println("모델명, 색상명, 스피드, 시동여부 생성자 호출");
		this.model = model;
		this.color = color;
		this.speed = speed;
		this.start = start;
	}

}
