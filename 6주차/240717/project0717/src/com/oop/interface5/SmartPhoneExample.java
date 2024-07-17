package com.oop.interface5;

public class SmartPhoneExample {

	public static void main(String[] args) {
		// Phone 은 PhoneService 직접적으로 구현하고 있기 때문에 자동 형 변환이 가능
		PhoneService ps1 = new Phone();

		// SmartPhone 은 Phone 을 상속받아 PhoneService 간접적으로 구현하고 있기 대문에 자동 형 변환이 가능
		PhoneService ps2 = new SmartPhone();

		// PhoneService => SmartService 기능이 없다
		// 따라서 SmartSerivice 메소드릃 호출하고 싶다면 강제 타입 변환이 필요하다
		// SmartService ss1 = (PhoneService) ps1;
		// 강제 타입 변환을 SmartPhone 으로 해줘야 한다
		// SmartPhone sp1 = (SmartPhone) ps1; // 애초에 phone 이기 때문에 바꿀 수 없음
		SmartPhone sp2 = (SmartPhone) ps2;

		// SmartService ss1 = (SmartService) sp1;
		SmartService ss2 = (SmartService) sp2;

	}

}
