package com.anonymous.implement;

// 인터페이스가 동작되는 구현 클래스
public class Television implements RemoteControl {

	@Override
	public void turnOn() {
		System.out.println("텔레비전을 켭니다.");

	}

	@Override
	public void turnOff() {
		System.out.println("텔레비전을 끕니다.");

	}

}
