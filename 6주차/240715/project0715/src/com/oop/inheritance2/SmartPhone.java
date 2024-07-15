package com.oop.inheritance2;

public class SmartPhone extends Phone {
	public boolean wifi;

	// phone 에 model, color 가 존재하기 때문에 사용 가능
	public SmartPhone(String model, String color) {
		// 부모에게 맡김
		super(model, color);

		// Phone 기본 생성자 존재
		// => Phone 파일의 기본 생성자 안의 문구가 함께 출력된다.
		System.out.println("스마트폰 생성자");
//		this.model = model;
//		this.color = color;

	} // => 생략 불가능

	public void setWifi(boolean wifi) {
		if (wifi) {
			System.out.println("와이파이를 켭니다.");
		} else {
			System.out.println("와이파이를 끕니다.");
		}
		this.wifi = wifi;
	}

	public void internet() {
		System.out.println("인터넷에 연결합니다.");
	}
}
