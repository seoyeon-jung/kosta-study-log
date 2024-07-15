package com.oop.inheritance2;

public class Phone {
	public String model, color;

	public Phone() {
		System.out.println("Phone 기본 생성자");
	}

	// 오버 로딩 (동일한테 괄호 안 매개변수만 다른 경우)
	public Phone(String model, String color) {
		System.out.println("Phone 생성자(모델, 색상)");
		this.model = model;
		this.color = color;
	}

	public void bell() {
		System.out.println("벨이 울립니다.");
	}

	public void sendVoice(String message) {
		System.out.println("본인: " + message);
	}

	public void receiveVoice(String message) {
		System.out.println("상대방: " + message);
	}

	public void hangUp() {
		System.out.println("전화를 끊습니다.");
	}
}
