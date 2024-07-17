package com.oop.interface3;

public class SmartPhoneExample {
	public static void main(String[] args) {
		PhoneService ps = new SmartPhone(); // smart phone 으로 이루어짐
		ps.turnOn();
		ps.call("112");
		ps.turnOff();

		System.out.println();

		// openAll()을 사용하기 위해 SmartService 가지고 있는지 확인
		SmartService ps_ss = (SmartService) ps;
		ps_ss.openAll("instagram");

		System.out.println();

		SmartService ss = new SmartPhone();
		// ss.turnOn();
		// ss.call("112");
		// ss.turnOff();
		ss.openAll("카카오톡");

		System.out.println();

		SmartPhone sp = new SmartPhone();
		sp.turnOn();
		sp.call("112");
		sp.openAll("유투브");
		sp.turnOff();
	}
}
