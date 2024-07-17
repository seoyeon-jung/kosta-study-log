package com.oop.interface5;

public class Phone implements PhoneService {

	@Override
	public void turnOn() {
		System.out.println("전화기를 켭니다.");

	}

	@Override
	public void turnOff() {
		System.out.println("전화기를 끕니다.");
	}

	@Override
	public void call(String number) {
		System.out.println(number + "에 전화거는 중...");
	}

}
