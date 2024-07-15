package com.oop.inheritance2;

public class SmartPhoneExample {

	public static void main(String[] args) {
		SmartPhone sp = new SmartPhone("아이폰", "스카이블루");
		System.out.println("와이파이 상태: " + sp.wifi); // false

		sp.bell();
		sp.sendVoice("여보세요");
		sp.receiveVoice("야! 나 00인데 메일 좀 봐봐");
		sp.sendVoice("응");
		sp.hangUp();

		// 와이파이 켜야 한다
		sp.setWifi(!sp.wifi); // 와이파이를 켭니다.
		sp.internet(); // 인터넷에 연결합니다.

	}

}
