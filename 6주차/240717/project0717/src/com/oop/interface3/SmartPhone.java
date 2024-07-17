package com.oop.interface3;

public class SmartPhone implements PhoneService, SmartService {

	@Override
	public void openAll(String appName) {
		System.out.println(appName + "을 열었습니다.");

	}

	@Override
	public void turnOn() {
		System.out.println("스마트폰을 켭니다.");

	}

	@Override
	public void turnOff() {
		System.out.println("스마트폰을 끕니다");

	}

	@Override
	public void call(String number) {
		System.out.println(number + "에 전화 거는 중...");

	}

}
